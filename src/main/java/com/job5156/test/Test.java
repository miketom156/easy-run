package com.job5156.test;

import com.google.common.collect.Maps;
import com.job5156.beans.freemarker.FreemarkerConfigure;
import com.job5156.beans.mail.BaseMailSend;
import com.job5156.beans.mail.EmailSender;
import com.job5156.common.CommonEnum;
import com.job5156.common.Constants;
import com.job5156.common.exception.EmailServerConfigException;
import com.job5156.model.per.PerUser;
import com.job5156.vo.mail.BirthdayWishesMailVo;
import com.job5156.vo.mail.ResumeNotPerfectMailVo;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.StringWriter;
import java.net.URLEncoder;
import java.util.Map;

public class Test extends BaseMailSend {


    private static Logger logger = Logger.getLogger(Test.class);

    private static EmailSender sender;


    public Test() throws EmailServerConfigException {
        sender = new EmailSender(CommonEnum.MailServer.THIRD_EASEYE);
    }

    public Test(CommonEnum.MailServer mailServer) throws EmailServerConfigException {
        sender = new EmailSender(mailServer);
    }

    public static void main(String[] args) throws EmailServerConfigException {
        Test test = new Test(CommonEnum.MailServer.MAIN);
       // test.send();
        test.resumeNotPerfect();
    }

    @Override
    public void send() {
        try {
            for (int i = 0; i < 1; i++) {
                Map<String, Object> paramMap = Maps.newHashMap();
                paramMap.put("userName", "李庆锋");
                String email = getOneVaildEmail("mailtous@163.com");

                boolean flag = sender.send(new BirthdayWishesMailVo("test", new String[]{email}, Constants.MAIL_TYPE_SIMPLIFIED, paramMap));
                if(flag) {
                    System.out.printf("发送成功！ email:" + email );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /**
     * 简历未完善
     */
    public void resumeNotPerfect()  {

        try {
            PerUser perUser = new PerUser();
            perUser.setEmail("mailtous@qq.com");
            perUser.setId(7036336);
            perUser.setUserName("李庆锋");

            String mailContent = assembleMailContent(perUser);
            boolean flag = sender.send(new ResumeNotPerfectMailVo(mailContent, new String[]{perUser.getEmail()}, Constants.MAIL_TYPE_SIMPLIFIED));
            if (flag) {
                System.out.printf("发送成功！ email:" + perUser.getEmail());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private String assembleMailContent(PerUser perUser) throws IOException {
        if (perUser != null) {
            String unsubscribeLink = this.assembleUnsubscribeLink(perUser, Constants.MAIL_TASK_SYSTEM_RESUME_NOT_PERFECT);
            String resumeLink = "/login/per/?ref=" + URLEncoder.encode("/per/resume", "UTF-8");
            Map<String, Object> map = Maps.newHashMap();
            map.put("perUser", perUser);
            map.put("unsubscribeLink", unsubscribeLink);
            map.put("resumeLink", resumeLink);

            Configuration configure = FreemarkerConfigure.getFreemarkerConfig();
            Template template = configure.getTemplate("mail/third/system_pos_recommend.ftl");

            try {
                StringWriter result = new StringWriter();
                template.process(map, result);
                return result.toString();
            } catch (TemplateException e) {
                e.printStackTrace();
                logger.error("===邮件模板解析异常：" + e.getMessage(), e);
            }
        }
        return StringUtils.EMPTY;
    }

}


