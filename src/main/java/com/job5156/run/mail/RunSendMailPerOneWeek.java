package com.job5156.run.mail;

import org.apache.log4j.Logger;

import com.job5156.common.Constants;
import com.job5156.common.CommonEnum.MailServer;
import com.job5156.common.exception.EmailServerConfigException;
import com.job5156.common.util.HibernateActionUtil;
import com.job5156.common.util.HibernateCountUtil;
import com.job5156.common.util.HibernateUtil;
import com.job5156.task.mail.ComNotReceiveResume;
import com.job5156.task.mail.ComPosExpireEmailRemind;

/**
 * 每一周发送一次邮件任务
 * 
 * @author leo
 * 
 */
public class RunSendMailPerOneWeek {
	private static final Logger logger = Logger.getLogger(RunSendMailPerOneWeek.class);

	public static void main(String[] args) {
        logger.error("==================== 每1周发送进程 开始 =========================");
		try {
			ComNotReceiveResume comReceive = new ComNotReceiveResume(MailServer.EXCHANGE);
			comReceive.send();
		} catch (EmailServerConfigException e) {
			e.printStackTrace();
			logger.error("[系统发送企业收到投递简历过少提醒邮件]异常：" + e.getMessage(), e);
		}
		
		try {
            //每周发送推荐企业职位到期邮件提醒
        	ComPosExpireEmailRemind comPosExpire = new ComPosExpireEmailRemind();
        	comPosExpire.sendMailByIntervalDays(Constants.MAIL_TASK_COM_POS_EXPIRE);
        	comPosExpire = null;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("[每周发送推荐企业职位到期邮件提醒]异常：" + e.getMessage(), e);
        }
		
		HibernateUtil.closeSession();
		HibernateActionUtil.closeSession();
		HibernateCountUtil.closeSession();
	}
}
