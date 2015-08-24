package com.job5156.task.backup;

import org.joda.time.DateTime;
import org.springframework.dao.EmptyResultDataAccessException;

import com.job5156.common.util.HibernateActionUtil;
import com.job5156.common.util.HibernateBackupActionUtil;

/**
 * <p>
 * 备份并清理5156action库中的个人应聘记录表
 * </p>
 * 
 * <pre>
 * 1、只保留半年数据
 * 2、半年前数据保存到按年份来分的表中，然后清理
 * </pre>
 * 
 * Date:2015-5-13 下午5:04:20
 * 
 * @author leo
 * @version 1.0
 */
public class BackPerPosApply extends BackAndCleanData implements Runnable {

	public BackPerPosApply(){
		this.sourceTableName = "per_pos_apply";
		this.sourceDateFieldName = "cre_time";
		this.deleteSourceFlag = false;
		this.backupEndDate = DateTime.now().minusMonths(6).secondOfDay().withMinimumValue().toDate();
		this.jdbcTemplateSource = HibernateActionUtil.getJdbcTemplate();
		this.jdbcTemplateTarget = HibernateBackupActionUtil.getJdbcTemplate();
	}
	
	@Override
	public void run() {
		logger.info("Start To Backup PerPosApply Data");
		this.backupAndCleanData(BackupType.YEAR);
	}
	
	public static void main(String[] args){
		new Thread(new BackPerPosApply()).start();
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
			buffer.append("`per_user_id` int(10) NOT NULL COMMENT '人个用户ID',");
			buffer.append("`pos_id` int(10) NOT NULL COMMENT '职位ID',");
			buffer.append("`com_id` int(10) NOT NULL COMMENT '企业ID',");
			buffer.append("`apply_num` tinyint(2) DEFAULT NULL,");
			buffer.append("`cre_time` datetime NOT NULL COMMENT '应聘时间',");
			buffer.append("`edit_time` datetime DEFAULT NULL,");
			buffer.append("`reply_status` tinyint(2) DEFAULT NULL COMMENT '企业对此次应聘的回复状态',");
			buffer.append("`del_status` tinyint(2) DEFAULT NULL,");
			buffer.append("`mark` varchar(100) DEFAULT NULL COMMENT '旗子标记  红：read  绿：green  蓝：blue',");
			buffer.append("`remark` varchar(200) DEFAULT NULL COMMENT '备注内容',");
			buffer.append("`mix_info` longtext COMMENT 'json格式的混合信息',");
			buffer.append("`from_source_url` varchar(800) DEFAULT NULL COMMENT '来源地址',");
			buffer.append("`spread_item_tn` varchar(30) DEFAULT NULL COMMENT '推广栏目编号',");
			buffer.append("`resume_id` int(10) DEFAULT NULL COMMENT '应聘的简历ID',");
			buffer.append("`resume_name` varchar(100) DEFAULT NULL COMMENT '应聘的简历名称',");
			buffer.append("`resume_type` tinyint(2) DEFAULT '0' COMMENT '简历类型:0：普通简历 1: 为长沙类型的简历 2: 名片',");
			buffer.append("PRIMARY KEY (`id`),");
			buffer.append("KEY `userid_index` (`per_user_id`),");
			buffer.append("KEY `IX_pos_id` (`pos_id`),");
			buffer.append("KEY `IX_resume_id` (`resume_id`),");
			buffer.append("KEY `IX_cre_time` (`cre_time`)");
			buffer.append(") ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;");
			this.jdbcTemplateTarget.update(buffer.toString());
		}
	}
}
