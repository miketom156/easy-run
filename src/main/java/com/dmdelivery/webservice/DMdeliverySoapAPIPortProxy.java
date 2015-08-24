package com.dmdelivery.webservice;

public class DMdeliverySoapAPIPortProxy implements com.dmdelivery.webservice.DMdeliverySoapAPIPort {
  private String _endpoint = null;
  private com.dmdelivery.webservice.DMdeliverySoapAPIPort dMdeliverySoapAPIPort = null;
  
  public DMdeliverySoapAPIPortProxy() {
    _initDMdeliverySoapAPIPortProxy();
  }
  
  public DMdeliverySoapAPIPortProxy(String endpoint) {
    _endpoint = endpoint;
    _initDMdeliverySoapAPIPortProxy();
  }
  
  private void _initDMdeliverySoapAPIPortProxy() {
    try {
      dMdeliverySoapAPIPort = (new com.dmdelivery.webservice.DMdeliverySoapAPILocator()).getDMdeliverySoapAPIPort();
      if (dMdeliverySoapAPIPort != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)dMdeliverySoapAPIPort)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)dMdeliverySoapAPIPort)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (dMdeliverySoapAPIPort != null)
      ((javax.xml.rpc.Stub)dMdeliverySoapAPIPort)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.dmdelivery.webservice.DMdeliverySoapAPIPort getDMdeliverySoapAPIPort() {
    if (dMdeliverySoapAPIPort == null)
      _initDMdeliverySoapAPIPortProxy();
    return dMdeliverySoapAPIPort;
  }
  
  public boolean checkHealth(com.dmdelivery.webservice.DMdeliveryLoginType login) throws java.rmi.RemoteException{
    if (dMdeliverySoapAPIPort == null)
      _initDMdeliverySoapAPIPortProxy();
    return dMdeliverySoapAPIPort.checkHealth(login);
  }
  
  public com.dmdelivery.webservice.RecordResultType addOverallRecipient(com.dmdelivery.webservice.DMdeliveryLoginType login, int[] campaignIDs, int[] groupIDs, com.dmdelivery.webservice.RecipientNameValuePairType[] recipientData, boolean overwrite) throws java.rmi.RemoteException{
    if (dMdeliverySoapAPIPort == null)
      _initDMdeliverySoapAPIPortProxy();
    return dMdeliverySoapAPIPort.addOverallRecipient(login, campaignIDs, groupIDs, recipientData, overwrite);
  }
  
  public com.dmdelivery.webservice.RecordResultType editOverallRecipient(com.dmdelivery.webservice.DMdeliveryLoginType login, int[] campaignIDs, int recipientID, int[] groupIDs, com.dmdelivery.webservice.RecipientNameValuePairType[] recipientData) throws java.rmi.RemoteException{
    if (dMdeliverySoapAPIPort == null)
      _initDMdeliverySoapAPIPortProxy();
    return dMdeliverySoapAPIPort.editOverallRecipient(login, campaignIDs, recipientID, groupIDs, recipientData);
  }
  
  public boolean addOverallRecipientToGroups(com.dmdelivery.webservice.DMdeliveryLoginType login, int[] campaignIDs, int recipientID, int[] groupIDs) throws java.rmi.RemoteException{
    if (dMdeliverySoapAPIPort == null)
      _initDMdeliverySoapAPIPortProxy();
    return dMdeliverySoapAPIPort.addOverallRecipientToGroups(login, campaignIDs, recipientID, groupIDs);
  }
  
  public boolean removeOverallRecipientFromGroups(com.dmdelivery.webservice.DMdeliveryLoginType login, int[] campaignIDs, int recipientID, int[] groupIDs) throws java.rmi.RemoteException{
    if (dMdeliverySoapAPIPort == null)
      _initDMdeliverySoapAPIPortProxy();
    return dMdeliverySoapAPIPort.removeOverallRecipientFromGroups(login, campaignIDs, recipientID, groupIDs);
  }
  
  public com.dmdelivery.webservice.RecordResultType editRecipient(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int recipientID, com.dmdelivery.webservice.RecipientNameValuePairType[] recipientData) throws java.rmi.RemoteException{
    if (dMdeliverySoapAPIPort == null)
      _initDMdeliverySoapAPIPortProxy();
    return dMdeliverySoapAPIPort.editRecipient(login, campaignID, recipientID, recipientData);
  }
  
  public com.dmdelivery.webservice.BrandType[] getBrands(com.dmdelivery.webservice.DMdeliveryLoginType login) throws java.rmi.RemoteException{
    if (dMdeliverySoapAPIPort == null)
      _initDMdeliverySoapAPIPortProxy();
    return dMdeliverySoapAPIPort.getBrands(login);
  }
  
  public com.dmdelivery.webservice.CampaignType[] getCampaigns(com.dmdelivery.webservice.DMdeliveryLoginType login) throws java.rmi.RemoteException{
    if (dMdeliverySoapAPIPort == null)
      _initDMdeliverySoapAPIPortProxy();
    return dMdeliverySoapAPIPort.getCampaigns(login);
  }
  
  public com.dmdelivery.webservice.SenderAddressType[] getSenderAddresses(com.dmdelivery.webservice.DMdeliveryLoginType login) throws java.rmi.RemoteException{
    if (dMdeliverySoapAPIPort == null)
      _initDMdeliverySoapAPIPortProxy();
    return dMdeliverySoapAPIPort.getSenderAddresses(login);
  }
  
  public com.dmdelivery.webservice.RecipientCampaignType[] getOverallRecipientCampaigns(com.dmdelivery.webservice.DMdeliveryLoginType login, int recipientID) throws java.rmi.RemoteException{
    if (dMdeliverySoapAPIPort == null)
      _initDMdeliverySoapAPIPortProxy();
    return dMdeliverySoapAPIPort.getOverallRecipientCampaigns(login, recipientID);
  }
  
  public com.dmdelivery.webservice.RecipientType[] getRecipientsByMatch(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, com.dmdelivery.webservice.RecipientNameValuePairType[] recipientData) throws java.rmi.RemoteException{
    if (dMdeliverySoapAPIPort == null)
      _initDMdeliverySoapAPIPortProxy();
    return dMdeliverySoapAPIPort.getRecipientsByMatch(login, campaignID, recipientData);
  }
  
  public com.dmdelivery.webservice.RecipientFieldType[] getRecipientFields(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, java.lang.String lang) throws java.rmi.RemoteException{
    if (dMdeliverySoapAPIPort == null)
      _initDMdeliverySoapAPIPortProxy();
    return dMdeliverySoapAPIPort.getRecipientFields(login, campaignID, lang);
  }
  
  public boolean sendSingleMailing(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int mailingID, int recipientID) throws java.rmi.RemoteException{
    if (dMdeliverySoapAPIPort == null)
      _initDMdeliverySoapAPIPortProxy();
    return dMdeliverySoapAPIPort.sendSingleMailing(login, campaignID, mailingID, recipientID);
  }
  
  public boolean sendSingleSMS(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int mailingID, int recipientID) throws java.rmi.RemoteException{
    if (dMdeliverySoapAPIPort == null)
      _initDMdeliverySoapAPIPortProxy();
    return dMdeliverySoapAPIPort.sendSingleSMS(login, campaignID, mailingID, recipientID);
  }
  
  public com.dmdelivery.webservice.RecordResultType sendMailing(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int mailingID, boolean isTest, java.lang.String resultsEmail, int[] groupIDs, int filterID, java.lang.String[] langs, java.lang.String ADprefixDomains, java.lang.String callbackUrl) throws java.rmi.RemoteException{
    if (dMdeliverySoapAPIPort == null)
      _initDMdeliverySoapAPIPortProxy();
    return dMdeliverySoapAPIPort.sendMailing(login, campaignID, mailingID, isTest, resultsEmail, groupIDs, filterID, langs, ADprefixDomains, callbackUrl);
  }
  
  public boolean sendSystemMail(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int mailingID, int recipientID, java.lang.String attachments) throws java.rmi.RemoteException{
    if (dMdeliverySoapAPIPort == null)
      _initDMdeliverySoapAPIPortProxy();
    return dMdeliverySoapAPIPort.sendSystemMail(login, campaignID, mailingID, recipientID, attachments);
  }
  
  public com.dmdelivery.webservice.RecordResultType sendMailingScheduled(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int mailingID, java.lang.String sendDate, boolean isTest, java.lang.String resultsEmail, int[] groupIDs, int filterID, java.lang.String[] langs, java.lang.String ADprefixDomains, java.lang.String callbackUrl, int approvalGroupID, float approvalPeriod, int approvalAck, int approvalNack) throws java.rmi.RemoteException{
    if (dMdeliverySoapAPIPort == null)
      _initDMdeliverySoapAPIPortProxy();
    return dMdeliverySoapAPIPort.sendMailingScheduled(login, campaignID, mailingID, sendDate, isTest, resultsEmail, groupIDs, filterID, langs, ADprefixDomains, callbackUrl, approvalGroupID, approvalPeriod, approvalAck, approvalNack);
  }
  
  public com.dmdelivery.webservice.RecordResultType sendSMS(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int mailingID, boolean isTest, java.lang.String resultsEmail, int[] groupIDs, int filterID, java.lang.String[] langs, java.lang.String ADprefixDomains, java.lang.String callbackUrl) throws java.rmi.RemoteException{
    if (dMdeliverySoapAPIPort == null)
      _initDMdeliverySoapAPIPortProxy();
    return dMdeliverySoapAPIPort.sendSMS(login, campaignID, mailingID, isTest, resultsEmail, groupIDs, filterID, langs, ADprefixDomains, callbackUrl);
  }
  
  public com.dmdelivery.webservice.RecordResultType createMailing(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, java.lang.String mailingName, java.lang.String lang, java.lang.String subject, java.lang.String fromName, int senderID, java.lang.String html) throws java.rmi.RemoteException{
    if (dMdeliverySoapAPIPort == null)
      _initDMdeliverySoapAPIPortProxy();
    return dMdeliverySoapAPIPort.createMailing(login, campaignID, mailingName, lang, subject, fromName, senderID, html);
  }
  
  public com.dmdelivery.webservice.RecordResultType slurpMailing(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, java.lang.String mailingName, java.lang.String lang, java.lang.String subject, java.lang.String fromName, int senderID, java.lang.String url, boolean checkTimestamp) throws java.rmi.RemoteException{
    if (dMdeliverySoapAPIPort == null)
      _initDMdeliverySoapAPIPortProxy();
    return dMdeliverySoapAPIPort.slurpMailing(login, campaignID, mailingName, lang, subject, fromName, senderID, url, checkTimestamp);
  }
  
  public int[] removeRecipientFromGroups(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int recipientID, int[] groupIDs) throws java.rmi.RemoteException{
    if (dMdeliverySoapAPIPort == null)
      _initDMdeliverySoapAPIPortProxy();
    return dMdeliverySoapAPIPort.removeRecipientFromGroups(login, campaignID, recipientID, groupIDs);
  }
  
  public int[] addRecipientToGroups(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int recipientID, int[] groupIDs) throws java.rmi.RemoteException{
    if (dMdeliverySoapAPIPort == null)
      _initDMdeliverySoapAPIPortProxy();
    return dMdeliverySoapAPIPort.addRecipientToGroups(login, campaignID, recipientID, groupIDs);
  }
  
  public int moveRecipientsToGroup(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int fromGroupID, int toGroupID) throws java.rmi.RemoteException{
    if (dMdeliverySoapAPIPort == null)
      _initDMdeliverySoapAPIPortProxy();
    return dMdeliverySoapAPIPort.moveRecipientsToGroup(login, campaignID, fromGroupID, toGroupID);
  }
  
  public com.dmdelivery.webservice.MailingType[] getMailings(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int limit, boolean definitiveOnly) throws java.rmi.RemoteException{
    if (dMdeliverySoapAPIPort == null)
      _initDMdeliverySoapAPIPortProxy();
    return dMdeliverySoapAPIPort.getMailings(login, campaignID, limit, definitiveOnly);
  }
  
  public com.dmdelivery.webservice.SMSMailingType[] getSMSMailings(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int limit, boolean definitiveOnly) throws java.rmi.RemoteException{
    if (dMdeliverySoapAPIPort == null)
      _initDMdeliverySoapAPIPortProxy();
    return dMdeliverySoapAPIPort.getSMSMailings(login, campaignID, limit, definitiveOnly);
  }
  
  public com.dmdelivery.webservice.RecipientType[] getRecipientsFromGroup(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, java.lang.String[] fields, int inGroupID, java.util.Date fromDate, int[] mailingIDs, int filterID) throws java.rmi.RemoteException{
    if (dMdeliverySoapAPIPort == null)
      _initDMdeliverySoapAPIPortProxy();
    return dMdeliverySoapAPIPort.getRecipientsFromGroup(login, campaignID, fields, inGroupID, fromDate, mailingIDs, filterID);
  }
  
  public com.dmdelivery.webservice.RecipientType[] getRecipients(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, java.lang.String[] fields, int[] inGroupIDs, int[] notInGroupIDs, int[] mailingIDs, int filterID) throws java.rmi.RemoteException{
    if (dMdeliverySoapAPIPort == null)
      _initDMdeliverySoapAPIPortProxy();
    return dMdeliverySoapAPIPort.getRecipients(login, campaignID, fields, inGroupIDs, notInGroupIDs, mailingIDs, filterID);
  }
  
  public int[] getRecipientGroups(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int recipientID) throws java.rmi.RemoteException{
    if (dMdeliverySoapAPIPort == null)
      _initDMdeliverySoapAPIPortProxy();
    return dMdeliverySoapAPIPort.getRecipientGroups(login, campaignID, recipientID);
  }
  
  public com.dmdelivery.webservice.MailingStatsSummaryResultType getMailingStatsSummary(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int mailing) throws java.rmi.RemoteException{
    if (dMdeliverySoapAPIPort == null)
      _initDMdeliverySoapAPIPortProxy();
    return dMdeliverySoapAPIPort.getMailingStatsSummary(login, campaignID, mailing);
  }
  
  public com.dmdelivery.webservice.GroupType[] getGroups(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID) throws java.rmi.RemoteException{
    if (dMdeliverySoapAPIPort == null)
      _initDMdeliverySoapAPIPortProxy();
    return dMdeliverySoapAPIPort.getGroups(login, campaignID);
  }
  
  public com.dmdelivery.webservice.MailingResponseType[] getMailingResponse(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int mailingID, java.lang.String types, java.lang.String field) throws java.rmi.RemoteException{
    if (dMdeliverySoapAPIPort == null)
      _initDMdeliverySoapAPIPortProxy();
    return dMdeliverySoapAPIPort.getMailingResponse(login, campaignID, mailingID, types, field);
  }
  
  public com.dmdelivery.webservice.RecordResultType deleteMailing(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int mailingID) throws java.rmi.RemoteException{
    if (dMdeliverySoapAPIPort == null)
      _initDMdeliverySoapAPIPortProxy();
    return dMdeliverySoapAPIPort.deleteMailing(login, campaignID, mailingID);
  }
  
  public com.dmdelivery.webservice.RecordResultType addGroup(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, com.dmdelivery.webservice.NewGroupType group) throws java.rmi.RemoteException{
    if (dMdeliverySoapAPIPort == null)
      _initDMdeliverySoapAPIPortProxy();
    return dMdeliverySoapAPIPort.addGroup(login, campaignID, group);
  }
  
  public int flushGroup(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int groupID) throws java.rmi.RemoteException{
    if (dMdeliverySoapAPIPort == null)
      _initDMdeliverySoapAPIPortProxy();
    return dMdeliverySoapAPIPort.flushGroup(login, campaignID, groupID);
  }
  
  public int deleteGroup(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int groupID) throws java.rmi.RemoteException{
    if (dMdeliverySoapAPIPort == null)
      _initDMdeliverySoapAPIPortProxy();
    return dMdeliverySoapAPIPort.deleteGroup(login, campaignID, groupID);
  }
  
  public com.dmdelivery.webservice.RecordResultType addRecipient(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int[] groupIDs, com.dmdelivery.webservice.RecipientNameValuePairType[] recipientData, boolean addDuplisToGroups, boolean overwrite) throws java.rmi.RemoteException{
    if (dMdeliverySoapAPIPort == null)
      _initDMdeliverySoapAPIPortProxy();
    return dMdeliverySoapAPIPort.addRecipient(login, campaignID, groupIDs, recipientData, addDuplisToGroups, overwrite);
  }
  
  public java.lang.String addRecipientAttachment(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int mailingID, int recipientID, java.lang.String fileName, java.lang.String fileMD5, java.lang.String fileData) throws java.rmi.RemoteException{
    if (dMdeliverySoapAPIPort == null)
      _initDMdeliverySoapAPIPortProxy();
    return dMdeliverySoapAPIPort.addRecipientAttachment(login, campaignID, mailingID, recipientID, fileName, fileMD5, fileData);
  }
  
  public java.lang.String addMailingAttachment(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int mailingID, java.lang.String fileName, java.lang.String fileMD5, java.lang.String fileData) throws java.rmi.RemoteException{
    if (dMdeliverySoapAPIPort == null)
      _initDMdeliverySoapAPIPortProxy();
    return dMdeliverySoapAPIPort.addMailingAttachment(login, campaignID, mailingID, fileName, fileMD5, fileData);
  }
  
  public com.dmdelivery.webservice.RecordResultType deleteMailingAttachments(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int mailingID, java.lang.String attachmentIDs) throws java.rmi.RemoteException{
    if (dMdeliverySoapAPIPort == null)
      _initDMdeliverySoapAPIPortProxy();
    return dMdeliverySoapAPIPort.deleteMailingAttachments(login, campaignID, mailingID, attachmentIDs);
  }
  
  public java.lang.String getMailingAttachmentIDs(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int mailingID) throws java.rmi.RemoteException{
    if (dMdeliverySoapAPIPort == null)
      _initDMdeliverySoapAPIPortProxy();
    return dMdeliverySoapAPIPort.getMailingAttachmentIDs(login, campaignID, mailingID);
  }
  
  public com.dmdelivery.webservice.AddRecipientsResultType addRecipients(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int[] groupIDs, com.dmdelivery.webservice.RecipientNameValuePairType[][] recipientDatas, boolean addDuplisToGroups, boolean overwrite) throws java.rmi.RemoteException{
    if (dMdeliverySoapAPIPort == null)
      _initDMdeliverySoapAPIPortProxy();
    return dMdeliverySoapAPIPort.addRecipients(login, campaignID, groupIDs, recipientDatas, addDuplisToGroups, overwrite);
  }
  
  public com.dmdelivery.webservice.AddRecipientsResultType addRecipientsSendMailing(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int mailingID, int[] groupIDs, com.dmdelivery.webservice.RecipientNameValuePairType[][] recipientDatas, boolean addDuplisToGroups, boolean overwrite) throws java.rmi.RemoteException{
    if (dMdeliverySoapAPIPort == null)
      _initDMdeliverySoapAPIPortProxy();
    return dMdeliverySoapAPIPort.addRecipientsSendMailing(login, campaignID, mailingID, groupIDs, recipientDatas, addDuplisToGroups, overwrite);
  }
  
  public com.dmdelivery.webservice.AddRecipientsResultType addRecipientsSendSMS(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int SMSmailingID, int[] groupIDs, com.dmdelivery.webservice.RecipientNameValuePairType[][] recipientDatas, boolean addDuplisToGroups, boolean overwrite) throws java.rmi.RemoteException{
    if (dMdeliverySoapAPIPort == null)
      _initDMdeliverySoapAPIPortProxy();
    return dMdeliverySoapAPIPort.addRecipientsSendSMS(login, campaignID, SMSmailingID, groupIDs, recipientDatas, addDuplisToGroups, overwrite);
  }
  
  public com.dmdelivery.webservice.RecordResultType importRemoteCSV(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int groupID, java.lang.String csvURL, java.lang.String csvCharset, java.lang.String csvFieldSep, java.lang.String csvEnclosure, boolean addDuplisToGroups, boolean overwrite, java.lang.String callbackUrl) throws java.rmi.RemoteException{
    if (dMdeliverySoapAPIPort == null)
      _initDMdeliverySoapAPIPortProxy();
    return dMdeliverySoapAPIPort.importRemoteCSV(login, campaignID, groupID, csvURL, csvCharset, csvFieldSep, csvEnclosure, addDuplisToGroups, overwrite, callbackUrl);
  }
  
  public com.dmdelivery.webservice.RecordResultType importRemoteCSVSendMailing(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int groupID, java.lang.String csvURL, java.lang.String csvCharset, java.lang.String csvFieldSep, java.lang.String csvEnclosure, boolean addDuplisToGroups, boolean overwrite, int mailingID, java.lang.String resultsEmail, int filterID, java.lang.String[] langs, java.lang.String ADprefixDomains, java.lang.String callbackUrl) throws java.rmi.RemoteException{
    if (dMdeliverySoapAPIPort == null)
      _initDMdeliverySoapAPIPortProxy();
    return dMdeliverySoapAPIPort.importRemoteCSVSendMailing(login, campaignID, groupID, csvURL, csvCharset, csvFieldSep, csvEnclosure, addDuplisToGroups, overwrite, mailingID, resultsEmail, filterID, langs, ADprefixDomains, callbackUrl);
  }
  
  public com.dmdelivery.webservice.EventType[] getEvents(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int eventID) throws java.rmi.RemoteException{
    if (dMdeliverySoapAPIPort == null)
      _initDMdeliverySoapAPIPortProxy();
    return dMdeliverySoapAPIPort.getEvents(login, campaignID, eventID);
  }
  
  public com.dmdelivery.webservice.RecipientNameValuePairType[] addEventAttendee(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int eventID, com.dmdelivery.webservice.RecipientNameValuePairType[] recipientData, boolean status) throws java.rmi.RemoteException{
    if (dMdeliverySoapAPIPort == null)
      _initDMdeliverySoapAPIPortProxy();
    return dMdeliverySoapAPIPort.addEventAttendee(login, campaignID, eventID, recipientData, status);
  }
  
  public com.dmdelivery.webservice.RecipientNameValuePairType[][] getEventAttendees(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int eventID) throws java.rmi.RemoteException{
    if (dMdeliverySoapAPIPort == null)
      _initDMdeliverySoapAPIPortProxy();
    return dMdeliverySoapAPIPort.getEventAttendees(login, campaignID, eventID);
  }
  
  public com.dmdelivery.webservice.FilterType[] getFilters(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID) throws java.rmi.RemoteException{
    if (dMdeliverySoapAPIPort == null)
      _initDMdeliverySoapAPIPortProxy();
    return dMdeliverySoapAPIPort.getFilters(login, campaignID);
  }
  
  public com.dmdelivery.webservice.RecordResultType createSenderAddress(com.dmdelivery.webservice.DMdeliveryLoginType login, java.lang.String fromEmail) throws java.rmi.RemoteException{
    if (dMdeliverySoapAPIPort == null)
      _initDMdeliverySoapAPIPortProxy();
    return dMdeliverySoapAPIPort.createSenderAddress(login, fromEmail);
  }
  
  public com.dmdelivery.webservice.RecordResultType createCampaign(com.dmdelivery.webservice.DMdeliveryLoginType login, int brandID, java.lang.String name, java.lang.String defaultSenderName, int defaultSenderAddress, int defaultReplyAddress, java.lang.String langs, boolean isOverall, java.lang.String conversionPoints, java.lang.String localDomain, java.lang.String excludeLists) throws java.rmi.RemoteException{
    if (dMdeliverySoapAPIPort == null)
      _initDMdeliverySoapAPIPortProxy();
    return dMdeliverySoapAPIPort.createCampaign(login, brandID, name, defaultSenderName, defaultSenderAddress, defaultReplyAddress, langs, isOverall, conversionPoints, localDomain, excludeLists);
  }
  
  public com.dmdelivery.webservice.RecordResultType copyFieldDefinition(com.dmdelivery.webservice.DMdeliveryLoginType login, int srcCampaignID, int dstCampaignID) throws java.rmi.RemoteException{
    if (dMdeliverySoapAPIPort == null)
      _initDMdeliverySoapAPIPortProxy();
    return dMdeliverySoapAPIPort.copyFieldDefinition(login, srcCampaignID, dstCampaignID);
  }
  
  
}