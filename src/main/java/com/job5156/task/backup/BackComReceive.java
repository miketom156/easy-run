package com.job5156.task.backup;

import org.joda.time.DateTime;
import org.springframework.dao.EmptyResultDataAccessException;

import com.job5156.common.util.HibernateActionUtil;
import com.job5156.common.util.HibernateBackupActionUtil;

/**
 * <p>
 * 备份并清理5156action库中的企业收到简历表
 * </p>
 * 
 * <pre>
 * 1、只保留一年数据
 * 2、一年前数据保存到按年份来分的表中，然后清理
 * </pre>
 *
 * Date:2015-5-20 下午6:01:31
 * @author leo
 * @version 1.0
 */
public class BackComReceive extends BackAndCleanData implements Runnable{

	public BackComReceive(){
		this.sourceTableName = "com_receive";
		this.sourceDateFieldName = "create_date";
		this.deleteSourceFlag = false;
		this.backupEndDate = DateTime.now().minusYears(1).secondOfDay().withMinimumValue().toDate();
		this.jdbcTemplateSource = HibernateActionUtil.getJdbcTemplate();
		this.jdbcTemplateTarget = HibernateBackupActionUtil.getJdbcTemplate();
	}
	
	@Override
	public void run() {
		logger.info("Start To Backup ComReceive Data");
		this.backupAndCleanData(BackupType.YEAR);
	}

	public static void main(String[] args) {
		new Thread(new BackComReceive()).start();
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
			buffer.append("`com_id` int(10) NOT NULL,");
			buffer.append("`per_user_id` int(10) NOT NULL,");
			buffer.append("`resume_id` int(10) NOT NULL,");
			buffer.append("`pos_id` int(10) NOT NULL,");
			buffer.append("`user_name` varchar(100) DEFAULT NULL,");
			buffer.append("`pos_name` varchar(100) DEFAULT NULL COMMENT '职位名称',");
			buffer.append("`gender` tinyint(2) DEFAULT NULL,");
			buffer.append("`age` tinyint(2) DEFAULT NULL,");
			buffer.append("`degree` tinyint(2) DEFAULT NULL COMMENT '学历',");
			buffer.append("`school_name` varchar(100) DEFAULT NULL COMMENT '校学名称',");
			buffer.append("`location` int(10) unsigned DEFAULT '0' COMMENT '现所在地',");
			buffer.append("`speciality` varchar(100) DEFAULT NULL COMMENT '专业',");
			buffer.append("`job_location` varchar(100) DEFAULT NULL COMMENT '希望工作地区',");
			buffer.append("`email` varchar(100) DEFAULT NULL COMMENT '邮箱号',");
			buffer.append("`mix_info` text COMMENT '混合信息',");
			buffer.append("`apply_numer` tinyint(2) DEFAULT NULL COMMENT '应聘数次',");
			buffer.append("`mark` varchar(100) DEFAULT NULL COMMENT '不符合/符合/待定/已面试/待邀请/已邀请/自定义标签',");
			buffer.append("`remark` varchar(500) DEFAULT NULL COMMENT '评语内容',");
			buffer.append("`sys_recommend` int(10) DEFAULT '0' COMMENT '1后台推荐的简历',");
			buffer.append("`read_flag` tinyint(2) DEFAULT NULL COMMENT '阅读状态1已阅读',");
			buffer.append("`del_status` tinyint(2) DEFAULT '0' COMMENT '-1已删除',");
			buffer.append("`receive_type` tinyint(2) DEFAULT '0' COMMENT '类型（1为视频,其它为网络应聘）',");
			buffer.append("`send_flag` tinyint(2) DEFAULT NULL COMMENT '发送标志1-邀请面试，2-待考虑，3-婉言谢绝',");
			buffer.append("`buy_flag` tinyint(2) DEFAULT '0' COMMENT '是否购买了此份简历（0:否 1：是）',");
			buffer.append("`create_date` datetime DEFAULT NULL COMMENT '创建时间',");
			buffer.append("`update_date` datetime DEFAULT NULL COMMENT '更新时间',");
			buffer.append("`jobyear_type` int(10) DEFAULT NULL COMMENT '工作经验',");
			buffer.append("`keywords` varchar(500) DEFAULT NULL COMMENT '简历关键字',");
			buffer.append("`filter_flag` tinyint(4) DEFAULT '0' COMMENT '简历是否被过滤（0:否 1：是）',");
			buffer.append("`match_rat` float DEFAULT '0' COMMENT '简历匹配度-百分比显示',");
			buffer.append("PRIMARY KEY (`id`),");
			buffer.append("KEY `idx_comid` (`com_id`) USING BTREE,");
			buffer.append("KEY `idx_peruserId` (`per_user_id`) USING BTREE,");
			buffer.append("KEY `idx_resume_id` (`resume_id`) USING BTREE,");
			buffer.append("KEY `idx_pos_id` (`pos_id`) USING BTREE,");
			buffer.append("KEY `idx_user_name` (`user_name`) USING BTREE,");
			buffer.append("KEY `idx_comid_resumeId` (`com_id`,`resume_id`) USING BTREE,");
			buffer.append("KEY `idx_email` (`email`) USING BTREE,");
			buffer.append("KEY `idx_createDate` (`create_date`) USING BTREE,");
			buffer.append("KEY `idx_location` (`location`) USING BTREE,");
			buffer.append("KEY `idx_update_date` (`update_date`) USING BTREE");
			buffer.append(") ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;");
			this.jdbcTemplateTarget.update(buffer.toString());
		}
	}
}
