package com.job5156.vo.api;

import java.util.List;

import com.job5156.model.per.PerResume;
import com.job5156.model.per.PerUser;

/**
 * 简历搜索结果返回对象
 * 
 * @author leo
 * 
 */
public class ResumeSearchResult extends BaseResult {

	private List<PerResVo> dataList; // 简历信息列表
	private Integer realCount;		 // 简历总数

	public List<PerResVo> getDataList() {
		return dataList;
	}

	public void setDataList(List<PerResVo> dataList) {
		this.dataList = dataList;
	}
	
	public Integer getRealCount() {
		return realCount;
	}

	public void setRealCount(Integer realCount) {
		this.realCount = realCount;
	}

	public static class PerResVo {
		private PerResume resume;
		private PerUser user;

		public PerResume getResume() {
			return resume;
		}

		public void setResume(PerResume resume) {
			this.resume = resume;
		}

		public PerUser getUser() {
			return user;
		}

		public void setUser(PerUser user) {
			this.user = user;
		}
	}
}
