package com.job5156.run.fix;

import com.google.common.collect.Lists;
import com.job5156.common.PvCitySiteEnum;
import com.job5156.common.util.HibernateCountUtil;
import com.job5156.common.util.PVAccessUtil;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @autor:lwb Date: 2015/3/17 17:27
 * 从备份表统计数据以修复某天的城市PV统计里的数据。
 * 因为排程任务有时候更新的数据局部出错，可以跑这个修复某天的数据，前提是某天的备份数据还存在。
 *  */
public class FixCountCitySiteFromBak {
    private JdbcTemplate jdbcTemplateCount = HibernateCountUtil.getJdbcTemplate();
    private static final Logger logger = Logger.getLogger(FixCountCitySiteFromBak.class);

    /**
     * 入口方法
     * @param args
     * 支持的命令：
     * <p>
     * --fixByUpdate={指定的修复日期} 例：--fixByUpdate=2015-03-07
     * </p>
     * <p>
     * --fixOmissiveDays={开始日期},{结束日期} 例：--fixOmissiveDays=2015-03-23,2015-03-29
     * </p>
     */
    public static void main(String[] args){
        long startTime = System.currentTimeMillis();
        String command = null;
        if(args!= null && args.length > 0 ){
            command = args[0];
        } else return;
        logger.info("城市PV统计数据修复-FixCountCitySiteFromBak[" + command + "]开始！");
        try {
            if (command.startsWith("--fixByUpdate=")) {//--fixByUpdate=2015-03-07
                String fixDateStr = command.substring("--fixByUpdate=".length());
                FixCountCitySiteFromBak fixer = new FixCountCitySiteFromBak();
                fixer.fixByUpdate(fixDateStr);
            } else if (command.startsWith("--fixOmissiveDays=")) {//--fixOmissiveDays=2015-03-23,2015-03-29
                String[] dateStrArr = command.substring("--fixOmissiveDays=".length()).split(",");
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date startDay = dateFormat.parse(dateStrArr[0]);
                Date endDay = dateFormat.parse(dateStrArr[1]);
                new FixCountCitySiteFromBak().fixOmissiveDays(startDay, endDay);
            }
        } catch (Exception e){
            logger.error("执行\"" + command + "\"时出错", e);
        }finally {
            HibernateCountUtil.closeSession();
        }
        long endTime = System.currentTimeMillis();
        logger.info("执行城市PV统计数据数据修复-FixCountCitySiteFromBak[" + command + "]结束！用时：" + ((endTime-startTime)/1000/60.0) + "分钟");

    }

    /**
     * 更新修复某天的城市PV统计里的数据
     * @param dayStr 需要被修复数据的相应日期，形如2015-03-07
     */
    public void fixByUpdate(String dayStr){
        Date fixDate = DateTime.parse(dayStr).toDate();
        String updateSql = "UPDATE pv_count_city_site SET" +
                " pv_count_site = ?," +
                " ip_count_site = ?," +
                " pv_count_city = ?," +
                " ip_count_city = ?" +
                " WHERE create_date = '" + dayStr + "' AND site_id = ?";
        for(PvCitySiteEnum citySite: PvCitySiteEnum.values()) {
            int siteId = citySite.getSiteId();
            int cityCode = citySite.getCityCode();
            int pv_count_site = countViewBySiteFromBackup(fixDate,siteId);
            int ip_count_site = countIpBySiteFromBackup(fixDate,siteId);
            int pv_count_city = countViewByCityFromBackup(fixDate,cityCode);
            int ip_count_city = countIpByCityFromBackup(fixDate,cityCode);
            try {
                jdbcTemplateCount.update(updateSql, pv_count_site, ip_count_site, pv_count_city, ip_count_city, siteId);
            }catch (DataAccessException e){
                logger.error("更新" + citySite.getName() + "的数据时发生错误");
            }
        }
    }

    /**
     * 从备份表新增统计指定的日期范围的数据（跨天）
     * @param startDay
     * @param endDay
     */
    public void fixOmissiveDays(Date startDay, Date endDay){
        String insertSql = "INSERT INTO pv_count_city_site (pv_count_site, ip_count_site, pv_count_city, ip_count_city, create_date, site_id) VALUES(?,?,?,?,?,?)";
        List<Object[]> batchArgs = new ArrayList<>(PvCitySiteEnum.values().length);//批量sql的占位参数

        DateTime jodaStartDay = new DateTime(startDay).withTimeAtStartOfDay();
        DateTime jodaEndDay = new DateTime(endDay).withTimeAtStartOfDay();
        DateTime jodaFixDay = jodaStartDay;
        while(!jodaFixDay.isAfter(jodaEndDay)){
            Date fixDay = jodaFixDay.toDate();
            for(PvCitySiteEnum citySite: PvCitySiteEnum.values()) {
                int siteId = citySite.getSiteId();
                int cityCode = citySite.getCityCode();
                int pv_count_site = countViewBySiteFromBackup(fixDay,siteId);
                int ip_count_site = countIpBySiteFromBackup(fixDay,siteId);
                int pv_count_city = countViewByCityFromBackup(fixDay,cityCode);
                int ip_count_city = countIpByCityFromBackup(fixDay,cityCode);
                Object[] params = new Object[6];
                params[0] = pv_count_site;
                params[1] = ip_count_site;
                params[2] = pv_count_city;
                params[3] = ip_count_city;
                params[4] = fixDay;
                params[5] = siteId;
                batchArgs.add(params);
            }
            //批量更新——一天为一个周期
            try {
                jdbcTemplateCount.batchUpdate(insertSql,batchArgs);
                batchArgs.clear();
            }catch (Exception e){
                logger.error(null, e);
            }
            jodaFixDay = jodaFixDay.plusDays(1);
        }

    }

    /**
     * 从备份表统计某天某城市IP量
     * @param fixDay
     * @param cityCode
     * @return
     */
    private int countIpByCityFromBackup(Date fixDay, int cityCode) {
        Date startDate = new DateTime(fixDay).withTimeAtStartOfDay().toDate();
        Date endDate = new DateTime(fixDay).hourOfDay().withMaximumValue()
                .minuteOfHour().withMaximumValue()
                .secondOfMinute().withMaximumValue()
                .millisOfSecond().withMaximumValue()
                .toDate();
        List params = Lists.newArrayList();
        String sql  = "select count(distinct a.userIp) from PV_Access_IP_Bak a where  a.viewFirstTime between ? and ?";
        params.add(startDate);
        params.add(endDate);
        if(cityCode != PvCitySiteEnum.ALL.getCityCode()){
            sql += " and a.cityCode = ? ";
            params.add(cityCode);
        }
        Integer count = jdbcTemplateCount.queryForObject(sql, params.toArray(), Integer.class);
        return (count == null) ? 0 : count.intValue();
    }

    /**
     * 从备份表统计某天某城市PV量
     * @param fixDay
     * @param cityCode
     * @return
     */
    private int countViewByCityFromBackup(Date fixDay, int cityCode) {
        return 0;//TODO 待PV_Access表增加cityCode字段
//        String pvAccessBakTableName = PVAccessUtil.getPVAccessTableName(fixDay);
//        List params = Lists.newArrayList();
//        String sql = "select count(*) from " + pvAccessBakTableName + " b where 1=1 ";
//        if(cityCode != PvCitySiteEnum.ALL.getCityCode()){
//            sql += " and EXISTS(select 1 from PV_Access_IP_Bak a where a.userIp = b.userIp and  a.cityCode = ? )" ;
//            params.add(cityCode);
//        }
//        Integer count =  jdbcTemplateCount.queryForObject(sql, params.toArray(), Integer.class);
//        return (count == null) ? 0 : count.intValue();
    }

    /**
     * 从备份表统计某天某站点IP量
     * @param fixDay
     * @param siteId
     * @return
     */
    private int countIpBySiteFromBackup(Date fixDay, int siteId) {
        String pvAccessBakTableName = PVAccessUtil.getPVAccessTableName(fixDay);
        String sql  = "select count(distinct a.userIp) from " + pvAccessBakTableName +" a where 1=1";
        List param = Lists.newArrayList();
        if(siteId != PvCitySiteEnum.ALL.getSiteId()){
            sql+=" AND a.site = ?";
            param.add(siteId);
        }
        Integer count =  jdbcTemplateCount.queryForObject(sql, param.toArray(), Integer.class);
        return (count == null) ? 0 : count.intValue();
    }

    /**
     * 从备份表统计某天某站点PV量
     * @param fixDay
     * @param siteId
     * @return
     */
    private int countViewBySiteFromBackup(Date fixDay, int siteId) {
        String pvAccessBakTableName = PVAccessUtil.getPVAccessTableName(fixDay);
        List params = Lists.newArrayList();
        String sql = "SELECT COUNT(*) FROM " + pvAccessBakTableName + " where 1=1";
        if(siteId != PvCitySiteEnum.ALL.getSiteId()){
            sql += " AND site = ?";
            params.add(siteId);
        }
        Integer count = jdbcTemplateCount.queryForObject(sql, params.toArray(), Integer.class);
        return (count == null) ? 0 : count.intValue();
    }
}
