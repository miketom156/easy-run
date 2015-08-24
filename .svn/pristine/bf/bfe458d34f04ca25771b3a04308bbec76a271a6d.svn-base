package com.job5156.vo.per;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.Years;
import org.springframework.beans.BeanUtils;

import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.job5156.model.per.PerResume;

public class PerResumeVo {
	private Integer id; 				// 简历信息ID
	private Integer accountType; 		// 账号类型
	private Integer accountId; 			// 个人用户账号ID
	private String resumeName; 			// 简历名称
	private Integer resumeType; 		// 简历类型:1为长沙类型的简历
	private Integer resumeId; 			// 简历ID 中文简历 和 英文简历相互对应
	private String resumeStyle; 		// 简历模板，默认为default
	private Integer languageType; 		// 语言类型:0为中文，1为英文
	private String userLastEditBy; 		// 用户最后修改人
	private Date userLastEditDate; 		// 用户的最后修改时间
	private String adminLastEditBy; 	// 后台管理员最后修改人
	private Date adminLastEditDate; 	// 后台管理员最后修改时间
	private Date freDate; 				// 简历刷新时间
	private Integer resumeGrade; 		// 简历类型：0-普通,1-精英(猎头) 2-模具人才. 101:中高级人才（进查询库）
										// 105:中高级人才(保密级不进查询库)
	private Date passDate; 				// 审核时间
	private Integer comeFrom; 			// 简历来源
	private Integer havePhoto; 			// 是否有照片：0为无，1为有
	private Integer pass; 				// -10:自杀式简历，不让登录，-9：封锁,-3：审核不合格，-1：未开通，0:未完善，1：暂时开通，10：已开通
	private Integer flag; 				// 简历保密　0:完全公开　1:完全保密　2:公开但联系方式保密
	private Integer readCount; 			// 被企业查看次数
	private Integer resFormwork; 		// 简历模板：0-6 默认为0
	private Double perfectNum; 			// 简历完整度数
	private Integer perfectInfo; 		// 用户简历信息的完整的0:不可投递，1：可投递（填写所有必填项）
	private Integer age; 				// 年龄
	private Integer displayEnResume; 	// 是否显示英文简历(0:默认不显示,1:显示)

	private PerEducationInfoVo maxDegree; 		// 最高学历
	private PerIntentVo intentInfoVo; 			// 求职意向信息
	private PerUserInfoVo basicInfoVo;			// 个人基本信息
	private PerUserVo basicUserVo;

	private List<PerLanguageInfoVo> languageInfoVoList; 			// 语言技能信息
	private List<PerCertificateInfoVo> certificateInfoVoList; 		// 证书信息
	private List<PerProjectInfoVo> projectInfoVoList; 				// 项目信息
	private List<PerAccessoryInfoVo> accessoryInfoVoList; 			// 附件信息
	private List<PerWorkInfoVo> workInfoVoList; 					// 工作经历信息
	private List<PerEducationInfoVo> educationInfoVoList; 			// 教育经历信息
	private List<PerTrainInfoVo> trainInfoVoList; 					// 培训经历信息
	private List<PerSkillVo> skillVoList;                 			//专业技能

	public PerResumeVo(){
		
	}
	
	public PerResumeVo(PerResume perResume) {
		if (perResume != null) {
			BeanUtils.copyProperties(perResume, this);
            Gson gson = new Gson();
            if(StringUtils.isNotBlank(perResume.getIntentInfo())) {
                PerIntentVo intentInfoVo = gson.fromJson(perResume.getIntentInfo(), PerIntentVo.class);
                String jobLocation = intentInfoVo.getJobLocation();
                if(StringUtils.endsWith(jobLocation, ",")){
                    intentInfoVo.setJobLocation(StringUtils.substringBeforeLast(jobLocation, ","));
                }
                this.setIntentInfoVo(intentInfoVo);
            } else {
                PerIntentVo intentInfoVo = new PerIntentVo();
                intentInfoVo.setJobType(1);
                this.setIntentInfoVo(intentInfoVo);
            }
            this.setLanguageInfoVoList(gson.<List<PerLanguageInfoVo>>fromJson(perResume.getLanguageInfo(), new TypeToken<List<PerLanguageInfoVo>>() {}.getType()));
            this.setCertificateInfoVoList(gson.<List<PerCertificateInfoVo>>fromJson(perResume.getCertificateInfo(), new TypeToken<List<PerCertificateInfoVo>>() {}.getType()));
            this.setProjectInfoVoList(gson.<List<PerProjectInfoVo>>fromJson(perResume.getProjectInfo(), new TypeToken<List<PerProjectInfoVo>>() {}.getType()));
            this.setAccessoryInfoVoList(gson.<List<PerAccessoryInfoVo>>fromJson(perResume.getAccessoryInfo(), new TypeToken<List<PerAccessoryInfoVo>>() {}.getType()));
            this.setEducationInfoVoList(gson.<List<PerEducationInfoVo>>fromJson(perResume.getEducationInfo(), new TypeToken<List<PerEducationInfoVo>>() {}.getType()));
            this.setTrainInfoVoList(gson.<List<PerTrainInfoVo>>fromJson(perResume.getTrainInfo(), new TypeToken<List<PerTrainInfoVo>>() {}.getType()));

            this.setBasicInfoVo(new PerUserInfoVo(perResume.getPerUser()));

            //计算出年龄
            if(this.getBasicInfoVo() !=null && this.getBasicInfoVo().getBirthday() != null) {
                //计算年龄的公式修改为精确到年与搜索引擎匹配
                DateTime bDate =  new DateTime(this.getBasicInfoVo().getBirthday());
                bDate =  bDate.monthOfYear().setCopy(1).dayOfMonth().setCopy(1);
                DateTime nDate = DateTime.now() ;
                nDate =  nDate.monthOfYear().setCopy(1).dayOfMonth().setCopy(2);
                this.setAge(Years.yearsBetween(bDate, nDate).getYears());
            }
            //专业技能
            this.setSkillVoList(gson.<List<PerSkillVo>>fromJson(perResume.getSkillInfo(), new TypeToken<List<PerSkillVo>>() {}.getType()));

            //发现工作经验的id有重复，这里做加值处理
            List<PerWorkInfoVo> workVoList = gson.<List<PerWorkInfoVo>>fromJson(perResume.getWorkInfo(), new TypeToken<List<PerWorkInfoVo>>() {}.getType());
            if (CollectionUtils.isNotEmpty(workVoList)) {
            	int i = 1;
            	Map<Long, PerWorkInfoVo> workIdMap = Maps.newHashMap();
            	
            	for (PerWorkInfoVo workInfoVo : workVoList) {
            		if(workIdMap.containsKey(workInfoVo.getId())) {
            			workInfoVo.setId(workInfoVo.getId() + i);
            		}
            		workIdMap.put(workInfoVo.getId(), workInfoVo);
            		
            		i++;
            	}
            }
            this.setWorkInfoVoList(workVoList);
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

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getResumeName() {
		return resumeName;
	}

	public void setResumeName(String resumeName) {
		this.resumeName = resumeName;
	}

	public Integer getResumeType() {
		return resumeType;
	}

	public void setResumeType(Integer resumeType) {
		this.resumeType = resumeType;
	}

	public Integer getResumeId() {
		return resumeId;
	}

	public void setResumeId(Integer resumeId) {
		this.resumeId = resumeId;
	}

	public String getResumeStyle() {
		return resumeStyle;
	}

	public void setResumeStyle(String resumeStyle) {
		this.resumeStyle = resumeStyle;
	}

	public Integer getLanguageType() {
		return languageType;
	}

	public void setLanguageType(Integer languageType) {
		this.languageType = languageType;
	}

	public String getUserLastEditBy() {
		return userLastEditBy;
	}

	public void setUserLastEditBy(String userLastEditBy) {
		this.userLastEditBy = userLastEditBy;
	}

	public Date getUserLastEditDate() {
		return userLastEditDate;
	}

	public void setUserLastEditDate(Date userLastEditDate) {
		this.userLastEditDate = userLastEditDate;
	}

	public String getAdminLastEditBy() {
		return adminLastEditBy;
	}

	public void setAdminLastEditBy(String adminLastEditBy) {
		this.adminLastEditBy = adminLastEditBy;
	}

	public Date getAdminLastEditDate() {
		return adminLastEditDate;
	}

	public void setAdminLastEditDate(Date adminLastEditDate) {
		this.adminLastEditDate = adminLastEditDate;
	}

	public Date getFreDate() {
		return freDate;
	}

	public void setFreDate(Date freDate) {
		this.freDate = freDate;
	}

	public Integer getResumeGrade() {
		return resumeGrade;
	}

	public void setResumeGrade(Integer resumeGrade) {
		this.resumeGrade = resumeGrade;
	}

	public Date getPassDate() {
		return passDate;
	}

	public void setPassDate(Date passDate) {
		this.passDate = passDate;
	}

	public Integer getComeFrom() {
		return comeFrom;
	}

	public void setComeFrom(Integer comeFrom) {
		this.comeFrom = comeFrom;
	}

	public Integer getHavePhoto() {
		return havePhoto;
	}

	public void setHavePhoto(Integer havePhoto) {
		this.havePhoto = havePhoto;
	}

	public Integer getPass() {
		return pass;
	}

	public void setPass(Integer pass) {
		this.pass = pass;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public Integer getReadCount() {
		return readCount;
	}

	public void setReadCount(Integer readCount) {
		this.readCount = readCount;
	}

	public Integer getResFormwork() {
		return resFormwork;
	}

	public void setResFormwork(Integer resFormwork) {
		this.resFormwork = resFormwork;
	}

	public Double getPerfectNum() {
		return perfectNum;
	}

	public void setPerfectNum(Double perfectNum) {
		this.perfectNum = perfectNum;
	}

	public Integer getPerfectInfo() {
		return perfectInfo;
	}

	public void setPerfectInfo(Integer perfectInfo) {
		this.perfectInfo = perfectInfo;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getDisplayEnResume() {
		return displayEnResume;
	}

	public void setDisplayEnResume(Integer displayEnResume) {
		this.displayEnResume = displayEnResume;
	}

	public PerEducationInfoVo getMaxDegree() {
		return maxDegree;
	}

	public void setMaxDegree(PerEducationInfoVo maxDegree) {
		this.maxDegree = maxDegree;
	}

	public PerIntentVo getIntentInfoVo() {
		return intentInfoVo;
	}

	public void setIntentInfoVo(PerIntentVo intentInfoVo) {
		this.intentInfoVo = intentInfoVo;
	}

	public PerUserInfoVo getBasicInfoVo() {
		return basicInfoVo;
	}

	public void setBasicInfoVo(PerUserInfoVo basicInfoVo) {
		this.basicInfoVo = basicInfoVo;
	}

	public PerUserVo getBasicUserVo() {
		return basicUserVo;
	}

	public void setBasicUserVo(PerUserVo basicUserVo) {
		this.basicUserVo = basicUserVo;
	}

	public List<PerLanguageInfoVo> getLanguageInfoVoList() {
		return languageInfoVoList;
	}

	public void setLanguageInfoVoList(List<PerLanguageInfoVo> languageInfoVoList) {
		this.languageInfoVoList = languageInfoVoList;
	}

	public List<PerCertificateInfoVo> getCertificateInfoVoList() {
		return certificateInfoVoList;
	}

	public void setCertificateInfoVoList(List<PerCertificateInfoVo> certificateInfoVoList) {
		this.certificateInfoVoList = certificateInfoVoList;
	}

	public List<PerProjectInfoVo> getProjectInfoVoList() {
		return projectInfoVoList;
	}

	public void setProjectInfoVoList(List<PerProjectInfoVo> projectInfoVoList) {
		this.projectInfoVoList = projectInfoVoList;
	}

	public List<PerAccessoryInfoVo> getAccessoryInfoVoList() {
		return accessoryInfoVoList;
	}

	public void setAccessoryInfoVoList(List<PerAccessoryInfoVo> accessoryInfoVoList) {
		this.accessoryInfoVoList = accessoryInfoVoList;
	}

	public List<PerWorkInfoVo> getWorkInfoVoList() {
		return workInfoVoList;
	}

	public void setWorkInfoVoList(List<PerWorkInfoVo> workInfoVoList) {
		this.workInfoVoList = workInfoVoList;
	}

	public List<PerEducationInfoVo> getEducationInfoVoList() {
		return educationInfoVoList;
	}

    public void setEducationInfoVoList(List<PerEducationInfoVo> educationInfoVoList) {
        this.educationInfoVoList = educationInfoVoList;
        //获取最高学历
        if(educationInfoVoList == null) return;

        PerEducationInfoVo degree = null;
        for(PerEducationInfoVo education : educationInfoVoList) {
            Integer maxDegree = (degree == null || degree.getDegree() == null) ? 0 : degree.getDegree();
            Integer curDegree = education.getDegree() == null ? 0 : education.getDegree();
            if(degree == null || curDegree > maxDegree){
            	degree = education;
            }
        }
        this.setMaxDegree(degree);
    }

	public List<PerTrainInfoVo> getTrainInfoVoList() {
		return trainInfoVoList;
	}

	public void setTrainInfoVoList(List<PerTrainInfoVo> trainInfoVoList) {
		this.trainInfoVoList = trainInfoVoList;
	}

	public List<PerSkillVo> getSkillVoList() {
		return skillVoList;
	}

	public void setSkillVoList(List<PerSkillVo> skillVoList) {
		this.skillVoList = skillVoList;
	}
}
