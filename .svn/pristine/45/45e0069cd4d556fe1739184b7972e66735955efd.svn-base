/**
 * MailWebServiceSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.easeye.webservice;

public interface MailWebServiceSoap extends java.rmi.Remote {
    public String helloWorld() throws java.rmi.RemoteException;
    public com.easeye.webservice.EaseyeReturnDTO sendMailListRequest(EaseyeUserAccountDTO easeyeUserAccountDTO,com.easeye.webservice.EaseyeMessageTemplateDTO easeyeMessageTemplateDTO,com.easeye.webservice.EaseyeMessageReceiveDTO[] easeyeMessageReceiveDTOArray,com.easeye.webservice.EaseyeSendOptionDTO easeyeSendOptionDTO) throws java.rmi.RemoteException;
    public com.easeye.webservice.EaseyeReturnDTO sendMailListRequestByGroup(EaseyeUserAccountDTO easeyeUserAccountDTO,com.easeye.webservice.EaseyeMessageTemplateDTO easeyeMessageTemplateDTO,com.easeye.webservice.EaseyeGroupDTO easeyeGroupDTO,com.easeye.webservice.EaseyeSendOptionDTO easeyeSendOptionDTO) throws java.rmi.RemoteException;
    public com.easeye.webservice.EaseyeDetailedResultReturnDTO cancelMaillist(EaseyeUserAccountDTO easeyeUserAccountDTO, String mailListName) throws java.rmi.RemoteException;
    public com.easeye.webservice.EaseyeReturnDTO importContactByGroup(EaseyeUserAccountDTO easeyeUserAccountDTO,com.easeye.webservice.EaseyeGroupDTO easeyeGroupDTO,com.easeye.webservice.EaseyeMessageReceiveDTO[] easeyeMessageReceiveDTOArray) throws java.rmi.RemoteException;
    public com.easeye.webservice.EaseyeDetailedResultReturnDTO importContactByGroupExt(EaseyeUserAccountDTO easeyeUserAccountDTO,com.easeye.webservice.EaseyeGroupDTO easeyeGroupDTO,com.easeye.webservice.EaseyeMessageCustomReceiverDTO easeyeMessageReceiveDTO, String importName) throws java.rmi.RemoteException;
    public com.easeye.webservice.EaseyeDetailedResultReturnDTO importContactByGroupDetailed(EaseyeUserAccountDTO easeyeUserAccountDTO,com.easeye.webservice.EaseyeGroupDTO easeyeGroupDTO,com.easeye.webservice.EaseyeMessageReceiveDTO[] easeyeMessageReceiveDTOArray, String importName) throws java.rmi.RemoteException;
    public com.easeye.webservice.EaseyeReturnDTO moveContactToNewGroup(EaseyeUserAccountDTO easeyeUserAccountDTO, String newGroupName,com.easeye.webservice.EaseyeMessageReceiveDTO[] easeyeMessageReceiveDTOArray) throws java.rmi.RemoteException;
    public com.easeye.webservice.MailStatusReportDTO sendMailReportResponse(EaseyeUserAccountDTO easeyeUserAccountDTO, String queryId, int reportOption) throws java.rmi.RemoteException;
    public int getCountByGroupName(EaseyeUserAccountDTO easeyeUserAccountDTO, String groupName) throws java.rmi.RemoteException;
    public boolean queryContactByGroup(EaseyeUserAccountDTO easeyeUserAccountDTO, String groupName, String email) throws java.rmi.RemoteException;
    public com.easeye.webservice.EaseyeGroupDTO[] getGroupList(EaseyeUserAccountDTO easeyeUserAccountDTO) throws java.rmi.RemoteException;
    public void modifyGroupName(EaseyeUserAccountDTO easeyeUserAccountDTO, String oldGroupName, String newGroupName) throws java.rmi.RemoteException;
    public com.easeye.webservice.EaseyeReturnDTO deleteGroupByGroupName(EaseyeUserAccountDTO easeyeUserAccountDTO, String groupName) throws java.rmi.RemoteException;
    public void createTask(EaseyeUserAccountDTO easeyeUserAccountDTO) throws java.rmi.RemoteException;
    public com.easeye.webservice.EaseyeReturnDTO sendTemplate(SendTemplateRequest sendTemplateRequest) throws java.rmi.RemoteException;
    public boolean accessCheck(String userName, String password) throws java.rmi.RemoteException;
    public com.easeye.webservice.EaseyeReturnDTO addUser(EaseyeUserAccountDTO easeyeUserAccountDTO,com.easeye.webservice.CustomMailUser mailUser) throws java.rmi.RemoteException;
    public com.easeye.webservice.EaseyeReturnDTO updateUser(EaseyeUserAccountDTO easeyeUserAccountDTO,com.easeye.webservice.CustomMailUser mailUser) throws java.rmi.RemoteException;
    public com.easeye.webservice.EaseyeReturnDTO manageUserPoint(EaseyeUserAccountDTO easeyeUserAccountDTO, String email, int point) throws java.rmi.RemoteException;
    public com.easeye.webservice.MailStatusReportDTO[] getSumReport(EaseyeUserAccountDTO easeyeUserAccountDTO, String projectName, String maillistName, java.util.Calendar sentDatetimeFrom, java.util.Calendar sentDatetimeTo) throws java.rmi.RemoteException;
    public com.easeye.webservice.ReportDetail[] getReportDetail(EaseyeUserAccountDTO easeyeUserAccountDTO, int sentMailListId, int sentFlag, int pageSize, int currentPageIndex) throws java.rmi.RemoteException;
    public com.easeye.webservice.ReportMoreDetail[] getReportMoreDetail(EaseyeUserAccountDTO easeyeUserAccountDTO, int sentMailListId, int sentFlag, int pageSize, int currentPageIndex) throws java.rmi.RemoteException;
    public com.easeye.webservice.WebServiceReportReturnDTO getWebServiceSumReport(EaseyeUserAccountDTO easeyeUserAccountDTO, String templateName, java.util.Calendar sentDatetimeFrom, java.util.Calendar sentDatetimeTo) throws java.rmi.RemoteException;
    public com.easeye.webservice.WebServiceReportDetailReturnDTO getWebServiceReportDetail(EaseyeUserAccountDTO easeyeUserAccountDTO, String templateName, java.util.Calendar sentDatetimeFrom, java.util.Calendar sentDatetimeTo, int sentFlag, int pageSize, int currentPageIndex) throws java.rmi.RemoteException;
    public com.easeye.webservice.MailReportDetailReturnDTO getMailReportDetail(EaseyeUserAccountDTO easeyeUserAccountDTO, int sentMailListId, int sentFlag, int pageSize, int currentPageIndex) throws java.rmi.RemoteException;
    public com.easeye.webservice.MailSumReportReturnDTO getMailSumReport(EaseyeUserAccountDTO easeyeUserAccountDTO, String projectName, String maillistName, java.util.Calendar sentDatetimeFrom, java.util.Calendar sentDatetimeTo) throws java.rmi.RemoteException;
    public com.easeye.webservice.EaseyeDetailedResultReturnDTO EY_ImportContactByGroupDetailed(EaseyeUserAccountDTO easeyeUserAccountDTO,com.easeye.webservice.EaseyeGroupDTO easeyeGroupDTO,com.easeye.webservice.EY_MessageReceiveDTO[] ey_MessageReceiveDTOArray) throws java.rmi.RemoteException;
    public com.easeye.webservice.EaseyeReturnDTO EY_SendMailListRequest(EaseyeUserAccountDTO easeyeUserAccountDTO,com.easeye.webservice.EaseyeMessageTemplateDTO easeyeMessageTemplateDTO,com.easeye.webservice.EY_MessageReceiveDTO[] ey_MessageReceiveDTOArray,com.easeye.webservice.EaseyeSendOptionDTO easeyeSendOptionDTO) throws java.rmi.RemoteException;
    public com.easeye.webservice.EY_MailStatusReportDTO[] EY_GetSumReport(EaseyeUserAccountDTO easeyeUserAccountDTO, String projectName, String maillistName, java.util.Calendar sentDatetimeFrom, java.util.Calendar sentDatetimeTo) throws java.rmi.RemoteException;
    public com.easeye.webservice.EaseyeDetailedResultReturnDTO getImportFailedRecords(EaseyeUserAccountDTO easeyeUserAccountDTO, String importName, int pageSize, int currentPageIndex) throws java.rmi.RemoteException;
    public com.easeye.webservice.EaseyeReturnDTO validateEmail(EaseyeUserAccountDTO easeyeUserAccountDTO, String email, String returnUrl) throws java.rmi.RemoteException;
    public com.easeye.webservice.GetGroupInfoReturnDTO getGroupInfoByGroupName(EaseyeUserAccountDTO easeyeUserAccountDTO, String groupName) throws java.rmi.RemoteException;
    public com.easeye.webservice.MailContactInActionReturnDTO getMailContactInAction(EaseyeUserAccountDTO easeyeUserAccountDTO, int sentFlag, java.util.Calendar dateFrom, java.util.Calendar dateTo, int pageSize, int currentPageIndex) throws java.rmi.RemoteException;
    public com.easeye.webservice.EaseyeMailSenderStatusReturnDTO getMailSenderStatus(EaseyeUserAccountDTO easeyeUserAccountDTO, String email, String sendEmail) throws java.rmi.RemoteException;
    public com.easeye.webservice.EaseyeDetailedResultReturnDTO updateRecipientsStatus(EaseyeUserAccountDTO easeyeUserAccountDTO, String[] recipients, int status) throws java.rmi.RemoteException;
    public com.easeye.webservice.EaseyeReturnDTO removeTemplate(EaseyeUserAccountDTO easeyeUserAccountDTO, String templateName) throws java.rmi.RemoteException;
    public com.easeye.webservice.EaseyeReturnDTO updateTemplate(EaseyeUserAccountDTO easeyeUserAccountDTO,com.easeye.webservice.EaseyeMessageTemplateDTO easeyeMessageTemplateDTO) throws java.rmi.RemoteException;
    public com.easeye.webservice.EaseyeReturnDTO sendMail(EaseyeUserAccountDTO easeyeUserAccountDTO,com.easeye.webservice.EaseyeMessageReceiveDTO easeyeMessageReceiveDTO, String templateName,com.easeye.webservice.EaseyeSendOptionDTO easeyeSendOptionDTO) throws java.rmi.RemoteException;
    public com.easeye.webservice.SmtpSendResultReturnDTO getSmtpSendResultByEmail(EaseyeUserAccountDTO easeyeUserAccountDTO, String email, java.util.Calendar dtBeginTime, java.util.Calendar dtEndTime) throws java.rmi.RemoteException;
    public com.easeye.webservice.SmtpSendResultPaginationReturnDTO getSmtpSendResult(EaseyeUserAccountDTO easeyeUserAccountDTO, String email, java.util.Calendar dtBeginTime, java.util.Calendar dtEndTime, int pageIndex, int pageSize) throws java.rmi.RemoteException;
    public com.easeye.webservice.AttachmentReturnDTO uploadAttachment(EaseyeUserAccountDTO easeyeUserAccountDTO, String attachmentContent, String attachmentName, String uploadMode) throws java.rmi.RemoteException;
    public com.easeye.webservice.AttachmentReturnDTO attachmentQuery(EaseyeUserAccountDTO easeyeUserAccountDTO, String fileName) throws java.rmi.RemoteException;
    public com.easeye.webservice.GetTopicReturnDTO getMailTopics(EaseyeUserAccountDTO easeyeUserAccountDTO) throws java.rmi.RemoteException;
    public com.easeye.webservice.GetTopicByTopicNameReturnDTO getMailTopic(EaseyeUserAccountDTO easeyeUserAccountDTO, String topicName) throws java.rmi.RemoteException;
    public com.easeye.webservice.EaseyeReturnDTO addMailTopic(EaseyeUserAccountDTO easeyeUserAccountDTO,com.easeye.webservice.Mail_Topic topic) throws java.rmi.RemoteException;
    public com.easeye.webservice.EaseyeReturnDTO modifyMailTopic(EaseyeUserAccountDTO easeyeUserAccountDTO,com.easeye.webservice.Mail_Topic topic) throws java.rmi.RemoteException;
    public com.easeye.webservice.EaseyeReturnDTO deleteMailTopic(EaseyeUserAccountDTO easeyeUserAccountDTO, String topicName) throws java.rmi.RemoteException;
    public com.easeye.webservice.EaseyeDetailedResultReturnDTO updateRecipientsStatusExt(EaseyeUserAccountDTO easeyeUserAccountDTO, String[] recipients, int status, String topicNames) throws java.rmi.RemoteException;
    public com.easeye.webservice.EaseyeDetailedResultReturnDTO deleteContactByGroup(EaseyeUserAccountDTO easeyeUserAccountDTO, String[] emails, String groupName) throws java.rmi.RemoteException;
    public com.easeye.webservice.AccountUserListReturnDTO getAccountUserList(EaseyeUserAccountDTO easeyeUserAccountDTO,com.easeye.webservice.UserFilters userFilters) throws java.rmi.RemoteException;
    public com.easeye.webservice.AccountUserGetReturnDTO accountUserGet(EaseyeUserAccountDTO easeyeUserAccountDTO, int userId) throws java.rmi.RemoteException;
    public com.easeye.webservice.GetTemplateListReturnDTO getTemplateList(EaseyeUserAccountDTO easeyeUserAccountDTO,com.easeye.webservice.TemplateFilters templateFilters, int pageIndex, int pageSize) throws java.rmi.RemoteException;
    public com.easeye.webservice.TemplateGetReturnDTO templateGet(EaseyeUserAccountDTO easeyeUserAccountDTO, int templateId) throws java.rmi.RemoteException;
    public com.easeye.webservice.TransMailBounceGetReturnDTO getTransMailHardBounceList(EaseyeUserAccountDTO easeyeUserAccountDTO, String senderEmail, java.util.Calendar startTime, java.util.Calendar endTime, int pageSize, int currentPageIndex) throws java.rmi.RemoteException;
    public com.easeye.webservice.TransMailBounceGetReturnDTO getTransMailSpamReportsList(EaseyeUserAccountDTO easeyeUserAccountDTO, String senderEmail, java.util.Calendar startTime, java.util.Calendar endTime, int pageSize, int currentPageIndex) throws java.rmi.RemoteException;
    public com.easeye.webservice.EaseyeReturnDTO



    addContactGroup(EaseyeUserAccountDTO easeyeUserAccountDTO,com.easeye.webservice.CustomContactGroup contactGroup) throws java.rmi.RemoteException;
    public com.easeye.webservice.EaseyeReturnDTO deleteContactGroupByGroupId(EaseyeUserAccountDTO easeyeUserAccountDTO, int groupId) throws java.rmi.RemoteException;
    public com.easeye.webservice.EaseyeReturnDTO updateContactGroup(EaseyeUserAccountDTO easeyeUserAccountDTO,com.easeye.webservice.UpdateContactGroupDTO contactGroup) throws java.rmi.RemoteException;
    public com.easeye.webservice.GetContactGroupListReturnDTO getContactGroupList(EaseyeUserAccountDTO easeyeUserAccountDTO,com.easeye.webservice.ContactGroupFilters contactGroupFilters, int pageIndex, int pageSize) throws java.rmi.RemoteException;
    public com.easeye.webservice.EaseyeReturnDTO addProject(EaseyeUserAccountDTO easeyeUserAccountDTO,com.easeye.webservice.CustomProject customProject) throws java.rmi.RemoteException;
    public com.easeye.webservice.EaseyeReturnDTO deleteProject(EaseyeUserAccountDTO easeyeUserAccountDTO, int mailProjectId) throws java.rmi.RemoteException;
    public com.easeye.webservice.EaseyeReturnDTO deleteProjectAndList(EaseyeUserAccountDTO easeyeUserAccountDTO, int mailProjectId) throws java.rmi.RemoteException;
    public com.easeye.webservice.EaseyeReturnDTO updateProject(EaseyeUserAccountDTO easeyeUserAccountDTO,com.easeye.webservice.UpdateProjectDTO mailProject) throws java.rmi.RemoteException;
    public com.easeye.webservice.GetProjectListReturnDTO getProjectList(EaseyeUserAccountDTO easeyeUserAccountDTO,com.easeye.webservice.ProjectFilters projectFilters, int pageIndex, int pageSize) throws java.rmi.RemoteException;
    public com.easeye.webservice.EaseyeReturnDTO deleteSender(EaseyeUserAccountDTO easeyeUserAccountDTO, String senderEmail) throws java.rmi.RemoteException;
    public com.easeye.webservice.SMTPPlainReportDTO getSMTPPlainReport(EaseyeUserAccountDTO easeyeUserAccountDTO, String category, java.util.Calendar beginTime, java.util.Calendar endTime, int pageSize, int currentPageIndex) throws java.rmi.RemoteException;
    public com.easeye.webservice.SMTPReportDetailDTO getSMTPReportDetail(EaseyeUserAccountDTO easeyeUserAccountDTO, int reportType, int reportCategory, String email, String category, String campaign, String uniqueMsgID, java.util.Calendar beginTime, java.util.Calendar endTime, int pageSize, int currentPageIndex) throws java.rmi.RemoteException;
    public com.easeye.webservice.SMTPBulkReportDTO getSMTPBulkReport(EaseyeUserAccountDTO easeyeUserAccountDTO, String category, String campaign, java.util.Calendar beginTime, java.util.Calendar endTime, int pageSize, int currentPageIndex) throws java.rmi.RemoteException;
    public com.easeye.webservice.GetContactListReturnDTO getContactList(EaseyeUserAccountDTO easeyeUserAccountDTO,com.easeye.webservice.ContactFilter contactFilter, int pageIndex, int pageSize) throws java.rmi.RemoteException;
    public com.easeye.webservice.EaseyeReturnDTO deleteUser(EaseyeUserAccountDTO easeyeUserAccountDTO, String userEmail) throws java.rmi.RemoteException;
    public com.easeye.webservice.MailReportDetailExtReturnDTO getMailReportDetailExt(EaseyeUserAccountDTO easeyeUserAccountDTO, String mailListName, int sentFlag, java.util.Calendar datetimeFrom, java.util.Calendar datetimeTo, int pageSize, int currentPageIndex) throws java.rmi.RemoteException;
    public com.easeye.webservice.WebServiceReportDetailExtReturnDTO getWebServiceReportDetailExt(EaseyeUserAccountDTO easeyeUserAccountDTO, String templateName, java.util.Calendar datetimeFrom, java.util.Calendar datetimeTo, int sentFlag, int pageSize, int currentPageIndex) throws java.rmi.RemoteException;
    public com.easeye.webservice.EaseyeReturnDTO importListSentTag(EaseyeUserAccountDTO easeyeUserAccountDTO, String mailListName, String[] tagName,com.easeye.webservice.ListSentTagDTO[] listSentTagArray) throws java.rmi.RemoteException;
    public com.easeye.webservice.SmtpQueueInfoReturnDTO getSmtpQueueInfo(EaseyeUserAccountDTO easeyeUserAccountDTO) throws java.rmi.RemoteException;
}
