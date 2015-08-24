package com.job5156.task.count;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.job5156.common.util.HibernateCountUtil;
import com.job5156.common.util.PVAccessUtil;

/**
 * Created with IntelliJ IDEA.
 * User: DJH
 * Date: 14-12-5
 * Time: 上午8:21
 * 用途：
 * 对pv_access表进行备份
 * 对pv_access_ip表进行备份
 * 对PV_Access_ClientDetail进行更新
 * 清空相关表格的数据
 *
 * 分别对应旧版几个任务调度的类：
 *    1.CountPVAccessBak
 *    2.CountPVAccessIPBak
 *    3.CountPVCleanData
 *
 */
public class BackPvAccessData {

    private JdbcTemplate jdbcTemplateCount = HibernateCountUtil.getJdbcTemplate();

    private static Logger logger = Logger.getLogger(BackPvAccessData.class);


    /**
     * 从pv_access表中复制某天的数据到其备份表中
     *
     * @param start
     * @param end
     */
    public void copyDataFromSrcToBack(Date start, Date end) {
        String sql = " INSERT INTO PV_Access_Bak(userIp,site,fromDomain,fromAddr,targetDomain,targetAddr,clientDetail,userType,userId,jsCookie,acceptTime,colId,flag,fromSourceUrl)"
                + " SELECT userIp,site,fromDomain,fromAddr,targetDomain,targetAddr,clientDetail,userType,userId,jsCookie,acceptTime,colId,flag,fromSourceUrl from PV_Access where acceptTime between ? and ? ";
        int effected = jdbcTemplateCount.update(sql, start, end);
        logger.info("备份Pv_Access表至PV_Access_Bak成功,记录数【" + effected + "】");
    }

    /**
     * 从pv_access表中复制某天的数据到其备份分表（按日）中
     *
     * @param start
     * @param end
     */
    public void copyDataFromSrcToBackDaily(Date start, Date end) {
        //分表形式的备份，分为20个表
        String tbName = PVAccessUtil.getPVAccessTableName(start);
        String sqlDel = " delete from " + tbName;
        String sqlInsert = " insert into " + tbName + "(userIp,site,fromDomain,fromAddr,targetDomain,targetAddr,clientDetail,userType,userId,jsCookie,acceptTime,colId,flag,fromSourceUrl)"
                + " select userIp,site,fromDomain,fromAddr,targetDomain,targetAddr,clientDetail,userType,userId,jsCookie,acceptTime,colId,flag,fromSourceUrl from PV_Access where acceptTime between ? and ? ";
        int effected = jdbcTemplateCount.update(sqlDel);
        logger.info("清空Pv_Access备份表【" + tbName + "】,记录数【" + effected + "】");
        effected = jdbcTemplateCount.update(sqlInsert, start, end);
        logger.info("备份Pv_Access表数据到分表【" + tbName + "】成功,记录数【" + effected + "】");
    }

    /**
     * 根据新成成的分表备份数据，重新生成PV_Access_ClientDetail的对应数据（删除后插入）
     *
     * @param start
     * @param end
     */
    public void regenerateClientDetail(Date start, Date end) {
        long tableIndex = PVAccessUtil.getPVAccessTableIndex(start);
        String tbName = PVAccessUtil.getPVAccessTableName(start);
        String sqlDel = " delete from PV_Access_ClientDetail where flag = "+tableIndex;
        String sqlInsert = " insert into PV_Access_ClientDetail(userIp, clientDetail, flag) "
                + " select userIp, clientDetail, "+tableIndex+" from "+tbName+" group by userIp";
        int effected = jdbcTemplateCount.update(sqlDel);
        logger.info("删除PV_Access_ClientDetail表中对应【" + tbName + "】表的数据,记录数【" + effected + "】");
        effected = jdbcTemplateCount.update(sqlInsert);
        logger.info("生成PV_Access_ClientDetail表中对应【" + tbName + "】表的数据,记录数【" + effected + "】");
    }

    /**
     * 对pvaccess表备份并生成相关 PV_Access_ClientDetail中的数据
     * (需要去报这一方法限于countfromsource跑)
     * @param start
     * @param end
     */
    public void backPvAccess(Date start, Date end) {
        copyDataFromSrcToBack(start,  end);
        copyDataFromSrcToBackDaily(start,  end);
        regenerateClientDetail(start,  end);
    }

    /**
     * 备份pv_access_ip表
     * @param start
     * @param end
     */
    public void backPvAccessIp(Date start, Date end){
        //查出最大最小id
        String sqlCount = "select max(p.id) as maxId,min(p.id) as minId from PV_Access_IP p where p.viewFirstTime  between ? and ? ";
        Map<String,Object> countResult = jdbcTemplateCount.queryForObject(sqlCount, new RowMapper<Map<String,Object>>() {
            @Override
            public Map<String,Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
                Map<String,Object> temp = Maps.newHashMap();
                temp.put("maxId",rs.getLong("maxId"));
                temp.put("minId", rs.getLong("minId"));
                return temp;
            }
        },start, end);
        Long maxId = (Long) countResult.get("maxId");
        Long minId = (Long) countResult.get("minId");
        if(maxId==null||minId==null||minId==0||maxId==0||maxId<=minId){
            logger.info("备份PV_Access_IP数据：最大最小id不符合要求，忽略当前任务，maxId【"+maxId+"】，minId【"+minId+"】");
             return;
        }
        int total = 0;
        for(Long startId = minId;startId<=maxId;startId+=10000){
            Long endId = startId+9999;
            endId = endId>maxId?maxId:endId;
            String sql = "insert into PV_Access_IP_Bak( userIp," +"  cityCode, " + "  cityAddr, " +"  countNum, " +"  viewFirstTime, " +"  viewLastTime, " + "  fromUrl, " +"  targetUrl, " + "  currentUrl, " + "  viewNum, " +"  siteId ) " +
                    "  select userIp," +"  cityCode, " + "  cityAddr, " +"  countNum, " +"  viewFirstTime, " +"  viewLastTime, " + "  fromUrl, " +"  targetUrl, " + "  currentUrl, " + "  viewNum, " +"  siteId from " +
                    " PV_Access_IP p where p.id between ? and ? ";
            int effected = jdbcTemplateCount.update(sql,startId,endId);
            total+=effected;
            logger.info("备份PV_Access_IP数据中，该批次备份【"+effected+"】条记录");
        }
        logger.info("备份PV_Access_IP数据完成，总共备份备份【"+total+"】条记录");
    }

    /**
     * 这方法清空PV_Access_IP，PV_Access等表的数据清空
     * (需要确保RunCountPvData方法先于跑)
     */
    public void cleanData(){
    	long startTime = System.currentTimeMillis();
    	
        List<String> sqlBatchs = Lists.newArrayList();
        //--清除每天的访问记录
        String sql1 = "delete from PV_Access where acceptTime < '"+DateTime.now().withTimeAtStartOfDay().toString("yyyy-MM-dd hh:mm:ss")+"'";
        sqlBatchs.add(sql1);
        //--清除每天的访问IP记录
        String sql2 = "delete from PV_Access_IP where viewFirstTime < '"+DateTime.now().withTimeAtStartOfDay().toString("yyyy-MM-dd hh:mm:ss")+"'";
        sqlBatchs.add(sql2);
        //--清除备份的访问记录
        String sql3 = "delete from PV_Access_Bak where acceptTime < '"+DateTime.now().minusDays(60).withTimeAtStartOfDay().toString("yyyy-MM-dd hh:mm:ss")+"'";
        sqlBatchs.add(sql3);
        //--清除备份的访问IP记录
        String sql4 = "delete from PV_Access_IP_Bak where viewFirstTime < '"+DateTime.now().minusDays(20).withTimeAtStartOfDay().toString("yyyy-MM-dd hh:mm:ss")+"'";
        sqlBatchs.add(sql4);
        //--清除回头客记录
        String sql5 = "delete from PV_BackUser where acceptTime < '"+DateTime.now().minusDays(20).withTimeAtStartOfDay().toString("yyyy-MM-dd hh:mm:ss")+"'";
        sqlBatchs.add(sql5);
        //--清除来路记录
        String sql6 = "delete from PV_ComeFrom where acceptTime < '"+DateTime.now().minusDays(20).withTimeAtStartOfDay().toString("yyyy-MM-dd hh:mm:ss")+"'";
        sqlBatchs.add(sql6);
        //--清除来路域名记录
        String sql7 = "delete from PV_FromDomain where acceptTime < '"+DateTime.now().minusDays(20).withTimeAtStartOfDay().toString("yyyy-MM-dd hh:mm:ss")+"'";
        sqlBatchs.add(sql7);
        //--清除浏览深度
        String sql8 = "delete from PV_LookDepth where acceptTime < '"+DateTime.now().minusDays(20).withTimeAtStartOfDay().toString("yyyy-MM-dd hh:mm:ss")+"'";
        sqlBatchs.add(sql8);
        //--清除非job5156来源记录
        String sql9 = "delete from PV_FromSource where acceptTime < '"+DateTime.now().minusDays(20).withTimeAtStartOfDay().toString("yyyy-MM-dd hh:mm:ss")+"'";
        sqlBatchs.add(sql9);
        //--清除ISP提供商记录
        String sql10 = "delete from PV_ISP_Offer where acceptTime < '"+DateTime.now().minusDays(90).withTimeAtStartOfDay().toString("yyyy-MM-dd hh:mm:ss")+"'";
        sqlBatchs.add(sql10);
        //--清除页面浏览记录
        String sql11 = "delete from PV_PageLook where acceptTime < '"+DateTime.now().minusDays(20).withTimeAtStartOfDay().toString("yyyy-MM-dd hh:mm:ss")+"'";
        sqlBatchs.add(sql11);
        jdbcTemplateCount.batchUpdate(sqlBatchs.toArray(new String[sqlBatchs.size()]));
        
        long endTime = System.currentTimeMillis();
        logger.info("完成【"+DateTime.now().minusDays(1).toString("yyyy-MM-dd")+"】数据清空工作");
        logger.error("====清理每天访问数据结束！用时："+((endTime - startTime)/1000/60)+" 分钟");
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
        //对pvaccess表备份并生成相关 PV_Access_ClientDetail中的数据
        backPvAccess(start,  end);
        //备份pvaccessip数据
        backPvAccessIp( start,  end);
        
        long endTime = System.currentTimeMillis();
        logger.error("====备份每天访问记录、IP记录结束！用时："+((endTime - startTime)/1000/60)+" 分钟");
    }

    public static void main(String args[]) {
        new BackPvAccessData().run();
//        System.out.println(PVAccessUtil.getPVAccessTableIndex(DateTime.now().minusDays(1).toDate()));
    }

}
