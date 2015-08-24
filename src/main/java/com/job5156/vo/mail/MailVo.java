package com.job5156.vo.mail;

import java.io.File;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;

import com.job5156.common.Constants;

@SuppressWarnings("unused")
public abstract class MailVo {
	private String subject; 	// 邮件主题
	private String content; 	// 邮件内容
	private String fromName; 	// 来源名称
	private String[] to; 		// 目标地址

	private Map<String, Object> paramMap; 	// 替换参数MAP
	private MailAttachVo[] attachList; 		// 附件列表
	private Integer emailType = Constants.MAIL_TYPE_SIMPLIFIED; // 邮件类型，默认为简体

	public abstract String getSubject();

	public abstract String getFromName();

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setFromName(String fromName) {
		this.fromName = fromName;
	}

	public void setTo(String[] to) {
		this.to = to;
	}

	public void setEmailType(Integer emailType) {
		this.emailType = emailType;
	}

	public void setAttachList(MailAttachVo... attachList) {
		this.attachList = attachList;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String[] getTo() {
		return to;
	}

	public Integer getEmailType() {
		return emailType;
	}

	public MailAttachVo[] getAttachList() {
		return attachList;
	}

	public String getContent() {
		return content;
	}

	public Map<String, Object> getParamMap() {
		return paramMap;
	}

	public void setParamMap(Map<String, Object> paramMap) {
		this.paramMap = paramMap;
	}
	
	public String getReplacedStr(String content){
		if(MapUtils.isNotEmpty(paramMap)){
			for(Map.Entry<String, Object> entry : paramMap.entrySet()){
				content = StringUtils.replace(content, "{" + entry.getKey() + "}", ObjectUtils.toString(entry.getValue()));
			}
		}
		return content;
	}

	public static class MailAttachVo {
		// 附件名称
		private String attachName;
		// 文件对象
		private File file;

		public MailAttachVo(String attchName, File file) {
			this.attachName = attchName;
			this.file = file;
		}

		public String getAttachName() {
			return attachName;
		}

		public void setAttachName(String attachName) {
			this.attachName = attachName;
		}

		public File getFile() {
			return file;
		}

		public void setFile(File file) {
			this.file = file;
		}
	}
}
