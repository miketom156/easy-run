package com.job5156.task.mail.sales;

import com.google.common.collect.Maps;
import com.job5156.beans.mail.BaseMailSend;
import com.job5156.common.CommonEnum;
import com.job5156.common.Constants;
import com.job5156.common.api.SendEmailByWebpowerApi;
import com.job5156.common.exception.EmailServerConfigException;
import com.job5156.common.util.HibernateUtil;
import com.job5156.task.mail.BirthdayWishes;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.joda.time.DateTime;
import org.joda.time.Hours;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 微信推广邮件
 */
public class WeiXinServiceToPer extends BaseMailSend {

    private static Logger logger = Logger.getLogger(BirthdayWishes.class);
    private Map<String,String> filterMap=new HashMap<>();
    private int campaignId = 11;   //活动ID
    private int mailingId = 65;   //邮件ID
    private int groupId = 81;     //组ID


    public WeiXinServiceToPer() throws EmailServerConfigException {
        this.setSendTestMailPerNum(2000);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void send() {
        logger.error("[微信推广邮件]任务开始...");
        Map<String, Integer> statusMap = Maps.newHashMap();
        int dataLoadNumber = 2000;
        DateTime beginTime = DateTime.now();
        Calendar ca= Calendar.getInstance();
        ca.setTime(beginTime.toDate());
        ca.add(Calendar.DAY_OF_YEAR,-182);   //半年内
        SimpleDateFormat sdf=new  SimpleDateFormat("yyyy-MM-dd");
        String hql = " select a.email  from  per_user a left  join  per_resume  b  on a.res_id=b.id  " +
                "  where   a.login_date>='"+sdf.format(ca.getTime())+"' and b.pass>=0 ";
        String countHql = " select COUNT(a.email)  from  per_user a left  join  per_resume  b  on a.res_id=b.id  " +
                "  where   a.login_date>='"+sdf.format(ca.getTime())+"' and b.pass>=0 ";
        Session session = HibernateUtil.currentSession();
        Query query = session.createSQLQuery(countHql);
        int allRecord = Integer.parseInt(query.uniqueResult().toString());
        logger.error("[微信推广邮件]共"+allRecord+"条开始发送...");
        statusMap.put(CommonEnum.MailCount.TOTAL.getType(), allRecord);

        if (allRecord > 0) {
            int allPage = 1;
            if (allRecord > dataLoadNumber) {
                allPage = allRecord / dataLoadNumber + ((allRecord % dataLoadNumber == 0) ? 0 : 1);
            }
            try {
                for (int i =262000/dataLoadNumber; i < allPage; i++) { //上次已经完成了261700多
                    query = session.createSQLQuery(hql);
                    query.setFirstResult(i * dataLoadNumber);
                    query.setMaxResults(dataLoadNumber);
                    sendUserMail((List<String>)query.list(),statusMap);
                    session.clear();
                }
            } catch (Exception e) {
                e.printStackTrace();
                logger.info("===系统发送微信推广邮件异常：" + e.getMessage(), e);
            }
        }
        DateTime endTime = DateTime.now();
        String logMessage = "[系统发送微信推广邮件]"
                + "总计应发：" + NumberUtils.toInt(String.valueOf(statusMap.get(CommonEnum.MailCount.TOTAL.getType())), 0) + "，"
                + "邮件地址过滤：" + NumberUtils.toInt(String.valueOf(statusMap.get(CommonEnum.MailCount.EMAIL_ADDR_FILTER.getType())), 0) + "，"
                + "发送成功：" + NumberUtils.toInt(String.valueOf(statusMap.get(CommonEnum.MailCount.SEND_SUCCESS.getType())), 0) + "，"
                + "发送失败：" + NumberUtils.toInt(String.valueOf(statusMap.get(CommonEnum.MailCount.SEND_FAIL.getType())), 0) + "，"
                + "共耗时：" + Hours.hoursBetween(beginTime, endTime).getHours() + "小时";
        logger.error(logMessage);

        // 记录日志
        this.saveLog(statusMap, Constants.MAIL_TASK_SYSTEM_BIRTHDAY_WISH, "系统发送微信推广邮件","");
    }



    /**
     * 发送邮件信息
     *
     * @param statusMap
     * @throws IOException
     */
    private void sendUserMail(List<String> mailList, Map<String, Integer> statusMap) throws IOException {

        if (CollectionUtils.isNotEmpty(mailList)) {
            for (String mail : mailList) {
                    String email = getOneVaildEmail(mail);
                    if(StringUtils.isBlank(email)){
                        this.addMailCount(statusMap, CommonEnum.MailCount.EMAIL_ADDR_FILTER);
                        continue;
                    }
                    if(filterMap.get(email)!=null){ //已经发送过
                        continue;
                    }
                    try {
                        boolean flag = SendEmailByWebpowerApi.getInstance().sendSingleMailing(email, "", campaignId, mailingId, groupId);
                        if(flag){
                            this.addMailCount(statusMap, CommonEnum.MailCount.SEND_SUCCESS);
                            logger.error(email + "发送成功！");
                        }else{
                            this.addMailCount(statusMap, CommonEnum.MailCount.SEND_FAIL);
                            logger.error(email + "发送失败！");
                        }
                        filterMap.put(email,email) ;
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        logger.error(email + "发送失败！");
                    }
//                    /**发送测试邮件**/
                    this.addSendNum();
                    if(this.getSendNum() % this.getSendTestMailPerNum() == 0){
                        logger.error("已经成功发送"+String.valueOf(this.getSendNum())+"条邮件！");
                    }

            }
        }
    }
}
