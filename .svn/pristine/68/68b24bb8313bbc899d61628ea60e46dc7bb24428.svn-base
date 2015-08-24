package com.job5156.vo.search;

import java.util.List;

/**
 * 职位搜索vo
 * 
 * @author leo
 * 
 */
public class SearchPosFormVo {

	private String keyword; // 关键字
	private Integer keywordType; // 关键字匹配范围{0-所有，1-职位名称，2-企业名称}
	private Integer keywordAnd; // 关键字之间的关系，如果此值为1，则关键词之间是or的关系，否则为and
	private List<Integer> locationList; // 职位工作地点
	private String locationAddr; // 职位地区
	private List<Integer> posTypeList; // 职位类别
	private List<Integer> industryList; // 企业行业类别
	private Integer degreeFrom; // 学历要求，最低条件
	private Integer degreeTo; // 学历要求，最高条件
	private Boolean degreeUnlimit; // 学历要求，包含不限
	private Integer workyearFrom; // 工作经验要求，最低条件
	private Integer workyearTo; // 工作经验要求，最高条件
	private Boolean workyearUnlimit; // 工作经验要求，包含不限
	private Integer salary; // 薪资待遇
	private Boolean salaryUnPublic; // 薪资待遇，包含未公开
	private List<String> taoLabelList; // 淘标签
	private List<Integer> propertyList; // 工作性质{1=全职，2=兼职，3=实习}
	private Integer gender; // 性别要求，0=不限，1=男，2=女
	private Integer age; // 年龄要求，输入求职者的年龄，0或null为不限
	private Double lat; // 纬度
	private Double lng; // 经度
	private Integer mile;

	private Integer updateIn; // 职位更新日期，按天算，如3个月算90天，取值90
	private Integer sortBy; // 排序方式，0=按更新日期 【以下3个可能有调整，1=学历+发布时间 2=工作经验
							// 3=初次发布时间】
	private Integer pageNo; // 页码
	private Integer pageSize; // 每页显示数量

	private List<Integer> comIdList; // 企业ID
	private Integer prodId; // 商品ID
	private Integer searchType; // 搜索类别(0: 全能搜索 1: 线下职位搜索)

	private boolean keywordHighLightFlag = true; // 添加此判断用于当手机或不支持高亮显示的入口，不进行自动添加em标签的高亮，默认为添加
	private Integer manualSort; // 手动搜索排序(0-不排序 1-收到简历过少排序 默认为0)

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Integer getKeywordType() {
		return keywordType;
	}

	public void setKeywordType(Integer keywordType) {
		this.keywordType = keywordType;
	}

	public Integer getKeywordAnd() {
		return keywordAnd;
	}

	public void setKeywordAnd(Integer keywordAnd) {
		this.keywordAnd = keywordAnd;
	}

	public List<Integer> getLocationList() {
		return locationList;
	}

	public void setLocationList(List<Integer> locationList) {
		this.locationList = locationList;
	}

	public String getLocationAddr() {
		return locationAddr;
	}

	public void setLocationAddr(String locationAddr) {
		this.locationAddr = locationAddr;
	}

	public List<Integer> getPosTypeList() {
		return posTypeList;
	}

	public void setPosTypeList(List<Integer> posTypeList) {
		this.posTypeList = posTypeList;
	}

	public List<Integer> getIndustryList() {
		return industryList;
	}

	public void setIndustryList(List<Integer> industryList) {
		this.industryList = industryList;
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

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Boolean getSalaryUnPublic() {
		return salaryUnPublic;
	}

	public void setSalaryUnPublic(Boolean salaryUnPublic) {
		this.salaryUnPublic = salaryUnPublic;
	}

	public List<String> getTaoLabelList() {
		return taoLabelList;
	}

	public void setTaoLabelList(List<String> taoLabelList) {
		this.taoLabelList = taoLabelList;
	}

	public List<Integer> getPropertyList() {
		return propertyList;
	}

	public void setPropertyList(List<Integer> propertyList) {
		this.propertyList = propertyList;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}

	public Integer getMile() {
		return mile;
	}

	public void setMile(Integer mile) {
		this.mile = mile;
	}

	public Integer getUpdateIn() {
		return updateIn;
	}

	public void setUpdateIn(Integer updateIn) {
		this.updateIn = updateIn;
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

	public List<Integer> getComIdList() {
		return comIdList;
	}

	public void setComIdList(List<Integer> comIdList) {
		this.comIdList = comIdList;
	}

	public Integer getProdId() {
		return prodId;
	}

	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}

	public Integer getSearchType() {
		return searchType;
	}

	public void setSearchType(Integer searchType) {
		this.searchType = searchType;
	}

	public boolean isKeywordHighLightFlag() {
		return keywordHighLightFlag;
	}

	public void setKeywordHighLightFlag(boolean keywordHighLightFlag) {
		this.keywordHighLightFlag = keywordHighLightFlag;
	}

	public Integer getManualSort() {
		return manualSort;
	}

	public void setManualSort(Integer manualSort) {
		this.manualSort = manualSort;
	}
}
