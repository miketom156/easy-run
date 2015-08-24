package com.job5156.vo.mail;

import java.util.Map;

/**
 * 智通才富专题订阅
 * 
 * @author Andy
 * 
 */
public class VisitorSubscribelVo extends MailVo {

	@Override
	public String getSubject() {
		return this.getReplacedStr("智通才富专题-{title}");
	}

	@Override
	public String getFromName() {
		return "智通人才网";
	}

	public VisitorSubscribelVo(String content, String[] to, Integer emailType, Map<String, Object> paramMap){
		this.setContent(content);
		this.setTo(to);
		this.setEmailType(emailType);
		this.setParamMap(paramMap);
	}
}
