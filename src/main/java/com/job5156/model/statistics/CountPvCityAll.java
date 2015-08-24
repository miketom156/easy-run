package com.job5156.model.statistics;

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
 * Created with IntelliJ IDEA.
 * User: djh
 * Date: 14-11-24
 * Time: 下午1:51
 * 城市综合统计 - 实体
 */
@Entity
@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate
public class CountPvCityAll implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    /**
     * ip总量
     */
    private Integer ip;
    /**
     * pv总量
     */
    private Integer pv;
    /**
     * 职位总数
     */
    private Integer positionCount;
    /**
     * 自有职位
     */
    private Integer selfPosition;
    /**
     * 个人注册
     */
    private Integer perReg;
    /**
     * 后台录入的个人注册量
     */
    private Integer perRegBySys;
    /**
     * 求职参与
     */
    private Integer resumeApply;
    /**
     * 个人修改
     */
    private Integer perEdit;
    /**
     * 个人开通
     */
    private Integer perValid;
    /**
     * 企业注册
     */
    private Integer comReg;
    /**
     * 个人发送简历
     */
    private Integer perToCom;
    /**
     * 企业查看简历
     */
    private Integer comViewResume;
    /**
     * 邀请面试次数
     */
    private Integer comToPer;
    /**
     * 邀请面试企业数
     */
    private Integer comCount;
    /**
     * 企业会员数量
     */
    private Integer comRightCount;
    /**
     * 发布职位数
     */
    private Integer posOut;
    /**
     * 真实发布职位数
     */
    private Integer posOutTrue;
    /**
     * 城市,为0时表示所有地区
     */
    private Integer cityId;
    /**
     * 统计日期
     */
    private Date creDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getComRightCount() {
        return comRightCount;
    }

    public void setComRightCount(Integer comRightCount) {
        this.comRightCount = comRightCount;
    }

    public Integer getIp() {
        return ip;
    }

    public void setIp(Integer ip) {
        this.ip = ip;
    }

    public Integer getPv() {
        return pv;
    }

    public void setPv(Integer pv) {
        this.pv = pv;
    }

    public Integer getPositionCount() {
        return positionCount;
    }

    public void setPositionCount(Integer positionCount) {
        this.positionCount = positionCount;
    }

    public Integer getSelfPosition() {
        return selfPosition;
    }

    public void setSelfPosition(Integer selfPosition) {
        this.selfPosition = selfPosition;
    }

    public Integer getPerReg() {
        return perReg;
    }

    public void setPerReg(Integer perReg) {
        this.perReg = perReg;
    }

    public Integer getResumeApply() {
        return resumeApply;
    }

    public void setResumeApply(Integer resumeApply) {
        this.resumeApply = resumeApply;
    }

    public Integer getPerEdit() {
        return perEdit;
    }

    public void setPerEdit(Integer perEdit) {
        this.perEdit = perEdit;
    }

    public Integer getPerValid() {
        return perValid;
    }

    public void setPerValid(Integer perValid) {
        this.perValid = perValid;
    }

    public Integer getComReg() {
        return comReg;
    }

    public void setComReg(Integer comReg) {
        this.comReg = comReg;
    }

    public Integer getPerToCom() {
        return perToCom;
    }

    public void setPerToCom(Integer perToCom) {
        this.perToCom = perToCom;
    }

    public Integer getComViewResume() {
        return comViewResume;
    }

    public void setComViewResume(Integer comViewResume) {
        this.comViewResume = comViewResume;
    }

    public Integer getComToPer() {
        return comToPer;
    }

    public void setComToPer(Integer comToPer) {
        this.comToPer = comToPer;
    }

    public Integer getComCount() {
        return comCount;
    }

    public void setComCount(Integer comCount) {
        this.comCount = comCount;
    }

    public Integer getPosOut() {
        return posOut;
    }

    public void setPosOut(Integer posOut) {
        this.posOut = posOut;
    }

    public Integer getPosOutTrue() {
        return posOutTrue;
    }

    public void setPosOutTrue(Integer posOutTrue) {
        this.posOutTrue = posOutTrue;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Date getCreDate() {
        return creDate;
    }

    public void setCreDate(Date creDate) {
        this.creDate = creDate;
    }

    public Integer getPerRegBySys() {
        return perRegBySys;
    }

    public void setPerRegBySys(Integer perRegBySys) {
        this.perRegBySys = perRegBySys;
    }
}
