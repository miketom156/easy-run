package com.job5156.task.init;

import com.job5156.common.util.HibernateActionSlaveUtil;
import com.job5156.common.util.HibernateQueryUtil;
import com.job5156.common.util.HibernateUtil;
import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>初始化转换企业会员数据</p>
 * Date: 2015/7/21 10:12
 *
 * @version 1.0
 * @author: lu Weibiao
 */
public class InitComRight {
    private static final Logger logger = Logger.getLogger(InitComRight.class);
    private static final String[] datePatternArr = new String[]{"yyyy-MM-dd", "yyyy-MM-dd#HH:mm:ss"};

    private JdbcTemplate jdbcTemplateBase = HibernateUtil.getJdbcTemplate();
    private JdbcTemplate jdbcTemplateQuery = HibernateQueryUtil.getJdbcTemplate();
    private JdbcTemplate jdbcTemplateActionSlave = HibernateActionSlaveUtil.getJdbcTemplate();

    /**
     * 入口方法
     * @param args
     * args[0] : 企业会员开通日期时间下限，格式yyyy-MM-dd#HH:mm:ss，"-1"表示不限制
     * args[1] : 企业会员开通日期时间上限，格式yyyy-MM-dd#HH:mm:ss，"-1"表示不限制
     * 例：InitComRight 2015-06-24 2015-07-21#15:29:45
     */
    public static void main(String[] args){
        Date startDate;
        Date endDate;
        if (args == null || args.length == 0) {
            return;
        }
        try {
            if (args.length == 2){
                if(args[0].equals("-1")){
                    startDate = null;
                } else{
                    startDate = DateUtils.parseDate(args[0], datePatternArr);
                }
                if(args[1].equals("-1")){
                    endDate = null;
                } else {
                    endDate = DateUtils.parseDate(args[1], datePatternArr);
                }
                InitComRight initer = new InitComRight();
                initer.initVipPosRefreshNum(startDate, endDate);
                initer.initVipSmsNum(startDate, endDate);
            }
        }catch (Exception e){
            logger.error("初始化转换企业会员数据出错", e);
        }finally {
            HibernateUtil.closeSession();
            HibernateQueryUtil.closeSession();
            HibernateActionSlaveUtil.closeSession();
        }
    }

    /**
     * 初始化指定时间范围内开通的企业VIP会员的职位刷新点数
     * 365 x 3次刷新机会/天/个职位 x （当前正在招聘企业发布职位数量最多的100家企业的职位数量平均值)
     * @param startDate 企业会员开通日期时间下限，null表示不限制
     * @param endDate 企业会员开通日期时间上限，null表示不限制
     */
    public void initVipPosRefreshNum(final Date startDate, final Date endDate){
        final int avgPosNum = countAvgPosNumOfComNow();
        final int posFreshNum = 365 * 3 * avgPosNum;
        String updateSql = "UPDATE com_right SET pos_refresh_num = ? WHERE 1=1" +
                " AND member_type >= 1 AND member_type <= 6" +
                " AND (pos_refresh_num IS NULL OR pos_refresh_num = 0) ";
        final List paramList = new ArrayList();
        paramList.add(posFreshNum);
        if(startDate != null){
            updateSql += " AND valid_date >= ?";
            paramList.add(startDate);
        }
        if(endDate != null){
            updateSql += " AND valid_date <= ?";
            paramList.add(endDate);
        }
        jdbcTemplateBase.update(updateSql, paramList.toArray());
    }

    /**
     * 统计当前正在招聘企业发布职位数量最多的100家企业的职位数量平均值
     * @return
     */
    public int countAvgPosNumOfComNow() {
        final String sql = "SELECT AVG(t.posNum) FROM (SELECT COUNT(*) AS posNum FROM pos_brief GROUP BY comId ORDER BY posNum DESC LIMIT 100) AS t";
        final Double count = jdbcTemplateQuery.queryForObject(sql, Double.class);
        return (int)Math.ceil(count);
    }

    /**
     * 初始化指定时间范围内开通的企业VIP会员的短信通知点数
     * 365 x (当前正在招聘企业中每天发送短信数量最多的50家企业的短信发送数量平均值)
     * @param startDate 企业会员开通日期时间下限，null表示不限制
     * @param endDate 企业会员开通日期时间上限，null表示不限制
     */
    public void initVipSmsNum(final Date startDate, final Date endDate){
        final int avgSmsNum = countDailyAvgSmsNumOfCom();
        final int smsNum = 365 * avgSmsNum;
        String updateSql = "UPDATE com_right SET max_msg_num = ? WHERE 1=1" +
                " AND member_type >= 1 AND member_type <= 6" +
                " AND (max_msg_num IS NULL OR max_msg_num = 0) ";
        final List paramList = new ArrayList();
        paramList.add(smsNum);
        if(startDate != null){
            updateSql += " AND valid_date >= ?";
            paramList.add(startDate);
        }
        if(endDate != null){
            updateSql += " AND valid_date <= ?";
            paramList.add(endDate);
        }
        jdbcTemplateBase.update(updateSql, paramList.toArray());
    }

    /**
     * 当前正在招聘企业中每天发送短信数量最多的50家企业的短信发送数量平均值
     * 取一个月的数据作为统计样本
     * @return
     */
    public int countDailyAvgSmsNumOfCom() {
        final String sql = "SELECT AVG(t.smsNum) FROM" +
                "(SELECT COUNT(*) AS smsNum FROM com_msg_log WHERE" +
                " create_date BETWEEN ? AND ? GROUP BY com_id ORDER BY smsNum DESC LIMIT 50" +
                ") AS t";//每天发送短信数量最多的50家企业的短信发送数量

        final DateTime endDay = DateTime.now().minusDays(1).withTimeAtStartOfDay();
        final DateTime startDay = endDay.minusDays(30);
        DateTime countDay = startDay;
        double dailyNumSum = 0.0;
        while(!countDay.isAfter(endDay)) {
            final Date startDate = countDay.toDate();
            final Date endDate = countDay.plusDays(1).toDate();
            final Object[] params = new Object[]{startDate, endDate};
            final Double rs = jdbcTemplateActionSlave.queryForObject(sql, params, Double.class);
            if(rs != null) {
                dailyNumSum += rs;
            }

            countDay = countDay.plusDays(1);
        }

        final int dailyNum = (int)Math.ceil(dailyNumSum / 30);//取一个月的平均值
        return dailyNum;
    }
}
