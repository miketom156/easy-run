package com.job5156.vo.mail;

/**
 * <p>
 * 长期未登陆邮件
 * </p>
 * 
 * @author leo
 * 
 */
public class LongTermNoLoginMailVo extends MailVo {

	@Override
	public String getSubject() {
		return "一份“留守”简历的独白，主人你快回来吧！";
	}

	@Override
	public String getFromName() {
		return "智通人才网";
	}

	public LongTermNoLoginMailVo(String content, String[] to, Integer emailType){
		this.setContent(content);
		this.setTo(to);
		this.setEmailType(emailType);
	}
}
