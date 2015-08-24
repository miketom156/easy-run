package com.easeye.webservice;

public class MailWebServiceSoapProxy implements com.easeye.webservice.MailWebServiceSoap {
  private String _endpoint = null;
  private com.easeye.webservice.MailWebServiceSoap mailWebServiceSoap = null;
  
  public MailWebServiceSoapProxy() {
    _initMailWebServiceSoapProxy();
  }
  
  public MailWebServiceSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initMailWebServiceSoapProxy();
  }
  
  private void _initMailWebServiceSoapProxy() {
    try {
      mailWebServiceSoap = (new com.easeye.webservice.MailWebServiceLocator()).getMailWebServiceSoap();
      if (mailWebServiceSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)mailWebServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)mailWebServiceSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (mailWebServiceSoap != null)
      ((javax.xml.rpc.Stub)mailWebServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.easeye.webservice.MailWebServiceSoap getMailWebServiceSoap() {
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap;
  }
  
  public String helloWorld() throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.helloWorld();
  }
  
  public com.easeye.webservice.EaseyeReturnDTO sendMailListRequest(EaseyeUserAccountDTO easeyeUserAccountDTO,com.easeye.webservice.EaseyeMessageTemplateDTO easeyeMessageTemplateDTO,com.easeye.webservice.EaseyeMessageReceiveDTO[] easeyeMessageReceiveDTOArray,com.easeye.webservice.EaseyeSendOptionDTO easeyeSendOptionDTO) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.sendMailListRequest(easeyeUserAccountDTO, easeyeMessageTemplateDTO, easeyeMessageReceiveDTOArray, easeyeSendOptionDTO);
  }
  
  public com.easeye.webservice.EaseyeReturnDTO sendMailListRequestByGroup(EaseyeUserAccountDTO easeyeUserAccountDTO,com.easeye.webservice.EaseyeMessageTemplateDTO easeyeMessageTemplateDTO,com.easeye.webservice.EaseyeGroupDTO easeyeGroupDTO,com.easeye.webservice.EaseyeSendOptionDTO easeyeSendOptionDTO) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.sendMailListRequestByGroup(easeyeUserAccountDTO, easeyeMessageTemplateDTO, easeyeGroupDTO, easeyeSendOptionDTO);
  }
  
  public com.easeye.webservice.EaseyeDetailedResultReturnDTO cancelMaillist(EaseyeUserAccountDTO easeyeUserAccountDTO, String mailListName) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.cancelMaillist(easeyeUserAccountDTO, mailListName);
  }
  
  public com.easeye.webservice.EaseyeReturnDTO importContactByGroup(EaseyeUserAccountDTO easeyeUserAccountDTO,com.easeye.webservice.EaseyeGroupDTO easeyeGroupDTO,com.easeye.webservice.EaseyeMessageReceiveDTO[] easeyeMessageReceiveDTOArray) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.importContactByGroup(easeyeUserAccountDTO, easeyeGroupDTO, easeyeMessageReceiveDTOArray);
  }
  
  public com.easeye.webservice.EaseyeDetailedResultReturnDTO importContactByGroupExt(EaseyeUserAccountDTO easeyeUserAccountDTO,com.easeye.webservice.EaseyeGroupDTO easeyeGroupDTO,com.easeye.webservice.EaseyeMessageCustomReceiverDTO easeyeMessageReceiveDTO, String importName) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.importContactByGroupExt(easeyeUserAccountDTO, easeyeGroupDTO, easeyeMessageReceiveDTO, importName);
  }
  
  public com.easeye.webservice.EaseyeDetailedResultReturnDTO importContactByGroupDetailed(EaseyeUserAccountDTO easeyeUserAccountDTO,com.easeye.webservice.EaseyeGroupDTO easeyeGroupDTO,com.easeye.webservice.EaseyeMessageReceiveDTO[] easeyeMessageReceiveDTOArray, String importName) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.importContactByGroupDetailed(easeyeUserAccountDTO, easeyeGroupDTO, easeyeMessageReceiveDTOArray, importName);
  }
  
  public com.easeye.webservice.EaseyeReturnDTO moveContactToNewGroup(EaseyeUserAccountDTO easeyeUserAccountDTO, String newGroupName,com.easeye.webservice.EaseyeMessageReceiveDTO[] easeyeMessageReceiveDTOArray) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.moveContactToNewGroup(easeyeUserAccountDTO, newGroupName, easeyeMessageReceiveDTOArray);
  }
  
  public com.easeye.webservice.MailStatusReportDTO sendMailReportResponse(EaseyeUserAccountDTO easeyeUserAccountDTO, String queryId, int reportOption) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.sendMailReportResponse(easeyeUserAccountDTO, queryId, reportOption);
  }
  
  public int getCountByGroupName(EaseyeUserAccountDTO easeyeUserAccountDTO, String groupName) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.getCountByGroupName(easeyeUserAccountDTO, groupName);
  }
  
  public boolean queryContactByGroup(EaseyeUserAccountDTO easeyeUserAccountDTO, String groupName, String email) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.queryContactByGroup(easeyeUserAccountDTO, groupName, email);
  }
  
  public com.easeye.webservice.EaseyeGroupDTO[] getGroupList(EaseyeUserAccountDTO easeyeUserAccountDTO) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.getGroupList(easeyeUserAccountDTO);
  }
  
  public void modifyGroupName(EaseyeUserAccountDTO easeyeUserAccountDTO, String oldGroupName, String newGroupName) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    mailWebServiceSoap.modifyGroupName(easeyeUserAccountDTO, oldGroupName, newGroupName);
  }
  
  public com.easeye.webservice.EaseyeReturnDTO deleteGroupByGroupName(EaseyeUserAccountDTO easeyeUserAccountDTO, String groupName) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.deleteGroupByGroupName(easeyeUserAccountDTO, groupName);
  }
  
  public void createTask(EaseyeUserAccountDTO easeyeUserAccountDTO) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    mailWebServiceSoap.createTask(easeyeUserAccountDTO);
  }
  
  public com.easeye.webservice.EaseyeReturnDTO sendTemplate(SendTemplateRequest sendTemplateRequest) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.sendTemplate(sendTemplateRequest);
  }
  
  public boolean accessCheck(String userName, String password) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.accessCheck(userName, password);
  }
  
  public com.easeye.webservice.EaseyeReturnDTO addUser(EaseyeUserAccountDTO easeyeUserAccountDTO,com.easeye.webservice.CustomMailUser mailUser) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.addUser(easeyeUserAccountDTO, mailUser);
  }
  
  public com.easeye.webservice.EaseyeReturnDTO updateUser(EaseyeUserAccountDTO easeyeUserAccountDTO,com.easeye.webservice.CustomMailUser mailUser) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.updateUser(easeyeUserAccountDTO, mailUser);
  }
  
  public com.easeye.webservice.EaseyeReturnDTO manageUserPoint(EaseyeUserAccountDTO easeyeUserAccountDTO, String email, int point) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.manageUserPoint(easeyeUserAccountDTO, email, point);
  }
  
  public com.easeye.webservice.MailStatusReportDTO[] getSumReport(EaseyeUserAccountDTO easeyeUserAccountDTO, String projectName, String maillistName, java.util.Calendar sentDatetimeFrom, java.util.Calendar sentDatetimeTo) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.getSumReport(easeyeUserAccountDTO, projectName, maillistName, sentDatetimeFrom, sentDatetimeTo);
  }
  
  public com.easeye.webservice.ReportDetail[] getReportDetail(EaseyeUserAccountDTO easeyeUserAccountDTO, int sentMailListId, int sentFlag, int pageSize, int currentPageIndex) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.getReportDetail(easeyeUserAccountDTO, sentMailListId, sentFlag, pageSize, currentPageIndex);
  }
  
  public com.easeye.webservice.ReportMoreDetail[] getReportMoreDetail(EaseyeUserAccountDTO easeyeUserAccountDTO, int sentMailListId, int sentFlag, int pageSize, int currentPageIndex) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.getReportMoreDetail(easeyeUserAccountDTO, sentMailListId, sentFlag, pageSize, currentPageIndex);
  }
  
  public com.easeye.webservice.WebServiceReportReturnDTO getWebServiceSumReport(EaseyeUserAccountDTO easeyeUserAccountDTO, String templateName, java.util.Calendar sentDatetimeFrom, java.util.Calendar sentDatetimeTo) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.getWebServiceSumReport(easeyeUserAccountDTO, templateName, sentDatetimeFrom, sentDatetimeTo);
  }
  
  public com.easeye.webservice.WebServiceReportDetailReturnDTO getWebServiceReportDetail(EaseyeUserAccountDTO easeyeUserAccountDTO, String templateName, java.util.Calendar sentDatetimeFrom, java.util.Calendar sentDatetimeTo, int sentFlag, int pageSize, int currentPageIndex) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.getWebServiceReportDetail(easeyeUserAccountDTO, templateName, sentDatetimeFrom, sentDatetimeTo, sentFlag, pageSize, currentPageIndex);
  }
  
  public com.easeye.webservice.MailReportDetailReturnDTO getMailReportDetail(EaseyeUserAccountDTO easeyeUserAccountDTO, int sentMailListId, int sentFlag, int pageSize, int currentPageIndex) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.getMailReportDetail(easeyeUserAccountDTO, sentMailListId, sentFlag, pageSize, currentPageIndex);
  }
  
  public com.easeye.webservice.MailSumReportReturnDTO getMailSumReport(EaseyeUserAccountDTO easeyeUserAccountDTO, String projectName, String maillistName, java.util.Calendar sentDatetimeFrom, java.util.Calendar sentDatetimeTo) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.getMailSumReport(easeyeUserAccountDTO, projectName, maillistName, sentDatetimeFrom, sentDatetimeTo);
  }
  
  public com.easeye.webservice.EaseyeDetailedResultReturnDTO EY_ImportContactByGroupDetailed(EaseyeUserAccountDTO easeyeUserAccountDTO,com.easeye.webservice.EaseyeGroupDTO easeyeGroupDTO,com.easeye.webservice.EY_MessageReceiveDTO[] ey_MessageReceiveDTOArray) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.EY_ImportContactByGroupDetailed(easeyeUserAccountDTO, easeyeGroupDTO, ey_MessageReceiveDTOArray);
  }
  
  public com.easeye.webservice.EaseyeReturnDTO EY_SendMailListRequest(EaseyeUserAccountDTO easeyeUserAccountDTO,com.easeye.webservice.EaseyeMessageTemplateDTO easeyeMessageTemplateDTO,com.easeye.webservice.EY_MessageReceiveDTO[] ey_MessageReceiveDTOArray,com.easeye.webservice.EaseyeSendOptionDTO easeyeSendOptionDTO) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.EY_SendMailListRequest(easeyeUserAccountDTO, easeyeMessageTemplateDTO, ey_MessageReceiveDTOArray, easeyeSendOptionDTO);
  }
  
  public com.easeye.webservice.EY_MailStatusReportDTO[] EY_GetSumReport(EaseyeUserAccountDTO easeyeUserAccountDTO, String projectName, String maillistName, java.util.Calendar sentDatetimeFrom, java.util.Calendar sentDatetimeTo) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.EY_GetSumReport(easeyeUserAccountDTO, projectName, maillistName, sentDatetimeFrom, sentDatetimeTo);
  }
  
  public com.easeye.webservice.EaseyeDetailedResultReturnDTO getImportFailedRecords(EaseyeUserAccountDTO easeyeUserAccountDTO, String importName, int pageSize, int currentPageIndex) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.getImportFailedRecords(easeyeUserAccountDTO, importName, pageSize, currentPageIndex);
  }
  
  public com.easeye.webservice.EaseyeReturnDTO validateEmail(EaseyeUserAccountDTO easeyeUserAccountDTO, String email, String returnUrl) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.validateEmail(easeyeUserAccountDTO, email, returnUrl);
  }
  
  public com.easeye.webservice.GetGroupInfoReturnDTO getGroupInfoByGroupName(EaseyeUserAccountDTO easeyeUserAccountDTO, String groupName) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.getGroupInfoByGroupName(easeyeUserAccountDTO, groupName);
  }
  
  public com.easeye.webservice.MailContactInActionReturnDTO getMailContactInAction(EaseyeUserAccountDTO easeyeUserAccountDTO, int sentFlag, java.util.Calendar dateFrom, java.util.Calendar dateTo, int pageSize, int currentPageIndex) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.getMailContactInAction(easeyeUserAccountDTO, sentFlag, dateFrom, dateTo, pageSize, currentPageIndex);
  }
  
  public com.easeye.webservice.EaseyeMailSenderStatusReturnDTO getMailSenderStatus(EaseyeUserAccountDTO easeyeUserAccountDTO, String email, String sendEmail) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.getMailSenderStatus(easeyeUserAccountDTO, email, sendEmail);
  }
  
  public com.easeye.webservice.EaseyeDetailedResultReturnDTO updateRecipientsStatus(EaseyeUserAccountDTO easeyeUserAccountDTO, String[] recipients, int status) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.updateRecipientsStatus(easeyeUserAccountDTO, recipients, status);
  }
  
  public com.easeye.webservice.EaseyeReturnDTO removeTemplate(EaseyeUserAccountDTO easeyeUserAccountDTO, String templateName) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.removeTemplate(easeyeUserAccountDTO, templateName);
  }
  
  public com.easeye.webservice.EaseyeReturnDTO updateTemplate(EaseyeUserAccountDTO easeyeUserAccountDTO,com.easeye.webservice.EaseyeMessageTemplateDTO easeyeMessageTemplateDTO) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.updateTemplate(easeyeUserAccountDTO, easeyeMessageTemplateDTO);
  }
  
  public com.easeye.webservice.EaseyeReturnDTO sendMail(EaseyeUserAccountDTO easeyeUserAccountDTO,com.easeye.webservice.EaseyeMessageReceiveDTO easeyeMessageReceiveDTO, String templateName,com.easeye.webservice.EaseyeSendOptionDTO easeyeSendOptionDTO) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.sendMail(easeyeUserAccountDTO, easeyeMessageReceiveDTO, templateName, easeyeSendOptionDTO);
  }
  
  public com.easeye.webservice.SmtpSendResultReturnDTO getSmtpSendResultByEmail(EaseyeUserAccountDTO easeyeUserAccountDTO, String email, java.util.Calendar dtBeginTime, java.util.Calendar dtEndTime) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.getSmtpSendResultByEmail(easeyeUserAccountDTO, email, dtBeginTime, dtEndTime);
  }
  
  public com.easeye.webservice.SmtpSendResultPaginationReturnDTO getSmtpSendResult(EaseyeUserAccountDTO easeyeUserAccountDTO, String email, java.util.Calendar dtBeginTime, java.util.Calendar dtEndTime, int pageIndex, int pageSize) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.getSmtpSendResult(easeyeUserAccountDTO, email, dtBeginTime, dtEndTime, pageIndex, pageSize);
  }
  
  public com.easeye.webservice.AttachmentReturnDTO uploadAttachment(EaseyeUserAccountDTO easeyeUserAccountDTO, String attachmentContent, String attachmentName, String uploadMode) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.uploadAttachment(easeyeUserAccountDTO, attachmentContent, attachmentName, uploadMode);
  }
  
  public com.easeye.webservice.AttachmentReturnDTO attachmentQuery(EaseyeUserAccountDTO easeyeUserAccountDTO, String fileName) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.attachmentQuery(easeyeUserAccountDTO, fileName);
  }
  
  public com.easeye.webservice.GetTopicReturnDTO getMailTopics(EaseyeUserAccountDTO easeyeUserAccountDTO) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.getMailTopics(easeyeUserAccountDTO);
  }
  
  public com.easeye.webservice.GetTopicByTopicNameReturnDTO getMailTopic(EaseyeUserAccountDTO easeyeUserAccountDTO, String topicName) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.getMailTopic(easeyeUserAccountDTO, topicName);
  }
  
  public com.easeye.webservice.EaseyeReturnDTO addMailTopic(EaseyeUserAccountDTO easeyeUserAccountDTO,com.easeye.webservice.Mail_Topic topic) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.addMailTopic(easeyeUserAccountDTO, topic);
  }
  
  public com.easeye.webservice.EaseyeReturnDTO modifyMailTopic(EaseyeUserAccountDTO easeyeUserAccountDTO,com.easeye.webservice.Mail_Topic topic) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.modifyMailTopic(easeyeUserAccountDTO, topic);
  }
  
  public com.easeye.webservice.EaseyeReturnDTO deleteMailTopic(EaseyeUserAccountDTO easeyeUserAccountDTO, String topicName) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.deleteMailTopic(easeyeUserAccountDTO, topicName);
  }
  
  public com.easeye.webservice.EaseyeDetailedResultReturnDTO updateRecipientsStatusExt(EaseyeUserAccountDTO easeyeUserAccountDTO, String[] recipients, int status, String topicNames) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.updateRecipientsStatusExt(easeyeUserAccountDTO, recipients, status, topicNames);
  }
  
  public com.easeye.webservice.EaseyeDetailedResultReturnDTO deleteContactByGroup(EaseyeUserAccountDTO easeyeUserAccountDTO, String[] emails, String groupName) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.deleteContactByGroup(easeyeUserAccountDTO, emails, groupName);
  }
  
  public com.easeye.webservice.AccountUserListReturnDTO getAccountUserList(EaseyeUserAccountDTO easeyeUserAccountDTO,com.easeye.webservice.UserFilters userFilters) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.getAccountUserList(easeyeUserAccountDTO, userFilters);
  }
  
  public com.easeye.webservice.AccountUserGetReturnDTO accountUserGet(EaseyeUserAccountDTO easeyeUserAccountDTO, int userId) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.accountUserGet(easeyeUserAccountDTO, userId);
  }
  
  public com.easeye.webservice.GetTemplateListReturnDTO getTemplateList(EaseyeUserAccountDTO easeyeUserAccountDTO,com.easeye.webservice.TemplateFilters templateFilters, int pageIndex, int pageSize) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.getTemplateList(easeyeUserAccountDTO, templateFilters, pageIndex, pageSize);
  }
  
  public com.easeye.webservice.TemplateGetReturnDTO templateGet(EaseyeUserAccountDTO easeyeUserAccountDTO, int templateId) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.templateGet(easeyeUserAccountDTO, templateId);
  }
  
  public com.easeye.webservice.TransMailBounceGetReturnDTO getTransMailHardBounceList(EaseyeUserAccountDTO easeyeUserAccountDTO, String senderEmail, java.util.Calendar startTime, java.util.Calendar endTime, int pageSize, int currentPageIndex) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.getTransMailHardBounceList(easeyeUserAccountDTO, senderEmail, startTime, endTime, pageSize, currentPageIndex);
  }
  
  public com.easeye.webservice.TransMailBounceGetReturnDTO getTransMailSpamReportsList(EaseyeUserAccountDTO easeyeUserAccountDTO, String senderEmail, java.util.Calendar startTime, java.util.Calendar endTime, int pageSize, int currentPageIndex) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.getTransMailSpamReportsList(easeyeUserAccountDTO, senderEmail, startTime, endTime, pageSize, currentPageIndex);
  }
  
  public com.easeye.webservice.EaseyeReturnDTO addContactGroup(EaseyeUserAccountDTO easeyeUserAccountDTO,com.easeye.webservice.CustomContactGroup contactGroup) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.addContactGroup(easeyeUserAccountDTO, contactGroup);
  }
  
  public com.easeye.webservice.EaseyeReturnDTO deleteContactGroupByGroupId(EaseyeUserAccountDTO easeyeUserAccountDTO, int groupId) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.deleteContactGroupByGroupId(easeyeUserAccountDTO, groupId);
  }
  
  public com.easeye.webservice.EaseyeReturnDTO updateContactGroup(EaseyeUserAccountDTO easeyeUserAccountDTO,com.easeye.webservice.UpdateContactGroupDTO contactGroup) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.updateContactGroup(easeyeUserAccountDTO, contactGroup);
  }
  
  public com.easeye.webservice.GetContactGroupListReturnDTO getContactGroupList(EaseyeUserAccountDTO easeyeUserAccountDTO,com.easeye.webservice.ContactGroupFilters contactGroupFilters, int pageIndex, int pageSize) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.getContactGroupList(easeyeUserAccountDTO, contactGroupFilters, pageIndex, pageSize);
  }
  
  public com.easeye.webservice.EaseyeReturnDTO addProject(EaseyeUserAccountDTO easeyeUserAccountDTO,com.easeye.webservice.CustomProject customProject) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.addProject(easeyeUserAccountDTO, customProject);
  }
  
  public com.easeye.webservice.EaseyeReturnDTO deleteProject(EaseyeUserAccountDTO easeyeUserAccountDTO, int mailProjectId) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.deleteProject(easeyeUserAccountDTO, mailProjectId);
  }
  
  public com.easeye.webservice.EaseyeReturnDTO deleteProjectAndList(EaseyeUserAccountDTO easeyeUserAccountDTO, int mailProjectId) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.deleteProjectAndList(easeyeUserAccountDTO, mailProjectId);
  }
  
  public com.easeye.webservice.EaseyeReturnDTO updateProject(EaseyeUserAccountDTO easeyeUserAccountDTO,com.easeye.webservice.UpdateProjectDTO mailProject) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.updateProject(easeyeUserAccountDTO, mailProject);
  }
  
  public com.easeye.webservice.GetProjectListReturnDTO getProjectList(EaseyeUserAccountDTO easeyeUserAccountDTO,com.easeye.webservice.ProjectFilters projectFilters, int pageIndex, int pageSize) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.getProjectList(easeyeUserAccountDTO, projectFilters, pageIndex, pageSize);
  }
  
  public com.easeye.webservice.EaseyeReturnDTO deleteSender(EaseyeUserAccountDTO easeyeUserAccountDTO, String senderEmail) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.deleteSender(easeyeUserAccountDTO, senderEmail);
  }
  
  public com.easeye.webservice.SMTPPlainReportDTO getSMTPPlainReport(EaseyeUserAccountDTO easeyeUserAccountDTO, String category, java.util.Calendar beginTime, java.util.Calendar endTime, int pageSize, int currentPageIndex) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.getSMTPPlainReport(easeyeUserAccountDTO, category, beginTime, endTime, pageSize, currentPageIndex);
  }
  
  public com.easeye.webservice.SMTPReportDetailDTO getSMTPReportDetail(EaseyeUserAccountDTO easeyeUserAccountDTO, int reportType, int reportCategory, String email, String category, String campaign, String uniqueMsgID, java.util.Calendar beginTime, java.util.Calendar endTime, int pageSize, int currentPageIndex) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.getSMTPReportDetail(easeyeUserAccountDTO, reportType, reportCategory, email, category, campaign, uniqueMsgID, beginTime, endTime, pageSize, currentPageIndex);
  }
  
  public com.easeye.webservice.SMTPBulkReportDTO getSMTPBulkReport(EaseyeUserAccountDTO easeyeUserAccountDTO, String category, String campaign, java.util.Calendar beginTime, java.util.Calendar endTime, int pageSize, int currentPageIndex) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.getSMTPBulkReport(easeyeUserAccountDTO, category, campaign, beginTime, endTime, pageSize, currentPageIndex);
  }
  
  public com.easeye.webservice.GetContactListReturnDTO getContactList(EaseyeUserAccountDTO easeyeUserAccountDTO,com.easeye.webservice.ContactFilter contactFilter, int pageIndex, int pageSize) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.getContactList(easeyeUserAccountDTO, contactFilter, pageIndex, pageSize);
  }
  
  public com.easeye.webservice.EaseyeReturnDTO deleteUser(EaseyeUserAccountDTO easeyeUserAccountDTO, String userEmail) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.deleteUser(easeyeUserAccountDTO, userEmail);
  }
  
  public com.easeye.webservice.MailReportDetailExtReturnDTO getMailReportDetailExt(EaseyeUserAccountDTO easeyeUserAccountDTO, String mailListName, int sentFlag, java.util.Calendar datetimeFrom, java.util.Calendar datetimeTo, int pageSize, int currentPageIndex) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.getMailReportDetailExt(easeyeUserAccountDTO, mailListName, sentFlag, datetimeFrom, datetimeTo, pageSize, currentPageIndex);
  }
  
  public com.easeye.webservice.WebServiceReportDetailExtReturnDTO getWebServiceReportDetailExt(EaseyeUserAccountDTO easeyeUserAccountDTO, String templateName, java.util.Calendar datetimeFrom, java.util.Calendar datetimeTo, int sentFlag, int pageSize, int currentPageIndex) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.getWebServiceReportDetailExt(easeyeUserAccountDTO, templateName, datetimeFrom, datetimeTo, sentFlag, pageSize, currentPageIndex);
  }
  
  public com.easeye.webservice.EaseyeReturnDTO importListSentTag(EaseyeUserAccountDTO easeyeUserAccountDTO, String mailListName, String[] tagName,com.easeye.webservice.ListSentTagDTO[] listSentTagArray) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.importListSentTag(easeyeUserAccountDTO, mailListName, tagName, listSentTagArray);
  }
  
  public com.easeye.webservice.SmtpQueueInfoReturnDTO getSmtpQueueInfo(EaseyeUserAccountDTO easeyeUserAccountDTO) throws java.rmi.RemoteException{
    if (mailWebServiceSoap == null)
      _initMailWebServiceSoapProxy();
    return mailWebServiceSoap.getSmtpQueueInfo(easeyeUserAccountDTO);
  }
  
  
}