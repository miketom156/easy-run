package com.job5156.vo.per;


import java.util.Date;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Years;
import org.springframework.beans.BeanUtils;

import com.job5156.common.option.OptionMap;
import com.job5156.common.option.OptionMap.OptionType;
import com.job5156.model.per.PerUser;

public class PerUserInfoVo {
	private Integer id;
	private Integer accountType;          //账号类型
	private String account;               //账号
	private Integer loginCount;           //登录次数
	private Date freDate;                 //刷新时间
	private Date createDate;              //创建时间
	private Date loginDate;               //登录时间
	private Integer publicSettings;       //公开状态：0-完全公开，1-完全保密，2-对智通公开
	private String filterComId;           //过滤的企业ID
	private Integer vipMember;            //是否为个人会员 默认为0 ，1为会员
	private Integer refreshRemind;        //刷新提醒：0表示超过15天没有更新就提示，1表示永不提示。
	private String userName;              //个人用户简历名称
	private Integer gender;               //性别：1为男，2为女
	private Date birthday;                //出生日期
	private Integer location;             //所在地省/市所对应的 编号
	private Integer locationTown;         //所在地城镇所对应的编号
	private String email;                 //电子邮箱
	private Integer cardType;             //证件类型
	private String cardNum;               //证件号码
	private Integer hometown;             //户口所在地 省/市所对应编码
	private Integer hometownTown;         //户口所在地 城镇对应的编码
	private String phone;                 //固定电话
	private String mobile;                //手机号码
	private String nation;                //民族
	private Integer marriage;             //婚姻状况所对应的编码
	private Integer stature;              //身高
	private Integer weight;               //体重
	private String zipcode;               //邮编
	private Integer mobileActivation;     //手机激活：0：未激活；1：已激活；
	private Integer identification;       //实名认证：0：未认证；1：已认证；
	private Integer mailActivation;       //邮件激活：0：未激活；1：已激活；
	private String address;               //详细地址
	private String homepage;              //个人主页
	private String qq;                    //QQ
	private Integer political;            //政治面貌
	private Integer jobyearType;          //工作年限类型
	private Integer jobState;             //求职状态类型
	private Integer nowSalary;            //目前薪水
	private String userNameEn;            //英文名称
	private String addressEn;             //英文地址
    private String nationEn;              //英文民族
	private String fileName;              //头像文件名称
	private String filePath;              //头像文件路径  
	private Integer resId;                //默认简历ID
	private Integer refreshDays;          //多少天没有刷新
	private Integer resRecommend;		  //简历推荐（0不同意，1同意）
	private Integer status;               //账户状态0=启用，1=禁用
	private PerResumeVo defaultPerResumeVo;      //默认简历vo
	
    public PerUserInfoVo() {
    	
    }

    public PerUserInfoVo(PerUser perUser) {
        if(perUser != null) {
        	ConvertUtils.register(new DateConverter(null), java.util.Date.class);
            BeanUtils.copyProperties(perUser, this);
            if(this.getFreDate() != null) {
                this.setRefreshDays(Days.daysBetween(new DateTime(this.getFreDate()), DateTime.now()).getDays());
            }
        }
    }

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAccountType() {
		return accountType;
	}

	public void setAccountType(Integer accountType) {
		this.accountType = accountType;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Integer getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
	}

	public Date getFreDate() {
		return freDate;
	}

	public void setFreDate(Date freDate) {
		this.freDate = freDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	public Integer getPublicSettings() {
		return publicSettings;
	}

	public void setPublicSettings(Integer publicSettings) {
		this.publicSettings = publicSettings;
	}

	public String getFilterComId() {
		return filterComId;
	}

	public void setFilterComId(String filterComId) {
		this.filterComId = filterComId;
	}

	public Integer getVipMember() {
		return vipMember;
	}

	public void setVipMember(Integer vipMember) {
		this.vipMember = vipMember;
	}

	public Integer getRefreshRemind() {
		return refreshRemind;
	}

	public void setRefreshRemind(Integer refreshRemind) {
		this.refreshRemind = refreshRemind;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Integer getLocation() {
		return location;
	}

	public void setLocation(Integer location) {
		this.location = location;
	}

	public Integer getLocationTown() {
		return locationTown;
	}

	public void setLocationTown(Integer locationTown) {
		this.locationTown = locationTown;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getCardType() {
		return cardType;
	}

	public void setCardType(Integer cardType) {
		this.cardType = cardType;
	}

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public Integer getHometown() {
		return hometown;
	}

	public void setHometown(Integer hometown) {
		this.hometown = hometown;
	}

	public Integer getHometownTown() {
		return hometownTown;
	}

	public void setHometownTown(Integer hometownTown) {
		this.hometownTown = hometownTown;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public Integer getMarriage() {
		return marriage;
	}

	public void setMarriage(Integer marriage) {
		this.marriage = marriage;
	}

	public Integer getStature() {
		return stature;
	}

	public void setStature(Integer stature) {
		this.stature = stature;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public Integer getMobileActivation() {
		return mobileActivation;
	}

	public void setMobileActivation(Integer mobileActivation) {
		this.mobileActivation = mobileActivation;
	}

	public Integer getIdentification() {
		return identification;
	}

	public void setIdentification(Integer identification) {
		this.identification = identification;
	}

	public Integer getMailActivation() {
		return mailActivation;
	}

	public void setMailActivation(Integer mailActivation) {
		this.mailActivation = mailActivation;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public Integer getPolitical() {
		return political;
	}

	public void setPolitical(Integer political) {
		this.political = political;
	}

	public Integer getJobyearType() {
		return jobyearType;
	}

	public void setJobyearType(Integer jobyearType) {
		this.jobyearType = jobyearType;
	}

	public Integer getJobState() {
		return jobState;
	}

	public void setJobState(Integer jobState) {
		this.jobState = jobState;
	}

	public Integer getNowSalary() {
		return nowSalary;
	}

	public void setNowSalary(Integer nowSalary) {
		this.nowSalary = nowSalary;
	}

	public String getUserNameEn() {
		return userNameEn;
	}

	public void setUserNameEn(String userNameEn) {
		this.userNameEn = userNameEn;
	}

	public String getAddressEn() {
		return addressEn;
	}

	public void setAddressEn(String addressEn) {
		this.addressEn = addressEn;
	}

    public String getNationEn() {
        return nationEn;
    }

    public void setNationEn(String nationEn) {
        this.nationEn = nationEn;
    }

    public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Integer getResId() {
		return resId;
	}

	public void setResId(Integer resId) {
		this.resId = resId;
	}

	public Integer getRefreshDays() {
		return refreshDays;
	}

	public void setRefreshDays(Integer refreshDays) {
		this.refreshDays = refreshDays;
	}

	public Integer getResRecommend() {
		return resRecommend;
	}

	public void setResRecommend(Integer resRecommend) {
		this.resRecommend = resRecommend;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public PerResumeVo getDefaultPerResumeVo() {
		return defaultPerResumeVo;
	}

	public void setDefaultPerResumeVo(PerResumeVo defaultPerResumeVo) {
		this.defaultPerResumeVo = defaultPerResumeVo;
	}

	//籍贯对应文字
	public String getHometownStr() {
		return OptionMap.getFullAddr(hometown);
	}
	
	//婚姻状况对应文字
	public String getMarriageStr() {
		return OptionMap.getValue(OptionType.OPT_PER_MARRIAGE, marriage);
	}
	
	//现所在地对应文字
	public String getLocationStr() {
		return OptionMap.getFullAddr(location);
	}
	
	//证件类型对应文字
	public String getCardTypeStr() {
		return OptionMap.getValue(OptionType.OPT_PER_CARDTYPE, cardType);
	}
	
	//获取年龄
	public String getAgeStr(){
		if (birthday != null) {
	        return String.valueOf(Years.yearsBetween(new DateTime(birthday), DateTime.now()).getYears());
	    }
		return "";
	}
	
	//获取性别
	public String getGanderStr(){
		return OptionMap.getValue(OptionType.OPT_GENDER, gender);
	}
	
	//获取工作经验
	public String getJobYear(){
		return OptionMap.getValue(OptionType.OPT_PER_WORKYEAR, jobyearType);
	}
}