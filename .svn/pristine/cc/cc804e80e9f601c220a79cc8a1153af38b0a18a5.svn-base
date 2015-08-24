package com.job5156.run.mail;

import java.util.Date;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;

import com.job5156.common.Constants;
import com.job5156.common.CommonEnum.MailServer;
import com.job5156.common.exception.EmailServerConfigException;
import com.job5156.common.util.HibernateActionUtil;
import com.job5156.common.util.HibernateCountUtil;
import com.job5156.common.util.HibernateUtil;
import com.job5156.task.mail.LargeSystemPosRecommend;

/**
 * <p>
 * 大量发送职位推荐邮件1
 * </p>
 * 
 * @author leo
 * 
 */
@Deprecated
public class RunLargeSendPosRecommend1 {
	private static final Logger logger = Logger.getLogger(RunLargeSendPosRecommend1.class);

	public static void main(String[] args) {
		try {
			LargeSystemPosRecommend recommend = new LargeSystemPosRecommend(
					MailServer.BAK1);
			Date date1 = DateTime.now().minusDays(15).toDate();
			//Date date2 = new DateTime(date1).minusDays(274).toDate();
			recommend.sendMailByIntervalDays(date1, -273,Constants.MAIL_TASK_SYSTEM_POS_RECOMMEND_LARGE,"进程1");
			recommend = null;
		} catch (EmailServerConfigException e) {
			e.printStackTrace();
			logger.error("[系统发送职位推荐进程1]异常：" + e.getMessage(), e);
		}
		
		HibernateUtil.closeSession();
		HibernateActionUtil.closeSession();
		HibernateCountUtil.closeSession();
	}
}
