package com.job5156.model.logs;

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
public class LogComReceiveResNum implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;				// 主键ID
	private Integer comId;			// 企业ID
	private Integer posId;			// 职位ID
	private Integer salerId;		// 业务员ID
	private String comName;			// 企业名称
	private String posName;			// 职位名称
	private String salerName;		// 业务员姓名
	private String email;			// 业务员内部邮箱
	private Integer receiveNum;		// 收到简历数量
	private Date createDate;		// 创建日期

    private transient boolean notfindManageEmail;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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

	public Integer getPosId() {
		return posId;
	}

	public void setPosId(Integer posId) {
		this.posId = posId;
	}

	public Integer getSalerId() {
		return salerId;
	}

	public void setSalerId(Integer salerId) {
		this.salerId = salerId;
	}

	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}

	public String getPosName() {
		return posName;
	}

	public void setPosName(String posName) {
		this.posName = posName;
	}

	public String getSalerName() {
		return salerName;
	}

	public void setSalerName(String salerName) {
		this.salerName = salerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getReceiveNum() {
		return receiveNum;
	}

	public void setReceiveNum(Integer receiveNum) {
		this.receiveNum = receiveNum;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

    public boolean isNotfindManageEmail() {
        return notfindManageEmail;
    }

    public void setNotfindManageEmail(boolean notfindManageEmail) {
        this.notfindManageEmail = notfindManageEmail;
    }
}
