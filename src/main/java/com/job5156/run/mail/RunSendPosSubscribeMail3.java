package com.job5156.run.mail;

import org.apache.log4j.Logger;

import com.job5156.common.Constants;
import com.job5156.common.exception.EmailServerConfigException;
import com.job5156.common.util.HibernateSalveBaseUtil;
import com.job5156.task.mail.PositionSubscribe;

/**
 * 发送职位订阅邮件主进程(默认发送周期3天)
 * @author Andy
 *
 */
public class RunSendPosSubscribeMail3 {
	private static final Logger logger = Logger.getLogger(RunSendPosSubscribeMail3.class);
	
	public static void main(String[] args) {
		try {
			PositionSubscribe subscribe = new PositionSubscribe();
			subscribe.sendMailByIntervalDays(3, Constants.MAIL_TASK_SYSTEM_POS_SUBSCRIBE_3);
		} catch (EmailServerConfigException e) {
			e.printStackTrace();
			logger.error("发送职位订阅邮件异常：" + e.getMessage(), e);
		}
		
		HibernateSalveBaseUtil.closeSession();
	}

}
