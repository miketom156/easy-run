package com.job5156.task.count;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.google.common.collect.Lists;
import com.job5156.common.PvCitySiteEnum;
import com.job5156.common.util.HibernateCountUtil;
import com.job5156.model.count.PVCountCitySite;

/**
 * 从旧版网站的PvCount表中的数据小于2014-11-24，
 * 并且剔除2014-01-01到2014-02-06的其它数据
 * @author Andy
 * @date 2015-01-13 15:07:56
 *
 */
public class CountOldWebPvCountToEyas {
	private static Logger log = Logger.getLogger(CountOldWebPvCountToEyas.class);
	private  JdbcTemplate jdbcTemplateCount = HibernateCountUtil.getJdbcTemplate();
	
	public static void main(String[] args) {
		log.error("旧版网站PvCount数据导入新版网站开始……");
		CountOldWebPvCountToEyas eyas = new CountOldWebPvCountToEyas();
		try {
			eyas.save();
		} catch (ParseException e) {
			log.error("数据保存时日期转换失败，失败原因：",e);
		} catch(DataAccessException e1){
			log.error("数据保存报错，错误信息：",e1);
		}
		HibernateCountUtil.closeSession();
		log.error("旧版网站PvCount数据导入新版网站结束。");
	}

	private void save() throws ParseException,DataAccessException {
		List<PVCountCitySite> list = getData();
		if(CollectionUtils.isNotEmpty(list)){
			for(PVCountCitySite model : list){
				insertPVCountCitySite(model);
			}
		}
	}
	
	private List<PVCountCitySite> getData() throws ParseException{
		Session session = HibernateCountUtil.currentSession();
		Query query = session.createSQLQuery(getPvCountSQL());
		List list = query.list();
		List<PVCountCitySite> dataList = Lists.newArrayList();
		if(CollectionUtils.isNotEmpty(list)){
			for(Object obj : list){
				Object[] objs = (Object[])obj;
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				PVCountCitySite model = new PVCountCitySite();
				model.setIpCountCity(NumberUtils.toInt(objs[0]+""));
				model.setIpCountSite(NumberUtils.toInt(objs[1]+""));
				model.setPvCountCity(NumberUtils.toInt(objs[2]+""));
				model.setPvCountSite(NumberUtils.toInt(objs[3]+""));
				model.setCreateDtae(sdf.parse(objs[4]+""));
				boolean isTrue = false;
				int code = NumberUtils.toInt(objs[5]+"");
				if(code == 9999){
					code = 0;
				}
				for(PvCitySiteEnum citySite: PvCitySiteEnum.values()){
					if(citySite.getCityCode().equals(code)){
						isTrue = true;
						model.setSiteId(citySite.getSiteId());
						break;
					}
				}
				if(isTrue)
					dataList.add(model);
			}
		}
		return dataList;
	}
	
	private String getPvCountSQL(){
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ipCity,ipSite,pvCity,pvSite,acceptTime,cityCode ");
		sql.append("FROM PV_Count WHERE acceptTime < '2014-11-24' ");
		sql.append(" AND (acceptTime NOT BETWEEN '2014-01-01' AND '2014-02-06')");
		return sql.toString();
	}
	
	private void insertPVCountCitySite(PVCountCitySite pvCountCitySite) throws DataAccessException{
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
}
