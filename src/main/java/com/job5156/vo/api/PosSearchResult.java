package com.job5156.vo.api;

import java.util.List;

import com.job5156.model.com.ComInfo;
import com.job5156.model.com.ComPosition;

/**
 * 职位搜索结果对象
 * 
 * @author leo
 * 
 */
public class PosSearchResult extends BaseResult {

	private List<ComPosVo> dataList; // 职位、企业信息列表
	private Integer realCount;		 // 真实职位总数

	public List<ComPosVo> getDataList() {
		return dataList;
	}

	public void setDataList(List<ComPosVo> dataList) {
		this.dataList = dataList;
	}
	
	public Integer getRealCount() {
		return realCount;
	}

	public void setRealCount(Integer realCount) {
		this.realCount = realCount;
	}

	public static class ComPosVo {
		private Integer posNo;	 	  	// 职位编号
		private Integer posType;	  	// 职位类型
		private ComInfo company; 		// 企业信息
		private ComPosition position; 	// 职位信息

		public Integer getPosNo() {
			return posNo;
		}

		public void setPosNo(Integer posNo) {
			this.posNo = posNo;
		}

		public Integer getPosType() {
			return posType;
		}

		public void setPosType(Integer posType) {
			this.posType = posType;
		}

		public ComInfo getCompany() {
			return company;
		}

		public void setCompany(ComInfo company) {
			this.company = company;
		}

		public ComPosition getPosition() {
			return position;
		}

		public void setPosition(ComPosition position) {
			this.position = position;
		}
	}
}
