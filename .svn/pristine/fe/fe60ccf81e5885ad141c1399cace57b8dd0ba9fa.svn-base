package com.job5156.model.temp;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

@Entity
@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate
public class ComInfoCellect implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;            //主键ID
	private String comId;          //企业ID
	private String comName;        //企业名称
	private String contactPerson;  //联系人
	private String contactPhone;   //联系电话
	private String email;          //邮箱
	private Integer status;        //状态，0=默认，1=新增，-1=过期
	private Integer inMyDatabase;  //是否存在于智通数据库中,0=否，1=是
	private Date createDate;       //创建时间
	private Date updateDate;       //修改日期
	private Integer comType;       //企业类型
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getComId() {
		return comId;
	}
	public void setComId(String comId) {
		this.comId = comId;
	}
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	public String getContactPerson() {
		return contactPerson;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	public String getContactPhone() {
		return contactPhone;
	}
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getInMyDatabase() {
		return inMyDatabase;
	}
	public void setInMyDatabase(Integer inMyDatabase) {
		this.inMyDatabase = inMyDatabase;
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
	public Integer getComType() {
		return comType;
	}
	public void setComType(Integer comType) {
		this.comType = comType;
	}

}
