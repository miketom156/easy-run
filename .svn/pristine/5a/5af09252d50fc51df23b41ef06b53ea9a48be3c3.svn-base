package com.job5156.vo.api;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import com.google.common.collect.Lists;

/**
 * 基本结果封装对象
 * @author leo
 *
 */
public class BaseResult {
	/**
	 * 结果成员变量(默认为true)
	 */
	private boolean success = true;

	/**
	 * 资源信息
	 */
	private String message;

	/**
	 * 错误信息列表
	 */
	private List<String> errorList = Lists.newArrayList();

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getErrorList() {
		return errorList;
	}

	public void setErrorList(List<String> errorList) {
		this.errorList = errorList;
		if(CollectionUtils.isNotEmpty(errorList)){
			this.setSuccess(false);
		}
	}

	public void setError(String errorMsg){
		if(StringUtils.isNotBlank(errorMsg)){
			this.errorList.add(errorMsg);
			this.setSuccess(false);
		}
	}
}
