package com.job5156.run.mail;

import java.util.Date;

import com.job5156.task.mail.*;
import org.apache.log4j.Logger;

import com.job5156.common.CommonEnum.MailServer;
import com.job5156.common.Constants;
import com.job5156.common.exception.EmailServerConfigException;
import com.job5156.common.util.HibernateCountUtil;
import com.job5156.common.util.HibernateSalveBaseUtil;
import com.job5156.common.util.HibernateUtil;

/**
 * <p>
 * 每天发送邮件进程2
 * </p>
 * 
 * @author leo
 * 
 */
public class RunSendMailEveryDay2 {
	private static final Logger logger = Logger.getLogger(RunSendMailEveryDay2.class);


	public static void main(String[] args) {
        logger.error("==================== 每日发送进程 Day2 开始 =========================");

		try {
			Date date = new Date();
			SystemPosRecommend recommend = new SystemPosRecommend(MailServer.BAK2);
			recommend.sendMailByIntervalDays(date, -7, Constants.MAIL_TASK_SYSTEM_POS_RECOMMEND_D7);
			recommend.sendMailByIntervalDays(date, -15, Constants.MAIL_TASK_SYSTEM_POS_RECOMMEND_D15);
			recommend = null;
			HibernateUtil.closeSession();
			HibernateCountUtil.closeSession();
		} catch (EmailServerConfigException e) {
			e.printStackTrace();
			logger.error("[系统发送职位推荐进程2]异常：" + e.getMessage(), e);
		}

		//暂时停止此邮件发送，对服务器稳定性产生影响。-闫锋 5/15/2015
		/*try{
            PerLessApply perLessApply = new PerLessApply();
            perLessApply.send();
            perLessApply = null;
        } catch (EmailServerConfigException e) {
            e.printStackTrace();
            logger.error("[给应聘职位过少的个人发送职位推荐邮件]异常：" + e.getMessage(), e);
        }*/

        try{
            BirthdayWishes birthday = new BirthdayWishes(MailServer.BAK2);
            birthday.send();
            birthday = null;
            HibernateUtil.closeSession();
        } catch (EmailServerConfigException e) {
            e.printStackTrace();
            logger.error("[系统发送生日祝福邮件]异常：" + e.getMessage(), e);
        }
		
        //屏蔽企业子账号被修改邮件提醒
		/*try{
			ComUserModifySendEmail comUser = new ComUserModifySendEmail();
			comUser.send();
			comUser = null;
			HibernateSalveBaseUtil.closeSession();
		} catch (EmailServerConfigException e) {
			e.printStackTrace();
			logger.error("[企业中心修改账号信息邮件]异常：" + e.getMessage(), e);
		}*/

        try{
            PerNotResumeByApi perNotResumeByApi = new PerNotResumeByApi();
            perNotResumeByApi.send();
            perNotResumeByApi = null;
        } catch (EmailServerConfigException e) {
            e.printStackTrace();
            logger.error("[个人只注册了帐号，没有填写简历]异常：" + e.getMessage(), e);
        }

        //暂时停止此邮件发送，对服务器稳定性产生影响。-闫锋 5/15/2015
        /*try{
            PerInterviewLess perInterviewLess = new PerInterviewLess();
            perInterviewLess.send();
            perInterviewLess = null;
        } catch (EmailServerConfigException e) {
            e.printStackTrace();
            logger.error("[针对用户收到的面试邀请很少的情况发邮件]异常：" + e.getMessage(), e);
        }*/

        try{

    /*        ComSchoolRecruit recommend = new ComSchoolRecruit();
            recommend.setTestMailAddr("1372236380@qq.com", "yf_198407@163.com", "jmail168@163.com","dghxc@job5156.com","381436695@qq.com");
            recommend.send();*/

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("[给企业发校园招聘推广信]异常：" + e.getMessage(), e);
        }

        try {
            //个人的简历四大项不完整，通过WEBPOWERE发送
            logger.error("[个人的简历四大项不完整，通过WEBPOWERE发送]开始发送==============");
            Date date = new Date();
            ResumeNotPerfectSendByApi resumeNotPerfect = new ResumeNotPerfectSendByApi(MailServer.BAK1);
            resumeNotPerfect.sendMailByIntervalDays(date, -1, Constants.MAIL_TASK_SYSTEM_RESUME_NOT_PERFECT_D1);
            resumeNotPerfect = null;
        } catch (EmailServerConfigException e) {
            e.printStackTrace();
            logger.error("[个人的简历四大项不完整，通过WEBPOWERE发送]异常：" + e.getMessage(), e);
        }



        logger.error("==================== 每日发送进程 Day2 结束 =========================");
    }

}
