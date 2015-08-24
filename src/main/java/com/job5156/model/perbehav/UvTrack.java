package com.job5156.model.perbehav;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>访客行为跟踪</p>
 * <p/>
 * Date:2015/4/4 10:19
 *
 * @author pzm
 * @version 1.0
 */
@Entity
@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate
public class UvTrack implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 访客id
     */
    @Id
    private String uvId;
    /**
     * 首次访问时间
     */
    private Date firstAccessTime;
    /**
     * 最后一次访问时间
     */
    private Date lastAccessTime;
    /**
     * 访问方式，web，touch，app，wechat
     */
    private String accessType;
    /**
     * 来访次数
     */
    private Integer accessCount;
    /**
     * 来源渠道，这里实用推广栏目编号
     */
    private String spreadTn;
    /**
     * 推广栏目名字
     */
    private String spreadName;
    /**
     * sem推广栏目
     */
    private String semSpreadTn;
    /**
     * sem推广栏目名字
     */
    private String semSpreadName;
    /**
     * 访问来源 0-搜索引擎，1-外部链接，2-自主访问
     */
    private Integer fromSourceType;
    /**
     * 来源域名
     */
    private String fromSourceDomain;
    /**
     * 来源地址
     */
    private String fromSourceAddr;
    /**
     * 注册用户id
     */
    private Integer regPid;
    /**
     * 最近登录使用的用户id
     */
    private Integer lastLoginPid;
    /**
     * 记录创建日期
     */
    private Date createTime;
    /**
     * 访客ip
     */
    private String ip;
    /**
     * ip-省
     */
    private String ipProv;
    /**
     * ip-市
     */
    private String ipCity;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getIpProv() {
        return ipProv;
    }

    public void setIpProv(String ipProv) {
        this.ipProv = ipProv;
    }

    public String getIpCity() {
        return ipCity;
    }

    public void setIpCity(String ipCity) {
        this.ipCity = ipCity;
    }

    public String getUvId() {
        return uvId;
    }

    public void setUvId(String uvId) {
        this.uvId = uvId;
    }

    public Date getFirstAccessTime() {
        return firstAccessTime;
    }

    public void setFirstAccessTime(Date firstAccessTime) {
        this.firstAccessTime = firstAccessTime;
    }

    public Date getLastAccessTime() {
        return lastAccessTime;
    }

    public void setLastAccessTime(Date lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    public String getAccessType() {
        return accessType;
    }

    public void setAccessType(String accessType) {
        this.accessType = accessType;
    }

    public Integer getAccessCount() {
        return accessCount;
    }

    public void setAccessCount(Integer accessCount) {
        this.accessCount = accessCount;
    }

    public String getSpreadTn() {
        return spreadTn;
    }

    public void setSpreadTn(String spreadTn) {
        this.spreadTn = spreadTn;
    }

    public String getSpreadName() {
        return spreadName;
    }

    public void setSpreadName(String spreadName) {
        this.spreadName = spreadName;
    }

    public String getSemSpreadTn() {
        return semSpreadTn;
    }

    public void setSemSpreadTn(String semSpreadTn) {
        this.semSpreadTn = semSpreadTn;
    }

    public String getSemSpreadName() {
        return semSpreadName;
    }

    public void setSemSpreadName(String semSpreadName) {
        this.semSpreadName = semSpreadName;
    }

    public Integer getFromSourceType() {
        return fromSourceType;
    }

    public void setFromSourceType(Integer fromSourceType) {
        this.fromSourceType = fromSourceType;
    }

    public String getFromSourceDomain() {
        return fromSourceDomain;
    }

    public void setFromSourceDomain(String fromSourceDomain) {
        this.fromSourceDomain = fromSourceDomain;
    }

    public String getFromSourceAddr() {
        return fromSourceAddr;
    }

    public void setFromSourceAddr(String fromSourceAddr) {
        this.fromSourceAddr = fromSourceAddr;
    }

    public Integer getRegPid() {
        return regPid;
    }

    public void setRegPid(Integer regPid) {
        this.regPid = regPid;
    }

    public Integer getLastLoginPid() {
        return lastLoginPid;
    }

    public void setLastLoginPid(Integer lastLoginPid) {
        this.lastLoginPid = lastLoginPid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
