package com.job5156.vo.api;

/**
 * 职位搜索查询结果数量统计
 * 
 * @author leo
 * 
 */
public class PosSearchCountResult extends BaseResult {

	private Integer realCount;			// 真实结果数量
	private PosSearchFilter filter;		// 分类统计数量

	public Integer getRealCount() {
		return realCount;
	}

	public void setRealCount(Integer realCount) {
		this.realCount = realCount;
	}

	public PosSearchFilter getFilter() {
		return filter;
	}

	public void setFilter(PosSearchFilter filter) {
		this.filter = filter;
	}
}
