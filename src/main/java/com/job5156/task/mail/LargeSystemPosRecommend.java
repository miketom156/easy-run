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

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.job5156.beans.freemarker.FreemarkerConfigure;
import com.job5156.beans.mail.BaseMailSend;
import com.job5156.beans.mail.EmailSender;
import com.job5156.common.CommonEnum.MailCount;
import com.job5156.common.CommonEnum.MailServer;
import com.job5156.common.Constants;
import com.job5156.common.exception.EmailServerConfigException;
import com.job5156.common.util.HibernateCountUtil;
import com.job5156.common.util.HibernateUtil;
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
 * 大量发送职位推荐邮件
 * </p>
 * 
 * @author leo
 *
 */
@SuppressWarnings("deprecation")
@Deprecated
public class LargeSystemPosRecommend extends BaseMailSend{
	private static Logger logger = Logger.getLogger(LargeSystemPosRecommend.class);

	private Gson gson;
	private EmailSender sender;

	public LargeSystemPosRecommend() throws EmailServerConfigException {
		gson = new Gson();
		sender = new EmailSender(MailServer.MAIN);
		this.setSendTestMailPerNum(20000);
	}

	public LargeSystemPosRecommend(MailServer mailServer) throws EmailServerConfigException {
		gson = new Gson();
		sender = new EmailSender(mailServer);
		this.setSendTestMailPerNum(20000);
	}

	public static void main(String[] args) {
		try {
			LargeSystemPosRecommend recommend = new LargeSystemPosRecommend();
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
        Date date2 = new DateTime(date1).minusDays(274).toDate();
		this.sendMailByIntervalDays(date1, -274,Constants.MAIL_TASK_SYSTEM_POS_RECOMMEND_LARGE_P1,"进程1");
		this.sendMailByIntervalDays(date2, -274,Constants.MAIL_TASK_SYSTEM_POS_RECOMMEND_LARGE_P2,"进程2");
	}

	/**
	 * 根据发送策略查询用户列表
	 *
	 * @param intervalDays
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public void sendMailByIntervalDays(Date date, Integer intervalDays,Integer taskId,String proc) {
		logger.error("[大量发送职位推荐邮件("+Math.abs(intervalDays)+"天未登陆)]开始发送...");
		DateTime beginTime = DateTime.now();

		Date loginDate = DateUtils.addDays(date, intervalDays);
		Map<String, Integer> statusMap = Maps.newHashMap();
		int dataLoadNumber = 1000;

		//根据taskId与doneFlag=0获取日志表中的beginId，PerUser从beginId起查询 START
		String taskSQL = "SELECT beginId FROM LogMailBatchSend WHERE taskId=:taskId AND proc=:proc AND doneFlag = 0 ";
		Session taskSession = HibernateCountUtil.currentSession();
		Query taskQuery = taskSession.createQuery(taskSQL);
		taskQuery.setParameter("taskId", taskId);
		taskQuery.setParameter("proc", proc);
		int beginId = NumberUtils.toInt(taskQuery.uniqueResult()+"",0);
		
		StringBuilder hql = new StringBuilder();
		hql.append("FROM PerUser p WHERE ");
		StringBuilder countHql = new StringBuilder();
		countHql.append("SELECT COUNT(p.id) FROM PerUser p WHERE ");
		if(beginId > 0){
			hql.append("id > :beginId AND ");
			countHql.append("id > :beginId AND ");
		}
		//END
		hql.append("p.loginDate > :beginLoginDate AND p.loginDate < :endLoginDate ORDER BY id");
		countHql.append("p.loginDate > :beginLoginDate AND p.loginDate < :endLoginDate ");
		Date beginLoginDate = new DateTime(loginDate).secondOfDay().withMinimumValue().toDate();
		Date endLoginDate = new DateTime(date).secondOfDay().withMaximumValue().toDate();

		Session session = HibernateUtil.currentSession();
		Query query = session.createQuery(countHql.toString());
		query.setParameter("beginLoginDate", beginLoginDate);
		query.setParameter("endLoginDate", endLoginDate);
		if(beginId > 0){
			query.setParameter("beginId", beginId);
		}
		int allRecord = ((Long) query.uniqueResult()).intValue();
		statusMap.put(MailCount.TOTAL.getType(), allRecord);
		if (allRecord > 0 ) {
			//计数器，如果发邮件出现异常时没有发送完成，计下当前已经发送到了哪一条
			int count = 0;
			int allPage = 1;
			if (allRecord > dataLoadNumber) {
				allPage = allRecord / dataLoadNumber + ((allRecord % dataLoadNumber == 0) ? 0 : 1);
			}
			try {
				for (int i = 0; i < allPage; i++) {
					query = session.createQuery(hql.toString());
					query.setParameter("beginLoginDate", beginLoginDate);
					query.setParameter("endLoginDate", endLoginDate);
					if(beginId > 0){
						query.setParameter("beginId", beginId);
					}
					query.setFirstResult(i * dataLoadNumber);
					query.setMaxResults(dataLoadNumber);

					List<PerUser> userList = query.list();
					this.sendUserMail(session,userList, statusMap,count,intervalDays,taskId,proc);
					//每1000次跑完，需要把beginId写入日志表
					if(count % dataLoadNumber != 0){
						//日志Id
						int id = Integer.valueOf(statusMap.get("id"));
						PerUser user = userList.get(count % dataLoadNumber);
						saveLogMailBathSend(id,user.getId(),proc);
					}
					session.clear();
				}
					
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("===大量发送职位推荐邮件：" + e.getMessage(), e);
			}
		}

		DateTime endTime = DateTime.now();
		String logMessage =  Constants.sendMailTaskType.get(taskId)
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
		statusMap.put("doneFlag",  Constants.MAIL_SEND_SUCCESS);
		this.saveLog(statusMap, taskId,  Constants.sendMailTaskType.get(taskId) ,proc);
		statusMap = null;
	}

	/**
	 * 发送邮件信息
	 *
	 * @param userList
	 * @param statusMap
	 * @throws java.io.IOException
	 */
	private void sendUserMail(Session session,List<PerUser> userList, Map<String, Integer> statusMap,int count,Integer intervalDays,Integer taskId,String proc) throws IOException {
		if (CollectionUtils.isNotEmpty(userList)) {
			for (PerUser perUser : userList) {
				count ++;
				if(!this.checkMailSend(perUser, Constants.MAIL_TASK_SYSTEM_POS_RECOMMEND_LARGE)){
					this.addMailCount(statusMap, MailCount.EMAIL_ADDR_FILTER);
					continue;
				}
				String mailContent = this.assembleMailContent(perUser, statusMap,taskId);
				if (StringUtils.isNotBlank(mailContent)) {
					//根据taskId查看LogMailBatchSend是否有记录，如果有更新，否则新增
					String logSelectSQL = "SELECT lmbs.id FROM LogMailBatchSend lmbs WHERE lmbs.taskId = :taskId AND proc = :proc"; 
					Session session1 = HibernateCountUtil.currentSession();
					Query query = session1.createQuery(logSelectSQL);
					// 给1.5年内登录过的个人用户发职位推荐
					query.setParameter("taskId", taskId);
					query.setParameter("proc", proc);
					int id= NumberUtils.toInt(query.uniqueResult()+"",0);
					//需要根据此ID来更新日志中end_id的值
					statusMap.put("id", id);
					if(id > 0){
						String updateSQL = "UPDATE LogMailBatchSend SET currentNum="+count+",beginId="+perUser.getId()+",proc='"+proc+"',doneFlag=0 WHERE id="+id;
						session1.createQuery(updateSQL).executeUpdate();
						session1.flush();
						session1.clear();
					}else{
						// 记录日志
						statusMap.put("currenum", count);
						this.saveLog(statusMap, taskId, "大量发送职位推荐邮件("+Math.abs(intervalDays)+"天未登陆)",proc);
					}
					
					//TODO:暂时停止发送
					String[] toAddr = StringUtils.split(perUser.getEmail(), Constants.MAIL_ADDRESS_SEPARATE_CHAR);
					/*boolean flag = sender.send(new PosRecommendMailVo(mailContent, toAddr, Constants.MAIL_TYPE_SIMPLIFIED));
					try {
						if(flag){
							this.addMailCount(statusMap, MailCount.SEND_SUCCESS);
							logger.info(perUser.getEmail() + "发送成功！");
						}else{
							this.addMailCount(statusMap, MailCount.SEND_FAIL);
							logger.info(perUser.getEmail() + "发送失败！");
						}
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}*/

					/**发送测试邮件**/
					this.addSendNum();
					if(this.getSendNum() % this.getSendTestMailPerNum() == 0){
						sender.send(new PosRecommendMailVo(mailContent, this.getTestMailAddr(), Constants.MAIL_TYPE_SIMPLIFIED));
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
			String unsubscribeLink = this.assembleUnsubscribeLink(perUser, Constants.MAIL_TASK_SYSTEM_POS_RECOMMEND_LARGE);
			
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
		HttpClient httpClient = null;
		String jsonStr = StringUtils.EMPTY;
		try {
			httpClient = new DefaultHttpClient();
			HttpPost httpost = new HttpPost(Constants.API_POS_SEARCH_URL);
			httpost.setEntity(new UrlEncodedFormEntity(httpParamList, Consts.UTF_8));
			HttpResponse response = httpClient.execute(httpost);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				jsonStr = EntityUtils.toString(entity, "utf-8");
				EntityUtils.consume(entity);
				PosSearchResult result = gson.fromJson(jsonStr, PosSearchResult.class); 
				if (result.isSuccess()) {
					posList = result.getDataList();
				} else {
					logger.error("===调用接口查询匹配求职意向职位列表失败：" + StringUtils.join(result.getErrorList(), ";") + "====USERID:" + userId);
				}
			}
		} catch (Exception e) {
			logger.error("===调用接口查询匹配求职意向职位列表异常：" + e.getMessage(), e);
			logger.error("USERID:" + userId);
			logger.error(jsonStr);
		} finally {
			httpClient.getConnectionManager().shutdown();
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
	 * @param id
	 * @param beginId
	 * @return
	 */
	private void saveLogMailBathSend(int id,int beginId,String proc){
		String sql = "UPDATE LogMailBatchSend SET beginId="+beginId+",proc='"+proc+"' WHERE id="+id;
		Session ses = HibernateCountUtil.currentSession();
		ses.createQuery(sql).executeUpdate();
		ses.flush();
		ses.clear();
	}
}
