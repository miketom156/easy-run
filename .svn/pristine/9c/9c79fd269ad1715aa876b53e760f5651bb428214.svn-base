package com.job5156.common.api;

import com.easeye.webservice.*;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;

import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;

/**
 * 调用第三方SOAP接口发邮件
 * 第三方（EASEYE)的WS使用org.apache.axis，需要pom.xml先引入
 */
public class SendEmailByEaseYeApi {
    private static Logger logger = Logger.getLogger(SendEmailByEaseYeApi.class);

    private static SendEmailByEaseYeApi instance;

    private static MailWebServiceLocator serviceLocator;
    private static MailWebServiceSoap service;
    private static String userName = "lyzq728@126.com"; //帐户名
    private static String password = "lyzq728@126.com"; //密码
    private static EaseyeUserAccountDTO accountDTO = new EaseyeUserAccountDTO();
    private static String  resultMail = "290413939@qq.com";  // result mail

    private SendEmailByEaseYeApi(){}

    public static SendEmailByEaseYeApi getInstance() {
        if (instance == null) {
            try { //初始化API,及API登录
                serviceLocator = new MailWebServiceLocator();
                service = serviceLocator.getMailWebServiceSoap();  // get an instance of the service
                accountDTO.setEmail(userName);
                accountDTO.setPassword(password);
                return new SendEmailByEaseYeApi();
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    public static void main(String[] arg) throws Exception {
        SendEmailByEaseYeApi sendEmailApi = SendEmailByEaseYeApi.getInstance();

        EaseyeGroupDTO group = sendEmailApi.createTempGroup();
        EaseyeMessageReceiveDTO messageReceiveDTO = new EaseyeMessageReceiveDTO();
        messageReceiveDTO.setFullName("leeton");
        messageReceiveDTO.setTo("yf_198407@163.com");
        EaseyeMessageReceiveDTO[] messageArray = sendEmailApi.createContactMessage(messageReceiveDTO);

        group = sendEmailApi.importContactByGroupDetail(group, messageArray, "");

        if(group != null){
            EaseyeSendOptionDTO easeyeSendOptionDTO = sendEmailApi.getSendOption();

            EaseyeMessageTemplateDTO easeyeMessageTemplateDTO = new  EaseyeMessageTemplateDTO();
            easeyeMessageTemplateDTO.setTemplateName("position recommend"); //网上的模板名

            sendEmailApi.sendMailByGroup(easeyeMessageTemplateDTO, group, easeyeSendOptionDTO);
        }

    }

    public void send(String content) {
        SendEmailByEaseYeApi sendEmailApi = SendEmailByEaseYeApi.getInstance();

        EaseyeGroupDTO group = sendEmailApi.createTempGroup();
        EaseyeMessageReceiveDTO messageReceiveDTO = new EaseyeMessageReceiveDTO();
        messageReceiveDTO.setFullName("leeton");
        messageReceiveDTO.setTo("yf_198407@163.com");
        EaseyeMessageReceiveDTO[] messageArray = sendEmailApi.createContactMessage(messageReceiveDTO);

        group = sendEmailApi.importContactByGroupDetail(group, messageArray, "");

        if(group != null){
            EaseyeSendOptionDTO easeyeSendOptionDTO = sendEmailApi.getSendOption();

            EaseyeMessageTemplateDTO easeyeMessageTemplateDTO = new  EaseyeMessageTemplateDTO();
            easeyeMessageTemplateDTO.setTemplateName("position recommend"); //网上的模板名
            easeyeMessageTemplateDTO.setSubject("");
            easeyeMessageTemplateDTO.setBody("");
            sendEmailApi.sendMailByGroup(easeyeMessageTemplateDTO, group, easeyeSendOptionDTO);
        }
    }


    /**
     * 创建临时邮件组
     * @return
     */
    public EaseyeGroupDTO createTempGroup() {

        String t = DateTime.now().toString("yyyyMMddHHmmss");
        EaseyeGroupDTO group = new EaseyeGroupDTO("pos_" + t, 1, "");
        return group;
    }

    /**
     * 建立以日期区分的组
     * @return
     */
    public EaseyeGroupDTO createGroupInToday() {

        String t = DateTime.now().toString("yyyyMMdd");
        EaseyeGroupDTO group = new EaseyeGroupDTO("pos_" + t, 1, "");
        return group;
    }

    /**
     * 创建联系人信息数组
     */
    public EaseyeMessageReceiveDTO[] createContactMessage(EaseyeMessageReceiveDTO messageReceiveDTO) {

        EaseyeMessageReceiveDTO[] messageArray = new  EaseyeMessageReceiveDTO[]{(messageReceiveDTO)};
        return messageArray;
    }

    /**
     * 导入联系人资料到平台(每次导入的数据不能超过1000）
     * @param group
     * @param messageArray
     * @param importName
     * @return
     */
    public EaseyeGroupDTO importContactByGroupDetail(EaseyeGroupDTO group,
                                                     EaseyeMessageReceiveDTO[] messageArray,
                                                     String importName) {

        EaseyeDetailedResultReturnDTO returnDTO = null;
        try {
            returnDTO = service.importContactByGroupDetailed(accountDTO, group, messageArray, importName);
            if (returnDTO.getErrorCode() >=200 && returnDTO.getErrorCode()<300 ) {
                return group;
            } else {
                logger.error("error  :" + returnDTO.getErrorInfo());
            }
        } catch (RemoteException e) {
            logger.error("调用亿业WS-API,导入组到平台失败(importContactByGroupDetail)："+e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 发送某一组邮件
     * @param template
     * @param groupDTO
     * @param sendOptionDTO
     * @return
     */
    public boolean sendMailByGroup(EaseyeMessageTemplateDTO template,
                                   EaseyeGroupDTO groupDTO,
                                   EaseyeSendOptionDTO sendOptionDTO) {

        EaseyeReturnDTO returnDTO = null;
        try {
            returnDTO = service.sendMailListRequestByGroup(accountDTO, template, groupDTO, sendOptionDTO);

            if (returnDTO.getErrorCode() >= 200 && returnDTO.getErrorCode() < 300) {
                return true;
            } else {
                logger.error("发送失败:error code  :" + returnDTO.getErrorCode() +"  error info : " + returnDTO.getErrorInfo());
            }
        } catch (RemoteException e) {
            logger.error("调用亿业WS-API,发送邮件组（sendMailByGroup）："+e.getMessage());
            e.printStackTrace();
        }

        return false;
    }

    /**
     * 设置发送选项
     * @return
     */
    public EaseyeSendOptionDTO  getSendOption(){

        EaseyeSendOptionDTO sendOptionDTO = new EaseyeSendOptionDTO();
        sendOptionDTO.setMailProjectName("pos_recommend");
        sendOptionDTO.setMailListName("pos_recommend_list");
        sendOptionDTO.setSenderName("智通人才网");
        sendOptionDTO.setIsActive(true);
        sendOptionDTO.setSenderEmail("noreply@newsletter.job5156.com");
        return sendOptionDTO;
    }


}
