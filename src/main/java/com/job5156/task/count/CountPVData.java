package com.job5156.task.count;

import com.google.common.collect.Lists;
import com.job5156.common.PvCitySiteEnum;
import com.job5156.common.util.HibernateCountUtil;
import com.job5156.model.count.PVCountCitySite;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: DJH
 * Date: 14-11-11
 * Time: 下午4:12
 * 用于统计城市的pv、ip数据
 */
public class CountPVData {

    private  JdbcTemplate jdbcTemplateCount = HibernateCountUtil.getJdbcTemplate();


    private static Logger logger = Logger.getLogger(CountPVData.class);

    /**
     * 根据ip所在地统计ip数
     * @param city
     * @param start
     * @param end
     * @return
     */
    public  Integer countIpByCity(int city,Date start,Date end){
        String sql  = "select count(distinct a.userIp) from PV_Access_IP a where  a.viewFirstTime between ? and ?";
        List params = Lists.newArrayList();
        params.add(start);
        params.add(end);
        if(city!=0){
        sql+=" and a.cityCode = ? ";
            params.add(city);
        }
        Integer count = jdbcTemplateCount.queryForObject(sql, params.toArray(), Integer.class);
        return (count == null) ? 0 : count;
    }

    /**
     * 根据站点统计ip
     * @param site
     * @param start
     * @param end
     * @return
     */
    public  Integer countIpBySite(int site,Date start,Date end){
        String sql  = "select count(distinct a.userIp) from PV_Access a where  a.acceptTime between ? and ?";
        List params = Lists.newArrayList();
        params.add(start);
        params.add(end);
        if(site!=0){
            sql+=" and a.site = ?  ";
            params.add(site);
        }
        Integer count = jdbcTemplateCount.queryForObject(sql, params.toArray(), Integer.class);
        return (count == null) ? 0 : count;
    }

    /**
     * 根据ip所在地统计浏览量
     */
    private  int countViewByCity( int city,Date start,Date end){
        return 0;//TODO 待PV_Access表增加cityCode字段
//        String cityStr="";
//        List params = Lists.newArrayList();
//        params.add(start);
//        params.add(end);
//        if(city!=0){
//            cityStr=" and EXISTS(select 1 from PV_Access_IP a where a.userIp = b.userIp and  a.cityCode = ? )" ;
//            params.add(city);
//        }
//        String sql = "select count(*) from  PV_Access b " +
//                " where    b.acceptTime between ? and ? "+cityStr;
//        Integer count = jdbcTemplateCount.queryForObject(sql, params.toArray(), Integer.class);
//        return (count == null) ? 0 : count;
    }


    /**
     * 所在ip城市获得
     */
    private  int countViewBySite( int site,Date start,Date end){
        String sql = "select count(*) from PV_Access a where "
                + "  a.acceptTime between ? and ?";
        List params = Lists.newArrayList();
        params.add(start);
        params.add(end);
        if(site!=0){
            sql+=" and a.site = ? ";
            params.add(site);
        }
        Integer count = jdbcTemplateCount.queryForObject(sql, params.toArray(), Integer.class);
        return (count == null) ? 0 : count;
    }

    /**
     * 插入城市/站点pv统计记录
     * @param pvCountCitySite
     */
    private  void insertPVCountCitySite(PVCountCitySite pvCountCitySite){
        String insertSql = "insert into pv_count_city_site(site_id," +
                "ip_count_city," +
                "ip_count_site," +
                "pv_count_city," +
                "pv_count_site," +
                "create_date) values(?,?,?,?,?,?)";
        jdbcTemplateCount.update(insertSql,pvCountCitySite.getSiteId(),
                pvCountCitySite.getIpCountCity()==null?0:pvCountCitySite.getIpCountCity(),
                pvCountCitySite.getIpCountSite()==null?0:pvCountCitySite.getIpCountSite(),
                pvCountCitySite.getPvCountCity()==null?0:pvCountCitySite.getPvCountCity(),
                pvCountCitySite.getPvCountSite()==null?0:pvCountCitySite.getPvCountSite(),
                pvCountCitySite.getCreateDtae());

    }


    public  void countCitySitePv() {
    	long startTime = System.currentTimeMillis();
    	
        Date start = DateTime.now().minusDays(1).withTimeAtStartOfDay().toDate();
        Date end = DateTime.now().minusDays(1)
                .hourOfDay().withMaximumValue()
                .minuteOfHour().withMaximumValue()
                .secondOfMinute().withMaximumValue()
                .millisOfSecond().withMaximumValue()
                .toDate();
        for(PvCitySiteEnum citySite: PvCitySiteEnum.values()){
        PVCountCitySite pvCountCitySite = new PVCountCitySite();
            pvCountCitySite.setSiteId(citySite.getSiteId());
            pvCountCitySite.setCreateDtae(start);
            pvCountCitySite.setIpCountCity(countIpByCity(citySite.getCityCode(),start,end));
            pvCountCitySite.setIpCountSite(countIpBySite(citySite.getSiteId(),start,end));
            pvCountCitySite.setPvCountCity(countViewByCity(citySite.getCityCode(),start,end));
            pvCountCitySite.setPvCountSite(countViewBySite(citySite.getSiteId(),start,end));
            insertPVCountCitySite(pvCountCitySite);
        }
        
        long endTime = System.currentTimeMillis();
        logger.error("====城市PV统计结束！用时："+((endTime - startTime)/1000/60)+" 分钟");
    }

}
