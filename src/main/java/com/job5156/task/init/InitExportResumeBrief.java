package com.job5156.task.init;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
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
import com.job5156.model.init.ResumeExportBrief;
import com.job5156.model.per.PerResume;
import com.job5156.vo.per.PerIntentVo;
import com.job5156.vo.per.PerResumeVo;

/**
 * 简历初始化
 * 
 * @author Andy
 * @Date	2014-12-05 8:22:42
 *
 */
public class InitExportResumeBrief {
	private static final Logger log = Logger.getLogger(InitExportResumeBrief.class);

	private JedisFactory jedisFactory = JedisFactory.getInstance();
	
	
	public static void main(String[] args){
		InitExportResumeBrief init = new InitExportResumeBrief();
		init.init(5000);
		HibernateSalveBaseUtil.closeSession();
		HibernateQuery2Util.closeSession();
	}
	
	/**
	 * 每页需要显示的数量
	 * 
	 * @param pageSize
	 */
	public void init(int pageSize) {
		log.error("==>启动简历初始化程序：" + DateTime.now().toString("yyyy-MM-dd HH:mm:ss"));
		Session query2Session = HibernateQuery2Util.currentSession(); 

		JedisTemplate jedisTemplate = jedisFactory.getJedisTemplate(Constants.INIT_EFFECTIVE_RESUME_KEY);
		// 求总条数需要进行分页
		int total = countResume();
		// 每页取5000条
		int pageNo = total % pageSize == 0 ? total / pageSize : total / pageSize + 1;
		for (int i = 0; i < pageNo; i++) {
			String redisPosId = "";
			if(jedisTemplate.isKeyExist(Constants.INIT_EFFECTIVE_RESUME_KEY)){
				// 从redis中获取
				redisPosId = jedisTemplate.readFromString(Constants.INIT_EFFECTIVE_RESUME_KEY);
			}
			
			int posId = NumberUtils.toInt(redisPosId, 0);
			// 获取comPosition的数据
			List<Map<String,Object>> mapList = getPerUserList(posId,pageSize);
			if (CollectionUtils.isEmpty(mapList)) {
				break;
			}
			for(Map<String,Object> map : mapList){
				try {
					ResumeExportBrief resumeBrief = toPosBrief(map);
					if (null != resumeBrief) {
						if(null == resumeBrief.getAccountId() || resumeBrief.getAccountId().equals(0)){
							continue;
						}
						
						// 将posId存入redis中
						jedisTemplate.writeToString(Constants.INIT_EFFECTIVE_RESUME_KEY, resumeBrief.getAccountId()+"");
						// 将comPos的数据写入到PosExportBrief中
						query2Session.save(resumeBrief);
						query2Session.flush();
						query2Session.clear();
						resumeBrief = null;
					}
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}catch(HibernateException e){
					e.printStackTrace();
				}
			}
			mapList.clear();
		}
	}
	
	/**
	 * 获取职位表的数据
	 * 
	 * @param posId
	 * @param nowDate
	 * @return
	 */
	private List<Map<String,Object>> getPerUserList(Integer userId,int pageSize){
		Session baseSession = HibernateSalveBaseUtil.currentSession();
		baseSession.clear();
		StringBuilder sql = new StringBuilder(" SELECT pu.id,pu.res_id AS resId,pu.user_name AS userName,");
		sql.append("pu.gender,pu.birthday,pu.mobile,pu.email,pu.jobyear_type AS jobyearType,pu.create_date AS createDate,");
		sql.append("pu.login_date AS loginDate,pu.location,pu.account_from AS accountFrom,pu.address ");
		sql.append(" FROM `per_resume` pr JOIN per_user pu ON pr.id = pu.res_id ");
		sql.append(" WHERE pr.pass > 0 AND pr.language_type <> 1 ");
		sql.append("AND pu.public_settings = 0 AND pu.id >:id ");
		sql.append(" ORDER BY pu.id LIMIT "+pageSize);
		Query query = baseSession.createSQLQuery(sql.toString());
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		query.setParameter("id", userId);
		return query.list();
	}
	
	/**
	 * 首先计算职位表的总数量
	 * 
	 * @param session
	 * @param nowDate
	 * @return
	 */
	private int countResume(){
		Session baseSession = HibernateSalveBaseUtil.currentSession();
		StringBuilder sql = new StringBuilder(" SELECT COUNT(pu.id) ");
		sql.append(" FROM `per_resume` pr ");
		sql.append(" JOIN per_user pu ON pr.id = pu.res_id ");
		sql.append(" WHERE pr.pass > 0 AND pr.language_type <> 1 ");
		sql.append("AND pu.public_settings = 0 ");
		Query query = baseSession.createSQLQuery(sql.toString());
		return NumberUtils.toInt(String.valueOf(query.uniqueResult()),0);
	}
	
	/**
	 * 将comPosition转为PosExportBrief对象
	 * 
	 * @param session
	 * @param comPosition
	 * @return
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	private ResumeExportBrief toPosBrief(Map<String,Object> data) throws IllegalAccessException, InvocationTargetException {
		if (MapUtils.isEmpty(data)) {
			return null;
		} else {
			Session baseSession = HibernateSalveBaseUtil.currentSession();
			baseSession.clear();
			PerResume perResume = (PerResume)baseSession.get(PerResume.class, Integer.valueOf(data.get("resId")+""));
			PerResumeVo resumeVo = new PerResumeVo(perResume);
        	PerIntentVo intentInfoVo = resumeVo.getIntentInfoVo();
        	ResumeExportBrief brief = new ResumeExportBrief();
        	
        	brief.setId(perResume.getId());
            brief.setResumeId(perResume.getId());
            brief.setUserName(data.get("userName")+"");
            brief.setGender(Integer.valueOf(data.get("gender")+""));
            brief.setBirthday((Date)data.get("birthday"));
            brief.setAge(resumeVo.getAge());
            brief.setDegree(resumeVo.getMaxDegree() == null ? null :  resumeVo.getMaxDegree().getDegree());
            brief.setMobile(data.get("mobile")+"");
            brief.setEmail(data.get("email")+"");
            brief.setWorkYear(NumberUtils.toInt(data.get("jobyearType")+"",0));
            brief.setAddress(StringUtils.isNotBlank(data.get("address")+"") == true ?data.get("address")+"" : "");
            brief.setCreateDate((Date)data.get("createDate") == null ? DateTime.now().toDate() : (Date)data.get("createDate"));
            brief.setUpdateDate(perResume.getUserLastEditDate() == null ? DateTime.now().toDate() : perResume.getUserLastEditDate());
            brief.setLoginDate((Date)data.get("loginDate"));
            brief.setFreDate(perResume.getFreDate());
            brief.setPass(perResume.getPass() == null ? 0 : perResume.getPass());
            brief.setLocation(NumberUtils.toInt(data.get("location")+"",0));
            
            brief.setAccountFrom(NumberUtils.toInt(data.get("accountFrom")+"", 0));
            brief.setResumeFrom(perResume.getComeFrom());
            brief.setAccountId(Integer.valueOf(data.get("id")+""));
            brief.setLanguageType(perResume.getLanguageType());
            brief.setDefaultFlag(Integer.valueOf(data.get("resId")+"") == perResume.getId() ? 0 : 1);

            try{
	            if(StringUtils.isNotBlank(intentInfoVo.getJobLocation())) {
	                String[] jobLocations = intentInfoVo.getJobLocation().split(",");
	            	if(jobLocations.length > 0 && NumberUtils.isNumber(jobLocations[0])) {
	            		brief.setJobLocation1(new Double(jobLocations[0]).intValue());
	                }
	            	if(jobLocations.length > 1 && NumberUtils.isNumber(jobLocations[1])) {
	            		brief.setJobLocation2(new Double(jobLocations[1]).intValue());
	                }
	            	if(jobLocations.length > 2 && NumberUtils.isNumber(jobLocations[2])) {
	            		brief.setJobLocation3(new Double(jobLocations[2]).intValue());
	                }
	            }
            }catch(NullPointerException e){
            	return null;
            }

            if(intentInfoVo.getJobCode() != null) {
                String[] jobCodes = intentInfoVo.getJobCode().split(",");
                if(jobCodes.length > 0 && NumberUtils.isNumber(jobCodes[0])) {
            		brief.setJobCode1(new Double(jobCodes[0]).intValue());
                }
            	if(jobCodes.length > 1 && NumberUtils.isNumber(jobCodes[1])) {
            		brief.setJobCode2(new Double(jobCodes[1]).intValue());
                }
            	if(jobCodes.length > 2 && NumberUtils.isNumber(jobCodes[2])) {
            		brief.setJobCode3(new Double(jobCodes[2]).intValue());
                }
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
