package com.job5156.task.backup;

import org.joda.time.DateTime;
import org.springframework.dao.EmptyResultDataAccessException;

import com.job5156.common.util.HibernateActionUtil;
import com.job5156.common.util.HibernateBackupActionUtil;

/**
 * <p>
 * 备份并清理5156action库中的企业、个人、后台消息表
 * </p>
 * 
 * <pre>
 * 1、只保留半年数据
 * 2、半年前数据保存到按年份来分的表中，然后清理
 * </pre>
 *
 * Date:2015-5-20 下午6:21:55
 * @author leo
 * @version 1.0
 */
public class BackSiteMessage extends BackAndCleanData implements Runnable {

	public BackSiteMessage(){
		this.sourceTableName = "site_message";
		this.sourceDateFieldName = "create_date";
		this.deleteSourceFlag = false;
		this.backupEndDate = DateTime.now().minusMonths(6).secondOfDay().withMinimumValue().toDate();
		this.jdbcTemplateSource = HibernateActionUtil.getJdbcTemplate();
		this.jdbcTemplateTarget = HibernateBackupActionUtil.getJdbcTemplate();
	}
	
	@Override
	public void run() {
		logger.info("Start To Backup SiteMessage Data");
		this.backupAndCleanData(BackupType.YEAR);
	}
	
	public static void main(String[] args) {
		new Thread(new BackSiteMessage()).start();
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
			buffer.append("`id` int(10) NOT NULL AUTO_INCREMENT,");
			buffer.append("`come_from` varchar(100) NOT NULL COMMENT '消息来源类别(COM:表示来自企业,PER:表示来自个人,SYS:表示来自系统)',");
			buffer.append("`com_id` int(10) DEFAULT NULL COMMENT '企业ID',");
			buffer.append("`per_user_id` int(10) DEFAULT NULL COMMENT '个人ID',");
			buffer.append("`per_user_name` varchar(100) DEFAULT NULL COMMENT '个人名称',");
			buffer.append("`group_id` int(10) DEFAULT NULL COMMENT '分组ID,用做排序,(旧数据导入:replyId=0时为记录ID,否则等于replyId)',");
			buffer.append("`source_id` int(10) DEFAULT NULL COMMENT '发件人ID，这里可能是企业、个人或系统',");
			buffer.append("`source_name` varchar(100) DEFAULT NULL COMMENT '发件人名字,这里可能是企业、个人或系统',");
			buffer.append("`photo` varchar(100) DEFAULT NULL COMMENT '头像',");
			buffer.append("`gender` tinyint(2) DEFAULT NULL COMMENT '性别',");
			buffer.append("`age` smallint(4) DEFAULT NULL COMMENT '年龄',");
			buffer.append("`degree` smallint(4) DEFAULT NULL COMMENT '学历',");
			buffer.append("`category` varchar(100) DEFAULT NULL COMMENT '动态分组，用于首页分组显示，同一分组内可能有多种类型的动态',");
			buffer.append("`type` varchar(100) DEFAULT NULL COMMENT '动态的类型，内容根据动态类型在程序中生成',");
			buffer.append("`pos_id` int(10) DEFAULT NULL COMMENT '职位id',");
			buffer.append("`pos_name` varchar(500) DEFAULT NULL COMMENT '职位名称',");
			buffer.append("`title` varchar(100) DEFAULT NULL COMMENT '标题',");
			buffer.append("`content` varchar(1024) DEFAULT NULL,");
			buffer.append("`read_flag` tinyint(2) NOT NULL DEFAULT '0' COMMENT '是否已读(0为未读，1为已读)',");
			buffer.append("`draft_flag` tinyint(2) NOT NULL DEFAULT '0' COMMENT '草稿(0.普通 1.草稿)',");
			buffer.append("`per_del_flag` tinyint(2) NOT NULL DEFAULT '0' COMMENT ' 0:表示正常,-1:表示个人删除',");
			buffer.append("`com_del_flag` tinyint(2) NOT NULL DEFAULT '0' COMMENT '0:表示正常,-1:表示企业删除..',");
			buffer.append("`reply_flag` tinyint(2) NOT NULL DEFAULT '0' COMMENT ' 是否回复(0:未回复,1:已回复)',");
			buffer.append("`public_flag` tinyint(2) NOT NULL DEFAULT '1' COMMENT '回复内容是否公开显示(0:不公开,1:默认公开)',");
			buffer.append("`reply_id` int(10) NOT NULL DEFAULT '0' COMMENT '所回复的消息Id,默认为0表示首发而不是回复',");
			buffer.append("`create_date` datetime NOT NULL COMMENT '创建日期',");
			buffer.append("`update_date` datetime DEFAULT NULL COMMENT '更新日期',");
			buffer.append("`resume_id` int(10) DEFAULT NULL,");
			buffer.append("`com_user_id` int(10) DEFAULT NULL,");
			buffer.append("PRIMARY KEY (`id`),");
			buffer.append("KEY `com_id_idx` (`com_id`) USING BTREE,");
			buffer.append("KEY `I_comefrom` (`come_from`),");
			buffer.append("KEY `I_per_id` (`per_user_id`),");
			buffer.append("KEY `idx_category` (`category`),");
			buffer.append("KEY `idx_type` (`type`),");
			buffer.append("KEY `idx_create_date` (`create_date`),");
			buffer.append("KEY `IX_pos_id` (`pos_id`) USING BTREE");
			buffer.append(") ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;");
			this.jdbcTemplateTarget.update(buffer.toString());
		}
	}
}
