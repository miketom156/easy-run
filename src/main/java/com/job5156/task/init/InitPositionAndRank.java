package com.job5156.task.init;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.Gson;
import com.job5156.beans.ServerConfig;
import com.job5156.beans.ServerConfigLoader;
import com.job5156.common.Constants;
import com.job5156.common.jedis.JedisFactory;
import com.job5156.common.jedis.JedisTemplate;
import com.job5156.common.util.ExcelReader;
import com.job5156.common.util.JsonValidator;
import com.job5156.vo.api.BaseResult;

/**
 * 系统向企业推送简历，初始化职位、职级分词和redis
 * @author zhaoman
 * 2015-6-30
 */
public class InitPositionAndRank {
	private static final Logger log = Logger.getLogger(InitPositionAndRank.class);
	/**
	 * 读取数据源路径,excel文件
	 */
	private static String dateSourceUri = ServerConfigLoader.getConfigByName(ServerConfig.INIT_POS_NAME_RANK_FILE);
	/**
	 * 连接REDIS客户端
	 */
	private JedisFactory jedisFactory = JedisFactory.getInstance();
	/**
	 * IK分词词库更新地址列表
	 */
	private List<String> ikUpdateUrlList = Lists.newArrayList();
	/**
	 * 职位名称词库数据
	 */
	private List<Map<Integer, String>> posNameDataList;
	/**
	 * 职级词库数据
	 */
	private List<Map<Integer, String>> posRankDataList;
	/**
	 * JSON工具类
	 */
	private Gson gson = new Gson();
	
	//初始化数据
	public InitPositionAndRank(){
		//职位数据源
		ExcelReader excelReader = new ExcelReader();
		excelReader.sheetPage = 0;
		excelReader.contentRow = 1;
		posNameDataList = readDateSource(excelReader);
		excelReader = null;
		
		//职级数据源
		ExcelReader excelReader1 = new ExcelReader();
		excelReader1.sheetPage = 1;
		excelReader1.contentRow = 0;
		posRankDataList = readDateSource(excelReader1);
		excelReader1 = null;
		
		ikUpdateUrlList.add("http://192.168.2.195:8080/open/api/common/dic/add.json");
		ikUpdateUrlList.add("http://192.168.2.191:8080/open/api/common/dic/add.json");
		ikUpdateUrlList.add("http://192.168.2.160:8080/open/api/common/dic/add.json");
		ikUpdateUrlList.add("http://192.168.2.180:8080/open/api/common/dic/add.json");
		ikUpdateUrlList.add("http://192.168.2.133:8080/open/api/common/dic/add.json");
		ikUpdateUrlList.add("http://192.168.2.139:8080/open/api/common/dic/add.json");
		ikUpdateUrlList.add("http://192.168.2.135:8080/open/api/common/dic/add.json");
	}
	
	public static void main(String[] args) {
		InitPositionAndRank initPosition = new InitPositionAndRank();
		initPosition.updateRedis();
		initPosition.updateIkLexicon();
	}
	
	/**
	 * 读取数据源,excel文件
	 * @param sheetPage sheet页
	 * @return map结构
	 */
	private List<Map<Integer, String>> readDateSource(ExcelReader excelReader) {
		List<Map<Integer, String>> dataList = null;
		InputStream is = null;
		try {
			is = new FileInputStream(dateSourceUri);
			// 读取Excel表格内容，用逗号拼接
			dataList = excelReader.readExcelContent(is);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			log.error("初始化数据中，职级、职位源文件找不到。" + e);
		} finally {
			if (null != is) {
				try {
					is.close();
					is = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return dataList;
	}
	
	/**
	 * 更新分词词库
	 */
	private void updateIkLexicon(){
		Set<String> posNameSet = assembleWordSetFromDataList(posNameDataList, Lists.newArrayList(1, 2));
		Set<String> posRankSet = assembleWordSetFromDataList(posRankDataList, null);
		
		updateIkLexicon(posNameSet);
		updateIkLexicon(posRankSet);
	}
	
	/**
	 * 更新REDIS词库
	 */
	private void updateRedis(){
		Map<String, String> posCataMap = assemblePosCataRedisMap();
		Map<String, Set<String>> posNameMap = assembleWordRedisMap(posNameDataList, Lists.newArrayList(1, 2));
		Map<String, Set<String>> posRankMap = assembleWordRedisMap(posRankDataList, null);
		
		updatePosCateRedis(posCataMap);
		updatePosDataRedis(posNameMap, Constants.REDIS_KEY_POS_NAME_LEXICON_MAP);
		updatePosDataRedis(posRankMap, Constants.REDIS_KEY_POS_RANK_LEXICON_MAP);
	}
	
	/**
	 * 组装职位类别与关联词数据到REDIS MAP
	 * @return
	 */
	private Map<String, String> assemblePosCataRedisMap(){
		Map<String, String> posCataMap = Maps.newHashMap();
		if(CollectionUtils.isNotEmpty(posNameDataList)){
			for(Map<Integer, String> dataMap : posNameDataList){
				//岗位类别id
				String posCataId = dataMap.get(1);
				if(StringUtils.isNotBlank(posCataId)){
					List<String> tempList = Lists.newArrayList();
					for(Map.Entry<Integer, String> entry : dataMap.entrySet()){
						//XLS文档中第三列开始才算关联词
						if(StringUtils.isNotBlank(entry.getValue()) && entry.getKey() > 2){
							tempList.add(entry.getValue());
						}
					}
					if(CollectionUtils.isNotEmpty(tempList)){
						posCataMap.put(posCataId, StringUtils.join(tempList, ","));
					}
				}
			}
		}
		return posCataMap;
	}
	
	/**
	 * 组装职位名称与关联词数据到REDIS MAP
	 * @param dataList
	 * @param excludeCellList
	 * @return
	 */
	private Map<String, Set<String>> assembleWordRedisMap(List<Map<Integer, String>> dataList, List<Integer> excludeCellList){
		Map<String, Set<String>> wordMap = Maps.newHashMap();
		if(CollectionUtils.isNotEmpty(dataList)){
			for(Map<Integer, String> dataMap : dataList){
				Set<String> tempSet = Sets.newHashSet();
				for(Map.Entry<Integer, String> entry : dataMap.entrySet()){
					if(StringUtils.isNotBlank(entry.getValue()) 
							&& !checkIsExcludeCell(entry.getKey(), excludeCellList)){
						tempSet.add(entry.getValue());
					}
				}
				
				if(CollectionUtils.isNotEmpty(tempSet)){
					for(String wordStr : tempSet){
						Set<String> wordSet = wordMap.get(wordStr);
						if(wordSet == null){
							wordSet = Sets.newHashSet();
						}
						wordSet.addAll(tempSet);
						wordMap.put(wordStr, wordSet);
					}
				}
				
				tempSet = null;
			}
		}
		return wordMap;
	}
	
	/**
	 * 更新词库
	 * @return
	 */
	private void updateIkLexicon(Set<String> wordSet) {
		log.info("---- Init Position Name Or Rank Lexicon Word Start ----");
		List<String> dicWordList = Lists.newArrayList();
		if(CollectionUtils.isNotEmpty(wordSet)){
			List<String> tempList = Lists.newArrayList();
			for(String wordStr : wordSet){
				if(StringUtils.length(wordStr) > 1){
					tempList.add(wordStr);
					if(CollectionUtils.size(tempList) == 4){
						dicWordList.add(StringUtils.join(tempList, ","));
						tempList.clear();
					}
				}
	        }
			if(CollectionUtils.size(tempList) > 0){
				dicWordList.add(StringUtils.join(tempList, ","));
				tempList.clear();
			}
			
			updateIkLexicon(dicWordList);
		}
		log.info("---- Init Position Name Or Rank Lexicon Word Finish ----");
	}
	
	/**
	 * 更新词库
	 * @param dicWordList
	 */
	private void updateIkLexicon(List<String> dicWordList) {
		if(CollectionUtils.isNotEmpty(dicWordList)){
			CloseableHttpClient httpClient = HttpClients.createDefault();
			for(String dicWord : dicWordList){
				for(String ikUpdateUrl : ikUpdateUrlList){
					List<NameValuePair> paramList = Lists.newArrayList();
	        		paramList.add(new BasicNameValuePair("dicWordList", dicWord));
	        		paramList.add(new BasicNameValuePair("authToken", "93531dfa818a298c2ddb5eda4f4353ae"));
	        		
	        		HttpPost httpost = new HttpPost(ikUpdateUrl);
	                httpost.setEntity(new UrlEncodedFormEntity(paramList, Consts.UTF_8));
	        		try {
	        			HttpResponse response = httpClient.execute(httpost);
	        			HttpEntity entity = response.getEntity();
	        			if (entity != null) {
	        				String jsonStr = EntityUtils.toString(entity, "utf-8");
	        				JsonValidator jsonValid = new JsonValidator();
	        				if(jsonValid.validate(jsonStr)){
	        					EntityUtils.consume(entity);
	        					BaseResult result = gson.fromJson(jsonStr, BaseResult.class); 
	        					if (!result.isSuccess()) {
	        						log.error("Update IK Lexicon Fail: URL[" + ikUpdateUrl + "] Lexicon[" + dicWord + "] Error[" + StringUtils.join(result.getErrorList(), ";") + "]");
	        					}
	        				}else{
	        					log.error("Update IK Lexicon Fail: URL[" + ikUpdateUrl + "] Lexicon[" + dicWord + "]");
	        				}
	        			}
	        			
	        			log.info("---- Load Position Name Or Rank Lexicon Word Success:" + dicWord);
	        		} catch (Exception e) {
	        			e.printStackTrace();
	        			log.error("Update IK Lexicon Exception: URL[" + ikUpdateUrl + "] Lexicon[" + dicWord + "] " + e.getMessage());
	        		} 
				}
			}
		}
	}
	
	/**
	 * 将职位分类同义词数据写入redis
	 * @param posCataMap
	 */
	private void updatePosCateRedis(Map<String, String> posCateMap){
		log.info("---- Init Position Category Redis Word Start ----");
		if(MapUtils.isNotEmpty(posCateMap)){
			String redisKey = Constants.REDIS_KEY_POS_CATE_LEXICON_MAP;
			JedisTemplate jedisTemplate = jedisFactory.getJedisTemplate(redisKey);
			jedisTemplate.del(redisKey);
			
			log.info("---- Load Position Category To Redis: KEY["+redisKey+"]----");
			for(Map.Entry<String, String> entry : posCateMap.entrySet()){
				jedisTemplate.writeToMap(redisKey, entry.getKey(), entry.getValue());
				log.info(entry.getKey() + "=>" + entry.getValue());
			}
		}
		log.info("---- Init Position Category Redis Word Finish ----");
	}
	
	/**
	 * 将职位名称与职级同义词写入REDIS
	 * @param dataMap
	 * @param redisKey
	 */
	private void updatePosDataRedis(Map<String, Set<String>> dataMap, String redisKey){
		log.info("---- Init Position Name Or Rank Redis Word Start ----");
		if(MapUtils.isNotEmpty(dataMap)){
			JedisTemplate jedisTemplate = jedisFactory.getJedisTemplate(redisKey);
			jedisTemplate.del(redisKey);
			
			log.info("---- Load Position Name Or Rank To Redis: KEY["+redisKey+"]----");
			for(Map.Entry<String, Set<String>> entry : dataMap.entrySet()){
				jedisTemplate.writeToMap(redisKey, entry.getKey(), StringUtils.join(entry.getValue(), ","));
				log.info(entry.getKey() + "=>" + StringUtils.join(entry.getValue(), ","));
			}
		}
		log.info("---- Init Position Name Or Rank Redis Word Finish ----");
	}
	
	/**
	 * 从解析出来的xls文档中抽取单词到集合
	 * @return
	 */
	private Set<String> assembleWordSetFromDataList(List<Map<Integer, String>> dataList, List<Integer> excludeCellList){
		Set<String> wordSet = Sets.newHashSet();
		if(CollectionUtils.isNotEmpty(dataList)){
			for(Map<Integer, String> dataMap : dataList){
				for(Map.Entry<Integer, String> entry : dataMap.entrySet()){
					if(StringUtils.isNotBlank(entry.getValue()) 
							&& !checkIsExcludeCell(entry.getKey(), excludeCellList)){
						wordSet.add(entry.getValue());
					}
				}
			}
		}
		return wordSet;
	}
	
	/**
	 * 检测当前列是否需要排除
	 * @param cellId
	 * @return true-排除 false-不排除
	 */
	private boolean checkIsExcludeCell(Integer cellId, List<Integer> excludeCellList){
		return CollectionUtils.isNotEmpty(excludeCellList) ? excludeCellList.contains(cellId) : false;
	}
}
