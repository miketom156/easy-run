package com.job5156.run.mail.sales;

import com.job5156.common.util.HibernateCountUtil;
import com.job5156.common.util.HibernateUtil;
import com.job5156.task.mail.sales.WeiXinServiceToPer;
import org.apache.log4j.Logger;

/**
 微信服务号邮件推广
 */
@Deprecated
public class RunWeiXinServiceToPer {
    private static final Logger logger = Logger.getLogger(RunWeiXinServiceToPer.class);
    public static   void main(String[]  args){
        try {
            new WeiXinServiceToPer().send();
            HibernateUtil.closeSession();
            HibernateCountUtil.closeSession();
        } catch (Exception e) {
            logger.error("发送微信服务号推广邮件出错！");
            e.printStackTrace();
        }
    }
}
