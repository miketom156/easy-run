package com.job5156.model.perbehav;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>用户行为跟踪</p>
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
public class PerBehavTrack implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @Id
    private int perUserId;
    /**
     * 账号
     */
    private String account;
    /**
     * 访客id（首次访问）
     */
    private String uvId;
    /**
     * 访问方式，web，touch，app，wechat
     */
    private String accessType;
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
     * 账户来源
     */
    private String accountFrom;
    /**
     * 注册时间
     */
    private Date regTime;
    /**
     * 是否注册微名片
     */
    private Integer isRegMicroCard;
    /**
     * 是否注册简历
     */
    private Integer isRegResume;
    /**
     * 注册简历时间
     */
    private Date regResumeTime;
    /**
     * 简历是否完整
     */
    private Integer isResumeComplete;
    /**
     * 简历审核状态
     */
    private String resumePass;
    /**
     * 应聘职位数
     */
    private Integer applyCount;
    /**
     * 最后应聘时间
     */
    private Date lastApplyTime;
    /**
     * 搜索职位次数
     */
    private Integer searchPosCount;
    /**
     * 最后搜索时间
     */
    private Date lastSearchTime;
    /**
     * 简历刷新次数
     */
    private Integer refreshCount;
    /**
     * 最后刷新时间
     */
    private Date lastRefreshTime;
    /**
     * 登录次数
     */
    private Integer loginCount;
    /**
     * 最后登录时间
     */
    private Date lastLoginTime;
    /**
     * 收到邀请面试次数
     */
    private Integer comInterviewCount;
    /**
     * 性别
     */
    private String gender;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 学历
     */
    private String degree;
    /**
     * 工作经验
     */
    private String workYear;
    /**
     * 所在地-省
     */
    private String locationProv;
    /**
     * 所在地-市
     */
    private String locationCity;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 手机归属地
     */
    private String mobilePlace;
    /**
     * 期望职位1
     */
    private String expectJobCode1;
    /**
     * 期望职位2
     */
    private String expectJobCode2;
    /**
     * 期望职位3
     */
    private String expectJobCode3;
    /**
     * 期望薪资
     */
    private String expectSalary;
    /**
     * 用户ip
     */
    private String userIp;
    /**
     * ip-省
     */
    private String userIpProv;
    /**
     * ip-市
     */
    private String userIpCity;
    /**
     * 记录创建日期
     */
    private Date createTime;

    public PerBehavTrack() {
        setLoginCount(0);
        setRefreshCount(0);
        setApplyCount(0);
        setSearchPosCount(0);
        setComInterviewCount(0);
        setIsRegResume(0);
        setIsRegMicroCard(0);
        setCreateTime(new Date());
    }

    public String getUserIpProv() {
        return userIpProv;
    }

    public void setUserIpProv(String userIpProv) {
        this.userIpProv = userIpProv;
    }

    public String getUserIpCity() {
        return userIpCity;
    }

    public void setUserIpCity(String userIpCity) {
        this.userIpCity = userIpCity;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getPerUserId() {
        return perUserId;
    }

    public void setPerUserId(int perUserId) {
        this.perUserId = perUserId;
    }

    public String getUvId() {
        return uvId;
    }

    public void setUvId(String uvId) {
        this.uvId = uvId;
    }

    public String getAccessType() {
        return accessType;
    }

    public void setAccessType(String accessType) {
        this.accessType = accessType;
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

    public String getAccountFrom() {
        return accountFrom;
    }

    public void setAccountFrom(String accountFrom) {
        this.accountFrom = accountFrom;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public Integer getIsRegMicroCard() {
        return isRegMicroCard;
    }

    public void setIsRegMicroCard(Integer isRegMicroCard) {
        this.isRegMicroCard = isRegMicroCard;
    }

    public Integer getIsRegResume() {
        return isRegResume;
    }

    public void setIsRegResume(Integer isRegResume) {
        this.isRegResume = isRegResume;
    }

    public Date getRegResumeTime() {
        return regResumeTime;
    }

    public void setRegResumeTime(Date regResumeTime) {
        this.regResumeTime = regResumeTime;
    }

    public Integer getIsResumeComplete() {
        return isResumeComplete;
    }

    public void setIsResumeComplete(Integer isResumeComplete) {
        this.isResumeComplete = isResumeComplete;
    }

    public String getResumePass() {
        return resumePass;
    }

    public void setResumePass(String resumePass) {
        this.resumePass = resumePass;
    }

    public Integer getApplyCount() {
        return applyCount;
    }

    public void setApplyCount(Integer applyCount) {
        this.applyCount = applyCount;
    }

    public Date getLastApplyTime() {
        return lastApplyTime;
    }

    public void setLastApplyTime(Date lastApplyTime) {
        this.lastApplyTime = lastApplyTime;
    }

    public Integer getSearchPosCount() {
        return searchPosCount;
    }

    public void setSearchPosCount(Integer searchPosCount) {
        this.searchPosCount = searchPosCount;
    }

    public Date getLastSearchTime() {
        return lastSearchTime;
    }

    public void setLastSearchTime(Date lastSearchTime) {
        this.lastSearchTime = lastSearchTime;
    }

    public Integer getRefreshCount() {
        return refreshCount;
    }

    public void setRefreshCount(Integer refreshCount) {
        this.refreshCount = refreshCount;
    }

    public Date getLastRefreshTime() {
        return lastRefreshTime;
    }

    public void setLastRefreshTime(Date lastRefreshTime) {
        this.lastRefreshTime = lastRefreshTime;
    }

    public Integer getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Integer getComInterviewCount() {
        return comInterviewCount;
    }

    public void setComInterviewCount(Integer comInterviewCount) {
        this.comInterviewCount = comInterviewCount;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getWorkYear() {
        return workYear;
    }

    public void setWorkYear(String workYear) {
        this.workYear = workYear;
    }

    public String getLocationProv() {
        return locationProv;
    }

    public void setLocationProv(String locationProv) {
        this.locationProv = locationProv;
    }

    public String getLocationCity() {
        return locationCity;
    }

    public void setLocationCity(String locationCity) {
        this.locationCity = locationCity;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMobilePlace() {
        return mobilePlace;
    }

    public void setMobilePlace(String mobilePlace) {
        this.mobilePlace = mobilePlace;
    }

    public String getExpectJobCode1() {
        return expectJobCode1;
    }

    public void setExpectJobCode1(String expectJobCode1) {
        this.expectJobCode1 = expectJobCode1;
    }

    public String getExpectJobCode2() {
        return expectJobCode2;
    }

    public void setExpectJobCode2(String expectJobCode2) {
        this.expectJobCode2 = expectJobCode2;
    }

    public String getExpectJobCode3() {
        return expectJobCode3;
    }

    public void setExpectJobCode3(String expectJobCode3) {
        this.expectJobCode3 = expectJobCode3;
    }

    public String getExpectSalary() {
        return expectSalary;
    }

    public void setExpectSalary(String expectSalary) {
        this.expectSalary = expectSalary;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
