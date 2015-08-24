package com.job5156.vo.com;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.job5156.common.ZhiPinDataTransferComponent;
import com.job5156.common.CommonEnum.PositionStatus;
import com.job5156.common.option.OptionMap;
import com.job5156.model.per.PerUser;

/**
 * 
* @ClassName: ComPosition 
* @Description: 公司职位vo。
* @author zhaoman
* @date 2015-7-2 上午9:49:45 
*
 */
public class ComPositionVo  {
	
	private Integer id ;
	private Integer comId;                                  //公司关联ID
	private Integer departmentId;                           //部门关联ID
	private Integer comUserId;                              //发布职位公司账户ID
	private String posType;                                 //职位类别用json方式保存
	private Integer posTypeSys;                             //系统判定的职位类别
	private String posName;                                 //职位名称
	private Integer urgent;                                 //是否为急聘1=是
	private String posKeyword;                              //职位关键字用json方式保存 例如:["行政","销售","教育"]
	private Integer property;                               //工作性质，0=未选择，1=全职，2=兼职，3=实习
	private Integer recruitmentNumber;                      //招聘人数，0=若干
	private Date endDate;                                   //截止时间
	private String workLocation;                            //工作地区用json方式保存
	private Integer salary;                                 //薪资待遇-老版本数据
	private Integer maxSalary;                              //最高薪资待遇
	private Integer minSalary;                              //最低薪资待遇
	private Integer negotiableFlag;                         //是否显示为面议   '是否面议，0,Null=否，1=是'
	private String taoLabel;                                //淘标签多个以json array保存
	private Integer reqGender;                              //性别要求，0=未选择，1=男，2=女，3=不限
	private Integer reqDegree;                              //学历要求，0=未选择，
	private Integer reqAgeMin;                              //最小年龄,0=未选择
	private Integer reqAgeMax;                              //最大年龄，0=未选择
	private Integer reqWorkYear;                            //工作经验，0=未选择
	private Integer reqLocation;                            //现所在地，0=未选择
	private Integer reqLanguage;                            //语言要求，0=未选择
	private Integer reqLanguageLevel;                       //语言等级，0=未选择
	private Integer filterDegree;                           //学历是否必须符合要求，0=否，1=是
	private Integer filterRes;                              //是否开启简历过滤，0=否，1=是
	private Integer filterWorkYear;                         //工作经验是否必须符合要求，0=否，1=是
	private Integer filterGender;                           //性别是否必须符合要求，0=否，1=是
    private Integer filterAge;                              //年龄是否必须符合要求，0=否，1=是
	private String description;                             //职位描述
	private String interviewNote;                           //面试须知
	private Integer autoReply;                              //接收到简历后是否自动回复，0=否，1=是
	private Integer schoolFlag;                             //是否为校园职位，0=否，1=是
	private Date createDate;                                //创建日期
	private Date updateDate;                                //修改日期
	private Date refreshDate;                               //职位刷新时间
	private Integer posStatus;                              //职位标识，解释见 Constants
	private Integer auditorId;                              //审核人id
	private Date auditDate;                                 //审核日期
	private Integer delStatus;                              //是否已删除，-1=已删除
    private Integer resumeCountRecent;                     //最近一周收到的简历数
    private Integer acceptResumeType;                       // -1:所有(包含名片)  0:正式简历(默认,不包含名片) 1：仅长沙简历 2：仅名片,参见 CommonEnum.acceptResumeType

    /**
     * 企业名称
     */
    private String comName ;
    
    /**
     * 联系人
     */
    private String  contactPerson;
    
    /**
     * 电子邮件用json格式存储
     */
    private String  email;
    
    /**
     * 邮件格式0简体 1繁体
     */
    private Integer emailFormat;
    
    /**
     * 系统向企业推送简历，总得分
     */
    private Integer totalGrade;
    
    /**
     * 用户map，<简历匹配度,用户信息>
     */
    Map<PerUser, String> userMap;
  //========== 非POJO方法 ==========
    public String getPropertyStr(){
        String str = "";
        if(getProperty() != null) {
            str = OptionMap.getValue(OptionMap.OptionType.OPT_JOBTYPE, getProperty());
        }
        return StringUtils.isNotBlank(str) ? str : "全职";
    }

    public String getWorkLocationStr(){
        List<String> list = Lists.newArrayList();
        if(StringUtils.isNotBlank(getWorkLocation()) && !StringUtils.equals(getWorkLocation(), "[]")) {
            Gson gson = new Gson();
            List<Integer> workLocationList = gson.fromJson(getWorkLocation(), new TypeToken<List<Integer>>() {}.getType());
            if(CollectionUtils.isNotEmpty(workLocationList)) {
                for(Integer workLocation : workLocationList) {
                    String locStr = OptionMap.getFullAddr(workLocation);
                    if(!list.contains(locStr)){
                        list.add(locStr);
                    }
                }
            }
        }
        return StringUtils.join(list, " ");
    }

    public Integer getFirstCityCode() {
        int cityCode = 0;
        if(StringUtils.isNotBlank(getWorkLocation()) && !StringUtils.equals(getWorkLocation(), "[]")) {
            Gson gson = new Gson();
            List<Integer> workLocationList = gson.fromJson(getWorkLocation(), new TypeToken<List<Integer>>() {}.getType());
            if(CollectionUtils.isNotEmpty(workLocationList)) {
                cityCode = workLocationList.get(0);
            }
        }
        return  cityCode;
    }

    public String getPosTypeStr(){
        List<String> list = Lists.newArrayList();
        List<Integer> posTypeList = getPosTypeList();
        if(CollectionUtils.isNotEmpty(posTypeList)) {
            for(Integer posType : posTypeList) {
                String posStr = OptionMap.getValue(OptionMap.OptionType.OPT_POSITION, posType);
                if(!list.contains(posStr)){
                    list.add(posStr);
                }
            }
        }
        return StringUtils.join(list, " ");
    }

    public List<Integer> getPosTypeList(){
        if(StringUtils.isNotBlank(getPosType()) && !StringUtils.equals(getPosType(), "[]")) {
            Gson gson = new Gson();
            return gson.fromJson(getPosType(), new TypeToken<List<Integer>>() {}.getType());
        }
        return null;
    }

    public String getReqLanguageStr() {
        String str = "";
        if(getReqLanguage() != null && getReqLanguage() > 0 && getReqLanguageLevel() != null && getReqLanguageLevel() > 0){
            str = OptionMap.getValue(OptionMap.OptionType.OPT_LANGUAGE, getReqLanguage())
                    + " " + OptionMap.getValue(OptionMap.OptionType.OPT_LANGUAGE, getReqLanguageLevel());
        }
        return StringUtils.isNotBlank(str) ? str : "不限";
    }

    public String getTaoLabelStr() {
        if(getTaoLabel() != null) {
            Gson gson = new Gson();
            List<String> taoLabelList = gson.fromJson(getTaoLabel(), new TypeToken<List<String>>() {}.getType());
            return StringUtils.join(taoLabelList, " ");
        } else {
            return "";
        }
    }

    public String getReqLocationStr(){
        String str = "";
        if(getReqLocation() != null) {
            str = OptionMap.getFullAddr(getReqLocation());
        }
        return StringUtils.isNotBlank(str) ? str : "不限";
    }

    public String getReqDegreeStr() {
        String str = "";
        if(getReqDegree() != null) {
            str = OptionMap.getValue(OptionMap.OptionType.OPT_POS_DEGREE, getReqDegree());
        }

        return StringUtils.isNotBlank(str) ? str : "不限";
    }

    public String getReqWorkYearStr(){
        String str = "";
        if(getReqWorkYear() != null) {
            str = OptionMap.getValue(OptionMap.OptionType.OPT_COM_REQ_WORKYEAR, getReqWorkYear());
        }
        return StringUtils.isNotBlank(str) ? str : "不限";
    }

    public String getReqGenderStr(){
        String str = "";
        if(getReqGender() != null && getReqGender() > 0) {
            str = OptionMap.getValue(OptionMap.OptionType.OPT_GENDER, getReqGender());
        }
        return StringUtils.isNotBlank(str) ? str : "不限";
    }

    public String getReqAgeStr(){
        int minAge = NumberUtils.toInt(String.valueOf(getReqAgeMin()));
        int maxAge = NumberUtils.toInt(String.valueOf(getReqAgeMax()));
        if(minAge == 0 && maxAge == 0){
            return "不限";
        }else if(minAge == 0 || maxAge == 0){
            if(minAge == 0){
                return maxAge + "岁以下";
            }else{
                return minAge + "岁以上";
            }
        }else{
            return minAge + "~" + maxAge;
        }
    }

    public String getSalaryStr(){
        if(getMaxSalary() != null&&getMinSalary() != null) {
            return   getMinSalary()+"-"+getMaxSalary();
        }
        if(getMaxSalary() != null) {
            return   "0-"+getMaxSalary();
        }
        if(getMinSalary() != null) {
            return   getMinSalary()+"-99999";
        }
        return  "面议";
    }

    public String getPosStatusStr(){
        if(getPosStatus() != null){
            return PositionStatus.getDescriptByValue(getPosStatus());
        }
        return "";
    }

    public String getPosKeywordStr(){
        List<String> list = Lists.newArrayList();
        if(StringUtils.isNotBlank(getPosKeyword()) && !StringUtils.equals(getPosKeyword(), "[]")){
            Gson gson = new Gson();
            List<String> keywordList = gson.fromJson(getPosKeyword(), new TypeToken<List<String>>() {}.getType());
            if(CollectionUtils.isNotEmpty(keywordList)) {
                for(String keyword : keywordList) {
                    if(StringUtils.isNotBlank(keyword) && !list.contains(keyword)){
                        list.add(keyword);
                    }
                }
            }
        }
        return StringUtils.join(list, " ");
    }
    public Integer getMaxSalaryWithTrans() {
        if (getMaxSalary() == null || getMaxSalary().equals(0)) {//当最大薪资无任何数值时进行转换
            if (getSalary() == null || getSalary() <= 0) { //默认为0
                return 0;
            } else {
                Integer[] salaryArray = ZhiPinDataTransferComponent.salaryMap.get(getSalary());
                if (salaryArray != null) {
                    return salaryArray[1];
                } else {  //默认---异常数据
                    return 0;
                }
            }
        } else {
            return getMaxSalary();
        }
    }

    public Integer getMinSalaryWithTrans() {
        if (getMinSalary() == null || getMinSalary().equals(0)) {//当最小薪资无任何数值时进行转换
            if (getSalary() == null || getSalary() <= 0) { //默认为0
                return 0;
            } else {
                Integer[] salaryArray = ZhiPinDataTransferComponent.salaryMap.get(getSalary());
                if (salaryArray != null) {
                    return salaryArray[0];
                } else {  //默认---异常数据
                    return 0;
                }
            }
        } else {
            return getMaxSalary();
        }
    }
    // ====================== getter && setter  ==============================
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
	public Integer getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}
	public Integer getComUserId() {
		return comUserId;
	}
	public void setComUserId(Integer comUserId) {
		this.comUserId = comUserId;
	}
	public String getPosType() {
		return posType;
	}
	public void setPosType(String posType) {
		this.posType = posType;
	}
	public String getPosName() {
		return posName;
	}
	public void setPosName(String posName) {
		this.posName = posName;
	}
	public Integer getUrgent() {
		return urgent;
	}
	public void setUrgent(Integer urgent) {
		this.urgent = urgent;
	}
	public String getPosKeyword() {
		return posKeyword;
	}
	public void setPosKeyword(String posKeyword) {
		this.posKeyword = posKeyword;
	}
	public Integer getProperty() {
		return property;
	}
	public void setProperty(Integer property) {
		this.property = property;
	}
	public Integer getRecruitmentNumber() {
		return recruitmentNumber;
	}
	public void setRecruitmentNumber(Integer recruitmentNumber) {
		this.recruitmentNumber = recruitmentNumber;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getWorkLocation() {
		return workLocation;
	}
	public void setWorkLocation(String workLocation) {
		this.workLocation = workLocation;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public Integer getNegotiableFlag() {
		return negotiableFlag;
	}
	public void setNegotiableFlag(Integer negotiableFlag) {
		this.negotiableFlag = negotiableFlag;
	}
	public String getTaoLabel() {
		return taoLabel;
	}
	public void setTaoLabel(String taoLabel) {
		this.taoLabel = taoLabel;
	}
	public Integer getReqGender() {
		return reqGender;
	}
	public void setReqGender(Integer reqGender) {
		this.reqGender = reqGender;
	}
	public Integer getReqDegree() {
		return reqDegree;
	}
	public void setReqDegree(Integer reqDegree) {
		this.reqDegree = reqDegree;
	}
	public Integer getReqAgeMin() {
		return reqAgeMin;
	}
	public void setReqAgeMin(Integer reqAgeMin) {
		this.reqAgeMin = reqAgeMin;
	}
	public Integer getReqAgeMax() {
		return reqAgeMax;
	}
	public void setReqAgeMax(Integer reqAgeMax) {
		this.reqAgeMax = reqAgeMax;
	}
	public Integer getReqWorkYear() {
		return reqWorkYear;
	}
	public void setReqWorkYear(Integer reqWorkYear) {
		this.reqWorkYear = reqWorkYear;
	}
	public Integer getReqLocation() {
		return reqLocation;
	}
	public void setReqLocation(Integer reqLocation) {
		this.reqLocation = reqLocation;
	}
	public Integer getReqLanguage() {
		return reqLanguage;
	}
	public void setReqLanguage(Integer reqLanguage) {
		this.reqLanguage = reqLanguage;
	}
	public Integer getReqLanguageLevel() {
		return reqLanguageLevel;
	}
	public void setReqLanguageLevel(Integer reqLanguageLevel) {
		this.reqLanguageLevel = reqLanguageLevel;
	}
	public Integer getFilterDegree() {
		return filterDegree;
	}
	public void setFilterDegree(Integer filterDegree) {
		this.filterDegree = filterDegree;
	}
	public Integer getFilterAge() {
		return filterAge;
	}
	public void setFilterAge(Integer filterAge) {
		this.filterAge = filterAge;
	}
	public Integer getFilterWorkYear() {
		return filterWorkYear;
	}
	public void setFilterWorkYear(Integer filterWorkYear) {
		this.filterWorkYear = filterWorkYear;
	}
	public Integer getFilterGender() {
		return filterGender;
	}
	public void setFilterGender(Integer filterGender) {
		this.filterGender = filterGender;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getInterviewNote() {
		return interviewNote;
	}
	public void setInterviewNote(String interviewNote) {
		this.interviewNote = interviewNote;
	}
	public Integer getAutoReply() {
		return autoReply;
	}
	public void setAutoReply(Integer autoReply) {
		this.autoReply = autoReply;
	}
	public Integer getSchoolFlag() {
		return schoolFlag;
	}
	public void setSchoolFlag(Integer schoolFlag) {
		this.schoolFlag = schoolFlag;
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
	public Date getRefreshDate() {
		return refreshDate;
	}
	public void setRefreshDate(Date refreshDate) {
		this.refreshDate = refreshDate;
	}
	public Integer getPosStatus() {
		return posStatus;
	}
	public void setPosStatus(Integer posStatus) {
		this.posStatus = posStatus;
	}
	public Integer getAuditorId() {
		return auditorId;
	}
	public void setAuditorId(Integer auditorId) {
		this.auditorId = auditorId;
	}
	public Date getAuditDate() {
		return auditDate;
	}
	public void setAuditDate(Date auditDate) {
		this.auditDate = auditDate;
	}
	public Integer getDelStatus() {
		return delStatus;
	}
	public void setDelStatus(Integer delStatus) {
		this.delStatus = delStatus;
	}
    public Integer getAcceptResumeType() {
        return acceptResumeType;
    }
    public void setAcceptResumeType(Integer acceptResumeType) {
        this.acceptResumeType = acceptResumeType;
    }
    public Integer getMaxSalary() {
        return maxSalary;
    }
    public void setMaxSalary(Integer maxSalary) {
        this.maxSalary = maxSalary;
    }
    public Integer getMinSalary() {
        return minSalary;
    }
    public void setMinSalary(Integer minSalary) {
        this.minSalary = minSalary;
    }
    public Integer getFilterRes() {
        return filterRes;
    }
    public void setFilterRes(Integer filterRes) {
        this.filterRes = filterRes;
    }
    public Integer getPosTypeSys() {
        return posTypeSys;
    }
    public void setPosTypeSys(Integer posTypeSys) {
        this.posTypeSys = posTypeSys;
    }
    public Integer getResumeCountRecent() {
        return resumeCountRecent;
    }
    public void setResumeCountRecent(Integer resumeCountRecent) {
        this.resumeCountRecent = resumeCountRecent;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getEmailFormat() {
		return emailFormat;
	}
	public void setEmailFormat(Integer emailFormat) {
		this.emailFormat = emailFormat;
	}
	public Integer getTotalGrade() {
		return totalGrade;
	}
	public void setTotalGrade(Integer totalGrade) {
		this.totalGrade = totalGrade;
	}
	public Map<PerUser, String> getUserMap() {
		return userMap;
	}
	public void setUserMap(Map<PerUser, String> userMap) {
		this.userMap = userMap;
	}
    
	
}