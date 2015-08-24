package com.job5156.task.mail;

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.io.Files;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.job5156.beans.freemarker.FreemarkerConfigure;
import com.job5156.beans.mail.BaseMailSend;
import com.job5156.beans.mail.EmailSender;
import com.job5156.common.CommonEnum.MailCount;
import com.job5156.common.CommonEnum.MailServer;
import com.job5156.common.Constants;
import com.job5156.common.exception.EmailServerConfigException;
import com.job5156.common.util.*;
import com.job5156.common.api.SendEmailByWebpowerApi;
import com.job5156.model.logs.LogMailBatchSend;
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
import org.apache.commons.io.FileUtils;
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

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 给应聘职位过少的个人发送职位推荐邮件
 *
 * @author leeton
 *
 */
public class LargePosRecommendToFile extends BaseMailSend{
    private static Logger logger = Logger.getLogger(LargePosRecommendToFile.class);

    private Gson gson;
    private EmailSender sender;
    private static String filePath = "/opt/email/";
    private static String fileNamePrev = "";
    private static int fileNo = 1;         //文件生成序号
    private static int fileRows = 20000;   //1个文件包含的行数
    private static int writeCount = 0;
    private static String crlf =System.getProperty("line.separator");
    private static int sendLimitNum = 150000; //每天最多发送的数量
    private static Long beginRunTime = new Long(0);
    private int pageSize = 1000;


    public LargePosRecommendToFile() throws EmailServerConfigException {
        gson = new Gson();
        sender = new EmailSender(MailServer.MAIN);
        this.setSendTestMailPerNum(10000);
    }

    public LargePosRecommendToFile(MailServer mailServer) throws EmailServerConfigException {
        gson = new Gson();
        sender = new EmailSender(mailServer);
        this.setSendTestMailPerNum(10000);
    }

    public static void main(String[] args) {
        try {

            LargePosRecommendToFile recommend = new LargePosRecommendToFile();
            recommend.setTestMailAddr("yf_198407@163.com", "jmail168@163.com","dghxc@job5156.com","381436695@qq.com");
            setSendLimitNum(150000);
            recommend.send();

            HibernateUtil.closeSession();
            HibernateCountUtil.closeSession();
        } catch (EmailServerConfigException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void send() {
//        logger.error("调试，暂时停一天发送。");
        //return;
        Date date1 = DateTime.now().minusDays(15).toDate();
        this.sendMailByIntervalDays(date1, -175, Constants.MAIL_TASK_SYSTEM_POS_RECOMMEND_WPAPI_P3, "P1"); //15-175
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
        beginRunTime = new Date().getTime();
        DateTime beginTime = DateTime.now();
        Date loginDate = DateUtils.addDays(date, intervalDays);
        Map<String, Integer> statusMap = Maps.newHashMap();
        int dataLoadNumber = pageSize;

        int todayRunTimes = getTodayRunTimes(taskId,proc);
        fileNamePrev =  "pos-email-" + DateTime.now().toLocalDate().toString() + "-" +"t"+ todayRunTimes + "-" + proc + "-" ;

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
        statusMap.put(MailCount.SEND_LIMIT_NUM.getType(),sendLimitNum);
        LogMailBatchSend logMailBatchSend =  this.saveLog(statusMap, taskId, Constants.sendMailTaskType.get(taskId),proc);
        Integer logId = NumberUtils.toInt(logMailBatchSend.getId()+"", 0);

        logger.error("TASKID:" + taskId +", 本次任务符合条件的记录总数为 (allRecord):"  + allRecord +" 限制最大发送数：" + getSendLimitNum());
        if (allRecord > 0 ) {

            int allPage = 1;
            if (allRecord > dataLoadNumber) {
                allPage = allRecord / dataLoadNumber + ((allRecord % dataLoadNumber == 0) ? 0 : 1);
            }
            try {
                for (int i = 0; i < allPage; i++) {
                    if(i*dataLoadNumber == sendLimitNum) {
                        statusMap.put("doneFlag", Constants.MAIL_SEND_WAIT);
                        break;
                    }

                    query = session.createQuery(hql);
                    query.setParameter("beginLoginDate", beginLoginDate);
                    query.setParameter("endLoginDate", endLoginDate);
                    query.setParameter("beginId", beginId);
                    query.setFirstResult(i * dataLoadNumber);
                    query.setMaxResults((allRecord<=dataLoadNumber)?allRecord:dataLoadNumber);

                    List<PerUser> userList = query.list();

                    this.userEmailToFile(logId,userList, statusMap, taskId, proc);
                    session.clear();
                }

            } catch (Exception e) {
                logger.error(Constants.sendMailTaskType.get(taskId)+ e.getMessage(), e);
            }
        }

        Integer countSendNum = countSendNum(taskId,proc);
        if(countSendNum >= allRecord){
            statusMap.put("doneFlag", Constants.MAIL_SEND_SUCCESS);
        }

        // 更新日志
        statusMap.put("id",logId);
        this.saveLog(statusMap, taskId,  Constants.sendMailTaskType.get(taskId) , proc);
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
     * 邮件内容保存到CSV文件
     * @param userList
     * @param statusMap
     * @throws IOException
     */
    private void userEmailToFile(int logId,List<PerUser> userList, Map<String, Integer> statusMap,Integer taskId,String proc) throws IOException {

        StringBuffer mailContentBuf = new StringBuffer(1024);
        if (CollectionUtils.isNotEmpty(userList)) {

            for (PerUser perUser : userList) {
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
                statusMap.put(MailCount.BEGIN_ID.getType(),perUser.getId()); //记录当前个人ID，以备下次运行从这个ID开始读取数据
                writeCount++;
                //生成邮件变量的模式
                String mailContent = this.assembleMailContentToFileByParam(perUser, statusMap);
                if (writeCount == getSendTestMailPerNum()) {  //每1万笔，追加测试邮件
                    appendTestMail(mailContent);
                    Long setpEndTime = new Date().getTime();
                    logger.error("==== 取得1万笔有效数据所花费的时间(秒):" +(setpEndTime - beginRunTime)/1000);
                    beginRunTime = setpEndTime;
                }
                if (StringUtils.isNotBlank(mailContent)) {
                    mailContentBuf.append(mailContent);
                    mailContentBuf.append(crlf);
                    mailContent = "";
                }else{
                    continue;
                }

                this.addMailCount(statusMap, MailCount.SEND_SUCCESS);

                String fileName = fileNamePrev + fileNo +".csv";

                if(writeCount % 10 == 0) {
                    updateLogMailBathSend(logId, perUser.getId(), writeCount, Constants.MAIL_SEND_WAIT); //记录当前PERUSER ID
                }
                if ((writeCount % 400 == 0) || writeCount == fileRows ) {//文件写入太慢，改为每 400 条写入一次
//                   String filePath = "d:/email/";
                    boolean isSave = save2fileByParam(filePath, fileName, mailContentBuf.toString());
                    mailContentBuf.setLength(0);
                    if (isSave || writeCount == fileRows  ) {
                        logger.error("current writeCount :" + writeCount  + "  fileRows = " +fileRows);
                        if (writeCount >= fileRows || userList.size() < pageSize) {
                            writeCount = 0;
                            //logger.error("START CALL API TO SEND MAIL :" + filePath + fileName);
                            boolean isSend = SendEmailByWebpowerApi.getInstance().sendByCSV(fileName);
//                            boolean isSend = true;
                            if (isSend) {
                                fileNo++;
                                logger.error("SEND MAIL BY CSV DONE:" + filePath + fileName);
                            }
                        }
                    }

                }

                 /*
                      整个邮件文件内容一起发送的模式
                String mailContent = this.assembleMailContent(perUser, statusMap);
                if (StringUtils.isNotBlank(mailContent)) {
                    String testMail = "290413939@qq.com";
                    save2file(testMail,  URLEncoder.encode(mailContent,"utf-8"));
                }*/

            }

        }
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
     * 组装邮件内容到CSV格式
     * @param perUser
     * @param statusMap
     * @return
     * @throws IOException
     */
    private String assembleMailContentToFileByParam(PerUser perUser, Map<String, Integer> statusMap) throws IOException {
        StringBuffer buffer = new StringBuffer();
        Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();
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
            int dateInterval = Days.daysBetween(new DateTime(perUser.getLoginDate()), DateTime.now()).getDays();

            //设置数据到file vo
            EmailToFilevo vo = new EmailToFilevo();

            List<EmailToFilevo.Position> positions = Lists.newArrayList();
            List<String> jsonObjectList = Lists.newArrayList();

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

/*
                默认格式的CSV文件，才用到
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("posNo",comPosVo.getPosNo().toString());
                jsonObject.addProperty("posName",comPosVo.getPosNo().toString());
                jsonObject.addProperty("comNam",comPosVo.getCompany().getComName());
                jsonObject.addProperty("workLocationStr",comPosVo.getPosition().getWorkLocationStr());
                jsonObject.addProperty("reqWorkYearStr",comPosVo.getPosition().getReqWorkYearStr());
                jsonObject.addProperty("reqDegreeStr",comPosVo.getPosition().getReqDegreeStr());
                jsonObject.addProperty("refreshDate",new DateTime(comPosVo.getPosition().getRefreshDate()).toString("yyyy-MM-dd"));
                jsonObjectList.add(jsonObject.toString().replaceAll("\"","'").replaceAll("\\\\",""));
                */
            }
            vo.setPositionList(positions);


/*            //默认格式的CSV格式  （逗号分隔，双引号包围内容）
            buffer.append("\"" + testMail + "\",");
           // buffer.append("\"" + perUser.getEmail() + "\",");
            buffer.append("\"" + perUser.getUserName() + "\",");
            buffer.append("\"" + dateInterval + "\",");
            buffer.append("\"" + morePosLink + "\",");
            buffer.append("\"" + unsubscribeLink + "\",");
            buffer.append("\"http://www.job5156.com\",");
            buffer.append("\"http://s.job5156.com\",");
            buffer.append(gson.toJson(jsonObjectList.toString(),String.class));*/

            //CSV格式  （|为分隔符，^号为包围符）
//            String testMail="290413939@qq.com";
//            buffer.append(testMail);
            String email = perUser.getEmail();
            StringUtils.replace(email,";",","); //旧版的数据email可以填多个存在类似 378067453@qq.com;hui.meng@cnlq.com.cn 的字串
            buffer.append(email);
            buffer.append(Constants.CSV_SEPARATOR + perUser.getUserName() );
            buffer.append(Constants.CSV_SEPARATOR + dateInterval );
            buffer.append(Constants.CSV_SEPARATOR + morePosLink);
            buffer.append(Constants.CSV_SEPARATOR + unsubscribeLink);
            buffer.append(Constants.CSV_SEPARATOR + "http://www.job5156.com");
            buffer.append(Constants.CSV_SEPARATOR + "http://s.job5156.com");
            buffer.append(Constants.CSV_SEPARATOR + gson.toJson(vo.getPositionList(), List.class));
        }
        return buffer.toString();
    }

    /**
     * 邮件的内容变量保存到一个CSV文件
     * @param content
     */
    private  boolean save2fileByParam(String filePath,String fileName,String content){

            String fileParamTitle ="";
            File dir = FileUtils.getFile(filePath);
            File file = FileUtils.getFile(filePath, fileName);
            try {
                if (!dir.exists()) {
                    dir.mkdir();
                }
                if (!file.exists()) {
                    Files.newWriter(file, Charsets.UTF_8);
                    logger.error(" Create a new file success :" + filePath + fileName);
                }

                String line = Files.readFirstLine(file, Charsets.UTF_8);
                if (StringUtils.isBlank(line)) {//第三方接口的平台变量字段名全为小写
                    fileParamTitle = "email" + Constants.CSV_SEPARATOR
                            + "username" + Constants.CSV_SEPARATOR
                            + "dateinterval" + Constants.CSV_SEPARATOR
                            + "moreposlink" + Constants.CSV_SEPARATOR
                            + "unsubscribelink" + Constants.CSV_SEPARATOR
                            + "visit_domain" + Constants.CSV_SEPARATOR
                            + "search_domain" + Constants.CSV_SEPARATOR
                            + "poslist" + crlf;
                    Files.append(fileParamTitle, file, Charsets.UTF_8);
                    Files.append(content, file, Charsets.UTF_8);
                } else {
                    Long begingTime = new Date().getTime();
                    Files.append(content, file, Charsets.UTF_8);
                    Long endTime = new Date().getTime();
                    logger.error(" ======> WRITE FILE TO DISK USED TIME (milliseconds) ="+ (endTime - begingTime));
                }
                return true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        return false;

    }

    private  void save2file(String email,String content){

        String fileParamTitle ="";
        String fileName = "pos-email-"+DateTime.now().toLocalDate().toString()+".csv";
        String filePath = "/opt/email/";
        String crlf =System.getProperty("line.separator");
        File dir = FileUtils.getFile(filePath);
        File file = FileUtils.getFile(filePath, fileName);
        try {
            if (!dir.exists()) {
                dir.mkdir();
            }
            if (!file.exists()) {
                Files.newWriter(file, Charsets.UTF_8);
                //logger.error("file to create!");
            }

            String line = Files.readFirstLine(file,Charsets.UTF_8);
            if (StringUtils.isBlank(line)) {//第三方接口的平台变量字段名全为小写
                fileParamTitle = "email,"+"content"+crlf;
                Files.append(fileParamTitle, file, Charsets.UTF_8);
            } else {
                Files.append(email +","+content+crlf, file, Charsets.UTF_8);
            }
        } catch (IOException e) {
            logger.error(" EMAIL save to "+filePath +fileName + "on Error.");
            e.printStackTrace();
        }

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


    private StringBuffer appendTestMail(String content){

        StringBuffer testStr = new StringBuffer();
        testStr.append(content).append(crlf);
        String subs = StringUtils.substring(content, StringUtils.indexOf(content, Constants.CSV_SEPARATOR), content.length());
        for (String email : getTestMailAddr()) {
            testStr.append(email).append(subs).append(crlf);
        }
        return  testStr;

    }

    /**
     * 取得最后一次的发送记录ID
     * @param id
     * @param beginId
     * @return
     */
    private int getLastLogId(int taskId, String proc){
        int id = 0;
        try {
            String logSelectSQL = " SELECT lmbs.id FROM LogMailBatchSend lmbs WHERE lmbs.taskId = :taskId AND proc = :proc " +
                    " AND doneFlag = 0 ORDER BY id DESC";
            Session session1 = HibernateCountUtil.currentSession();
            Query query = session1.createQuery(logSelectSQL);
            query.setParameter("taskId", taskId);
            query.setParameter("proc", proc);
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
     * 统计从上一次完整发送以后的，发送的数量（任务未整体完成的）
     * @param taskId
     * @return
     */
    private Integer countSendNum(Integer taskId,String proc){

        Session sendNumSqlSession = HibernateCountUtil.currentSession();
        String lastDoneRecnSql = " SELECT id from LogMailBatchSend where doneFlag = 1 ORDER BY id desc ";  //上一次完整发送的记录ID
        Query sendNumQuery = sendNumSqlSession.createQuery(lastDoneRecnSql);
        sendNumQuery.setMaxResults(1);
        Integer lastDoneRecn = NumberUtils.toInt(sendNumQuery.uniqueResult()+"",0);

        String sendNumSql = " SELECT SUM(success) FROM LogMailBatchSend WHERE taskId=:taskId AND proc=:proc AND doneFlag = 0 AND id > :id";
        sendNumQuery = sendNumSqlSession.createQuery(sendNumSql);
        sendNumQuery.setParameter("taskId", taskId);
        sendNumQuery.setParameter("proc", proc);
        sendNumQuery.setParameter("id", lastDoneRecn);
        sendNumQuery.setMaxResults(1);
        return NumberUtils.toInt(sendNumQuery.uniqueResult()+"",0);
    }

    private int getTodayRunTimes(Integer taskId,String proc){
        String hql = " SELECT COUNT(*) FROM LogMailBatchSend WHERE createDate >= :beginTime AND taskId = :taskId ";
        if(StringUtils.isNotBlank(proc)){
            hql += " AND proc ='" + proc +"'";
        }
        Session ses = HibernateCountUtil.currentSession();
        Query query = ses.createQuery(hql);
        Date beginTime = DateTime.now().secondOfDay().withMinimumValue().toDate();
        query.setParameter("beginTime",beginTime);
        query.setParameter("taskId",taskId);
        int count= NumberUtils.toInt(query.uniqueResult()+"",0);
        ses.clear();
        return count;
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

    public static int getSendLimitNum() {
        return sendLimitNum;
    }

    public static void setSendLimitNum(int sendLimitNum) {
        LargePosRecommendToFile.sendLimitNum = sendLimitNum;
    }
}
