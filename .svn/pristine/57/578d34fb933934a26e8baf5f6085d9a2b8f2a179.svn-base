package com.job5156.run.mail;

import com.job5156.common.Constants;
import com.job5156.common.exception.EmailServerConfigException;
import com.job5156.common.util.HibernateActionUtil;
import com.job5156.common.util.HibernateCountUtil;
import com.job5156.common.util.HibernateUtil;
import com.job5156.task.mail.LargePosRecommendToFile;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;

import java.util.Date;

/**
 * 通过外部API接口发邮件-进程2
 *
 * @author leeton
 *
 */
@Deprecated
public class RunSendMailByApiProcess2 {
	private static final Logger logger = Logger.getLogger(RunSendMailByApiProcess2.class);

	public static void main(String[] args) {
		try {
            LargePosRecommendToFile recommend = new LargePosRecommendToFile();
            recommend.setTestMailAddr("yf_198407@163.com", "jmail168@163.com","dghxc@job5156.com","381436695@qq.com");
            Date date2 = DateTime.now().minusDays(288).toDate();
            recommend.sendMailByIntervalDays(date2, -274,Constants.MAIL_TASK_SYSTEM_POS_RECOMMEND_WPAPI_P2,"P2"); //进程2
			recommend = null;
		} catch (EmailServerConfigException e) {
			e.printStackTrace();
			logger.error(Constants.sendMailTaskType.get(Constants.MAIL_TASK_SYSTEM_POS_RECOMMEND_WPAPI_P2) + e.getMessage(), e);
		}
		
		HibernateUtil.closeSession();
		HibernateActionUtil.closeSession();
		HibernateCountUtil.closeSession();
	}
}
