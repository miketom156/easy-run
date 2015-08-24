package com.job5156.run.fix;

import com.job5156.common.ApiCallTypeEnum;
import com.job5156.common.util.HibernateCountUtil;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Function:
 * 触屏版访问方式统计修复
 * @autor:lwb Date: 2015/3/18 9:33
 */
public class FixCountTouch {
    private static Logger logger = Logger.getLogger(FixCountCitySiteFromBak.class);
    private static final Integer RET_SUC = 1;
    private JdbcTemplate jdbcTemplateCount = HibernateCountUtil.getJdbcTemplate();


    /**
     * 修复"yyyy-MM-dd"~"yyyy-MM-dd"的触屏版用户注册数
     * @param args
     */
    public static void main(String[] args){
        try {
            if (args.length == 2) {
                FixCountTouch task = new FixCountTouch();
                String startDay = args[0];
                String endDay = args[1];
                task.fixPerRegCount(startDay, endDay);
            } else {
                logger.error("参数不正确");
            }
        }catch (Exception e){
            HibernateCountUtil.closeSession();
        }
    }
    /**
     * 重新统计以修复某日期范围内触屏版用户注册数
     * 这里对应count_access_mode_daily表 resume_add_api_call_count字段
     * @param startDayStr
     * @param endDayStr
     */
    public void fixPerRegCount(String startDayStr, String endDayStr){
        logger.info("====修复" + startDayStr + "~" + endDayStr + "触屏版用户注册数开始！");
        long startTime = System.currentTimeMillis();
        Date startDate = DateTime.parse(startDayStr).withTimeAtStartOfDay().toDate();
        Date endDate = DateTime.parse(endDayStr).hourOfDay().withMaximumValue()
                .minuteOfHour().withMaximumValue()
                .secondOfMinute().withMaximumValue()
                .millisOfSecond().withMaximumValue()
                .toDate();

        String updateSql = "UPDATE count_access_mode_daily SET resume_add_api_call_count = ? " +
                "where count_date = ? and api_call_type = ?";
        List<Map<String,Object>> perRegCounts = getPerRegCountGroupByDay(startDate, endDate);
        for(Map<String,Object> countMap : perRegCounts){
            Long count = (Long)countMap.get("count");
            String countDate = (String)countMap.get("countDate");
            jdbcTemplateCount.update(updateSql,count,countDate,ApiCallTypeEnum.TOUCH.getEnName());

        }
        long endTime = System.currentTimeMillis();
        logger.info("====修复" + startDayStr + "~" + endDayStr + "触屏版用户注册数结束！用时"+((endTime - startTime)/1000/60)+" 分钟");
    }

    /**
     * 按某天分组统计触屏版用户注册数
     * @param startDate
     * @param endDate
     * @return
     */
    private List<Map<String, Object>> getPerRegCountGroupByDay(Date startDate, Date endDate) {
        String sql = "SELECT count(*) as count ,DATE_FORMAT(t.create_time,'%Y-%m-%d') as countDate FROM log_mobile_web_usage t where" +
                " t.create_time BETWEEN ? AND ?" +
                " AND t.ret = ?" +
                " AND (url = ? or url = ?)" +
                " GROUP BY DATE_FORMAT(t.create_time,'%Y-%m-%d')";
        Object[] params = new Object[]{
                startDate,
                endDate,
                RET_SUC,
                "/touch/act/reg/step1/save",
                "/touch/reg/save"
        };
        List<Map<String,Object>> countsGroupByDate = jdbcTemplateCount.queryForList(sql,params);
        return countsGroupByDate;
    }
}
