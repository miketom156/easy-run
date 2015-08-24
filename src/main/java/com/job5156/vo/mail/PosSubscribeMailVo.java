package com.job5156.vo.mail;

import java.util.Map;

/**
 * <p>
 * 职位推荐邮件<br>
 * 针对职位订阅发送推荐邮件<br>
 * </p>
 * 
 * @author leo
 * 
 */
public class PosSubscribeMailVo extends MailVo {

	@Override
	public String getSubject() {
		return this.getReplacedStr("{userName}，您订阅的职位已安全抵达你家，请您查阅！");
	}

	@Override
	public String getFromName() {
		return "智通人才网";
	}

	public PosSubscribeMailVo(String content, String[] to, Integer emailType, Map<String, Object> paramMap){
		this.setContent(content);
		this.setTo(to);
		this.setEmailType(emailType);
		this.setParamMap(paramMap);
	}
}
