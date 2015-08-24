package com.job5156.run.mail;

import org.apache.log4j.Logger;

import com.job5156.common.exception.EmailServerConfigException;
import com.job5156.common.util.HibernateCountUtil;
import com.job5156.common.util.HibernateUtil;
import com.job5156.task.mail.ResumeSubscribe;

/**
 * 发送简历订阅邮件
 *
 * @author leo
 */
public class RunSendResSubscribeMail {
    private static final Logger logger = Logger.getLogger(RunSendResSubscribeMail.class);

    public static void main(String[] args) {
        try {
            ResumeSubscribe subscribe = new ResumeSubscribe();
            for (String arg : args) {
                if (arg.startsWith("--comUserId")) {
                    subscribe.setComUserId(arg.substring("--comUserId=".length()));
                }
            }
            subscribe.send();
        } catch (EmailServerConfigException e) {
            e.printStackTrace();
            logger.error("发送简历订阅邮件异常：" + e.getMessage(), e);
        }

        HibernateUtil.closeSession();
        HibernateCountUtil.closeSession();
    }
}
