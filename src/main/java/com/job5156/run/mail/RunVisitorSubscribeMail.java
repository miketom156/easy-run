package com.job5156.run.mail;

import org.apache.log4j.Logger;

import com.job5156.common.exception.EmailServerConfigException;
import com.job5156.common.util.HibernateSalveBaseUtil;
import com.job5156.task.mail.VisitorSubscribe;

/**
 * 智通才富专题订阅邮件
 * <p>由于周琴那边不确定专题发布的时间，
 * 因此此邮件提醒需要手动执行</p>
 * @author Andy
 *
 */
public class RunVisitorSubscribeMail {
	private static final Logger logger = Logger.getLogger(RunVisitorSubscribeMail.class);
	
	public static void main(String[] args) {
		try {
			VisitorSubscribe subscribe = new VisitorSubscribe();
			subscribe.send();
		} catch (EmailServerConfigException e) {
			e.printStackTrace();
			logger.error("智通才富专题订阅邮件异常：" + e.getMessage(), e);
		}
		
		HibernateSalveBaseUtil.closeSession();
	}
}
