package com.job5156.task.mail;

import com.easeye.webservice.EaseyeGroupDTO;
import com.easeye.webservice.EaseyeMessageReceiveDTO;
import com.easeye.webservice.EaseyeMessageTemplateDTO;
import com.easeye.webservice.EaseyeSendOptionDTO;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.job5156.beans.freemarker.FreemarkerConfigure;
import com.job5156.beans.mail.BaseMailSend;
import com.job5156.beans.mail.EmailSender;
import com.job5156.common.CommonEnum.MailCount;
import com.job5156.common.CommonEnum.MailServer;
import com.job5156.common.Constants;
import com.job5156.common.api.SendEmailByEaseYeApi;
import com.job5156.common.exception.EmailServerConfigException;
import com.job5156.common.util.*;
import com.job5156.model.logs.LogMailBatchSend;
import com.job5156.model.per.PerResume;
import com.job5156.model.per.PerUser;
import com.job5156.vo.api.PosSearchResult;
import com.job5156.vo.api.PosSearchResult.ComPosVo;
import com.job5156.vo.mail.PosRecommendMailVo;
import com.job5156.vo.per.PerIntentVo;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Hours;
import org.joda.time.Minutes;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 大量发送职位推荐邮件
 * 使用用亿业科技的WEBSERVICE-API
 * 步骤：
 * 1：查询出符合条件的个人用户
 * 2：组装邮件内容
 * 3：把邮件内容通过数组的形式上传到平台并创建收件人组（平台上收件人的mailContent字段用于存放邮件内容）
 * 4：调用平台的API发送刚才创建的收件人组列表
 * </p>
 *
 */
public class PosRecommendByEyWsApi extends BaseMailSend{
    private static Logger logger = Logger.getLogger(PosRecommendByEyWsApi.class);

    private Gson gson;
    private EmailSender sender;
    private int sendLimitNum ; //每天最多发送的数量
    private int pageSize = 200; //受限于API，每次上传联系人不能超过1000人,并且受限于HTTP的BODY不能太。
    private SendEmailByEaseYeApi sendEmailApi = SendEmailByEaseYeApi.getInstance();
    private EaseyeGroupDTO group = null;



    public PosRecommendByEyWsApi() throws EmailServerConfigException {
        gson = new Gson();
        sender = new EmailSender(MailServer.THIRD_EASEYE);
    }

    public PosRecommendByEyWsApi(MailServer mailServer) throws EmailServerConfigException {
        gson = new Gson();
        sender = new EmailSender(mailServer);
    }

    public static void main(String[] args) {
        try {

            PosRecommendByEyWsApi recommend = new PosRecommendByEyWsApi();
            recommend.setTestMailAddr(new String[]{"yf_198407@163.com"});
            recommend.setSendLimitNum(1);
            recommend.send();

            HibernateUtil.closeSession();
            HibernateCountUtil.closeSession();
        } catch (EmailServerConfigException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void send() {
        Date date1 = DateTime.now().minusDays(15).toDate();
        Date date2 = new DateTime(date1).minusDays(175).toDate();
        this.sendMailByIntervalDays(date1, -175,Constants.MAIL_TASK_SYSTEM_POS_RECOMMEND_EYAPI_P1,"P1"); //15-175
    }

    /**
     * 根据发送策略查询用户列表
     *
     * @param intervalDays
     * @return
     */
    @SuppressWarnings("unchecked")
    public void sendMailByIntervalDays(Date date, Integer intervalDays,Integer taskId,String proc) {
        logger.error(Constants.sendMailTaskType.get(taskId)+" 开始发送...");
        DateTime beginTime = DateTime.now();
        Date loginDate = DateUtils.addDays(date, intervalDays);
        Map<String, Integer> statusMap = Maps.newHashMap();

        int beginId = getBeginId(taskId,proc);

        String  hql =  " FROM PerUser AS p WHERE p.id > :beginId AND p.loginDate > :beginLoginDate AND p.loginDate < :endLoginDate ORDER BY p.id" ;
        String countHql = " SELECT COUNT(*) " + hql;

        Date beginLoginDate = new DateTime(loginDate).secondOfDay().withMinimumValue().toDate();
        Date endLoginDate = new DateTime(date).secondOfDay().withMaximumValue().toDate();

        Session session = HibernateSalveBaseUtil.currentSession();
        Query query = session.createQuery(countHql);
        query.setParameter("beginLoginDate", beginLoginDate);
        query.setParameter("endLoginDate", endLoginDate);
        query.setParameter("beginId", beginId);

        int allRecord = ((Long) query.uniqueResult()).intValue();

        //创建初始日志
        if(sendLimitNum > 0){
            statusMap.put(MailCount.TOTAL.getType(), sendLimitNum);
        }else{
            statusMap.put(MailCount.TOTAL.getType(), allRecord);
        }
        statusMap.put("doneFlag", 0);
        statusMap.put("beginId",beginId) ;
        statusMap.put(MailCount.SEND_LIMIT_NUM.getType(), sendLimitNum);
        this.saveLog(statusMap, taskId, Constants.sendMailTaskType.get(taskId),proc);
        Integer logId = getLogId(taskId,proc);

        logger.error("TASKID:" + taskId +", 本次任务符合条件的记录总数为 (allRecord):"  + allRecord +" 限制最大发送数：" + sendLimitNum);
        if (allRecord > 0 ) {

            int allPage = 1;
            if (allRecord > pageSize) {
                allPage = allRecord / pageSize + ((allRecord % pageSize == 0) ? 0 : 1);
            }
            try {
                for (int i = 0; i < allPage; i++) {
                    if(i*pageSize == sendLimitNum) {
                        statusMap.put("doneFlag", Constants.MAIL_SEND_WAIT);
                        break;
                    }

                    query = session.createQuery(hql);
                    query.setParameter("beginLoginDate", beginLoginDate);
                    query.setParameter("endLoginDate", endLoginDate);
                    query.setParameter("beginId", beginId);
                    query.setFirstResult(i * pageSize);
                    query.setMaxResults((allRecord<=pageSize)?allRecord:pageSize);

                    List<PerUser> userList = query.list();

                    getMailContentAndSendToGroup(logId, userList, statusMap);
                    session.clear();
                }

                //通过API发送邮件
                sendByApi(group);

            } catch (Exception e) {
                logger.error(Constants.sendMailTaskType.get(taskId)+ e.getMessage(), e);
            }
        }

        Integer countSendNum = countSendNum(taskId,proc);
        if((countSendNum + 2000) >= allRecord){ //因为6天之后，应发送总数会有变更化，故已发送数+5000
            statusMap.put("doneFlag", Constants.MAIL_SEND_SUCCESS);
        }

        // 更新日志
        statusMap.put("id",logId);
        this.saveLog(statusMap, taskId,  Constants.sendMailTaskType.get(taskId) , proc);
        DateTime endTime = DateTime.now();
        String logMessage = Constants.sendMailTaskType.get(taskId)
                + "总计应发：" + NumberUtils.toInt(String.valueOf(statusMap.get(MailCount.TOTAL.getType())), 0) + "，"
                + "邮件地址过滤：" + NumberUtils.toInt(String.valueOf(statusMap.get(MailCount.EMAIL_ADDR_FILTER.getType())), 0) + "，"
                + "硬弹过滤：" + NumberUtils.toInt(String.valueOf(statusMap.get(MailCount.EMIAL_HARD_BOUNCE_FILTER.getType())), 0) + "，"
                + "职位列表不足：" + NumberUtils.toInt(String.valueOf(statusMap.get(MailCount.POS_NUM_NOT_ENOUGH.getType())), 0) + "，"
                + "简历不存在：" + NumberUtils.toInt(String.valueOf(statusMap.get(MailCount.PER_RESUME_NOT_EXIST.getType())), 0) + "，"
                + "未填求职意向：" + NumberUtils.toInt(String.valueOf(statusMap.get(MailCount.NOT_FILL_PER_INTENT.getType())), 0) + "，"
                + "发送成功：" + NumberUtils.toInt(String.valueOf(statusMap.get(MailCount.SEND_SUCCESS.getType())), 0) + "，"
                + "发送失败：" + NumberUtils.toInt(String.valueOf(statusMap.get(MailCount.SEND_FAIL.getType())), 0) + "，"
                + "本次最大发送数（限制）：" + NumberUtils.toInt(String.valueOf(statusMap.get(MailCount.SEND_LIMIT_NUM.getType())), 0) + "，"
                + "开始时间：" +beginTime.toLocalDateTime() +"结束时间：" +endTime.toLocalDateTime() + "，"
                + "共耗时：" + Hours.hoursBetween(beginTime, endTime).getHours() + "小时,"+ Minutes.minutesBetween(beginTime,endTime).getMinutes()+"分钟";
        logger.error(logMessage);
    }



    /**
     * 创建邮件内容
     * @param logId
     * @param userList
     * @param statusMap
     * @throws java.io.IOException
     */
    private EaseyeGroupDTO getMailContentAndSendToGroup(int logId, List<PerUser> userList, Map<String, Integer> statusMap) throws IOException {

        EaseyeMessageReceiveDTO[] messageReceiveDTOs = new EaseyeMessageReceiveDTO[pageSize+this.getTestMailAddr().length];
        if (CollectionUtils.isNotEmpty(userList)) {

            int i = 0;
            for (PerUser perUser : userList) {
                if (getSendNum() >= sendLimitNum) {
                    break;
                }
                this.addSendNum();
                if (!this.checkMailSend(perUser, Constants.MAIL_TASK_SYSTEM_POS_RECOMMEND_WPAPI)) {
                    this.addMailCount(statusMap, MailCount.EMAIL_ADDR_FILTER);
                    continue;
                }
                String email = getOneVaildEmail(perUser.getEmail());
                if (StringUtils.isBlank(email)) {
                    this.addMailCount(statusMap, MailCount.EMAIL_ADDR_FILTER);
                    continue;
                }
                if(isHardBouceEmail(email)){//EMAIL是否在硬退信列表中
                    this.addMailCount(statusMap, MailCount.EMIAL_HARD_BOUNCE_FILTER);
                    continue;
                }

                String mailContent = this.assembleMailContent(perUser, statusMap);
                if (StringUtils.isNotBlank(mailContent)) {
                    EaseyeMessageReceiveDTO receiveDTO = new EaseyeMessageReceiveDTO();
                   // email = "mailtous@163.com";     //test
                    receiveDTO.setTo(email);
                    receiveDTO.setFullName(perUser.getUserName());
                    receiveDTO.setReserve1(mailContent);

                    this.addMailCount(statusMap, MailCount.SEND_SUCCESS);
                    statusMap.put(MailCount.BEGIN_ID.getType(), perUser.getId()); //记录当前个人ID，以备下次运行从这个ID开始读取数据
                    if (getSendNum() % 100 == 0) {
                        updateLogMailBathSend(logId, perUser.getId(), getSendNum(), Constants.MAIL_SEND_WAIT); //记录当前PERUSER ID
                    }

                    messageReceiveDTOs[i]=receiveDTO;
                    i++;

                    /**发送测试邮件**/

                    if (this.getSendNum() % this.getSendTestMailPerNum() == 0 || this.getSendNum() == 1) {
                        for(String to: this.getTestMailAddr()) {
                            EaseyeMessageReceiveDTO testReceive = new EaseyeMessageReceiveDTO();
                            testReceive.setTo(to);
                            testReceive.setFullName("测试用户" + i);
                            testReceive.setReserve1(mailContent);
                            messageReceiveDTOs[i]=testReceive;
                            i++;
                        }
                    }
                } else {
                    this.addMailCount(statusMap, MailCount.SEARCHER_IS_EMPTY);
                }
            }

        }
        //发送邮件内容到组
        if (messageReceiveDTOs.length > 0) {
            group = sendEmailApi.createGroupInToday();
            return  group = sendEmailApi.importContactByGroupDetail(group, messageReceiveDTOs, "");
        }
        return null;
    }



    /**
     * 发送邮件亿业WEBSERVICE-API
     * @return
     */
    private boolean sendByApi( EaseyeGroupDTO group){

        try {
            if(group != null){
                EaseyeSendOptionDTO easeyeSendOptionDTO = sendEmailApi.getSendOption();

                EaseyeMessageTemplateDTO easeyeMessageTemplateDTO = new  EaseyeMessageTemplateDTO();
                easeyeMessageTemplateDTO.setTemplateName("position_recommend");
                easeyeMessageTemplateDTO.setTrackLink("1");
                easeyeMessageTemplateDTO.setSubject("");
                easeyeMessageTemplateDTO.setBody("");
                sendEmailApi.sendMailByGroup(easeyeMessageTemplateDTO, group, easeyeSendOptionDTO);
            }
            return true;
        } catch (Exception e) {
            logger.error("调用亿业WS-API发送邮件失败："+e.getMessage());
            e.printStackTrace();
        }
        return false;

    }


    /**
     * 组装邮件内容
     *
     * @param perUser
     * @return
     * @throws java.io.IOException
     */
    private String assembleMailContent(PerUser perUser, Map<String, Integer> statusMap) throws IOException {
        if (perUser != null) {
            PerResume perResume = perUser.getDefaultPerResume();
            if(perResume == null){
                this.addMailCount(statusMap, MailCount.PER_RESUME_NOT_EXIST);
                return StringUtils.EMPTY;
            }

            List<NameValuePair> httpParamList = this.assemblePosSearchParam(perResume);
            if(CollectionUtils.isEmpty(httpParamList)){
                this.addMailCount(statusMap, MailCount.NOT_FILL_PER_INTENT);
                return StringUtils.EMPTY;
            }

            List<ComPosVo> comPosList = this.getPosListByUserIntent(perUser.getId(), httpParamList);
            if(CollectionUtils.isEmpty(comPosList) || comPosList.size() == 0){
                this.addMailCount(statusMap, MailCount.POS_NUM_NOT_ENOUGH);
                return StringUtils.EMPTY;
            }

            if(comPosList.size() > 10){
                comPosList = comPosList.subList(0, 10);
            }
            String morePosLink = this.assembleMoreLink(perResume);
            String unsubscribeLink = this.assembleUnsubscribeLink(perUser, Constants.MAIL_TASK_SYSTEM_POS_RECOMMEND_WPAPI);

            Map<String, Object> map = Maps.newHashMap();
            map.put("comPosList", comPosList);
            map.put("perUser", perUser);
            map.put("dateInterval", Days.daysBetween(new DateTime(perUser.getLoginDate()), DateTime.now()).getDays());
            map.put("morePosLink", morePosLink);
            map.put("unsubscribeLink", unsubscribeLink);

            Configuration configure = FreemarkerConfigure.getFreemarkerConfig();
            Template template = configure.getTemplate("mail/third/system_pos_recommend.ftl");

            try {
                StringWriter result = new StringWriter();
                template.process(map, result);
                return result.toString();
            } catch (TemplateException e) {
                logger.error("===邮件模板解析异常：" + e.getMessage(), e);
            }
        }
        return StringUtils.EMPTY;
    }


    /**
     * 根据求职意向查询匹配职位列表
     * @param userId
     * @param httpParamList
     * @return
     */
    private List<ComPosVo> getPosListByUserIntent(Integer userId, List<NameValuePair> httpParamList) {
        List<ComPosVo> posList = Lists.newArrayList();
        HttpClient httpClient = null;
        String jsonStr = StringUtils.EMPTY;
        if(userId == null || CollectionUtils.isEmpty(httpParamList)){
            return posList;
        }

        try {
            httpClient = new DefaultHttpClient();
            HttpPost httpost = new HttpPost(Constants.API_POS_SEARCH_URL);
            httpost.setEntity(new UrlEncodedFormEntity(httpParamList, Consts.UTF_8));
            HttpResponse response = httpClient.execute(httpost);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                jsonStr = EntityUtils.toString(entity, "utf-8");
                JsonValidator jsonValidator = new JsonValidator();
                if (jsonValidator.validate(jsonStr)) {
                    EntityUtils.consume(entity);
                    PosSearchResult result = gson.fromJson(jsonStr, PosSearchResult.class);
                    if (result.isSuccess()) {
                        posList = result.getDataList();
                    } else {
                        logger.error("===调用接口查询匹配求职意向职位列表失败：" + StringUtils.join(result.getErrorList(), ";") + "====USERID:" + userId);
                    }
                }
            }
        } catch (Exception e) {
            logger.error("===调用接口查询匹配求职意向职位列表异常：" + e.getMessage(), e);
            logger.error("USERID:" + userId);
            logger.error(jsonStr);
            posList=Lists.newArrayList();
        } finally {
            httpClient.getConnectionManager().shutdown();
        }
        return posList;
    }

    /**
     * 封装搜索查询参数
     * @param perResume
     * @return
     */
    private List<NameValuePair> assemblePosSearchParam(PerResume perResume) {
        List<NameValuePair> paramList = Lists.newArrayList();

        /*
         // 按行业,职位名称，职位代码，所在地
         PerIntentVo intentVo = gson.fromJson(perResume.getIntentInfo(), PerIntentVo.class);
        if (intentVo != null && (StringUtils.isNotBlank(intentVo.getJobCode())
                || StringUtils.isNotBlank(intentVo.getJobLocation())
                || StringUtils.isNotBlank(intentVo.getJobName()))) {
            paramList.add(new BasicNameValuePair("propertyList", ObjectUtils.toString(intentVo.getJobType(), "")));
            paramList.add(new BasicNameValuePair("locationList", StringUtils.defaultIfBlank(intentVo.getJobLocation(),"")));
            paramList.add(new BasicNameValuePair("posTypeList", StringUtils.defaultIfBlank(intentVo.getJobCode(), "")));
            paramList.add(new BasicNameValuePair("keyword", StringUtils.defaultIfBlank(intentVo.getJobName(), "")));
            paramList.add(new BasicNameValuePair("keywordType", "1"));
            paramList.add(new BasicNameValuePair("keywordAnd", "2"));
            paramList.add(new BasicNameValuePair("authToken", MD5Builder.md5(Constants.API_COMMON_AUTH_KEY, Constants.API_COMMON_AUTH_PASS)));

            */

        //改为只按意向工作地区或意向职位
        if(perResume != null && StringUtils.isNotBlank(perResume.getIntentInfo()) && !StringUtils.equals("{}",perResume.getIntentInfo())) {
            paramList.add(new BasicNameValuePair("authToken", MD5Builder.md5(Constants.API_COMMON_AUTH_KEY, Constants.API_COMMON_AUTH_PASS)));
            try {
                PerIntentVo intentVo = gson.fromJson(perResume.getIntentInfo(), PerIntentVo.class);

                if(StringUtils.isNotBlank(intentVo.getJobLocation())) {

                    paramList.add(new BasicNameValuePair("locationList", StringUtils.defaultIfBlank(intentVo.getJobLocation(),"")));
                }

                if(StringUtils.isNotBlank(intentVo.getJobCode())) {
                    paramList.add(new BasicNameValuePair("posTypeList", StringUtils.defaultIfBlank(intentVo.getJobCode(), "")));
                }
                
                paramList.add(new BasicNameValuePair("manualSort", "1"));
            } catch (JsonSyntaxException e) {
                paramList = Lists.newArrayList();
               // e.printStackTrace();
            }
        }

        return paramList;
    }




    /**
     * 组装更多链接查询条件
     * @param perResume
     * @return
     */
    private String assembleMoreLink(PerResume perResume){
        PerIntentVo intentVo = gson.fromJson(perResume.getIntentInfo(), PerIntentVo.class);
        StringBuffer buf = new StringBuffer();
        buf.append("/s/p/result?propertyList=" + (intentVo.getJobType() != null ? String.valueOf(intentVo.getJobType()) : ""));
        buf.append("&locationList=" + StringUtils.defaultIfBlank(intentVo.getJobLocation(), ""));
        buf.append("&posTypeList=" + StringUtils.defaultIfBlank(intentVo.getJobCode(), ""));
        buf.append("&keyword=" + StringUtils.defaultIfBlank(StringUtils.replace(intentVo.getJobName(), ",", "+"), ""));
        buf.append("&keywordType=1");
        buf.append("&keywordAnd=2");
        return buf.toString();
    }


    /**
     * 根据Id来写日志表log_mail_batch_send
     * @param taskId
     * @param proc
     * @return
     */
    private int getLogId(int taskId,String proc){
        int id = 0;
        try {
            String logSelectSQL = " SELECT lmbs.id FROM LogMailBatchSend lmbs WHERE lmbs.taskId = :taskId AND proc = :proc " +
                    " AND doneFlag = 0 And createDate>=:sDate And createDate<=:eDate ORDER BY id DESC";
            Session session1 = HibernateCountUtil.currentSession();
            Query query = session1.createQuery(logSelectSQL);
            query.setParameter("taskId", taskId);
            query.setParameter("proc", proc);
            query.setParameter("sDate",DateTime.now().secondOfDay().withMinimumValue().toDate());
            query.setParameter("eDate",DateTime.now().secondOfDay().withMaximumValue().toDate());
            query.setMaxResults(1);
            id= NumberUtils.toInt(query.uniqueResult()+"",0);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return id;
    }

    /**
     * 根据Id来写日志表log_mail_batch_send
     * @param id
     * @param beginId
     * @return
     */
    private void updateLogMailBathSend(int id,int beginId,int currentNum , int doneFlag){
        String sql = "UPDATE LogMailBatchSend SET success="+currentNum+", currentNum=" + currentNum +",beginId="+beginId+", doneFlag = "+doneFlag+" WHERE id="+id;
        Session ses = HibernateCountUtil.currentSession();
        ses.createQuery(sql).executeUpdate();
    }



    /**
     * 统计已发送的数量（任务未整体完成的）
     * @param taskId
     * @return
     */
    private Integer countSendNum(Integer taskId,String proc){
        String sendNumSql = " SELECT SUM(success) FROM LogMailBatchSend WHERE taskId=:taskId AND proc=:proc AND doneFlag = 0 ";
        Session sendNumSqlSession = HibernateCountUtil.currentSession();
        Query sendNumQuery = sendNumSqlSession.createQuery(sendNumSql);

        sendNumQuery.setParameter("taskId", taskId);
        sendNumQuery.setParameter("proc", proc);
        sendNumQuery.setMaxResults(1);
        return NumberUtils.toInt(sendNumQuery.uniqueResult()+"",0);
    }


    /**
     * 根据taskId与proc获取日志表中的beginId，PerUser从beginId起查询 START
     * 找不到记录或者是上次任务已跑完,则beginId=0
     * @param taskId
     * @param proc
     * @return
     */
    private Integer getBeginId (Integer taskId,String proc){

        String taskSQL = " FROM LogMailBatchSend WHERE taskId=:taskId AND proc=:proc ORDER BY id DESC";
        Session taskSession = HibernateCountUtil.currentSession();
        Query taskQuery = taskSession.createQuery(taskSQL);
        taskQuery.setParameter("taskId", taskId);
        taskQuery.setParameter("proc", proc);
        taskQuery.setMaxResults(1);
        LogMailBatchSend logMailBatchSend = (LogMailBatchSend)taskQuery.uniqueResult();
        if(logMailBatchSend == null || logMailBatchSend.getDoneFlag() == 1 ){
            return 0;
        }else{
            return NumberUtils.toInt(String.valueOf(logMailBatchSend.getBeginId()),0);
        }


    }



    public int getSendLimitNum() {
        return sendLimitNum;
    }

    public void setSendLimitNum(int sendLimitNum) {
        this.sendLimitNum = sendLimitNum;
    }
}
