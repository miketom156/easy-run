package com.job5156.task.mail;

import com.google.common.collect.Maps;
import com.job5156.beans.freemarker.FreemarkerConfigure;
import com.job5156.beans.mail.BaseMailSend;
import com.job5156.beans.mail.EmailSender;
import com.job5156.common.CommonEnum.MailCount;
import com.job5156.common.CommonEnum.MailServer;
import com.job5156.common.Constants;
import com.job5156.common.api.SendEmailByWebpowerApi;
import com.job5156.common.exception.EmailServerConfigException;
import com.job5156.common.util.HibernateSalveBaseUtil;
import com.job5156.model.per.PerUser;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.joda.time.DateTime;

import java.io.IOException;
import java.io.StringWriter;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 个人的简历四大项不完整，发提醒邮件
 * 业务规则：当天的简历得分少于38分，（四大项必填项得分为38）,仅未完善及暂时开通的简历
 *
 * @author:leeton
 */
public class ResumeNotPerfectSendByApi extends BaseMailSend {
	private static Logger logger = Logger.getLogger(ResumeNotPerfectSendByApi.class);

	private EmailSender sender;

	public ResumeNotPerfectSendByApi() throws EmailServerConfigException{
		sender = new EmailSender(MailServer.MAIN);
	}

	public ResumeNotPerfectSendByApi(MailServer mailServer) throws EmailServerConfigException{
		sender = new EmailSender(mailServer);
	}

	public static void main(String[] args) {
		try {
            ResumeNotPerfectSendByApi notResume = new ResumeNotPerfectSendByApi();
            notResume.setTestMailAddr("yf_198407@163.com");
            notResume.send();
            HibernateSalveBaseUtil.closeSession();
		} catch (EmailServerConfigException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void send() {
		sendMailByIntervalDays(new Date(), -1, Constants.MAIL_TASK_SYSTEM_RESUME_NOT_PERFECT_D1);
        HibernateSalveBaseUtil.closeSession();
	}

	@SuppressWarnings("unchecked")
	public void sendMailByIntervalDays(Date date,Integer intervalDays,Integer taskId) {
        logger.error(Constants.sendMailTaskType.get(taskId)+" 开始发送...");
		Date loginDate = DateUtils.addDays(date, intervalDays);
		Map<String, Integer> statusMap = Maps.newHashMap();
		int dataLoadNumber = 1000;
        String sql = "SELECT u.id, u.user_name,u.email,r.id as resume_id FROM per_resume r LEFT JOIN per_user as u ON u.id = r.account_id " +
                " where r.perfect_num <38 and r.pass>=0 and r.pass <10 AND r.language_type = 1 and r.fre_date>:beginDate ";
        String coountSQl = " SELECT COUNT(*) FROM " + StringUtils.substringAfter(sql, "FROM");

		Date beginDate = new DateTime(loginDate).secondOfDay().withMinimumValue().toDate();

		Session session = HibernateSalveBaseUtil.currentSession();
		Query query = session.createSQLQuery(coountSQl);
		query.setParameter("beginDate", beginDate);
		int allRecord = ((BigInteger) query.uniqueResult()).intValue();
        statusMap.put(MailCount.TOTAL.getType(), allRecord);

        if (allRecord > 0) {
			int allPage = 1;
			if (allRecord > dataLoadNumber) {
				allPage = allRecord / dataLoadNumber + ((allRecord % dataLoadNumber == 0) ? 0 : 1);
			}
			try {
				for (int i = 0; i < allPage; i++) {
					query = session.createSQLQuery(sql);
					query.setParameter("beginDate", beginDate);
					query.setFirstResult(i * dataLoadNumber);
					query.setMaxResults(dataLoadNumber);

                    List<Map<String ,String>>  userList = query.list();

					this.sendUserMail(userList, statusMap,taskId);
                    userList = null;
					session.clear();
				}
			} catch (IOException e) {
				e.printStackTrace();
				logger.error(Constants.sendMailTaskType.get(taskId)+"异常：" + e.getMessage(), e);
			}
		}

		String logMessage =Constants.sendMailTaskType.get(taskId)
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
	 * @throws java.io.IOException
	 */
    @SuppressWarnings("unused")
	private void sendUserMail(List<Map<String ,String>> userList, Map<String, Integer> statusMap,Integer taskId) throws IOException {
		if (CollectionUtils.isNotEmpty(userList)) {
            for (Object obj : userList) {

                Object[] objArr = (Object[])obj;
                Integer perUserId = NumberUtils.toInt(ObjectUtils.toString(objArr[0]),0);
                String userName = ObjectUtils.toString(objArr[1]);
                String email = ObjectUtils.toString(objArr[2]);
                Integer resumeId =  NumberUtils.toInt(ObjectUtils.toString(objArr[3]));
                PerUser perUser = new PerUser();
                perUser.setEmail(email);
                perUser.setId(perUserId);
                perUser.setUserName(userName);
                perUser.setResId(resumeId);

                if (!this.checkEmail(perUser.getEmail())) {
                    this.addMailCount(statusMap, MailCount.EMAIL_ADDR_FILTER);
                    continue;
                }
                String mailContent = this.assembleMailContent(perUser, taskId);
                if (StringUtils.isNotBlank(mailContent)) {
                    Map<String, Object> paramMap = Maps.newHashMap();
                    paramMap.put("userName", perUser != null ? perUser.getUserName() : "");
                    email = getOneVaildEmail(perUser.getEmail());
                    if (StringUtils.isBlank(email)) {
                        this.addMailCount(statusMap, MailCount.EMAIL_ADDR_FILTER);
                        continue;
                    }
                    int campaignId = 9;   //活动ID
                    int mailingId = 55;   //邮件ID
                    int groupId = 81;     //组ID
                    try {
                        //email = "mailtous@163.com";
                        boolean flag = SendEmailByWebpowerApi.getInstance().sendSingleMailing(email, mailContent, campaignId, mailingId, groupId);
                        if (flag) {
                            this.addMailCount(statusMap, MailCount.SEND_SUCCESS);
                        } else {
                            this.addMailCount(statusMap, MailCount.SEND_FAIL);
                        }
                    } catch (Exception e) {
                        this.addMailCount(statusMap, MailCount.SEND_FAIL);
                        e.printStackTrace();
                    }

                    /**发送测试邮件**/
                    this.addSendNum();
                    if (this.getSendNum() % this.getSendTestMailPerNum() == 0) {
                        for (String testEmail : getTestMailAddr()) {
                            SendEmailByWebpowerApi.getInstance().sendSingleMailing(testEmail, mailContent, campaignId, mailingId, groupId);
                        }
                    }
                } else {
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
	 * @throws java.io.IOException
	 */
	private String assembleMailContent(PerUser perUser, Integer taskId) throws IOException {
        if (perUser != null) {

            Map<String, Object> map = Maps.newHashMap();

            String unsubscribeLink = this.assembleUnsubscribeLink(perUser, taskId);
            String resumeLink = "/login/per/?ref=" + URLEncoder.encode("/per/resume/"+perUser.getResId(), "UTF-8");
            map.put("perUser", perUser);
            map.put("unsubscribeLink", unsubscribeLink);
            map.put("resumeLink", resumeLink);

            Configuration configure = FreemarkerConfigure.getFreemarkerConfig();
            Template template = configure.getTemplate("mail/third/resume_no_perfect.ftl");

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
