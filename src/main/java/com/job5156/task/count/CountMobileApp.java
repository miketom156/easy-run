package com.job5156.task.count;

import com.job5156.common.ApiCallTypeEnum;
import com.job5156.common.util.HibernateCountUtil;
import com.job5156.model.statistics.CountAccessModeDaily;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: DJH
 * Date: 14-11-13
 * Time: 下午2:47
 * 用于统计手机app访问
 */
public class CountMobileApp {

    private static Logger logger = Logger.getLogger(CountWeixin.class);
    private  static JdbcTemplate jdbcTemplate = HibernateCountUtil.getJdbcTemplate();
    private static final Integer RET_SUC = 1;

    /**
     * 统计前一天
     */
    public void countVistorsAndPV() {
        DateTime jodaCountDay = DateTime.now().minusDays(1).withTimeAtStartOfDay();
        String countDayStr = jodaCountDay.toString("yyyy-MM-dd");
        logger.info("开始执行"+ countDayStr +"的手机app访问统计。");

        countVistorsAndPV(jodaCountDay.toDate());
        logger.info(countDayStr + "的手机app访问统计执行完毕。");
    }

    /**
     * 统计指定天
     * @param countDay
     */
    public void countVistorsAndPV(Date countDay) {
        Date start = new DateTime(countDay).withTimeAtStartOfDay().toDate();
        Date end = new DateTime(countDay).plusDays(1).withTimeAtStartOfDay().toDate();

        //查询出一天内访问的uuid数量作为访问人数
        Integer uuidCount = getPeriodUUIDCount(start,end);
        //查出一天内接口的调用次数作为pv
        Integer totalCount = getPeriodCount(start, end);
        //查出一天内访问注册接口的次数(由于是调用接口的次数，所以不一定是注册成功的次数)
        Integer totalRegisterCount = getPeriodUUIDCountByUrl("/open/api/per_user_register.json", start, end, RET_SUC);
        //查出一天内访问刷新简历接口的次数
        Integer totalRefreshCount = getPeriodTokenCountByUrl("/open/api/per_resume_basic_update.json", start, end, RET_SUC);
        //查出一天内访问应聘接口的次数
        Integer totalApplyCount = getPeriodCountByUrl("/open/api/per_apply_pos.json", start, end, RET_SUC);
        //查出一天内访问应聘简历接口的设备数
        Integer totalApplyUUIDCount = getPeriodTokenCountByUrl("/open/api/per_apply_pos.json", start, end,RET_SUC);
        //查出一天内访问登录接口的设备数
        Integer totalLoginUUIDCount = getPeriodTokenCountByUrl("/open/api/per_user_login.json", start, end,RET_SUC);
        //插入sys_count_mobile_app表(忽略登录个数一栏)
        CountAccessModeDaily countAccessModeDaily  = new CountAccessModeDaily();
        countAccessModeDaily.setAllAccessCount(totalCount);
        countAccessModeDaily.setDeviceAccessCount(uuidCount);
        countAccessModeDaily.setApiCallType(ApiCallTypeEnum.MOBILE.getEnName());
        countAccessModeDaily.setCountDate(start);
        countAccessModeDaily.setApplicantApiCallCount(totalApplyCount);
        countAccessModeDaily.setApplicantApiCallPerCount(totalApplyUUIDCount);
        countAccessModeDaily.setResumeRefreshApiCallCount(totalRefreshCount);
        countAccessModeDaily.setResumeAddApiCallCount(totalRegisterCount);
        countAccessModeDaily.setPerLoginCount(totalLoginUUIDCount);
        save(countAccessModeDaily);
    }

    public void save(CountAccessModeDaily countAccessModeDaily){
        HibernateCountUtil.currentSession().save(countAccessModeDaily);
    }

    public Integer getCountBySql(String sql) {
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }


    /**
     * 获取时间范围内访问UUID数
     * @param start
     * @param end
     * @return
     */
    public Integer getPeriodUUIDCount(Date start ,Date end){
        String sql = "select count(distinct uuid) from log_mobile_app_usage where create_time between  '" +
                new DateTime(start).toString("yyyy-MM-dd HH:mm:ss") + "' and '" +
                new DateTime(end).toString("yyyy-MM-dd HH:mm:ss")+"'";
        return getCountBySql(sql);
    }

    public Integer getPeriodCount(Date start ,Date end){
        String sql = "select count(*) from log_mobile_app_usage where create_time between  '" +
                new DateTime(start).toString("yyyy-MM-dd HH:mm:ss") + "' and '" +
                new DateTime(end).toString("yyyy-MM-dd HH:mm:ss")+"'";
        return getCountBySql(sql);
    }

    public Integer getPeriodCountByUrl(String url, Date start ,Date end,Integer ret){
        String sql = "select count(*) from log_mobile_app_usage where create_time between  '" +
                new DateTime(start).toString("yyyy-MM-dd HH:mm:ss") + "' and '" +
                new DateTime(end).toString("yyyy-MM-dd HH:mm:ss")+"'  and url='"+url+"' and ret = " +ret+"";
        return getCountBySql(sql);
    }


    /**
     * 获取时间范围内访问token数(特定返回值)
     * @param start
     * @param end
     * @param ret
     * @return
     */
    public Integer getPeriodTokenCountByUrl(String url, Date start ,Date end,Integer ret){
        String sql = "select count(distinct token) from log_mobile_app_usage where url='"+url+"' and  create_time between '" +
                new DateTime(start).toString("yyyy-MM-dd HH:mm:ss") + "' and '" +
                new DateTime(end).toString("yyyy-MM-dd HH:mm:ss")+"'"+ " and ret = " +ret+"";
        return getCountBySql(sql);
    }

    /**
     * 获取时间范围内访问UUID数(特定返回值)
     * @param start
     * @param end
     * @param ret
     * @return
     */
    public Integer getPeriodUUIDCountByUrl(String url, Date start ,Date end,Integer ret){
        String sql = "select count(distinct uuid) from log_mobile_app_usage where url='"+url+"' and  create_time between '" +
                new DateTime(start).toString("yyyy-MM-dd HH:mm:ss") + "' and '" +
                new DateTime(end).toString("yyyy-MM-dd HH:mm:ss")+"'"+ " and ret = " +ret+"";
        return getCountBySql(sql);
    }

    public static void main(String args[]){
        new CountMobileApp().countVistorsAndPV();
    }

}
