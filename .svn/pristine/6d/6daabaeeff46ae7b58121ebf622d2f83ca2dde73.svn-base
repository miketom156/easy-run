package com.job5156.model.count;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by cy on 2014/11/20.
 */
@Entity
@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate
public class CountSiteIndexCheck implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2447153976561390848L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private Integer siteId; // 站点ID
	private String mainUrl; // 站点入口URL
	private String urlOrType; // 1、如果是前台统计URL是否失效的话，那么存取URL链接；２、如果是后台统计广告、企业、职位是否过期的话，有
								// 广告ID存广告id,如：模块名+广告id(comId或posId)
    private String infoName; // 职位名称或者公司名称
	private String mesage; // 链接地址请求时的错误信息，如：首页的广告位过期，广告企业过期，职位过期。
	private Date createDate; // 创建时间
	private int sysStatus; // 数据来源：1、首页；2、后台。

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSiteId() {
		return siteId;
	}

	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}

	public String getMainUrl() {
		return mainUrl;
	}

	public void setMainUrl(String mainUrl) {
		this.mainUrl = mainUrl;
	}

	public String getUrlOrType() {
		return urlOrType;
	}

	public void setUrlOrType(String urlOrType) {
		this.urlOrType = urlOrType;
	}

    public String getInfoName() {
        return infoName;
    }

    public void setInfoName(String infoName) {
        this.infoName = infoName;
    }

    public String getMesage() {
		return mesage;
	}

	public void setMesage(String mesage) {
		this.mesage = mesage;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getSysStatus() {
		return sysStatus;
	}

	public void setSysStatus(int sysStatus) {
		this.sysStatus = sysStatus;
	}
}
