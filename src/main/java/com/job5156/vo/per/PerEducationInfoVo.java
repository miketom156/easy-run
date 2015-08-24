package com.job5156.vo.per;

import java.util.Date;

import com.job5156.common.option.OptionMap;
import com.job5156.common.option.OptionMap.OptionType;

/**
 * 教育经历
 * 
 * @author leo
 * 
 */
public class PerEducationInfoVo {
	private Long id; // id编号
	private String begin; // 开始
	private String end; // 结束
	private String schoolName; // 学校名称
	private String speciality; // 专业名称
	private Date creDate; // 创建时间
	private Date updDate; // 修改时间
	private String specialityDescription; // 专业描述
	private Integer degree; // 学历

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

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
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

	public String getSpecialityDescription() {
		return specialityDescription;
	}

	public void setSpecialityDescription(String specialityDescription) {
		this.specialityDescription = specialityDescription;
	}

	public Integer getDegree() {
		return degree;
	}

	public void setDegree(Integer degree) {
		this.degree = degree;
	}

	// 学历对应文字
	public String getDegreeStr() {
		return OptionMap.getValue(OptionType.OPT_PER_DEGREE, degree);
	}
}
