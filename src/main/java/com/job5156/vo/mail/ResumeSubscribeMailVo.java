package com.job5156.vo.mail;

/**
 * <p>
 * 简历订阅邮件
 * </p>
 * 
 * @author leo
 * 
 */
public class ResumeSubscribeMailVo extends MailVo {

	@Override
	public String getSubject() {
		return "您订阅的简历已安全抵达你家，请您查阅！";
	}

	@Override
	public String getFromName() {
		return "智通人才网";
	}
	
	public ResumeSubscribeMailVo(String content, String[] to, Integer emailType){
		this.setContent(content);
		this.setTo(to);
		this.setEmailType(emailType);
	}

}
