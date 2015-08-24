package com.job5156.task.init;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.joda.time.DateTime;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.job5156.common.Constants;
import com.job5156.common.jedis.JedisFactory;
import com.job5156.common.jedis.JedisTemplate;
import com.job5156.common.util.HibernateQuery2Util;
import com.job5156.common.util.HibernateSalveBaseUtil;
import com.job5156.common.util.KeyMaskUtil;
import com.job5156.model.com.ComDepartment;
import com.job5156.model.com.ComInfo;
import com.job5156.model.init.PosExportBrief;

/**
 * 职位初始化
 * 
 * @author Andy
 * @Date	2014-12-03 9:2:42
 *
 */
public class InitPosBrief {
	private static final Logger log = Logger.getLogger(InitPosBrief.class);
	private final static int POS_TYPE_ONLINE = 1;
	private JedisFactory jedisFactory = JedisFactory.getInstance();

	public static void main(String[] args){
		InitPosBrief init = new InitPosBrief();
		init.init(new Date(),5000);
		HibernateSalveBaseUtil.closeSession();
		HibernateQuery2Util.closeSession();
	}
	
	/**
	 * 根据日期和每页需要显示的数量
	 * 
	 * @param date
	 * @param pageSize
	 */
	public void init(Date date,int pageSize) {
		log.error("==>启动职位初始化程序：" + DateTime.now().toString("yyyy-MM-dd HH:mm:ss"));
		Session query2Session = HibernateQuery2Util.currentSession(); 
		Date nowDate = null;
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			nowDate = format.parse(format.format(date));
		} catch (ParseException e) {
			log.error("日期解析异常："+e.toString());
		}

		if (null != nowDate) {
			JedisTemplate jedisTemplate = jedisFactory.getJedisTemplate(Constants.INIT_EFFECTIVE_POS_KEY);
			// 求总条数需要进行分页
			int total = countPos(nowDate);
			// 每页取5000条
			int pageNo = total % pageSize == 0 ? total / pageSize : total / pageSize + 1;
			for (int i = 0; i < pageNo; i++) {
				String redisPosId = "";
				if(jedisTemplate.isKeyExist(Constants.INIT_EFFECTIVE_POS_KEY)){
					// 从redis中获取
					redisPosId = jedisTemplate.readFromString(Constants.INIT_EFFECTIVE_POS_KEY);
				}
				
				int posId = NumberUtils.toInt(redisPosId, 0);

				// 获取comPosition的数据
				List<Map<String, Object>> mapList = getComPositionList(posId, nowDate);
				if (CollectionUtils.isNotEmpty(mapList)) {
					for (Map<String, Object> map : mapList) {
						PosExportBrief posBrief = toPosBrief(map);
						if (null != posBrief) {
							// 将comPos的数据写入到PosExportBrief中
							query2Session.save(posBrief);
							query2Session.flush();
							query2Session.clear();
							// 将posId存入redis中
							jedisTemplate.writeToString(Constants.INIT_EFFECTIVE_POS_KEY, posBrief.getPosId()+"");
						}
					}
					mapList.clear();
				}
			}
		}
		log.error("==>结束职位初始化程序：" + DateTime.now().toString("yyyy-MM-dd HH:mm:ss"));
	}
	
	/**
	 * 获取职位表的数据
	 * 
	 * @param posId
	 * @param nowDate
	 * @return
	 */
	private List<Map<String,Object>> getComPositionList(Integer posId,Date nowDate){
		StringBuilder sql = new StringBuilder("SELECT cp.id,cp.com_id AS comId,");
		sql.append("cp.department_id AS departmentId,cp.pos_type AS posType,cp.pos_name AS posName,cp.pos_status AS posStatus,");
		sql.append("cp.refresh_date AS refreshDate,cp.end_date AS endDate,cp.update_date AS updateDate,cp.work_location AS workLocation,");
		sql.append("cp.req_gender AS reqGender,cp.req_degree AS reqDegree,cp.req_age_min AS reqAgeMin,cp.req_age_max AS reqAgeMax,");
		sql.append("cp.req_work_year AS reqWorkYear,cp.description,cp.lat,cp.lng ");
		sql.append(" FROM `com_position` cp");
		sql.append(" JOIN `com_right` cr ON cp.com_id = cr.com_id ");
		sql.append(" WHERE cp.pos_status > 0 AND cp.del_status <> - 1 ");
		sql.append("AND cp.id > :id AND cp.end_date >= :endDate ");
		sql.append("AND cr.expire_date >= :expDate ");
		sql.append(" ORDER BY id LIMIT 5000 ");
		Session baseSession = HibernateSalveBaseUtil.currentSession();
		baseSession.clear();
		SQLQuery query = baseSession.createSQLQuery(sql.toString());
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		query.setParameter("id", posId);
		query.setParameter("endDate", nowDate);
		query.setParameter("expDate", nowDate);
		return query.list();
	}
	
	/**
	 * 首先计算职位表的总数量
	 * 
	 * @param session
	 * @param nowDate
	 * @return
	 */
	private int countPos(Date nowDate){
		Session baseSession = HibernateSalveBaseUtil.currentSession();
		StringBuilder sql = new StringBuilder("SELECT COUNT(cp.id)");
		sql.append(" FROM `com_position` cp");
		sql.append(" JOIN `com_right` cr ON cp.com_id = cr.com_id ");
		sql.append(" WHERE cp.pos_status > 0 AND cp.del_status <> - 1 ");
		sql.append(" AND cp.end_date >= :endDate ");
		sql.append(" AND cr.expire_date >= :expDate ");
		SQLQuery query = baseSession.createSQLQuery(sql.toString());
		query.setParameter("endDate", nowDate);
		query.setParameter("expDate", nowDate);
		return NumberUtils.toInt(String.valueOf(query.uniqueResult()), 0);
	}
	
	/**
	 * 将comPosition转为PosExportBrief对象
	 * 
	 * @param session
	 * @param comPosition
	 * @return
	 */
	private PosExportBrief toPosBrief(Map<String,Object> paramMap) {
		if (MapUtils.isEmpty(paramMap)) {
			return null;
		} else {
			PosExportBrief brief = new PosExportBrief();
			brief.setId(KeyMaskUtil.posIdToNo(Integer.valueOf(paramMap.get("id")+""), (short) POS_TYPE_ONLINE));
			brief.setPosId(Integer.valueOf(paramMap.get("id")+""));
			brief.setPosName(paramMap.get("posName")+"");
			brief.setComId(Integer.valueOf(paramMap.get("comId")+""));
			brief.setDeptId(Integer.valueOf(paramMap.get("departmentId")+""));

			brief.setPosFlag(Integer.valueOf(paramMap.get("posStatus")+""));

			Gson gson = new Gson();
			List<Integer> workLocationList = gson.fromJson(paramMap.get("workLocation")+"", new TypeToken<List<Integer>>() {}.getType());
			brief.setJobLocation1(CollectionUtils.size(workLocationList) > 0 ? workLocationList.get(0) : null);
			brief.setJobLocation2(CollectionUtils.size(workLocationList) > 1 ? workLocationList.get(1) : null);
			brief.setJobLocation3(CollectionUtils.size(workLocationList) > 2 ? workLocationList.get(2) : null);

			List<Integer> jobCodeList = getPosTypeList(paramMap.get("posType")+"");
			if (CollectionUtils.isNotEmpty(jobCodeList)) {
				brief.setJobCode1(CollectionUtils.size(jobCodeList) > 0 ? jobCodeList.get(0) : null);
				brief.setJobCode2(CollectionUtils.size(jobCodeList) > 1 ? jobCodeList.get(1) : null);
				brief.setJobCode3(CollectionUtils.size(jobCodeList) > 2 ? jobCodeList.get(2) : null);
			}

			brief.setWorkedYear(Integer.valueOf(paramMap.get("reqWorkYear")+""));
			brief.setDegree(Integer.valueOf(paramMap.get("reqDegree")+""));
			brief.setAgeUp(Integer.valueOf(paramMap.get("reqAgeMin")+""));
			brief.setAgeDown(Integer.valueOf(paramMap.get("reqAgeMax")+""));
			brief.setGender(Integer.valueOf(paramMap.get("reqGender")+""));
			brief.setPosDesc(paramMap.get("description")+"");
			if(StringUtils.isNotBlank(paramMap.get("lat")+"") && !(paramMap.get("lat")+"").equals("null")){
				brief.setLat(Double.valueOf(paramMap.get("lat")+""));
			}
			
			if(StringUtils.isNotBlank(paramMap.get("lng")+"") && !(paramMap.get("lng")+"").equals("null")){
				brief.setLng(Double.valueOf(paramMap.get("lng")+""));
			}

			Session baseSession = HibernateSalveBaseUtil.currentSession();
			baseSession.clear();
			ComInfo comInfo = (ComInfo)baseSession.get(ComInfo.class,Integer.valueOf(paramMap.get("comId")+""));
			if (comInfo != null) {
				brief.setComName(comInfo.getComName());
				brief.setComDesc(comInfo.getCompanyIntroduction());
			}

			ComDepartment comDepartment = (ComDepartment)baseSession.get(ComDepartment.class,Integer.valueOf(paramMap.get("departmentId")+""));
			if (comDepartment != null) {
				brief.setDeptName(comDepartment.getDeptName());
			}

			brief.setFreDate((Date)paramMap.get("refreshDate"));
			brief.setEndDate((Date)paramMap.get("endDate"));
			brief.setUpdateDate((Date)paramMap.get("updateDate"));
			
			// 从REDIS中获取当前职位的热度数据
			String redisKey = Constants.REDIS_KEY_POS_HOT_DEGREE_PREFIX + KeyMaskUtil.calPosIdRedisRegion(Integer.valueOf(paramMap.get("id")+""));
			JedisTemplate jedisTemplate = jedisFactory.getJedisTemplate(redisKey);
			Map<String, Integer> hotDegree = jedisTemplate.readFromMap(redisKey, Integer.class);
			if(MapUtils.isNotEmpty(hotDegree)){
				brief.setHotDegree(hotDegree.get(Integer.valueOf(paramMap.get("id")+"")));
			}
			
			return brief;
		}
	}
	
	/**
	 * 获取岗位类别
	 * 
	 * @param posType
	 * @return
	 */
	private List<Integer> getPosTypeList(String posType){
        if(StringUtils.isNotBlank(posType) && !StringUtils.equals(posType, "[]")) {
            Gson gson = new Gson();
            return gson.fromJson(posType, new TypeToken<List<Integer>>() {}.getType());
        }
        return null;
    }
}
