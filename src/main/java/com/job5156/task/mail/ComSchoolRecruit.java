package com.job5156.task.mail;

import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.job5156.beans.mail.BaseMailSend;
import com.job5156.beans.mail.EmailSender;
import com.job5156.common.CommonEnum.MailCount;
import com.job5156.common.CommonEnum.MailServer;
import com.job5156.common.Constants;
import com.job5156.common.api.SendEmailByWebpowerApi;
import com.job5156.common.exception.EmailServerConfigException;
import com.job5156.common.util.HibernateSalveBaseUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.joda.time.DateTime;
import org.joda.time.Hours;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

/**
 * 给企业发送校园招聘的推广邮件
 * 业务规则：当前未过期的正式企业用户
 *
 * @author leeton
 *
 */
public class ComSchoolRecruit extends BaseMailSend{
    private static Logger logger = Logger.getLogger(ComSchoolRecruit.class);

    private Gson gson;
    private EmailSender sender;
    private static int sendLimitNum = 150000; //每天最多发送的数量
    private int pageSize = 1000;


    public ComSchoolRecruit() throws EmailServerConfigException {
        gson = new Gson();
        sender = new EmailSender(MailServer.MAIN);
        this.setSendTestMailPerNum(10000);
    }

    public ComSchoolRecruit(MailServer mailServer) throws EmailServerConfigException {
        gson = new Gson();
        sender = new EmailSender(mailServer);
        this.setSendTestMailPerNum(10000);
    }

    public static void main(String[] args) {
        try {

            ComSchoolRecruit recommend = new ComSchoolRecruit();
            recommend.setTestMailAddr("1372236380@qq.com", "yf_198407@163.com", "jmail168@163.com","dghxc@job5156.com","381436695@qq.com");
            setSendLimitNum(1);
            recommend.send();

            HibernateSalveBaseUtil.closeSession();
        } catch (EmailServerConfigException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void send() {
        this.sendMailByIntervalDays(Constants.MAIL_TASK_COM_SCHOOL_RECRUIT);
        HibernateSalveBaseUtil.closeSession();
    }

    /**
     * 根据发送策略查询用户列表
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    public void sendMailByIntervalDays(Integer taskId) {

        logger.error(Constants.sendMailTaskType.get(taskId)+" 开始发送...");

        DateTime beginTime = DateTime.now();
        Map<String, Integer> statusMap = Maps.newHashMap();
        int dataLoadNumber = pageSize;

        String  comSql =  " SELECT cc.email FROM com_right cr JOIN com_contact cc ON cr.com_id = cc.com_id  WHERE cr.member_type < 6" +
                " AND cr.member_type > 1 AND cr.expire_date > :today ";
        String countSql = " SELECT COUNT(*) FROM " + StringUtils.substringAfter(comSql, "FROM");

        Session session = HibernateSalveBaseUtil.currentSession();
        Query query = session.createSQLQuery(countSql);
        query.setParameter("today", DateTime.now().toDate());
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

                    query = session.createSQLQuery(comSql);
                    query.setParameter("today", DateTime.now().toDate());
                    query.setFirstResult(i * dataLoadNumber);
                    query.setMaxResults((allRecord <= dataLoadNumber) ? allRecord : dataLoadNumber);

                    List<String> dataList = query.list();

                    sendUserMail(dataList, statusMap, taskId);
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
     * @param dataList
     * @param statusMap
     * @throws java.io.IOException
     */
    private void sendUserMail(List<String> dataList, Map<String, Integer> statusMap,Integer taskId) throws IOException {
        if (CollectionUtils.isNotEmpty(dataList)) {
            for (String emailStr : dataList) {
                if (getSendNum() >= sendLimitNum) {
                    break;
                }
                this.addSendNum();

                String email = "";
                List<String> emailList = gson.fromJson(emailStr, List.class);
                if(CollectionUtils.isNotEmpty(emailList)) {
                    email = emailList.get(0);
                }else{
                    this.addMailCount(statusMap, MailCount.EMAIL_ADDR_FILTER);
                   continue;
                }
                if (!this.checkEmail(email)) {
                    this.addMailCount(statusMap, MailCount.EMAIL_ADDR_FILTER);
                    continue;
                }

                if(isHardBouceEmail(email)){//EMAIL是否在硬退信列表中
                    this.addMailCount(statusMap, MailCount.EMIAL_HARD_BOUNCE_FILTER);
                    continue;
                }
                int campaignId = 8;   //活动ID
                int mailingId = 50;   //邮件ID
                int groupId = 81;     //组ID
                try {
//                    email = "1372236380@qq.com";  //test
                    boolean flag = SendEmailByWebpowerApi.getInstance().sendSingleMailing(email, "", campaignId, mailingId, groupId);
                    if (flag) {
                        this.addMailCount(statusMap, MailCount.SEND_SUCCESS);
                    } else {
                        this.addMailCount(statusMap, MailCount.SEND_FAIL);
                    }
                } catch (Exception e) {
                    this.addMailCount(statusMap, MailCount.SEND_FAIL);
                    e.printStackTrace();
                }

                /**发送测试邮件**/
                this.addSendNum();
                if (this.getSendNum() % this.getSendTestMailPerNum() == 0) {
                    for (String testEmail : getTestMailAddr()) {
                      //  SendEmailByWebpowerApi.getInstance().sendSingleMailing(testEmail, "", campaignId, mailingId, groupId);
                    }
                }
            }
        }
    }



    public static int getSendLimitNum() {
        return sendLimitNum;
    }

    public static void setSendLimitNum(int sendLimitNum) {
        ComSchoolRecruit.sendLimitNum = sendLimitNum;
    }
}
