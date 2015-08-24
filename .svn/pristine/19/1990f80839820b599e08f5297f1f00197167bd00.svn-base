package com.job5156.vo.per;

import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.job5156.common.option.OptionMap;
import com.job5156.common.option.OptionMap.OptionType;

public class PerWorkInfoVo {
	private Long id; // id编号
	private String begin; // 开始
	private String end; // 结束
	private String comName; // 公司名称
	private Integer comType; // 公司性质
	private Integer comCalling; // 公司行业
	private String jobName; // 职位名称（自定义）
	private Integer jobFunctionId; // 职位Id（已有类别）
	private String description; // 工作描述
	private String leftreason; // 离职愿意
	private String section; // 部门名称
	private Integer comScale; // 企业规模
	private Date creDate; // 创建时间
	private Date updDate; // 修改时间

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBegin() {
		return begin;
	}

	public void setBegin(String begin) {
		this.begin = begin;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}

	public Integer getComType() {
		return comType;
	}

	public void setComType(Integer comType) {
		this.comType = comType;
	}

	public Integer getComCalling() {
		return comCalling;
	}

	public void setComCalling(Integer comCalling) {
		this.comCalling = comCalling;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public Integer getJobFunctionId() {
		return jobFunctionId;
	}

	public void setJobFunctionId(Integer jobFunctionId) {
		this.jobFunctionId = jobFunctionId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLeftreason() {
		return leftreason;
	}

	public void setLeftreason(String leftreason) {
		this.leftreason = leftreason;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public Integer getComScale() {
		return comScale;
	}

	public void setComScale(Integer comScale) {
		this.comScale = comScale;
	}

	public Date getCreDate() {
		return creDate;
	}

	public void setCreDate(Date creDate) {
		this.creDate = creDate;
	}

	public Date getUpdDate() {
		return updDate;
	}

	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}

	// 企业性质对应文字
	public String getComTypeStr() {
		return OptionMap.getValue(OptionType.OPT_COM_PROPERTY, comType);
	}

	// 企业行业对应文字
	public String getComCallingStr() {
		return OptionMap.getValue(OptionType.OPT_INDUSTRY, comCalling);
	}

	// 职位名称
	public String getJobNameStr() {
		if (StringUtils.isNotBlank(jobName)) {
			return jobName;
		} else {
			return OptionMap.getValue(OptionType.OPT_POSITION, jobFunctionId);
		}
	}
}
