package com.job5156.task.mail;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.jdbc.core.JdbcTemplate;

import com.job5156.common.Constants;
import com.job5156.common.jedis.JedisFactory;
import com.job5156.common.jedis.JedisTemplate;
import com.job5156.common.util.HibernateActionSlaveUtil;
import com.job5156.common.util.HibernateSalveBaseUtil;
import com.job5156.vo.com.ComGradeVo;

/**
 * <p>筛选出符合推荐简历的职位</p>
 * Date:2015/7/17 11:24
 *
 * @author pzm
 * @version 1.0
 */
public class SysFindPosToResRecommend {
    private Logger logger = Logger.getLogger(this.getClass());

    private JedisFactory jedisFactory = JedisFactory.getInstance();

    private JdbcTemplate jdbcTemplateSlaveBase = HibernateSalveBaseUtil.getJdbcTemplate();
    private JdbcTemplate jdbcTemplateSlaveAction = HibernateActionSlaveUtil.getJdbcTemplate();

    /**
     * 查找第二类符合规则的职位推荐简历，三天一次
     * @param comIdFilter 指定查询的企业id，用于测试，正式运行传值null
     * @return
     */
    @SuppressWarnings("unchecked")
	public void findPosToResRecommendThreeRun(String comIdFilter) {
        logger.info("[findPosToResRecommendThreeRun] start!");
        String redisKey = Constants.REDIS_KEY_RECOMMENDED_COMPOS_ID_THREE_RUN;
        JedisTemplate jedisTemplate = jedisFactory.getJedisTemplate(Constants.REDIS_KEY_RECOMMENDED_COMPOS_ID_THREE_RUN);
        Map<String, Set<String>> dataMap = new HashMap<>();
        //获取一周前发布的职位以及企业
        Map<Integer, Set<String>> comPosMap = getAllValidPosGroupByCom(false, comIdFilter);
        Set<Integer> comIds = comPosMap.keySet();
        //分析并计算企业得分
        Map<Integer, ComGradeVo> comGradeVoMap = analyseComGrade(comIds);
        for (ComGradeVo comGrade : comGradeVoMap.values()) {
            //超过30分，推荐
            if (comGrade.getTotalScore() >= 30) {
                Integer currComId = comGrade.getComId();
                dataMap.put(currComId.toString(), comPosMap.containsKey(currComId) ? subSet(comPosMap.get(currComId), 3) : Collections.EMPTY_SET);
            }
        }
        //删除以前redis中的map
        if (jedisTemplate.isKeyExist(redisKey)) {
            jedisTemplate.del(redisKey);
        }
        
        //这里dataMap数据量有可能非常多，防止内存溢出用循环的方式写入Map - 7/23/2015 闫锋
        if(MapUtils.isNotEmpty(dataMap)){
        	for(Map.Entry<String, Set<String>> entry : dataMap.entrySet()){
        		String fieldKey = entry.getKey();
        		jedisTemplate.writeToMap(redisKey, fieldKey, StringUtils.join(entry.getValue(), ","));
        	}
        }
        logger.info("[findPosToResRecommendThreeRun] end! 总企业数：" + comIds.size() + ",推荐企业数：" + dataMap.size());
    }

    /**
     * 查找最近发布的职位推荐简历，两天一次
     * @param comIdFilter 指定查询的企业id，用于测试，正式运行传值null
     * @return
     */
    public void findPosToResRecommendTwoRun(String comIdFilter) {
        String redisKey = Constants.REDIS_KEY_RECOMMENDED_COMPOS_ID_NEW_RELEASE;
        JedisTemplate jedisTemplate = jedisFactory.getJedisTemplate(Constants.REDIS_KEY_RECOMMENDED_COMPOS_ID_NEW_RELEASE);
        Map<String, Set<String>> dataMap = new HashMap<>();
        //获取最近一周发布的职位以及企业
        Map<Integer, Set<String>> comPosMap = getAllValidPosGroupByCom(true, comIdFilter);
        for (Map.Entry<Integer, Set<String>> entry : comPosMap.entrySet()) {
            Integer comId = entry.getKey();
            dataMap.put(comId.toString(), subSet(entry.getValue(), 3));
        }
        
        //删除以前redis中的map
        if (jedisTemplate.isKeyExist(redisKey)) {
            jedisTemplate.del(redisKey);
        }
        
        //这里dataMap数据量有可能非常多，防止内存溢出用循环的方式写入Map - 7/23/2015 闫锋
        if(MapUtils.isNotEmpty(dataMap)){
        	for(Map.Entry<String, Set<String>> entry : dataMap.entrySet()){
        		String fieldKey = entry.getKey();
        		jedisTemplate.writeToMap(redisKey, fieldKey, StringUtils.join(entry.getValue(), ","));
        	}
        }
        logger.info("[findPosToResRecommendTwoRun] finish! 推荐企业数：" + dataMap.size());
    }

    /**
     * 剪切集合
     *
     * @param set     集合
     * @param subSize 剪切的数量
     * @return
     */
    private Set<String> subSet(Set<String> set, int subSize) {
        Set<String> subSet = new HashSet<>();
        int i = 0;
        for (String oneVal : set) {
            if (i >= subSize) {
                break;
            }
            subSet.add(oneVal);
            i++;
        }
        return subSet;
    }

    /**
     * 获取每个企业的有效职位（没有有效职位的企业不获取）
     *
     * @param newPos 是否新发布职位（一周）
     * @return
     */
    private Map<Integer, Set<String>> getAllValidPosGroupByCom(boolean newPos, String comIdFilter) {
        Map<Integer, Set<String>> rs = new HashMap<>();
        String sql = "SELECT cp.id,cp.com_id FROM com_position cp " +
                "LEFT JOIN com_right cri ON cp.com_id = cri.com_id " +
                "WHERE cp.pos_status > 0 " +
                "AND cp.del_status != - 1 " +
                "AND cp.end_date >= CURDATE() " +
                "AND cri.member_type >= 1 " +
                "AND cri.member_type <= 6 " +
                "AND cri.expire_date >= CURDATE()";
        if (newPos) {
            sql += " AND cp.create_date >= '" + new DateTime().minusDays(7).toString("yyyy-MM-dd") + "'";
        } else {
            sql += " AND cp.create_date < '" + new DateTime().minusDays(7).toString("yyyy-MM-dd") + "'";
        }
        if (comIdFilter != null) {
            sql += " AND cp.com_id = " + comIdFilter;
        }
        List<Map<String, Object>> posList = jdbcTemplateSlaveBase.queryForList(sql);
        for (Map<String, Object> posMap : posList) {
            Integer comId = (Integer) posMap.get("com_id");
            Integer posId = (Integer) posMap.get("id");
            if (rs.containsKey(comId)) {
                Set<String> posSet = rs.get(comId);
                posSet.add(posId.toString());
            } else {
                Set<String> posSet = new HashSet<>();
                posSet.add(posId.toString());
                rs.put(comId, posSet);
            }
        }
        return rs;
    }

    /**
     * 计算企业得分
     */
    private Map<Integer, ComGradeVo> analyseComGrade(Set<Integer> comIds) {
        Map<Integer, ComGradeVo> dataMap = new HashMap<>();
        for (Integer comId : comIds) {
            dataMap.put(comId, new ComGradeVo(comId));
        }
        //计算（企业一周内收到简历数量）得分
        analyseResumeReceiveScore(dataMap);
        //计算（一个月内推荐简历查看率）得分
        analyseReadRecommendScore(dataMap);
        return dataMap;
    }

    /**
     * 计算（企业一周内收到简历数量）得分
     */
    private void analyseResumeReceiveScore(Map<Integer, ComGradeVo> dataMap) {
        String startDate = new DateTime().minusDays(7).toString("yyyy-MM-dd");
        String endDate = new DateTime().toString("yyyy-MM-dd");
        String sql = "SELECT com_id, count(distinct(per_user_id)) AS resume_count " +
                "FROM com_receive " +
                "WHERE create_date >=? " +
                "AND create_date <? " +
                "AND sys_recommend != 1 " +
                "GROUP BY com_id;";
        List<Map<String, Object>> dataList = jdbcTemplateSlaveAction.queryForList(sql, startDate, endDate);
        if(CollectionUtils.isNotEmpty(dataList)){
        	for (Map<String, Object> row : dataList) {
                int comId = (int) row.get("com_id");
                if (dataMap.containsKey(comId)) {
                    ComGradeVo comGradeVo = dataMap.get(comId);
                    comGradeVo.setResumeCountWeekly(((Long) row.get("resume_count")).intValue());
                }
            }
        }
    }

    /**
     * 计算（一个月内推荐简历查看率）得分
     */
    private void analyseReadRecommendScore(Map<Integer, ComGradeVo> dataMap) {
        String startDate = new DateTime().minusDays(30).toString("yyyy-MM-dd");
        String endDate = new DateTime().toString("yyyy-MM-dd");
        String sql = "SELECT com_id, IFNULL(read_flag,0) as readFlag, count(*) as comReceiveCount " +
                "FROM com_receive " +
                "WHERE create_date>=? " +
                "AND create_date<? " +
                "AND receive_type=1 " +
                "GROUP BY 1,2;";
        List<Map<String, Object>> dataList = jdbcTemplateSlaveAction.queryForList(sql, startDate, endDate);
        if(CollectionUtils.isNotEmpty(dataList)){
        	for (Map<String, Object> row : dataList) {
                int comId = (int) row.get("com_id");
                if (dataMap.containsKey(comId)) {
                    ComGradeVo comGradeVo = dataMap.get(comId);
                    int read_flag = (int) row.get("readFlag");
                    int comReceiveCount = ((Long) row.get("comReceiveCount")).intValue();
                    if (read_flag == 1) {
                        comGradeVo.setSysRecommendReadedCountMonthly(comReceiveCount);
                    } else {
                        comGradeVo.setSysRecommendUnreadCountMonthly(comReceiveCount);
                    }
                }
            }
        }
    }
}
