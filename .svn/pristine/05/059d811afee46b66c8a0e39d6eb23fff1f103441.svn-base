package com.job5156.run.mail;

import java.util.Date;

import org.apache.log4j.Logger;

import com.job5156.common.CommonEnum.MailServer;
import com.job5156.common.Constants;
import com.job5156.common.exception.EmailServerConfigException;
import com.job5156.common.util.HibernateActionUtil;
import com.job5156.common.util.HibernateCountUtil;
import com.job5156.common.util.HibernateUtil;
import com.job5156.task.mail.PerLoginFailure;
import com.job5156.task.mail.PerLongTermNoLogin;
import com.job5156.task.mail.ResumeNotPerfect;
import com.job5156.task.mail.ResumeViewed;
import com.job5156.task.mail.SystemPosRecommend;

/**
 * <p>
 * 每天发送邮件进程1
 * </p>
 * 
 * @author leo
 * 
 */
public class RunSendMailEveryDay1 {
	private static final Logger logger = Logger.getLogger(RunSendMailEveryDay1.class);

	public static void main(String[] args) {
        logger.error("==================== 每日发送进程 Day1 开始 =========================");
		try {
            //个人登录失败，提醒找回密码
        	Date date = new Date();
            PerLoginFailure perLoginFailure = new PerLoginFailure(MailServer.BAK1);
            perLoginFailure.sendMailByIntervalDays(date,-1,Constants.MAIL_TASK_PER_LOGIN_FAILURE);
            perLoginFailure = null;
            HibernateUtil.closeSession();
        } catch (EmailServerConfigException e) {
            e.printStackTrace();
            logger.error("[个人登录失败，提醒找回密码]异常：" + e.getMessage(), e);
        }

        try {
        	Date date = new Date();
            ResumeViewed resumeViewed = new ResumeViewed(MailServer.BAK1);
            resumeViewed.sendMailByIntervalDays(date, -1,Constants.MAIL_TASK_SYSTEM_RESUME_VIEWED);
            resumeViewed = null;
            HibernateUtil.closeSession();
			HibernateActionUtil.closeSession();
        } catch (EmailServerConfigException e) {
            e.printStackTrace();
            logger.error("[系统发送简历被查看邮件]异常：" + e.getMessage(), e);
        }

		try {
            //长期未登录
			Date date = new Date();
            PerLongTermNoLogin perLongNoLogin = new PerLongTermNoLogin(MailServer.BAK1);
            perLongNoLogin.sendMailByIntervalDays(date, -30,Constants.MAIL_TASK_SYSTEM_LONG_TERM_NO_LOGIN_D30);
            perLongNoLogin.sendMailByIntervalDays(date, -90,Constants.MAIL_TASK_SYSTEM_LONG_TERM_NO_LOGIN_D90);
            perLongNoLogin.sendMailByIntervalDays(date, -180,Constants.MAIL_TASK_SYSTEM_LONG_TERM_NO_LOGIN_D180);
            perLongNoLogin = null;
            HibernateUtil.closeSession();
		} catch (EmailServerConfigException e) {
			e.printStackTrace();
			logger.error("[长期未登录]异常：" + e.getMessage(), e);
		}

        try {
            //简历不完善
        	Date date = new Date();
            ResumeNotPerfect resumeNotPerfect = new ResumeNotPerfect(MailServer.BAK1);
            resumeNotPerfect.sendMailByIntervalDays(date, -15, Constants.MAIL_TASK_SYSTEM_RESUME_NOT_PERFECT_D15);
            resumeNotPerfect.sendMailByIntervalDays(date, -30, Constants.MAIL_TASK_SYSTEM_RESUME_NOT_PERFECT_D30);
            resumeNotPerfect.sendMailByIntervalDays(date, -90, Constants.MAIL_TASK_SYSTEM_RESUME_NOT_PERFECT_D90);
            resumeNotPerfect.sendMailByIntervalDays(date, -180, Constants.MAIL_TASK_SYSTEM_RESUME_NOT_PERFECT_D180);
            resumeNotPerfect.sendMailByIntervalDays(date, -360, Constants.MAIL_TASK_SYSTEM_RESUME_NOT_PERFECT_D360);
            resumeNotPerfect = null;
            HibernateUtil.closeSession();
        } catch (EmailServerConfigException e) {
            e.printStackTrace();
            logger.error("[简历不完善]异常：" + e.getMessage(), e);
        }
        
        try {
			Date date = new Date();
			SystemPosRecommend recommend = new SystemPosRecommend(MailServer.BAK1);
			recommend.sendMailByIntervalDays(date, -1, Constants.MAIL_TASK_SYSTEM_POS_RECOMMEND_D1);
			recommend.sendMailByIntervalDays(date, -3, Constants.MAIL_TASK_SYSTEM_POS_RECOMMEND_D3);
			recommend = null;
			HibernateUtil.closeSession();
			HibernateCountUtil.closeSession();
		} catch (EmailServerConfigException e) {
			e.printStackTrace();
			logger.error("[系统发送职位推荐进程1]异常：" + e.getMessage(), e);
		}

        logger.error("==================== 每日发送进程 Day1 结束 =========================");
	}
}
