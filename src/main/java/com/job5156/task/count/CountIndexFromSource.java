package com.job5156.task.count;

import com.job5156.common.util.HibernateActionUtil;
import com.job5156.common.util.HibernateCountUtil;
import com.job5156.common.util.HibernateUtil;
import com.job5156.common.util.PVAccessUtil;
import com.job5156.model.sys.SysFromSource;
import org.apache.commons.lang.ObjectUtils;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.joda.time.DateTime;
import org.joda.time.format.ISODateTimeFormat;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;
import java.util.Map;


/**
 * 来源统计
 *
 * @author pzm
 */
public class CountIndexFromSource {
    private static Logger LOG = Logger.getLogger(CountIndexFromSource.class);
    JdbcTemplate countJdbcTemplate = HibernateCountUtil.getJdbcTemplate();
    JdbcTemplate baseJdbcTemplate = HibernateUtil.getJdbcTemplate();
    JdbcTemplate actionJdbcTemplate = HibernateActionUtil.getJdbcTemplate();
    int processLimit = 100000;
    private Date countDate;
    private String countDateString;

    public CountIndexFromSource() throws ParseException {
        setCountDate(new DateTime().plusDays(-1).toString("yyyy-M-d"));
    }

    public Date getCountDate() {
        return countDate;
    }

    public void setCountDate(String countDate) throws ParseException {
        this.countDate = new Date(new DateTime(countDate).getMillis());
        this.countDateString = new DateTime(countDate).toString(ISODateTimeFormat.date());
    }

    public void countIndexFromSourceBaseData() {
        log("START countIndexFromSourceBaseData");
        deleteFromSourceBase();
        countPVIPToFromSourceBase();
        log("END countIndexFromSourceBaseData");
    }

    public void countIndexFromSourceData() {
        log("START countIndexFromSourceData");
        String deleteSql = "DELETE FROM count_index_from_source WHERE count_date = ?";
        countJdbcTemplate.update(deleteSql, countDate);
        String insertSql = "INSERT INTO count_index_from_source (from_source_id,count_date,ip,pv,register_count,resume_refresh_count,pos_apply_count)" +
                " SELECT from_source_id,max(count_date),sum(ip),sum(pv),sum(register_count),sum(resume_refresh_count),sum(pos_apply_count)" +
                " FROM count_index_from_source_base WHERE count_date = ? GROUP BY from_source_id";
        int updateCt = countJdbcTemplate.update(insertSql, countDate);
        log("END countIndexFromSourceData! [insert count:" + updateCt + "]");
    }

    public void countIndexFromSourceGeneralData() {
        log("START countIndexFromSourceData");
        String deleteSql = "DELETE FROM count_index_from_source_general WHERE count_date = ?";
        countJdbcTemplate.update(deleteSql, countDate);

        //搜索引擎-自然搜索
        String insertSearchEngineSql = "INSERT INTO count_index_from_source_general (source_type,source_domain,search_engine,search_keyword,count_date,ip,pv,register_count,resume_refresh_count,pos_apply_count)" +
                " SELECT source_type,source_domain,max(search_engine),search_keyword,max(count_date),sum(ip),sum(pv),sum(register_count),sum(resume_refresh_count),sum(pos_apply_count)" +
                " FROM count_index_from_source_base a LEFT JOIN sys_from_source b ON a.from_source_id = b.id" +
                " WHERE count_date = ? AND source_type = ? AND spread_item_tn='' GROUP BY source_type,source_domain,search_keyword";
        log("BEGIN insertSearchEngineSpreadSql");
        int updateCt = countJdbcTemplate.update(insertSearchEngineSql, countDate, SysFromSource.SOURCE_TYPE_SEARCHENGINE);
        log("FINISH insertSearchEngineSql! [insert count:" + updateCt + "]");

        //搜索引擎-推广栏目
        String insertSearchEngineSpreadSql = "INSERT INTO count_index_from_source_general (source_type,source_domain,search_engine,spread_item_tn,count_date,ip,pv,register_count,resume_refresh_count,pos_apply_count)" +
                " SELECT source_type,source_domain,max(search_engine),spread_item_tn,max(count_date),sum(ip),sum(pv),sum(register_count),sum(resume_refresh_count),sum(pos_apply_count)" +
                " FROM count_index_from_source_base a LEFT JOIN sys_from_source b ON a.from_source_id = b.id" +
                " WHERE count_date = ? AND source_type = ? AND spread_item_tn!='' GROUP BY source_type,source_domain,spread_item_tn";
        log("BEGIN insertSearchEngineSpreadSql");
        updateCt = countJdbcTemplate.update(insertSearchEngineSpreadSql, countDate, SysFromSource.SOURCE_TYPE_SEARCHENGINE);
        log("FINISH insertSearchEngineSpreadSql! [insert count:" + updateCt + "]");

        //外部链接-自然流量
        String insertOutterlinkSql = "INSERT INTO count_index_from_source_general (source_type,source_domain,count_date,ip,pv,register_count,resume_refresh_count,pos_apply_count)" +
                " SELECT source_type,source_domain,max(count_date),sum(ip),sum(pv),sum(register_count),sum(resume_refresh_count),sum(pos_apply_count)" +
                " FROM count_index_from_source_base a LEFT JOIN sys_from_source b ON a.from_source_id = b.id" +
                " WHERE count_date = ? AND source_type = ? AND spread_item_tn='' GROUP BY source_type,source_domain";
        log("BEGIN insertOutterlinkSql");
        updateCt = countJdbcTemplate.update(insertOutterlinkSql, countDate, SysFromSource.SOURCE_TYPE_OUTTERLINK);
        log("FINISH insertOutterlinkSql! [insert count:" + updateCt + "]");

        //外部链接-推广栏目
        String insertOutterlinkSpreadSql = "INSERT INTO count_index_from_source_general (source_type,source_domain,spread_item_tn,count_date,ip,pv,register_count,resume_refresh_count,pos_apply_count)" +
                " SELECT source_type,source_domain,spread_item_tn,max(count_date),sum(ip),sum(pv),sum(register_count),sum(resume_refresh_count),sum(pos_apply_count)" +
                " FROM count_index_from_source_base a LEFT JOIN sys_from_source b ON a.from_source_id = b.id" +
                " WHERE count_date = ? AND source_type = ? AND spread_item_tn!='' GROUP BY source_type,source_domain,spread_item_tn";
        log("BEGIN insertOutterlinkSpreadSql");
        updateCt = countJdbcTemplate.update(insertOutterlinkSpreadSql, countDate, SysFromSource.SOURCE_TYPE_OUTTERLINK);
        log("FINISH insertOutterlinkSpreadSql! [insert count:" + updateCt + "]");

        //自主访问
        String insertSelfaccessSql = "INSERT INTO count_index_from_source_general (source_type,count_date,ip,pv,register_count,resume_refresh_count,pos_apply_count)" +
                " SELECT source_type,max(count_date),sum(ip),sum(pv),sum(register_count),sum(resume_refresh_count),sum(pos_apply_count)" +
                " FROM count_index_from_source_base a LEFT JOIN sys_from_source b ON a.from_source_id = b.id" +
                " WHERE count_date = ? GROUP BY source_type HAVING source_type=?";
        log("BEGIN insertSelfaccessSql");
        updateCt = countJdbcTemplate.update(insertSelfaccessSql, countDate, SysFromSource.SOURCE_TYPE_SELFACCESS);
        log("FINISH insertSelfaccessSql! [insert count:" + updateCt + "]");

        log("end countIndexFromSourceData");
    }

    private int saveFromSource(String fromSourceUrl, String fromTable) {
        SysFromSource sysFromSource = new SysFromSource();
        try {
            sysFromSource.parseFromSourceUrl(fromSourceUrl);
        } catch (Exception e) {
            LOG.warn("parseFromSourceUrl 失败,忽略此url！fromSourceUrl=[" + fromSourceUrl + "],来源于:" + fromTable + ", Exception:" + e.toString());
            LOG.debug("Exception Detail", e);
            return -1;
        }
        sysFromSource.setCreateTime(new Timestamp(System.currentTimeMillis()));
        String hql = "FROM SysFromSource as s WHERE s.sourceDomain=:sourceDomain and s.sourceAddr=:sourceAddr";
        Query query = HibernateCountUtil.currentSession().createQuery(hql);
        query.setParameter("sourceDomain", sysFromSource.getSourceDomain());
        query.setParameter("sourceAddr", sysFromSource.getSourceAddr());
        SysFromSource sysFromSourceQuery = (SysFromSource) query.uniqueResult();
        if (sysFromSourceQuery == null) {
            HibernateCountUtil.currentSession().save(sysFromSource);
        } else {
            sysFromSource = sysFromSourceQuery;
        }
        return sysFromSource.getId();
    }

    private boolean isToday() {
        return new DateTime(countDate).toString(ISODateTimeFormat.date()).equals(new DateTime(new Date(System.currentTimeMillis())).toString(ISODateTimeFormat.date()));
    }

    private void deleteFromSourceBase() {
        countJdbcTemplate.update("delete from count_index_from_source_base where count_date=?", countDate);
    }

    private void countPVIPToFromSourceBase() {
        log("BEGIN countIndexPVIPToFromSourceBase");
        String pvTable = isToday() ? "PV_Access" : PVAccessUtil.getPVAccessTableName(countDate);
        log("pvTable is " + pvTable);
        String selectPVIPSql = "SELECT fromSourceUrl,colId,count(*) AS PV,count(DISTINCT(userIp)) AS IP" +
                " FROM " + pvTable + " WHERE DATE_FORMAT(acceptTime, '%Y-%m-%d') = ? AND (CONCAT(targetDomain,targetAddr) = 'www.job5156.com/' OR  CONCAT(targetDomain,targetAddr) like 'www.job5156.com/?et%' OR CONCAT(targetDomain,targetAddr) like 'www.job5156.com/?rg%') GROUP BY fromSourceUrl,colId" +
                " ORDER BY fromSourceUrl,colId";
        String getPVIPRowSql = "select count(*) from (select 1 " +
                " FROM " + pvTable + " WHERE DATE_FORMAT(acceptTime, '%Y-%m-%d') = ? AND (CONCAT(targetDomain,targetAddr) = 'www.job5156.com/' OR  CONCAT(targetDomain,targetAddr) like 'www.job5156.com/?et%' OR CONCAT(targetDomain,targetAddr) like 'www.job5156.com/?rg%') GROUP BY fromSourceUrl,colId) a";
        int PVIPRow = countJdbcTemplate.queryForObject(getPVIPRowSql, Integer.class, countDateString);
        String insertPVIPSql = "insert into count_index_from_source_base (from_source_id,spread_item_tn,count_date,ip,pv) values (?,?,?,?,?)";
        String updatePVIPSql = "update count_index_from_source_base set ip=?,pv=? where from_source_id=? and spread_item_tn=? and count_date=?";
        long insertCount = 0;
        long updateCount = 0;
        long failCount = 0;
        for (int i = 0; i < PVIPRow; i += processLimit) {
            String limitSelectPVIPSql = selectPVIPSql + " limit ?,?";
            List<Map<String, Object>> rs = countJdbcTemplate.queryForList(limitSelectPVIPSql, countDateString, i, processLimit);
            for (Map<String, Object> fromSourceRsItem : rs) {
                String fromSourceUrl = ObjectUtils.toString(fromSourceRsItem.get("fromSourceUrl"));
                String spreadItemTn = ObjectUtils.toString(fromSourceRsItem.get("colId"));
                try {
                    int fromSourceId = saveFromSource(fromSourceUrl, "PV_Access");
                    if (fromSourceId == -1) {
                        failCount++;
                        continue;
                    }
                    Object pvCount = fromSourceRsItem.get("PV");
                    Object ipCount = fromSourceRsItem.get("IP");
                    try {
                        countJdbcTemplate.update(insertPVIPSql, fromSourceId, spreadItemTn, countDate, ipCount, pvCount);
                        insertCount++;
                    } catch (DuplicateKeyException e) {
                        countJdbcTemplate.update(updatePVIPSql, ipCount, pvCount, fromSourceId, spreadItemTn, countDate);
                        updateCount++;
                    }
                } catch (Exception e) {
                    LOG.warn(String.format("insert pvip to index_from_source_base fail! [fromSourceUrl=%s, spreadItemTn=%s]" + e.toString(), fromSourceUrl, spreadItemTn));
                    LOG.debug("Exception Detail", e);
                    failCount++;
                }
            }
        }
        log("FINISH countIndexPVIPToFromSourceBase! [all count:" + PVIPRow + ", insert count:" + insertCount + ", update count:" + updateCount + ", fail count:" + failCount + "]");
    }

    private void log(String log) {
        LOG.info("[CountIndexFromSource INFO]: " + log);
    }
}
