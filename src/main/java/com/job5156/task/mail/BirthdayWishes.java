package com.job5156.task.mail;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.joda.time.DateTime;
import org.joda.time.Hours;

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
import com.job5156.vo.mail.BirthdayWishesMailVo;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * <p>
 * 生日祝福邮件
 * </p>
 * 
 * @author leo
 * 
 */
public class BirthdayWishes extends BaseMailSend {
	private static Logger logger = Logger.getLogger(BirthdayWishes.class);
	
	private EmailSender sender;
	
	public BirthdayWishes() throws EmailServerConfigException{
		sender = new EmailSender(MailServer.MAIN);
		this.setSendTestMailPerNum(2000);
	}
	
	public BirthdayWishes(MailServer mailServer) throws EmailServerConfigException{
		sender = new EmailSender(mailServer);
		this.setSendTestMailPerNum(2000);
	}
	
	public static void main(String[] args) {
		try {
			BirthdayWishes birthdayWishes = new BirthdayWishes();
			birthdayWishes.send();
			HibernateUtil.closeSession();
		} catch (EmailServerConfigException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void send() {
		logger.error("[系统发送生日祝福邮件]开始发送...");
		Map<String, Integer> statusMap = Maps.newHashMap();
		int dataLoadNumber = 2000;
		DateTime beginTime = DateTime.now();

		String hql = " FROM PerUser p WHERE DATE_FORMAT(CURDATE(), '-%m-%d') = DATE_FORMAT(birthday, '-%m-%d') AND YEAR(p.birthday) <> 1900";
		String countHql = "SELECT COUNT(p.id) " + hql;

		Session session = HibernateUtil.currentSession();
		Query query = session.createQuery(countHql);
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
					query.setFirstResult(i * dataLoadNumber);
					query.setMaxResults(dataLoadNumber);

					List<PerUser> userList = query.list();
					this.sendUserMail(userList, statusMap);
					session.clear();
				}
			} catch (IOException e) {
				e.printStackTrace();
				logger.error("===系统发送生日祝福邮件异常：" + e.getMessage(), e);
			}
		}
		
		DateTime endTime = DateTime.now();
		String logMessage = "[系统发送生日祝福邮件]"
				  + "总计应发：" + NumberUtils.toInt(String.valueOf(statusMap.get(MailCount.TOTAL.getType())), 0) + "，"
				  + "邮件地址过滤：" + NumberUtils.toInt(String.valueOf(statusMap.get(MailCount.EMAIL_ADDR_FILTER.getType())), 0) + "，"
				  + "发送成功：" + NumberUtils.toInt(String.valueOf(statusMap.get(MailCount.SEND_SUCCESS.getType())), 0) + "，"
				  + "发送失败：" + NumberUtils.toInt(String.valueOf(statusMap.get(MailCount.SEND_FAIL.getType())), 0) + "，"
				  + "共耗时：" + Hours.hoursBetween(beginTime, endTime).getHours() + "小时";
		logger.error(logMessage);
		
		// 记录日志
		this.saveLog(statusMap, Constants.MAIL_TASK_SYSTEM_BIRTHDAY_WISH, "系统发送生日祝福邮件","");
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
				//判断是否退订了生日祝福
				if(!this.checkMailSend(perUser, Constants.MAIL_TASK_SYSTEM_BIRTHDAY_WISH)){
					this.addMailCount(statusMap, MailCount.EMAIL_ADDR_FILTER);
					continue;
				}
				String mailContent = this.assembleMailContent(perUser);
				if (StringUtils.isNotBlank(mailContent)) {
					Map<String, Object> paramMap = Maps.newHashMap();
					paramMap.put("userName", perUser != null ? perUser.getUserName() : "");
                    String email = getOneVaildEmail(perUser.getEmail());
                    if(StringUtils.isBlank(email)){
                        this.addMailCount(statusMap, MailCount.EMAIL_ADDR_FILTER);
                        continue;
                    }
                    boolean flag = sender.send(new BirthdayWishesMailVo(mailContent,new String[]{email}, Constants.MAIL_TYPE_SIMPLIFIED, paramMap));
					try {
						if(flag){
							this.addMailCount(statusMap, MailCount.SEND_SUCCESS);
							//logger.info(perUser.getEmail() + "发送成功！");
						}else{
							this.addMailCount(statusMap, MailCount.SEND_FAIL);
							//logger.info(perUser.getEmail() + "发送失败！");
						}
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					/**发送测试邮件**/
					this.addSendNum();
					if(this.getSendNum() % this.getSendTestMailPerNum() == 0){
						sender.send(new BirthdayWishesMailVo(mailContent, this.getTestMailAddr(), Constants.MAIL_TYPE_SIMPLIFIED, paramMap));
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
	private String assembleMailContent(PerUser perUser) throws IOException {
		if (perUser != null) {
			String unsubscribeLink = this.assembleUnsubscribeLink(perUser, Constants.MAIL_TASK_SYSTEM_BIRTHDAY_WISH);
			Map<String, Object> map = Maps.newHashMap();
			map.put("perUser", perUser);
			map.put("unsubscribeLink", unsubscribeLink);

			Configuration configure = FreemarkerConfigure.getFreemarkerConfig();
			Template template = configure.getTemplate("mail/third/birthday_wishes.ftl");

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
