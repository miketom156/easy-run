package com.job5156.run.mail;

import org.apache.log4j.Logger;

import com.job5156.common.CommonEnum.MailServer;
import com.job5156.common.exception.EmailServerConfigException;
import com.job5156.common.util.HibernateActionUtil;
import com.job5156.common.util.HibernateCountUtil;
import com.job5156.common.util.HibernateUtil;
import com.job5156.task.mail.PerLongTermNoLogin;
import com.job5156.task.mail.ResumeNotPerfect;

/**
 * 每周发送一次邮件
 * 
 * @author leo
 * 
 */
public class RunSendMailPerWeek {
	private static final Logger logger = Logger.getLogger(RunSendMailPerWeek.class);

	public static void main(String[] args) {
        logger.error("==================== 每周发送进程 开始 =========================");
		try {
			PerLongTermNoLogin longTermNoLogin = new PerLongTermNoLogin(MailServer.BAK2);
			longTermNoLogin.send();
			longTermNoLogin = null;
		} catch (EmailServerConfigException e) {
			e.printStackTrace();
			logger.error("[系统发送长期未登陆邮件]异常：" + e.getMessage(), e);
		}
		
		try {
			ResumeNotPerfect resumeNotPerfect = new ResumeNotPerfect(MailServer.BAK2);
			resumeNotPerfect.send();
			resumeNotPerfect = null;
		} catch (EmailServerConfigException e) {
			e.printStackTrace();
			logger.error("[系统发送简历未完善邮件]异常：" + e.getMessage(), e);
		}
		
		HibernateUtil.closeSession();
		HibernateActionUtil.closeSession();
		HibernateCountUtil.closeSession();
	}
	
}
