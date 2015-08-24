package com.job5156.task.mail;

import com.google.common.collect.Maps;
import com.job5156.beans.mail.BaseMailSend;
import com.job5156.common.CommonEnum;
import com.job5156.common.Constants;
import com.job5156.common.api.SendEmailByWebpowerApi;
import com.job5156.common.exception.EmailServerConfigException;
import com.job5156.common.util.HibernateUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.ResultTransformer;
import org.joda.time.DateTime;
import org.joda.time.Hours;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-8-25
 * Time: 上午10:17
 * To change this template use File | Settings | File Templates.
 */
public class SendMailPlan {

    private static Logger logger = Logger.getLogger(BirthdayWishes.class);


    public static  void main(String[] args){
            new SendMailPlan().excuteMailPlan();
    }
    public SendMailPlan()  {
    }
    public  void  excuteMailPlan(){
        List<Map<String,Object>> resukt=new ArrayList<>();
//        `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
//        `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '邮件状态  0：待发送  1：正在发送  2：发送完毕',
//        `start_time` timestamp NULL DEFAULT NULL COMMENT '开始执行时间',
//        `mail_title` varchar(255) DEFAULT NULL COMMENT '邮件标题',
//        `from_addr` varchar(255) DEFAULT NULL COMMENT '发送邮件地址',
//        `from_name` varchar(255) DEFAULT NULL COMMENT '发送邮件名称',
//        `send_type` tinyint(4) DEFAULT NULL COMMENT 'sendType',
//        `content` mediumtext,
//        `count_log` varchar(255) DEFAULT NULL COMMENT '统计日志',
//        `data_sql` varchar(255) DEFAULT NULL COMMENT '数据SQL',
//        `campaign_id` int(11) DEFAULT NULL COMMENT '商业邮件--活动ID',
//        `mailing_id` int(11) DEFAULT NULL COMMENT '商业邮件--邮件ID',
//        `group_id` int(11) DEFAULT NULL COMMENT '商业邮件--组ID',
//        `create_date` timestamp NULL DEFAULT NULL COMMENT '创建时间',
//        `update_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
        String hql = " select  id as id ,start_time  as start_time,mail_title  as mail_title,from_addr  as from_addr," +
                " from_name as from_name,send_type as send_type,content as content, data_sql as data_sql," +
                " campaign_id as campaign_id,mailing_id as mailing_id,group_id as group_id  from  sys_mail_plan  where  status=0 ";   //查找待执行的计划
        SQLQuery sqlQuery = HibernateUtil.currentSession().createSQLQuery(hql);
        sqlQuery.setResultTransformer(new ResultTransformer() {
            @Override
            public Object transformTuple(Object[] values, String[] columns)
            {
                Map<String, Object> map = new LinkedHashMap<String, Object>(1);
                int i = 0;
                for(String column : columns){
                    map.put(column, values[i++]);
                }
                return map;
            }
            @Override
            public List transformList(List list)
            {
                return list;
            }
        });
        List<Map<String, Object>> resultList= sqlQuery.list();

        for (int t=0;t<resukt.size();t++){
            Map<String,Object> map= resukt.get(0);

        }
    }
    @SuppressWarnings("unchecked")
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
//                    sendUserMail((List<String>)query.list(),statusMap);
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
//        this.saveLog(statusMap, Constants.MAIL_TASK_SYSTEM_BIRTHDAY_WISH, "系统发送微信推广邮件","");
    }

   class  MailPlanSender extends BaseMailSend{
       private Map<String,String> filterMap=new HashMap<>();
       private int sendType;
       private int campaignId;
       private int mailingId;
       private int groupId;
       public MailPlanSender(int sendType) throws EmailServerConfigException {
           this.setSendTestMailPerNum(2000);
           this.sendType=sendType;
       }


       @SuppressWarnings("unchecked")
       @Override
       public void send() {


       }
       /**
        * 发送邮件信息
        *
        * @param statusMap
        * @throws java.io.IOException
        */
       private void sendThirdMail(List<String> mailList, Map<String, Integer> statusMap) throws IOException {

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
                   /**发送测试邮件**/
                   this.addSendNum();
                   if(this.getSendNum() % this.getSendTestMailPerNum() == 0){
                       logger.error("已经成功发送"+String.valueOf(this.getSendNum())+"条邮件！");
                   }

               }
           }
       }
    }


}
