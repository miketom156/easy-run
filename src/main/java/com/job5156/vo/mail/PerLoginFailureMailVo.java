package com.job5156.vo.mail;

import java.util.Map;

/**
 * 个人登录失败，提醒找回密码
 *
 * @author leeton
 * 
 */
public class PerLoginFailureMailVo extends MailVo {

	@Override
	public String getSubject() {
		return this.getReplacedStr("{userName}，您忘记密码了吗？");
	}

	@Override
	public String getFromName() {
		return "智通人才网";
	}

	public PerLoginFailureMailVo(String content, String[] to, Integer emailType, Map<String, Object> paramMap){
		this.setContent(content);
		this.setTo(to);
		this.setEmailType(emailType);
		this.setParamMap(paramMap);
	}

}
