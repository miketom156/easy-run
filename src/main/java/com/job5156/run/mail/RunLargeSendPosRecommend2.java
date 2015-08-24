package com.job5156.run.mail;

import com.job5156.common.Constants;
import com.job5156.common.CommonEnum.MailServer;
import com.job5156.common.exception.EmailServerConfigException;
import com.job5156.common.util.HibernateActionUtil;
import com.job5156.common.util.HibernateCountUtil;
import com.job5156.common.util.HibernateUtil;
import com.job5156.task.mail.LargeSystemPosRecommend;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;

import java.util.Date;

/**
 * <p>
 * 大量发送职位推荐邮件2
 * </p>
 * 
 * @author leo
 * 
 */
@Deprecated
public class RunLargeSendPosRecommend2 {
	private static final Logger logger = Logger.getLogger(RunLargeSendPosRecommend2.class);

	public static void main(String[] args) {
		try {
            LargeSystemPosRecommend recommend = new LargeSystemPosRecommend(MailServer.BAK1);
            Date date1 = DateTime.now().minusDays(288).toDate();  //0.75年 +15天
			recommend.sendMailByIntervalDays(date1, -273,Constants.MAIL_TASK_SYSTEM_POS_RECOMMEND_LARGE,"进程2");
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
