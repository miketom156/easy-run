package com.job5156.vo.mail;

/**
 * 站点首页中链接失效邮件提醒
 * 
 * @author Andy
 * 
 */
public class CountSiteAdminCheckAppVo extends MailVo {

	@Override
	public String getSubject() {
		return "网站后台logo、职位及企业会员三天内即将过期提醒";
	}

	@Override
	public String getFromName() {
		return "智通人才网";
	}

	public CountSiteAdminCheckAppVo(String content, String[] to, Integer emailType){
		this.setContent(content);
		this.setTo(to);
		this.setEmailType(emailType);
	}
}
