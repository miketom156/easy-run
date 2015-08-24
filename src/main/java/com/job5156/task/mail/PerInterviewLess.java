package com.job5156.task.mail;

import java.io.IOException;
import java.io.StringWriter;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.joda.time.DateTime;
import org.joda.time.Hours;

import com.dmdelivery.webservice.RecipientNameValuePairType;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.job5156.beans.freemarker.FreemarkerConfigure;
import com.job5156.beans.mail.BaseMailSend;
import com.job5156.beans.mail.EmailSender;
import com.job5156.common.CommonEnum.MailCount;
import com.job5156.common.CommonEnum.MailServer;
import com.job5156.common.Constants;
import com.job5156.common.api.SendEmailByWebpowerApi;
import com.job5156.common.exception.EmailServerConfigException;
import com.job5156.common.util.HibernateActionSlaveUtil;
import com.job5156.common.util.HibernateActionUtil;
import com.job5156.common.util.HibernateSalveBaseUtil;
import com.job5156.model.per.PerUser;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * 针对用户收到的面试邀请很少的情况
 * 业务规则：当用户连续两天收到的面试邀总量少于5份时，第二天自动发送邮件提醒
 *
 * @author leeton
 *
 */
@SuppressWarnings("deprecation")
public class PerInterviewLess extends BaseMailSend{
    private static Logger logger = Logger.getLogger(PerInterviewLess.class);

    private Gson gson;
    private EmailSender sender;
    private static int sendLimitNum = 150000; //每天最多发送的数量
    private int pageSize = 1000;


    public PerInterviewLess() throws EmailServerConfigException {
        gson = new Gson();
        sender = new EmailSender(MailServer.MAIN);
        this.setSendTestMailPerNum(10000);
    }

    public PerInterviewLess(MailServer mailServer) throws EmailServerConfigException {
        gson = new Gson();
        sender = new EmailSender(mailServer);
        this.setSendTestMailPerNum(10000);
    }

    public static void main(String[] args) {
        try {

            PerInterviewLess recommend = new PerInterviewLess();
            recommend.setTestMailAddr("yf_198407@163.com", "jmail168@163.com","dghxc@job5156.com","381436695@qq.com");
            setSendLimitNum(50000);
            recommend.send();

            HibernateSalveBaseUtil.closeSession();
            HibernateActionSlaveUtil.closeSession();
        } catch (EmailServerConfigException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void send() {
        this.sendMailByIntervalDays(DateTime.now().toDate(), -2,Constants.MAIL_TASK_PER_INTERVIEW_LESS);
        HibernateSalveBaseUtil.closeSession();
        HibernateActionSlaveUtil.closeSession();
    }

    /**
     * 根据发送策略查询用户列表
     *
     * @param intervalDays
     * @return
     */
    @SuppressWarnings("unchecked")
    public void sendMailByIntervalDays(Date date, Integer intervalDays,Integer taskId) {

        logger.error(Constants.sendMailTaskType.get(taskId)+" 开始发送...");

        DateTime beginTime = DateTime.now();
        Date startDate = new DateTime(date).secondOfDay().withMinimumValue().toDate();
        Date endDate = DateUtils.addDays(date, intervalDays);
        Map<String, Integer> statusMap = Maps.newHashMap();
        int dataLoadNumber = pageSize;

        String  applySql =  " SELECT per_user_id FROM per_invite_log WHERE cre_time >= :endDate " +
                " AND cre_time < :startDate GROUP BY per_user_id Having count(per_user_id) < 5 " ;
        String countSql = " SELECT COUNT(*) FROM (" +applySql +" ) AS p";

        Session session = HibernateActionSlaveUtil.currentSession();
        Query query = session.createSQLQuery(countSql);
        query.setParameter("endDate", endDate);
        query.setParameter("startDate", startDate);
        int allRecord = ((BigInteger) query.uniqueResult()).intValue();
        statusMap.put(MailCount.TOTAL.getType(), allRecord);

        logger.error("TASKID:" + taskId +", 本次任务符合条件的记录总数为 (allRecord):"  + allRecord +" 限制最大发送数：" + getSendLimitNum());
        if (allRecord > 0 ) {

            int allPage = 1;
            if (allRecord > dataLoadNumber) {
                allPage = allRecord / dataLoadNumber + ((allRecord % dataLoadNumber == 0) ? 0 : 1);
            }
            try {

                Session baseSession = HibernateSalveBaseUtil.currentSession();

                for (int i = 0; i < allPage; i++) {
                    if (i * dataLoadNumber == sendLimitNum) {
                        statusMap.put("doneFlag", Constants.MAIL_SEND_WAIT);
                        break;
                    }

                    query = session.createSQLQuery(applySql);
                    query.setParameter("endDate", endDate);
                    query.setParameter("startDate", startDate);
                    query.setFirstResult(i * dataLoadNumber);
                    query.setMaxResults((allRecord <= dataLoadNumber) ? allRecord : dataLoadNumber);

                    List<Integer> applyList = query.list();

                    //取得用户列表
                    List<PerUser> perUserList = Lists.newArrayList();
                    String perUserHql = " From PerUser WHERE id In (" + StringUtils.join(applyList,",") +") ";
                    Query baseQuery = baseSession.createQuery(perUserHql);
                    perUserList = baseQuery.list();

                    sendUserMail(perUserList, statusMap, taskId);
                    session.clear();
                    baseSession.clear();
                }

            } catch (Exception e) {
                logger.error(Constants.sendMailTaskType.get(taskId)+ e.getMessage(), e);
            }
        }


        // 更新日志
        this.saveLog(statusMap, taskId,  Constants.sendMailTaskType.get(taskId) , "");
        DateTime endTime = DateTime.now();
        String logMessage = Constants.sendMailTaskType.get(taskId)
                + "总计应发：" + NumberUtils.toInt(String.valueOf(statusMap.get(MailCount.TOTAL.getType())), 0) + "，"
                + "邮件地址过滤：" + NumberUtils.toInt(String.valueOf(statusMap.get(MailCount.EMAIL_ADDR_FILTER.getType())), 0) + "，"
                + "职位列表不足：" + NumberUtils.toInt(String.valueOf(statusMap.get(MailCount.POS_NUM_NOT_ENOUGH.getType())), 0) + "，"
                + "简历不存在：" + NumberUtils.toInt(String.valueOf(statusMap.get(MailCount.PER_RESUME_NOT_EXIST.getType())), 0) + "，"
                + "未填求职意向：" + NumberUtils.toInt(String.valueOf(statusMap.get(MailCount.NOT_FILL_PER_INTENT.getType())), 0) + "，"
                + "发送成功：" + NumberUtils.toInt(String.valueOf(statusMap.get(MailCount.SEND_SUCCESS.getType())), 0) + "，"
                + "发送失败：" + NumberUtils.toInt(String.valueOf(statusMap.get(MailCount.SEND_FAIL.getType())), 0) + "，"
                + "本次最大发送数（限制）：" + NumberUtils.toInt(String.valueOf(statusMap.get(MailCount.SEND_LIMIT_NUM.getType())), 0) + "，"
                + "共耗时：" + Hours.hoursBetween(beginTime, endTime).getHours() + "小时";
        logger.error(logMessage);
    }



    /**
     * 发送邮件信息
     *
     * @param userList
     * @param statusMap
     * @throws java.io.IOException
     */
    private void sendUserMail(List<PerUser> userList, Map<String, Integer> statusMap,Integer taskId) throws IOException {
        if (CollectionUtils.isNotEmpty(userList)) {
            RecipientNameValuePairType[] recipientParam = new RecipientNameValuePairType[userList.size() + getTestMailAddr().length];
            for (PerUser perUser : userList) {
                if (!this.checkEmail(perUser.getEmail())) {
                    this.addMailCount(statusMap, MailCount.EMAIL_ADDR_FILTER);
                    continue;
                }
                Map<String, Object> paramMap = Maps.newHashMap();
                paramMap.put("userName", perUser != null ? perUser.getUserName() : "");
                String email = getOneVaildEmail(perUser.getEmail());
                if (StringUtils.isBlank(email)) {
                    this.addMailCount(statusMap, MailCount.EMAIL_ADDR_FILTER);
                    continue;
                }
                int campaignId = 7;   //活动ID
                int mailingId = 45;   //邮件ID
                int groupId = 81;     //组ID

                try {
                    //email = "290413939@qq.com";
                    String unsubscribeLink = this.assembleUnsubscribeLink(perUser, taskId);
                    recipientParam = new RecipientNameValuePairType[]{
                            new RecipientNameValuePairType("email", email),
                            new RecipientNameValuePairType("username", ObjectUtils.toString(perUser.getUserName(),"")),
                            new RecipientNameValuePairType("unsubscribelink", unsubscribeLink),
                    };
                    boolean flag = SendEmailByWebpowerApi.getInstance().sendSingleMailing(recipientParam, campaignId, mailingId, groupId);
                    if (flag) {
                        this.addMailCount(statusMap, MailCount.SEND_SUCCESS);
                    } else {
                        this.addMailCount(statusMap, MailCount.SEND_FAIL);
                        if (getSendNum() < 100) {
                            //logger.error("SEND FAIL TO:"+ email);
                        }
                    }
                } catch (Exception e) {
                    this.addMailCount(statusMap, MailCount.SEND_FAIL);
                    e.printStackTrace();
                }

                /**发送测试邮件**/
                this.addSendNum();
                if (this.getSendNum() % this.getSendTestMailPerNum() == 0) {
                    for (String testEmail : getTestMailAddr()) {
                        recipientParam[0] = new RecipientNameValuePairType("email", testEmail);//收件人email
                        SendEmailByWebpowerApi.getInstance().sendSingleMailing(recipientParam, campaignId, mailingId, groupId);
                    }
                }
            }
        }
    }


    /**
     * 组装邮件内容
     *
     * @param perUser
     * @return
     * @throws IOException
     */
    private String assembleMailContent(PerUser perUser,Integer taskId) throws IOException {
        if (perUser != null) {
            String unsubscribeLink = this.assembleUnsubscribeLink(perUser,taskId);
            Map<String, Object> map = Maps.newHashMap();
            map.put("perUser", perUser);
            map.put("unsubscribeLink", unsubscribeLink);

            Configuration configure = FreemarkerConfigure.getFreemarkerConfig();
            Template template = configure.getTemplate("mail/third/per_interview_less.ftl");

            try {
                StringWriter result = new StringWriter();
                template.process(map, result);
                return result.toString();
            } catch (TemplateException e) {
                e.printStackTrace();
                logger.error("===邮件模板解析异常：" + e.getMessage(), e);
            }
        }
        return StringUtils.EMPTY;
    }



    public static int getSendLimitNum() {
        return sendLimitNum;
    }

    public static void setSendLimitNum(int sendLimitNum) {
        PerInterviewLess.sendLimitNum = sendLimitNum;
    }
}
