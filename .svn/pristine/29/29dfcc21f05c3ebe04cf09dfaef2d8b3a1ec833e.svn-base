package com.job5156.vo.mail;

/**
 * <p>
 * 职位推荐邮件<br>
 * 针对用户投递简历不多的情况发送推荐邮件<br>
 * </p>
 * 
 * @author leeton
 * 
 */
public class PerLessApplyMailVo extends MailVo {

	@Override
	public String getSubject() {
		return "智通人才网提醒您：申请职位越多，面试机会越大！";
	}

	@Override
	public String getFromName() {
		return "智通人才网";
	}

	public PerLessApplyMailVo(String content, String[] to, Integer emailType){
		this.setContent(content);
		this.setTo(to);
		this.setEmailType(emailType);
	}
}
