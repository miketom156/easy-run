package com.job5156.vo.per;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

import com.google.common.collect.Lists;
import com.job5156.common.option.OptionMap;
import com.job5156.common.option.OptionMap.OptionType;

/**
 * 个人求职意向
 * 
 * @author leo
 * 
 */
public class PerIntentVo {
	private Long id; 				// id编号
	private Date creDate; 			// 创建时间
	private Date updDate; 			// 修改时间
	private Integer jobType; 		// 工作类型
	private String keywords; 		// 关键字
	private String treatment; 		// 待遇
	private Integer salary; 		// 期望薪水
	private Boolean negotiable; 	// 可面议
	private String otherMandate; 	// 其他要求
	private String jobCode; 		// 期望工作职位
	private String jobName; 		// 自定义职位
	private String jobLocation; 	// 期望工作地点
	private Integer checkindate; 	// 到岗时间
	private String professionSkill;	// 职业技能

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Integer getJobType() {
		return jobType;
	}

	public void setJobType(Integer jobType) {
		this.jobType = jobType;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getTreatment() {
		return treatment;
	}

	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Boolean getNegotiable() {
		return negotiable;
	}

	public void setNegotiable(Boolean negotiable) {
		this.negotiable = negotiable;
	}

	public String getOtherMandate() {
		return otherMandate;
	}

	public void setOtherMandate(String otherMandate) {
		this.otherMandate = otherMandate;
	}

	public String getJobCode() {
		return jobCode;
	}

	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobLocation() {
		return jobLocation;
	}

	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}

	public Integer getCheckindate() {
		return checkindate;
	}

	public void setCheckindate(Integer checkindate) {
		this.checkindate = checkindate;
	}

	public String getProfessionSkill() {
		return professionSkill;
	}

	public void setProfessionSkill(String professionSkill) {
		this.professionSkill = professionSkill;
	}

	// 到岗时间对应文字
	public String getCheckindateStr() {
		return OptionMap.getValue(OptionType.OPT_PER_ARRIVAL, checkindate);
	}

	// 期望岗位对应文字
	public String getJobNameStr() {
		List<String> jobNameList = Lists.newArrayList();

		if (StringUtils.isNotBlank(jobCode)) {
			if (StringUtils.isNotBlank(jobCode)) {
				for (String code : jobCode.split(",")) {
					String jobCodeStr = OptionMap.getValue(OptionMap.OptionType.OPT_POSITION, NumberUtils.toInt(code, 0));
					if (!jobNameList.contains(jobCodeStr)) {
						jobNameList.add(jobCodeStr);
					}
				}
			}
			if (StringUtils.isNotBlank(jobName)) {
				for (String jobCodeStr : jobName.split(",")) {
					if (!jobNameList.contains(jobCodeStr)) {
						jobNameList.add(jobCodeStr);
					}
				}
			}
		}

		return StringUtils.join(jobNameList, " ");
	}
	
    //期望职位类型对应文字
    public String getJobCodeStr() {
        List<String> jobNameList = Lists.newArrayList();
        if(StringUtils.isNotBlank(jobCode)) {
            for (String code : jobCode.split(",| ")) {
                String jobCodeStr = OptionMap.getValue(OptionMap.OptionType.OPT_POSITION, NumberUtils.toInt(code, 0));
                if(!jobNameList.contains(jobCodeStr)) {
                    jobNameList.add(jobCodeStr);
                }
            }
        }
        return StringUtils.join(jobNameList, ",");
    }

	// 待遇对应文字
	public String getSalaryStr() {
		if (salary == null || salary == 0) {
			return "面议";
		} else {
			return OptionMap.getValue(OptionType.OPT_PER_NOWSALARY, salary);
		}
	}

	// 希望地区对应文字
	public String getJobLocationStr() {
		List<String> jobLocationList = Lists.newArrayList();

		if (StringUtils.isNotBlank(jobLocation)) {
			for (String location : jobLocation.split(",")) {
				String locationStr = OptionMap.getCityAddr(NumberUtils.toInt(location, 0));
				if (!jobLocationList.contains(locationStr)) {
					jobLocationList.add(locationStr);
				}
			}
		}
		return StringUtils.join(jobLocationList, " ");
	}
}
