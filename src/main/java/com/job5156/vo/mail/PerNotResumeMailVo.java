package com.job5156.vo.mail;

import java.util.Map;

/**
 * <p>
 * 个人用户没有填写简历
 * </p>
 * 
 * @author leeton
 * 
 */
public class PerNotResumeMailVo extends MailVo {

	@Override
	public String getSubject() {
		return this.getReplacedStr("智通人才网提醒您：好工作需要有简历！");
	}

	@Override
	public String getFromName() {
		return "智通人才网";
	}

	public PerNotResumeMailVo(String content, String[] to, Integer emailType, Map<String, Object> paramMap){
		this.setContent(content);
		this.setTo(to);
		this.setEmailType(emailType);
		this.setParamMap(paramMap);
	}

}
