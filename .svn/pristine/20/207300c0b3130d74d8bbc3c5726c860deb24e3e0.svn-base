package com.job5156.run.mail.sales;

import com.job5156.common.util.HibernateCountUtil;
import com.job5156.common.util.HibernateUtil;
import com.job5156.task.mail.sales.EshopPerMail;
import org.apache.log4j.Logger;

/**
电商频道邮件推广
 */
@Deprecated
public class RunEshopPerMail {
    private static final Logger logger = Logger.getLogger(RunEshopPerMail.class);
    public static   void main(String[]  args){
        try {
            new EshopPerMail().send();
            HibernateUtil.closeSession();
            HibernateCountUtil.closeSession();
        } catch (Exception e) {
            logger.error("发送电商频道推广邮件出错！");
            e.printStackTrace();
        }
    }
}
