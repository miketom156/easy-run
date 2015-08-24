package com.job5156.task.count;

import java.lang.reflect.Type;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.job5156.common.Constants;
import com.job5156.common.option.OptionMap;
import com.job5156.common.option.OptionPositionMap;
import com.job5156.common.util.CollectionSortUtil;
import com.job5156.common.util.HibernateActionUtil;
import com.job5156.common.util.HibernateCountUtil;
import com.job5156.common.util.HibernateSalveBaseUtil;
import com.job5156.common.util.MD5Builder;
import com.job5156.model.count.CountPosResCate;
import com.job5156.vo.api.PosSearchCountResult;
import com.job5156.vo.api.ResumeSearchCountResult;
import com.job5156.vo.api.SearchFilterDetail;
import com.job5156.vo.per.PerEducationInfoVo;
import com.job5156.vo.per.PerIntentVo;


/**
 * 每周统计一次职位与简历存量
 * 与增量总数
 * Created by Andy on 2014/9/16.
 */
public class CountPosResCategory {
    private static Logger log = Logger.getLogger(CountPosResCategory.class);

    private static int TIMEPERIOD = -7;// 执行的周期

    // 地区
    private final static List<Integer> WORKLOCATLIST = Lists.newArrayList(
            14010000, 14020000, 14030000, 14040000,
            14070000, 14080000, 14090000, 14230000,
            14130000, 14110000, 28010000, 28020000,
            5020000, 23010000, 16010000
    );
    // 学历
    private final static List<String[]> REQDEGREE = Lists.newArrayList(
            new String[]{"0", "不限"},
            new String[]{"1", "初中"},
            new String[]{"2", "高中"},
            new String[]{"3", "中专"},
            new String[]{"4", "大专"},
            new String[]{"5", "本科"},
            new String[]{"6", "硕士"},
            new String[]{"7", "MBA"},
            new String[]{"8", "博士"}
    );

    public void resPosStatistics() {
        log.error("每周统计职位简历总数开始...");
        Session countSession = null;
        try {
            countSession = HibernateCountUtil.currentSession();
            //存放默认简历的Map
            Map<Integer, Integer> maxDegree = getMaxDegree();
            //获取最高学历的次数
            List allResList = getDegreeCount();
            //获取所有有效职位数据
            List list = posAddStatistics();
            //获取所有有效职位数据
            List posApplyDataList = posApplyDatas();
            for (int workLocation : WORKLOCATLIST) {
                for (int posType : OptionPositionMap.OPT_MAP_POSITION.keySet()) {
                    CountPosResCate modelTemp = new CountPosResCate();
                    modelTemp.setCreateDate(new Date());
                    modelTemp.setWorkLocation(workLocation);
                    modelTemp.setPosType(posType);
                    List<SearchFilterDetail> degreePosFilter = httpClient(Constants.API_POS_CATE_URL, true, modelTemp, 30);
                    List<SearchFilterDetail> degreeResumeFilter = httpClient(Constants.API_RESUME_CATE_URL, false, modelTemp, 30);
                    List<SearchFilterDetail> degreeResumeFilterActive = httpClient(Constants.API_RESUME_CATE_URL, false, modelTemp, 30);//搜索引擎的查询条件其实是以30天作为一个月
                    for (int y = 0; y < REQDEGREE.size(); y++) {
                        CountPosResCate model = new CountPosResCate();
                        model.setCreateDate(new Date());
                        model.setWorkLocation(workLocation);
                        model.setPosType(posType);
                        int reqDegree = Integer.valueOf(REQDEGREE.get(y)[0]);
                        model.setReqDegree(reqDegree);
                        //增量
                        fillAddStatistics( model,  list,  allResList,  maxDegree,  workLocation,  posType,  reqDegree);
                        //存量
                        fillCountSavePosResCate( model,  degreePosFilter, degreeResumeFilter,  reqDegree);
                        //活跃量
                        fillCountActiveResCate( model,  degreeResumeFilterActive, reqDegree);
                        //简历投递量
                        fillPosApplyCount(model, posApplyDataList,  workLocation,  posType,  reqDegree);
                        countSession.save(model);
                    }
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    public void fillAddStatisticsPos(CountPosResCate model, List list, int workLocation, int posType, int reqDegree) {
        Gson gson = new Gson();
        //职位的统计增量的数据
        String workLoc = OptionMap.getCityCodeBits(workLocation);
        int posCount = 0;
        if (CollectionUtils.isNotEmpty(list)) {
            for (Object obj : list) {
                Object[] objs = (Object[]) obj;
                String work = String.valueOf(objs[0]);
                String posTypeVal = String.valueOf(objs[1]);
                String req = String.valueOf(objs[2]);

                //工作地区的判断
                boolean checkWorkLocation = false;
                if (StringUtils.isNotBlank(work) && !StringUtils.equals(work, "[]")) {
                    List<Integer> workLocationList = gson.fromJson(work, new TypeToken<List<Integer>>() {
                    }.getType());
                    if (CollectionUtils.isNotEmpty(workLocationList)) {
                        for (Integer location : workLocationList) {
                            String cityCodeStr = OptionMap.getCityCodeBits(location);
                            if (cityCodeStr.equals(workLoc)) {
                                checkWorkLocation = true;
                                break;
                            }
                        }
                    }
                }

                //职位Id的判断
                boolean checkPosType = false;
                if (StringUtils.isNotBlank(posTypeVal) && !StringUtils.equals(posTypeVal, "[]")) {
                    List<Integer> posTypeList = gson.fromJson(posTypeVal, new TypeToken<List<Integer>>() {
                    }.getType());
                    if (CollectionUtils.isNotEmpty(posTypeList)) {
                        //for(Integer posTpeyId : posTypeList) {
                        Integer posTpeyId = posTypeList.get(0);
                        if (posTpeyId.equals(posType)) {
                            checkPosType = true;
                        }
                        //}
                    }
                }

                if (checkWorkLocation && checkPosType && req.equals(reqDegree + "")) {
                    posCount++;
                }
            }
            model.setAddPosCount(posCount);
        }
    }

    public void fillAddReStatistics(CountPosResCate model, List allResList, Map<Integer, Integer> maxDegree, int workLocation, int posType, int reqDegree) {
        //统计简历增量的数据
        Gson gson = new Gson();
        //职位的统计增量的数据
        String workLoc = OptionMap.getCityCodeBits(workLocation);
        int resCount = 0;
        if (CollectionUtils.isNotEmpty(allResList)) {
            Map<Integer, Integer> degreeCount = Maps.newHashMap();
            for (Object obj : allResList) {
                Object[] objs = (Object[]) obj;
                Type type = new TypeToken<PerIntentVo>() {
                }.getType();
                PerIntentVo perIntentVo = gson.fromJson(objs[1] + "", type);
                if (null == perIntentVo)
                    continue;

                // 判断工作地区
                boolean checkJobLocation = false;
                String jobLocation = perIntentVo.getJobLocation();
                if (StringUtils.isNotBlank(jobLocation)) {
                    String[] jobLocationArr = StringUtils.split(jobLocation, ",");
                    if (ArrayUtils.isNotEmpty(jobLocationArr)) {
                        for (String jobLocationStr : jobLocationArr) {
                            String cityCodeStr = OptionMap.getCityCodeBits(jobLocationStr);
                            if (cityCodeStr.equals(workLoc)) {
                                checkJobLocation = true;
                                break;
                            }
                        }
                    }
                }

                // 判断职位类别
                boolean checkPosType = false;
                if (StringUtils.isNotBlank(perIntentVo.getJobCode())) {
                    String jobCode = perIntentVo.getJobCode().split(",")[0];
                    //for (String jobCode : perIntentVo.getJobCode().split(",")) {
                    if (jobCode.equals(String.valueOf(posType))) {
                        checkPosType = true;
                    }
                    //}
                }
                // 统计简历的次数
                if (checkJobLocation && checkPosType) {
                    Integer degree = maxDegree.get(Integer.valueOf(objs[0] + ""));
                    if (degreeCount.containsKey(degree)) {
                        degreeCount.put(degree, degreeCount.get(degree) + 1);
                    } else {
                        degreeCount.put(degree, 1);
                    }
                }
            }
            try {
                resCount = resumeAddStatistics(reqDegree, degreeCount);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            model.setAddResCount(resCount);
        }
    }

    public void fillAddStatistics(CountPosResCate model, List list, List allResList, Map<Integer, Integer> maxDegree, int workLocation, int posType, int reqDegree) {
        //填入职位增量
        fillAddStatisticsPos(model, list, workLocation, posType, reqDegree);
        //填入简历增量
        fillAddReStatistics(model, allResList, maxDegree, workLocation, posType, reqDegree);
    }


    /**
     * 简历活跃统计查询搜索器
     *
     * @param model
     */
    private void fillCountActiveResCate(CountPosResCate model, List<SearchFilterDetail> degreeResumeFilter, Integer degree) {
        try {
            List<Integer> degreeList = Lists.newArrayList();

            if (CollectionUtils.isNotEmpty(degreeResumeFilter)) {
                for (SearchFilterDetail filter : degreeResumeFilter) {
                    if (!degreeList.contains(filter.getId())) {
                        degreeList.add(filter.getId());
                    }
                }
            }

            for (Integer degreeTemp : degreeList) {
                if (degreeTemp.equals(degree)) {
                    SearchFilterDetail resFilter = this.getFilterByDegreeId(degreeResumeFilter, degree);
                    model.setActiveResCount(resFilter != null ? resFilter.getRealCount() : 0);
                }
            }
        } catch (Exception e) {
            log.error("===写入数据异常：" + e.getMessage(), e);
        }
    }

    /**
     * 简历投递量
     *
     * @param model
     */
    private void fillPosApplyCount(CountPosResCate model, List list, int workLocation, int posType, int reqDegree) {
        Gson gson = new Gson();
        //职位的统计增量的数据
        String workLoc = OptionMap.getCityCodeBits(workLocation);
        int applyCount = 0;
        if (CollectionUtils.isNotEmpty(list)) {
            for (Object obj : list) {
                Map pos = (Map) obj;
                int posApplyCount = ((BigInteger)pos.get("pos_apply_count")).intValue();
                String work = String.valueOf(pos.get("work_location"));
                String posTypeVal = String.valueOf(pos.get("pos_type"));
                String posReqDegree = String.valueOf(pos.get("req_degree"));

                //工作地区的判断
                boolean checkWorkLocation = false;
                if (StringUtils.isNotBlank(work) && !StringUtils.equals(work, "[]")) {
                    List<Integer> workLocationList = gson.fromJson(work, new TypeToken<List<Integer>>() {
                    }.getType());
                    if (CollectionUtils.isNotEmpty(workLocationList)) {
                        for (Integer location : workLocationList) {
                            String cityCodeStr = OptionMap.getCityCodeBits(location);
                            if (cityCodeStr.equals(workLoc)) {
                                checkWorkLocation = true;
                                break;
                            }
                        }
                    }
                }

                //职位Id的判断
                boolean checkPosType = false;
                if (StringUtils.isNotBlank(posTypeVal) && !StringUtils.equals(posTypeVal, "[]")) {
                    List<Integer> posTypeList = gson.fromJson(posTypeVal, new TypeToken<List<Integer>>() {
                    }.getType());
                    if (CollectionUtils.isNotEmpty(posTypeList)) {
                        //for(Integer posTpeyId : posTypeList) {
                        Integer posTpeyId = posTypeList.get(0);
                        if (posTpeyId.equals(posType)) {
                            checkPosType = true;
                        }
                        //}
                    }
                }

                if (checkWorkLocation && checkPosType && posReqDegree.equals(reqDegree + "")) {
                    applyCount += posApplyCount;
                }
            }
            model.setPosApplyCount(applyCount);
        }
    }

    /**
     * 填充存量数据
     *
     * @param model
     */
    private void fillCountSavePosResCate(CountPosResCate model, List<SearchFilterDetail> degreePosFilter, List<SearchFilterDetail> degreeResumeFilter, Integer degree) {
        try {
            List<Integer> degreeList = Lists.newArrayList();

            if (CollectionUtils.isNotEmpty(degreePosFilter)) {
                for (SearchFilterDetail filter : degreePosFilter) {
                    if (!degreeList.contains(filter.getId())) {
                        degreeList.add(filter.getId());
                    }
                }
            }

            if (CollectionUtils.isNotEmpty(degreeResumeFilter)) {
                for (SearchFilterDetail filter : degreeResumeFilter) {
                    if (!degreeList.contains(filter.getId())) {
                        degreeList.add(filter.getId());
                    }
                }
            }

            for (Integer degreeTemp : degreeList) {
                if (degree.equals(degreeTemp)) {
                    SearchFilterDetail posFilter = this.getFilterByDegreeId(degreePosFilter, degree);
                    SearchFilterDetail resFilter = this.getFilterByDegreeId(degreeResumeFilter, degree);
                    model.setSavePosCount(posFilter != null ? posFilter.getRealCount() : 0);
                    model.setSaveResCount(resFilter != null ? resFilter.getRealCount() : 0);
                }
            }
        } catch (Exception e) {
            log.error("===写入存量数据异常：" + e.getMessage(), e);
        }
    }



    /**
     * 职位与简历存量统计查询搜索器
     *
     * @param model
     */
//	private void saveCountPosResCate(CountPosResCate model) {
//		try{
//			Session session = HibernateCountUtil.currentSession();
//			//职位学历数量
//			List<Map<String,Object>> posMapList = findByPositonDegreeNum(model);
//			Map<String,Integer> posMap = Maps.newHashMap();
//			if(CollectionUtils.isNotEmpty(posMapList)){
//				for(Map<String,Object> map : posMapList){
//					posMap.put(map.get("degree")+"", Integer.valueOf(map.get("total")+""));
//				}
//			}
//			
//			//简历学历数量
//			List<Map<String,Object>> resumeMapList = findByResumeDegreeNum(model);
//			Map<String,Integer> resumeMap = Maps.newHashMap();
//			if(CollectionUtils.isNotEmpty(resumeMapList)){
//				for(Map<String,Object> map : resumeMapList){
//					resumeMap.put(map.get("degree")+"", Integer.valueOf(map.get("total")+""));
//				}
//			}
//			
//			for(String[] degree : REQDEGREE){
//				//职位数量
//				int posCount = 0;
//				if(null != posMap.get(degree[0]) && !"".equals(posMap.get(degree[0])) && posMap.get(degree[0]) > 0){
//					posCount = posMap.get(degree[0]);
//				}
//				
//				//简历数量
//				int resCount = 0;
//				if(null != resumeMap.get(degree[0]) && !"".equals(resumeMap.get(degree[0])) && resumeMap.get(degree[0]) > 0){
//					resCount = resumeMap.get(degree[0]);
//				}
//				
//				if(posCount > 0 || resCount > 0){
//					CountPosResCate entry = new CountPosResCate();
//					BeanUtils.copyProperties(model, entry);
//					entry.setReqDegree(Integer.valueOf(degree[0]));
//					entry.setSavePosCount(posCount);
//					entry.setSaveResCount(resCount);
//					session.save(entry);
//				}
//			}
//		}catch (Exception e) {
//            log.error("===写入数据异常：" + e.getMessage(), e);
//        } 
//	}

    /**
     * 根据学历分组查询简历数量
     *
     * @param model
     * @return
     */
//	private List<Map<String,Object>> findByResumeDegreeNum(CountPosResCate model){
//		Session session = HibernateQuery2Util.currentSession();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		Date loginDate = DateUtils.addDays(new Date(), TIMEPERIOD);// 一周之内新增的职位
//		String startDate = sdf.format(loginDate)  + " 00:00:00";// 上次执行后第二天的时间
//		String endDate = sdf.format(new Date()) + " 23:59:59";
//		StringBuilder sql = new StringBuilder("SELECT degree,COUNT(id) total ");
//		sql.append(" FROM `resume_export_brief` ");
//		sql.append(" WHERE job_location1 LIKE ':jobLoc%' AND job_code1 = :jobCode ");
//		sql.append(" AND fre_date BETWEEN :startDate AND :endDate ");
//		sql.append(" GROUP BY degree ");
//		Query query = session.createSQLQuery(sql.toString());
//		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
//		query.setParameter("jobLoc", model.getWorkLocation());
//		query.setParameter("jobCode", model.getPosType());
//		query.setParameter("startDate", startDate);
//		query.setParameter("endDate", endDate);
//		return query.list();
//	}

    /**
     * 根据学历分组查询职位数量
     *
     * @param model
     * @return
     */
//	private List<Map<String,Object>> findByPositonDegreeNum(CountPosResCate model){
//		Session session = HibernateQuery2Util.currentSession();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		Date loginDate = DateUtils.addDays(new Date(), TIMEPERIOD);// 一周之内新增的职位
//		String startDate = sdf.format(loginDate) + " 00:00:00";// 上次执行后第二天的时间
//		String endDate = sdf.format(new Date())  + " 23:59:59";
//		StringBuilder sql = new StringBuilder("SELECT degree,COUNT(id) total ");
//		sql.append(" FROM `pos_export_brief` ");
//		sql.append(" WHERE job_location1 LIKE ':jobLoc% AND job_code1 = :jobCode ");
//		sql.append(" AND fre_date BETWEEN :startDate AND :endDate ");
//		sql.append(" GROUP BY degree ");
//		Query query = session.createSQLQuery(sql.toString());
//		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
//		query.setParameter("jobLoc", model.getWorkLocation());
//		query.setParameter("jobCode", model.getPosType());
//		query.setParameter("startDate", startDate);
//		query.setParameter("endDate", endDate);
//		return query.list();
//	}
    private SearchFilterDetail getFilterByDegreeId(List<SearchFilterDetail> filterList, Integer degree) {
        if (CollectionUtils.isNotEmpty(filterList)) {
            for (SearchFilterDetail filter : filterList) {
                if (filter.getId().equals(degree)) {
                    return filter;
                }
            }
        }
        return null;
    }

    /**
     * 职位统计增量数据
     *
     * @param session
     * @return
     * @throws HibernateException
     * @throws ParseException
     */
    private List posAddStatistics() throws HibernateException, ParseException {
        Session salveBaseSession = HibernateSalveBaseUtil.currentSession();
        StringBuilder sql = new StringBuilder("SELECT cp.work_location,cp.pos_type,cp.req_degree FROM `com_position` cp ");
        sql.append(" LEFT JOIN com_right cri ON cp.com_id = cri.com_id ");
        sql.append(" WHERE cp.create_date >= :startDate AND cp.create_date < :createEndDate ");
        sql.append(" AND cp.pos_status > 0 AND cp.del_status != -1 AND cp.end_date > :endDate ");
        sql.append(" AND cri.member_type >= 1 AND cri.member_type <= 6 AND cri.expire_date > :expireDate");
        SQLQuery query = salveBaseSession.createSQLQuery(sql.toString());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        Date beforDate = DateUtils.addDays(date, TIMEPERIOD);// 一周之内新增的职位
        String startDate = sdf.format(beforDate);// 上次执行后第二天的时间
        String endDate = sdf.format(date);
        query.setParameter("startDate", sdf.parse(startDate));
        query.setParameter("createEndDate", sdf.parse(endDate));
        query.setParameter("endDate", sdf.parse(endDate));
        query.setParameter("expireDate", sdf.parse(endDate));
        return query.list();
    }

    /**
     * 简历投递量数据
     *
     * @return
     * @throws HibernateException
     * @throws ParseException
     */
    private List posApplyDatas() throws HibernateException, ParseException {
        Session salveBaseSession = HibernateSalveBaseUtil.currentSession();
        Session actionSession = HibernateActionUtil.currentSession();
        String sql = "select pos_id,count(*) as pos_apply_count from per_pos_apply where cre_time >= :startDate and cre_time < :endDate group by pos_id";
        SQLQuery query = actionSession.createSQLQuery(sql);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        Date beforDate = DateUtils.addDays(date, TIMEPERIOD);// 一周之内新增的职位
        String startDate = sdf.format(beforDate);// 上次执行后第二天的时间
        String endDate = sdf.format(date);
        query.setParameter("startDate", sdf.parse(startDate));
        query.setParameter("endDate", sdf.parse(endDate));
        query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
        List<Map> list = query.list();
        for(Map pos : list){
            SQLQuery sqlQuery = salveBaseSession.createSQLQuery("SELECT work_location,pos_type,req_degree FROM `com_position` where id = :id");
            sqlQuery.setParameter("id", pos.get("pos_id"));
            sqlQuery.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
            Map posInfo = (Map)sqlQuery.uniqueResult();
            pos.putAll(posInfo);
        }
        return list;
    }

    /**
     * 默认简历的最高学历的统计次数
     *
     * @param reqDegree
     * @param maxDegreeCount
     * @return
     * @throws HibernateException
     * @throws ParseException
     */
    private int resumeAddStatistics(Integer reqDegree, Map<Integer, Integer> maxDegreeCount) throws HibernateException, ParseException {
        int count = 0;
        if (MapUtils.isNotEmpty(maxDegreeCount)) {
            if (maxDegreeCount.containsKey(reqDegree))
                count = maxDegreeCount.get(reqDegree);
        }
        return count;
    }

    /**
     * 指定时间内所新增的简历数
     *
     * @param session
     * @return
     */
    private List getDegreeCount() {
        Session salveBaseSession = HibernateSalveBaseUtil.currentSession();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        Date beforDate = DateUtils.addDays(date, TIMEPERIOD);//一周之内新增的职位
        String startDate = sdf.format(beforDate);//上次执行后第二天的时间
        String endDate = sdf.format(date);

        StringBuilder sql = new StringBuilder("SELECT pu.id,pr.intent_info FROM `per_user` pu ");
        sql.append(" INNER JOIN `per_resume` pr ON pu.res_id = pr.id  AND pr.education_info IS NOT NULL ");
        sql.append(" WHERE pr.pass_date >= :startDate AND pr.pass_date < :endDate ");
        sql.append(" AND pu.public_settings = 0 and pr.pass > 0 ");

        SQLQuery query = salveBaseSession.createSQLQuery(sql.toString());
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);
        return query.list();
    }

    /**
     * 职位与简历存量使用搜索器进行查询
     *
     * @param url
     * @param isPos
     * @param model
     * @return
     */
    private List<SearchFilterDetail> httpClient(String url, boolean isPos, CountPosResCate model, Integer updatePeriod) {
        CloseableHttpClient httpClient = null;// 职位连接客户端
        List<SearchFilterDetail> filterList = null;
        List<NameValuePair> paramList = Lists.newArrayList();
        if (isPos) {
            paramList.add(new BasicNameValuePair("locationList", StringUtils.defaultIfBlank(model.getWorkLocation() + "", "")));
            paramList.add(new BasicNameValuePair("searchType", "2"));
        } else {
            paramList.add(new BasicNameValuePair("workareaList", StringUtils.defaultIfBlank(model.getWorkLocation() + "", "")));
        }

        if (updatePeriod != null && updatePeriod > 0) {
            paramList.add(new BasicNameValuePair("updateIn", updatePeriod + ""));
        }

        paramList.add(new BasicNameValuePair("posTypeList", StringUtils.defaultIfBlank(model.getPosType() + "", "")));
        paramList.add(new BasicNameValuePair("authToken", MD5Builder.md5(Constants.API_COMMON_AUTH_KEY, Constants.API_COMMON_AUTH_PASS)));
        try {
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(20000).setConnectTimeout(20000).build();// 设置请求和传输超时时间
            httpClient = HttpClients.createDefault();
            HttpPost httppost = new HttpPost(url);
            httppost.setConfig(requestConfig);
            httppost.setEntity(new UrlEncodedFormEntity(paramList, Consts.UTF_8));
            HttpResponse response = httpClient.execute(httppost);
            HttpEntity posEntity = response.getEntity();
            String jsonStr = EntityUtils.toString(posEntity, "utf-8");
            Gson gson = new Gson();
            EntityUtils.consume(posEntity);
            if (isPos) {
                PosSearchCountResult resultPosVo = gson.fromJson(jsonStr, PosSearchCountResult.class);
                if (resultPosVo.isSuccess()) {
                    filterList = resultPosVo.getFilter().getDegreeFilter();
                }
            } else {
                ResumeSearchCountResult resultResumeVo = gson.fromJson(jsonStr, ResumeSearchCountResult.class);
                if (resultResumeVo.isSuccess()) {
                    filterList = resultResumeVo.getFilter().getDegreeFilter();
                }
            }
            httppost.releaseConnection();
            httpClient.close();
        } catch (Exception e) {
            log.error("===调用职位/简历接口查询搜索器职位/简历存量列表失败：" + e.getMessage(), e);
        }

        return filterList;
    }

    /**
     * 获取默认简历Map
     *
     * @return
     * @throws ParseException
     * @throws HibernateException
     */
    private Map<Integer, Integer> getMaxDegree() throws HibernateException, ParseException {
        Session salveBaseSession = HibernateSalveBaseUtil.currentSession();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date loginDate = DateUtils.addDays(new Date(), TIMEPERIOD);// 一周之内新增的职位
        String startDate = sdf.format(loginDate);// 上次执行后第二天的时间
        String endDate = sdf.format(new Date());
        StringBuilder sql = new StringBuilder("SELECT pu.id,pr.education_info FROM `per_user` pu ");
        sql.append(" INNER JOIN `per_resume` pr ON pu.res_id = pr.id  AND pr.education_info IS NOT NULL ");
        sql.append(" WHERE pr.pass_date >= :startDate AND pr.pass_date < :endDate ");
        sql.append(" AND pu.public_settings = 0 and pr.pass > 0 ");

        SQLQuery query = salveBaseSession.createSQLQuery(sql.toString());
        query.setParameter("startDate", sdf.parse(startDate));
        query.setParameter("endDate", sdf.parse(endDate));
        Map<Integer, Integer> params = Maps.newHashMap();
        List list = query.list();
        Gson gson = new Gson();
        if (CollectionUtils.isNotEmpty(list)) {
            for (Object obj : list) {
                Object[] objs = (Object[]) obj;
                try {
                    Type type = new TypeToken<List<PerEducationInfoVo>>() {
                    }.getType();
                    List<PerEducationInfoVo> educationList = gson.fromJson(objs[1] + "", type);
                    CollectionSortUtil.sortTheList(educationList, "degree", "DESC");
                    if (CollectionUtils.isNotEmpty(educationList)) {
                        PerEducationInfoVo vo = educationList.get(0);
                        if (null != vo.getDegree()) {
                            params.put(Integer.valueOf(objs[0] + ""), vo.getDegree());
                        }
                    }
                } catch (JsonSyntaxException e) {
                    e.printStackTrace();
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        }
        return params;
    }
}
