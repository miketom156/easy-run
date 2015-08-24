package com.job5156.vo.mail;

import java.util.Map;

/**
 * <p>
 * 根据职位信息智能推荐简历信息
 * </p>
 * 
 * @author leo
 * 
 */
public class ResumeRecommendMailVo extends MailVo {

	@Override
	public String getSubject() {
		return this.getReplacedStr("智通人才网给您的 {posName} 职位推荐的个人简历");
	}

	@Override
	public String getFromName() {
		return "智通人才网";
	}

	public ResumeRecommendMailVo(String content, String[] to, Integer emailType, Map<String, Object> paramMap){
		this.setContent(content);
		this.setTo(to);
		this.setEmailType(emailType);
		this.setParamMap(paramMap);
	}
	
	
}
