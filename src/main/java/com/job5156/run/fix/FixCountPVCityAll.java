package com.job5156.run.fix;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.job5156.common.option.OptionMap;
import com.job5156.common.util.HibernateActionUtil;
import com.job5156.common.util.HibernateCountUtil;
import com.job5156.common.util.HibernateSalveBaseUtil;
import com.job5156.common.util.PVAccessUtil;
import com.job5156.model.statistics.CountPvCityAll;
import com.job5156.task.count.CountPvCityAllData;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @autor: Lu Weibiao
 * Date: 2015/3/23 15:26
 * 用于修复CountPvCityAll表的数据错误
 */
public class FixCountPVCityAll {

    private static final Logger logger = Logger.getLogger(FixCountPVCityAll.class);
    private static final int CITY_CODE_MASK = 10000;//地区-市的编码掩码
    private static final int PROVINCE_CODE_MASK = 1000000;//地区-省的编码掩码
    private static final int PV_ACCESS_BAK_DAYS = 20;//PV_Access_Bak_% 备份存留的天数

    private final JdbcTemplate jdbcTemplateCount = HibernateCountUtil.getJdbcTemplate();
    private final JdbcTemplate jdbcTemplateBase = HibernateSalveBaseUtil.getJdbcTemplate();
    private final JdbcTemplate jdbcTemplateAction = HibernateActionUtil.getJdbcTemplate();
    private final Map<String,List<Integer>> comIdListCache = Maps.newHashMap();

    /**
     * @param args 传入命令
     * 支持的命令：
     * <p>
     * --fixIpAndPvFromBak={指定的修复日期} 例：--fixIpAndPvFromBak=2015-03-07
     * </p>
     * <p>
     * --fixOmissiveDays={开始日期},{结束日期} 例：--fixOmissiveDays=2015-03-23,2015-03-29
     * </p>
     * <p>
     * --fixPerRegBySys={开始日期},{结束日期} 例：--fixPerRegBySys=2015-03-23,2015-03-29
     * </p>
     */
    public static void main(String[] args){
        logger.info("城市综合统计数据修复-FixCountPVCityAll开始！");
        long startTime = System.currentTimeMillis();
        String command = null;
        if(args!= null && args.length > 0 ){
            command = args[0];
        } else return;
        try {
            if (command.startsWith("--fixIpAndPvFromBak=")) {//--fixIpAndPvFromBak=2015-03-07
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String fixDateStr = command.substring("--fixIpAndPvFromBak=".length());
                Date fixDate = null;
                fixDate = dateFormat.parse(fixDateStr);
                FixCountPVCityAll fixer = new FixCountPVCityAll();
                fixer.fixIpAndPvFromBak(fixDate);
            } else if (command.startsWith("--fixOmissiveDays=")) {//--fixOmissiveDays=2015-03-23,2015-03-29
                String[] dateStrArr = command.substring("--fixOmissiveDays=".length()).split(",");
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date startDay = dateFormat.parse(dateStrArr[0]);
                Date endDay = dateFormat.parse(dateStrArr[1]);
                new FixCountPVCityAll().fixOmissiveDays(startDay, endDay);
            } else if (command.startsWith("--fixPerRegBySys=")) {//--fixPerRegBySys=2015-03-23,2015-03-29
                String[] dateStrArr = command.substring("--fixPerRegBySys=".length()).split(",");
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date startDay = dateFormat.parse(dateStrArr[0]);
                Date endDay = dateFormat.parse(dateStrArr[1]);
                new FixCountPVCityAll().fixPerRegBySys(startDay, endDay);
            }
        } catch (Exception e){
            logger.error("执行\"" + command + "\"时出错", e);
        }finally {
            HibernateCountUtil.closeSession();
            HibernateSalveBaseUtil.closeSession();
            HibernateActionUtil.closeSession();
        }
        long endTime = System.currentTimeMillis();
        logger.info("执行城市综合统计数据修复-FixCountPVCityAll结束！用时：" + ((endTime-startTime)/1000/60.0) + "分钟");
    }

    /**
     * 修复指定日期范围内的后台录入简历注册量
     * @param startDay 开始日期
     * @param endDay 结束日期
     */
    public void fixPerRegBySys(final Date startDay, final Date endDay){
        DateTime startDateTime = new DateTime(startDay).withTimeAtStartOfDay();
        DateTime endDateTime = new DateTime(endDay).withTimeAtStartOfDay();

        String updateSql = "UPDATE count_pv_city_all SET per_reg_by_sys = ? WHERE cre_date = ?  AND city_id = ?";

        DateTime tempDay = startDateTime;
        while(!tempDay.isAfter(endDateTime)){//遍历每天
            Date tempStartOfDay = tempDay.toDate();
            Date tempEndOfDay = tempDay.plusDays(1).toDate();
            for (String[] city : CountPvCityAllData.cityArray) {//统计每个城市下该日的注册量
                try {
                    String cityId = city[1];
                    String provCodeBit = OptionMap.getProvCodeBits(city[1]);
                    String cityCodeBit = OptionMap.getCityCodeBits(city[1]);
                    int count = this.countPerRegBySys(provCodeBit, cityCodeBit, tempStartOfDay, tempEndOfDay);
                    //sql占位参数
                    Object[] params = new Object[]{
                            count,
                            tempStartOfDay,
                            cityId
                    };
                    jdbcTemplateCount.update(updateSql, params);//更新该城市该天的注册量
                } catch (Exception e) {
                    logger.error("修复城市[" + city[0] + "," + city[1] + "]在" + tempDay.toString("yyyy-MM-dd") + "的后台录入简历注册量时发生错误", e);
                }
            }
            //该天全国的注册量
            int count = this.countPerRegBySys(null, null, tempStartOfDay, tempEndOfDay);
            Object[] params = new Object[]{
                    count,
                    tempStartOfDay,
                    0
            };
            jdbcTemplateCount.update(updateSql, params);
            tempDay = tempDay.plusDays(1);//下一天
        }
    }
    /**
     * 从备份表修复指定某天各城市的ip、pv量
     * @param fixDate
     */
    public void fixIpAndPvFromBak(Date fixDate){
        DateTime today = new DateTime().withTimeAtStartOfDay();
        DateTime dateTime = new DateTime(fixDate);
        if(!dateTime.isBefore(today) || dateTime.isBefore(today.minusDays(PV_ACCESS_BAK_DAYS))){//备份表的数据只有最近20天的。
            logger.error("选择的修复日期没有数据");
            return;
        }

        String updateSql = "UPDATE count_pv_city_all SET ip = ?, pv = ? WHERE cre_date = ? AND city_id = ?";
        for(String[] city : CountPvCityAllData.cityArray){
            String cityId = city[1];
            int ipCount = countIpByCity(cityId,fixDate);
            int pvCount = countPvByCity(cityId,fixDate);
            //sql绑定参数
            Object[] params = new Object[]{
                    ipCount,
                    pvCount,
                    fixDate,
                    cityId
            };
            try {
                jdbcTemplateCount.update(updateSql, params);
            }catch (DataAccessException e){
                logger.error("更新" + city[0] + "的ip、pv量时发生错误");
            }
        }
        /*更新全国ip\pv数据*/
        int ipCount = countIpByCity(null,fixDate);
        int pvCount = countPvByCity(null,fixDate);
        //sql绑定参数
        Object[] params = new Object[]{
                ipCount,
                pvCount,
                fixDate,
                0
        };
        try {
            jdbcTemplateCount.update(updateSql, params);
        }catch (DataAccessException e){
            logger.error("更新全国的ip、pv量时发生错误");
        }
    }

    /**
     * 从备份表修复未统计的日期范围（跨天）
     * @param startDay
     * @param endDay
     */
    public void fixOmissiveDays(Date startDay, Date endDay) {
        long startTime = System.currentTimeMillis();
        DateTime curDayDateTime = new DateTime(startDay);
        DateTime endDayDateTime = new DateTime(endDay);
        while(!curDayDateTime.isAfter(endDayDateTime)){
            Date curDay = curDayDateTime.toDate();
            Date startDate = curDayDateTime.withTimeAtStartOfDay().toDate();//当天最早时间
            Date endDate =curDayDateTime.plusDays(1).withTimeAtStartOfDay().toDate();//次天最早时间

            for(String[] city : CountPvCityAllData.cityArray){//统计每个城市下该日的相关数据
                String provCodeBit = OptionMap.getProvCodeBits(city[1]);
                String cityCodeBit = OptionMap.getCityCodeBits(city[1]);

                CountPvCityAll countPvCityAll = new CountPvCityAll();
                countPvCityAll.setCreDate(curDayDateTime.toDate());
                countPvCityAll.setCityId(Integer.parseInt(city[1]));
                countPvCityAll.setIp(countIpByCity(city[1],curDay));
                countPvCityAll.setPv(countPvByCity(city[1],curDay));
                countPvCityAll.setPositionCount(countPositionCountByCity(provCodeBit, cityCodeBit, curDay));
                countPvCityAll.setSelfPosition(getSelfPosition(provCodeBit, cityCodeBit, curDay));
                countPvCityAll.setPerReg(countPerRegByCity(provCodeBit, cityCodeBit, startDate, endDate));
                countPvCityAll.setPerRegBySys(countPerRegBySys(provCodeBit, cityCodeBit, startDate, endDate));
                countPvCityAll.setResumeApply(countResumeApply(provCodeBit, cityCodeBit, startDate, endDate));
                countPvCityAll.setPerEdit(countPerFresh(provCodeBit, cityCodeBit, startDate, endDate));
                countPvCityAll.setPerValid(countPerValid(provCodeBit, cityCodeBit, startDate, endDate));
                countPvCityAll.setComReg(countComReg(provCodeBit, cityCodeBit, startDate, endDate));
                countPvCityAll.setPerToCom(countPerToCom(provCodeBit, cityCodeBit, startDate, endDate));
                countPvCityAll.setComViewResume(countComViewResume(provCodeBit, cityCodeBit, startDate, endDate));
                countPvCityAll.setComToPer(countComToPer(provCodeBit, cityCodeBit, startDate, endDate));
                countPvCityAll.setComCount(countComCount(provCodeBit, cityCodeBit, startDate, endDate));
                countPvCityAll.setComRightCount(countComRightCount(provCodeBit, cityCodeBit, startDate, endDate));
                countPvCityAll.setPosOut(countPosOut(provCodeBit, cityCodeBit, startDate, endDate));
                countPvCityAll.setPosOutTrue(countPosOutTrue(provCodeBit, cityCodeBit, startDate, endDate));
                HibernateCountUtil.currentSession().save(countPvCityAll);
                comIdListCache.clear();
                logger.info("城市综合统计：完成对【"+city[0]+"】城市的统计。");
            }
            //查询所有地区下各项数据的总值
            CountPvCityAll countPvCityAll = new CountPvCityAll();
            countPvCityAll.setCreDate(startDate);
            countPvCityAll.setCityId(0);
            countPvCityAll.setIp(countIpByCity(null,curDay));
            countPvCityAll.setPv(countPvByCity(null,curDay));
            countPvCityAll.setPositionCount(countPositionCountByCity(null, null, curDay));
            countPvCityAll.setSelfPosition(getSelfPosition(null, null, curDay));
            countPvCityAll.setPerReg(countPerRegByCity(null, null, startDate, endDate));
            countPvCityAll.setPerRegBySys(countPerRegBySys(null, null, startDate, endDate));
            countPvCityAll.setResumeApply(countResumeApply(null, null, startDate, endDate));
            countPvCityAll.setPerEdit(countPerFresh(null, null, startDate, endDate));
            countPvCityAll.setPerValid(countPerValid(null, null, startDate, endDate));
            countPvCityAll.setComReg(countComReg(null, null, startDate, endDate));
            countPvCityAll.setPerToCom(countPerToCom(null, null, startDate, endDate));
            countPvCityAll.setComViewResume(countComViewResume(null, null, startDate, endDate));
            countPvCityAll.setComToPer(countComToPer(null, null, startDate, endDate));
            countPvCityAll.setComCount(countComCount(null, null, startDate, endDate));
            countPvCityAll.setComRightCount(countComRightCount(null, null, startDate, endDate));
            countPvCityAll.setPosOut(countPosOut(null, null, startDate, endDate));
            countPvCityAll.setPosOutTrue(countPosOutTrue(null, null, startDate, endDate));
            HibernateCountUtil.currentSession().save(countPvCityAll);
            logger.info("城市综合统计：完成对全地区的统计。");

            curDayDateTime = curDayDateTime.plusDays(1);
        }
        long endTime = System.currentTimeMillis();
        logger.error("====城市综合统计结束！用时："+((endTime - startTime)/1000/60)+" 分钟");
    }

    /**
     * 从备份表修复。统计指定天的指定城市pv量
     * @param cityCode 地区编码，null表示统计全国pv量
     * @param fixDate
     * @return
     */
    private int countPvByCity(String cityCode,Date fixDate) {
        return 0;//TODO 待PV_Access表增加cityCode字段
//        List params = Lists.newArrayList();
//        Date startDateTime = new DateTime(fixDate).withTimeAtStartOfDay().toDate();
//        Date endDateTime = new DateTime(fixDate).plusDays(1).withTimeAtStartOfDay().toDate();
//
//        String pvAccessTableName = PVAccessUtil.getPVAccessTableName(fixDate);
//        String sql = "select count(*) from " + pvAccessTableName + " b where 1=1";
//        if (!StringUtils.isEmpty(cityCode)) {
//            sql += " and EXISTS(select 1 from PV_Access_IP_Bak a where a.userIp = b.userIp AND a.viewFirstTime >= ? AND a.viewFirstTime < ?";
//            params.add(startDateTime);
//            params.add(endDateTime);
//            int areaCode = Integer.parseInt(cityCode);
//            if(isProvince(areaCode)) {
//                sql += " and a.cityCode like ? ";
//                params.add(OptionMap.getProvCodeBits(cityCode) + "%");
//            } else if(isCity(areaCode)){
//                sql += " and a.cityCode like ? ";
//                params.add(OptionMap.getCityCodeBits(cityCode) + "%");
//            }
//            sql += ")";
//        }
//
//        Integer count = jdbcTemplateCount.queryForObject(sql, params.toArray(), Integer.class);
//        return (count == null) ? 0 : count.intValue();
    }

    /**
     * 从备份表修复。统计指定天的指定城市ip量
     * @param cityCode 地区编码，null表示统计全国ip总量
     * @param fixDate
     * @return
     */
    private int countIpByCity(String cityCode,Date fixDate) {
        Date startDate = new DateTime(fixDate).withTimeAtStartOfDay().toDate();
        Date endDate = new DateTime(fixDate).plusDays(1).withTimeAtStartOfDay().toDate();
        String sql = "select count(distinct a.userIp) from PV_Access_IP_Bak a where  a.viewFirstTime >= ? and a.viewFirstTime < ? ";
        List param = Lists.newArrayList();
        param.add(startDate);
        param.add(endDate);
        if(!StringUtils.isEmpty(cityCode)) {//如果为null，则统计全国。
            int areaCode = Integer.parseInt(cityCode);
            if(isProvince(areaCode)) {
                sql += " and a.cityCode like ? ";
                param.add(OptionMap.getProvCodeBits(cityCode) + "%");
            } else if(isCity(areaCode)){
                sql += " and a.cityCode like ? ";
                param.add(OptionMap.getCityCodeBits(cityCode) + "%");
            }
        }
        Integer count = jdbcTemplateCount.queryForObject(sql, param.toArray(), Integer.class);
        return (count == null) ? 0 : count.intValue();
    }

    /**
     * 根据地区编码判断是否为为市
     * @param areaCode
     * @return
     */
    private boolean isCity(int areaCode) {
        return (areaCode % PROVINCE_CODE_MASK != 0) && (areaCode % CITY_CODE_MASK == 0);
    }

    /**
     * 根据地区编码判断是否为为省份
     * @param areaCode
     * @return
     */
    private boolean isProvince(int areaCode) {
        return (areaCode % PROVINCE_CODE_MASK == 0);
    }

    /**
     * 从城市PV统计获取ip\pv量
     * @param siteId
     * @param day
     * @return
     */
    public Map<String,Object> getIpPvFromPVCountCitySite(String siteId, Date day) {
        String sql = "select ip_count_city as ipCount, pv_count_city as pvCount from pv_count_city_site a where create_date = ?";
        List param = Lists.newArrayList();
        param.add(day);
        if (!StringUtils.isEmpty(siteId)) {
            sql += " and site_id = ? ";
            param.add(siteId);
        }
        Map<String,Object> rs = jdbcTemplateCount.queryForMap(sql, param.toArray());
        return rs;
    }


    /**
     * 查出当天有效职位总数
     * @param provCodeBit
     * @param cityCodeBit
     * @return
     */
    private int countPositionCountByCity(String provCodeBit, String cityCodeBit, Date fixDay) {
        Date tomorrow = new DateTime(fixDay).plusDays(1).withTimeAtStartOfDay().toDate();
        List params = Lists.newArrayList();
        String sql = "SELECT COUNT(*) FROM com_position AS p JOIN com_right AS cr ON cr.com_id=p.com_id"
                + " WHERE cr.member_type >= 1 AND cr.member_type <= 6 AND cr.expire_date >= ?"
                + " AND p.pos_status > 0 AND p.del_status != -1 AND p.end_date >= ? AND p.create_date < ?";
        params.add(tomorrow);
        params.add(tomorrow);
        params.add(tomorrow);//统计的职位的创建日期不能晚于修复日期
        if (!StringUtils.isEmpty(provCodeBit) && !StringUtils.isEmpty(cityCodeBit)) {
            sql += cityCodeBit.endsWith("00") ? " AND (p.work_location like '%," + provCodeBit + "%' OR p.work_location like '[" + provCodeBit + "%')" : " AND (p.work_location like '%," + cityCodeBit + "%' OR p.work_location like '[" + cityCodeBit + "%')";
        }
        Integer count = jdbcTemplateBase.queryForObject(sql, params.toArray(), Integer.class);
        return (count == null) ? 0 : count;
    }


    /**
     * 查出当天真实职位数（部分职位是导入的，不是真是发布的）
     * 自有职位
     * @param provCodeBit
     * @param cityCodeBit
     * @return
     */
    private int getSelfPosition(String provCodeBit, String cityCodeBit, Date fixDay) {
        Date tomorrow = new DateTime(fixDay).plusDays(1).withTimeAtStartOfDay().toDate();
        List params = Lists.newArrayList();
        String sql = "SELECT COUNT(*) FROM com_position AS p INNER JOIN com_right AS cr ON cr.com_id=p.com_id"
                + " WHERE cr.member_type >= 2 AND cr.member_type <= 5 AND cr.expire_date >= ?"
                + " AND p.pos_status > 0 AND p.del_status != -1 AND p.end_date >= ? AND p.create_date < ?";
        params.add(tomorrow);
        params.add(tomorrow);
        params.add(tomorrow);//统计的职位的创建日期不能晚于当天
        if (!StringUtils.isEmpty(provCodeBit) && !StringUtils.isEmpty(cityCodeBit)) {
            sql += cityCodeBit.endsWith("00") ? " AND (p.work_location like '%," + provCodeBit + "%' OR p.work_location like '[" + provCodeBit + "%')" : " AND (p.work_location like '%," + cityCodeBit + "%' OR p.work_location like '[" + cityCodeBit + "%')";
        }
        Integer count = jdbcTemplateBase.queryForObject(sql, params.toArray(), Integer.class);
        return (count == null) ? 0 : count;
    }

    /**
     * 计算某天简历注册量
     * @param provCodeBit
     * @param cityCodeBit
     * @param startOfDay
     * @param endOfDay
     * @return
     */
    private int countPerRegByCity(String provCodeBit, String cityCodeBit, Date startOfDay, Date endOfDay) {
        String sql = "SELECT COUNT(*) FROM per_user WHERE create_date >= ? AND create_date < ?";
        List params = Lists.newArrayList();
        params.add(startOfDay);
        params.add(endOfDay);
        if (!StringUtils.isEmpty(provCodeBit) && !StringUtils.isEmpty(cityCodeBit)) {
            sql += " and location like ? ";
            params.add(cityCodeBit.endsWith("00") ? provCodeBit + "%" : cityCodeBit + "%");
        }
        Integer count = jdbcTemplateBase.queryForObject(sql, params.toArray(), Integer.class);
        return (count == null) ? 0 : count;
    }

    /**
     * 计算某天由后台录入的简历注册量
     * @param provCodeBit 省份高位编码
     * @param cityCodeBit 城市高位编码
     * @param startOfDay 该天最早时间点
     * @param endOfDay 该天最晚时间点
     * @return
     */
    private int countPerRegBySys(String provCodeBit, String cityCodeBit, Date startOfDay, Date endOfDay) {
        String sql = "SELECT COUNT(*) FROM per_user WHERE create_date >= ? AND create_date < ?  AND (admin_id IS NOT NULL AND admin_id != 0)";
        List params = Lists.newArrayList();
        params.add(startOfDay);
        params.add(endOfDay);
        if (!StringUtils.isEmpty(provCodeBit) && !StringUtils.isEmpty(cityCodeBit)) {
            sql += " and location like ? ";
            params.add(cityCodeBit.endsWith("00") ? provCodeBit + "%" : cityCodeBit + "%");
        }
        Integer count = jdbcTemplateBase.queryForObject(sql, params.toArray(), Integer.class);
        return (count == null) ? 0 : count;
    }

    /**
     * 查询某天职位应聘量
     *
     * @param provCodeBit
     * @param cityCodeBit
     * @param startOfDay
     * @param endOfDay
     * @return
     */
    private int countResumeApply(String provCodeBit, String cityCodeBit, Date startOfDay, Date endOfDay) {
        String sql = "select count(distinct per_user_id) from com_receive WHERE create_date >= ? AND create_date < ? and receive_type = 0";
        List params = Lists.newArrayList();
        params.add(startOfDay);
        params.add(endOfDay);
        if (!StringUtils.isEmpty(provCodeBit) && !StringUtils.isEmpty(cityCodeBit)) {
            sql += " and location like ? ";
            params.add(cityCodeBit.endsWith("00") ? provCodeBit + "%" : cityCodeBit + "%");
        }
        Integer count = jdbcTemplateAction.queryForObject(sql, params.toArray(), Integer.class);
        return (count == null) ? 0 : count;
    }

    /**
     * 查询当日修改的个人（刷新简历）
     * @param provCodeBit
     * @param cityCodeBit
     * @param startOfDay
     * @param endOfDay
     * @return
     */
    private int countPerFresh(String provCodeBit, String cityCodeBit, Date startOfDay, Date endOfDay) {
        String sql = "SELECT COUNT(*) FROM per_user WHERE fre_date >= ? AND fre_date < ?";
        List params = Lists.newArrayList();
        params.add(startOfDay);
        params.add(endOfDay);
        if (!StringUtils.isEmpty(provCodeBit) && !StringUtils.isEmpty(cityCodeBit)) {
            sql += " and location like ? ";
            params.add(cityCodeBit.endsWith("00") ? provCodeBit + "%" : cityCodeBit + "%");
        }
        Integer count = jdbcTemplateBase.queryForObject(sql, params.toArray(), Integer.class);
        return (count == null) ? 0 : count;
    }

    /**
     * 简历审核通过
     * @param provCodeBit
     * @param cityCodeBit
     * @param startOfDay
     * @param endOfDay
     * @return
     */
    private int countPerValid(String provCodeBit, String cityCodeBit, Date startOfDay, Date endOfDay) {
        String sql = "SELECT COUNT(*) FROM per_user AS u JOIN per_resume AS r ON u.res_id = r.id WHERE r.pass > 0  AND r.pass_date >= ? and r.pass_date < ? ";
        List params = Lists.newArrayList();
        params.add(startOfDay);
        params.add(endOfDay);
        if (!StringUtils.isEmpty(provCodeBit) && !StringUtils.isEmpty(cityCodeBit)) {
            if (cityCodeBit.endsWith("00")) {
                sql += " and u.location like ? ";
                params.add(provCodeBit + "%");
            } else {
                if (cityCodeBit.equals("2807")) {
                    sql += " AND (u.location LIKE ? OR u.location LIKE '2813%')";
                } else {
                    sql += " AND (u.location LIKE ?)";
                }
                params.add(cityCodeBit + "%");
            }
        }
        Integer count = jdbcTemplateBase.queryForObject(sql, params.toArray(), Integer.class);
        return (count == null) ? 0 : count;
    }

    /**
     * 获取企业注册量（过滤导入的会员）
     *   先查出所有注册量，再除去导入注册量
     * @param provCodeBit
     * @param cityCodeBit
     * @param startOfDay
     * @param endDay
     * @return
     */
    private int countComReg(String provCodeBit, String cityCodeBit, Date startOfDay, Date endDay) {
        String sql = "SELECT COUNT(*) FROM com_info AS ci JOIN com_right AS cr ON cr.com_id=ci.id  WHERE (cr.member_type != 6 or cr.member_type is null) AND ci.create_date >= ? and ci.create_date < ? ";
        List params = Lists.newArrayList();
        params.add(startOfDay);
        params.add(endDay);
        if (!StringUtils.isEmpty(provCodeBit) && !StringUtils.isEmpty(cityCodeBit)) {
            sql += " and ci.location like ? ";
            params.add(cityCodeBit.endsWith("00") ? provCodeBit + "%" : cityCodeBit + "%");
        }
        Integer count = jdbcTemplateBase.queryForObject(sql, params.toArray(), Integer.class);
        return (count == null) ? 0 : count;
    }

    /**
     * 获取企业开通会员数量（过滤导入的会员）
     * @param provCodeBit
     * @param cityCodeBit
     * @param startOfDay
     * @param endDay
     * @return
     */
    private int countComRightCount(String provCodeBit, String cityCodeBit, Date startOfDay, Date endDay) {
        String sql = "SELECT COUNT(*) FROM com_right AS cr LEFT JOIN com_info AS ci ON cr.com_id=ci.id  WHERE cr.member_type != 6 AND ((cr.create_date >= ? and cr.create_date < ?) or (cr.check_date >= ? and cr.check_date < ?)) ";
        List params = Lists.newArrayList();
        params.add(startOfDay);
        params.add(endDay);
        params.add(startOfDay);
        params.add(endDay);
        if (!StringUtils.isEmpty(provCodeBit) && !StringUtils.isEmpty(cityCodeBit)) {
            sql += " and ci.location like ? ";
            params.add(cityCodeBit.endsWith("00") ? provCodeBit + "%" : cityCodeBit + "%");
        }
        Integer count = jdbcTemplateBase.queryForObject(sql, params.toArray(), Integer.class);
        return (count == null) ? 0 : count;
    }

    /**
     * 企业收到简历数
     *
     * @param provCodeBit
     * @param cityCodeBit
     * @param startOfDay
     * @param endOfDay
     * @return
     */
    private int countPerToCom(String provCodeBit, String cityCodeBit, Date startOfDay, Date endOfDay) {
        String sql = "SELECT count(*) FROM com_receive  WHERE create_date >= ? and create_date < ?";
        List params = Lists.newArrayList();
        params.add(startOfDay);
        params.add(endOfDay);
        if (!StringUtils.isEmpty(provCodeBit) && !StringUtils.isEmpty(cityCodeBit)) {
            sql += " and location like ? ";
            params.add(cityCodeBit.endsWith("00") ? provCodeBit + "%" : cityCodeBit + "%");
        }
        Integer count = jdbcTemplateAction.queryForObject(sql, params.toArray(), Integer.class);
        return (count == null) ? 0 : count;
    }

    /**
     * 根据地点查询公司列表
     * @param provCodeBit
     * @param cityCodeBit
     * @return
     */
    private List<Integer> getIdListByLocation(String provCodeBit, String cityCodeBit) {
        String cahceKey = (cityCodeBit!=null && cityCodeBit.endsWith("00"))? provCodeBit :cityCodeBit;
        if(comIdListCache.get(cahceKey)!=null){
            return comIdListCache.get(cahceKey);
        }
        String sql = "";
        if (cityCodeBit!=null && cityCodeBit.endsWith("00")) {
            sql = "SELECT id FROM com_info WHERE location LIKE '" + provCodeBit + "%'";
        } else {
            sql = "SELECT id FROM com_info WHERE location LIKE '" + cityCodeBit + "%'";
        }
        List<Integer> comIdList = jdbcTemplateBase.queryForList(sql, Integer.class);
        comIdListCache.put(cahceKey,comIdList);
        return comIdList;
    }

    /**
     * 查询企业浏览简历数
     * @param provCodeBit
     * @param cityCodeBit
     * @param startOfDay
     * @param endOfDay
     * @return
     */
    private int countComViewResume(String provCodeBit, String cityCodeBit, Date startOfDay, Date endOfDay) {
        List<Integer> comIdList = getIdListByLocation(provCodeBit, cityCodeBit);
        String sql = " SELECT COUNT(*) FROM per_view_log WHERE cre_time >= ? and cre_time < ?  ";
        if(!StringUtils.isEmpty(provCodeBit) && !StringUtils.isEmpty(cityCodeBit) && (comIdList != null && !comIdList.isEmpty())){
            sql+=" AND com_id IN (" + org.apache.commons.lang.StringUtils.join(comIdList, ',') + ")" ;
        }
        List params = Lists.newArrayList();
        params.add(startOfDay);
        params.add(endOfDay);
        Integer count = jdbcTemplateAction.queryForObject(sql, params.toArray(), Integer.class);
        return (count == null) ? 0 : count;
    }

    /**
     * 企业邀请面试
     * @param provCodeBit
     * @param cityCodeBit
     * @param startOfDay
     * @param endOfDay
     * @return
     */
    private int countComToPer(String provCodeBit, String cityCodeBit, Date startOfDay, Date endOfDay) {
        List<Integer> comIdList = getIdListByLocation(provCodeBit, cityCodeBit);
        String  sql = " SELECT COUNT(id) FROM com_interview  WHERE create_date >=  ? and create_date < ? ";
        if(!StringUtils.isEmpty(provCodeBit) && !StringUtils.isEmpty(cityCodeBit)){
            sql+=" AND com_id IN (" + org.apache.commons.lang.StringUtils.join(comIdList, ',') + ")" ;
        }
        List params = Lists.newArrayList();
        params.add(startOfDay);
        params.add(endOfDay);
        Integer count = jdbcTemplateAction.queryForObject(sql, params.toArray(), Integer.class);
        return (count == null) ? 0 : count;
    }

    /**
     * 查询邀请面试企业数
     * @param provCodeBit
     * @param cityCodeBit
     * @param startOfDay
     * @param endOfDay
     * @return
     */
    private int countComCount(String provCodeBit, String cityCodeBit, Date startOfDay, Date endOfDay) {
        List<Integer> comIdList = getIdListByLocation(provCodeBit, cityCodeBit);
        String  sql = " SELECT COUNT(distinct com_id) FROM com_interview  WHERE create_date >=  ? and create_date < ? ";
        if(!StringUtils.isEmpty(provCodeBit) && !StringUtils.isEmpty(cityCodeBit)){
            sql+=" AND com_id IN (" + org.apache.commons.lang.StringUtils.join(comIdList, ',') + ")" ;
        }
        List params = Lists.newArrayList();
        params.add(startOfDay);
        params.add(endOfDay);
        Integer count = jdbcTemplateAction.queryForObject(sql, params.toArray(), Integer.class);
        return (count == null) ? 0 : count;
    }

    /**
     * 发布职位数
     * @param provCodeBit
     * @param cityCodeBit
     * @param startOfDay
     * @param endOfDay
     * @return
     */
    private int countPosOut(String provCodeBit, String cityCodeBit, Date startOfDay, Date endOfDay){
        String    sql = "SELECT COUNT(*) FROM com_position AS p JOIN com_right AS cr ON cr.com_id=p.com_id  WHERE cr.member_type != 6 AND p.create_date >= ? and p.create_date < ?";
        List params = Lists.newArrayList();
        params.add(startOfDay);
        params.add(endOfDay);
        if (!StringUtils.isEmpty(provCodeBit) && !StringUtils.isEmpty(cityCodeBit)) {
            String areaCodeBit = org.apache.commons.lang.StringUtils.endsWith(cityCodeBit, "00") ? provCodeBit : cityCodeBit;
            sql += " AND (p.work_location like '%," + areaCodeBit + "%' OR p.work_location like '[" + areaCodeBit + "%')";
        }
        Integer count = jdbcTemplateBase.queryForObject(sql, params.toArray(), Integer.class);
        return (count == null) ? 0 : count;
    }

    /**
     * 查询真实发布职位
     * @param provCodeBit
     * @param cityCodeBit
     * @param startOfDay
     * @param endOfDay
     * @return
     */
    private int countPosOutTrue(String provCodeBit, String cityCodeBit, Date startOfDay, Date endOfDay){
        String sql = "SELECT COUNT(*) FROM com_position as p INNER JOIN com_right AS cr ON cr.com_id = p.com_id  WHERE cr.member_type != 6 AND p.create_date >= ? and p.create_date < ? AND p.pos_status > 0";
        List params = Lists.newArrayList();
        params.add(startOfDay);
        params.add(endOfDay);
        if (!StringUtils.isEmpty(provCodeBit) && !StringUtils.isEmpty(cityCodeBit)) {
            String areaCodeBit = org.apache.commons.lang.StringUtils.endsWith(cityCodeBit, "00") ? provCodeBit : cityCodeBit;
            sql += " AND (p.work_location like '%," + areaCodeBit + "%' OR p.work_location like '[" + areaCodeBit + "%')";
        }
        Integer count = jdbcTemplateBase.queryForObject(sql, params.toArray(), Integer.class);
        return (count == null) ? 0 : count;
    }
}
