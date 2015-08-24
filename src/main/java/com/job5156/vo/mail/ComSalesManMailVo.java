package com.job5156.vo.mail;

import java.util.Map;

/**
 * <p>
 * 企业职位到期给业务员邮件提醒
 * </p>
 * 
 * @author Andy
 * 
 */
public class ComSalesManMailVo extends MailVo {

	@Override
	public String getSubject() {
		return this.getReplacedStr("{salemanName}，企业职位到期提醒邮件");
	}

	@Override
	public String getFromName() {
		return "智通人才网";
	}
	
	public ComSalesManMailVo(String content, String[] to, Integer emailType, Map<String, Object> paramMap){
		this.setContent(content);
		this.setTo(to);
		this.setEmailType(emailType);
		this.setParamMap(paramMap);
	}

}
