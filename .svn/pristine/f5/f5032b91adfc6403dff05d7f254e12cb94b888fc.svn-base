package com.job5156.task.backup;

import org.joda.time.DateTime;
import org.springframework.dao.EmptyResultDataAccessException;

import com.job5156.common.util.HibernateActionUtil;
import com.job5156.common.util.HibernateBackupActionUtil;

/**
 * <p>
 * 备份并清理5156action库中的个人邀请面试记录表
 * </p>
 * 
 * <pre>
 * 1、只保留半年数据
 * 2、半年前数据保存到按年份来分的表中，然后清理
 * </pre>
 *
 * Date:2015-5-20 下午5:08:44
 * @author leo
 * @version 1.0
 */
public class BackPerInviteLog extends BackAndCleanData implements Runnable {
	
	public BackPerInviteLog(){
		this.sourceTableName = "per_invite_log";
		this.sourceDateFieldName = "cre_time";
		this.deleteSourceFlag = false;
		this.backupEndDate = DateTime.now().minusMonths(6).secondOfDay().withMinimumValue().toDate();
		this.jdbcTemplateSource = HibernateActionUtil.getJdbcTemplate();
		this.jdbcTemplateTarget = HibernateBackupActionUtil.getJdbcTemplate();
	}
	
	@Override
	public void run() {
		logger.info("Start To Backup PerInviteLog Data");
		this.backupAndCleanData(BackupType.YEAR);
	}
	
	public static void main(String[] args) {
		new Thread(new BackPerInviteLog()).start();
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
			buffer.append("`id` int(10) NOT NULL AUTO_INCREMENT COMMENT '请面试邀主键',");
			buffer.append("`per_user_id` int(10) NOT NULL COMMENT '个人ID',");
			buffer.append("`com_id` int(10) NOT NULL COMMENT '企业ID',");
			buffer.append("`pos_id` int(10) NOT NULL COMMENT '职位ID',");
			buffer.append("`cre_time` datetime DEFAULT NULL COMMENT '请邀时间',");
			buffer.append("`edit_time` datetime DEFAULT NULL,");
			buffer.append("`del_status` tinyint(2) DEFAULT '0' COMMENT '个人删除字段',");
			buffer.append("`read_status` tinyint(2) DEFAULT NULL COMMENT '是否已查看',");
			buffer.append("`mark` varchar(100) DEFAULT NULL COMMENT '旗子标记 红：red  绿：green  蓝：blue',");
			buffer.append("`remark` varchar(500) DEFAULT NULL COMMENT '备注内容',");
			buffer.append("`user_name` varchar(100) DEFAULT NULL,");
			buffer.append("`invite_detail` text COMMENT '邀请详情',");
			buffer.append("`interview_address` varchar(500) DEFAULT NULL COMMENT '面试地点',");
			buffer.append("`room_num` int(10) DEFAULT NULL COMMENT '频视面试房间号',");
			buffer.append("`book_period` varchar(100) DEFAULT NULL COMMENT '面试的预约时间段',");
			buffer.append("`contact_person` varchar(100) DEFAULT NULL COMMENT '联系人',");
			buffer.append("`contact_phone` varchar(100) DEFAULT NULL COMMENT '联系电话',");
			buffer.append("`mix_info` longtext COMMENT 'json格式的混合信息',");
			buffer.append("PRIMARY KEY (`id`),");
			buffer.append("KEY `userid_index` (`per_user_id`),");
			buffer.append("KEY `IX_pos_id` (`pos_id`),");
			buffer.append("KEY `IX_cre_time` (`cre_time`)");
			buffer.append(") ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;");
			this.jdbcTemplateTarget.update(buffer.toString());
		}
	}
}
