package com.job5156.task.mail;

import java.io.IOException;
import java.io.StringWriter;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.joda.time.DateTime;
import org.json.JSONObject;
import org.springframework.jdbc.core.JdbcTemplate;

import com.google.common.base.Functions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.job5156.beans.ResumeMatchingAnalyzer;
import com.job5156.beans.ServerConfig;
import com.job5156.beans.ServerConfigLoader;
import com.job5156.beans.freemarker.FreemarkerConfigure;
import com.job5156.beans.mail.BaseMailSend;
import com.job5156.beans.mail.EmailSender;
import com.job5156.common.CommonEnum.MailCount;
import com.job5156.common.CommonEnum.MailServer;
import com.job5156.common.CommonEnum.ReceiveType;
import com.job5156.common.Constants;
import com.job5156.common.exception.EmailServerConfigException;
import com.job5156.common.jedis.JedisFactory;
import com.job5156.common.jedis.JedisTemplate;
import com.job5156.common.util.HibernateActionSlaveUtil;
import com.job5156.common.util.HibernateActionUtil;
import com.job5156.common.util.HibernateSalveBaseUtil;
import com.job5156.common.util.IKAnalysisUtil;
import com.job5156.common.util.KeyMaskUtil;
import com.job5156.common.util.MD5Builder;
import com.job5156.model.com.ComInfo;
import com.job5156.model.com.ComPosition;
import com.job5156.model.com.ComReceive;
import com.job5156.model.per.PerResume;
import com.job5156.model.per.PerUser;
import com.job5156.vo.api.ResumeSearchResult;
import com.job5156.vo.api.ResumeSearchResult.PerResVo;
import com.job5156.vo.com.ComReceiveAssistVo;
import com.job5156.vo.mail.PosRecommendMailToComVo;
import com.job5156.vo.mail.ResumeRecommendMailVo;
import com.job5156.vo.per.PerResumeVo;
import com.job5156.vo.per.PerWorkInfoVo;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * <p>
 * 系统推荐简历
 * </p>
 * 
 * <pre>
 * 1、给企业发送推荐邮件
 * 2、将个人简历推荐到企业管理中心
 * </pre>
 * 
 * Date:2015-6-16 下午3:26:36
 * 
 * @author leo
 * @version 1.0
 */
public class SystemResRecommend extends BaseMailSend{
	private static Logger logger = Logger.getLogger(SystemResRecommend.class);
	/**
	 * 连接REDIS客户端
	 */
	private JedisFactory jedisFactory = JedisFactory.getInstance();
	/**
	 * json转换工具
	 */
	private Gson gson = new Gson();
	/**
	 * 简历匹配度分析器
	 */
	private ResumeMatchingAnalyzer resumeMatchAnalyzer;
	/**
	 * 时间间隔内的简历不能重复，单位”月“
	 */
	private Integer monthInterval;
	/**
	 * 每个职位的简历推荐数量
	 */
	private Integer recommendResNum;
	/**
	 * 企业用户ID对应的OpenId保存到MAP
	 */
	private Map<Integer, String> comUserOpenIdMap = Maps.newHashMap();
	/**
	 * 推荐结果日志保存到MAP
	 */
	private Map<String, Integer> resultStatusMap = Maps.newHashMap();
	/**
	 * 邮件发送服务器
	 */
	private EmailSender sender;

    /**
     * 推荐简历的职位队列，缓存中的key
     * 数据结构Map<comId,Set<posId>>
     *
     */
    private String redisKey;

	public SystemResRecommend(String redisKey) throws EmailServerConfigException{
		this.monthInterval = 6;
		this.recommendResNum = 5; 
		sender = new EmailSender(MailServer.MAIN);
		resumeMatchAnalyzer = new ResumeMatchingAnalyzer();
        this.redisKey = redisKey;
	}
	
	/**
	 * <p>记录推荐结果类型</p>
	 * <pre>
	 * ALL_POS_NUM：职位推荐总数
	 * POS_SUCCESS_NUM：职位推荐成功数
	 * </pre>
	 *
	 * Date:2015-7-27 下午6:23:27
	 * @author leo
	 * @version 1.0
	 */
	public enum ResultType {
		ALL_POS_NUM("all_pos_num"), POS_SUCCESS_NUM("pos_success_num");
		
		String typeName;
		
		private ResultType(String typeName){
			this.typeName = typeName;
		}
		
		public String getTypeName(){
			return this.typeName;
		}
	}

    public String getRedisKey() {
        return redisKey;
    }

    public void setRedisKey(String redisKey) {
        this.redisKey = redisKey;
    }

	/**
	 * 系统推荐程序入口
	 */
    @SuppressWarnings({ "unchecked" })
	public void send() {
        int step = 500;
        int times = 1;
        
        logger.info("[ResRecommend] start!");
        JedisTemplate jedisTemplate = jedisFactory.getJedisTemplate(redisKey);
        //考虑到MAP数据量问题，分批取出REDIS中MAP数据
        Set<String> mapKeySet = jedisTemplate.readFieldsFromMap(redisKey);
        
        if(CollectionUtils.isNotEmpty(mapKeySet)){
        	Set<Integer> posIdSet = Sets.newHashSet();
        	Session session = HibernateSalveBaseUtil.currentSession();
        	
        	for(String comId : mapKeySet){
        		String posIds = jedisTemplate.readObjectFromMap(redisKey, comId, String.class);
        		if(StringUtils.isNotBlank(posIds)){
        			Integer[] posIdArr = (Integer[])ConvertUtils.convert(StringUtils.split(posIds, ","), Integer.class);
        			posIdSet.addAll(Sets.newHashSet(posIdArr));
        		}
        		
        		if(times % step == 0 || times == mapKeySet.size()){
        			String hql = "FROM ComPosition cp WHERE cp.id IN(:posIdList)";
        			List<ComPosition> posList = session.createQuery(hql).setParameterList("posIdList", posIdSet).list();
        			Map<String, List<ComPosition>> comPosMap = parsePositionListToMap(posList);
        			recommendStart(comPosMap);
        			posIdSet.clear();
        		}
        		
        		//清理REDIS队列中的待推荐企业职位信息
                jedisTemplate.removeFromMap(redisKey, comId);
        		times ++;
        	}
        }
        
        StringBuffer buf = new StringBuffer("---- resume recommend finished: ");
        buf.append("totalPos["+NumberUtils.toInt(ObjectUtils.toString(resultStatusMap.get(ResultType.ALL_POS_NUM.getTypeName())), 0)+"] ");
        buf.append("successPos["+NumberUtils.toInt(ObjectUtils.toString(resultStatusMap.get(ResultType.POS_SUCCESS_NUM.getTypeName())), 0)+"] ");
        logger.info(buf.toString());
    }
	
	/**
	 * 开始系统推荐简历
	 * @param dataMap
	 */
	private void recommendStart(Map<String, List<ComPosition>> dataMap){
		if(MapUtils.isNotEmpty(dataMap)){
			for(Map.Entry<String, List<ComPosition>> entry : dataMap.entrySet()){
				List<ComPosition> posList = entry.getValue();
				Map<ComPosition, Map<PerUser, Double>> posResMap = assemblePosResMap(posList);
				if(MapUtils.isNotEmpty(posResMap)){
					for(Map.Entry<ComPosition, Map<PerUser, Double>> posMapEntry : posResMap.entrySet()){
						ComPosition comPosition = posMapEntry.getKey();
						Map<PerUser, Double> userMap = posMapEntry.getValue();
						
						//发送简历推荐邮件
						sendComMail(comPosition, userMap);
						for(Map.Entry<PerUser, Double> userEntry : userMap.entrySet()){
							PerUser perUser = userEntry.getKey();
							PerResume perResume = perUser.getDefaultPerResume();
							
							//推送简历到企业管理中心
							saveComReceiveInfo(perUser, perResume, comPosition, userEntry.getValue());
							//记录推荐简历到REDIS
		                    logRecommendedToRedis(comPosition.getId(), Lists.newArrayList(perResume.getId()));
		                    //更新管理中心推荐简历缓存
		                    updateComTipMsgToRedis(comPosition, 1);
						}
						
						//调用微信端接口给企业推送消息
						pushRecommendMsgToWeixinHR(comPosition, userMap);
						
						//记录职位推荐成功数
						Integer count = NumberUtils.toInt(ObjectUtils.toString(resultStatusMap.get(ResultType.POS_SUCCESS_NUM.getTypeName())), 0);
						resultStatusMap.put(ResultType.POS_SUCCESS_NUM.getTypeName(), ++ count);
					}
				}
			}
			//清理Session缓存
			HibernateActionUtil.currentSession().clear();
		}
	}
	
	/**
	 * 根据企业职位筛选符合推荐的简历列表
	 * @param posList
	 * @return
	 */
	private Map<ComPosition, Map<PerUser, Double>> assemblePosResMap(List<ComPosition> posList){
		Map<ComPosition, Map<PerUser, Double>> posResMap = Maps.newHashMap();
		if(CollectionUtils.isNotEmpty(posList)){
			for(ComPosition comPosition : posList){
				// 记录职位推荐总数
				Integer count = NumberUtils.toInt(ObjectUtils.toString(resultStatusMap.get(ResultType.ALL_POS_NUM.getTypeName())), 0);
				resultStatusMap.put(ResultType.ALL_POS_NUM.getTypeName(), ++ count);
				
				Map<PerUser, Double> userMap = searchMeetUserListWithPosition(comPosition);
				if(MapUtils.isNotEmpty(userMap)){
					posResMap.put(comPosition, userMap);
				}
			}
		}
		return posResMap;
	}
	
	/**
	 * 查询当前职位符合要求的简历列表
	 * @param comPositionVo
	 * @return
	 */
	private Map<PerUser, Double> searchMeetUserListWithPosition(ComPosition comPosition){
		Map<PerUser, Double> userMap = null;
		if(comPosition != null){
			List<NameValuePair> paramList = assembleResumeSearchParam(comPosition);
            if (CollectionUtils.isNotEmpty(paramList)) {
            	logger.info("---- search condition id[" + comPosition.getId() + "] posName[" + comPosition.getPosName() + "]");
                for (NameValuePair valuePair : paramList) {
                    logger.info(valuePair.getName() + " => " + valuePair.getValue());
                }
                
                List<PerUser> userList = getMatchedResumeListWithPosition(paramList);
                if (CollectionUtils.isNotEmpty(userList)) {
                	userMap = Maps.newHashMap();
                	for(PerUser perUser : userList){
                		// 简历推荐数量不能超过定义
                		if(userMap.size() >= recommendResNum){
                			break;
                		}
        				double matchScore = calculateMatchScore(comPosition, perUser);
        				if(matchScore > 0.5){
        					userMap.put(perUser, matchScore);
        					logger.info("---- userId[" + perUser.getId() + "] userName[" + perUser.getUserName() + "] Success");
        				}else{
        					logger.info("---- userId[" + perUser.getId() + "] userName[" + perUser.getUserName() + "] Fail, matchRat:" + matchScore);
        				}
                	}
                } else {
                	logger.error("---- search matching resume list empty: posId[" + comPosition.getId() + "], posName[" + comPosition.getPosName() + "]");
                }
            }
		}
		return userMap;
	}
	
	/**
	 * 计算职位简历匹配度
	 * @param comPositionVo
	 * @param perUser
	 * @return
	 */
	private double calculateMatchScore(ComPosition comPosition, PerUser perUser){
		//计算简历匹配度
		PerResume perResume = perUser.getDefaultPerResume();
		perResume.setPerUser(perUser);
		
		double matchRat = 0.0;
		try{
			matchRat = resumeMatchAnalyzer.getResumeMatchScore(comPosition, perResume);
		}catch(Exception e){
			e.printStackTrace();
		}
		return matchRat;
	}

	/**
	 * 发送邮件信息
	 * 
	 * @param userList
	 * @param statusMap
	 * @throws IOException
	 */
	private void sendComMail(ComPosition comPosition, Map<PerUser, Double> userMap) {
		Map<String, Integer> statusMap =  Maps.newHashMap();
		try {
			String email = getOneVaildEmail(comPosition.getEmailStr());
			//判断邮箱是否存在有效邮箱
			if(StringUtils.isBlank(email)){
				this.addMailCount(statusMap, MailCount.EMAIL_ADDR_FILTER);
                return;
			}
			//判断邮箱是否参与退订-默认是订阅状态
			if(this.checkComSubscribe(email, Constants.MAIL_TASK_SYSTEM_RES_RECOMMEND)){
				String mailContent = this.assembleMailContent(email, comPosition, userMap);
				if(StringUtils.isNotBlank(mailContent)) {
					String[] toEmail = new String[]{email};
					
					Map<String, Object> paramMap = Maps.newHashMap();
					paramMap.put("posName", comPosition.getPosName());
					
					boolean flag = sender.send(new ResumeRecommendMailVo(mailContent, toEmail, Constants.MAIL_TYPE_SIMPLIFIED, paramMap));
					if(flag){
						this.addMailCount(statusMap, MailCount.SEND_SUCCESS);
					}else{
						this.addMailCount(statusMap, MailCount.SEND_FAIL);
					}
					Thread.sleep(500);
					
					/**发送测试邮件**/
					this.addSendNum();
					if(this.getSendNum() % this.getSendTestMailPerNum() == 0){
						sender.send(new PosRecommendMailToComVo(mailContent, this.getTestMailAddr(), Constants.MAIL_TYPE_SIMPLIFIED));
					}
				}
			}else{
				this.addMailCount(statusMap, MailCount.EMAIL_UNSUBSCRIBE);
			}
			
		} catch (Exception e) {
			this.addMailCount(statusMap, MailCount.SEND_FAIL);
			logger.error("===[系统自动推荐简历]发送邮件异常：", e);
		}
	}
	
	/**
	 * 判断当前职位是否是收到简历过少的职位
	 * @param posId
	 * @return
	 */
	@SuppressWarnings("unused")
	@Deprecated
	private boolean isPosRes(Integer posId){
		if(posId != null && posId > 0){
			JedisTemplate jedisTemplate = jedisFactory.getJedisTemplate(Constants.REDIS_KEY_COM_LESS_RECEIVE_RESUME_LIST);
			String posNo = String.valueOf(KeyMaskUtil.posIdToNo(posId, Constants.POS_TYPE_ONLINE.shortValue()));
			return jedisTemplate.isInSet(Constants.REDIS_KEY_COM_LESS_RECEIVE_RESUME_LIST, posNo);
		}
		return false;
	}
	
	/**
	 * 组装邮件内容
	 * @TODO 
	 * @param perUser
	 * @return
	 * @throws IOException
	 */
	private String assembleMailContent(String email, ComPosition comPosition, Map<PerUser, Double> userMap) throws IOException {
		if (comPosition != null && MapUtils.isNotEmpty(userMap)) {
			List<PerResumeVo> userList = parsePerResVo(userMap.keySet());
			ComInfo comInfo = comPosition.getComInfo();
			
			if(comInfo != null){
				String moreResLink = this.assembleMoreLink(comPosition);
				String unsubscribeLink = this.assembleUnsubscribeComLink(email, Constants.MAIL_TASK_SYSTEM_RES_RECOMMEND);
				
				Map<String, Object> map = Maps.newHashMap();
				map.put("userList", userList);
				map.put("comPosition", comPosition);
				map.put("comInfo", comInfo);
				map.put("moreResLink", moreResLink);
				map.put("unsubscribeLink", unsubscribeLink);
				
				Configuration configure = FreemarkerConfigure.getFreemarkerConfig();
				Template template = configure.getTemplate("mail/system_res_recommend.ftl");

				try {
					StringWriter result = new StringWriter();
					template.process(map, result);
					return result.toString();
				} catch (TemplateException e) {
					logger.error("===邮件模板解析异常：" + e.getMessage(), e);
				}
			}
		}
		return StringUtils.EMPTY;
	}
	
    /**
     * 根据职位匹配推荐简历列表
     * @param userId
     * @param httpParamList
     * @return
     * @throws Exception 
     */
	private List<PerUser> getMatchedResumeListWithPosition(List<NameValuePair> httpParamList) {
		List<PerUser> dataList = null;
        if(CollectionUtils.isNotEmpty(httpParamList)){
        	CloseableHttpClient httpClient = HttpClients.createDefault();
        	HttpPost httpost = new HttpPost(Constants.API_RESUME_SEARCH_URL);
            httpost.setEntity(new UrlEncodedFormEntity(httpParamList, Consts.UTF_8));
            
            try{
            	HttpResponse response = httpClient.execute(httpost);
    			HttpEntity entity = response.getEntity();
    			if (entity != null) {
    				String jsonStr = EntityUtils.toString(entity, "utf-8");
    				EntityUtils.consume(entity);
    				ResumeSearchResult result = gson.fromJson(jsonStr, ResumeSearchResult.class);
    				if (result.isSuccess()) {
    					List<PerResVo> resumeList = result.getDataList();
    					if(CollectionUtils.isNotEmpty(resumeList)){
    						dataList = Lists.newArrayList();
    						for(PerResVo resVo : resumeList){
    							PerUser perUser = resVo.getUser();
    							perUser.setDefaultPerResume(resVo.getResume());
    							dataList.add(perUser);
    						}
    					}
    				} else {
    					logger.error("===[系统自动推荐简历]调用接口查询匹配简历列表失败：" + StringUtils.join(result.getErrorList(), ";"));
    				}
    			}
            }catch(Exception e){
            	logger.error("===[系统自动推荐简历]调用接口查询匹配简历列表异常：" + e.getMessage());
            }finally{
            	try {
            		httpost.releaseConnection();
					httpClient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
        }
		return dataList;
	}

	/**
	 * 封装搜索查询参数
	 * 
	 * @param perResume
	 * @return
	 */
	private List<NameValuePair> assembleResumeSearchParam(ComPosition comPosition) {
		List<NameValuePair> paramList = Lists.newArrayList();
		String keywordQuery = assembleKeywordQueryStr(comPosition.getPosName(), comPosition.getPosTypeList());
		String posKeywordStr = comPosition.getPosKeywordStr();
		
		if(StringUtils.isNotBlank(keywordQuery)){
			Set<Integer> excludeResIdSet = Sets.newHashSet();
			//当前企业的职位已推荐过的简历ID列表
			excludeResIdSet.addAll(getRecommendedResIdSetByPosId(comPosition.getId()));
			//企业黑名单的简历ID列表
			excludeResIdSet.addAll(getComBlackResIdSet(comPosition.getComId()));
			//当前企业的职位已经应聘过的简历ID列表
			excludeResIdSet.addAll(getApplyResIdSetByComIdAndPosId(comPosition.getComId(), comPosition.getId()));
			
			List<Integer> workLocationList = Lists.newArrayList();
			if(StringUtils.isNotBlank(comPosition.getWorkLocation()) && !StringUtils.equals(comPosition.getWorkLocation(), "[]")) {
	            workLocationList = gson.fromJson(comPosition.getWorkLocation(), new TypeToken<List<Integer>>() {}.getType());
			}
			
			paramList.add(new BasicNameValuePair("keywordQueryStr", keywordQuery));
			paramList.add(new BasicNameValuePair("workareaList", StringUtils.join(workLocationList, ",")));
			paramList.add(new BasicNameValuePair("excludeIdList", StringUtils.join(excludeResIdSet, ",")));
			
			String[] posKeywordArr = StringUtils.split(posKeywordStr, " ");
			if(ArrayUtils.isNotEmpty(posKeywordArr)){
				paramList.add(new BasicNameValuePair("posKeywordList", StringUtils.join(posKeywordArr, ",")));
			}
			
			if(CollectionUtils.isNotEmpty(comPosition.getPosTypeList())){
				paramList.add(new BasicNameValuePair("posTypeList", StringUtils.join(comPosition.getPosTypeList(), ",")));
			}
			
			// 职位是否开启简历过滤功能
			if(comPosition.getFilterRes() != null && comPosition.getFilterRes() == 1){
				if(comPosition.getReqWorkYear() != null && comPosition.getReqWorkYear() != 99){
					paramList.add(new BasicNameValuePair("workyearFrom", ObjectUtils.toString(comPosition.getReqWorkYear())));
					paramList.add(new BasicNameValuePair("workyearTo", "11"));
				}
				if(comPosition.getReqDegree() != null && comPosition.getReqDegree() > 0){
					paramList.add(new BasicNameValuePair("degreeFrom", ObjectUtils.toString(comPosition.getReqDegree())));
					paramList.add(new BasicNameValuePair("degreeTo", "8"));
				}
				if(comPosition.getReqGender() != null && comPosition.getReqGender() > 0){
					paramList.add(new BasicNameValuePair("gender", ObjectUtils.toString(comPosition.getReqGender())));
				}
				if(comPosition.getReqAgeMin() != null && comPosition.getReqAgeMin() > 0){
					paramList.add(new BasicNameValuePair("ageFrom", ObjectUtils.toString(comPosition.getReqAgeMin())));
				}
				if(comPosition.getReqAgeMax() != null && comPosition.getReqAgeMax() > 0){
					paramList.add(new BasicNameValuePair("ageTo", ObjectUtils.toString(comPosition.getReqAgeMax())));
				}
				if(comPosition.getReqLocation() != null && comPosition.getReqLocation() > 0){
					paramList.add(new BasicNameValuePair("locationList", ObjectUtils.toString(comPosition.getReqLocation())));
				}
				if(comPosition.getReqLanguage() != null && comPosition.getReqLanguage() > 0){
					paramList.add(new BasicNameValuePair("languageLevel", ObjectUtils.toString(comPosition.getReqLanguage())));
				}
			}
			
			paramList.add(new BasicNameValuePair("searchType", "6"));
			paramList.add(new BasicNameValuePair("updateIn", "7"));
			paramList.add(new BasicNameValuePair("pageNo", "1"));
			paramList.add(new BasicNameValuePair("pageSize", "50"));
			paramList.add(new BasicNameValuePair("sortBy", "0"));
			paramList.add(new BasicNameValuePair("authToken", MD5Builder.md5(Constants.API_COMMON_AUTH_KEY, Constants.API_COMMON_AUTH_PASS)));
		}
		return paramList;
	}

	/**
	 * 针对职位名称分词处理，组装关键字搜索条件
	 * 
	 * @param posName
	 * @return
	 */
	private String assembleKeywordQueryStr(String posName, List<Integer> posTypeList){
		StringBuffer buf = new StringBuffer();
		if(StringUtils.isNotBlank(posName)){
			String redisPosNameKey = Constants.REDIS_KEY_POS_NAME_LEXICON_MAP;
			String redisPosRankKey = Constants.REDIS_KEY_POS_RANK_LEXICON_MAP;
			
			Set<String> wordSet = Sets.newHashSet(IKAnalysisUtil.analysisKeywordSegAndSelf(posName));
			//先从岗位类别对应词库中查找关联词
			String[] posCateArr = getWordFormRedisByPosCate(wordSet, posTypeList);
			String redisNameStr = posCateArr[1];
			//如果岗位类别中没有找到，则查找所有关联词
			if(StringUtils.isBlank(redisNameStr)){
				String[] posNameArr = getWordFromRedisByType(wordSet, redisPosNameKey);
				redisNameStr = posNameArr[1];
			}
			
			//职级REDIS词库中存在一个字的情况，同时没有将单个字加入到IK分词词库，所以手动添加单字到分词集合
			wordSet.add(posName.substring(StringUtils.length(posName) - 1));
			//从职级对应词库中查找关联词
			String[] posRankArr = getWordFromRedisByType(wordSet, redisPosRankKey);
			if(StringUtils.isNotBlank(redisNameStr)){
				buf.append("(" + StringUtils.join(StringUtils.split(redisNameStr, ","), " OR ") + ")");
				
				if(StringUtils.isNotBlank(posRankArr[1])){
					buf.append(",");
					buf.append("(" + StringUtils.join(StringUtils.split(posRankArr[1], ","), " OR ") + ")");
				}
			}else{
				buf.append("(" + StringUtils.join(wordSet, " AND ") + ")");
			}
		}
		return buf.toString();
	}

	/**
	 * <p>
	 * 从职位分词集合中获取职位名或者职级关键字<br>
	 * 说明：选取职位分词中最长的一个分词。<br>
	 * </p>
	 * 
	 * @param wordSet
	 * 
	 * @param redisKeyPrefix
	 * @return
	 */
	private String[] getWordFromRedisByType(Set<String> posNameSet, String redisKey) {
		String[] relateWordArr = new String[2];
		if (CollectionUtils.isNotEmpty(posNameSet)) {
			JedisTemplate jedisTemplate = jedisFactory.getJedisTemplate(redisKey);
			for (String word : posNameSet) {
				if (StringUtils.isNotBlank(word)) {
					boolean isExists = jedisTemplate.hExists(redisKey, word);
					if (isExists && StringUtils.length(word) > StringUtils.length(relateWordArr[0])) {
						relateWordArr[0] = word;
					}
				}
			}
			if(StringUtils.isNotBlank(relateWordArr[0])){
				relateWordArr[1] = jedisTemplate.readObjectFromMap(redisKey, relateWordArr[0], String.class);
			}
		}
		
		return relateWordArr;
	}
	
	/**
	 * 从职位分词集合中获取分类关键字
	 * @param posNameSet
	 * @return
	 */
	private String[] getWordFormRedisByPosCate(Set<String> posNameSet, List<Integer> posTypeList){
		String[] relateWordArr = new String[2];
		if(CollectionUtils.isNotEmpty(posNameSet) && CollectionUtils.isNotEmpty(posTypeList)){
			String redisKey = Constants.REDIS_KEY_POS_CATE_LEXICON_MAP;
			JedisTemplate jedisTemplate = jedisFactory.getJedisTemplate(redisKey);
			for(Integer category : posTypeList){
				if(category != null && category > 0){
					String categoryCodeStr = String.valueOf(category);
					if(jedisTemplate.hExists(redisKey, categoryCodeStr)){
						String posNameWordStr = jedisTemplate.readObjectFromMap(redisKey, categoryCodeStr, String.class);
						String[] posNameWordArr = StringUtils.split(posNameWordStr, ",");
						
						if(CollectionUtils.containsAny(posNameSet, Sets.newHashSet(posNameWordArr))){
							relateWordArr[0] = categoryCodeStr;
							relateWordArr[1] = posNameWordStr;
							break;
						}
					}
					
				}
			}
		}
		return relateWordArr;
	}
	
	/**
	 * 获取当前企业的职位已推荐过的简历ID列表
	 * @param posId
	 * @return
	 */
	private Set<Integer> getRecommendedResIdSetByPosId(Integer posId){
		Set<Integer> resIdSet = Sets.newHashSet();
		String redisKey = Constants.REDIS_KEY_RECOMMENDED_POS_ID_PREFIX + posId;
		JedisTemplate jedisTemplate = jedisFactory.getJedisTemplate(redisKey);
		String compareDateStr = DateTime.now().minusMonths(monthInterval).withTimeAtStartOfDay().toString("yyyyMMdd");
		
		Set<String> fieldSet = jedisTemplate.readFieldsFromMap(redisKey);
		if(CollectionUtils.isNotEmpty(fieldSet)){
			for(String dataStr : fieldSet){
				if(NumberUtils.toInt(dataStr, 0) >= NumberUtils.toInt(compareDateStr)){
					String resumeIds = jedisTemplate.readObjectFromMap(redisKey, dataStr, String.class);
					if(StringUtils.isNotBlank(resumeIds)){
						Integer[] resIdArr = (Integer[])ConvertUtils.convert(StringUtils.split(resumeIds, ","), Integer.class);
						resIdSet.addAll(Sets.newHashSet(resIdArr));
					}
				}
			}
		}
		return resIdSet;
	}
	
	/**
	 * 获取当前企业的职位已经应聘过的简历ID列表
	 * @param comId 企业id
	 * @param posId 职位id
	 * @param createDate 创建时间
	 * @return
	 */
	private Set<Integer> getApplyResIdSetByComIdAndPosId(Integer comId, Integer posId){
		JdbcTemplate jdbcActionSlaveTemplate = HibernateActionSlaveUtil.getJdbcTemplate();
		Date compareDate = DateTime.now().minusMonths(monthInterval).withTimeAtStartOfDay().toDate();
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT DISTINCT resume_id FROM com_receive ");
		sql.append("WHERE com_id = ? AND pos_id = ? AND apply_numer > 0 AND create_date >= ?");
		
		List<Integer> resumeIdList = jdbcActionSlaveTemplate.queryForList(sql.toString(), new Object[]{comId, posId, compareDate}, Integer.class);
		return Sets.newHashSet(resumeIdList);
	}
	
	/**
	 * 查询企业黑名单的简历ID列表
	 * 
	 * @param comId
	 * @return
	 */
	private Set<Integer> getComBlackResIdSet(Integer comId){
		JdbcTemplate jdbcTemplate = HibernateActionSlaveUtil.getJdbcTemplate();
		List<Integer> resumeIdList = jdbcTemplate.queryForList("SELECT resume_id FROM com_blacklist WHERE com_id = " + comId, Integer.class);
		return Sets.newHashSet(resumeIdList);
	}
	
	/**
	 * 推送简历到企业管理中心
	 * @param perResume
	 * @return
	 */
	private void saveComReceiveInfo(PerUser perUser, PerResume perResume, ComPosition comPosition, double matchRat){
		PerResumeVo resumeVo = new PerResumeVo(perResume);
		ComReceiveAssistVo receiveAssist = new ComReceiveAssistVo();
		//判断是否有工作经验
		if(CollectionUtils.isNotEmpty(resumeVo.getWorkInfoVoList())) {
			//获取最近的一次工作信息
			PerWorkInfoVo lastWorkInfo = resumeVo.getWorkInfoVoList().get(0);
			//设置附加信息中的工作经验信息
			receiveAssist.setLastPosName(lastWorkInfo.getJobName());
			receiveAssist.setComName(lastWorkInfo.getComName());
			receiveAssist.setStart(lastWorkInfo.getBegin());
			receiveAssist.setEnd(lastWorkInfo.getEnd());
		}
		
		//设置附加信息中的其他信息
		receiveAssist.setSkill(resumeVo.getIntentInfoVo().getProfessionSkill());
		receiveAssist.setMobile(resumeVo.getBasicInfoVo().getMobile());
		receiveAssist.setJobyearType(resumeVo.getBasicInfoVo().getJobyearType());
		
		ComReceive comReceive = new ComReceive();
		//构建收到简历对象
		comReceive.setComId(comPosition.getComId());
		comReceive.setPerUserId(resumeVo.getAccountId());
		comReceive.setResumeId(resumeVo.getId());
		comReceive.setPosId(comPosition.getId());
		comReceive.setUserName(perUser.getUserName());
		comReceive.setPosName(comPosition.getPosName());
		comReceive.setGender(perUser.getGender());
		comReceive.setAge(resumeVo.getAge());
		comReceive.setLocation(resumeVo.getBasicInfoVo().getLocation());
		comReceive.setJobLocation(resumeVo.getIntentInfoVo().getJobLocation());
		comReceive.setEmail(resumeVo.getBasicInfoVo().getEmail());
		comReceive.setApplyNumer(1);
		//设置是否购买
		comReceive.setBuyFlag(0);
		comReceive.setSysRecommend(1);
		
		//设置最高学历信息
		if(resumeVo.getMaxDegree() != null) {
			comReceive.setDegree(resumeVo.getMaxDegree().getDegree());
			comReceive.setSpeciality(resumeVo.getMaxDegree().getSpeciality());
			comReceive.setSchoolName(resumeVo.getMaxDegree().getSchoolName());
		}
				
		//设置接收到的简历类型
		comReceive.setReceiveType(ReceiveType.SYS_RECOMMAND.getValue());
		comReceive.setCreateDate(new Date());
		//设置工作经验年限
		comReceive.setJobyearType(resumeVo.getBasicInfoVo().getJobyearType());
			
		//设置附加信息
		comReceive.setMixInfo(new Gson().toJson(receiveAssist));
		comReceive.setUpdateDate(new Date());
		
		//设置简历匹配度
		comReceive.setMatchRat(matchRat);
		
		//添加或保存企业收到简历
		HibernateActionUtil.currentSession().save(comReceive);
	}
	
	/**
	 * 记录推荐简历ID到对应的职位REDIS
	 * @param posId
	 * @param resumeId
	 */
	private void logRecommendedToRedis(Integer posId, List<Integer> resumeIdList){
		if(posId != null && posId > 0 && CollectionUtils.isNotEmpty(resumeIdList)){
			Set<String> resumeIdSet = Sets.newHashSet();
			List<String> resumeIdStrList = Lists.transform(resumeIdList, Functions.toStringFunction());
			resumeIdSet.addAll(resumeIdStrList);
			
			String redisKey = Constants.REDIS_KEY_RECOMMENDED_POS_ID_PREFIX + posId;
			String fieldKey = DateTime.now().toString("yyyyMMdd");
			
			JedisTemplate jedisTemplate = jedisFactory.getJedisTemplate(redisKey);
			String recommendResIds = jedisTemplate.readObjectFromMap(redisKey, fieldKey, String.class);
			
			if(StringUtils.isNotBlank(recommendResIds)){
				Collections.addAll(resumeIdSet, StringUtils.split(recommendResIds, ","));
			}
			jedisTemplate.writeToMap(redisKey, fieldKey, StringUtils.join(resumeIdSet, ","));
		}
	}
	
	/**
	 * 更新系统推荐简历数量到REDIS
	 * @param comId
	 * @param resumeNum
	 */
	private void updateComTipMsgToRedis(ComPosition comPosition, Integer resumeNum){
		String redisKey = Constants.REDIS_KEY_COM_MSG_RES_COUNT_PREFIX + comPosition.getComId() + Constants.COM_MSG_RES_COUNT_TIPS;
		String fieldKey = Constants.COM_ZP_COUNT_RECOMMEND_ALL;

		JedisTemplate jedisTemplate = JedisFactory.getInstance().getJedisTemplate(redisKey);
		if(jedisTemplate.hExists(redisKey, fieldKey)){
			Integer count = jedisTemplate.readObjectFromMap(redisKey, fieldKey, Integer.class);
			jedisTemplate.writeToMap(redisKey, fieldKey, count + resumeNum);
		}
		
		if(comPosition.getDepartmentId() != null && comPosition.getDepartmentId() > 0){
			fieldKey = Constants.COM_ZP_COUNT_RECOMMEND_NEW + ":" + comPosition.getDepartmentId();
			if(jedisTemplate.hExists(redisKey, fieldKey)){
				Integer count = jedisTemplate.readObjectFromMap(redisKey, fieldKey, Integer.class);
				jedisTemplate.writeToMap(redisKey, fieldKey, count + resumeNum);
			}
		}
	}
	
	/**
	 * 推送简历推荐消息到企业微信端
	 * @param comId
	 * @param userMap
	 */
	private void pushRecommendMsgToWeixinHR(ComPosition comPosition, Map<PerUser, Double> userMap){
		String openId = queryOpenIdWithComUserId(comPosition.getComUserId());
		JSONObject paramJsonObject = assembleMsgNoticeParamList(openId, comPosition.getPosName(), userMap);
		
		if(StringUtils.isNotBlank(openId) && paramJsonObject.length() > 0){
			CloseableHttpClient httpClient = HttpClients.createDefault();
	    	HttpPost httpost = new HttpPost(ServerConfigLoader.getConfigByName(ServerConfig.API_WEIXINHR_MSG_RESUME_RECOMMEND_URL));
	        try{
	        	String paramStr = URLEncoder.encode(paramJsonObject.toString(), "UTF-8");
		    	httpost.setEntity(new StringEntity(paramStr, Consts.UTF_8));
	        	HttpResponse response = httpClient.execute(httpost);
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					String resultStr = EntityUtils.toString(entity, "utf-8");
					JSONObject jsonObject = new JSONObject(resultStr);
					if(jsonObject.optBoolean("status")){
						logger.info("---- push messsage to comUserId["+comPosition.getComUserId()+"] success");
					}else{
						logger.info("---- push messsage to comUserId["+comPosition.getComUserId()+"] fail");
					}
				}
	        }catch(Exception e){
	        	logger.error("===[系统自动推荐简历]推送简历推荐消息到企业微信端异常：" + e.getMessage());
	        }finally{
	        	try {
	        		httpost.releaseConnection();
					httpClient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
	        }
		}else{
			logger.info("---- push messsage to comUser fail: comUserId["+comPosition.getComUserId()+"] do not have openId");
		}
	}
	
	/**
	 * 组装推送简历推荐通知给php的参数列表
	 * @param openId
	 * @param posName
	 * @param userMap
	 * @return
	 */
	private JSONObject assembleMsgNoticeParamList(String openId, String posName, Map<PerUser, Double> userMap){
		JSONObject jsonObject = new JSONObject();
		Map<String, String[]> posResNameMap = Maps.newHashMap();
		List<String> resumeNameList = Lists.newArrayList();
		
    	for(PerUser perUser : userMap.keySet()){
    		if(perUser != null){
    			String userName = StringUtils.isNotBlank(perUser.getUserName()) ? perUser.getUserName() : perUser.getEmail();
        		resumeNameList.add(userName);
    		}
    	}
    	
    	if(CollectionUtils.isNotEmpty(resumeNameList)){
    		posResNameMap.put(posName, resumeNameList.toArray(new String[resumeNameList.size()]));
    		jsonObject.put("type", "recommendResume");
    		jsonObject.put("positionName", posResNameMap);
    		jsonObject.put("openid", new String[]{openId});
    	}
    	
    	return jsonObject;
	}
	
	/**
	 * 获取企业用户对应的OpenId
	 * @param comUserId
	 * @return
	 */
	private String queryOpenIdWithComUserId(Integer comUserId){
		if(comUserId != null && comUserId > 0){
			if(comUserOpenIdMap.containsKey(comUserId)){
				return comUserOpenIdMap.get(comUserId);
			}
			
			JdbcTemplate jdbcTemplateSlave = HibernateSalveBaseUtil.getJdbcTemplate();
			String sql = "SELECT open_id FROM per_user_connect WHERE com_user_id = ? AND type = ?";
			List<String> openIdList = jdbcTemplateSlave.queryForList(sql, new Object[]{comUserId, Constants.CONNECT_TYPE_WEIXIN}, String.class);
			String openId = CollectionUtils.isNotEmpty(openIdList) ? openIdList.get(0) : StringUtils.EMPTY;
			comUserOpenIdMap.put(comUserId, openId);
			return openId;
		}
		return StringUtils.EMPTY;
	}

	/**
	 * 转换职位列表到MAP
	 * @param dataList
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private Map<String, List<ComPosition>> parsePositionListToMap(List<ComPosition> dataList){
		Map<String, List<ComPosition>> dataMap = null;
		if(CollectionUtils.isNotEmpty(dataList)){
			dataMap = Maps.newHashMap();
			for(ComPosition comPosition : dataList){
				String comId = String.valueOf(comPosition.getComId());
				List<ComPosition> list = (List<ComPosition>) (dataMap.containsKey(comId) ? dataMap.get(comId) : Lists.newArrayList());
				list.add(comPosition);
				dataMap.put(comId, list);
			}
		}
		return dataMap;
	}
	
	/**
	 * 组装更多链接查询条件
	 * @param perResume
	 * @return
	 */
	private String assembleMoreLink(ComPosition comPosition){
		String keyword = StringUtils.EMPTY;
		try{
			keyword = URLEncoder.encode(comPosition.getPosName(), "UTF-8");
		}catch(Exception e){
			e.printStackTrace();
			keyword = comPosition.getPosName();
		}
		return "/s/r/result?keyword="+keyword+"&updateIn=365&et=9c026512";
	}
	
	/**
	 * 转换简历信息
	 * @param resList
	 * @return
	 */
	public List<PerResumeVo> parsePerResVo(Set<PerUser> userList){
		List<PerResumeVo> dataList = null;
		if(CollectionUtils.isNotEmpty(userList)){
			dataList = Lists.newArrayList();
			for(PerUser perUser : userList){
				try {
					PerResumeVo resumeVo = new PerResumeVo(perUser.getDefaultPerResume());
					dataList.add(resumeVo);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return dataList;
	}
}
