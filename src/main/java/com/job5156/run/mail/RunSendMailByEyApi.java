package com.job5156.run.mail;

import com.job5156.common.CommonEnum.MailServer;
import com.job5156.common.Constants;
import com.job5156.common.exception.EmailServerConfigException;
import com.job5156.common.util.HibernateUtil;
import com.job5156.task.mail.*;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;

import java.util.Date;

/**
 * <p>
 * 使用亿业科技API,每天发送邮件进程
 * </p>
 * 
 * @author leeton
 * 
 */
public class RunSendMailByEyApi {
	private static final Logger logger = Logger.getLogger(RunSendMailByEyApi.class);

	public static void main(String[] args) {

        logger.error("==================== 每日发送进程 使用亿业API 开始 =========================");
/*		try {
            //使用[EASEYE]给(15-175)天未登录过的个人用户发推荐职位
            //通过SMTP-API发送
        	Date date = new Date();
            PosRecommendByEaseyeApiAndThread posRecommendByEaseyeApi = new PosRecommendByEaseyeApiAndThread(MailServer.THIRD_EASEYE);
            posRecommendByEaseyeApi.setSendLimitNum(4000);
            posRecommendByEaseyeApi.setSendTestMailPerNum(1000);
            Date date1 = DateTime.now().minusDays(15).toDate();
            posRecommendByEaseyeApi.sendMailByIntervalDays(date1, -175,Constants.MAIL_TASK_SYSTEM_POS_RECOMMEND_EYAPI_P1,"P1"); //15-175
            posRecommendByEaseyeApi = null;
            HibernateUtil.closeSession();

        } catch (EmailServerConfigException e) {
            logger.error(Constants.sendMailTaskType.get(Constants.MAIL_TASK_SYSTEM_POS_RECOMMEND_EYAPI_P1) +"发生异常:" + e.getMessage(), e);
            e.printStackTrace();
        }*/

        try {
            //使用[EASEYE]给(15-175)天未登录过的个人用户发推荐职位
            //通过webservice-API发送
            Date date = new Date();
            PosRecommendByEyWsApi posRecommendByEyWsApi = new PosRecommendByEyWsApi();
            posRecommendByEyWsApi.setSendLimitNum(2000);
            posRecommendByEyWsApi.setSendTestMailPerNum(1000);
            Date date1 = DateTime.now().minusDays(15).toDate();
            posRecommendByEyWsApi.sendMailByIntervalDays(date1, -175,Constants.MAIL_TASK_SYSTEM_POS_RECOMMEND_EYAPI_P1,"P1"); //15-175
            posRecommendByEyWsApi = null;
            HibernateUtil.closeSession();

        } catch (EmailServerConfigException e) {
            logger.error(Constants.sendMailTaskType.get(Constants.MAIL_TASK_SYSTEM_POS_RECOMMEND_EYAPI_P1) +"发生异常:" + e.getMessage(), e);
            e.printStackTrace();
        }

        logger.error("==================== 每日发送进程 使用亿业API 结束 =========================");
	}

}
