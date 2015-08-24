package com.job5156.vo.mail;

/**
 * 企业在过去两周收到简历数量小于2份,给销售顾问发邮件提醒
 * 
 * @author leo
 * 
 */
public class ComReceiveResNumRemindMailVo extends MailVo {

	@Override
	public String getSubject() {
		return "过去一周内企业收到简历数量过少提醒";
	}

	@Override
	public String getFromName() {
		return "智通人才网";
	}

	public ComReceiveResNumRemindMailVo(String content, String[] to, Integer emailType){
		this.setContent(content);
		this.setTo(to);
		this.setEmailType(emailType);
	}
}
