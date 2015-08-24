package com.job5156.vo.mail;


/**
 * <p>
 * 企业修改子账号基本信息邮件提醒
 * </p>
 * 
 * @author Andy
 * 
 */
public class ComUserModifySendMailVo extends MailVo {

	@Override
	public String getSubject() {
		return "贵司的账号信息修改成功－JOB5156.COM";
	}

	@Override
	public String getFromName() {
		return "智通人才网客服中心";
	}
	
	public ComUserModifySendMailVo(String content, String[] to, Integer emailType){
		this.setContent(content);
		this.setTo(to);
		this.setEmailType(emailType);
	}

}
