package com.job5156.model.sys.logo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.SelectBeforeUpdate;

import com.google.common.collect.Lists;

/**
 * <P>
 * 后台LOGO管理-LOGO文件中对应一行TABLE显示
 * </P>
 * 
 * @author leo
 * 
 */
@Entity
@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate
public class SysLogoTable implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;				// 主键ID
	@NotNull(message = "{sys.logoFile.boardSet.logoTable.fileId.is.notempty}")
	private Integer fileId;			// 文件ID
	@NotNull(message = "{sys.logoFile.boardSet.logoTable.orderby.is.notempty}")
	private Integer orderBy;		// 排序
	@NotNull(message = "{sys.logoFile.boardSet.logoTable.tableId.is.notempty}")
	private Integer tableId;
	
	private SysLogoFile logoFile;   // LOGO文件
	
	private List<SysLogoPosition> logoPositionList = Lists.newArrayList();	// LOGO位置列表
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fileId", updatable = false, insertable = false)
	@NotFound(action = NotFoundAction.IGNORE)
	public SysLogoFile getLogoFile() {
		return logoFile;
	}

	public void setLogoFile(SysLogoFile logoFile) {
		this.logoFile = logoFile;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "logoTable", cascade = {CascadeType.REMOVE})
	@OrderBy(value = "rowNum asc, orderBy asc")
	public List<SysLogoPosition> getLogoPositionList() {
		return logoPositionList;
	}

	public void setLogoPositionList(List<SysLogoPosition> logoPositionList) {
		this.logoPositionList = logoPositionList;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFileId() {
		return fileId;
	}

	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}

	public Integer getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(Integer orderBy) {
		this.orderBy = orderBy;
	}

	public Integer getTableId() {
		return tableId;
	}

	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}
}
