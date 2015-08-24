package com.job5156.task;

import java.util.Map;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.job5156.common.util.HibernateActionUtil;
import com.job5156.common.util.HibernateCountUtil;

/**
 * 职位发布分析
 * Created by pzm on 2015/1/20.
 */
public class PosPublishAnalyse {
    JdbcTemplate actionJdbcTemplate = HibernateActionUtil.getJdbcTemplate();
    JdbcTemplate countJdbcTemplate = HibernateCountUtil.getJdbcTemplate();
    private Logger logger = Logger.getLogger(PosPublishAnalyse.class);

    public void statisPosViewCount(String countDateStr) {
        logger.info(String.format("[%s] start! countdate:%s", Thread.currentThread().getStackTrace()[1].getMethodName(), countDateStr));
        DateTime countDate = DateTime.parse(countDateStr, DateTimeFormat.forPattern("yyyy-MM"));
        String startDate = countDate.withDayOfMonth(1).toString("yyyy-MM-dd");
        String endDate = countDate.minusMonths(-1).withDayOfMonth(1).toString("yyyy-MM-dd");
        String sql = "SELECT " +
                " pos_id, " +
                " max(com_id) AS com_id, " +
                " count(*) AS view_count " +
                "FROM " +
                " log_access_pos " +
                "WHERE " +
                " create_date >=? " +
                "AND create_date <? " +
                "GROUP BY " +
                " pos_id;";
        int insertSucCount = 0, updateSucCount = 0, failCount = 0;
        for (Map<String, Object> row : actionJdbcTemplate.queryForList(sql, startDate, endDate)) {
            String pos_id = row.get("pos_id").toString();
            String com_id = row.get("com_id").toString();
            long view_count = (long) row.get("view_count");

            String insertSql = "insert into pos_publish_statis (pos_id,com_id,view_count,count_date) values (?,?,?,?)";
            String updateSql = "update pos_publish_statis set view_count=? where pos_id=? and count_date=?";
            try {
                countJdbcTemplate.update(insertSql, pos_id, com_id, view_count, countDateStr);
                insertSucCount++;
            } catch (DataAccessException dae) {
                if (dae.toString().contains("Duplicate entry")) {
                    try {
                        countJdbcTemplate.update(updateSql, view_count, pos_id, countDateStr);
                        updateSucCount++;
                    } catch (Exception e) {
                        logger.error(String.format("[%s] update view_count fail!", Thread.currentThread().getStackTrace()[1].getMethodName()), e);
                        failCount++;
                    }
                } else {
                    logger.error(String.format("[%s] insert view_count fail!", Thread.currentThread().getStackTrace()[1].getMethodName()), dae);
                    failCount++;
                }
            }
        }
        logger.info(String.format("[%s] end! insert_count:%s, update_count:%s, fail_count:%s", Thread.currentThread().getStackTrace()[1].getMethodName(), insertSucCount, updateSucCount, failCount));
    }

    public void statisPosDeliverCount(String countDateStr) {
        logger.info(String.format("[%s] start! countdate:%s", Thread.currentThread().getStackTrace()[1].getMethodName(), countDateStr));
        DateTime countDate = DateTime.parse(countDateStr, DateTimeFormat.forPattern("yyyy-MM"));
        String startDate = countDate.withDayOfMonth(1).toString("yyyy-MM-dd");
        String endDate = countDate.minusMonths(-1).withDayOfMonth(1).toString("yyyy-MM-dd");
        int insertSucCount = 0, updateSucCount = 0, failCount = 0;
        String sql = "SELECT " +
                " pos_id, " +
                " max(com_id) AS com_id, " +
                " count(distinct(per_user_id)) AS deliver_count " +
                "FROM " +
                " com_receive " +
                "WHERE " +
                " create_date >=? " +
                "AND create_date <? " +
                "GROUP BY " +
                " pos_id;";
        for (Map<String, Object> row : actionJdbcTemplate.queryForList(sql, startDate, endDate)) {
            String pos_id = row.get("pos_id").toString();
            String com_id = row.get("com_id").toString();
            long deliver_count = (long) row.get("deliver_count");
            String insertSql = "insert into pos_publish_statis (pos_id,com_id,resume_count,count_date) values (?,?,?,?)";
            String updateSql = "update pos_publish_statis set resume_count=? where pos_id=? and count_date=?";
            try {
                countJdbcTemplate.update(insertSql, pos_id, com_id, deliver_count, countDateStr);
                insertSucCount++;
            } catch (DataAccessException dae) {
                if (dae.toString().contains("Duplicate entry")) {
                    try {
                        countJdbcTemplate.update(updateSql, deliver_count, pos_id, countDateStr);
                        updateSucCount++;
                    } catch (Exception e) {
                        logger.error(String.format("[%s] update deliver_count fail!", Thread.currentThread().getStackTrace()[1].getMethodName()), e);
                        failCount++;
                    }
                } else {
                    logger.error(String.format("[%s] insert deliver_count fail!", Thread.currentThread().getStackTrace()[1].getMethodName()), dae);
                    failCount++;
                }
            }
        }
        logger.info(String.format("[%s] end! insert_count:%s, update_count:%s, fail_count:%s", Thread.currentThread().getStackTrace()[1].getMethodName(), insertSucCount, updateSucCount, failCount));
    }

/*    public void cleanUpLogAccessPos(String cleanBeforeDate) {
        logger.info(String.format("[%s] start!", Thread.currentThread().getStackTrace()[1].getMethodName()));
        String sql = "DELETE FROM log_access_pos WHERE create_date < ?";
        int count = baseJdbcTemplate.update(sql, cleanBeforeDate);
        logger.info(String.format("[%s] clean posaccess count:%s!", Thread.currentThread().getStackTrace()[1].getMethodName(), count));
        logger.info(String.format("[%s] end!", Thread.currentThread().getStackTrace()[1].getMethodName()));
    }*/
}
