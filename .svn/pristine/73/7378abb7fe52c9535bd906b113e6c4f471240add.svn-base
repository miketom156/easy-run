/**
 * DMdeliverySoapAPIPort.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dmdelivery.webservice;

public interface DMdeliverySoapAPIPort extends java.rmi.Remote {

    /**
     * Check the health of DMdelivery's webservice.
     * 		Specifically: check whether the webservice is available (http(s)
     * access), and the database is up and responsive.
     * 		Required credentials: none
     * 		
     * @param login: DMdelivery login object.
     * 		
     * @returns: true, when health is okay.
     */
    public boolean checkHealth(com.dmdelivery.webservice.DMdeliveryLoginType login) throws java.rmi.RemoteException;

    /**
     * Add a new recipient to the overall DMdelivery database.
     * 		Required credentials: 'insert' privilege for area 'Overall recipients'
     * 		
     * @param login: DMdelivery login object.
     * 		
     * @param campaignIDs: An array of overall campaigns (database IDs) to
     * make the recipients a member of. Provide at least one campaign.
     * 		
     * @param groupIDs: An array of groups (database IDs) to make the recipient
     * a member of. The groups here need to be present in all campaigns the
     * recipient becomes a member of! Provide at least one group. If this
     * array *only* contains the ID of the Opt-in group (60), the opt-in
     * confirmation email will be sent to the recipient.
     * 		
     * @param recipientData: An associative array (key: name of field, value:
     * value of field) containing recipient data.
     * 		
     * @param overwrite: In case the recipient already exists, whether or
     * not to overwrite the known recipient data with the new data provided.
     * If set to 'false', and the recipient to be added turns out to be duplicate,
     * then the recipient will not be added to the given campaigns and groups!
     * 		
     * @returns: The database ID of the newly created recipient.
     */
    public com.dmdelivery.webservice.RecordResultType addOverallRecipient(com.dmdelivery.webservice.DMdeliveryLoginType login, int[] campaignIDs, int[] groupIDs, com.dmdelivery.webservice.RecipientNameValuePairType[] recipientData, boolean overwrite) throws java.rmi.RemoteException;

    /**
     * Edit the data of an existing overall recipient, enabling modifying
     * campaign and/or group memberships.
     * 		Required credentials: 'update' privilege for area 'Overall recipients'
     * 		
     * @param login: DMdelivery login object.
     * 		
     * @param campaignIDs: An array of overall campaigns (database IDs) to
     * make the recipients a member of. For campaigns this recipient was
     * a member of but that are not included in $campaignIDs, the recipient
     * will be put in the Unsubscribers group. For all 'campaignIDs' given,
     * the recipient will be put in the 'groupIDs', while removing that recipient
     * from the Unsubscribe, Bounce and Spamcomplaint groups in these campaigns.
     * If this argument is an empty list, the recipient will be unsubscribed
     * from all campaigns he is a member of.
     * 		
     * @param recipientID: The database ID of the recipient to edit. Can
     * be found via getRecipientsByMatch.
     * 		
     * @param groupIDs: An array of groups (database IDs) to make the recipient
     * a member of. The groups here need to be present in all campaigns the
     * recipient becomes a member of! Provide at least one group.
     * 		
     * @param recipientData: An associative array (key: name of field, value:
     * value of field) containing updated recipient data.
     * 		
     * @returns: The database ID of the updated recipient.
     */
    public com.dmdelivery.webservice.RecordResultType editOverallRecipient(com.dmdelivery.webservice.DMdeliveryLoginType login, int[] campaignIDs, int recipientID, int[] groupIDs, com.dmdelivery.webservice.RecipientNameValuePairType[] recipientData) throws java.rmi.RemoteException;

    /**
     * Make an overall recipient a member of one or more groups in
     * one or more overall campaigns.
     * 		Required credentials: 'update' privilege for area 'Overall recipients'
     * 		
     * @param login: DMdelivery login object.
     * 		
     * @param campaignIDs: An array of overall campaigns (database IDs).
     * 		
     * @param recipientID: The database ID of the recipient.
     * 		
     * @param groupIDs: An array of groups (database IDs) to make the recipient
     * a member of. Provide at least one group.
     * 		
     * @returns: true
     */
    public boolean addOverallRecipientToGroups(com.dmdelivery.webservice.DMdeliveryLoginType login, int[] campaignIDs, int recipientID, int[] groupIDs) throws java.rmi.RemoteException;

    /**
     * Remove an overall recipient from one or more groups in one
     * or more overall campaigns.
     * 		Required credentials: 'delete' privilege for area 'Overall recipients'
     * 		
     * @param login: DMdelivery login object.
     * 		
     * @param campaignIDs: An array of overall campaigns (database IDs).
     * 		
     * @param recipientID: The database ID of the recipient.
     * 		
     * @param groupIDs: An array of groups (database IDs) to remove the recipient
     * from. Provide at least one group.
     * 		
     * @returns: true
     */
    public boolean removeOverallRecipientFromGroups(com.dmdelivery.webservice.DMdeliveryLoginType login, int[] campaignIDs, int recipientID, int[] groupIDs) throws java.rmi.RemoteException;

    /**
     * Edit the data of an existing recipient.
     * 		Required credentials: 'update' privilege for area 'Recipients'
     * 		
     * @param login: DMdelivery login object.
     * 		
     * @param campaignID: The database ID of the campaign to work with. Use
     * 0 to edit an overall recipient, regardless of campain.
     * 		
     * @param recipientID: The database ID of the recipient to edit. Can
     * be found via getRecipientsByMatch.
     * 		
     * @param recipientData: An array of name/value pairs, representing updated
     * recipient data.
     * 		
     * @returns: The database ID of the updated recipient.
     */
    public com.dmdelivery.webservice.RecordResultType editRecipient(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int recipientID, com.dmdelivery.webservice.RecipientNameValuePairType[] recipientData) throws java.rmi.RemoteException;

    /**
     * Retrieve all brands from DMdelivery.
     * 		Required credentials: 'export' privilege for area 'Brands'
     * 		
     * @param login: DMdelivery login object.
     * 		
     * @returns: An array of all brands in the DMdelivery environment.
     */
    public com.dmdelivery.webservice.BrandType[] getBrands(com.dmdelivery.webservice.DMdeliveryLoginType login) throws java.rmi.RemoteException;

    /**
     * Retrieve all campaigns from DMdelivery.
     * 		Required credentials: 'export' privilege for area 'Campaigns'
     * 		
     * @param login: DMdelivery login object.
     * 		
     * @returns: An array of all campaigns in the DMdelivery environment.
     */
    public com.dmdelivery.webservice.CampaignType[] getCampaigns(com.dmdelivery.webservice.DMdeliveryLoginType login) throws java.rmi.RemoteException;

    /**
     * Retrieve all sender addresses from DMdelivery.
     * 		Required credentials: 'export' privilege for area 'Sender addresses'
     * 		
     * @param login: DMdelivery login object.
     * 		
     * @returns: An array of all sender addresses in the DMdelivery environment.
     */
    public com.dmdelivery.webservice.SenderAddressType[] getSenderAddresses(com.dmdelivery.webservice.DMdeliveryLoginType login) throws java.rmi.RemoteException;

    /**
     * Retrieve all campaigns an overall recipient is member of, and
     * the groups they're member of within those campaigns.
     * 		Required credentials: access to area 'Overall recipients'
     * 		
     * @param login: DMdelivery login object.
     * 		
     * @param recipientID: The database ID of the overall recipient. Can
     * be found via getRecipientsByMatch.
     * 		
     * @returns: An array of campaigns (and groups) the recipient is member
     * of.
     */
    public com.dmdelivery.webservice.RecipientCampaignType[] getOverallRecipientCampaigns(com.dmdelivery.webservice.DMdeliveryLoginType login, int recipientID) throws java.rmi.RemoteException;

    /**
     * Retrieve recipients that match certain criteria, including
     * their database ID.
     * 		Required credentials: 'export' privilege for area 'Recipients'
     * 		
     * @param login: DMdelivery login object.
     * 		
     * @param recipientMatchData: An array of name/value pairs that represent
     * criteria to match recipients by. Ex: (('name'=>'email', 'value'=>'user@example.com'),('name'=>'firstname',
     * 'value'=>'John')). Wildcards '*' and '?' can be used as well.
     * 		
     * @returns: An array of recipients that match the criteria.
     */
    public com.dmdelivery.webservice.RecipientType[] getRecipientsByMatch(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, com.dmdelivery.webservice.RecipientNameValuePairType[] recipientData) throws java.rmi.RemoteException;

    /**
     * Retrieve recipient fields for a DMdelivery campaign.
     * 		Required credentials: access to area 'Define fields'
     * 		
     * @param login: DMdelivery login object.
     * 		
     * @param campaignID: The database ID of the campaign to work with. Use
     * 0 to retrieve fields in the overall database.
     * 		
     * @param lang: The language to retrieve fields in.
     * 		
     * @returns: An array of all recipient fields defined for the campaign.
     */
    public com.dmdelivery.webservice.RecipientFieldType[] getRecipientFields(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, java.lang.String lang) throws java.rmi.RemoteException;

    /**
     * Send a mailing to a single recipient. Mainly used for (un)subscribe
     * confirmations etc.
     * 		Of emails sent through this function, no statistics will be registered.
     * 		Do not use this function to send many emails to many different recipients!
     * 		Required credentials: access to area 'Send mailing'
     * 		
     * @param login: DMdelivery login object.
     * 		
     * @param campaignID: The database ID of the campaign to work with.
     * 		
     * @param mailingID: The database ID of the mailing to send.
     * 		
     * @param recipientID: The database ID of the recipient to send to. Can
     * be found via getRecipientsByMatch.
     * 		
     * @returns: true
     */
    public boolean sendSingleMailing(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int mailingID, int recipientID) throws java.rmi.RemoteException;

    /**
     * Send an SMS message to a single recipient.
     * 		Required credentials: access to area 'Send SMS mailing'
     * 		
     * @param login: DMdelivery login object.
     * 		
     * @param campaignID: The database ID of the campaign to work with.
     * 		
     * @param mailingID: The database ID of the SMS mailing to send.
     * 		
     * @param recipientID: The database ID of the recipient to send to. Can
     * be found via getRecipientsByMatch.
     * 		
     * @returns: true
     */
    public boolean sendSingleSMS(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int mailingID, int recipientID) throws java.rmi.RemoteException;

    /**
     * Bulk-send a mailing.
     * 		Required credentials: access to area 'Send mailing'
     * 		
     * @param login: DMdelivery login object.
     * 		
     * @param campaignID: The database ID of the campaign to work with.
     * 		
     * @param mailingID: The database ID of the mailing to send.
     * 		
     * @param isTest: Use true for test batch, false for definitive batch.
     * 		
     * @param resultsEmail: The email address of the person who should receive
     * logfile.
     * 		
     * @param groupIDs: Array of (database IDs of) groups to send the mailing
     * to. Provide at least one group.
     * 		
     * @param filterID: The database ID of the filter to use for matching
     * recipients. Use 0 for no filter.
     * 		
     * @param langs: An array of languages to send the mailing to. Ex: ('en',
     * 'nl').
     * 		
     * @param ADprefixDomains: Optional and for China only: A comma-separated
     * string of domains that need an (AD) prefix. For example: *163.com,*126.com,yeah.net,188.com.
     * 		
     * @param callbackUrl: An (optional) url DMdelivery will call after the
     * mailing has been sent.
     * 		       You can use the following variables in this URL, which DMdelivery
     * will replace:
     * 				 - {$DMDcid} The campaign id
     * 				 - {$DMDmid} The mailing id
     * 				 - {$nrRecipients} The number of recipients in the batch
     * 				 - {$nrSent} The number of emails actually sent
     * 		
     * @returns: status 'OK'
     */
    public com.dmdelivery.webservice.RecordResultType sendMailing(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int mailingID, boolean isTest, java.lang.String resultsEmail, int[] groupIDs, int filterID, java.lang.String[] langs, java.lang.String ADprefixDomains, java.lang.String callbackUrl) throws java.rmi.RemoteException;

    /**
     * Send a system mail to a single recipient, optionally attaching
     * files.
     * 		The filesize of all attachments is limited to 10MB.
     * 		Required credentials: access to area 'Send mailing'
     * 		
     * @param login: DMdelivery login object.
     * 		
     * @param campaignID: The database ID of the campaign to work with.
     * 		
     * @param mailingID: The database ID of the mailing to send.
     * 		
     * @param recipientID: The database ID of the recipient to send to.
     * 		
     * @param attachments: Comma-separated string of attachment-id's to attach
     * to the email. May be empty.
     * 		
     * @returns: status 'OK'
     */
    public boolean sendSystemMail(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int mailingID, int recipientID, java.lang.String attachments) throws java.rmi.RemoteException;

    /**
     * Bulk-send a mailing at a later date/time, optionally using
     * approval procedure.
     * 		Required credentials: access to area 'Send mailing'
     * 		
     * @param login: DMdelivery login object.
     * 		
     * @param campaignID: The database ID of the campaign to work with.
     * 		
     * @param mailingID: The database ID of the mailing to send.
     * 		
     * @param sendDate: The date/time to send the mailing at, in ISO format.
     * You can only schedule 
     * @ :03, :18, :33, :48. Example: '2012-03-29 09:03:00'
     * 		
     * @param isTest: Use true for test batch, false for definitive batch.
     * 		
     * @param resultsEmail: The email address of the person who should receive
     * logfile.
     * 		
     * @param groupIDs: Array of (database IDs of) groups to send the mailing
     * to. Provide at least one group.
     * 		
     * @param filterID: The database ID of the filter to use for matching
     * recipients. Use 0 for no filter.
     * 		
     * @param langs: An array of languages to send the mailing to. Ex: ('en',
     * 'nl').
     * 		
     * @param ADprefixDomains: Optional and for China only: A comma-separated
     * string of domains that need an (AD) prefix. For example: *163.com,*126.com,yeah.net,188.com.
     * 		
     * @param callbackUrl: An (optional) url DMdelivery will call after the
     * mailing has been sent.
     * 		       You can use the following variables in this URL, which DMdelivery
     * will replace:
     * 				 - {$DMDcid} The campaign id
     * 				 - {$DMDmid} The mailing id
     * 				 - {$nrRecipients} The number of recipients in the batch
     * 				 - {$nrSent} The number of emails actually sent
     * 		
     * @param approvalDMDgid: Approval group id. Provide this argument to
     * use approval module.
     * 		
     * @param approvalPeriod: How many hours to wait between approval sendout
     * and definitive sendout.
     * 		
     * @param approvalAck: At least X people must approve the mailing.
     * 		
     * @param $approvalNack: At most X people may disapprove the mailing.
     * 		
     * @returns: status 'OK'
     */
    public com.dmdelivery.webservice.RecordResultType sendMailingScheduled(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int mailingID, java.lang.String sendDate, boolean isTest, java.lang.String resultsEmail, int[] groupIDs, int filterID, java.lang.String[] langs, java.lang.String ADprefixDomains, java.lang.String callbackUrl, int approvalGroupID, float approvalPeriod, int approvalAck, int approvalNack) throws java.rmi.RemoteException;

    /**
     * Bulk-send an SMS.
     * 		Required credentials: access to area 'Send SMS mailing'
     * 		When messages, after personalizing, exceed a length of 160 characters,
     * multiple SMS's are sent.
     * 		
     * @param login: DMdelivery login object.
     * 		
     * @param campaignID: The database ID of the campaign to work with.
     * 		
     * @param mailingID: The database ID of the SMS mailing to send.
     * 		
     * @param isTest: Use true for test batch, false for definitive batch.
     * 		
     * @param resultsEmail: The email address of the person who should receive
     * logfile.
     * 		
     * @param groupIDs: Array of (database IDs of) groups to send the mailing
     * to. Provide at least one group.
     * 		
     * @param filterID: The database ID of the filter to use for matching
     * recipients. Use 0 for no filter.
     * 		
     * @param lang: An array of languages to send the mailing to. Ex: ('en',
     * 'nl').
     * 		
     * @param callbackUrl: An (optional) url DMdelivery will call after the
     * SMS mailing has been sent.
     * 		       You can use the following variables in this URL, which DMdelivery
     * will replace:
     * 				 - {$DMDcid} The campaign id
     * 				 - {$DMDmid} The SMS mailing id
     * 				 - {$nrRecipients} The number of recipients in the batch
     * 				 - {$nrSent} The number of SMS messages actually sent
     * 		
     * @returns: status 'OK'
     */
    public com.dmdelivery.webservice.RecordResultType sendSMS(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int mailingID, boolean isTest, java.lang.String resultsEmail, int[] groupIDs, int filterID, java.lang.String[] langs, java.lang.String ADprefixDomains, java.lang.String callbackUrl) throws java.rmi.RemoteException;

    /**
     * Create a mailing from scratch, providing raw HTML.
     * 		The plaintext-message is inherited from the campaign's default plaintext
     * message.
     * 		Required credentials: 'insert' privilege for area 'Mailings'
     * 		
     * @param login: DMdelivery login object.
     * 		
     * @param campaignID: The database ID of the campaign to work with.
     * 		
     * @param mailingName: The name to store the mailing as (must be unique!).
     * 		
     * @param lang: The ISO-lang code for the mailing. Ex: 'nl', 'en', etc.
     * 		
     * @param subject: The default subject of the mailing. Can be overwritten
     * in the HTML to fetch.
     * 		
     * @param fromName: The from name.
     * 		
     * @param senderID: The database ID of the sender address. Use 0 for
     * campaign's default sender address.
     * 		
     * @param html: The mailing's HTML.
     * 		
     * @returns: The database ID of the mailing that was created.
     */
    public com.dmdelivery.webservice.RecordResultType createMailing(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, java.lang.String mailingName, java.lang.String lang, java.lang.String subject, java.lang.String fromName, int senderID, java.lang.String html) throws java.rmi.RemoteException;

    /**
     * Create a mailing from a URL.
     * 		Required credentials: 'insert' privilege for area 'Mailings'
     * 		
     * @param login: DMdelivery login object.
     * 		
     * @param campaignID: The database ID of the campaign to work with.
     * 		
     * @param mailingName: The name to store the mailing as (must be unique!).
     * 		
     * @param lang: The ISO-lang code for the mailing. Ex: 'nl', 'en', etc.
     * 		
     * @param subject: The default subject of the mailing. Can be overwritten
     * in the HTML to fetch.
     * 		
     * @param fromName: The from name.
     * 		
     * @param senderID: The database ID of the sender address. Use 0 for
     * campaign's default sender address.
     * 		
     * @param url: The url where the mailing HTML (or a ZIP file) can be
     * fetched from.
     * 		
     * @param checkTimestamp: Whether or not to check the HTML for a <!--DMdeliveryTimestamp-->
     * tag. Ignored for ZIP files.
     * 		
     * @returns: The database ID of the mailing that was created.
     */
    public com.dmdelivery.webservice.RecordResultType slurpMailing(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, java.lang.String mailingName, java.lang.String lang, java.lang.String subject, java.lang.String fromName, int senderID, java.lang.String url, boolean checkTimestamp) throws java.rmi.RemoteException;

    /**
     * Remove a recipient from one or more groups.
     * 		Required credentials: 'update' privilege for area 'Recipients'
     * 		
     * @param login: DMdelivery login object.
     * 		
     * @param campaignID: The database ID of the campaign to work with.
     * 		
     * @param recipientID: The database ID of the recipient. Can be found
     * via getRecipientsByMatch.
     * 		
     * @param groupIDs: The (database ID of) the groups to remove the recipient
     * from. Provide at least one group.
     * 		
     * @returns: An array of groups (database IDs) the recipient is now a
     * member of.
     */
    public int[] removeRecipientFromGroups(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int recipientID, int[] groupIDs) throws java.rmi.RemoteException;

    /**
     * Make a recipient a member of one or more groups.
     * 		Required credentials: 'update' privilege for area 'Recipients'
     * 		
     * @param login: DMdelivery login object.
     * 		
     * @param campaignID: The database ID of the campaign to work with.
     * 		
     * @param recipientID: The database ID of the recipient.
     * 		
     * @param groupIDs: An array of groups (database IDs) to make the recipients
     * a member of. Provide at least one group.
     * 		
     * @returns: An array of groups (database IDs) the recipient is now a
     * member of.
     */
    public int[] addRecipientToGroups(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int recipientID, int[] groupIDs) throws java.rmi.RemoteException;

    /**
     * Move all recipients from one group to another group.
     * 		Required credentials: access to area 'Groups'
     * 		
     * @param login: DMdelivery login object.
     * 		
     * @param campaignID: The database ID of the campaign to work with.
     * 		
     * @param fromGroupID: The database ID of the source group.
     * 		
     * @param toGroupID: The database ID of the target group.
     * 		
     * @returns: The number of recipients that were moved to the target group.
     */
    public int moveRecipientsToGroup(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int fromGroupID, int toGroupID) throws java.rmi.RemoteException;

    /**
     * Retrieve all mailings from a DMdelivery campaign. Mailings
     * are returned from new to old (newest on top).
     * 		Required credentials: 'export' privilege for area 'Mailings'
     * 		
     * @param login: DMdelivery login object.
     * 		
     * @param campaignID: The database ID of the campaign to work with.
     * 		
     * @param limit: indicates the number of mailings to retrieve. Use 0
     * to retrieve *all* mailings.
     * 		
     * @param definitiveOnly: Whether or not to only return definitively
     * sent mailings.
     * 		
     * @returns: An array of all mailings in the campaign.
     */
    public com.dmdelivery.webservice.MailingType[] getMailings(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int limit, boolean definitiveOnly) throws java.rmi.RemoteException;

    /**
     * Retrieve all SMS mailings from a DMdelivery campaign. Mailings
     * are returned from new to old (newest on top).
     * 		Required credentials: 'export' privilege for area 'SMS mailings'
     * 		
     * @param login: DMdelivery login object.
     * 		
     * @param campaignID: The database ID of the campaign to work with.
     * 		
     * @param limit: indicates the number of SMS mailings to retrieve. Use
     * 0 to retrieve *all* mailings.
     * 		
     * @param definitiveOnly: Whether or not to only return definitively
     * sent SMS mailings.
     * 		
     * @returns: An array of all SMS mailings in the campaign.
     */
    public com.dmdelivery.webservice.SMSMailingType[] getSMSMailings(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int limit, boolean definitiveOnly) throws java.rmi.RemoteException;

    /**
     * Retrieve recipients from a specific DMdelivery group.
     * 		Required credentials: 'export' privilege for area 'Recipients'
     * 		
     * @param login: DMdelivery login object.
     * 		
     * @param campaignID: The database ID of the campaign to work with.
     * 		
     * @param fields: Array of fields to retrieve. Ex: ('email', 'firstname',
     * 'lastname'). Provide at least one field.
     * 		
     * @param inGroupID: Database ID of group the recipients should be member
     * of.
     * 		
     * @param fromDate: Date since when recipient became a member of 'inGroupID'.
     * Leave empty if it doesn't matter, otherwise use 'YYYY-MM-DD' format.
     * 		
     * @param mailingIDs: Array of (database IDs of) mailings the recipients
     * must have been sent. May be empty.
     * 		
     * @param filterID: The database ID of the filter to use for matching
     * recipients. Use 0 for no filter.
     * 		
     * @returns: An array of recipients.
     */
    public com.dmdelivery.webservice.RecipientType[] getRecipientsFromGroup(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, java.lang.String[] fields, int inGroupID, java.util.Date fromDate, int[] mailingIDs, int filterID) throws java.rmi.RemoteException;

    /**
     * Retrieve recipients from a DMdelivery campaign.
     * 		Required credentials: 'export' privilege for area 'Recipients'
     * 		Provide at least one inGroupID or mailingID (inGroupIDs and mailingIDs
     * can't both be empty).
     * 		
     * @param login: DMdelivery login object.
     * 		
     * @param campaignID: The database ID of the campaign to work with.
     * 		
     * @param fields: Array of fields to retrieve. Ex: ('email', 'firstname',
     * 'lastname'). Provide at least one field.
     * 		
     * @param inGroupIDs: Array of (database IDs of) groups the recipients
     * should be member of. May be empty.
     * 		
     * @param notInGroupIDs: Array of (database IDs of) groups the recipients
     * should *not* be member of. May be empty.
     * 		
     * @param mailingIDs: Array of (database IDs of) mailings the recipients
     * must have been sent. May be empty.
     * 		
     * @param filterID: The database ID of the filter to use for matching
     * recipients. Use 0 for no filter.
     * 		
     * @returns: An array of recipients.
     */
    public com.dmdelivery.webservice.RecipientType[] getRecipients(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, java.lang.String[] fields, int[] inGroupIDs, int[] notInGroupIDs, int[] mailingIDs, int filterID) throws java.rmi.RemoteException;

    /**
     * Retrieve the groups a recipient is member of.
     * 		Required credentials: 'export' privilege for area 'Groups'
     * 		
     * @param login: DMdelivery login object.
     * 		
     * @param campaignID: The database ID of the campaign to work with.
     * 		
     * @param recipientID: The database ID of the recipient. Can be found
     * via getRecipientsByMatch.
     * 		
     * @returns: An array with all (database IDs of) groups the recipient
     * is now a member of.
     */
    public int[] getRecipientGroups(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int recipientID) throws java.rmi.RemoteException;

    /**
     * Retrieve summarized statistics for a mailing sent. Mailing
     * must be sent in order to be able to do this.
     * 		Required credentials: access to area 'Statistics'
     * 		
     * @param login: DMdelivery login object.
     * 		
     * @param campaignID: The database ID of the campaign to work with.
     * 		
     * @param mailingID: The database ID of the mailing to fetch the summary
     * for.
     * 		
     * @returns: An array containing summary stats info (sent, bounces, unsubscribers,
     * opens, clicks, conversion etc).
     */
    public com.dmdelivery.webservice.MailingStatsSummaryResultType getMailingStatsSummary(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int mailing) throws java.rmi.RemoteException;

    /**
     * Retrieve all groups from a DMdelivery campaign.
     * 		Required credentials: 'export' privilege for area 'Groups'
     * 		
     * @param login: DMdelivery login object.
     * 		
     * @param campaignID: The database ID of the campaign to work with.
     * 		
     * @returns: An array of all groups in the campaign.
     */
    public com.dmdelivery.webservice.GroupType[] getGroups(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID) throws java.rmi.RemoteException;

    /**
     * Retrieve the response (what recipients opened/clicked) for
     * a mailing.
     * 		Required credentials: access to area 'Statistics'
     * 		
     * @param login: DMdelivery login object.
     * 		
     * @param campaignID: The database ID of the campaign to work with.
     * 		
     * @param mailingID: The database ID of the mailing to fetch the response
     * for.
     * 		
     * @param types: Either 'click', 'open', 'trigger' or a combination (comma
     * separated), for example 'click,open' or 'click,trigger'.
     * 		
     * @param field: The name of the recipient field to retrieve, for example
     * 'id' or 'email'.
     * 		
     * @returns: An array containing response info (recipient_id, type [open,click,trigger]
     * and log_date).
     */
    public com.dmdelivery.webservice.MailingResponseType[] getMailingResponse(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int mailingID, java.lang.String types, java.lang.String field) throws java.rmi.RemoteException;

    /**
     * Delete a mailing from a campaign.
     * 		Required credentials: 'delete' privilege for area 'Mailings'
     * 		
     * @param login: DMdelivery login object.
     * 		
     * @param campaignID: The database ID of the campaign to work with.
     * 		
     * @param mailingID: The database ID of the mailing to delete.
     * 		
     * @returns: 'OK' or 'ERROR'
     */
    public com.dmdelivery.webservice.RecordResultType deleteMailing(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int mailingID) throws java.rmi.RemoteException;

    /**
     * Add a new group to this DMdelivery campaign.
     * 		Required credentials: 'insert' privilege for area 'Groups'
     * 		
     * @param login: DMdelivery login object.
     * 		
     * @param campaignID: The database ID of the campaign to work with.
     * 		
     * @param group: The characteristics of the group to add.
     * 		
     * @returns: The database ID of the newly created group.
     */
    public com.dmdelivery.webservice.RecordResultType addGroup(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, com.dmdelivery.webservice.NewGroupType group) throws java.rmi.RemoteException;

    /**
     * Flush all recipients from a recipient group, keep the group.
     * 		The recipients are 'disconnected' from the group, not physically
     * deleted.
     * 		Afterwards, the group will still exist, but contains no recipients
     * anymore.
     * 		Required credentials: 'delete' privilege for area 'Groups'
     * 		
     * @param login: DMdelivery login object.
     * 		
     * @param campaignID: The database ID of the campaign to work with.
     * 		
     * @param groupID: The database ID of the group to delete.
     * 		
     * @returns: Number of recipients actually flushed.
     */
    public int flushGroup(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int groupID) throws java.rmi.RemoteException;

    /**
     * Flush all recipients from a recipient group, then delete the
     * group.
     * 		The recipients are 'disconnected' from the group, not physically
     * deleted.
     * 		Afterwards, the group will no longer exist.
     * 		Required credentials: 'delete' privilege for area 'Groups'
     * 		
     * @param login: DMdelivery login object.
     * 		
     * @param campaignID: The database ID of the campaign to work with.
     * 		
     * @param groupID: The database ID of the group to delete.
     * 		
     * @returns: Number of groups (0 or 1) actually deleted.
     */
    public int deleteGroup(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int groupID) throws java.rmi.RemoteException;

    /**
     * Add a new recipient to a DMdelivery campaign.
     * 		Required credentials: 'insert' privilege for area 'Recipients'
     * 		
     * @param login: DMdelivery login object.
     * 		
     * @param campaignID: The database ID of the campaign to work with.
     * 		
     * @param groupIDs: An array of groups (database IDs) to make the recipient
     * a member of. Provide at least one group. If this array *only* contains
     * the ID of the Opt-in group (60), *and* this is a non-existing recipient,
     * the opt-in confirmation email will be sent to the recipient.
     * 		
     * @param recipientData: An associative array (key: name of field, value:
     * value of field) containing recipient data.
     * 		
     * @param addDuplisToGroup: Whether or not to add this recipient to the
     * groups, when the recipient is in the database already.
     * 		
     * @param overwrite: In case the recipient already exists, whether or
     * not to overwrite the known recipient data with the new data provided.
     * 		
     * @returns: The database ID of the newly created recipient.
     */
    public com.dmdelivery.webservice.RecordResultType addRecipient(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int[] groupIDs, com.dmdelivery.webservice.RecipientNameValuePairType[] recipientData, boolean addDuplisToGroups, boolean overwrite) throws java.rmi.RemoteException;

    /**
     * Upload a recipient-specific attachment to DMdelivery.
     * 		The file will be scanned for viruses, and may not be larger than
     * 5MB.
     * 		Required credentials: 'insert' privilege for area 'Mailings',
     * 							  'insert' privilege for area 'Recipients'.
     * 		
     * @param login: DMdelivery login object.
     * 		
     * @param campaignID: The database ID of the campaign to work with.
     * 		
     * @param mailingID: The database ID of the mailing to attach this file
     * to.
     * 		
     * @param recipientID: The database ID of the recipient to send this
     * file to.
     * 		
     * @param fileName: The name of the file.
     * 		
     * @param fileMD5: The md5 hash of the file.
     * 		
     * @param fileData: The actual file, base64 encoded.
     * 		
     * @returns: A unique ID (a 14-character string) for this attachment.
     */
    public java.lang.String addRecipientAttachment(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int mailingID, int recipientID, java.lang.String fileName, java.lang.String fileMD5, java.lang.String fileData) throws java.rmi.RemoteException;

    /**
     * Upload a mailing-specific attachment to DMdelivery.
     * 		The file will be scanned for viruses, and may not be larger than
     * 5MB.
     * 		Required credentials: 'insert' privilege for area 'Mailings',
     * 		
     * @param login: DMdelivery login object.
     * 		
     * @param campaignID: The database ID of the campaign to work with.
     * 		
     * @param mailingID: The database ID of the mailing to attach this file
     * to.
     * 		
     * @param fileName: The name of the file.
     * 		
     * @param fileMD5: The md5 hash of the file.
     * 		
     * @param fileData: The actual file, base64 encoded.
     * 		
     * @returns: A unique ID (a 14-character string) for this attachment.
     */
    public java.lang.String addMailingAttachment(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int mailingID, java.lang.String fileName, java.lang.String fileMD5, java.lang.String fileData) throws java.rmi.RemoteException;

    /**
     * Delete mailing-specific attachments, by ID.
     * 		Required credentials: 'delete' privilege for area 'Mailings',
     * 		
     * @param login: DMdelivery login object.
     * 		
     * @param campaignID: The database ID of the campaign to work with.
     * 		
     * @param mailingID: The database ID of the mailing to attach this file
     * to.
     * 		
     * @param attachmentIDs: The IDs (comma separated string) of the attachments
     * to delete.
     * 		
     * @returns: 'OK'
     */
    public com.dmdelivery.webservice.RecordResultType deleteMailingAttachments(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int mailingID, java.lang.String attachmentIDs) throws java.rmi.RemoteException;

    /**
     * Retrieve the ID's of all attachments available for a mailing
     * (uploaded via addMailingAttachment).
     * 		Required credentials: access to area 'Mailings'
     * 		
     * @param login: DMdelivery login object.
     * 		
     * @param campaignID: The database ID of the campaign to work with.
     * 		
     * @param mailingID: The database ID of the mailing to attach this file
     * to.
     * 		
     * @returns: A comma-separated list of attachment-ID's (of type string).
     */
    public java.lang.String getMailingAttachmentIDs(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int mailingID) throws java.rmi.RemoteException;

    /**
     * Add multiple new recipients to DMdelivery (max 1000 at once).
     * 		Required credentials: 'insert' privilege for area 'Recipients'
     * 		
     * @param login: DMdelivery login object.
     * 		
     * @param campaignID: The database ID of the campaign to work with.
     * 		
     * @param groupIDs: An array of groups (database IDs) to make the recipients
     * a member of. Provide at least one group.
     * 		
     * @param recipientDatas: An array of associative arrays (key: name of
     * field, value: value of field) containing recipient data.
     * 		
     * @param addDuplisToGroup: Whether or not to add this recipient to the
     * groups, when the recipient is in the database already.
     * 		
     * @param overwrite: In case a recipient already exists, whether or not
     * to overwrite the known recipient data with the new data provided.
     * 		
     * @returns: Complex datatype, containing all successfully inserted records
     * (including the ID assigned by DMdelivery), duplicates and/or errors.
     */
    public com.dmdelivery.webservice.AddRecipientsResultType addRecipients(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int[] groupIDs, com.dmdelivery.webservice.RecipientNameValuePairType[][] recipientDatas, boolean addDuplisToGroups, boolean overwrite) throws java.rmi.RemoteException;

    /**
     * Import recipients (max 1000 at once), while sending a (definitive)
     * mailing to them.
     * 		Required credentials: 'insert' privilege for area 'Recipients' AND
     * access to area 'Send mailing'
     * 		
     * @param login: DMdelivery login object.
     * 		
     * @param campaignID: The database ID of the campaign to work with.
     * 		
     * @param mailingID: The database ID of the mailing to send.
     * 		
     * @param groupIDs: An array of groups (database IDs) to make the recipients
     * a member of. Provide at least one group.
     * 		
     * @param recipientDatas: An array of associative arrays (key: name of
     * field, value: value of field) containing recipient data.
     * 		
     * @param addDuplisToGroup: Whether or not to add this recipient to the
     * groups, when the recipient is in the database already.
     * 		
     * @param overwrite: In case a recipient already exists, whether or not
     * to overwrite the known recipient data with the new data provided.
     * 		
     * @returns: Complex datatype, containing all duplicates and/or errors.
     */
    public com.dmdelivery.webservice.AddRecipientsResultType addRecipientsSendMailing(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int mailingID, int[] groupIDs, com.dmdelivery.webservice.RecipientNameValuePairType[][] recipientDatas, boolean addDuplisToGroups, boolean overwrite) throws java.rmi.RemoteException;

    /**
     * Import recipients (max 1000 at once), while sending a (definitive)
     * SMS to them.
     * 		Required credentials: 'insert' privilege for area 'Recipients' AND
     * access to area 'Send mailing'
     * 		
     * @param login: DMdelivery login object.
     * 		
     * @param campaignID: The database ID of the campaign to work with.
     * 		
     * @param SMSmailingID: The database ID of the SMS mailing to send.
     * 		
     * @param groupIDs: An array of groups (database IDs) to make the recipients
     * a member of. Provide at least one group.
     * 		
     * @param recipientDatas: An array of associative arrays (key: name of
     * field, value: value of field) containing recipient data.
     * 		
     * @param addDuplisToGroup: Whether or not to add this recipient to the
     * groups, when the recipient is in the database already.
     * 		
     * @param overwrite: In case a recipient already exists, whether or not
     * to overwrite the known recipient data with the new data provided.
     * 		
     * @returns: Complex datatype, containing all duplicates and/or errors.
     */
    public com.dmdelivery.webservice.AddRecipientsResultType addRecipientsSendSMS(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int SMSmailingID, int[] groupIDs, com.dmdelivery.webservice.RecipientNameValuePairType[][] recipientDatas, boolean addDuplisToGroups, boolean overwrite) throws java.rmi.RemoteException;

    /**
     * Import a remotely located CSV file, containing recipient info,
     * into DMdelivery.
     * 		Supports http, https, ftp, sftp, ftps and scp protocols.
     * 		Required credentials: 'import' privilege for area 'Recipients'
     * 		Errors and Duplicates are uploaded back to the same location the
     * CSV was downloaded from.
     * 		For example, if this is the CSV file:
     * 		- ftp://username:password@somewhere.server.com:80/incoming/recipients.csv
     * 		Then errors and duplicates will be available here when the import
     * has finished:
     * 		- ftp://username:password@somewhere.server.com:80/incoming/recipients.csv.errors
     * 		- ftp://username:password@somewhere.server.com:80/incoming/recipients.csv.duplis
     * 		The 'callbackUrl' argument is used to let you know when the import
     * is finished.
     * 		This can be an email address: An email is sent to this address when
     * import is finished.
     * 		This can be a URL: The URL is fetched when import is finished. The
     * URL may contain the following
     * 		   placeholders: {$DMDcid}, {$nrLines}, {$nrDuplicates} and {$nrErrors}
     * 
     * 		
     * @param login: DMdelivery login object.
     * 		
     * @param campaignID: The database ID of the campaign to work with.
     * 		
     * @param groupID: The ID of the group to import the recipients into.
     * 		
     * @param csvURL: The URL of the CSV file. Examples:
     * 		- http://username:password@somewhere.server.com:80/recipients.csv
     * 		- ftp://username:password@somewhere.server.com/incoming/recipients.csv
     * 		- sftp://username:password@somewhere.server.com/root/csvs/recipients.csv
     * 		
     * @param csvCharset: The character set of the CSV file. For example:
     * utf-8, iso-8859-1, gb2312
     * 		
     * @param csvFieldSep: The field separator character used in the CSV
     * file.
     * 		
     * @param csvEnclosure: The enclosure character used in the CSV file.
     * 		
     * @param addDuplisToGroup: Whether or not to add this recipient to the
     * groups, when the recipient is in the database already.
     * 		
     * @param overwrite: In case a recipient already exists, whether or not
     * to overwrite the known recipient data with the new data provided.
     * 		
     * @param callbackUrl: Either an email address or a URL. Will be emailed/called
     * when import is done.
     * 		
     * @returns: 'OK', when remote file could be found or 'ERROR' if not.
     */
    public com.dmdelivery.webservice.RecordResultType importRemoteCSV(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int groupID, java.lang.String csvURL, java.lang.String csvCharset, java.lang.String csvFieldSep, java.lang.String csvEnclosure, boolean addDuplisToGroups, boolean overwrite, java.lang.String callbackUrl) throws java.rmi.RemoteException;

    /**
     * Import a remotely located CSV file, containing recipient info,
     * into DMdelivery.
     * 		Send a mailing to this group (optionally applying filter/language)
     * when import is finished.
     * 		Supports http, https, ftp, sftp, ftps and scp protocols.
     * 		Required credentials: 'import' privilege for area 'Recipients' and
     * access to area 'Send mailing'
     * 		Errors and Duplicates are uploaded back to the same location the
     * CSV was downloaded from.
     * 		For example, if this is the CSV file:
     * 		- ftp://username:password@somewhere.server.com:80/incoming/recipients.csv
     * 		Then errors and duplicates will be available here when the import
     * has finished:
     * 		- ftp://username:password@somewhere.server.com:80/incoming/recipients.csv.errors
     * 		- ftp://username:password@somewhere.server.com:80/incoming/recipients.csv.duplis
     * 
     * 		
     * @param login: DMdelivery login object.
     * 		
     * @param campaignID: The database ID of the campaign to work with.
     * 		
     * @param groupID: The ID of the group to import the recipients into.
     * 		
     * @param csvURL: The URL of the CSV file. Examples:
     * 		- http://username:password@somewhere.server.com:80/recipients.csv
     * 		- ftp://username:password@somewhere.server.com/incoming/recipients.csv
     * 		- sftp://username:password@somewhere.server.com/root/csvs/recipients.csv
     * 		
     * @param csvCharset: The character set of the CSV file. For example:
     * utf-8, iso-8859-1, gb2312
     * 		
     * @param csvFieldSep: The field separator character used in the CSV
     * file.
     * 		
     * @param csvEnclosure: The enclosure character used in the CSV file.
     * 		
     * @param addDuplisToGroup: Whether or not to add this recipient to the
     * groups, when the recipient is in the database already.
     * 		
     * @param overwrite: In case a recipient already exists, whether or not
     * to overwrite the known recipient data with the new data provided.
     * 		
     * @param mailingID: The database ID of the mailing to send.
     * 		
     * @param resultsEmail: The email address of the person who should receive
     * logfile.
     * 		
     * @param filterID: The database ID of the filter to use for matching
     * recipients. Use 0 for no filter.
     * 		
     * @param langs: An array of languages to send the mailing to. Ex: ('en',
     * 'nl').
     * 		
     * @param ADprefixDomains: Optional and for China only: A comma-separated
     * string of domains that need an (AD) prefix. For example: *163.com,*126.com,yeah.net,188.com.
     * 		
     * @param callbackUrl: An (optional) url DMdelivery will call after the
     * mailing has been sent.
     * 		       You can use the following variables in this URL, which DMdelivery
     * will replace:
     * 				 - {$DMDcid} The campaign id
     * 				 - {$DMDmid} The mailing id
     * 				 - {$nrRecipients} The number of recipients in the batch
     * 				 - {$nrSent} The number of emails actually sent
     * 		
     * @returns: status 'OK'
     */
    public com.dmdelivery.webservice.RecordResultType importRemoteCSVSendMailing(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int groupID, java.lang.String csvURL, java.lang.String csvCharset, java.lang.String csvFieldSep, java.lang.String csvEnclosure, boolean addDuplisToGroups, boolean overwrite, int mailingID, java.lang.String resultsEmail, int filterID, java.lang.String[] langs, java.lang.String ADprefixDomains, java.lang.String callbackUrl) throws java.rmi.RemoteException;

    /**
     * Get all events for a specified campaign
     * 		
     * @param login: DMdelivery login object.
     * 		
     * @param campaignID: The database ID of the campaign to work with.
     * 		
     * @param eventID: Optional eventID parameter
     * 		
     * @returns: Complex datatype, containing all duplicates and/or errors.
     */
    public com.dmdelivery.webservice.EventType[] getEvents(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int eventID) throws java.rmi.RemoteException;

    /**
     * Add or update an attendee for a specified event
     * 		
     * @param login: DMdelivery login object.
     * 		
     * @param campaignID: The database ID of the campaign to work with.
     * 		
     * @param eventID: The eventID of the event the attendee should be added
     * to.
     * 		
     * @param status: Boolean flag to set weather the given attendee is attending
     * the event.
     * 		
     * @returns: Returns original attendee data with extra fields eventResponse
     * and eventMessage.
     */
    public com.dmdelivery.webservice.RecipientNameValuePairType[] addEventAttendee(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int eventID, com.dmdelivery.webservice.RecipientNameValuePairType[] recipientData, boolean status) throws java.rmi.RemoteException;

    /**
     * Get all attendees for an event
     * 		
     * @param login: DMdelivery login object.
     * 		
     * @param campaignID: The database ID of the campaign to work with.
     * 		
     * @param eventID: The eventID of the event the attendee should be added
     * to.
     * 		
     * @returns: Multidimensional array with recipient data formatted as
     * name/value pairs.
     */
    public com.dmdelivery.webservice.RecipientNameValuePairType[][] getEventAttendees(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int eventID) throws java.rmi.RemoteException;

    /**
     * Get the filters available in a campaign.
     *             
     * @param login: DMdelivery login object
     *             
     * @param campaignID: The database ID of the campaign to work with.
     *             
     * @returns: Multidimensional array with filter data containing ID and
     * name.
     */
    public com.dmdelivery.webservice.FilterType[] getFilters(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID) throws java.rmi.RemoteException;

    /**
     * Create a sender address, according to the "My own sender address"
     * scenario.
     * 		CAUTION: This function is disabled by default. Please contact Web
     * Power to enable it.
     * 		
     * @param login: DMdelivery login object.
     * 		
     * @param fromEmail: The 'from' email address.
     * 		
     * @returns: The database ID of the newly created recipient.
     */
    public com.dmdelivery.webservice.RecordResultType createSenderAddress(com.dmdelivery.webservice.DMdeliveryLoginType login, java.lang.String fromEmail) throws java.rmi.RemoteException;

    /**
     * Create a new campaign.
     * 		CAUTION: This function is disabled by default. Please contact Web
     * Power to enable it.
     * 		
     * @param login: DMdelivery login object.
     * 		
     * @param brandID: The ID of the brand to link the new campaign to. Set
     * to 0 to don't use a brand.
     * 		
     * @param name: The name of the new campaign.
     * 		
     * @param defaultSenderName: The default sender name of mailings sent
     * from this campaign.
     * 		
     * @param defaultSenderAddress: The ID of the default sender address
     * for this campaign.
     * 		
     * @param defaultReplyAddress: The ID of the default reply address for
     * this campaign. Set to 0 to use the sender address.
     * 		
     * @param langs: The languages for this campaign, as a comma separated
     * list (en,cn,nl).
     * 		
     * @param isOverall: Whether or not this is an overall campaign.
     * 		
     * @param conversionPoints: Comma-separated list of conversion points
     * to define.
     * 		
     * @param localDomain: What local domain to use. Use '' (empty string)
     * for default.
     * 		
     * @param excludeLists: What exclude lists to apply. Options: 'license
     * spamcomplaint', 'license hardbounce'. Provide a comma-separated list.
     * 		
     * @returns: The database ID of the newly created campaign.
     */
    public com.dmdelivery.webservice.RecordResultType createCampaign(com.dmdelivery.webservice.DMdeliveryLoginType login, int brandID, java.lang.String name, java.lang.String defaultSenderName, int defaultSenderAddress, int defaultReplyAddress, java.lang.String langs, boolean isOverall, java.lang.String conversionPoints, java.lang.String localDomain, java.lang.String excludeLists) throws java.rmi.RemoteException;

    /**
     * Copy the recipient fields definition from one (template) campaign
     * into another (empty) campaign.
     * 		The target campaign must not be overall, and may not contain any
     * recipients yet.
     * 		CAUTION: This function is disabled by default. Please contact Web
     * Power to enable it.
     * 		
     * @param login: DMdelivery login object.
     * 		
     * @param srcCampaignID: The ID of the source campaign, to copy field
     * definition from.
     * 		
     * @param dstCampaignID: The ID of the destination campaign, to copy
     * the field definition to.
     * 		
     * @returns: The database ID of the destination campaign.
     */
    public com.dmdelivery.webservice.RecordResultType copyFieldDefinition(com.dmdelivery.webservice.DMdeliveryLoginType login, int srcCampaignID, int dstCampaignID) throws java.rmi.RemoteException;
}
