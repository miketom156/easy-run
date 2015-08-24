package com.job5156.vo.mail;

import java.util.Map;

/**
 * <p>
 * 企业职位到期提醒
 * </p>
 * 
 * @author Andy
 * 
 */
public class ComPosExpireMailVo extends MailVo {

	@Override
	public String getSubject() {
		return this.getReplacedStr("{comName}，企业职位到期提醒邮件");
	}

	@Override
	public String getFromName() {
		return "智通人才网";
	}
	
	public ComPosExpireMailVo(String content, String[] to, Integer emailType, Map<String, Object> paramMap){
		this.setContent(content);
		this.setTo(to);
		this.setEmailType(emailType);
		this.setParamMap(paramMap);
	}

}
