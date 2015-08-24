package com.job5156.vo.mail;

/**
 * <p>
 * 职位推荐邮件<br>
 * 针对个人求职意向发送推荐邮件<br>
 * </p>
 * 
 * @author leo
 * 
 */
public class PosRecommendMailVo extends MailVo {
	
	@Override
	public String getSubject() {
		return "把合适的职位送给你！";
	}

	@Override
	public String getFromName() {
		return "智通人才网";
	}
	
	public PosRecommendMailVo(String content, String[] to, Integer emailType){
		this.setContent(content);
		this.setTo(to);
		this.setEmailType(emailType);
	}
}
