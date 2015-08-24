package com.job5156.common.api;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;

import com.dmdelivery.webservice.DMdeliveryLoginType;
import com.dmdelivery.webservice.DMdeliverySoapAPILocator;
import com.dmdelivery.webservice.DMdeliverySoapAPIPort;
import com.dmdelivery.webservice.MailingStatsSummaryResultType;
import com.dmdelivery.webservice.NewGroupType;
import com.dmdelivery.webservice.RecipientNameValuePairType;
import com.dmdelivery.webservice.RecordResultType;
import com.dmdelivery.webservice.RecordResultTypeStatus;
import com.job5156.common.Constants;

/**
 * 调用第三方SOAP接口发邮件
 * 第三方（WEBPOWER)的WS使用org.apache.axis，需要pom.xml先引入
 */
public class SendEmailByWebpowerApi {
    private static Logger logger = Logger.getLogger(SendEmailByWebpowerApi.class);

    private static SendEmailByWebpowerApi instance;

    private static DMdeliverySoapAPILocator serviceLocator;
    private static  DMdeliverySoapAPIPort service;
    private static String userName = "admin";
    private static String password = "Loxpwb1~a";
    private static DMdeliveryLoginType login = null;
    private static String  resultMail = "myejb22@163.com";  // result mail

    private SendEmailByWebpowerApi(){}

    public static SendEmailByWebpowerApi getInstance() {
        if (instance == null) {
            try { //初始化API,及API登录
                serviceLocator = new DMdeliverySoapAPILocator();
                service = serviceLocator.getDMdeliverySoapAPIPort();  // get an instance of the service
                login = new DMdeliveryLoginType(userName, password);
                return new SendEmailByWebpowerApi();
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    public static void main(String[] arg) throws Exception {
        String csvFileName = "pos-email-" + DateTime.now().toLocalDate().toString()+"-0" + ".csv";
        //SendEmailByWebpowerApi.getInstance().sendByCSV(csvFileName);
        SendEmailByWebpowerApi.getInstance().testSendSingleMailing();

    }

    /**
     * 通过CSV文件的方式发送邮件
     * @param csvfileName
     */
    public boolean sendByCSV(String csvfileName) {

        //String wsdlUrl = "https://job5156.dmdelivery.com/x/soap-v4/wsdl.php";
        // String csvfileName = "pos-email-"+ DateTime.now().toLocalDate().toString()+".csv";
        logger.error("==== START RUN sendByCSV() to SEND EMAIL ====" + csvfileName);
        String csvURL = "ftp://We8rp20:kS5ijKZoLmegZsCos4kBnHGAN@119.147.105.46:2921/" + csvfileName;  //csv 地址链接 eg: ftp://username:password@180.168.67.74/test.csv
        String csvCharset = "utf-8";
        boolean addDuplisToGroups = true;    //Whether or not to add this recipient to the groups, when the recipient is in the database already.
        boolean overwrite = true;     //overwrite
        String callbackUrl = "";
        int campaignId = 1;  //活动ID
        int mailingId = 29;  //邮件ID
        int testMailingId = 28; //测试的邮件ID
        int groupId = 6;//组ID
        int recipientId;

        try {
            RecordResultType result;
            //create group
            //创建一个临时组，以免重复
            Long temNum = DateTime.now().getMillis();
            NewGroupType group = new NewGroupType("tmp_"+temNum, true, "This group is Temp");
            try {
                result = service.addGroup(login, campaignId, group);
                if (result.getStatus() == RecordResultTypeStatus.ERROR) {
                    throw new RuntimeException("Error creating group " + result.getStatusMsg());
                } else {
                    groupId = result.getId(); // Group ID produced from database, group is used to group recipients addresses
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            //import csv file, and then send email RecordResultType
            result = service.importRemoteCSVSendMailing(
                    login,
                    campaignId,   //campaign id
                    groupId,      //group id
                    csvURL,
                    csvCharset,       //csvCharset
                    Constants.CSV_SEPARATOR,      //separator character
                    Constants.CSV_ENCLOSURE,     //enclosure character
                    addDuplisToGroups,     //Whether or not to add this recipient when exist.
                    overwrite,     //overwrite
                    mailingId,     //mail id
                    resultMail,  //result mail
                    0,        //filter id
                    new String[]{"cn"},    //lang
                    "",        // (AD) prefix
                    callbackUrl //callback url
            );
            // summarized statistics for a mailing sent
            MailingStatsSummaryResultType mailingStatsSummary = service.getMailingStatsSummary(
                    login,
                    campaignId,   //campaign id
                    mailingId  //mail id
            );
            mailingStatsSummary.getTotal_accepted();  //open number
            mailingStatsSummary.getTotal_sent();      //delivered number
            logger.error("SEND NUMBER =" + mailingStatsSummary.getTotal_sent());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 创建邮件组
     * @return
     */
    public int createGroup(){

        int campaignId = 1;  //活动ID

        RecordResultType result;
        NewGroupType group = new NewGroupType("Pos Recommend", true, "This group is Pos Recommend Create by job5156");
        int groupId = 0;
        try {
            result = service.addGroup(login, campaignId, group);
            if (result.getStatus() == RecordResultTypeStatus.ERROR) {
                throw new RuntimeException("Error creating group " + result.getStatusMsg());
            } else {
                groupId = result.getId(); // Group ID produced from database, group is used to group recipients addresses
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return  groupId;
    }


    /**
     * 单封邮件发送
     * 1.增加收件人，2.发送
     *
     * @param to            收件人email
     * @param content       邮件内容
     * @param campaignId    活动ID
     * @param mailingId     邮件ID
     * @param groupId       组ID
     * @return
     */
    public boolean sendSingleMailing(String to,String content,int campaignId,int mailingId,int groupId ) {
        //add a single recipient // 测试 增加一个收件人
        int recipientId = 0;
        RecordResultType result;

        try {
            result = service.addRecipient(login,
                    campaignId,
                    new int[]{groupId},
                    new RecipientNameValuePairType[]{
                            new RecipientNameValuePairType("email", to),
                            new RecipientNameValuePairType("content",content),
                    }, true,
                    // add duplicates to group
                    true);
            // overwrite existing recipients (matched on email)
            if (result.getStatus() == RecordResultTypeStatus.ERROR) {
                throw new RuntimeException("Error creating group " + result.getStatusMsg());
            } else {
                recipientId = result.getId(); // return recipientid for send single mailing
               // logger.info("recipientId" + recipientId);
            }

            Thread.sleep(500); //暂停一下，让收件人数据先上传完
            if(recipientId > 0){
                //Send single mailing 单封邮件发送测试
                Boolean singleMailing;
                singleMailing = service.sendSingleMailing(login, campaignId, mailingId, recipientId);
                if (singleMailing == false) {
                    throw new RuntimeException("Error send single mailing.");
                } else {
                    // logger.info("single mailing is send.");
                }
            }
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch(InterruptedException e){
             e.printStackTrace();
        }
        return false;
    }

    /**
     * 单封邮件发送,多参数封装模式
     * 1.增加收件人，2.发送
     *
     * @param recipientParam 收件人信息封装
     * @param campaignId     活动ID
     * @param mailingId      邮件ID
     * @param groupId        组ID
     * @return
     */
    public boolean sendSingleMailing(RecipientNameValuePairType[] recipientParam,int campaignId,int mailingId,int groupId ) {
        if(recipientParam.length == 0 ){return false;}
        //add a single recipient // 测试 增加一个收件人
        int recipientId = 0;
        RecordResultType result;

        try {
            result = service.addRecipient(login,
                    campaignId,
                    new int[]{groupId},recipientParam, true,
                    // add duplicates to group
                    true);
            // overwrite existing recipients (matched on email)
            if (result.getStatus() == RecordResultTypeStatus.ERROR) {
                throw new RuntimeException("Error creating group " + result.getStatusMsg());
            } else {
                recipientId = result.getId(); // return recipientid for send single mailing
                // logger.info("recipientId" + recipientId);
            }

            Thread.sleep(500); //暂停一下，让收件人数据先上传完
            if(recipientId > 0 ){
                //Send single mailing 单封邮件发送测试
                Boolean singleMailing;
                singleMailing = service.sendSingleMailing(login, campaignId, mailingId, recipientId);
                if (singleMailing == false) {
                    throw new RuntimeException("Error send single mailing.");
                } else {
                    // logger.info("single mailing is send.");
                }
            }

            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        return false;
    }

    /**
     * 测试单封邮件发送
     */
    public boolean testSendSingleMailing() {
        //add a single recipient // 测试 增加一个收件人
        int campaignId = 1;  //活动ID
        int mailingId = 29;  //邮件ID
        int testMailingId = 29; //测试的邮件ID
        int groupId = 70;   //组ID
        int recipientId = 0;
        RecordResultType result;

        try {
            result = service.addRecipient(login,
                    campaignId,
                    new int[]{groupId},
                    new RecipientNameValuePairType[]{
                            new RecipientNameValuePairType("email", "290413939@qq.com"),
                            new RecipientNameValuePairType("username", "test"),
                            new RecipientNameValuePairType("age", "25")
                    }, true,
                    // add duplicates to group
                    true);
            // overwrite existing recipients (matched on email)
            if (result.getStatus() == RecordResultTypeStatus.ERROR) {
                throw new RuntimeException("Error creating group " + result.getStatusMsg());
            } else {
                recipientId = result.getId(); // return recipientid for send single mailing
                System.out.printf("recipientId" + recipientId);
            }

            //Send single mailing 单封邮件发送测试
            Boolean singleMailing;
            singleMailing = service.sendSingleMailing(login, campaignId, testMailingId, recipientId);
            if (singleMailing == false) {
                throw new RuntimeException("Error send single mailing.");
            } else {
                System.out.printf("single mailing is send.");
            }
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();

        }
      return false;
    }
}
