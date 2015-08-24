package com.job5156.task.mail;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Hours;

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
import com.job5156.common.exception.EmailServerConfigException;
import com.job5156.common.util.HibernateCountUtil;
import com.job5156.common.util.HibernateUtil;
import com.job5156.common.util.JsonValidator;
import com.job5156.common.util.MD5Builder;
import com.job5156.model.per.PerResume;
import com.job5156.model.per.PerUser;
import com.job5156.vo.api.PosSearchResult;
import com.job5156.vo.api.PosSearchResult.ComPosVo;
import com.job5156.vo.mail.PosRecommendMailVo;
import com.job5156.vo.per.PerIntentVo;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * <p>
 * 系统根据个人求职意向发送职位推荐邮件
 * </p>
 * 
 * @author leo
 * 
 */
public class SystemPosRecommend extends BaseMailSend{
	private static Logger logger = Logger.getLogger(SystemPosRecommend.class);

	private Gson gson;
	private EmailSender sender;
	
	public SystemPosRecommend() throws EmailServerConfigException {
		gson = new Gson();
		sender = new EmailSender(MailServer.MAIN);
		this.setSendTestMailPerNum(2000);
	}

	public SystemPosRecommend(MailServer mailServer) throws EmailServerConfigException {
		gson = new Gson();
		sender = new EmailSender(mailServer);
		this.setSendTestMailPerNum(2000);
	}

	public static void main(String[] args) {
		try {
			SystemPosRecommend recommend = new SystemPosRecommend();
			recommend.send();
			HibernateUtil.closeSession();
			HibernateCountUtil.closeSession();
		} catch (EmailServerConfigException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void send() {
		Date date = new Date();
        this.sendMailByIntervalDays(date, -1, Constants.MAIL_TASK_SYSTEM_POS_RECOMMEND_D1);
        this.sendMailByIntervalDays(date, -3, Constants.MAIL_TASK_SYSTEM_POS_RECOMMEND_D3);
        this.sendMailByIntervalDays(date, -7, Constants.MAIL_TASK_SYSTEM_POS_RECOMMEND_D7);
        this.sendMailByIntervalDays(date, -15, Constants.MAIL_TASK_SYSTEM_POS_RECOMMEND_D15);
    }

	/**
	 * 根据发送策略查询用户列表
	 * 
	 * @param intervalDays
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public void sendMailByIntervalDays(Date date, Integer intervalDays,Integer taskId) {
		logger.error("[系统根据求职意向发送职位推荐邮件("+Math.abs(intervalDays)+"天未登陆)]开始发送...");
		DateTime beginTime = DateTime.now();
		
		Date loginDate = DateUtils.addDays(date, intervalDays);
		Map<String, Integer> statusMap = Maps.newHashMap();
		int dataLoadNumber = 1000;

		String hql = "FROM PerUser p WHERE p.loginDate > :beginLoginDate AND p.loginDate < :endLoginDate";
		String countHql = "SELECT COUNT(p.id) FROM PerUser p WHERE p.loginDate > :beginLoginDate AND p.loginDate < :endLoginDate";

		Date beginLoginDate = new DateTime(loginDate).secondOfDay().withMinimumValue().toDate();
		Date endLoginDate = new DateTime(loginDate).secondOfDay().withMaximumValue().toDate();

		Session session = HibernateUtil.currentSession();
		Query query = session.createQuery(countHql);
		query.setParameter("beginLoginDate", beginLoginDate);
		query.setParameter("endLoginDate", endLoginDate);
		int allRecord = ((Long) query.uniqueResult()).intValue();
		statusMap.put(MailCount.TOTAL.getType(), allRecord);
		
		if (allRecord > 0) {
			int allPage = 1;
			if (allRecord > dataLoadNumber) {
				allPage = allRecord / dataLoadNumber + ((allRecord % dataLoadNumber == 0) ? 0 : 1);
			}
			try {
				for (int i = 0; i < allPage; i++) {
					query = session.createQuery(hql);
					query.setParameter("beginLoginDate", beginLoginDate);
					query.setParameter("endLoginDate", endLoginDate);
					query.setFirstResult(i * dataLoadNumber);
					query.setMaxResults(dataLoadNumber);

					List<PerUser> userList = query.list();
					this.sendUserMail(userList, statusMap);
					session.clear();
				}
			} catch (IOException e) {
				e.printStackTrace();
				logger.error("===系统发送职位推荐邮件异常：" + e.getMessage(), e);
			}
		}
		
		DateTime endTime = DateTime.now();
		String logMessage = Constants.sendMailTaskType.get(taskId)
						  + "总计应发：" + NumberUtils.toInt(String.valueOf(statusMap.get(MailCount.TOTAL.getType())), 0) + "，"
						  + "邮件地址过滤：" + NumberUtils.toInt(String.valueOf(statusMap.get(MailCount.EMAIL_ADDR_FILTER.getType())), 0) + "，"
						  + "职位列表不足：" + NumberUtils.toInt(String.valueOf(statusMap.get(MailCount.POS_NUM_NOT_ENOUGH.getType())), 0) + "，"
						  + "简历不存在：" + NumberUtils.toInt(String.valueOf(statusMap.get(MailCount.PER_RESUME_NOT_EXIST.getType())), 0) + "，"
						  + "未填求职意向：" + NumberUtils.toInt(String.valueOf(statusMap.get(MailCount.NOT_FILL_PER_INTENT.getType())), 0) + "，"
						  + "发送成功：" + NumberUtils.toInt(String.valueOf(statusMap.get(MailCount.SEND_SUCCESS.getType())), 0) + "，"
						  + "发送失败：" + NumberUtils.toInt(String.valueOf(statusMap.get(MailCount.SEND_FAIL.getType())), 0) + "，"
						  + "共耗时：" + Hours.hoursBetween(beginTime, endTime).getHours() + "小时";
		logger.error(logMessage);
		
		// 记录日志
		this.saveLog(statusMap, taskId, Constants.sendMailTaskType.get(taskId),"");
		statusMap = null;
	}

	/**
	 * 发送邮件信息
	 * 
	 * @param userList
	 * @param statusMap
	 * @throws IOException
	 */
	private void sendUserMail(List<PerUser> userList, Map<String, Integer> statusMap) throws IOException {
		if (CollectionUtils.isNotEmpty(userList)) {
			for (PerUser perUser : userList) {
				if(!this.checkMailSend(perUser, Constants.MAIL_TASK_SYSTEM_POS_RECOMMEND)){
					this.addMailCount(statusMap, MailCount.EMAIL_ADDR_FILTER);
					continue;
				}
				String mailContent = this.assembleMailContent(perUser, statusMap);
				if (StringUtils.isNotBlank(mailContent)) {
					try {
                        //String[] toAddr = StringUtils.split(perUser.getEmail(), Constants.MAIL_ADDRESS_SEPARATE_CHAR);
                        String email = getOneVaildEmail(perUser.getEmail());
                        if(StringUtils.isBlank(email)){
                            this.addMailCount(statusMap, MailCount.EMAIL_ADDR_FILTER);
                            continue;
                        }
                        String[] toMail = new String[]{ email};        
                        boolean flag = sender.send(new PosRecommendMailVo(mailContent, toMail, Constants.MAIL_TYPE_SIMPLIFIED));
                        if(flag){
							this.addMailCount(statusMap, MailCount.SEND_SUCCESS);
						}else{
							this.addMailCount(statusMap, MailCount.SEND_FAIL);
						}
						Thread.sleep(500);
					} catch (Exception e) {
                        this.addMailCount(statusMap, MailCount.SEND_FAIL);
						e.printStackTrace();
					}
					
					/**发送测试邮件**/
					this.addSendNum();
					if(this.getSendNum() % this.getSendTestMailPerNum() == 0){
						sender.send(new PosRecommendMailVo(mailContent, this.getTestMailAddr(), Constants.MAIL_TYPE_SIMPLIFIED));
					}
				}else{
					this.addMailCount(statusMap, MailCount.SEARCHER_IS_EMPTY);
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
                statusMap.put(MailCount.ERROR_USER_ID.getType(),+perUser.getId());
				return StringUtils.EMPTY;
			}
			
			if(comPosList.size() > 10){
				comPosList = comPosList.subList(0, 10);
			}
			String morePosLink = this.assembleMoreLink(perResume);
			String unsubscribeLink = this.assembleUnsubscribeLink(perUser, Constants.MAIL_TASK_SYSTEM_POS_RECOMMEND);
			
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
		List<ComPosVo> posList = null;
		String jsonStr = StringUtils.EMPTY;
        if(userId == null || CollectionUtils.isEmpty(httpParamList)){
            return posList;
        }
        
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpost = new HttpPost(Constants.API_POS_SEARCH_URL);
        httpost.setEntity(new UrlEncodedFormEntity(httpParamList, Consts.UTF_8));
		try {
			HttpResponse response = httpClient.execute(httpost);
			HttpEntity entity = response.getEntity();
			if (entity != null ) {
				jsonStr = EntityUtils.toString(entity, "utf-8");
				JsonValidator jsonValid = new JsonValidator();
				if(jsonValid.validate(jsonStr)){
					EntityUtils.consume(entity);
					PosSearchResult result = gson.fromJson(jsonStr, PosSearchResult.class); 
					if (result.isSuccess()) {
						posList = result.getDataList();
					} else {
						logger.error("===调用接口查询匹配求职意向职位列表失败：" + StringUtils.join(result.getErrorList(), ";") + "====USERID:" + userId);
					}
				}else{
					 return posList;
				}
			}
			httpost.releaseConnection();
			httpost = null;
		} catch (Exception e) {
			logger.error("===调用接口查询匹配求职意向职位列表异常：" + e.getMessage(), e);
			logger.error("USERID:" + userId);
			logger.error(jsonStr);
		} finally {
			try {
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return posList;
	}

	/**
	 * 封装搜索查询参数
	 * 
	 * @param perResume
	 * @return
	 */
	private List<NameValuePair> assemblePosSearchParam(PerResume perResume) {
		List<NameValuePair> paramList = Lists.newArrayList();
        try {
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
                paramList.add(new BasicNameValuePair("manualSort", "1"));
                paramList.add(new BasicNameValuePair("authToken", MD5Builder.md5(Constants.API_COMMON_AUTH_KEY, Constants.API_COMMON_AUTH_PASS)));
            }
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            paramList = Lists.newArrayList();
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
}
