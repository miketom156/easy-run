package com.job5156.run.mail;

import java.text.ParseException;

import org.apache.log4j.Logger;

import com.job5156.common.exception.EmailServerConfigException;
import com.job5156.common.util.HibernateCountUtil;
import com.job5156.common.util.HibernateQuery2Util;
import com.job5156.common.util.HibernateSalveBaseUtil;
import com.job5156.task.count.CountSiteIndexCheckApp;

/**
 * 站点首页检测URL是否失效
 * @author Andy
 *
 */
public class RunSendCountIndexCheckApp {
	private static final Logger logger = Logger.getLogger(RunSendCountIndexCheckApp.class);

	public static void main(String[] args) {
		logger.error("==================== 站点首页检测URL是否失效 =========================");
		try {
            //站点首页检测URL是否失效
        	CountSiteIndexCheckApp app = new CountSiteIndexCheckApp();
        	app.siteIndexURLFailCheck();
        	app = null;
        	HibernateSalveBaseUtil.closeSession();
            HibernateCountUtil.closeSession(); 
        } catch (EmailServerConfigException e) {
            logger.error("[站点首页检测URL是否失效]异常：" + e.toString(), e);
        }
		
		logger.error("==================== 网站后台站点检测广告LOGO、企业与职位过期 =========================");
		try {
            //站点首页检测URL是否失效
        	CountSiteIndexCheckApp app = new CountSiteIndexCheckApp();
        	app.siteIndexAdminExpiredCheck();
        	app = null;
            HibernateSalveBaseUtil.closeSession();
            HibernateCountUtil.closeSession();
            HibernateQuery2Util.closeSession();
        } catch (EmailServerConfigException e) {
            logger.error("[网站后台站点检测广告LOGO、企业与职位过期]邮件发送异常：" + e.toString(), e);
        } catch (ParseException e) {
        	logger.error("[网站后台站点检测广告LOGO、企业与职位过期]日期解析异常：" + e.toString(), e);
		}
		
	}

}
