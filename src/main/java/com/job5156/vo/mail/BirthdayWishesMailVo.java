package com.job5156.vo.mail;

import java.util.Map;

/**
 * <p>
 * 生日祝福邮件
 * </p>
 * 
 * @author leo
 * 
 */
public class BirthdayWishesMailVo extends MailVo {

	@Override
	public String getSubject() {
		return this.getReplacedStr("{userName}，生日快乐，Happy每一天！");
	}

	@Override
	public String getFromName() {
		return "智通人才网";
	}
	
	public BirthdayWishesMailVo(String content, String[] to, Integer emailType, Map<String, Object> paramMap){
		this.setContent(content);
		this.setTo(to);
		this.setEmailType(emailType);
		this.setParamMap(paramMap);
	}

}
