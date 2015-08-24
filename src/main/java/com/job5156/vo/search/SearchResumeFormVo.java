package com.job5156.vo.search;


import java.util.List;

/**
 * 简历搜索VO
 * @author leo
 *
 */
public class SearchResumeFormVo {

    private String keyword;                     //关键字
    private Integer keywordAnd; 				//关键字之间的关系，如果此值为1，则关键词之间是And的关系，否则为or
    private List<Integer> posTypeList;           	//希望工作岗位类别（最多三个）
    private List<Integer> locationList;       		//现所居住地区(省市区)（最多三个）
    private List<Integer> hometownList;				//户口所在地(省市)（最多三个）
    private List<Integer> workareaList;				//意向工作地区(省市区)（最多三个）
    private String locationAddr;           			//现所在地详细区镇
    private Integer workyearFrom;                   //工作经验要求上限（如：3年 - 5年， 3年为上限）
    private Integer workyearTo;                    	//工作经验要求下限（如：3年 - 5年， 5年为下限）
    private Boolean workyearUnlimit;               	//不限工作经验
    private Integer degreeFrom;                     //学历要求上限（如：专科 - 硕士， 专科为上限）
    private Integer degreeTo;                       //学历要求下限（如：专科 - 硕士， 硕士为下限）
    private Boolean degreeUnlimit;                 	//不限学历
    private Integer ageFrom;                        //年纪上限（如：19860101 -  19821231， 19860101为上限）
    private Integer ageTo;                          //年纪下限（如：19860101 -  19821231， 19821231为下限）
    private Integer gender;                        	//性别要求(1:男  2：女  0：不限)
    private Integer updateIn;                      	//(freshDate)简历更新日期，按天算，如3个月算90天，取值90
    public Boolean beforeUpdateIn;                 	//简历更新时间点之外
    private Integer salaryFrom;                    	//期望月薪上限（如：3000 - 5000， 3000为上限）
    private Integer salaryTo;                  		//期望月薪下限（如：3000 - 5000， 5000为下限）
    private List<String> languageLevel;				//外语水平[1000-1,1001-2]
    private Integer heightFrom;                     //身高上限（如：165 - 185， 165为上限）
    private Integer heightTo;                       //身高上限（如：165 - 185， 185为下限）
    private Integer latestJob;                      //最近工作岗位
    private Integer latestIndustry;                 //最近工作行业
    private String comName;                        	//工作的公司名/曾就职的单位
    private Boolean comRecent;      				//是否只搜最近工作过的公司名
    private String school;                         	//毕业学校
    private String speciality;                      //所学专业
    private Boolean photoExist;                     //是否有照片要求(1：必须有照片 0：不作要求)
    private Boolean resumeEnExist;                  //该求职者必须要有英文简历 (1:需要有  0：不作要求)

    //精确搜索
    private Integer perUserId;                  //求职者编号
    private String perName;                     //求职者姓名

    private Integer sortBy;                     //排序（0：按相关度  1：按更新日期  2：按年龄   3：按学历）
    private Integer pageNo; 					//页码
    private Integer pageSize; 					//每页显示数量 
    private Integer searchType;                 //搜索类型(1：简单，2：高级 3：个人ID，4：个人姓名）
    private Integer prodId;                   	//现场招聘会对应的prodId

    private List<Integer> resumeIdList; 		//限定在哪些简历中进行搜索

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Integer getKeywordAnd() {
		return keywordAnd;
	}

	public void setKeywordAnd(Integer keywordAnd) {
		this.keywordAnd = keywordAnd;
	}

	public List<Integer> getPosTypeList() {
		return posTypeList;
	}

	public void setPosTypeList(List<Integer> posTypeList) {
		this.posTypeList = posTypeList;
	}

	public List<Integer> getLocationList() {
		return locationList;
	}

	public void setLocationList(List<Integer> locationList) {
		this.locationList = locationList;
	}

	public List<Integer> getHometownList() {
		return hometownList;
	}

	public void setHometownList(List<Integer> hometownList) {
		this.hometownList = hometownList;
	}

	public List<Integer> getWorkareaList() {
		return workareaList;
	}

	public void setWorkareaList(List<Integer> workareaList) {
		this.workareaList = workareaList;
	}

	public String getLocationAddr() {
		return locationAddr;
	}

	public void setLocationAddr(String locationAddr) {
		this.locationAddr = locationAddr;
	}

	public Integer getWorkyearFrom() {
		return workyearFrom;
	}

	public void setWorkyearFrom(Integer workyearFrom) {
		this.workyearFrom = workyearFrom;
	}

	public Integer getWorkyearTo() {
		return workyearTo;
	}

	public void setWorkyearTo(Integer workyearTo) {
		this.workyearTo = workyearTo;
	}

	public Boolean getWorkyearUnlimit() {
		return workyearUnlimit;
	}

	public void setWorkyearUnlimit(Boolean workyearUnlimit) {
		this.workyearUnlimit = workyearUnlimit;
	}

	public Integer getDegreeFrom() {
		return degreeFrom;
	}

	public void setDegreeFrom(Integer degreeFrom) {
		this.degreeFrom = degreeFrom;
	}

	public Integer getDegreeTo() {
		return degreeTo;
	}

	public void setDegreeTo(Integer degreeTo) {
		this.degreeTo = degreeTo;
	}

	public Boolean getDegreeUnlimit() {
		return degreeUnlimit;
	}

	public void setDegreeUnlimit(Boolean degreeUnlimit) {
		this.degreeUnlimit = degreeUnlimit;
	}

	public Integer getAgeFrom() {
		return ageFrom;
	}

	public void setAgeFrom(Integer ageFrom) {
		this.ageFrom = ageFrom;
	}

	public Integer getAgeTo() {
		return ageTo;
	}

	public void setAgeTo(Integer ageTo) {
		this.ageTo = ageTo;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Integer getUpdateIn() {
		return updateIn;
	}

	public void setUpdateIn(Integer updateIn) {
		this.updateIn = updateIn;
	}

	public Boolean getBeforeUpdateIn() {
		return beforeUpdateIn;
	}

	public void setBeforeUpdateIn(Boolean beforeUpdateIn) {
		this.beforeUpdateIn = beforeUpdateIn;
	}

	public Integer getSalaryFrom() {
		return salaryFrom;
	}

	public void setSalaryFrom(Integer salaryFrom) {
		this.salaryFrom = salaryFrom;
	}

	public Integer getSalaryTo() {
		return salaryTo;
	}

	public void setSalaryTo(Integer salaryTo) {
		this.salaryTo = salaryTo;
	}

	public List<String> getLanguageLevel() {
		return languageLevel;
	}

	public void setLanguageLevel(List<String> languageLevel) {
		this.languageLevel = languageLevel;
	}

	public Integer getHeightFrom() {
		return heightFrom;
	}

	public void setHeightFrom(Integer heightFrom) {
		this.heightFrom = heightFrom;
	}

	public Integer getHeightTo() {
		return heightTo;
	}

	public void setHeightTo(Integer heightTo) {
		this.heightTo = heightTo;
	}

	public Integer getLatestJob() {
		return latestJob;
	}

	public void setLatestJob(Integer latestJob) {
		this.latestJob = latestJob;
	}

	public Integer getLatestIndustry() {
		return latestIndustry;
	}

	public void setLatestIndustry(Integer latestIndustry) {
		this.latestIndustry = latestIndustry;
	}

	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}

	public Boolean getComRecent() {
		return comRecent;
	}

	public void setComRecent(Boolean comRecent) {
		this.comRecent = comRecent;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public Boolean getPhotoExist() {
		return photoExist;
	}

	public void setPhotoExist(Boolean photoExist) {
		this.photoExist = photoExist;
	}

	public Boolean getResumeEnExist() {
		return resumeEnExist;
	}

	public void setResumeEnExist(Boolean resumeEnExist) {
		this.resumeEnExist = resumeEnExist;
	}

	public Integer getPerUserId() {
		return perUserId;
	}

	public void setPerUserId(Integer perUserId) {
		this.perUserId = perUserId;
	}

	public String getPerName() {
		return perName;
	}

	public void setPerName(String perName) {
		this.perName = perName;
	}

	public Integer getSortBy() {
		return sortBy;
	}

	public void setSortBy(Integer sortBy) {
		this.sortBy = sortBy;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getSearchType() {
		return searchType;
	}

	public void setSearchType(Integer searchType) {
		this.searchType = searchType;
	}

	public Integer getProdId() {
		return prodId;
	}

	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}

	public List<Integer> getResumeIdList() {
		return resumeIdList;
	}

	public void setResumeIdList(List<Integer> resumeIdList) {
		this.resumeIdList = resumeIdList;
	}
}
