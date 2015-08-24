package com.job5156.run.count;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.google.common.collect.Lists;
import com.job5156.common.util.HibernateCountUtil;
import com.job5156.model.statistics.CountPvCityAll;

/**
 * 将旧版网站中的Count_CityAll_V3的数据导入新版网站count_pv_city_all
 * @author Andy
 *
 */
public class RunImportCityAllV3 {
	private Logger log = Logger.getLogger(RunImportCityAllV3.class);
	private JdbcTemplate jdbcTemplateCount = HibernateCountUtil.getJdbcTemplate();
	
	private static String[][] areaDates = {
		{"2014-1-01 00:00:00","2014-12-02 23:59:59"},
		{"2013-1-01 00:00:00","2013-12-31 23:59:59"},
		{"2012-1-01 00:00:00","2012-12-31 23:59:59"},
		{"2011-1-01 00:00:00","2011-12-31 23:59:59"},
		{"2010-11-12 00:00:00","2011-12-31 23:59:59"},
	};
	
	private static String[][] nationwideDates = {
		{"2014-1-01 00:00:00","2014-12-02 23:59:59"},
		{"2013-1-01 00:00:00","2013-12-31 23:59:59"},
		{"2012-1-01 00:00:00","2012-12-31 23:59:59"},
		{"2011-1-01 00:00:00","2011-12-31 23:59:59"},
		{"2010-11-13 00:00:00","2011-12-31 23:59:59"},
	};

	public static void main(String[] args) throws ParseException {
		RunImportCityAllV3 allV3 = new RunImportCityAllV3();
		allV3.run();
	}

	private void run(){
		log.error("城市综合统计V3数据开始采集...");
		//各地区
		for(int i=0; i < areaDates.length ; i++){
			log.error("执行到的日期："+areaDates[i][0]+" ~ "+areaDates[i][1]);
			String areaSql = getSQL(areaDates[i][0],areaDates[i][1]);
			List<CountPvCityAll> areaList = getData(areaSql);
			saveArea(areaList);
			areaList = null;
			areaSql = null;
		}
		
		//全国
		Connection con = null;
		try {
			con = getConnection();
			for(int i=0; i < nationwideDates.length ; i++){
				log.error("执行到的日期："+nationwideDates[i][0]+" ~ "+nationwideDates[i][1]);
				String nationwideSql = getNationwideSQL(nationwideDates[i][0],nationwideDates[i][1]);
				
					List<CountPvCityAll> nationwideList = getNationwideData(nationwideSql,con);
					save(nationwideList);
					nationwideList = null;
					nationwideSql = null;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		log.error("城市综合统计V3数据采集结束.");
	}
	
	//各地区
	private String getSQL(String startDate,String endDate){
		StringBuilder sql = new StringBuilder("SELECT v3.ip,v3.pv,v3.`positionCount`, v3.`selfPosition`,v3.`resemeLoaction`,");
		sql.append("v3.`resumeApply`,v3.`perEdit`,v3.`perValid`,v3.`comreg`,");
		sql.append("v3.`perToCom`,v3.`comviewresume`,v3.`comToPer`,v3.`comCount`,");
		sql.append("v3.`posOut`,v3.`posOutTrue`,v3.`cityid`,v3.`credate` ");
		sql.append("FROM Count_CityAll_V3 v3 ");
		sql.append("WHERE v3.credate BETWEEN '"+startDate+"' AND '"+endDate+"' ");
		sql.append("GROUP BY credate,cityid ");
		return sql.toString();
	}
	
	//各地区
	private String getNationwideSQL(String startDate,String endDate){
		StringBuilder sql = new StringBuilder("SELECT v3.`ipcount`,v3.`pagecount`, v3.`composcount`,v3.`perreg` , v3.`percount` ,v3.`peredit`,");
		sql.append("v3.`comreg`,v3.`resumetopos`,v3.`comviewresume`,v3.`comtoper`,");
		sql.append("v3.`comcount`,v3.`funddate` ");
		sql.append("FROM Sys_Count_All_V3 v3 WHERE v3.funddate BETWEEN '"+startDate+"' AND '"+endDate+"' ");
		return sql.toString();
	}
	
	//全国数据
	private List<CountPvCityAll>  getNationwideData(String sql,Connection con) throws ClassNotFoundException, SQLException{
		Statement sta = con.createStatement();
		ResultSet rs = sta.executeQuery(sql);
		List<CountPvCityAll> list = Lists.newArrayList();
		while(rs.next()){
			CountPvCityAll cityAll = new CountPvCityAll();
			cityAll.setIp(rs.getInt("ipcount"));
			cityAll.setPv(rs.getInt("pagecount"));
			cityAll.setPositionCount(rs.getInt("composcount"));
			cityAll.setSelfPosition(0);
			cityAll.setPerReg(rs.getInt("perreg"));
			cityAll.setResumeApply(rs.getInt("percount"));
			cityAll.setPerEdit(rs.getInt("peredit"));
			cityAll.setPerValid(0);
			cityAll.setComReg(rs.getInt("comreg"));
			cityAll.setPerToCom(rs.getInt("resumetopos"));
			cityAll.setComViewResume(rs.getInt("comviewresume"));
			cityAll.setComToPer(rs.getInt("comtoper"));
			cityAll.setComCount(rs.getInt("comcount"));
			cityAll.setCityId(0);//全国
			cityAll.setPosOut(0);//发布职位数
			cityAll.setPosOutTrue(0);
			cityAll.setCreDate(rs.getDate("funddate"));
			list.add(cityAll);
		}
		
		rs.close();
		sta.close();
		return list;
	}

	//各个地区的统计数据
	private List<CountPvCityAll> getData(String sql){
		return jdbcTemplateCount.query(sql, new RowMapper<CountPvCityAll>(){
			@Override
			public CountPvCityAll mapRow(ResultSet rs, int rowNum) throws SQLException {
				CountPvCityAll cityAll = new CountPvCityAll();
				cityAll.setIp(rs.getInt("ip"));
				cityAll.setPv(rs.getInt("pv"));
				cityAll.setPositionCount(rs.getInt("positionCount"));
				cityAll.setSelfPosition(rs.getInt("selfPosition"));
				cityAll.setPerReg(rs.getInt("resemeLoaction"));
				cityAll.setResumeApply(rs.getInt("resumeApply"));
				cityAll.setPerEdit(rs.getInt("perEdit"));
				cityAll.setPerValid(rs.getInt("perValid"));
				cityAll.setComReg(rs.getInt("comreg"));
				cityAll.setPerToCom(rs.getInt("perToCom"));
				cityAll.setComViewResume(rs.getInt("comviewresume"));
				cityAll.setComToPer(rs.getInt("comToPer"));
				cityAll.setComCount(rs.getInt("comCount"));
				cityAll.setPosOut(rs.getInt("posOut"));
				cityAll.setPosOutTrue(rs.getInt("posOutTrue"));
				
				Integer	cityId = rs.getInt("cityid") * 10000;
				cityAll.setCityId(cityId);
				cityAll.setCreDate(rs.getDate("credate"));
				return cityAll;
			}
		});
	}
	
	/**
	 * 各地区的数据
	 * @param listData
	 */
	private void saveArea(List<CountPvCityAll> listData){
		Session session = HibernateCountUtil.currentSession();
		if(CollectionUtils.isNotEmpty(listData)){
			int i = 0 ;
			for(CountPvCityAll model : listData){
				if(session.contains(model)){
	                continue;
				}else{
					session.save(model);
					i++;
				}
				
				if(i % 50 == 0){
					session.flush();
					session.clear();
				}
			}
		}
		HibernateCountUtil.closeSession();
	}
	
	private void save(List<CountPvCityAll> listData){
		Session session = HibernateCountUtil.currentSession();
		if(CollectionUtils.isNotEmpty(listData)){
			int i = 0 ;
			for(CountPvCityAll model : listData){
				if(session.contains(model)){
	                continue;
				}else{
					session.save(model);
					i++;
				}
				
				if(i % 50 == 0){
					session.flush();
					session.clear();
				}
			}
		}
		HibernateCountUtil.closeSession();
	}
	
	/**
	 * 获取JDBC的连接
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	private Connection getConnection() throws SQLException,
			ClassNotFoundException {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://192.168.2.211/Job5156?zeroDateTimeBehavior=convertToNull";
		String userName = "M5156irc";
		String passWord = "CCCtKeaWFfqH82Ap4revTvj5C";
		Class.forName(driver);
		return DriverManager.getConnection(url, userName, passWord);
	}
}
