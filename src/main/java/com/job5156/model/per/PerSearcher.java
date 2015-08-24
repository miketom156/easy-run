package com.job5156.model.per;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.SelectBeforeUpdate;

/**
 * 职位搜索器
 * 
 * @author leo
 * 
 */
@Entity
@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate
public class PerSearcher implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id; // 记录ID
	private Integer perUserId; // 对应个人用户表的ID
	private String name; // 搜索器命名，对于同一个求职来说此字段不能重复
	private Integer subscribe; // 是否订阅的标识，1=订阅，0=不订阅
	private String content; // JSON格式的搜索器条件内容
	private String email; // 订阅到的Email地址，可空，只有当subscribe=1的时候才有用
	private String url; // 搜索地址
	private Integer sendPeriod; // 发送周期（天）
	private Date createDate;
	private Date updateDate;

	private PerUser perUser; // 个人用户

	@NotFound(action = NotFoundAction.IGNORE)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "perUserId", insertable = false, updatable = false)
	public PerUser getPerUser() {
		return perUser;
	}

	public void setPerUser(PerUser perUser) {
		this.perUser = perUser;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPerUserId() {
		return perUserId;
	}

	public void setPerUserId(Integer perUserId) {
		this.perUserId = perUserId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSubscribe() {
		return subscribe;
	}

	public void setSubscribe(Integer subscribe) {
		this.subscribe = subscribe;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getSendPeriod() {
		return sendPeriod;
	}

	public void setSendPeriod(Integer sendPeriod) {
		this.sendPeriod = sendPeriod;
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
}
