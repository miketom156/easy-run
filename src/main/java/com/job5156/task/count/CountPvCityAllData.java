package com.job5156.task.count;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.job5156.common.option.OptionMap;
import com.job5156.common.util.HibernateActionSlaveUtil;
import com.job5156.common.util.HibernateCountUtil;
import com.job5156.common.util.HibernateSalveBaseUtil;
import com.job5156.model.statistics.CountPvCityAll;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.joda.time.DateTime;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: DJH
 * Date: 14-11-24
 * Time: 上午11:25
 * 用于统计各个城市以及所有地点的业务数据量
 */
public class CountPvCityAllData {

    private JdbcTemplate jdbcTemplateCount = HibernateCountUtil.getJdbcTemplate();
    private JdbcTemplate jdbcTemplateBase = HibernateSalveBaseUtil.getJdbcTemplate();
    private JdbcTemplate jdbcTemplateActionSlave = HibernateActionSlaveUtil.getJdbcTemplate();
    private Map<String,List<Integer>> comIdListCache = Maps.newHashMap();

    private static Logger logger = Logger.getLogger(CountPvCityAllData.class);

    /**
     * 保存城市综合统计实体
     *
     * @param countPvCityAll
     */
    public void saveCountPvCityAll(CountPvCityAll countPvCityAll) {
        HibernateCountUtil.currentSession().save(countPvCityAll);
    }

    /**
     * 根据ip所在地统计ip数
     *
     * @param provCodeBit
     * @param cityCodeBit
     * @param start
     * @param end
     * @return
     */
    public Integer countIpByCity(String provCodeBit, String cityCodeBit, Date start, Date end) {
        String sql = "select count(distinct a.userIp) from PV_Access_IP a where  a.viewFirstTime between ? and ? ";
        List param = Lists.newArrayList();
        param.add(start);
        param.add(end);
        if (StringUtils.isNotBlank(provCodeBit) && StringUtils.isNotBlank(cityCodeBit)) {
            sql += " and a.cityCode like ? ";
            param.add(StringUtils.endsWith(cityCodeBit, "00") ? provCodeBit + "%" : cityCodeBit + "%");
        }
        Integer count = jdbcTemplateCount.queryForObject(sql, param.toArray(), Integer.class);
        return (count == null) ? 0 : count;
    }

    /**
     * 根据ip所在地统计pv数
     *
     * @param provCodeBit
     * @param cityCodeBit
     * @param start
     * @param end
     * @return
     */
    private int countViewByCity(String provCodeBit, String cityCodeBit, Date start, Date end) {
        return 0;//TODO 待PV_Access表增加cityCode字段
//        List params = Lists.newArrayList();
//        String cityStr = "";
//        if (StringUtils.isNotBlank(provCodeBit) && StringUtils.isNotBlank(cityCodeBit)) {
//            cityStr += " and a.cityCode like ? ";
//            params.add(StringUtils.endsWith(cityCodeBit, "00") ? provCodeBit + "%" : cityCodeBit + "%");
//        }
//        params.add(start);
//        params.add(end);
//        String sql = "select count(*) from  PV_Access b " +
//                " where EXISTS(select 1 from PV_Access_IP a where a.userIp = b.userIp  " + cityStr + ") and b.acceptTime between ? and ?";
//        Integer count = jdbcTemplateCount.queryForObject(sql, params.toArray(), Integer.class);
//        return (count == null) ? 0 : count;
    }


    /**
     * 查出当天有效职位总数
     *
     * @param provCodeBit
     * @param cityCodeBit
     * @return
     */
    private int countPositionCountByCity(String provCodeBit, String cityCodeBit) {
        List params = Lists.newArrayList();
    	Date nowDate = DateTime.now().withTimeAtStartOfDay().toDate();
        String sql = "SELECT COUNT(*) FROM com_position AS p JOIN com_right AS cr ON cr.com_id=p.com_id"
        		   + " WHERE cr.member_type >= 1 AND cr.member_type <= 6 AND cr.expire_date >= ?"
        		   + " AND p.pos_status > 0 AND p.del_status != -1 AND p.end_date >= ?";
        params.add(nowDate);
        params.add(nowDate);
        if (StringUtils.isNotBlank(provCodeBit) && StringUtils.isNotBlank(cityCodeBit)) {
            sql += StringUtils.endsWith(cityCodeBit, "00") ? " AND (p.work_location like '%," + provCodeBit + "%' OR p.work_location like '[" + provCodeBit + "%')" : " AND (p.work_location like '%," + cityCodeBit + "%' OR p.work_location like '[" + cityCodeBit + "%')";
        }
        Integer count = jdbcTemplateBase.queryForObject(sql, params.toArray(), Integer.class);
        return (count == null) ? 0 : count;
    }


    /**
     * 查出当天真实职位数（部分职位是导入的，不是真是发布的）
     * 自有职位
     *
     * @param provCodeBit
     * @param cityCodeBit
     * @return
     */
    private int getSelfPosition(String provCodeBit, String cityCodeBit) {
        List params = Lists.newArrayList();
    	Date nowDate = DateTime.now().withTimeAtStartOfDay().toDate();
        String sql = "SELECT COUNT(*) FROM com_position AS p INNER JOIN com_right AS cr ON cr.com_id=p.com_id"
     		   + " WHERE cr.member_type >= 2 AND cr.member_type <= 5 AND cr.expire_date >= ?"
     		   + " AND p.pos_status > 0 AND p.del_status != -1 AND p.end_date >= ?";
        params.add(nowDate);
        params.add(nowDate);
        if (StringUtils.isNotBlank(provCodeBit) && StringUtils.isNotBlank(cityCodeBit)) {
            sql += StringUtils.endsWith(cityCodeBit, "00") ? " AND (p.work_location like '%," + provCodeBit + "%' OR p.work_location like '[" + provCodeBit + "%')" : " AND (p.work_location like '%," + cityCodeBit + "%' OR p.work_location like '[" + cityCodeBit + "%')";
        }
        Integer count = jdbcTemplateBase.queryForObject(sql, params.toArray(), Integer.class);
        return (count == null) ? 0 : count;
    }

    /**
     * 计算简历注册量
     *
     * @param provCodeBit
     * @param cityCodeBit
     * @param start
     * @param end
     * @return
     */
    private int countPerRegByCity(String provCodeBit, String cityCodeBit, Date start, Date end) {
        String sql = "SELECT COUNT(*) FROM per_user WHERE create_date >= ? AND create_date <=?";
        List params = Lists.newArrayList();
        params.add(start);
        params.add(end);
        if (StringUtils.isNotBlank(provCodeBit) && StringUtils.isNotBlank(cityCodeBit)) {
            sql += " and location like ? ";
            params.add(StringUtils.endsWith(cityCodeBit, "00") ? provCodeBit + "%" : cityCodeBit + "%");
        }
        Integer count = jdbcTemplateBase.queryForObject(sql, params.toArray(), Integer.class);
        return (count == null) ? 0 : count;
    }

    /**
     * 统计指定地区的后台录入个人注册量
     * @param provCodeBit
     * @param cityCodeBit
     * @param startDateTime
     * @param endDateTime
     * @return
     */
    private Integer countPerRegBySys(String provCodeBit, String cityCodeBit, Date startDateTime, Date endDateTime) {
        String sql = "SELECT COUNT(*) FROM per_user WHERE create_date >= ? AND create_date <=? AND (admin_id IS NOT NULL AND admin_id != 0)";
        List params = Lists.newArrayList();
        params.add(startDateTime);
        params.add(endDateTime);
        if (StringUtils.isNotBlank(provCodeBit) && StringUtils.isNotBlank(cityCodeBit)) {
            sql += " and location like ? ";
            params.add(StringUtils.endsWith(cityCodeBit, "00") ? provCodeBit + "%" : cityCodeBit + "%");
        }
        Integer count = jdbcTemplateBase.queryForObject(sql, params.toArray(), Integer.class);
        return (count == null) ? 0 : count;
    }

    /**
     * 查询职位应聘量
     *
     * @param provCodeBit
     * @param cityCodeBit
     * @param start
     * @param end
     * @return
     */
    private int countResumeApply(String provCodeBit, String cityCodeBit, Date start, Date end) {
        String sql = "select count(distinct per_user_id) from com_receive WHERE create_date >= ? AND create_date <=? and receive_type = 0";
        List params = Lists.newArrayList();
        params.add(start);
        params.add(end);
        if (StringUtils.isNotBlank(provCodeBit) && StringUtils.isNotBlank(cityCodeBit)) {
            sql += " and location like ? ";
            params.add(StringUtils.endsWith(cityCodeBit, "00") ? provCodeBit + "%" : cityCodeBit + "%");
        }
        Integer count = jdbcTemplateActionSlave.queryForObject(sql, params.toArray(), Integer.class);
        return (count == null) ? 0 : count;
    }

    /**
     * 查询当日修改的个人（刷新简历）
     *
     * @param provCodeBit
     * @param cityCodeBit
     * @param start
     * @param end
     * @return
     */
    private int countPerFresh(String provCodeBit, String cityCodeBit, Date start, Date end) {
        String sql = "SELECT COUNT(*) FROM per_user WHERE fre_date between ? AND ?";
        List params = Lists.newArrayList();
        params.add(start);
        params.add(end);
        if (StringUtils.isNotBlank(provCodeBit) && StringUtils.isNotBlank(cityCodeBit)) {
            sql += " and location like ? ";
            params.add(StringUtils.endsWith(cityCodeBit, "00") ? provCodeBit + "%" : cityCodeBit + "%");
        }
        Integer count = jdbcTemplateBase.queryForObject(sql, params.toArray(), Integer.class);
        return (count == null) ? 0 : count;
    }

    /**
     * 简历审核通过
     *
     * @param provCodeBit
     * @param cityCodeBit
     * @param start
     * @param end
     * @return
     */
    private int countPerValid(String provCodeBit, String cityCodeBit, Date start, Date end) {
        String sql = "SELECT COUNT(*) FROM per_user AS u JOIN per_resume AS r ON u.res_id = r.id WHERE r.pass > 0  AND r.pass_date between ? and ? ";
        List params = Lists.newArrayList();
        params.add(start);
        params.add(end);
        if (StringUtils.isNotBlank(provCodeBit) && StringUtils.isNotBlank(cityCodeBit)) {
            if (StringUtils.endsWith(cityCodeBit, "00")) {
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
     * @param start
     * @param end
     * @return
     */
    private int countComReg(String provCodeBit, String cityCodeBit, Date start, Date end) {
        String sql = "SELECT COUNT(*) FROM com_info AS ci JOIN com_right AS cr ON cr.com_id=ci.id  WHERE (cr.member_type != 6 or cr.member_type is null) AND ci.create_date between ? and ? ";
        List params = Lists.newArrayList();
        params.add(start);
        params.add(end);
        if (StringUtils.isNotBlank(provCodeBit) && StringUtils.isNotBlank(cityCodeBit)) {
            sql += " and ci.location like ? ";
            params.add(StringUtils.endsWith(cityCodeBit, "00") ? provCodeBit + "%" : cityCodeBit + "%");
        }
        Integer count = jdbcTemplateBase.queryForObject(sql, params.toArray(), Integer.class);
        return (count == null) ? 0 : count;
    }

    /**
     * 企业收到简历数
     *
     * @param provCodeBit
     * @param cityCodeBit
     * @param start
     * @param end
     * @return
     */
    private int countPerToCom(String provCodeBit, String cityCodeBit, Date start, Date end) {
        String sql = "SELECT sum(apply_numer) FROM com_receive  WHERE create_date between ? and ?";
        List params = Lists.newArrayList();
        params.add(start);
        params.add(end);
        if (StringUtils.isNotBlank(provCodeBit) && StringUtils.isNotBlank(cityCodeBit)) {
            sql += " and location like ? ";
            params.add(StringUtils.endsWith(cityCodeBit, "00") ? provCodeBit + "%" : cityCodeBit + "%");
        }
        Integer count = jdbcTemplateActionSlave.queryForObject(sql, params.toArray(), Integer.class);
        return (count == null) ? 0 : count;
    }

    /**
     * 根据地点查询公司列表
     * @param provCodeBit
     * @param cityCodeBit
     * @return
     */
    private List<Integer> getIdListByLocation(String provCodeBit, String cityCodeBit) {
        String cahceKey = StringUtils.endsWith(cityCodeBit, "00")? provCodeBit :cityCodeBit;
        if(comIdListCache.get(cahceKey)!=null){
             return comIdListCache.get(cahceKey);
        }
        String sql;
        if(provCodeBit == null && cityCodeBit == null){
            sql = "SELECT id FROM com_info";
        } else if (StringUtils.endsWith(cityCodeBit, "00")) {
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
     * @param start
     * @param end
     * @return
     */
    private int countComViewResume(String provCodeBit, String cityCodeBit, Date start, Date end) {
        String sql = " SELECT COUNT(*) FROM per_view_log WHERE cre_time between ? and ?  ";
        List params = Lists.newArrayList();
        params.add(start);
        params.add(end);
        if(StringUtils.isNotBlank(provCodeBit) && StringUtils.isNotBlank(cityCodeBit)){
            List<Integer> comIdList = getIdListByLocation(provCodeBit, cityCodeBit);
            sql+=" AND com_id IN (" + StringUtils.join(comIdList, ',') + ")" ;
        }
        Integer count = jdbcTemplateActionSlave.queryForObject(sql, params.toArray(), Integer.class);
        return (count == null) ? 0 : count;
    }

    /**
     * 企业邀请面试
     * @param provCodeBit
     * @param cityCodeBit
     * @param start
     * @param end
     * @return
     */
    private int countComToPer(String provCodeBit, String cityCodeBit, Date start, Date end) {
        String  sql = " SELECT COUNT(id) FROM com_interview  WHERE create_date between  ? and ? ";
        List params = Lists.newArrayList();
        params.add(start);
        params.add(end);
        if(StringUtils.isNotBlank(provCodeBit) && StringUtils.isNotBlank(cityCodeBit)){
            List<Integer> comIdList = getIdListByLocation(provCodeBit, cityCodeBit);
            sql+=" AND com_id IN (" + StringUtils.join(comIdList, ',') + ")" ;
        }
        Integer count = jdbcTemplateActionSlave.queryForObject(sql, params.toArray(), Integer.class);
        return (count == null) ? 0 : count;
    }

    /**
     * 查询邀请面试企业数
     * @param provCodeBit
     * @param cityCodeBit
     * @param start
     * @param end
     * @return
     */
    private int countComCount(String provCodeBit, String cityCodeBit, Date start, Date end) {
        String  sql = " SELECT COUNT(distinct com_id) FROM com_interview  WHERE create_date between  ? and ? ";
        List params = Lists.newArrayList();
        params.add(start);
        params.add(end);
        if(StringUtils.isNotBlank(provCodeBit) && StringUtils.isNotBlank(cityCodeBit)){
            List<Integer> comIdList = getIdListByLocation(provCodeBit, cityCodeBit);
            sql+=" AND com_id IN (" + StringUtils.join(comIdList, ',') + ")" ;
        }
        Integer count = jdbcTemplateActionSlave.queryForObject(sql, params.toArray(), Integer.class);
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
        if (!org.springframework.util.StringUtils.isEmpty(provCodeBit) && !org.springframework.util.StringUtils.isEmpty(cityCodeBit)) {
            sql += " and ci.location like ? ";
            params.add(cityCodeBit.endsWith("00") ? provCodeBit + "%" : cityCodeBit + "%");
        }
        Integer count = jdbcTemplateBase.queryForObject(sql, params.toArray(), Integer.class);
        return (count == null) ? 0 : count;
    }

    /**
     *
     * @param provCodeBit
     * @param cityCodeBit
     * @param start
     * @param end
     * @return
     */
    private int countPosOut(String provCodeBit, String cityCodeBit, Date start, Date end){
        String    sql = "SELECT COUNT(*) FROM com_position AS p JOIN com_right AS cr ON cr.com_id=p.com_id  WHERE cr.member_type != 6 AND p.create_date between ? and ?";
        List params = Lists.newArrayList();
        params.add(start);
        params.add(end);
        if (StringUtils.isNotBlank(provCodeBit) && StringUtils.isNotBlank(cityCodeBit)) {
            String areaCodeBit = StringUtils.endsWith(cityCodeBit, "00") ? provCodeBit : cityCodeBit;
            sql += " AND (p.work_location like '%," + areaCodeBit + "%' OR p.work_location like '[" + areaCodeBit + "%')";
        }
        Integer count = jdbcTemplateBase.queryForObject(sql, params.toArray(), Integer.class);
        return (count == null) ? 0 : count;
    }

    /**
     * 查询真实发布职位
     * @param provCodeBit
     * @param cityCodeBit
     * @param start
     * @param end
     * @return
     */
    private int countPosOutTrue(String provCodeBit, String cityCodeBit, Date start, Date end){
        String sql = "SELECT COUNT(*) FROM com_position as p INNER JOIN com_right AS cr ON cr.com_id = p.com_id  WHERE cr.member_type != 6 AND p.create_date between ? and ? AND p.pos_status > 0";
        List params = Lists.newArrayList();
        params.add(start);
        params.add(end);
        if (StringUtils.isNotBlank(provCodeBit) && StringUtils.isNotBlank(cityCodeBit)) {
            String areaCodeBit = StringUtils.endsWith(cityCodeBit, "00") ? provCodeBit : cityCodeBit;
            sql += " AND (p.work_location like '%," + areaCodeBit + "%' OR p.work_location like '[" + areaCodeBit + "%')";
        }
        Integer count = jdbcTemplateBase.queryForObject(sql, params.toArray(), Integer.class);
        return (count == null) ? 0 : count;
    }

    public void run() {
    	long startTime = System.currentTimeMillis();
        //昨天的开始，结束日期
        Date start = DateTime.now().minusDays(1).withTimeAtStartOfDay().toDate();
        Date end = DateTime.now().minusDays(1)
                .hourOfDay().withMaximumValue()
                .minuteOfHour().withMaximumValue()
                .secondOfMinute().withMaximumValue()
                .millisOfSecond().withMaximumValue()
                .toDate();
        //统计每个城市下该日的相关数据
        for (String[] city : cityArray) {
            String provCodeBit = OptionMap.getProvCodeBits(city[1]);
            String cityCodeBit = OptionMap.getCityCodeBits(city[1]);
            CountPvCityAll countPvCityAll = new CountPvCityAll();
            countPvCityAll.setCreDate(start);
            countPvCityAll.setCityId(Integer.parseInt(city[1]));
            countPvCityAll.setIp(countIpByCity(provCodeBit, cityCodeBit, start, end));
            countPvCityAll.setPv(countViewByCity(provCodeBit, cityCodeBit, start, end));
            countPvCityAll.setPositionCount(countPositionCountByCity(provCodeBit, cityCodeBit));
            countPvCityAll.setSelfPosition(getSelfPosition(provCodeBit, cityCodeBit));
            countPvCityAll.setPerReg(countPerRegByCity(provCodeBit, cityCodeBit, start, end));
            countPvCityAll.setPerRegBySys(countPerRegBySys(provCodeBit, cityCodeBit, start, end));
            countPvCityAll.setResumeApply(countResumeApply(provCodeBit, cityCodeBit, start, end));
            countPvCityAll.setPerEdit(countPerFresh(provCodeBit, cityCodeBit, start, end));
            countPvCityAll.setPerValid(countPerValid(provCodeBit, cityCodeBit, start, end));
            countPvCityAll.setComReg(countComReg(provCodeBit, cityCodeBit, start, end));
            countPvCityAll.setPerToCom(countPerToCom(provCodeBit, cityCodeBit, start, end));
            countPvCityAll.setComViewResume(countComViewResume(provCodeBit, cityCodeBit, start, end));
            countPvCityAll.setComToPer(countComToPer(provCodeBit, cityCodeBit, start, end));
            countPvCityAll.setComCount(countComCount(provCodeBit, cityCodeBit, start, end));
            countPvCityAll.setComRightCount(countComRightCount(provCodeBit, cityCodeBit, start, end));
            countPvCityAll.setPosOut(countPosOut(provCodeBit, cityCodeBit, start, end));
            countPvCityAll.setPosOutTrue(countPosOutTrue(provCodeBit, cityCodeBit, start, end));
            saveCountPvCityAll(countPvCityAll);
            comIdListCache.clear();
            logger.info("城市综合统计：完成对【"+city[0]+"】城市的统计。");
        }
        //查询所有地区下各项数据的总值
        CountPvCityAll countPvCityAll = new CountPvCityAll();
        countPvCityAll.setCreDate(start);
        countPvCityAll.setCityId(0);
        countPvCityAll.setIp(countIpByCity(null, null, start, end));
        countPvCityAll.setPv(countViewByCity(null, null, start, end));
        countPvCityAll.setPositionCount(countPositionCountByCity(null, null));
        countPvCityAll.setSelfPosition(getSelfPosition(null, null));
        countPvCityAll.setPerReg(countPerRegByCity(null, null, start, end));
        countPvCityAll.setPerRegBySys(countPerRegBySys(null, null, start, end));
        countPvCityAll.setResumeApply(countResumeApply(null, null, start, end));
        countPvCityAll.setPerEdit(countPerFresh(null, null, start, end));
        countPvCityAll.setPerValid(countPerValid(null, null, start, end));
        countPvCityAll.setComReg(countComReg(null, null, start, end));
        countPvCityAll.setPerToCom(countPerToCom(null, null, start, end));
        countPvCityAll.setComViewResume(countComViewResume(null, null, start, end));
        countPvCityAll.setComToPer(countComToPer(null, null, start, end));
        countPvCityAll.setComCount(countComCount(null, null, start, end));
        countPvCityAll.setComRightCount(countComRightCount(null, null, start, end));
        countPvCityAll.setPosOut(countPosOut(null, null, start, end));
        countPvCityAll.setPosOutTrue(countPosOutTrue(null, null, start, end));
        saveCountPvCityAll(countPvCityAll);
        logger.info("城市综合统计：完成对全地区的统计。");
        
        long endTime = System.currentTimeMillis();
        logger.error("====城市综合统计结束！用时："+((endTime - startTime)/1000/60)+" 分钟");
    }

    /**
     * 用于重新统计企业注册量数据
     */
    public  void reRun(){
        String hqlGetAll = " from CountPvCityAll ";    //现在数据库中只有两千多条记录，不分页
        Session session = HibernateCountUtil.currentSession();
        List<CountPvCityAll> countPvCityAlls =  session.createQuery(hqlGetAll).list();
        for(CountPvCityAll countPvCity:countPvCityAlls){
             DateTime createDate =  new DateTime(countPvCity.getCreDate());
            Date start = createDate.withTimeAtStartOfDay().toDate();
            Date end = createDate
                    .hourOfDay().withMaximumValue()
                    .minuteOfHour().withMaximumValue()
                    .secondOfMinute().withMaximumValue()
                    .millisOfSecond().withMaximumValue()
                    .toDate();
            String provCodeBit = countPvCity.getCityId()==0?null:OptionMap.getProvCodeBits(countPvCity.getCityId());
            String cityCodeBit = countPvCity.getCityId()==0?null:OptionMap.getCityCodeBits(countPvCity.getCityId());
            //重新统计各天企业注册量
            countPvCity.setComReg(countComReg(provCodeBit, cityCodeBit, start, end));
            saveCountPvCityAll(countPvCity);
            if(countPvCityAlls.indexOf(countPvCity)>0&&countPvCityAlls.indexOf(countPvCity)%1000==0){
                  session.flush();
            }
            System.out.println((countPvCityAlls.indexOf(countPvCity)+1)+"/"+countPvCityAlls.size());
        }
    }


    public static void main(String args[]){
        new CountPvCityAllData().reRun();
    }

    public static String[][] cityArray = {
            {"东莞", "14010000"},
            {"佛山", "14090000"},
            {"广州", "14030000"},
            {"深圳", "14020000"},
            {"惠州", "14070000"},
            {"中山", "14040000"},
            {"江门", "14080000"},
            {"珠海", "14050000"},
            {"清远", "14110000"},
            {"顺德", "14230000"},
            {"肇庆", "14130000"},
            {"天津", "12000000"},
            {"北京", "11000000"},
            {"上海", "10000000"},
            {"武汉", "27010000"},
            {"荆州", "27040000"},
            {"咸宁", "27100000"},
            {"长沙", "28010000"},
            {"湘潭", "28020000"},
            {"衡阳", "28060000"},
            {"郴州", "28070000"},
            {"成都", "32010000"},
            {"南昌", "29010000"},
            {"南京", "16010000"},
            {"苏州", "16020000"},
            {"宁波", "15020000"},
            {"合肥", "24010000"},
            {"西安", "23010000"},
            {"永州", "28130000"},
            {"邵阳", "28120000"},
            {"广东", "14000000"},
            {"湖南", "28000000"},
            {"湖北", "27000000"},
            {"江苏", "16000000"},
            {"江西", "29000000"},
            {"陕西", "23000000"},
            {"浙江", "15000000"},
            {"重庆", "13000000"}
    };
}
