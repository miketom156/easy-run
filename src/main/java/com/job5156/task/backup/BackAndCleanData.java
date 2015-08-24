package com.job5156.task.backup;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import com.google.common.collect.Lists;
import com.job5156.beans.mail.EmailSender;
import com.job5156.common.CommonEnum.MailServer;
import com.job5156.common.exception.EmailServerConfigException;
import com.job5156.model.mail.EmailQueue;

/**
 * <p>
 * 备份和清理数据库
 * </p>
 * 
 * Date:2015-5-16 下午11:31:59
 * 
 * @author leo
 * @version 1.0
 */
public abstract class BackAndCleanData {
	protected Logger logger = Logger.getLogger(this.getClass());
	// 备份源数据表
	protected String sourceTableName;
	// 备份源数据表时间字段名称
	protected String sourceDateFieldName;
	// 备份分页数量
	protected Integer pageSize = 5000;

	// 备份源连接池
	protected JdbcTemplate jdbcTemplateSource;
	// 备份目标连接池
	protected JdbcTemplate jdbcTemplateTarget;
	// 是否删除源数据，默认删除源表数据
	protected boolean deleteSourceFlag = true;
	// 备份数据开始时间，默认为截止时间前的最小时间
	protected Date backupBeginDate;
	// 备份数据截止时间，备份的数据小于截止时间
	protected Date backupEndDate;

	/**
	 * 备份和清理数据
	 * 
	 * @param backupType
	 */
	protected void backupAndCleanData(BackupType backupType) {
		try{
			Long startTimeMillis = System.currentTimeMillis();
			DateTime backupEndDateTime = new DateTime(backupEndDate).secondOfDay().withMinimumValue();
			String sql = "SELECT MIN(" + sourceDateFieldName + ") FROM " + sourceTableName + " WHERE " + sourceDateFieldName + " < ?";
			Date backupStartDate = jdbcTemplateSource.queryForObject(sql, new Object[] { backupEndDateTime.toDate() }, Date.class);
			if (backupStartDate != null) {
				if (backupBeginDate != null && backupBeginDate.after(backupStartDate)) {
					backupStartDate = backupBeginDate;
				}
				DateTime backupStartDateTime = new DateTime(backupStartDate);
				String backupDateStr = backupStartDateTime.toString("yyyy-MM-dd") + "~" + backupEndDateTime.toString("yyyy-MM-dd");
				logger.info("Start To Backup Data: TableName[" + sourceTableName + "] BackupDate[" + backupDateStr + "]");

				while (backupStartDateTime.secondOfDay().withMinimumValue().isBefore(backupEndDateTime)) {
					switch (backupType) {
					case YEAR:
						backupAndCleanDataWithYear(backupStartDateTime.getYear());
						backupStartDateTime = backupStartDateTime.plusYears(1);
						break;
					case YEAR_MONTH:
						backupAndCleanDataWithYearMonth(backupStartDateTime.getYear(), backupStartDateTime.getMonthOfYear());
						backupStartDateTime = backupStartDateTime.plusMonths(1);
						break;
					}
				}
				
				long costTimeMinute = (System.currentTimeMillis() - startTimeMillis) / (1000 * 60);
				logger.info("Finish To Backup Data: TableName[" + sourceTableName + "] Cost[" + costTimeMinute + " Minute]");
			}
		} catch (Exception e) {
			e.printStackTrace();
			String mailContent = DateTime.now().toString("yyyy-MM-dd HH:mm:ss")+"-Backup And Clean Table " + sourceTableName + " Exception:" + e.getMessage();
			logger.error("Backup And Clean Data Exception:" + e.getMessage());
			sendFailBackupMail(mailContent);
		}
	}

	/**
	 * 按年备份源表数据
	 * 
	 * @param year
	 *            年份，如：2014
	 */
	protected void backupAndCleanDataWithYear(Integer year) {
		backupAndCleanData(year, null);
	}

	/**
	 * 按年月备份源表数据
	 * 
	 * @param yearMonth
	 *            年月，如：201405
	 */
	protected void backupAndCleanDataWithYearMonth(Integer year, Integer month) {
		backupAndCleanData(year, month);
	}

	/**
	 * 检测是否存在备份表，如果不存在则创建
	 * 
	 * @param tableName
	 *            备份表名
	 */
	public abstract void createBackTable(String backTableName);

	/**
	 * 备份和清理数据
	 * 
	 * @param targetTableName
	 *            备份表名
	 */
	private void backupAndCleanData(Integer year, Integer month) {
		String targetTableName = sourceTableName
				+ "_"
				+ year
				+ ((month != null && month > 0) ? StringUtils.leftPad(String.valueOf(month), 2, "0") : StringUtils.EMPTY);
		this.createBackTable(targetTableName);

		// 查询原表数据结构
		List<Map<String, Object>> metaList = jdbcTemplateSource.queryForList("SELECT * FROM " + sourceTableName + " LIMIT 1");
		if (CollectionUtils.isNotEmpty(metaList)) {
			Map<String, Object> metaMap = metaList.get(0);
			List<String> fieldList = Lists.newArrayList();

			String insertSql = assembleInsertSql(targetTableName, metaMap.keySet(), fieldList);
			Date backupDateBegin = getRangeDateBegin(year, month);
			Date backupDateEnd = getRangeDateEnd(year, month);

			if (backupDateBegin.before(backupDateEnd)) {
				/*
				 * String sql =
				 * "SELECT MIN(id) AS minId, MAX(id) AS maxId FROM " +
				 * sourceTableName + " WHERE " + sourceDateFieldName +
				 * " >= ? and " + sourceDateFieldName + " < ?"; Map<String,
				 * Object> idMap = jdbcTemplateSource.queryForMap(sql,
				 * backupDateBegin, backupDateEnd); if
				 * (MapUtils.isNotEmpty(idMap)) { Integer minId =
				 * NumberUtils
				 * .toInt(ObjectUtils.toString(idMap.get("minId")), 0);
				 * Integer maxId =
				 * NumberUtils.toInt(ObjectUtils.toString(idMap
				 * .get("maxId")), 0); // 备份并清理数据
				 * backupAndCleanData(insertSql, fieldList, minId, maxId); }
				 */
				backupAndCleanData(insertSql, fieldList, backupDateBegin, backupDateEnd);
				logger.info("Finish Backup And Clean Data: SourceTableName[" + sourceTableName + "] TargetTableName[" + targetTableName + "]");
			}
		}
	}

	/**
	 * <p>
	 * 备份线上action库数据到各年份分表<br>
	 * 说明：此备份和清理方式按照取时间范围来处理<br>
	 * </p>
	 * 
	 * @param insertSql
	 *            插入的sql语句
	 * @param fieldList
	 *            源表中时间段内最小记录id
	 * @param beginDate
	 *            备份开始时间
	 * @param endDate
	 *            备份截止时间
	 */
	private void backupAndCleanData(String insertSql, List<String> fieldList, Date beginDate, Date endDate) {
		boolean cycleFlag = true;
		Integer cycleCount = 0;

		while (cycleFlag) {
			long startTimeMillis = System.currentTimeMillis();
			String querySql = "SELECT * FROM " + sourceTableName + " WHERE " + sourceDateFieldName + " >= ? and " + sourceDateFieldName + " < ? LIMIT ?, ?";
			List<Map<String, Object>> dataList = jdbcTemplateSource.queryForList(querySql, beginDate, endDate, cycleCount * pageSize, pageSize);
			saveDataToSeparateTable(insertSql, fieldList, dataList);
			
			long costTimeSecond = (System.currentTimeMillis() - startTimeMillis) / 1000;
			logger.info("Backup Data: FROM[" + (cycleCount * pageSize) + "] LIMIT[" + pageSize + "] DATASIZE[" + CollectionUtils.size(dataList) + "] COST[" + costTimeSecond + " Second]");
			
			cycleCount++;
			cycleFlag = CollectionUtils.size(dataList) > 0;
		}

		// 清理刚备份的数据，若发生异常则直接终止备份进程
		if (deleteSourceFlag) {
			cleanDataWithSourceTable(beginDate, endDate);
		}
	}

	/**
	 * 清理源表中日期范围之间的数据
	 * 
	 * @param beginDate
	 *            日期范围下线
	 * @param endDate
	 *            日期范围上线
	 */
	private void cleanDataWithSourceTable(Date beginDate, Date endDate) {
		String deleteSql = "DELETE FROM " + sourceTableName + " WHERE " + sourceDateFieldName + " >= ? and " + sourceDateFieldName + " < ?";
		jdbcTemplateSource.update(deleteSql, beginDate, endDate);
	}

	/**
	 * <p>
	 * 备份线上库数据到各年份分表<br>
	 * 说明：此备份和清理方式需要满足两个条件<br>
	 * 1、数据库表主键为“id”,自增<br>
	 * 2、数据库表中数据按照创建时间升序，id也是升序增长，不存在数据混乱的情况<br>
	 * 此种方式不符合所有表备份，所以只能作为特殊情况处理<br>
	 * </p>
	 * 
	 * @param insertSql
	 *            插入的sql语句
	 * @param minId
	 *            源表中时间段内最小记录id
	 * @param maxId
	 *            源表中时间段内最大记录id
	 */
	@SuppressWarnings("unused")
	@Deprecated
	private void backupAndCleanData(String insertSql, List<String> fieldList, Integer minId, Integer maxId) {
		String querySql = "SELECT * FROM " + sourceTableName + " WHERE id >= ? AND id <= ?";
		while (minId <= maxId) {
			Integer endId = minId + pageSize;
			if (endId > maxId) {
				endId = maxId;
			}
			List<Map<String, Object>> dataList = jdbcTemplateSource.queryForList(querySql, minId, endId);
			// 备份最小id与最大id之间的数据，若发生异常则直接终止备份进程
			saveDataToSeparateTable(insertSql, fieldList, dataList);
			// 清理刚备份的数据，若发生异常则直接终止备份进程
			if (deleteSourceFlag) {
				cleanDataWithSourceTable(minId, endId);
			}
			minId = endId + 1;
		}
	}

	/**
	 * 清理源表中主键ID在最小值与最大值之间的数据
	 * 
	 * @param minId
	 *            主键id最小值
	 * @param maxId
	 *            主键id最大值
	 */
	private void cleanDataWithSourceTable(Integer minId, Integer maxId) {
		String deleteSql = "DELETE FROM " + sourceTableName + " WHERE id >= ? AND id <= ?";
		jdbcTemplateSource.update(deleteSql, minId, maxId);
	}

	/**
	 * 保存数据到分表
	 * 
	 * @param insertSql
	 * @param fieldList
	 * @param dataList
	 */
	private void saveDataToSeparateTable(String insertSql, final List<String> fieldList,
			final List<Map<String, Object>> dataList) {
		if (CollectionUtils.isNotEmpty(dataList)) {
			jdbcTemplateTarget.batchUpdate(insertSql, new BatchPreparedStatementSetter() {

				@Override
				public void setValues(PreparedStatement ps, int i) throws SQLException {
					Map<String, Object> dataMap = dataList.get(i);
					for (int fieldNum = 0; fieldNum < fieldList.size(); fieldNum++) {
						ps.setObject(fieldNum + 1, dataMap.get(fieldList.get(fieldNum)));
					}
				}

				@Override
				public int getBatchSize() {
					return dataList.size();
				}

			});
		}
	}

	/**
	 * 数据备份失败发送邮件提醒
	 * 
	 * @param content
	 */
	private void sendFailBackupMail(String content) {
		try {
			EmailSender sender = new EmailSender(MailServer.EXCHANGE);
			EmailQueue emailQueue = new EmailQueue();
			emailQueue.setToAddr("dg3996@zhitong.com");
			emailQueue.setFromName("智通人才网");
			emailQueue.setTitle("数据库备份清理异常");
			emailQueue.setContent(content);
			sender.send(emailQueue);
		} catch (EmailServerConfigException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 组装插入的SQL语句
	 * 
	 * @param tableName
	 *            备份目标数据表
	 * @param fieldSet
	 *            表字段集合
	 * @param fieldList
	 *            表字段先后顺序
	 * @return
	 */
	private String assembleInsertSql(String tableName, Set<String> fieldSet, List<String> fieldList) {
		StringBuffer buf = new StringBuffer("INSERT INTO " + tableName + "(");
		for (String field : fieldSet) {
			buf.append(field + ",");
			fieldList.add(field);
		}
		buf.deleteCharAt(buf.length() - 1);
		buf.append(") VALUES(");

		int fieldSize = fieldSet.size();
		for (int num = 0; num < fieldSize; num++) {
			buf.append("?,");
		}
		buf.deleteCharAt(buf.length() - 1);
		buf.append(")");

		return buf.toString();
	}

	/**
	 * <p>
	 * 备份类型
	 * </p>
	 * 
	 * <pre>
	 * YEAR：按年来备份源表数据
	 * YEAR_MONTH：按年月来备份源表数据
	 * </pre>
	 * 
	 * Date:2015-5-17 上午2:15:22
	 * 
	 * @author leo
	 * @version 1.0
	 */
	public enum BackupType {
		YEAR, YEAR_MONTH;
	}

	/**
	 * 获取备份数据的开始时间
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	private Date getRangeDateBegin(Integer year, Integer month) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		if (month != null && month > 0) {
			calendar.set(Calendar.MONTH, month - 1);
			calendar.set(Calendar.DATE, 1);
		} else {
			calendar.set(Calendar.MONTH, 0);
			calendar.set(Calendar.DATE, 1);
		}
		return new DateTime(calendar).secondOfDay().withMinimumValue().toDate();
	}

	/**
	 * 获取备份数据的截止时间
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	private Date getRangeDateEnd(Integer year, Integer month) {
		Calendar calendar = Calendar.getInstance();
		if (month != null && month > 0) {
			calendar.set(Calendar.YEAR, year);
			calendar.set(Calendar.MONTH, month);
			calendar.set(Calendar.DATE, 1);
		} else {
			calendar.set(Calendar.YEAR, year + 1);
			calendar.set(Calendar.MONTH, 0);
			calendar.set(Calendar.DATE, 1);
		}
		DateTime calculateDateTime = new DateTime(calendar).secondOfDay().withMinimumValue();
		DateTime endDateTime = new DateTime(backupEndDate).secondOfDay().withMinimumValue();

		if (calculateDateTime.isAfter(endDateTime)) {
			return endDateTime.toDate();
		}
		return calculateDateTime.toDate();
	}

	public String getSourceTableName() {
		return sourceTableName;
	}

	public void setSourceTableName(String sourceTableName) {
		this.sourceTableName = sourceTableName;
	}

	public String getSourceDateFieldName() {
		return sourceDateFieldName;
	}

	public void setSourceDateFieldName(String sourceDateFieldName) {
		this.sourceDateFieldName = sourceDateFieldName;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public JdbcTemplate getJdbcTemplateSource() {
		return jdbcTemplateSource;
	}

	public void setJdbcTemplateSource(JdbcTemplate jdbcTemplateSource) {
		this.jdbcTemplateSource = jdbcTemplateSource;
	}

	public JdbcTemplate getJdbcTemplateTarget() {
		return jdbcTemplateTarget;
	}

	public void setJdbcTemplateTarget(JdbcTemplate jdbcTemplateTarget) {
		this.jdbcTemplateTarget = jdbcTemplateTarget;
	}

	public boolean isDeleteSourceFlag() {
		return deleteSourceFlag;
	}

	public void setDeleteSourceFlag(boolean deleteSourceFlag) {
		this.deleteSourceFlag = deleteSourceFlag;
	}

	public Date getBackupBeginDate() {
		return backupBeginDate;
	}

	public void setBackupBeginDate(Date backupBeginDate) {
		this.backupBeginDate = backupBeginDate;
	}

	public Date getBackupEndDate() {
		return backupEndDate;
	}

	public void setBackupEndDate(Date backupEndDate) {
		this.backupEndDate = backupEndDate;
	}
}
