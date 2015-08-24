package com.job5156.task.mail;

import com.dmdelivery.webservice.RecipientNameValuePairType;
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
import com.job5156.common.util.HibernateUtil;
import com.job5156.model.per.PerUser;
import com.job5156.vo.mail.PerNotResumeMailVo;
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
import java.util.*;

/**
 * 个人只注册了帐号，没有填写简历
 *
 * @author:leeton
 */
public class PerNotResumeByApi extends BaseMailSend {
	private static Logger logger = Logger.getLogger(PerNotResumeByApi.class);

	private EmailSender sender;

	public PerNotResumeByApi() throws EmailServerConfigException{
		sender = new EmailSender(MailServer.MAIN);
	}

	public PerNotResumeByApi(MailServer mailServer) throws EmailServerConfigException{
		sender = new EmailSender(mailServer);
	}

	public static void main(String[] args) {
		try {
            PerNotResumeByApi notResume = new PerNotResumeByApi();
            notResume.setTestMailAddr("yf_198407@163.com");
            notResume.send();
            HibernateSalveBaseUtil.closeSession();
		} catch (EmailServerConfigException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void send() {
		sendMailByIntervalDays(new Date(), -1, Constants.MAIL_TASK_PER_NOT_RESUME);
        HibernateSalveBaseUtil.closeSession();
	}

	@SuppressWarnings("unchecked")
	public void sendMailByIntervalDays(Date date,Integer intervalDays,Integer taskId) {
        logger.error(Constants.sendMailTaskType.get(taskId)+" 开始发送...");
		Date loginDate = DateUtils.addDays(date, intervalDays);
		Map<String, Integer> statusMap = Maps.newHashMap();
		int dataLoadNumber = 1000;
        String hql = " FROM PerUser WHERE resId IS NULL AND createDate >= :beginDate AND createDate <= :endDate  ";
		String countHql = " SELECT COUNT(*) " + hql ;

		Date beginDate = new DateTime(loginDate).secondOfDay().withMinimumValue().toDate();
		Date endDate = new DateTime(loginDate).secondOfDay().withMaximumValue().toDate();
		
		Session session = HibernateSalveBaseUtil.currentSession();
		Query query = session.createQuery(countHql);
		query.setParameter("beginDate", beginDate);
		query.setParameter("endDate", endDate);
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
					query.setParameter("beginDate", beginDate);
					query.setParameter("endDate", endDate);
					query.setFirstResult(i * dataLoadNumber);
					query.setMaxResults(dataLoadNumber);

                    List<PerUser> userList = query.list();

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
	private void sendUserMail(List<PerUser> userList, Map<String, Integer> statusMap,Integer taskId) throws IOException {
        if (CollectionUtils.isNotEmpty(userList)) {
            RecipientNameValuePairType[] recipientParam = new RecipientNameValuePairType[userList.size() + getTestMailAddr().length];
            for (PerUser perUser : userList) {
                if (!this.checkEmail(perUser.getEmail())) {
                    this.addMailCount(statusMap, MailCount.EMAIL_ADDR_FILTER);
                    continue;
                }

                Map<String, Object> paramMap = Maps.newHashMap();
                paramMap.put("userName", perUser != null ? perUser.getUserName() : "");
                String email = getOneVaildEmail(perUser.getEmail());
                if (StringUtils.isBlank(email)) {
                    this.addMailCount(statusMap, MailCount.EMAIL_ADDR_FILTER);
                    continue;
                }
                int campaignId = 5;   //活动ID
                int mailingId = 35;   //邮件ID
                int groupId = 81;     //组ID

                try {
                    //email = "290413939@qq.com";
                    String unsubscribeLink = this.assembleUnsubscribeLink(perUser, taskId);
                    recipientParam = new RecipientNameValuePairType[]{
                            new RecipientNameValuePairType("email", email),
                            new RecipientNameValuePairType("username", ObjectUtils.toString(perUser.getUserName(), "")),
                            new RecipientNameValuePairType("unsubscribelink", unsubscribeLink),
                    };
                    boolean flag = SendEmailByWebpowerApi.getInstance().sendSingleMailing(recipientParam, campaignId, mailingId, groupId);
                    if (flag) {
                        this.addMailCount(statusMap, MailCount.SEND_SUCCESS);
                    } else {
                        this.addMailCount(statusMap, MailCount.SEND_FAIL);
                        if (getSendNum() < 100) {
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
            String unsubscribeLink = this.assembleUnsubscribeLink(perUser, taskId);
            Map<String, Object> map = Maps.newHashMap();
            map.put("perUser", perUser);
            map.put("unsubscribeLink", unsubscribeLink);

            Configuration configure = FreemarkerConfigure.getFreemarkerConfig();
            Template template = configure.getTemplate("mail/third/per_not_resume.ftl");

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
