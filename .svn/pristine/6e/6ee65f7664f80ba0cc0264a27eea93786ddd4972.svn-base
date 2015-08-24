package com.job5156.task.count;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.job5156.common.util.HibernateCountUtil;
import com.job5156.common.util.PVAccessUtil;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.format.ISODateTimeFormat;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: pzm
 * Date: 15-03-16
 * 用途：
 * 对pv_access表按天进行备份
 */
public class BackPerBehavLogData {

    private static Logger logger = Logger.getLogger(BackPerBehavLogData.class);
    private JdbcTemplate jdbcTemplateCount = HibernateCountUtil.getJdbcTemplate();

    public static void main(String args[]) {
        try {
            new BackPerBehavLogData().run();
        } catch (Exception e) {
            logger.error("BackPerBehavLogData Fail!", e);
        }
    }

    /**
     * 从pv_access表中复制某天的数据到其备份分表（按日）中
     *
     * @param startDate
     * @param endDate
     */
    public void copyDataFromSrcToBackDaily(Date startDate, Date endDate) {
        try {
            String tbName = "per_behavior_log_" + new DateTime(startDate).toString(ISODateTimeFormat.basicDate()) + "_" + new DateTime(endDate).toString(ISODateTimeFormat.basicDate());
            String sqlCreateTable = "CREATE TABLE " + tbName + " (\n" +
                    "  `id` int(11) NOT NULL,\n" +
                    "  `cmd` varchar(30) DEFAULT NULL COMMENT '行为',\n" +
                    "  `method` varchar(100) DEFAULT NULL COMMENT '控制器方法，如com.job5156.webapp.controller.per.PerSearcherController.del',\n" +
                    "  `behav_type` int(11) DEFAULT '0' COMMENT '行为类型：0-访客行为，1-个人用户，2-企业',\n" +
                    "  `cmd_type` int(11) DEFAULT NULL COMMENT '动作类型，0-查看页面，1-动作请求',\n" +
                    "  `ip` varchar(30) DEFAULT NULL COMMENT '用户ip',\n" +
                    "  `ip_prov` varchar(20) DEFAULT NULL COMMENT 'ip-省',\n" +
                    "  `ip_city` varchar(20) DEFAULT NULL COMMENT 'ip-市',\n" +
                    "  `pcookie` varchar(50) DEFAULT NULL COMMENT '个人登录cookie，redisid',\n" +
                    "  `pid` int(11) DEFAULT NULL COMMENT '用户id',\n" +
                    "  `ccookie` varchar(50) DEFAULT NULL COMMENT '企业cookie',\n" +
                    "  `cid` int(11) DEFAULT NULL COMMENT '企业id',\n" +
                    "  `cuid` int(11) DEFAULT NULL COMMENT '企业用户id',\n" +
                    "  `uvcookie` varchar(50) DEFAULT NULL COMMENT '访客永久id',\n" +
                    "  `jscookie` varchar(50) DEFAULT NULL COMMENT '访客单次访问id',\n" +
                    "  `fdomain` varchar(100) DEFAULT NULL COMMENT '来源域名',\n" +
                    "  `faddr` varchar(1000) DEFAULT NULL COMMENT '来源地址',\n" +
                    "  `tdomain` varchar(100) DEFAULT NULL COMMENT '访问域名',\n" +
                    "  `taddr` varchar(1000) DEFAULT NULL COMMENT '访问地址',\n" +
                    "  `clientdetail` varchar(200) DEFAULT NULL COMMENT '客户端信息',\n" +
                    "  `accesstype` varchar(10) DEFAULT NULL COMMENT '访问方式：web，touch，app，wechat',\n" +
                    "  `originflag` int(11) DEFAULT '0' COMMENT '首次访问标记，0-首次访问，1-二次访问，2-普通访问',\n" +
                    "  `uuid` varchar(50) DEFAULT NULL COMMENT 'type为app时需要记录的设备id',\n" +
                    "  `hardware` varchar(50) DEFAULT NULL COMMENT 'type为app时需要记录的设备名',\n" +
                    "  `os` varchar(50) DEFAULT NULL COMMENT 'type为app时需要记录的手机操作系统',\n" +
                    "  `token` varchar(50) DEFAULT NULL,\n" +
                    "  `openid` varchar(50) DEFAULT NULL COMMENT 'type为wechat时需要记录的微信用户id',\n" +
                    "  `jsoninfo` longtext COMMENT '其他自定义属性',\n" +
                    "  `logtime` datetime DEFAULT NULL,\n" +
                    "  `spread_tn` varchar(20) DEFAULT NULL COMMENT '推广栏目编号'' AFTER `logtime',\n" +
                    "  `sem_spread_tn` varchar(20) DEFAULT NULL COMMENT 'sem推广栏目编号'' AFTER `spread_tn',\n" +
                    "  `from_source_domain` varchar(100) DEFAULT NULL COMMENT '来源域名',\n" +
                    "  `from_source_addr` varchar(1000) DEFAULT NULL COMMENT '来源地址',\n" +
                    "  `from_source_type` int(11) DEFAULT NULL COMMENT '访问来源 0-搜索引擎，1-外部链接，2-自主访问',\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  KEY `IX_cmd` (`cmd`),\n" +
                    "  KEY `IX_pid` (`pid`),\n" +
                    "  KEY `IX_uvcookie` (`uvcookie`),\n" +
                    "  KEY `IX_fdomain` (`fdomain`),\n" +
                    "  KEY `IX_tdomain` (`tdomain`),\n" +
                    "  KEY `IX_logtime` (`logtime`),\n" +
                    "  KEY `IX_spread_tn` (`spread_tn`),\n" +
                    "  KEY `IX_sem_spread_tn` (`sem_spread_tn`),\n" +
                    "  KEY `IX_from_source_domain` (`from_source_domain`),\n" +
                    "  KEY `IX_from_source_type` (`from_source_type`),\n" +
                    "  KEY `IX_behav_type` (`behav_type`),\n" +
                    "  KEY `IX_cmd_type` (`cmd_type`),\n" +
                    "  KEY `IX_ip_prov` (`ip_prov`),\n" +
                    "  KEY `IX_ip_city` (`ip_city`)\n" +
                    ") ENGINE=MyISAM DEFAULT CHARSET=utf8;";
            jdbcTemplateCount.update(sqlCreateTable);
            logger.info("创建备份表【" + tbName + "】成功!");
            String sqlInsert = "Insert into " + tbName + " Select * from per_behavior_log where logtime>=? and logtime<?";
            int effected = jdbcTemplateCount.update(sqlInsert, new DateTime(startDate).withTimeAtStartOfDay().toDate(), new DateTime(endDate).plusDays(1).withTimeAtStartOfDay().toDate());
            logger.info("备份per_behav_log表数据到分表【" + tbName + "】成功,记录数【" + effected + "】");
            String sqlDel = "delete from per_behavior_log where logtime>=? and logtime<?";
            int deled = jdbcTemplateCount.update(sqlDel, new DateTime(startDate).withTimeAtStartOfDay().toDate(), new DateTime(endDate).plusDays(1).withTimeAtStartOfDay().toDate());
            logger.info("删除per_behav_log表从" + new DateTime(startDate).toString(ISODateTimeFormat.yearMonthDay()) + "到" + new DateTime(endDate).toString(ISODateTimeFormat.yearMonthDay()) + "数据成功,记录数【" + deled + "】");
        } catch (Exception e) {
            logger.error("BackPerBehavLogData Fail!", e);
        }
    }

    public void run() {
        long startTime = System.currentTimeMillis();
        //昨天的开始，结束日期
        Date startDate = DateTime.now().minusWeeks(1).withDayOfWeek(1).toDate();
        Date endDate = DateTime.now().minusWeeks(1).withDayOfWeek(7).toDate();
        copyDataFromSrcToBackDaily(startDate, endDate);

        long endTime = System.currentTimeMillis();
        logger.error("====备份用户行为日志记录结束！用时：" + ((endTime - startTime) / 1000 / 60) + " 分钟");
    }

}
