package com.job5156.run.mail;

import org.apache.log4j.Logger;

import com.job5156.common.exception.EmailServerConfigException;
import com.job5156.common.util.HibernateActionUtil;
import com.job5156.common.util.HibernateCountUtil;
import com.job5156.common.util.HibernateUtil;
import com.job5156.task.mail.SendMailQueue;

/**
 * 定时运行发送邮件队列
 * 
 * @author leo
 * 
 */
public class RunSendMailQueue {
	private static final Logger logger = Logger.getLogger(RunSendMailQueue.class);

	public static void main(String[] args) {
		try {
			SendMailQueue sendMailQueue = new SendMailQueue();
			sendMailQueue.send();
		} catch (EmailServerConfigException e) {
			e.printStackTrace();
			logger.error("[系统发送队列邮件]异常：" + e.getMessage(), e);
		}
		
		HibernateUtil.closeSession();
		HibernateActionUtil.closeSession();
		HibernateCountUtil.closeSession();
	}
}
