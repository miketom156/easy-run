package com.job5156.task.backup;

import org.joda.time.DateTime;
import org.springframework.dao.EmptyResultDataAccessException;

import com.job5156.common.util.HibernateActionUtil;
import com.job5156.common.util.HibernateBackupActionUtil;

/**
 * <p>
 * 备份并清理5156action库中的个人简历被查看记录表
 * </p>
 * 
 * <pre>
 * 1、只保留半年数据
 * 2、半年前数据保存到按年份来分的表中，然后清理
 * </pre>
 *
 * Date:2015-5-20 下午5:28:11
 * @author leo
 * @version 1.0
 */
public class BackPerViewLog extends BackAndCleanData implements Runnable {
	
	public BackPerViewLog(){
		this.sourceTableName = "per_view_log";
		this.sourceDateFieldName = "cre_time";
		this.deleteSourceFlag = false;
		this.backupEndDate = DateTime.now().minusMonths(6).secondOfDay().withMinimumValue().toDate();
		this.jdbcTemplateSource = HibernateActionUtil.getJdbcTemplate();
		this.jdbcTemplateTarget = HibernateBackupActionUtil.getJdbcTemplate();
	}
	
	@Override
	public void run() {
		logger.info("Start To Backup PerViewLog Data");
		this.backupAndCleanData(BackupType.YEAR);
	}
	
	public static void main(String[] args) {
		new Thread(new BackPerViewLog()).start();
	}

	/**
	 * 判断备份数据库中是否存在备份表，如果不存在手工创建
	 */
	@Override
	public void createBackTable(String backTableName) {
		try{
			this.jdbcTemplateTarget.queryForObject("SHOW TABLES LIKE ?", new String[]{backTableName}, String.class);
		}catch(EmptyResultDataAccessException e){
			StringBuffer buffer = new StringBuffer("CREATE TABLE `"+backTableName+"` (");
			buffer.append("`id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',");
			buffer.append("`per_user_id` int(10) NOT NULL COMMENT '人个账号ID',");
			buffer.append("`com_id` int(10) NOT NULL COMMENT '企业ID',");
			buffer.append("`look_num` int(10) DEFAULT NULL COMMENT '查看次数',");
			buffer.append("`cre_time` datetime DEFAULT NULL COMMENT '查看简历时间',");
			buffer.append("`edit_time` datetime DEFAULT NULL COMMENT '修改时间（修改备注）',");
			buffer.append("`look_status` tinyint(2) DEFAULT NULL COMMENT '是否查看联系方式  未查看0   已查看1',");
			buffer.append("`del_status` tinyint(2) DEFAULT NULL COMMENT '删除  未删除0   已删除-1',");
			buffer.append("`mark` tinyint(2) DEFAULT NULL COMMENT '旗子标记',");
			buffer.append("`remark` varchar(500) DEFAULT NULL COMMENT '注备内容',");
			buffer.append("`com_name` varchar(100) DEFAULT NULL,");
			buffer.append("`com_info` varchar(500) DEFAULT NULL,");
			buffer.append("`mix_info` longtext COMMENT 'json格式的混合信息',");
			buffer.append("PRIMARY KEY (`id`),");
			buffer.append("KEY `userid_index` (`per_user_id`),");
			buffer.append("KEY `delstatus_index` (`del_status`),");
			buffer.append("KEY `I_com_id` (`com_id`) USING BTREE,");
			buffer.append("KEY `I_cre_time` (`cre_time`) USING BTREE,");
			buffer.append("KEY `I_edit_time` (`edit_time`) USING BTREE");
			buffer.append(") ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;");
			this.jdbcTemplateTarget.update(buffer.toString());
		}
	}
}
