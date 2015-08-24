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
public class CountFromSource {
    private static Logger LOG = Logger.getLogger(CountFromSource.class);
    JdbcTemplate countJdbcTemplate = HibernateCountUtil.getJdbcTemplate();
    JdbcTemplate baseJdbcTemplate = HibernateUtil.getJdbcTemplate();
    JdbcTemplate actionJdbcTemplate = HibernateActionUtil.getJdbcTemplate();
    int processLimit = 100000;
    private Date countDate;
    private String countDateString;

    public CountFromSource() throws ParseException {
        setCountDate(new DateTime().plusDays(-1).toString("yyyy-M-d"));
    }

    public Date getCountDate() {
        return countDate;
    }

    public void setCountDate(String countDate) throws ParseException {
        this.countDate = new Date(new DateTime(countDate).getMillis());
        this.countDateString = new DateTime(countDate).toString(ISODateTimeFormat.date());
    }

    public void countFromSourceBaseData() {
        log("START countFromSourceBaseData");
        deleteFromSourceBase();
        countPVIPToFromSourceBase();
        countRegCountToFromSourceBase();
        countPosApplyCountToFromSourceBase();
        countResumeRefreshCountToFromSourceBase();
        log("END countFromSourceBaseData");
    }

    public void countFromSourceData() {
        log("START countFromSourceData");
        String deleteSql = "DELETE FROM count_from_source WHERE count_date = ?";
        countJdbcTemplate.update(deleteSql, countDate);
        String insertSql = "INSERT INTO count_from_source (from_source_id,count_date,ip,pv,register_count,resume_refresh_count,pos_apply_count)" +
                " SELECT from_source_id,max(count_date),sum(ip),sum(pv),sum(register_count),sum(resume_refresh_count),sum(pos_apply_count)" +
                " FROM count_from_source_base WHERE count_date = ? GROUP BY from_source_id";
        int updateCt = countJdbcTemplate.update(insertSql, countDate);
        log("END countFromSourceData! [insert count:" + updateCt + "]");
    }

    public void countFromSourceGeneralData() {
        log("START countFromSourceData");
        String deleteSql = "DELETE FROM count_from_source_general WHERE count_date = ?";
        countJdbcTemplate.update(deleteSql, countDate);

        //搜索引擎-自然搜索
        String insertSearchEngineSql = "INSERT INTO count_from_source_general (source_type,source_domain,search_engine,search_keyword,count_date,ip,pv,register_count,resume_refresh_count,pos_apply_count)" +
                " SELECT source_type,source_domain,max(search_engine),search_keyword,max(count_date),sum(ip),sum(pv),sum(register_count),sum(resume_refresh_count),sum(pos_apply_count)" +
                " FROM count_from_source_base a LEFT JOIN sys_from_source b ON a.from_source_id = b.id" +
                " WHERE count_date = ? AND source_type = ? AND spread_item_tn='' GROUP BY source_type,source_domain,search_keyword";
        log("BEGIN insertSearchEngineSpreadSql");
        int updateCt = countJdbcTemplate.update(insertSearchEngineSql, countDate, SysFromSource.SOURCE_TYPE_SEARCHENGINE);
        log("FINISH insertSearchEngineSql! [insert count:" + updateCt + "]");

        //搜索引擎-推广栏目
        String insertSearchEngineSpreadSql = "INSERT INTO count_from_source_general (source_type,source_domain,search_engine,spread_item_tn,count_date,ip,pv,register_count,resume_refresh_count,pos_apply_count)" +
                " SELECT source_type,source_domain,max(search_engine),spread_item_tn,max(count_date),sum(ip),sum(pv),sum(register_count),sum(resume_refresh_count),sum(pos_apply_count)" +
                " FROM count_from_source_base a LEFT JOIN sys_from_source b ON a.from_source_id = b.id" +
                " WHERE count_date = ? AND source_type = ? AND spread_item_tn!='' GROUP BY source_type,source_domain,spread_item_tn";
        log("BEGIN insertSearchEngineSpreadSql");
        updateCt = countJdbcTemplate.update(insertSearchEngineSpreadSql, countDate, SysFromSource.SOURCE_TYPE_SEARCHENGINE);
        log("FINISH insertSearchEngineSpreadSql! [insert count:" + updateCt + "]");

        //外部链接-自然流量
        String insertOutterlinkSql = "INSERT INTO count_from_source_general (source_type,source_domain,count_date,ip,pv,register_count,resume_refresh_count,pos_apply_count)" +
                " SELECT source_type,source_domain,max(count_date),sum(ip),sum(pv),sum(register_count),sum(resume_refresh_count),sum(pos_apply_count)" +
                " FROM count_from_source_base a LEFT JOIN sys_from_source b ON a.from_source_id = b.id" +
                " WHERE count_date = ? AND source_type = ? AND spread_item_tn='' GROUP BY source_type,source_domain";
        log("BEGIN insertOutterlinkSql");
        updateCt = countJdbcTemplate.update(insertOutterlinkSql, countDate, SysFromSource.SOURCE_TYPE_OUTTERLINK);
        log("FINISH insertOutterlinkSql! [insert count:" + updateCt + "]");

        //外部链接-推广栏目
        String insertOutterlinkSpreadSql = "INSERT INTO count_from_source_general (source_type,source_domain,spread_item_tn,count_date,ip,pv,register_count,resume_refresh_count,pos_apply_count)" +
                " SELECT source_type,source_domain,spread_item_tn,max(count_date),sum(ip),sum(pv),sum(register_count),sum(resume_refresh_count),sum(pos_apply_count)" +
                " FROM count_from_source_base a LEFT JOIN sys_from_source b ON a.from_source_id = b.id" +
                " WHERE count_date = ? AND source_type = ? AND spread_item_tn!='' GROUP BY source_type,source_domain,spread_item_tn";
        log("BEGIN insertOutterlinkSpreadSql");
        updateCt = countJdbcTemplate.update(insertOutterlinkSpreadSql, countDate, SysFromSource.SOURCE_TYPE_OUTTERLINK);
        log("FINISH insertOutterlinkSpreadSql! [insert count:" + updateCt + "]");

        //自主访问
        String insertSelfaccessSql = "INSERT INTO count_from_source_general (source_type,count_date,ip,pv,register_count,resume_refresh_count,pos_apply_count)" +
                " SELECT source_type,max(count_date),sum(ip),sum(pv),sum(register_count),sum(resume_refresh_count),sum(pos_apply_count)" +
                " FROM count_from_source_base a LEFT JOIN sys_from_source b ON a.from_source_id = b.id" +
                " WHERE count_date = ? GROUP BY source_type HAVING source_type=?";
        log("BEGIN insertSelfaccessSql");
        updateCt = countJdbcTemplate.update(insertSelfaccessSql, countDate, SysFromSource.SOURCE_TYPE_SELFACCESS);
        log("FINISH insertSelfaccessSql! [insert count:" + updateCt + "]");

        log("end countFromSourceData");
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
        countJdbcTemplate.update("delete from count_from_source_base where count_date=?", countDate);
    }

    private void countPVIPToFromSourceBase() {
        log("BEGIN countPVIPToFromSourceBase");
        String pvTable = isToday() ? "PV_Access" : PVAccessUtil.getPVAccessTableName(countDate);
        log("pvTable is " + pvTable);
        String selectPVIPSql = "SELECT fromSourceUrl,colId,count(*) AS PV,count(DISTINCT(userIp)) AS IP" +
                " FROM " + pvTable + " WHERE DATE_FORMAT(acceptTime, '%Y-%m-%d') = ? AND targetDomain like '%.job5156.com' GROUP BY fromSourceUrl,colId" +
                " ORDER BY fromSourceUrl,colId";
        String getPVIPRowSql = "select count(*) from (select 1 " +
                " FROM " + pvTable + " WHERE DATE_FORMAT(acceptTime, '%Y-%m-%d') = ? AND targetDomain like '%.job5156.com'  GROUP BY fromSourceUrl,colId) a";
        int PVIPRow = countJdbcTemplate.queryForObject(getPVIPRowSql, Integer.class, countDateString);
        String insertPVIPSql = "insert into count_from_source_base (from_source_id,spread_item_tn,count_date,ip,pv) values (?,?,?,?,?)";
        String updatePVIPSql = "update count_from_source_base set ip=?,pv=? where from_source_id=? and spread_item_tn=? and count_date=?";
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
                    LOG.warn(String.format("insert pvip to from_source_base fail! [fromSourceUrl=%s, spreadItemTn=%s]" + e.toString(), fromSourceUrl, spreadItemTn));
                    LOG.debug("Exception Detail", e);
                    failCount++;
                }
            }
        }
        log("FINISH countPVIPToFromSourceBase! [all count:" + PVIPRow + ", insert count:" + insertCount + ", update count:" + updateCount + ", fail count:" + failCount + "]");
    }

    private void countRegCountToFromSourceBase() {
        log("BEGIN countRegCountToFromSourceBase");
        String selectRegisterCountSql = "SELECT fromUrl,register,count(*) as registerCount FROM PV_Person_Register" +
                " WHERE DATE_FORMAT(credate, '%Y-%m-%d') = ? GROUP BY fromUrl,register" +
                " ORDER BY fromUrl,register";
        String getRegisterCountRowSql = "select count(*) from (select 1 " +
                " FROM PV_Person_Register WHERE DATE_FORMAT(credate, '%Y-%m-%d') = ? GROUP BY fromUrl,register) a";
        int registerCountRow = countJdbcTemplate.queryForObject(getRegisterCountRowSql, Integer.class, countDateString);
        String insertRegCtSql = "insert into count_from_source_base (from_source_id,spread_item_tn,count_date,register_count) values (?,?,?,?)";
        String updateRegCtSql = "update count_from_source_base set register_count=? where from_source_id=? and spread_item_tn=? and count_date=?";
        long insertCount = 0;
        long updateCount = 0;
        long failCount = 0;
        for (int i = 0; i < registerCountRow; i += processLimit) {
            String limitSelecRegCountSql = selectRegisterCountSql + " limit ?,?";
            List<Map<String, Object>> rs = countJdbcTemplate.queryForList(limitSelecRegCountSql, countDateString, i, processLimit);
            for (Map<String, Object> fromSourceRsItem : rs) {
                String fromSourceUrl = ObjectUtils.toString(fromSourceRsItem.get("fromUrl"));
                String spreadItemTn = ObjectUtils.toString(fromSourceRsItem.get("register"));
                try {
                    int fromSourceId = saveFromSource(fromSourceUrl, "PV_Person_Register");
                    if (fromSourceId == -1) {
                        failCount++;
                        continue;
                    }
                    Object registerCount = fromSourceRsItem.get("registerCount");
                    try {
                        countJdbcTemplate.update(insertRegCtSql, fromSourceId, spreadItemTn, countDate, registerCount);
                        insertCount++;
                    } catch (DuplicateKeyException e) {
                        countJdbcTemplate.update(updateRegCtSql, registerCount, fromSourceId, spreadItemTn, countDate);
                        updateCount++;
                    }
                } catch (Exception e) {
                    LOG.warn(String.format("insert RegCount to from_source_base fail! [fromSourceUrl=%s, spreadItemTn=%s] " + e.toString(), fromSourceUrl, spreadItemTn));
                    LOG.debug("Exception Detail", e);
                    failCount++;
                }
            }
        }
        log("FINISH countRegCountToFromSourceBase! [all count:" + registerCountRow + ", insert count:" + insertCount + ", update count:" + updateCount + ", fail count:" + failCount + "]");
    }

    private void countPosApplyCountToFromSourceBase() {
        log("BEGIN countPosApplyCountToFromSourceBase");
        String selectPosCtSql = "SELECT from_source_url,spread_item_tn,count(*) as posApplyCount FROM per_pos_apply" +
                " WHERE DATE_FORMAT(cre_time, '%Y-%m-%d') = ? GROUP BY from_source_url,spread_item_tn" +
                " ORDER BY from_source_url,spread_item_tn";
        String getPosCtRowSql = "select count(*) from (select 1 " +
                " FROM per_pos_apply WHERE DATE_FORMAT(cre_time, '%Y-%m-%d') = ? GROUP BY from_source_url,spread_item_tn) a";
        int posCtRow = actionJdbcTemplate.queryForObject(getPosCtRowSql, Integer.class, countDateString);
        String insertPosCtSql = "insert into count_from_source_base (from_source_id,spread_item_tn,count_date,pos_apply_count) values (?,?,?,?)";
        String updatePosCtSql = "update count_from_source_base set pos_apply_count=? where from_source_id=? and spread_item_tn=? and count_date=?";
        long insertCount = 0;
        long updateCount = 0;
        long failCount = 0;
        for (int i = 0; i < posCtRow; i += processLimit) {
            String limitSelecPosCountSql = selectPosCtSql + " limit ?,?";
            List<Map<String, Object>> rs = actionJdbcTemplate.queryForList(limitSelecPosCountSql, countDateString, i, processLimit);
            for (Map<String, Object> fromSourceRsItem : rs) {
                String fromSourceUrl = ObjectUtils.toString(fromSourceRsItem.get("from_source_url"));
                String spreadItemTn = ObjectUtils.toString(fromSourceRsItem.get("spread_item_tn"));
                try {
                    int fromSourceId = saveFromSource(fromSourceUrl, "per_pos_apply");
                    if (fromSourceId == -1) {
                        failCount++;
                        continue;
                    }
                    Object posApplyCount = fromSourceRsItem.get("posApplyCount");
                    try {
                        countJdbcTemplate.update(insertPosCtSql, fromSourceId, spreadItemTn, countDate, posApplyCount);
                        insertCount++;
                    } catch (DuplicateKeyException e) {
                        countJdbcTemplate.update(updatePosCtSql, posApplyCount, fromSourceId, spreadItemTn, countDate);
                        updateCount++;
                    }
                } catch (Exception e) {
                    LOG.warn(String.format("insert PosApplyCount to from_source_base fail! [fromSourceUrl=%s, spreadItemTn=%s] " + e.toString(), fromSourceUrl, spreadItemTn));
                    LOG.debug("Exception Detail", e);
                    failCount++;
                }
            }
        }
        log("FINISH countPosApplyCountToFromSourceBase! [all count:" + posCtRow + ", insert count:" + insertCount + ",update count:" + updateCount + ", fail count:" + failCount + "]");
    }

    private void countResumeRefreshCountToFromSourceBase() {
        log("BEGIN countResumeRefreshCountToFromSourceBase");
        String selectResumeCtSql = "SELECT from_source_url,spread_item_tn,count(*) as resumeRefreshCt FROM per_resume_refresh" +
                " WHERE DATE_FORMAT(refresh_time, '%Y-%m-%d') = ? GROUP BY from_source_url,spread_item_tn" +
                " ORDER BY from_source_url,spread_item_tn";
        String getResumeCtRowSql = "select count(*) from (select 1 " +
                " FROM per_resume_refresh WHERE DATE_FORMAT(refresh_time, '%Y-%m-%d') = ? GROUP BY from_source_url,spread_item_tn) a";
        int resumeCtRow = actionJdbcTemplate.queryForObject(getResumeCtRowSql, Integer.class, countDateString);
        String insertResumeCtSql = "insert into count_from_source_base (from_source_id,spread_item_tn,count_date,resume_refresh_count) values (?,?,?,?)";
        String updateResumeCtSql = "update count_from_source_base set resume_refresh_count=? where from_source_id=? and spread_item_tn=? and count_date=?";
        long insertCount = 0;
        long updateCount = 0;
        long failCount = 0;
        for (int i = 0; i < resumeCtRow; i += processLimit) {
            String limitSelecResumeCountSql = selectResumeCtSql + " limit ?,?";
            List<Map<String, Object>> rs = actionJdbcTemplate.queryForList(limitSelecResumeCountSql, countDateString, i, processLimit);
            for (Map<String, Object> fromSourceRsItem : rs) {
                String fromSourceUrl = ObjectUtils.toString(fromSourceRsItem.get("from_source_url"));
                String spreadItemTn = ObjectUtils.toString(fromSourceRsItem.get("spread_item_tn"));
                try {
                    int fromSourceId = saveFromSource(fromSourceUrl, "per_resume_refresh");
                    if (fromSourceId == -1) {
                        failCount++;
                        continue;
                    }
                    Object resumeRefreshCt = fromSourceRsItem.get("resumeRefreshCt");
                    try {
                        countJdbcTemplate.update(insertResumeCtSql, fromSourceId, spreadItemTn, countDate, resumeRefreshCt);
                        insertCount++;
                    } catch (DuplicateKeyException e) {
                        countJdbcTemplate.update(updateResumeCtSql, resumeRefreshCt, fromSourceId, spreadItemTn, countDate);
                        updateCount++;
                    }
                } catch (Exception e) {
                    LOG.warn(String.format("insert ResumeRefreshCount to from_source_base fail! [fromSourceUrl=%s, spreadItemTn=%s] " + e.toString(), fromSourceUrl, spreadItemTn));
                    LOG.debug("Exception Detail", e);
                    failCount++;
                }
            }
        }
        log("FINISH countResumeRefreshCountToFromSourceBase! [all count:" + resumeCtRow + ", insert count:" + insertCount + ",update count:" + updateCount + "fail count:" + failCount + "]");
    }

    public void copySysCountItemSetting() {
        log("START copySysCountItemSetting");
        int insertCount = 0;
        int failCount = 0;
        List<Map<String, Object>> items = baseJdbcTemplate.queryForList("select * from sys_count_item_setting");
        countJdbcTemplate.update("TRUNCATE TABLE sys_count_item_setting_copy");
        for (Map<String, Object> item : items) {
            String tn = item.get("tn").toString();
            try {
                String insertSql = "insert into sys_count_item_setting_copy (id,item_name,item_type,item_url,item_category,tn,begin_date,end_date,create_date,update_date,update_user_name,item_mode,item_type_no) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
                countJdbcTemplate.update(insertSql,
                        item.get("id"),
                        item.get("item_name"),
                        item.get("item_type"),
                        item.get("item_url"),
                        item.get("item_category"),
                        tn,
                        item.get("begin_date"),
                        item.get("end_date"),
                        item.get("create_date"),
                        item.get("update_date"),
                        item.get("update_user_name"),
                        item.get("item_mode"),
                        item.get("item_type_no"));
                insertCount++;
            } catch (Exception e) {
                LOG.warn("insert SysCountItem to sys_count_item_setting fail! [tn=" + tn + "] " + e.toString());
                LOG.debug("Exception Detail", e);
                failCount++;
            }
        }
        log("END copySysCountItemSetting! [insert count:" + insertCount + ", fail count:" + failCount + "]");
    }

    private void log(String log) {
        LOG.info("[CountFromSource INFO]: " + log);
    }
}
