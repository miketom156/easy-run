package com.job5156.task.mail.sales;

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
import org.hibernate.Session;
import org.joda.time.DateTime;
import org.joda.time.Hours;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 电商推广邮件
 * </p>
 * 
 * @author leo
 * 
 */
@SuppressWarnings("deprecation")
public class EshopPerMail extends BaseMailSend {
	private static Logger logger = Logger.getLogger(EshopPerMail.class);

    private Map<String,String> filterMap=new HashMap<>();
    private int campaignId = 12;   //活动ID  12
    private int mailingId = 80;   //邮件ID  71
    private int groupId = 70;     //组ID    81


    public EshopPerMail() throws EmailServerConfigException {
        this.setSendTestMailPerNum(2000);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void send() {
        int allRecord =270270;
        logger.error("[电商频道推广邮件]共"+allRecord+"条开始发送...");
        DateTime  beginTime= DateTime.now();
        Map<String, Integer> statusMap = Maps.newHashMap();
        statusMap.put(CommonEnum.MailCount.TOTAL.getType(), allRecord);


        List<InputStream>  inputStreams =new ArrayList<>();
        for(int s=14;s<35;s++){//从第14页开始
            inputStreams.add(EshopPerMail.class.getResourceAsStream("/temp/resumeIds_"+s+".txt"));
        }
        int     index=14;
        for(InputStream inputStream:inputStreams){
            try {
                    InputStreamReader read = new InputStreamReader(inputStream);//
                    BufferedReader bufferedReader = new BufferedReader(read);
                    String lineTxt = null;
                    while((lineTxt = bufferedReader.readLine()) != null){
                        String[]  resumeIds=lineTxt.split(";");
                        String idSql="";
                        for(int s=0;s<resumeIds.length;s++)  {
                            idSql+=" "+resumeIds[s]+" ,";
                        }
                        if(idSql.trim().length()>0){
                            idSql=idSql.substring(0,idSql.length()-1);
                        } else{
                            continue;
                        }
                        try{
                            String hql = " select a.email  from  per_user a left  join  per_resume  b " +
                                    " on a.res_id=b.id    where  b.id in ("+idSql+")";
                            Session session = HibernateUtil.currentSession();
                            List<String>  emailList= session.createSQLQuery(hql).list();
                            sendUserMail(emailList,statusMap);
                        } catch (Exception ex)     {
                            ex.printStackTrace();
                        }


                    }
                    read.close();
            } catch (Exception e) {
                logger.error("读取文件内容出错");
                e.printStackTrace();
            }
            index++;
            logger.error("已经发送成功文件【/temp/resumeIds_"+index+".txt】");
        }


        DateTime endTime = DateTime.now();
        String logMessage = "[电商频道推广邮件]"
                + "总计应发：" + NumberUtils.toInt(String.valueOf(statusMap.get(CommonEnum.MailCount.TOTAL.getType())), 0) + "，"
                + "邮件地址过滤：" + NumberUtils.toInt(String.valueOf(statusMap.get(CommonEnum.MailCount.EMAIL_ADDR_FILTER.getType())), 0) + "，"
                + "发送成功：" + NumberUtils.toInt(String.valueOf(statusMap.get(CommonEnum.MailCount.SEND_SUCCESS.getType())), 0) + "，"
                + "发送失败：" + NumberUtils.toInt(String.valueOf(statusMap.get(CommonEnum.MailCount.SEND_FAIL.getType())), 0) + "，"
                + "共耗时：" + Hours.hoursBetween(beginTime, endTime).getHours() + "小时";
        logger.error(logMessage);

        // 记录日志
        this.saveLog(statusMap, Constants.MAIL_TASK_SYSTEM_BIRTHDAY_WISH, "系统发送电商频道推广邮件","");
    }



    /**
     * 发送邮件信息
     *
     * @param statusMap
     * @throws java.io.IOException
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
                } catch (Exception e) {
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
