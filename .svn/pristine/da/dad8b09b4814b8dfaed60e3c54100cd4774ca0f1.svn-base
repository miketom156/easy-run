package com.job5156.vo.mail;

import java.util.Map;

/**
 * <p>
 * 个人简历被查看邮件
 * </p>
 * 
 * @author leo
 * 
 */
public class ResumeViewedMailVo extends MailVo {

	@Override
	public String getSubject() {
		return this.getReplacedStr("{userName}，你的简历被{comNum}家企业查看了");
	}

	@Override
	public String getFromName() {
		return "智通人才网";
	}

	public ResumeViewedMailVo(String content, String[] to, Integer emailType, Map<String, Object> paramMap){
		this.setContent(content);
		this.setTo(to);
		this.setEmailType(emailType);
		this.setParamMap(paramMap);
	}
	
	
}
