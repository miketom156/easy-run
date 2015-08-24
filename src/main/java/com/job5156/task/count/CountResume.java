package com.job5156.task.count;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.job5156.common.option.OptionMap;
import com.job5156.common.option.OptionMap.OptionType;
import com.job5156.vo.per.PerIntentVo;

/**
 * 每个月求职指数统计
 * @author leo
 *
 */
public class CountResume {
	private static final Logger logger = Logger.getLogger(CountResume.class);

	private DataSource getJob5156DataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		basicDataSource.setUrl("jdbc:mysql://192.168.2.237/5156base?zeroDateTimeBehavior=convertToNull");
		basicDataSource.setUsername("M5156BSQL");
		basicDataSource.setPassword("&,R}sH_F{g5!$w](+V8')-8gJ");
		return basicDataSource;
	}

	private DataSource getJob5156DataSourceAction() {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		basicDataSource.setUrl("jdbc:mysql://192.168.2.201/5156action?zeroDateTimeBehavior=convertToNull");
		basicDataSource.setUsername("M5156ASQL");
		basicDataSource.setPassword("aPvM!)*^%~cdwc@7*^1");
		return basicDataSource;
	}

	private JdbcTemplate sourceTemplate = new JdbcTemplate(getJob5156DataSource());
	private JdbcTemplate sourceActionTemplate = new JdbcTemplate(getJob5156DataSourceAction());

	public static void main(String[] args) {
		CountResume taskCountResume = new CountResume();
		//taskCountResume.countResumeIntentWithFresh();
		taskCountResume.countResumeIntentWithRegister();
		taskCountResume.countComReceive();
		taskCountResume = null;
	}

	public void countResumeIntentWithFresh() {
		Map<String, Integer> jobMap = Maps.newHashMap();
		Map<String, Integer> jobCataMap = Maps.newHashMap();

		String countSql = "SELECT COUNT(u.id) FROM per_user u INNER JOIN per_resume r ON u.res_id = r.id WHERE r.fre_date > '2013-9-29'";
		int totalRecord = sourceTemplate.queryForObject(countSql, Integer.class);
		int dataLoadNumber = 10000;
		int totalPage = 1;
		if (totalRecord > dataLoadNumber) {
			totalPage = totalRecord / dataLoadNumber + ((totalRecord % dataLoadNumber == 0) ? 0 : 1);
		}

		System.out.println("====>一共需要处理" + totalPage + "批数据....");
		for (int i = 0; i < totalPage; i++) {
			System.out.println("====>正在获取第" + (i + 1) + "批数据....");
			String sql = "SELECT r.intent_info FROM per_resume r inner join per_user u on r.id = u.res_id WHERE r.fre_date > '2013-9-29' LIMIT "
					   + (i * dataLoadNumber) + "," + dataLoadNumber;
			List<String> intentList = sourceTemplate.queryForList(sql, String.class);
			if (CollectionUtils.isNotEmpty(intentList)) {
				Gson gson = new Gson();
				for (String intent : intentList) {
					PerIntentVo intentVo = gson.fromJson(intent, PerIntentVo.class);
					if (intentVo != null) {
						String[] jobCodeArr = StringUtils.split(intentVo.getJobCode(), ",");
						if (ArrayUtils.isNotEmpty(jobCodeArr)) {
							String code = StringUtils.substring(jobCodeArr[0], 0, 2) + "00";
							jobCataMap.put(code, NumberUtils.toInt(String.valueOf(jobCataMap.get(code)), 0) + 1);
							jobMap.put(jobCodeArr[0], NumberUtils.toInt(String.valueOf(jobMap.get(jobCodeArr[0])), 0) + 1);
						}
					}
				}
			}

			System.out.println("====>第" + (i + 1) + "批数据处理完毕");
		}

		List<Map.Entry<String, Integer>> mappingCataList = new ArrayList<Map.Entry<String, Integer>>(jobCataMap.entrySet());
		Collections.sort(mappingCataList, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> mapping1, Map.Entry<String, Integer> mapping2) {
				return mapping2.getValue().compareTo(mapping1.getValue());
			}
		});

		List<Map.Entry<String, Integer>> mappingList = new ArrayList<Map.Entry<String, Integer>>(jobMap.entrySet());
		Collections.sort(mappingList, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> mapping1, Map.Entry<String, Integer> mapping2) {
				return mapping2.getValue().compareTo(mapping1.getValue());
			}
		});

		if (CollectionUtils.isNotEmpty(mappingCataList) && mappingCataList.size() > 50) {
			mappingCataList = mappingCataList.subList(0, 50);
		}

		if (CollectionUtils.isNotEmpty(mappingList) && mappingList.size() > 50) {
			mappingList = mappingList.subList(0, 50);
		}

		logger.error("====COUNT RESUME JOBCODE WITH BIG CATA THROUGH FRESH DATE > 2013-9-29====");
		for (Map.Entry<String, Integer> mapping : mappingCataList) {
			String jobName = OptionMap.getValue(OptionType.OPT_POSITION, Integer.parseInt(mapping.getKey()));
			logger.error(jobName + "===>" + mapping.getValue());
		}

		logger.error("====COUNT RESUME JOBCODE WITH SMALL CATA THROUGH FRESH DATE > 2013-9-29====");
		for (Map.Entry<String, Integer> mapping : mappingList) {
			String jobName = OptionMap.getValue(OptionType.OPT_POSITION, Integer.parseInt(mapping.getKey()));
			logger.error(jobName + "===>" + mapping.getValue());
		}
	}

	public void countResumeIntentWithRegister() {
		Map<String, Integer> jobMap = Maps.newHashMap();
		Map<String, Integer> jobCataMap = Maps.newHashMap();

		String countSql = "SELECT COUNT(u.id) FROM per_user u WHERE u.create_date > '2014-5-27' AND u.create_date < '2014-6-26 23:59'";
		int totalRecord = sourceTemplate.queryForObject(countSql, Integer.class);
		int dataLoadNumber = 10000;
		int totalPage = 1;
		if (totalRecord > dataLoadNumber) {
			totalPage = totalRecord / dataLoadNumber + ((totalRecord % dataLoadNumber == 0) ? 0 : 1);
		}

		System.out.println("====>一共需要处理" + totalPage + "批数据....");
		for (int i = 0; i < totalPage; i++) {
			System.out.println("====>正在获取第" + (i + 1) + "批数据....");
			String sql = "SELECT r.intent_info FROM per_resume r inner join per_user u on r.id = u.res_id WHERE u.create_date > '2014-5-27'"
					   + " AND u.create_date < '2014-6-26 23:59' LIMIT " + (i * dataLoadNumber) + "," + dataLoadNumber;
			List<String> intentList = sourceTemplate.queryForList(sql, String.class);
			if (CollectionUtils.isNotEmpty(intentList)) {
				Gson gson = new Gson();
				for (String intent : intentList) {
					PerIntentVo intentVo = gson.fromJson(intent, PerIntentVo.class);
					if (intentVo != null) {
						String[] jobCodeArr = StringUtils.split(intentVo.getJobCode(), ",");
						if (ArrayUtils.isNotEmpty(jobCodeArr)) {
							String code = StringUtils.substring(jobCodeArr[0], 0, 2) + "00";
							jobCataMap.put(code, NumberUtils.toInt(String.valueOf(jobCataMap.get(code)), 0) + 1);
							jobMap.put(jobCodeArr[0], NumberUtils.toInt(String.valueOf(jobMap.get(jobCodeArr[0])), 0) + 1);
						}
					}
				}
			}

			System.out.println("====>第" + (i + 1) + "批数据处理完毕");
		}

		List<Map.Entry<String, Integer>> mappingCataList = new ArrayList<Map.Entry<String, Integer>>(jobCataMap.entrySet());
		Collections.sort(mappingCataList, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> mapping1, Map.Entry<String, Integer> mapping2) {
				return mapping2.getValue().compareTo(mapping1.getValue());
			}
		});

		List<Map.Entry<String, Integer>> mappingList = new ArrayList<Map.Entry<String, Integer>>(jobMap.entrySet());
		Collections.sort(mappingList, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> mapping1, Map.Entry<String, Integer> mapping2) {
				return mapping2.getValue().compareTo(mapping1.getValue());
			}
		});

		if (CollectionUtils.isNotEmpty(mappingCataList) && mappingCataList.size() > 50) {
			mappingCataList = mappingCataList.subList(0, 50);
		}

		if (CollectionUtils.isNotEmpty(mappingList) && mappingList.size() > 50) {
			mappingList = mappingList.subList(0, 50);
		}

		logger.error("====COUNT RESUME JOBCODE WITH BIG CATA THROUGH REGISTER DATE > 2014-5-27====");
		for (Map.Entry<String, Integer> mapping : mappingCataList) {
			String jobName = OptionMap.getValue(OptionType.OPT_POSITION, Integer.parseInt(mapping.getKey()));
			logger.error(jobName + "===>" + mapping.getValue());
		}

		logger.error("====COUNT RESUME JOBCODE WITH SMALL CATA THROUGH REGISTER DATE > 2014-5-27====");
		for (Map.Entry<String, Integer> mapping : mappingList) {
			String jobName = OptionMap.getValue(OptionType.OPT_POSITION, Integer.parseInt(mapping.getKey()));
			logger.error(jobName + "===>" + mapping.getValue());
		}
	}

	public void countComReceive() {
		Map<String, Integer> jobMap = Maps.newHashMap();
		Map<String, Integer> jobCataMap = Maps.newHashMap();
		int dataLoadNumber = 1000;
		String countSql = "select count(1) from com_receive where create_date > '2014-5-27' and create_date < '2014-6-26 23:59' and receive_type = 0";
		int totalRecord = sourceActionTemplate.queryForObject(countSql, Integer.class);
		int totalPage = 1;
		if (totalRecord > dataLoadNumber) {
			totalPage = totalRecord / dataLoadNumber + ((totalRecord % dataLoadNumber == 0) ? 0 : 1);
		}

		Gson gson = new Gson();
		for (int i = 0; i < totalPage; i++) {
			System.out.println("-----开始转换第 " + (i + 1) + " 批数据------");
			String listSql = "select pos_id from com_receive where create_date > '2014-5-27' and create_date < '2014-6-26 23:59' and receive_type = 0 limit "
					       + (i * dataLoadNumber) + "," + dataLoadNumber;
			List<Integer> posIdList = sourceActionTemplate.queryForList(listSql, Integer.class);
			if (CollectionUtils.isNotEmpty(posIdList)) {
				listSql = "select pos_type from com_position where id in(" + StringUtils.join(posIdList, ",") + ")";
				List<String> posTypeList = sourceTemplate.queryForList(listSql, String.class);
				if (CollectionUtils.isNotEmpty(posTypeList)) {
					for (String posType : posTypeList) {
						List<Integer> posTypeIdList = gson.fromJson(posType, new TypeToken<List<Integer>>() {}.getType());
						if (CollectionUtils.isNotEmpty(posTypeIdList)) {
							String posTypeStr = String.valueOf(posTypeIdList.get(0));
							String posCataTypeStr = StringUtils.substring(posTypeStr, 0, 2) + "00";
							
							jobMap.put(posTypeStr, NumberUtils.toInt(String.valueOf(jobMap.get(posTypeStr)), 0) + 1);
							jobCataMap.put(posCataTypeStr, NumberUtils.toInt(String.valueOf(jobCataMap.get(posCataTypeStr)), 0) + 1);
						}
						posTypeIdList = null;
					}
				}
			}
		}
		
		List<Map.Entry<String, Integer>> mappingCataList = new ArrayList<Map.Entry<String, Integer>>(jobCataMap.entrySet());
		Collections.sort(mappingCataList, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> mapping1, Map.Entry<String, Integer> mapping2) {
				return mapping2.getValue().compareTo(mapping1.getValue());
			}
		});

		List<Map.Entry<String, Integer>> mappingList = new ArrayList<Map.Entry<String, Integer>>(jobMap.entrySet());
		Collections.sort(mappingList, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> mapping1, Map.Entry<String, Integer> mapping2) {
				return mapping2.getValue().compareTo(mapping1.getValue());
			}
		});
		
		if (CollectionUtils.isNotEmpty(mappingCataList) && mappingCataList.size() > 50) {
			mappingCataList = mappingCataList.subList(0, 50);
		}

		if(CollectionUtils.isNotEmpty(mappingList) && mappingList.size() > 50){
			mappingList = mappingList.subList(0, 50);
		}
		
		logger.error("====COUNT COM RECEIVE RESUME WITH BIG CATA THROUGH CREATE DATE > 2014-5-27====");
		for (Map.Entry<String, Integer> mapping : mappingCataList) {
			String jobName = OptionMap.getValue(OptionType.OPT_POSITION, Integer.parseInt(mapping.getKey()));
			logger.error(jobName + "===>" + mapping.getValue());
		}
		
		logger.error("====COUNT COM RECEIVE RESUME WITH SMALL CATA THROUGH CREATE DATE > 2014-5-27====");
		for (Map.Entry<String, Integer> mapping : mappingList) {
			String jobName = OptionMap.getValue(OptionType.OPT_POSITION, Integer.parseInt(mapping.getKey()));
			logger.error(jobName + "===>" + mapping.getValue());
		}
	}
}
