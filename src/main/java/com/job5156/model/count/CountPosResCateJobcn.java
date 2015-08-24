package com.job5156.model.count;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

/**
 * Created by Andy on 2014/10/24. 卓博职位与简历统计实体
 */
@Entity
@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate
public class CountPosResCateJobcn implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private Integer workLocation; // 工作地区
	private Integer jobcnPosType; // 卓博职位类别（小类别）
	private String posName; // 卓博职位名称，到时可以与网站作对应关系
	private Integer posType;// 网站的职位类别
	private Integer reqDegree; // 学历要求，0=不限；10=初中；20=高中；30=中专；40=大专；50=本科；60=硕士；70=博士
	private Integer addPosCount; // 职位增量统计数量
	private Integer savePosCount; // 职位存量统计数量
	private Integer addResCount; // 简历增量统计数量
	private Integer saveResCount; // 简历存量统计数量
	private Date createDate; // 每次统计时间
	private Integer dataSource;// 数据来源: 0=卓博

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getWorkLocation() {
		return workLocation;
	}

	public void setWorkLocation(Integer workLocation) {
		this.workLocation = workLocation;
	}

	public Integer getJobcnPosType() {
		return jobcnPosType;
	}

	public void setJobcnPosType(Integer jobcnPosType) {
		this.jobcnPosType = jobcnPosType;
	}

	public String getPosName() {
		return posName;
	}

	public void setPosName(String posName) {
		this.posName = posName;
	}

	public Integer getPosType() {
		return posType;
	}

	public void setPosType(Integer posType) {
		this.posType = posType;
	}

	public Integer getReqDegree() {
		return reqDegree;
	}

	public void setReqDegree(Integer reqDegree) {
		this.reqDegree = reqDegree;
	}

	public Integer getAddPosCount() {
		return addPosCount;
	}

	public void setAddPosCount(Integer addPosCount) {
		this.addPosCount = addPosCount;
	}

	public Integer getSavePosCount() {
		return savePosCount;
	}

	public void setSavePosCount(Integer savePosCount) {
		this.savePosCount = savePosCount;
	}

	public Integer getAddResCount() {
		return addResCount;
	}

	public void setAddResCount(Integer addResCount) {
		this.addResCount = addResCount;
	}

	public Integer getSaveResCount() {
		return saveResCount;
	}

	public void setSaveResCount(Integer saveResCount) {
		this.saveResCount = saveResCount;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getDataSource() {
		return dataSource;
	}

	public void setDataSource(Integer dataSource) {
		this.dataSource = dataSource;
	}

}
