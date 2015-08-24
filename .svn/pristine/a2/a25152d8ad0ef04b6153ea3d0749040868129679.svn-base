package com.job5156.task.mail;

import com.dmdelivery.webservice.RecipientNameValuePairType;
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
import com.job5156.common.api.SendEmailByWebpowerApi;
import com.job5156.common.exception.EmailServerConfigException;
import com.job5156.common.util.*;
import com.job5156.model.per.PerResume;
import com.job5156.model.per.PerUser;
import com.job5156.vo.api.PosSearchResult;
import com.job5156.vo.api.PosSearchResult.ComPosVo;
import com.job5156.vo.file.EmailToFilevo;
import com.job5156.vo.per.PerIntentVo;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.ObjectUtils;
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
import org.hibernate.Query;
import org.hibernate.Session;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Hours;

import java.io.IOException;
import java.io.StringWriter;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 给应聘职位过少的个人发送职位推荐邮件
 * 业务规则：当用户连续两天投递简历总量少于30份时，第二天自动发送邮件提醒
 *
 * @author leeton
 *
 */
@SuppressWarnings("deprecation")
public class PerLessApply extends BaseMailSend{
    private static Logger logger = Logger.getLogger(PerLessApply.class);

    private Gson gson;
    private EmailSender sender;
    private static int sendLimitNum = 150000; //每天最多发送的数量
    private int pageSize = 1000;


    public PerLessApply() throws EmailServerConfigException {
        gson = new Gson();
        sender = new EmailSender(MailServer.MAIN);
        this.setSendTestMailPerNum(10000);
    }

    public PerLessApply(MailServer mailServer) throws EmailServerConfigException {
        gson = new Gson();
        sender = new EmailSender(mailServer);
        this.setSendTestMailPerNum(10000);
    }

    public static void main(String[] args) {
        try {

            PerLessApply recommend = new PerLessApply();
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
        this.sendMailByIntervalDays(DateTime.now().toDate(), -2,Constants.MAIL_TASK_PER_LESS_APPLY_SEND_POS);
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

        String  applySql =  " SELECT per_user_id FROM per_pos_apply WHERE cre_time >= :endDate " +
                " AND cre_time < :startDate GROUP BY per_user_id Having sum(apply_num) < 30 " ;
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
                Map<String, String> contentMap = this.assembleMailContentMap(perUser, statusMap, taskId);
                if (MapUtils.isNotEmpty(contentMap)) {
                    Map<String, Object> paramMap = Maps.newHashMap();
                    paramMap.put("userName", perUser != null ? perUser.getUserName() : "");
                    String email = getOneVaildEmail(perUser.getEmail());
                    if (StringUtils.isBlank(email)) {
                        this.addMailCount(statusMap, MailCount.EMAIL_ADDR_FILTER);
                        continue;
                    }
                    int campaignId = 6;   //活动ID
                    int mailingId = 40;   //邮件ID
                    int groupId = 81;     //组ID
                    try {
                        //email = "290413939@qq.com";
                        recipientParam = new RecipientNameValuePairType[]{
                                new RecipientNameValuePairType("email", email),
                                new RecipientNameValuePairType("username", perUser.getUserName()),
                                new RecipientNameValuePairType("poslist", contentMap.get("poslist")),
                                new RecipientNameValuePairType("unsubscribelink", contentMap.get("unsubscribeLink")),
                                new RecipientNameValuePairType("moreposlink",contentMap.get("morePosLink")),
                        };
                        boolean flag = SendEmailByWebpowerApi.getInstance().sendSingleMailing(recipientParam, campaignId, mailingId, groupId);
                        if (flag) {
                            this.addMailCount(statusMap, MailCount.SEND_SUCCESS);
                        } else {
                            this.addMailCount(statusMap, MailCount.SEND_FAIL);
                            if(getSendNum() < 100){
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
                } else {
                    this.addMailCount(statusMap, MailCount.SEARCHER_IS_EMPTY);
                }
            }
        }
    }

    private Map<String, String> assembleMailContentMap(PerUser perUser, Map<String, Integer> statusMap,Integer taskId) throws IOException {
        Map<String, String> map = Maps.newHashMap();
        if (perUser != null) {
            PerResume perResume = perUser.getDefaultPerResume();
            if(perResume == null){
                this.addMailCount(statusMap, MailCount.PER_RESUME_NOT_EXIST);
                return map;
            }

            List<NameValuePair> httpParamList = this.assemblePosSearchParam(perResume);
            if(CollectionUtils.isEmpty(httpParamList)){
                this.addMailCount(statusMap, MailCount.NOT_FILL_PER_INTENT);
                return map;
            }

            List<ComPosVo> comPosList = this.getPosListByUserIntent(perUser.getId(), httpParamList);
            if(CollectionUtils.isEmpty(comPosList) || comPosList.size() == 0){
                this.addMailCount(statusMap, MailCount.POS_NUM_NOT_ENOUGH);
                return map;
            }

            if(comPosList.size() > 10){
                comPosList = comPosList.subList(0, 10);
            }
            String morePosLink = this.assembleMoreLink(perResume);
            String unsubscribeLink = this.assembleUnsubscribeLink(perUser, taskId);

            //设置数据到file vo
            EmailToFilevo vo = new EmailToFilevo();

            List<EmailToFilevo.Position> positions = Lists.newArrayList();
            for (ComPosVo comPosVo : comPosList) {
                EmailToFilevo.Position position = new EmailToFilevo.Position();

                if (comPosVo.getCompany() == null || comPosVo.getPosition() == null) continue;
                //邮件布局限制：职位名称长度10字，公司名长度：14字
                if (comPosVo.getPosition().getPosName() != null && StringUtils.isNotBlank(comPosVo.getPosition().getPosName())) {
                    String posName = comPosVo.getPosition().getPosName();
                    posName = posName.replaceAll("（", "(").replaceAll("）", ")").replaceAll("【", "[").replaceAll("】", "]");
                    posName = StringUtils.abbreviate(posName, 10);
                    position.setPosName(posName);
                } else {
                    continue;
                }
                if (comPosVo.getCompany().getComName() != null && StringUtils.isNotBlank(comPosVo.getCompany().getComName())) {
                    String comName = comPosVo.getCompany().getComName();
                    comName = comName.replaceAll("（", "(").replaceAll("）", ")").replaceAll("【", "[").replaceAll("】", "]");
                    comName = StringUtils.abbreviate(comName, 14);
                    position.setComName(comName);
                } else {
                    continue;
                }
                position.setPosNo(comPosVo.getPosNo().toString());
                position.setComId(comPosVo.getCompany().getId().toString());
                position.setWorkLocationStr(comPosVo.getPosition().getWorkLocationStr());
                position.setReqWorkYearStr(comPosVo.getPosition().getReqWorkYearStr());
                position.setReqDegreeStr(comPosVo.getPosition().getReqDegreeStr());
                position.setRefreshDate(new DateTime(comPosVo.getPosition().getRefreshDate()).toString("yyyy-MM-dd"));
                positions.add(position);
            }
            vo.setPositionList(positions);


            map.put("poslist", gson.toJson(vo.getPositionList(), List.class));
            map.put("morePosLink", morePosLink);
            map.put("unsubscribeLink", unsubscribeLink);

        }
        return map;
    }


    /**
     * 组装邮件内容
     *
     * @param perUser
     * @return
     * @throws java.io.IOException
     */
    private String assembleMailContent(PerUser perUser, Map<String, Integer> statusMap,Integer taskId) throws IOException {
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
            String unsubscribeLink = this.assembleUnsubscribeLink(perUser, taskId);

            Map<String, Object> map = Maps.newHashMap();
            map.put("comPosList", comPosList);
            map.put("perUser", perUser);
            map.put("dateInterval", Days.daysBetween(new DateTime(perUser.getLoginDate()), DateTime.now()).getDays());
            map.put("morePosLink", morePosLink);
            map.put("unsubscribeLink", unsubscribeLink);

            Configuration configure = FreemarkerConfigure.getFreemarkerConfig();
            Template template = configure.getTemplate("mail/third/per_less_apply.ftl");

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



    public static int getSendLimitNum() {
        return sendLimitNum;
    }

    public static void setSendLimitNum(int sendLimitNum) {
        PerLessApply.sendLimitNum = sendLimitNum;
    }
}
