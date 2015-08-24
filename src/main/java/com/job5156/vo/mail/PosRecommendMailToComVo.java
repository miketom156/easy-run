package com.job5156.vo.mail;

/**
 * <p>
 * 职位推荐邮件<br>
 * 智能推送简历到企业邮箱<br>
 * </p>
 * 
 * @author zhaoman
 * 
 */
public class PosRecommendMailToComVo extends MailVo {
	
	@Override
	public String getSubject() {
		return "符合您要求的简历！";
	}

	@Override
	public String getFromName() {
		return "智通人才网";
	}
	
	public PosRecommendMailToComVo(String content, String[] to, Integer emailType){
		this.setContent(content);
		this.setTo(to);
		this.setEmailType(emailType);
	}
}
