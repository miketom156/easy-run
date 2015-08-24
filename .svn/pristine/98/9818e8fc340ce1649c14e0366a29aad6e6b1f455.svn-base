package com.job5156.run.log;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import com.google.common.collect.Sets;
import com.job5156.common.util.HibernateCountUtil;

/**
 * Created with IntelliJ IDEA.
 * User: DJH
 * Date: 14-6-21
 * Time: 上午10:50
 * To change this template use File | Settings | File Templates.
 */
public class RunBackSearchKeyWord {

    public static final String BackSearchKeywordTbName = "back_search_pos_keyword";
    public static final int defaultPageSize = 10000;
    private static final Logger logger = Logger.getLogger(RunBackSearchKeyWord.class);

    private static Connection getCountJDBCCon() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://192.168.2.232/CountDB?zeroDateTimeBehavior=convertToNull",
                    "jobbest","poiLKJmnb@~!@");
            return c;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }


    /**
     * 检查是否存在当月数据的分区
     * 不存在的话则增加
     * 分区名称规则： p+年月（yyyyMM）
     *
     * @param yearMonth
     * @param countCon
     */
    public static void createMonthPartitionIfNotExist(String yearMonth, Connection countCon) {
        String checkPartitionSql = "    SELECT  * " +
                "    FROM INFORMATION_SCHEMA.PARTITIONS " +
                "   WHERE TABLE_NAME='" + BackSearchKeywordTbName + "' and PARTITION_NAME = 'p" + yearMonth + "' ";
        Statement statement = null;
        ResultSet rsCheckExist = null;
        try {
            statement = countCon.createStatement();
            rsCheckExist = statement.executeQuery(checkPartitionSql);
            boolean existed = rsCheckExist.next();
            if (!existed) {
                DateTime dateTime = DateTime.parse(yearMonth, DateTimeFormat.forPattern("yyyyMM")).plusMonths(1);
                String addPartitionSql = "ALTER TABLE " + BackSearchKeywordTbName + "  ADD PARTITION (PARTITION p" + yearMonth + " VALUES LESS THAN (" +
                        dateTime.toString("yyyyMM")
                        + "))";
                statement.execute(addPartitionSql);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        } finally {
            if (rsCheckExist != null) {
                try {
                    rsCheckExist.close();
                } catch (SQLException e) {
                    logger.error(e.getMessage(), e);
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    logger.error(e.getMessage(), e);
                }
            }
        }
    }

    public static void backSearchKeyWord() {
        Session sessionBase = HibernateCountUtil.currentSession();
        Connection countCon = getCountJDBCCon();
        try {
            countCon.setAutoCommit(false);
            long b = new Date().getTime();
            backAllByPage(sessionBase, countCon);
            //备份每个月的数据
            countCon.commit();
            logger.info("备份事务提交");
            logger.info("关键字日志备份初始化完成，耗时【" + (new Date().getTime() - b) + "】毫秒");

        } catch (SQLException e) {
            try {
                countCon.rollback();
            } catch (SQLException e1) {
                logger.error(e1.getMessage(), e1);
            }
            logger.error(e.getMessage(), e);
        } finally {
            try {
                countCon.close();
            } catch (SQLException e) {
                logger.error(e.getMessage(), e);
            }
        }
    }

    public static void backAllByPage(Session sessionBase, Connection countCon) throws SQLException {
        String oriTbName = "log_search_pos_keyword";//原表名
        //查出5月份最大id
        String yearMonth = "201405";
        DateTime dateTime = DateTime.parse(yearMonth, DateTimeFormat.forPattern("yyyyMM"));
        dateTime = dateTime.withDayOfMonth(dateTime.dayOfMonth().getMaximumValue())//最大日期
                .withHourOfDay(23).withMinuteOfHour(59).withSecondOfMinute(59);
        Query maxIdQueryOriTb = sessionBase.createSQLQuery("select max(id) from " + oriTbName + " where cre_date <= '" + dateTime.toString("yyyy-MM-dd HH:mm:ss") + "'");
        Integer maxId = ((BigInteger) maxIdQueryOriTb.uniqueResult()).intValue();
        //查出当前备份库中最大id，没有当然为0
        Statement maxIdBackStatement = countCon.createStatement();
        ResultSet rsMaxIdBack = maxIdBackStatement.executeQuery("select max(id) from " + BackSearchKeywordTbName);
        Integer maxIdBack = 0;
        if (rsMaxIdBack.next()) {
            maxIdBack = rsMaxIdBack.getInt(1);
            maxIdBack = maxIdBack == null ? 0 : maxIdBack;
        }
        maxIdBack = maxIdBack == null ? 0 : maxIdBack;
        Integer curRangeMaxId = maxIdBack + 10000;//当前查询范围id
        //每次范围为当前备份最大id+10000查询（若大于5月最大id为5月最大id）（不一定10000条）
        Query listDataQuery = sessionBase.createSQLQuery("select id,keyword,pos_type,cre_date from " + oriTbName + " where id >  ? and id <= ?  ");
        //插入每页的每条数据（每条插入前检查是否存在当月的分区，并且更新备份库的最大id）
        String insertSql = "insert into " + BackSearchKeywordTbName + " values(?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = countCon.prepareStatement(insertSql);
            Set<String> yearMonthCache = Sets.newHashSet();
            while (maxIdBack < maxId) {
                listDataQuery.setParameter(0, maxIdBack);
                listDataQuery.setParameter(1, curRangeMaxId);
                long b = new Date().getTime();
                List<Object[]> data = listDataQuery.list();
                logger.info("查询【" + data.size() + "】条数据,耗时【" + (new Date().getTime() - b) + "】毫秒");
                sessionBase.clear();
                Integer tempMaxId = batchInsertData(data, countCon, ps, yearMonthCache);
                maxIdBack = tempMaxId == 0 ? curRangeMaxId : tempMaxId;
                curRangeMaxId = maxIdBack + 10000>maxId?maxId:maxIdBack + 10000;
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    public static Integer batchInsertData(List<Object[]> data, Connection countCon, PreparedStatement ps, Set<String> yearMonthCache) throws SQLException {
        if (CollectionUtils.isEmpty(data)) {
            return 0;
        }
        Integer curMaxId = 0;
        for (int i = 0; i < data.size(); i++) {
            //插入数据
            //数据库表的设定也不允许任何列为空
            if (data.get(i).length < 4 || data.get(i)[1] == null || data.get(i)[2] == null
                    || data.get(i)[3] == null || data.get(i)[0] == null) {
                logger.error("搜索关键字备份 - 数据插入：存在空值！");
                continue;
            }
            Integer curId = ((BigInteger) data.get(i)[0]).intValue();
            Date curDate = (Date) data.get(i)[3];
            String curYearMonth = new DateTime(curDate).toString("yyyyMM");
            if (!yearMonthCache.contains(curYearMonth)) {
                yearMonthCache.add(curYearMonth);
                //如果当前id大于等于5月最大id，结束
                for (DateTime temp = DateTime.parse("201401", DateTimeFormat.forPattern("yyyyMM"));
                     temp.toString("yyyyMM").compareTo(curYearMonth) < 0; temp = temp.plusMonths(1)) {//如果出现比现在的月份还小的分区不存在的情况，也创建
                    String tempCurString = temp.toString("yyyyMM");
                    if (!yearMonthCache.contains(tempCurString)) {
                        yearMonthCache.add(tempCurString);
                        createMonthPartitionIfNotExist(tempCurString, countCon);
                    }
                }
                createMonthPartitionIfNotExist(curYearMonth, countCon);
            }
            ps.setObject(1, curId);
            ps.setObject(2, data.get(i)[1]);
            ps.setObject(3, data.get(i)[2]);
            ps.setObject(4, curDate);
            ps.addBatch();
            if (curId > curMaxId) {
                curMaxId = curId;
            }
            if ((i + 1) == data.size()) {
                long b = new Date().getTime();
                ps.executeBatch();
                ps.clearBatch();
                logger.info("插入【" + data.size() + "】条数据,耗时【" + (new Date().getTime() - b) + "】毫秒");
            }
        }
        return curMaxId;
    }

    public static void main(String[] args) {
        backSearchKeyWord();
    }

}
