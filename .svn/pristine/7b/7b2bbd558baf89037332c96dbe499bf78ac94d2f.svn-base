package com.job5156.task.count;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.job5156.common.util.HibernateCountUtil;
import com.job5156.common.util.HibernateUtil;
import com.job5156.common.util.JsonValidator;
import com.job5156.common.util.PVAccessUtil;
import com.job5156.model.sys.SysCountItem;
import com.job5156.model.sys.SysCountItemSetting;
import com.job5156.vo.sys.SysCountItemSettingVo;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * 栏目统计
 * @author xh
 * @date 2014-4-25 上午10:35:25
 *
 */
public class CountItemTask {
    private static Logger logger = Logger.getLogger(CountItem.class);


    private JdbcTemplate jdbcTemplate = HibernateUtil.getJdbcTemplate();

    private JdbcTemplate  jdbcTemplateCount = HibernateCountUtil.getJdbcTemplate();

    /** 配置是否从备份表中统计，多用于修复，默认从原表统计 */
    private boolean countFromBak = false;

    public static void main(String args[]){
                new CountItemTask().run();
    }

    public void run() {
        save("TaskCountItem.countItem.start", "开始：栏目访问统计");
        try {
            countItem();
        } catch(Exception e) {
            e.printStackTrace();
            logger.error("统计栏目访问量时出错,异常信息如下:" + e.getMessage(), e);
        }
        save("TaskCountItem.countItem.finish", "结束：栏目访问统计");
    }

    public List<SysCountItemSetting> getValidCountItem() {
        String hql = "from SysCountItemSetting where beginDate<=? and (endDate>=? or endDate is null)";
        return createQuery(hql, new Date(), new Date()).list();
    }

    public Query createQuery(final String queryString, final Object... values) {
        Assert.hasText(queryString, "queryString不能为空");
        Query query = HibernateUtil.currentSession().createQuery(queryString);
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                query.setParameter(i, values[i]);
            }
        }
        return query;
    }

    /**
     * 统计前一天的栏目访问量
     */
    public void countItem() {
        List<SysCountItemSetting> countItemSettingList = getValidCountItem();
        for(SysCountItemSetting sysCountItemSetting : countItemSettingList) {
            SysCountItemSettingVo sysCountItemSettingVo = toVo(sysCountItemSetting);
            countItem(DateTime.now().minusDays(1).toDate(), sysCountItemSettingVo);
        }
    }

    /**
     * 统计指定日期的栏目访问量
     * @param countDate 统计日期
     * @param sysCountItemSettingVo 栏目设置
     */
    public void countItem(Date countDate, SysCountItemSettingVo sysCountItemSettingVo) {
        SysCountItem sysCountItem = new SysCountItem();
        sysCountItem.setItemId(sysCountItemSettingVo.getId());
        sysCountItem.setCountDate(countDate);
        //栏目编号
        String et = sysCountItemSettingVo.getTn();

        for(Integer itemCategory : sysCountItemSettingVo.getItemCategoryList()) {
            if(itemCategory.equals(CountItem.IP.value)) {
                sysCountItem.setIpCount(getCountByIp(countDate, sysCountItemSettingVo));
            } else if(itemCategory.equals(CountItem.PV.value)) {
                sysCountItem.setPvCount(getCountByPv(countDate, sysCountItemSettingVo));
            } else if(itemCategory.equals(CountItem.REG_RESUME.value)) {
                sysCountItem.setRegResumeCount(getCountByRegister(countDate, et));
            } else if(itemCategory.equals(CountItem.SPREAD.value)) {
                sysCountItem.setSpreadCount(getCountBySpread(countDate, et));
            }
        }
        //保存统计数据
        HibernateUtil.currentSession().save(sysCountItem);
    }

    /**
     * 获取统计栏目IP量
     * @param countDay 指定的统计日期
     * @param sysCountItemSettingVo 栏目设置
     * @return
     */
    private int getCountByIp(final Date countDay, final SysCountItemSettingVo sysCountItemSettingVo) {
        final DateTime jodaCountDay = new DateTime(countDay);
        final Date startTime = jodaCountDay.toDate();
        final Date endTime = jodaCountDay.plusDays(1).toDate();

        final String et = sysCountItemSettingVo.getTn();
        final String pvTable = countFromBak ? PVAccessUtil.getPVAccessTableName(countDay) : "PV_Access";
        final List<Object> params = new ArrayList<>();
        String sql;

        if(sysCountItemSettingVo.getItemMode() == 1){
            List<String> itemUrlList =  sysCountItemSettingVo.getItemUrlList();
            if(CollectionUtils.isEmpty(itemUrlList)){
                return 0;
            }
            sql = "select count(distinct userIp) from " + pvTable + " where acceptTime between ? and ? and colId=?";
            params.add(startTime);
            params.add(endTime);
            params.add(et);
            sql += " and(";
            for(int i=0; i<itemUrlList.size(); i++){
                String itemUrl = itemUrlList.get(i);
                if(StringUtils.isNotBlank(itemUrl)){
                    String domain = StringUtils.substringBetween(itemUrl, "http://", "/");
                    if(StringUtils.isNotBlank(domain)){
                        String addr = StringUtils.substringAfter(itemUrl, domain);
                        sql += "(targetDomain = ? and targetAddr = ?)";
                        params.add(domain);
                        params.add(addr);
                    }else{
                        sql += "targetAddr = ?";
                        params.add(itemUrl);
                    }
                    if(i != itemUrlList.size() -1){
                        sql += " or ";
                    }
                }
            }
            sql += ")";
        }else{
            sql = "select count(distinct userIp) from " + pvTable + " where acceptTime between ? and ? and colId=? and targetAddr like ?";
            params.add(startTime);
            params.add(endTime);
            params.add(et);
            params.add("%et=" + et + "%");
        }
        return getCountBySql(sql, params.toArray());
    }

    /**
     * 获取统计栏目PV量
     * @param countDay 指定的统计日期
     * @param sysCountItemSettingVo 栏目设置
     * @return
     */
    private int getCountByPv(Date countDay, SysCountItemSettingVo sysCountItemSettingVo) {
        final DateTime jodaCountDay = new DateTime(countDay);
        final Date startTime = jodaCountDay.toDate();
        final Date endTime = jodaCountDay.plusDays(1).toDate();

        final String et = sysCountItemSettingVo.getTn();
        final String pvTable = countFromBak ? PVAccessUtil.getPVAccessTableName(countDay) : "PV_Access";
        final List<Object> params = new ArrayList<>();
        String sql;

        if(sysCountItemSettingVo.getItemMode() == 1){
            List<String> itemUrlList =  sysCountItemSettingVo.getItemUrlList();
            if(CollectionUtils.isEmpty(itemUrlList)){
                return 0;
            }
            sql = "select count(1) from " + pvTable + " where acceptTime between ? and ? and colId=?";
            params.add(startTime);
            params.add(endTime);
            params.add(et);
            sql += " and(";
            for(int i=0; i<itemUrlList.size(); i++){
                String itemUrl = itemUrlList.get(i);
                if(StringUtils.isNotBlank(itemUrl)){
                    String domain = StringUtils.substringBetween(itemUrl, "http://", "/");
                    if(StringUtils.isNotBlank(domain)){
                        String addr = StringUtils.substringAfter(itemUrl, domain);
                        sql += "(targetDomain = ? and targetAddr = ?)";
                        params.add(domain);
                        params.add(addr);
                    }else{
                        sql += "targetAddr = ?";
                        params.add(itemUrl);
                    }
                    if(i != itemUrlList.size() -1){
                        sql += " or ";
                    }
                }
            }
            sql += ")";
        }else{
            sql = "select count(1) from " + pvTable + " where acceptTime between ? and ? and colId=? and targetAddr like ?";
            params.add(startTime);
            params.add(endTime);
            params.add(et);
            params.add("%et=" + et + "%");
        }
        return getCountBySql(sql, params.toArray());
    }

    /**
     * 获取统计栏目简历注册量
     * @param countDay 统计日期
     * @param et 统计编号
     * @return
     */
    private int getCountByRegister(Date countDay, String et) {
        final DateTime jodaCountDay = new DateTime(countDay);
        final Date startTime = jodaCountDay.toDate();
        final Date endTime = jodaCountDay.plusDays(1).toDate();
        final List<Object> params = new ArrayList<>(3);

        final String sql = "select count(1) from PV_Person_Register where credate between ? and ? and register=? ";
        params.add(startTime);
        params.add(endTime);
        params.add(et);
        return getCountBySql(sql, params.toArray());
    }

    /**
     * 获取统计栏目推广带来的访问量
     * @param countDay 指定的统计日期
     * @param et 统计编号
     * @return
     */
    private int getCountBySpread(Date countDay, String et) {
        final DateTime jodaCountDay = new DateTime(countDay);
        final Date startTime = jodaCountDay.toDate();
        final Date endTime = jodaCountDay.plusDays(1).toDate();
        final List<Object> params = new ArrayList<>(3);

        final String pvTable = countFromBak ? PVAccessUtil.getPVAccessTableName(countDay) : "PV_Access";
        final String sql = "select count(1) from " + pvTable + " where acceptTime between ? and ? and colId=?";
        params.add(startTime);
        params.add(endTime);
        params.add(et);
        return getCountBySql(sql, params.toArray());
    }


    public Integer getCountBySql(String sql, Object... params) {
        return jdbcTemplateCount.queryForObject(sql, Integer.class, params);
    }


    public void modelJsonToVoObject(SysCountItemSetting model, SysCountItemSettingVo vo) {
        JsonValidator jsonValid = new JsonValidator();
        Gson gson = new Gson();

        if(jsonValid.validate(model.getItemUrl())) {
            vo.setItemUrlList(gson.<List<String>>fromJson(model.getItemUrl(), new TypeToken<List<String>>() {}.getType()));
        }

        if(jsonValid.validate(model.getItemCategory())) {
            vo.setItemCategoryList(gson.<List<Integer>>fromJson(model.getItemCategory(), new TypeToken<List<Integer>>() {}.getType()));
        }

        if(vo.getBeginDate().after(new Date())) {
            vo.setStatusStr("未开始");
        } else {
            if(new DateTime(vo.getEndDate()).withHourOfDay(23).withMinuteOfHour(59).withSecondOfMinute(59).isBeforeNow()) {
                vo.setStatusStr("已过期");
            } else {
                vo.setStatusStr("未过期");
            }
        }
    }

    public void copyProperties(SysCountItemSetting model, SysCountItemSettingVo vo, String[] ignoreProperties) {
        BeanUtils.copyProperties(model, vo, ignoreProperties);
        modelJsonToVoObject(model, vo);
    }

    public SysCountItemSettingVo toVo(SysCountItemSetting m) {
        SysCountItemSettingVo v = null;

        try {
            v = SysCountItemSettingVo.class.newInstance();
        } catch(IllegalAccessException illegalAccessException) {
        } catch (InstantiationException instantiationException) {
        }

        if(v != null)
            copyProperties(m, v, null);
        return v;
    }

    public void save(String taskClass, String taskMemo) {
        String deleteSql = "DELETE FROM log_task WHERE task_class = ?";
        String sql = "INSERT INTO log_task(task_class, task_last_time, task_memo) VALUES(?,?,?)";
        jdbcTemplate.update(deleteSql, taskClass);
        jdbcTemplate.update(sql, taskClass, DateTime.now().toDate(), taskMemo);
    }


    /**
     *
     * 统计项
     * @author xh
     * @date 2014-4-21 下午2:07:29
     *
     */
    public enum CountItem {
        /**
         * 统计IP
         */
        IP(1),
        /**
         * 统计PV
         */
        PV(3),
        /**
         * 统计简历注册量
         */
        REG_RESUME(5),
        /**
         * 统计推广带来的访问量
         */
        SPREAD(7);

        private Integer value;

        public Integer getValue() {
            return value;
        }

        private CountItem(Integer value) {
            this.value = value;
        }
    }

    public boolean isCountFromBak() {
        return countFromBak;
    }

    public void setCountFromBak(boolean countFromBak) {
        this.countFromBak = countFromBak;
    }
}



