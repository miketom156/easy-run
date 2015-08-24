package com.job5156.run.mail;

import com.job5156.common.exception.EmailServerConfigException;
import com.job5156.common.util.HibernateActionUtil;
import com.job5156.common.util.HibernateCountUtil;
import com.job5156.common.util.HibernateUtil;
import com.job5156.task.mail.SendMailQueue;
import org.apache.log4j.Logger;

/**
 * 定时运行发送邮件队列
 * 发送ID为偶数的邮件
 * @author leo
 * 
 */
public class RunSendMailQueueByP2 {
	private static final Logger logger = Logger.getLogger(RunSendMailQueueByP2.class);

	public static void main(String[] args) {
		try {
			SendMailQueue sendMailQueue = new SendMailQueue();
			sendMailQueue.startSendByIdType(SendMailQueue.NumberType.even); //发送ID为偶数的邮件
		} catch (EmailServerConfigException e) {
			e.printStackTrace();
			logger.error("[系统发送队列邮件]异常：" + e.getMessage(), e);
		}
		
		HibernateUtil.closeSession();
		HibernateActionUtil.closeSession();
		HibernateCountUtil.closeSession();
	}
}
