package com.job5156.task.count;

import com.job5156.common.ApiCallTypeEnum;
import com.job5156.common.util.HibernateCountUtil;
import com.job5156.common.util.HibernateUtil;
import com.job5156.model.statistics.CountAccessModeDaily;
import com.job5156.model.statistics.SysCountMobileApp;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.jdbc.core.JdbcTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: DJH
 * Date: 14-10-8
 * Time: 上午10:50
 * 用于统计微信的访问量、访问人数
 * 每日1:40分进行统计
 */

public class CountWeixin {

    private static Logger logger = Logger.getLogger(CountWeixin.class);
    private  static JdbcTemplate jdbcTemplate = HibernateUtil.getJdbcTemplate();
    private static final Integer RET_SUC = 1;

    /**
     * 统计前一天
     */
    public void countVistorsAndPV() {
        DateTime jodaCountDay = DateTime.now().minusDays(1).withTimeAtStartOfDay();
        String countDayStr = jodaCountDay.toString("yyyy-MM-dd");

        logger.info("开始执行"+ countDayStr +"的微信访问统计。");

        countVistorsAndPV(jodaCountDay.toDate());
        logger.info(countDayStr + "的微信访问统计执行完毕。");
    }

    /**
     * 统计指定天
     * @param countDay
     */
    public void countVistorsAndPV(Date countDay){
        Date start = new DateTime(countDay).withTimeAtStartOfDay().toDate();
        Date end = new DateTime(countDay).plusDays(1).withTimeAtStartOfDay().toDate();

        //查询出一天内访问的ip数量作为访问人数
        Integer ipCount = getPeriodIpCount(start,end);
        //查出一天内接口的调用次数作为pv
        Integer totalCount = getPeriodCount(start, end);
        //查出一天内访问注册接口的次数(由于是调用接口的次数，所以不一定是注册成功的次数)
        Integer totalRegisterCount = getPeriodOpenIdCountByUrl("/api/weixin/account/register.json",start,end,RET_SUC);
        //查出一天内访问刷新简历接口的次数
        Integer totalRefreshCount = getPeriodOpenIdCountByUrl("/api/weixin/my/refresh/save.json",start,end,RET_SUC);
        //查出一天内访问应聘接口的次数
        Integer totalApplyCount = getPeriodOpenIdCountByUrl("/api/weixin/position/apply.json",start,end,RET_SUC);
        //查出一天内访问刷新简历接口的ip数
        Integer totalApplyIpCount = getPeriodOpenIdCountByUrl("/api/weixin/position/apply.json", start, end,RET_SUC);
        //插入sys_count_mobile_app表(忽略登录个数一栏)
        CountAccessModeDaily countAccessModeDaily  = new CountAccessModeDaily();
        countAccessModeDaily.setAllAccessCount(totalCount);
        countAccessModeDaily.setDeviceAccessCount(ipCount);
        countAccessModeDaily.setApiCallType(ApiCallTypeEnum.WECHAT.getEnName());
        countAccessModeDaily.setCountDate(start);
        countAccessModeDaily.setApplicantApiCallCount(totalApplyCount);
        countAccessModeDaily.setApplicantApiCallPerCount(totalApplyIpCount);
        countAccessModeDaily.setResumeRefreshApiCallCount(totalRefreshCount);
        countAccessModeDaily.setResumeAddApiCallCount(totalRegisterCount);
        save(countAccessModeDaily);
    }

    public void save(CountAccessModeDaily countAccessModeDaily){
        HibernateCountUtil.currentSession().save(countAccessModeDaily);
    }

    public Integer getCountBySql(String sql) {
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    /**
     * 获取时间范围内访问过的ip数量
     * @param start
     * @param end
     * @return
     */
    public Integer getPeriodIpCount(Date start ,Date end){
        String sql = "select count(distinct ip) from log_wexin_app_usage where  create_time between '" +
                new DateTime(start).toString("yyyy-MM-dd HH:mm:ss") + "' and '" +
                new DateTime(end).toString("yyyy-MM-dd HH:mm:ss")+"'";
        return getCountBySql(sql);
    }
    /**
     * 获取时间范围内访问次数
     * @param start
     * @param end
     * @return
     */
    public Integer getPeriodCount(Date start ,Date end){
        String sql = "select count(*) from log_wexin_app_usage where  create_time between '" +
                new DateTime(start).toString("yyyy-MM-dd HH:mm:ss") + "' and '" +
                new DateTime(end).toString("yyyy-MM-dd HH:mm:ss")+"'";
        return getCountBySql(sql);
    }

    /**
     * 获取时间范围内访问次数
     * @param start
     * @param end
     * @return
     */
    public Integer getPeriodCountByUrl(String url, Date start ,Date end){
        String sql = "select count(*) from log_wexin_app_usage where url='"+url+"' and  create_time between '" +
                new DateTime(start).toString("yyyy-MM-dd HH:mm:ss") + "' and '" +
                new DateTime(end).toString("yyyy-MM-dd HH:mm:ss")+"'";
        return getCountBySql(sql);
    }

    /**
     * 获取时间范围内访问ip数
     * @param start
     * @param end
     * @return
     */
    public Integer getPeriodIpCountByUrl(String url, Date start ,Date end){
        String sql = "select count(distinct ip) from log_wexin_app_usage where url='"+url+"' and  create_time between '" +
                new DateTime(start).toString("yyyy-MM-dd HH:mm:ss") + "' and '" +
                new DateTime(end).toString("yyyy-MM-dd HH:mm:ss")+"'";
        return getCountBySql(sql);
    }

    /**
     * 获取时间范围内访问次数(特定返回值)
     * @param start
     * @param end
     * @param ret
     * @return
     */
    public Integer getPeriodCountByUrl(String url, Date start ,Date end,Integer ret){
        String sql = "select count(*) from log_wexin_app_usage where url='"+url+"' and  create_time between '" +
                new DateTime(start).toString("yyyy-MM-dd HH:mm:ss") + "' and '" +
                new DateTime(end).toString("yyyy-MM-dd HH:mm:ss")+"'"+ " and ret = " +ret+"";
        return getCountBySql(sql);
    }

    /**
     * 获取时间范围内访问ip数(特定返回值)
     * @param start
     * @param end
     * @param ret
     * @return
     */
    public Integer getPeriodIpCountByUrl(String url, Date start ,Date end,Integer ret){
        String sql = "select count(distinct ip) from log_wexin_app_usage where url='"+url+"' and  create_time between '" +
                new DateTime(start).toString("yyyy-MM-dd HH:mm:ss") + "' and '" +
                new DateTime(end).toString("yyyy-MM-dd HH:mm:ss")+"'"+ " and ret = " +ret+"";
        return getCountBySql(sql);
    }

    /**
     * 获取时间范围内访问openid数(对应字段为uuid)(特定返回值)
     * @param start
     * @param end
     * @param ret
     * @return
     */
    public Integer getPeriodOpenIdCountByUrl(String url, Date start ,Date end,Integer ret){
        String sql = "select count(distinct uuid) from log_wexin_app_usage where url='"+url+"' and  create_time between '" +
                new DateTime(start).toString("yyyy-MM-dd HH:mm:ss") + "' and '" +
                new DateTime(end).toString("yyyy-MM-dd HH:mm:ss")+"'"+ " and ret = " +ret+" " +
                " and uuid <> '' ";
        return getCountBySql(sql);
    }

    public static void main(String args[]){
        new CountWeixin().countVistorsAndPV();
    }

}
