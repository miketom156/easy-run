package com.job5156.run.log;

import com.google.common.collect.Lists;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.apache.commons.lang.StringUtils;

import java.sql.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: DJH
 * Date: 14-11-10
 * Time: 下午2:01
 * 用于删除超过一年的搜索关键字日志备份
 */
public class RunDelBackKeyWord {


    public static final String BackSearchKeywordTbName = "back_search_pos_keyword";
    private static final Logger logger = Logger.getLogger(RunDelBackKeyWord.class);
    private static final String defaultDateFormat = "yyyyMM";

    public static void main(String args[]) {
        logger.error("开始删除一年前的关键字搜索日志备份数据。");
        doInJdbcTransactionWithCon(new JdbcTask<Object>() {
            @Override
            public Object execute(Connection con) {
                //获取所有分区
                List<String> parts = getAllPartition(con);
                if (parts != null) {
                    //删除一年以前的分区
                    DateTime yesterdayAYearBefore = DateTime.now().minusDays(1).minusYears(1)
                            .hourOfDay().withMaximumValue()
                            .minuteOfHour().withMaximumValue()
                            .secondOfMinute().withMaximumValue()
                            .millisOfSecond().withMaximumValue();
                    //按分区名升序排列（日期）
                    Collections.sort(parts, new Comparator<String>() {
                        @Override
                        public int compare(String o1, String o2) {
                            if (StringUtils.isNotBlank(o1) && StringUtils.isNotBlank(o2)) {
                                return o1.compareTo(o2);
                            }
                            return 0;
                        }
                    });
                    String yearMonthStr = yesterdayAYearBefore.toString(defaultDateFormat);
                    for (String part : parts) {
                        if (part.compareTo("p"+yearMonthStr) < 0) {
                            delPartition(con, part);
                        } else if (part.compareTo("p"+yearMonthStr) == 0 &&
                                yesterdayAYearBefore.toString("yyyyMMdd").equals(yesterdayAYearBefore.dayOfMonth().withMaximumValue().toString("yyyyMMdd"))) {//如果是当月最后一天 ，那么删除这月前以及这月前的分区即完成删除
                            delPartition(con, part);
                            return null;
                        }
                    }
                    //删除一年以前的数据
                    delBackLogBeforeDate(con, yesterdayAYearBefore.toDate());
                } else {
                    logger.error("出现数据表分区数为0的情况。");
                }
                return null;
            }
        });
        logger.error("结束删除一年前的关键字搜索日志备份数据。");
    }

    public static void delBackLogBeforeDate(Connection con ,Date date){
        String sql = "delete from "+BackSearchKeywordTbName+" where cre_date <= ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setObject(1, date);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    logger.error(e.getMessage(), e);
                }
            }
        }
    }

    /**
     * 删除对应名称的分区
     *
     * @param con
     * @param partName
     */
    public static void delPartition(Connection con, String partName) {
        String sql = "ALTER TABLE "+BackSearchKeywordTbName+" DROP PARTITION "+partName;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    logger.error(e.getMessage(), e);
                }
            }
        }
    }


    /**
     * 获取当前备份表的所有分区
     *
     * @param con
     * @return
     */
    public static List<String> getAllPartition(Connection con) {
        String sql = "select partition_name from information_schema.PARTITIONS where table_name = ?";
        List parts = Lists.newArrayList();
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setObject(1, BackSearchKeywordTbName);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                parts.add(rs.getString(1));
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    logger.error(e.getMessage(), e);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    logger.error(e.getMessage(), e);
                }
            }
        }
        return parts;
    }

    /**
     * 获取jdbc链接
     *
     * @return
     */
    private static Connection getCountJDBCCon() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://192.168.2.232/CountDB?zeroDateTimeBehavior=convertToNull",
                    "jobbest", "poiLKJmnb@~!@");
//            Connection c = DriverManager.getConnection("jdbc:mysql://192.168.8.29/Jobemail?zeroDateTimeBehavior=convertToNull",
//                    "jobquery", "jobquery");
            return c;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    public static <T> T doInJdbcTransactionWithCon(JdbcTask<T> task) {
        Connection con = null;
        try {
            con = getCountJDBCCon();
            con.setAutoCommit(false);
            T result = task.execute(con);
            con.commit();
            return result;
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        } finally {
            //关闭数据库连接
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    logger.error(e.getMessage(), e);
                }
            }
        }
        return null;
    }

    public static abstract class JdbcTask<T> {
        public String getSql() {
            return null;
        }

        public T execute(Connection con) {
            return null;
        }

        public T execute(PreparedStatement preparedStatement) {
            return null;
        }

        public static void fillParamToPs(PreparedStatement preparedStatement, List params) {
            int i = 1;
            if (org.apache.commons.collections.CollectionUtils.isNotEmpty(params)) {
                for (Object param : params) {
                    try {
                        preparedStatement.setObject(i++, param);
                    } catch (SQLException e) {
                        logger.error(e.getMessage(), e);
                    }
                }
            }
        }
    }
}
