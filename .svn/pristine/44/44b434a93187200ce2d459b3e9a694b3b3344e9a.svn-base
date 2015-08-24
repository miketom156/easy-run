package com.job5156.model.logs;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

/**
 * 批量发送邮件日志
 * 
 * @author leo
 * 
 */
@Entity
@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate
public class LogMailBatchSend implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id; // 主键ID
	private Integer taskId; // 批量发送任务ID
	private String proc; // 进程名称
	private String summary; // 摘要说明
	private Integer total; // 总应发数量
	private Integer success; // 发送成功数量
	private Integer fail; // 发送失败数量
	private String detail; // 发送明细（JSON格式）
	private Integer beginId; // 起始Id
	private Integer currentNum; // 当前发送的条数
	private Integer doneFlag; // 任务完成的状态:0、部分完成 1、全部完成。
	private Date createDate; // 创建日期

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getSuccess() {
		return success;
	}

	public void setSuccess(Integer success) {
		this.success = success;
	}

	public Integer getFail() {
		return fail;
	}

	public void setFail(Integer fail) {
		this.fail = fail;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getBeginId() {
		return beginId;
	}

	public void setBeginId(Integer beginId) {
		this.beginId = beginId;
	}

	public Integer getCurrentNum() {
		return currentNum;
	}

	public void setCurrentNum(Integer currentNum) {
		this.currentNum = currentNum;
	}

	public Integer getDoneFlag() {
		return doneFlag;
	}

	public void setDoneFlag(Integer doneFlag) {
		this.doneFlag = doneFlag;
	}

	public String getProc() {
		return proc;
	}

	public void setProc(String proc) {
		this.proc = proc;
	}
}
