package com.job5156.task.mail;

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
import com.job5156.vo.mail.PerLoginFailureMailVo;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.joda.time.DateTime;

import java.io.IOException;
import java.io.StringWriter;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.util.*;

/**
 * 个人登录失败，提醒找回密码
 * 业务规则：
 * 1.LogAction 表里昨天登录失败的用户 >3次
 * 2.过滤掉当前已申请过找回密码的用户
 * 3.过滤掉当前已登录过的用户
 * 4.给过滤后剩下的用户发送【提醒邮件】
 *
 * @author:leeton
 */
public class PerLoginFailure extends BaseMailSend {
	private static Logger logger = Logger.getLogger(PerLoginFailure.class);

	private EmailSender sender;

	public PerLoginFailure() throws EmailServerConfigException{
		sender = new EmailSender(MailServer.MAIN);
	}

	public PerLoginFailure(MailServer mailServer) throws EmailServerConfigException{
		sender = new EmailSender(mailServer);
	}

	public static void main(String[] args) {
		try {
            PerLoginFailure perLoginFailure = new PerLoginFailure();
//            perLoginFailure.setTestMailAddr("yf_198407@163.com");
            perLoginFailure.send();
		} catch (EmailServerConfigException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void send() {
		this.sendMailByIntervalDays(new Date(),-1,Constants.MAIL_TASK_PER_LOGIN_FAILURE);
		HibernateUtil.closeSession();
	}

	@SuppressWarnings("unchecked")
	public void sendMailByIntervalDays(Date date,Integer intervalDays,Integer taskId) {
       // Integer taskId =  Constants.MAIL_TASK_PER_LOGIN_FAILURE;
       // Date date = new Date();
		logger.error("[个人登录失败，提醒找回密码邮件开始发送...");
		Date loginDate = DateUtils.addDays(date, intervalDays);
		Map<String, Integer> statusMap = Maps.newHashMap();
		int dataLoadNumber = 1000;
        String sql2 = " FROM log_action  WHERE create_time >= :beginDate AND create_time <= :endDate AND call_method = :callMethod " +
                " GROUP BY param1 HAVING count(id) > 3 ";

        String sql = " SELECT substring(param1,9) " + sql2;

        String countHql = " SELECT COUNT(*) FROM ( SELECT id " + sql2 +" ) AS log" ;

		Date beginDate = new DateTime(loginDate).secondOfDay().withMinimumValue().toDate();
		Date endDate = new DateTime(loginDate).secondOfDay().withMaximumValue().toDate();
		
		Session session = HibernateUtil.currentSession();
		Query query = session.createSQLQuery(countHql);
		query.setParameter("beginDate", beginDate);
		query.setParameter("endDate", endDate);
        query.setParameter("callMethod",Constants.LOG_ACTION_PER_LOGIN_FAILURE);
		int allRecord = ((BigInteger) query.uniqueResult()).intValue();

        if (allRecord > 0) {
			int allPage = 1;
			if (allRecord > dataLoadNumber) {
				allPage = allRecord / dataLoadNumber + ((allRecord % dataLoadNumber == 0) ? 0 : 1);
			}
			try {
                int totalCount = 0;
				for (int i = 0; i < allPage; i++) {
					query = session.createSQLQuery(sql);
					query.setParameter("beginDate", beginDate);
					query.setParameter("endDate", endDate);
                    query.setParameter("callMethod",Constants.LOG_ACTION_PER_LOGIN_FAILURE);
					query.setFirstResult(i * dataLoadNumber);
					query.setMaxResults(dataLoadNumber);

					List<String> logList = query.list();
                    filterIsGotPassword(logList);
                    List<PerUser> userList = filterHasLogin(logList);
                    totalCount += userList.size();
                    statusMap.put(MailCount.TOTAL.getType(),totalCount);

					this.sendUserMail(userList, statusMap);
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
     * 过滤当前已经申请找回密码的用户
     * @param logList
     */
    private void filterIsGotPassword(List<String> logList){

        List<String> isApplyList = null;
        try {
            String SQL = " SELECT distinct substring(param1,9) FROM log_action  WHERE create_time <= :now AND call_method = :callMethod";

            Date now = DateTime.now().toDate();
            Session session = HibernateUtil.currentSession();
            Query query = session.createSQLQuery(SQL);
            query.setParameter("now", now);
            query.setParameter("callMethod", Constants.LOG_ACTION_PER_RESET_PASSWORD_APPLY);

            isApplyList = query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        Iterator logIt = logList.iterator();
        while(logIt.hasNext() && CollectionUtils.isNotEmpty(isApplyList)){
            if (isApplyList.contains(logIt.next())) {
                logIt.remove();
            }
        }

    }

    /**
     * 过滤当天登录过的用户
     * @param logList
     */
    private List<PerUser> filterHasLogin(List<String> logList) {

        List<PerUser> perUserList = new ArrayList<>();
        List<String> accountList = new ArrayList<>();

        for (String logAction : logList) {
            String account = StringUtils.strip(logAction, "account=");
            accountList.add(account);
        }

        try {
            String accountStr = "";
            for (int i = 0; i < accountList.size(); i++) {
                if (i <= accountList.size() - 1 && i>0) {
                    accountStr += ",'" + accountList.get(i) +"'";
                } else {
                    accountStr += "'" + accountList.get(i) + "'";
                }
            }
            String hql = " FROM PerUser  WHERE loginDate < :now  AND  account IN("+accountStr+")";

            Date now = DateTime.now().toDate();
            Session session = HibernateUtil.currentSession();
            Query query = session.createQuery(hql);
            query.setParameter("now", now);

            perUserList = query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return perUserList;
    }




	/**
	 * 发送邮件信息
	 *
	 * @param userList
	 * @param statusMap
	 * @throws java.io.IOException
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
					Map<String, Object> paramMap = Maps.newHashMap();
					paramMap.put("userName", perUser != null ? perUser.getUserName() : "");
					String email = getOneVaildEmail(perUser.getEmail());
					if(StringUtils.isBlank(email)){
						this.addMailCount(statusMap, MailCount.EMAIL_ADDR_FILTER);
						continue;
					}
					try {
						String[] toMail = new String[]{ email};
						boolean flag = sender.send(new PerLoginFailureMailVo(mailContent, toMail, Constants.MAIL_TYPE_SIMPLIFIED, paramMap));
						if(flag){
							this.addMailCount(statusMap, MailCount.SEND_SUCCESS);
						}else{
							this.addMailCount(statusMap, MailCount.SEND_FAIL);
                            if(getSendNum() < 100){
                                logger.error("SEND FAIL TO:"+ email);
                            }
						}
						Thread.sleep(500);
					} catch (Exception e) {
						this.addMailCount(statusMap, MailCount.SEND_FAIL);
						e.printStackTrace();
					}

					/**发送测试邮件**/
					this.addSendNum();
					if(this.getSendNum() % this.getSendTestMailPerNum() == 0){
						sender.send(new PerLoginFailureMailVo(mailContent, getTestMailAddr(), Constants.MAIL_TYPE_SIMPLIFIED, paramMap));
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
	 * @throws java.io.IOException
	 */
	private String assembleMailContent(PerUser perUser, Map<String, Integer> statusMap) throws IOException {
		if (perUser != null) {
			String unsubscribeLink = this.assembleUnsubscribeLink(perUser, Constants.MAIL_TASK_PER_LOGIN_FAILURE);
			String editSearcherLink = "/?ref=" + URLEncoder.encode("/per/resume", "UTF-8");
			Map<String, Object> map = Maps.newHashMap();
			map.put("perUser", perUser);
			map.put("link", "/login/per");
			map.put("unsubscribeLink", unsubscribeLink);
			map.put("editSearcherLink", editSearcherLink);

			Configuration configure = FreemarkerConfigure.getFreemarkerConfig();
			Template template = configure.getTemplate("mail/third/per_login_failure.ftl");

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
