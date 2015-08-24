package com.job5156.task.mail;

import java.io.IOException;
import java.io.StringWriter;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.joda.time.DateTime;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.job5156.beans.freemarker.FreemarkerConfigure;
import com.job5156.beans.mail.BaseMailSend;
import com.job5156.beans.mail.EmailSender;
import com.job5156.common.CommonEnum.MailCount;
import com.job5156.common.CommonEnum.MailServer;
import com.job5156.common.Constants;
import com.job5156.common.exception.EmailServerConfigException;
import com.job5156.common.util.HibernateActionUtil;
import com.job5156.common.util.HibernateUtil;
import com.job5156.model.per.PerUser;
import com.job5156.model.per.job.PerViewLog;
import com.job5156.vo.mail.ResumeViewedMailVo;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * <p>
 * 简历被查看
 * </p>
 * 
 * @author leo
 * 
 */
public class ResumeViewed extends BaseMailSend {
	private static Logger logger = Logger.getLogger(ResumeViewed.class);

	private EmailSender sender;
	private Map<Integer, List<PerViewLog>> perViewMap = Maps.newHashMap();
	private Map<Integer, PerUser> userMap = Maps.newHashMap();

	public ResumeViewed() throws EmailServerConfigException {
		sender = new EmailSender(MailServer.MAIN);
		this.setSendTestMailPerNum(2000);
	}
	
	public ResumeViewed(MailServer mailServer) throws EmailServerConfigException{
		sender = new EmailSender(mailServer);
		this.setSendTestMailPerNum(2000);
	}

	public static void main(String[] args) {
		try {
			ResumeViewed resumeViewed = new ResumeViewed();
			resumeViewed.send();
			HibernateUtil.closeSession();
			HibernateActionUtil.closeSession();
		} catch (EmailServerConfigException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void send(){
		this.sendMailByIntervalDays(new Date(), -1,Constants.MAIL_TASK_SYSTEM_RESUME_VIEWED);
	}
	
	@SuppressWarnings("unchecked")
	public void sendMailByIntervalDays(Date date, Integer intervalDays,Integer taskId) {
		logger.error("[系统发送简历被查看邮件开始发送...");
		Date viewDate = DateUtils.addDays(date, intervalDays);
		Map<String, Integer> statusMap = Maps.newHashMap();
		int dataLoadNumber = 2000;

		String hql = "FROM PerViewLog p WHERE p.comId > 0 AND p.lookStatus= 1 AND p.creTime > :beginDate AND p.creTime < :endDate ORDER BY p.id";
		String countHql = "SELECT COUNT(p.id) FROM PerViewLog p WHERE p.comId > 0 AND p.lookStatus= 1 AND p.creTime > :beginDate AND p.creTime < :endDate ORDER BY p.id";

		Date beginDate = new DateTime(viewDate).secondOfDay().withMinimumValue().toDate();
		Date endDate = new DateTime(viewDate).secondOfDay().withMaximumValue().toDate();

		Session session = HibernateActionUtil.currentSession();
		Query query = session.createQuery(countHql);
		query.setParameter("beginDate", beginDate);
		query.setParameter("endDate", endDate);
		int allRecord = ((Long) query.uniqueResult()).intValue();
		
		if (allRecord > 0) {
			int allPage = 1;
			if (allRecord > dataLoadNumber) {
				allPage = allRecord / dataLoadNumber + ((allRecord % dataLoadNumber == 0) ? 0 : 1);
			}
			
			for (int i = 0; i < allPage; i++) {
				query = session.createQuery(hql);
				query.setParameter("beginDate", beginDate);
				query.setParameter("endDate", endDate);
				query.setFirstResult(i * dataLoadNumber);
				query.setMaxResults(dataLoadNumber);

				List<PerViewLog> viewList = query.list();
				this.analysisViewLogList(viewList);
				session.clear();
			}
			
			statusMap.put(MailCount.TOTAL.getType(), perViewMap.size());
			this.assembleUserInfo();
			try {
				this.sendUserMail(statusMap,taskId);
			} catch (IOException e) {
				e.printStackTrace();
				logger.error("===系统发送简历被查看邮件异常：" + e.getMessage(), e);
			}
		}
		
		String logMessage = Constants.sendMailTaskType.get(taskId)
				  + "总计应发：" + NumberUtils.toInt(String.valueOf(statusMap.get(MailCount.TOTAL.getType())), 0) + "，"
				  + "邮件地址过滤：" + NumberUtils.toInt(String.valueOf(statusMap.get(MailCount.EMAIL_ADDR_FILTER.getType())), 0) + "，"
				  + "发送成功：" + NumberUtils.toInt(String.valueOf(statusMap.get(MailCount.SEND_SUCCESS.getType())), 0) + "，"
				  + "发送失败：" + NumberUtils.toInt(String.valueOf(statusMap.get(MailCount.SEND_FAIL.getType())), 0);
		logger.error(logMessage);
		
		// 记录日志
		this.saveLog(statusMap, taskId, Constants.sendMailTaskType.get(taskId),"");
		statusMap = null;
	}
	private void sendUserMail(Map<String, Integer> statusMap,Integer taskId) throws IOException{
		for(Integer userId : perViewMap.keySet()){
			List<PerViewLog> viewLogList = perViewMap.get(userId);
			PerUser perUser = userMap.get(userId);
			
			if(!this.checkMailSend(perUser, taskId)){
				this.addMailCount(statusMap, MailCount.EMAIL_ADDR_FILTER);
				continue;
			}
			// TODO 修改测试邮箱地址
			Map<String, Object> paramMap = Maps.newHashMap();
			String mailContent = this.assembleMailContent(perUser, viewLogList,paramMap,taskId);
			if (StringUtils.isNotBlank(mailContent)) {
				Map<String, Object> map = Maps.newHashMap();
				map.put("userName", perUser != null ? perUser.getUserName() : "");
				String email = getOneVaildEmail(perUser.getEmail());
				if(StringUtils.isBlank(email)){
					this.addMailCount(statusMap, MailCount.EMAIL_ADDR_FILTER);
					continue;
				}
				String[] toMail = new String[]{ email};
				boolean flag = sender.send(new ResumeViewedMailVo(mailContent, toMail, Constants.MAIL_TYPE_SIMPLIFIED, paramMap));
				try {
					if(flag){
						this.addMailCount(statusMap, MailCount.SEND_SUCCESS);
					}else{
						this.addMailCount(statusMap, MailCount.SEND_FAIL);
					}
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				/**发送测试邮件**/
				this.addSendNum();
				if(this.getSendNum() % this.getSendTestMailPerNum() == 0){
					sender.send(new ResumeViewedMailVo(mailContent, this.getTestMailAddr(), Constants.MAIL_TYPE_SIMPLIFIED, paramMap));
				}
			}else{
				this.addMailCount(statusMap, MailCount.SEARCHER_IS_EMPTY);
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
	private String assembleMailContent(PerUser perUser, List<PerViewLog> viewLogList,Map<String, Object> paramMap,Integer taskId) throws IOException {
		if (perUser != null) {
			if(viewLogList.size() > 7){
				viewLogList = viewLogList.subList(0, 7);
			}
			
			String unsubscribeLink = this.assembleUnsubscribeLink(perUser, taskId);
			String lookMoreComLink = "/login/per/?ref=" + URLEncoder.encode("/per/job", "UTF-8");//查看更多求职动态
			String whoLookMeResumeLink = "/login/per/?ref="+URLEncoder.encode("/per/job/view","UTF-8");//谁看过我的简历
			Map<String, Object> map = Maps.newHashMap();
			map.put("perUser", perUser);
			map.put("viewLogList", viewLogList);
			map.put("comNum", viewLogList.size());
			map.put("lookMoreComLink", lookMoreComLink);
			map.put("whoLookMeResumeLink", whoLookMeResumeLink);
			map.put("unsubscribeLink", unsubscribeLink);
			
			paramMap.put("userName", perUser.getUserName());
			paramMap.put("comNum", viewLogList.size());
			Configuration configure = FreemarkerConfigure.getFreemarkerConfig();
			Template template = configure.getTemplate("mail/third/resume_viewed.ftl");

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

	/**
	 * 分析简历查看数据封装到MAP
	 * @param viewList
	 */
	private void analysisViewLogList(List<PerViewLog> viewList){
		if(CollectionUtils.isNotEmpty(viewList)){
			for(PerViewLog viewLog : viewList){
				List<PerViewLog> list = perViewMap.get(viewLog.getPerUserId());
				if(CollectionUtils.isEmpty(list)){
					list = Lists.newArrayList();
					perViewMap.put(viewLog.getPerUserId(), list);
				}
				list.add(viewLog);
			}
		}
	}
	
	private void assembleUserInfo(){
		if(MapUtils.isNotEmpty(perViewMap)){
			List<Integer> userIdList = Lists.newArrayList();
			for(Integer userId : perViewMap.keySet()){
				userIdList.add(userId);
				if(userIdList.size() == 1000){
					this.assembleUserInfoMap(userIdList);
					userIdList.clear();
				}
			}
			this.assembleUserInfoMap(userIdList);
		}
	}
	
	@SuppressWarnings("unchecked")
	private void assembleUserInfoMap(List<Integer> userIdList){
		if(CollectionUtils.isNotEmpty(userIdList)){
			String hql = "FROM PerUser u WHERE u.id IN(:idList)";
			Session session = HibernateUtil.currentSession();
			List<PerUser> userList = session.createQuery(hql).setParameterList("idList", userIdList).list();
			for(PerUser user : userList){
				userMap.put(user.getId(), user);
			}
			session.clear();
		}
	}
}
