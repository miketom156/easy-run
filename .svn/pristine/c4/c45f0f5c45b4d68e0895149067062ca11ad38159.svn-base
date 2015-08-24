package com.job5156.model.count;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-11-13
 * Time: 上午9:22
 * 站点、所在地p，ip量统计vo.
 */
@Entity
@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate
public class PVCountCitySite {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer ipCountCity;
    private Integer ipCountSite;
    private Integer pvCountCity;
    private Integer pvCountSite;
    private Integer siteId;
    private Date createDtae;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIpCountCity() {
        return ipCountCity;
    }

    public void setIpCountCity(Integer ipCountCity) {
        this.ipCountCity = ipCountCity;
    }

    public Integer getIpCountSite() {
        return ipCountSite;
    }

    public void setIpCountSite(Integer ipCountSite) {
        this.ipCountSite = ipCountSite;
    }

    public Integer getPvCountCity() {
        return pvCountCity;
    }

    public void setPvCountCity(Integer pvCountCity) {
        this.pvCountCity = pvCountCity;
    }

    public Integer getPvCountSite() {
        return pvCountSite;
    }

    public void setPvCountSite(Integer pvCountSite) {
        this.pvCountSite = pvCountSite;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public Date getCreateDtae() {
        return createDtae;
    }

    public void setCreateDtae(Date createDtae) {
        this.createDtae = createDtae;
    }
}
