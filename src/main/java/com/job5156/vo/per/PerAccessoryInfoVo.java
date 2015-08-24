package com.job5156.vo.per;

import java.util.Date;

public class PerAccessoryInfoVo {
	private Long id; // id编号
	private String uploadName; // 附件名称
	private String opusPath; // 作品路径
	private String description; // 附件描述
	private Date uploadDate; // 上传时间
	private String uploadPath; // 附件路径
	private String fileName; // 文件名称
	private Integer show; // 是否显示简历中：1为显示，0为不显示

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUploadName() {
		return uploadName;
	}

	public void setUploadName(String uploadName) {
		this.uploadName = uploadName;
	}

	public String getOpusPath() {
		return opusPath;
	}

	public void setOpusPath(String opusPath) {
		this.opusPath = opusPath;
	}

	public String getUploadPath() {
		return uploadPath;
	}

	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public Integer getShow() {
		return show;
	}

	public void setShow(Integer show) {
		this.show = show;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
