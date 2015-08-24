package com.job5156.model.com;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * 
 * @ClassName: ComDepartment
 * @Description: 公司部门实体类
 * @author xh
 * @date 2013-7-2 上午9:48:53
 * 
 */
@Entity
@DynamicUpdate
@DynamicInsert
public class ComDepartment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	private Integer comId; // 公司ID
	private Integer contactId; // 联系人ID
	private String deptName; // 部门名称
	private Integer sort; // 排序号
	private Integer type; // 类型，0=部门，1=分子公司
	private Integer delStatus; // 是否为删除状态，-1=已删除
	private Date createDate; // 创建日期
	private Date updateDate; // 修复日期

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getComId() {
		return comId;
	}

	public void setComId(Integer comId) {
		this.comId = comId;
	}

	public Integer getContactId() {
		return contactId;
	}

	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(Integer delStatus) {
		this.delStatus = delStatus;
	}
}
