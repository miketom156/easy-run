package com.job5156.task.mail;

import java.io.IOException;
import java.io.StringWriter;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.joda.time.DateTime;

import com.google.common.collect.Maps;
import com.job5156.beans.freemarker.FreemarkerConfigure;
import com.job5156.beans.mail.BaseMailSend;
import com.job5156.beans.mail.EmailSender;
import com.job5156.common.CommonEnum.MailCount;
import com.job5156.common.CommonEnum.MailServer;
import com.job5156.common.Constants;
import com.job5156.common.exception.EmailServerConfigException;
import com.job5156.common.util.HibernateUtil;
import com.job5156.model.per.PerUser;
import com.job5156.vo.mail.LongTermNoLoginMailVo;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * <p>
 * 用户 长期未登陆提醒<br>
 * 1个月、3个月、半年未登陆提醒<br>
 * </p>
 * @author leo
 *
 */
public class PerLongTermNoLogin extends BaseMailSend {
	private static Logger logger = Logger.getLogger(PerLongTermNoLogin.class);
	
	private EmailSender sender;

	public PerLongTermNoLogin() throws EmailServerConfigException{
		sender = new EmailSender(MailServer.MAIN);
	}
	
	public PerLongTermNoLogin(MailServer mailServer) throws EmailServerConfigException{
		sender = new EmailSender(mailServer);
	}
	
	public static void main(String[] args) {
		try {
			PerLongTermNoLogin shorTermNoLogin = new PerLongTermNoLogin();
			shorTermNoLogin.send();
		} catch (EmailServerConfigException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void send() {
		Date date = new Date();
		this.sendMailByIntervalDays(date, -30,Constants.MAIL_TASK_SYSTEM_LONG_TERM_NO_LOGIN_D30);
		this.sendMailByIntervalDays(date, -90,Constants.MAIL_TASK_SYSTEM_LONG_TERM_NO_LOGIN_D90);
		this.sendMailByIntervalDays(date, -180,Constants.MAIL_TASK_SYSTEM_LONG_TERM_NO_LOGIN_D180);
		HibernateUtil.closeSession();
	}
	
	@SuppressWarnings("unchecked")
	public void sendMailByIntervalDays(Date date, Integer intervalDays,Integer taskId) {
		logger.error("[系统发送长期未登陆邮件("+Math.abs(intervalDays)+"天)]开始发送...");
		Date loginDate = DateUtils.addDays(date, intervalDays);
		Map<String, Integer> statusMap = Maps.newHashMap();
		int dataLoadNumber = 1000;

		String hql = "FROM PerUser p WHERE p.status = 0 AND  p.loginDate > :beginLoginDate AND p.loginDate < :endLoginDate";
		String countHql = "SELECT COUNT(p.id) FROM PerUser p WHERE p.status = 0 AND p.loginDate > :beginLoginDate AND p.loginDate < :endLoginDate";

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
				logger.error( Constants.sendMailTaskType.get(taskId) +" ON ERROR: " + e.getMessage(), e);
			}
		}
		
		String logMessage =  Constants.sendMailTaskType.get(taskId)
						  + "总计应发：" + NumberUtils.toInt(String.valueOf(statusMap.get(MailCount.TOTAL.getType())), 0) + "，"
						  + "邮件地址过滤：" + NumberUtils.toInt(String.valueOf(statusMap.get(MailCount.EMAIL_ADDR_FILTER.getType())), 0) + "，"
						  + "发送成功：" + NumberUtils.toInt(String.valueOf(statusMap.get(MailCount.SEND_SUCCESS.getType())), 0) + "，"
						  + "发送失败：" + NumberUtils.toInt(String.valueOf(statusMap.get(MailCount.SEND_FAIL.getType())), 0);
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
				if(!this.checkEmail(perUser.getEmail())){
					this.addMailCount(statusMap, MailCount.EMAIL_ADDR_FILTER);
					continue;
				}
				String mailContent = this.assembleMailContent(perUser, statusMap);
				if (StringUtils.isNotBlank(mailContent)) {
					Map<String, Object> map = Maps.newHashMap();
					map.put("userName", perUser != null ? perUser.getUserName() : "");
					String email = getOneVaildEmail(perUser.getEmail());
					if(StringUtils.isBlank(email)){
						this.addMailCount(statusMap, MailCount.EMAIL_ADDR_FILTER);
						continue;
					}
					String[] toMail = new String[]{ email};
					boolean flag = sender.send(new LongTermNoLoginMailVo(mailContent, toMail, Constants.MAIL_TYPE_SIMPLIFIED));
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
						sender.send(new LongTermNoLoginMailVo(mailContent, this.getTestMailAddr(), Constants.MAIL_TYPE_SIMPLIFIED));
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
			String unsubscribeLink = this.assembleUnsubscribeLink(perUser, Constants.MAIL_TASK_SYSTEM_LONG_TERM_NO_LOGIN);
			String editSearcherLink = "/?ref=" + URLEncoder.encode("/per/resume", "UTF-8");
			Map<String, Object> map = Maps.newHashMap();
			map.put("perUser", perUser);
			map.put("link", "/login/per");
			map.put("unsubscribeLink", unsubscribeLink);
			map.put("editSearcherLink", editSearcherLink);

			Configuration configure = FreemarkerConfigure.getFreemarkerConfig();
			Template template = configure.getTemplate("mail/third/long_term_no_login.ftl");

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
}
