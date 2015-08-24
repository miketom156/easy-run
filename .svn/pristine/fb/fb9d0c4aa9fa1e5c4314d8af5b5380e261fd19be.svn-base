package com.job5156.task.mail;

import java.io.IOException;
import java.io.StringWriter;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.joda.time.DateTime;
import org.joda.time.Hours;
import org.json.JSONArray;
import org.json.JSONObject;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.job5156.beans.freemarker.FreemarkerConfigure;
import com.job5156.beans.mail.BaseMailSend;
import com.job5156.beans.mail.EmailSender;
import com.job5156.common.CommonEnum.MailCount;
import com.job5156.common.CommonEnum.MailServer;
import com.job5156.common.Constants;
import com.job5156.common.exception.EmailServerConfigException;
import com.job5156.common.util.HibernateSalveBaseUtil;
import com.job5156.common.util.MD5Builder;
import com.job5156.model.per.PerSearcher;
import com.job5156.model.per.PerUser;
import com.job5156.vo.api.PosSearchResult;
import com.job5156.vo.api.PosSearchResult.ComPosVo;
import com.job5156.vo.mail.PosSubscribeMailVo;
import com.job5156.vo.search.SearchPosFormVo;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * <p>
 * 职位搜索器订阅邮件发送
 * </p>
 * 
 * @author leo
 * 
 */
@SuppressWarnings("deprecation")
public class PositionSubscribe extends BaseMailSend {
	private static Logger logger = Logger.getLogger(PositionSubscribe.class);

	private Gson gson;
	private EmailSender sender;
	
	public PositionSubscribe() throws EmailServerConfigException {
		gson = new Gson();
		sender = new EmailSender(MailServer.MAIN);
	}

	public PositionSubscribe(MailServer mailServer) throws EmailServerConfigException {
		gson = new Gson();
		sender = new EmailSender(mailServer);
	}

	public static void main(String[] args) {
		try {
			PositionSubscribe subscribe = new PositionSubscribe();
			subscribe.send();
			HibernateSalveBaseUtil.closeSession();
		} catch (EmailServerConfigException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void send() {
		sendMailByIntervalDays(3,Constants.MAIL_TASK_SYSTEM_POS_SUBSCRIBE_3);
	}

	/**
	 * 根据发送策略查询用户列表
	 * 
	 * @param intervalDays
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public void sendMailByIntervalDays(Integer sendPeriod,Integer taskId) {
		logger.error("系统发送职位订阅器邮件("+sendPeriod+"天)开始发送...");
		Map<String, Integer> statusMap = Maps.newHashMap();
		int dataLoadNumber = 2000;
		DateTime beginTime = DateTime.now();
		
		String hql = "FROM PerSearcher s WHERE s.subscribe = 1 AND s.sendPeriod = :sendPeriod GROUP BY name,email";
		String countHql = "SELECT COUNT(s.id) " + hql;

		Session session = HibernateSalveBaseUtil.currentSession();
		Query query = session.createQuery(countHql);
		query.setParameter("sendPeriod", sendPeriod);
		
		int allRecord = ((Long) query.uniqueResult()).intValue();
		statusMap.put(MailCount.TOTAL.getType(), allRecord);
		
		if (allRecord > 0) {
			int allPage = 1;
			if (allRecord > dataLoadNumber) {
				allPage = allRecord / dataLoadNumber + ((allRecord % dataLoadNumber == 0) ? 0 : 1);
			}
			try {
				for (int i = 0; i < allPage; i++) {
					query = session.createQuery(hql);
					query.setParameter("sendPeriod", sendPeriod);
					query.setFirstResult(i * dataLoadNumber);
					query.setMaxResults(dataLoadNumber);

					List<PerSearcher> searcherList = query.list();
					this.sendUserMail(searcherList, statusMap);
					session.clear();
				}
			} catch (IOException e) {
				e.printStackTrace();
				logger.error("===系统发送职位订阅器邮件异常：" + e.getMessage(), e);
			}
		}
		
		DateTime endTime = DateTime.now();
		String logMessage = Constants.sendMailTaskType.get(taskId)
				  + "总计应发：" + NumberUtils.toInt(String.valueOf(statusMap.get(MailCount.TOTAL.getType())), 0) + "，"
				  + "邮件地址过滤：" + NumberUtils.toInt(String.valueOf(statusMap.get(MailCount.EMAIL_ADDR_FILTER.getType())), 0) + "，"
				  + "搜索器内容为空：" + NumberUtils.toInt(String.valueOf(statusMap.get(MailCount.SEARCHER_IS_EMPTY.getType())), 0) + "，"
				  + "职位列表不足：" + NumberUtils.toInt(String.valueOf(statusMap.get(MailCount.POS_NUM_NOT_ENOUGH.getType())), 0) + "，"
				  + "发送成功：" + NumberUtils.toInt(String.valueOf(statusMap.get(MailCount.SEND_SUCCESS.getType())), 0) + "，"
				  + "发送失败：" + NumberUtils.toInt(String.valueOf(statusMap.get(MailCount.SEND_FAIL.getType())), 0) + "，"
				  + "共耗时：" + Hours.hoursBetween(beginTime, endTime).getHours() + "小时";
		logger.error(logMessage);
		
		// 记录日志
		this.saveLog(statusMap, taskId, "系统发送职位订阅器邮件("+sendPeriod+"天)","");
		statusMap = null;
	}
	
	/**
	 * 发送邮件信息
	 * 
	 * @param userList
	 * @param statusMap
	 * @throws IOException
	 */
	private void sendUserMail(List<PerSearcher> searcherList, Map<String, Integer> statusMap) throws IOException {
		if (CollectionUtils.isNotEmpty(searcherList)) {
			for (PerSearcher searcher : searcherList) {
				if(!this.checkEmail(searcher.getEmail())){
					this.addMailCount(statusMap, MailCount.EMAIL_ADDR_FILTER);
					continue;
				}
				PerUser perUser = searcher.getPerUser();
				String mailContent = this.assembleMailContent(perUser, searcher, statusMap);
				if (StringUtils.isNotBlank(mailContent)) {
					Map<String, Object> paramMap = Maps.newHashMap();
					String email = searcher.getEmail();
					String[] toAddr = null;
					if(perUser!=null){
						paramMap.put("userName", perUser.getUserName());
						toAddr = StringUtils.split(perUser.getEmail(), Constants.MAIL_ADDRESS_SEPARATE_CHAR);
					}else{
						paramMap.put("userName", email);
						toAddr = new String[]{email};
					}
					
					boolean flag = sender.send(new PosSubscribeMailVo(mailContent, toAddr, Constants.MAIL_TYPE_SIMPLIFIED, paramMap));
					try {
						if(flag){
							this.addMailCount(statusMap, MailCount.SEND_SUCCESS);
							logger.info(searcher.getEmail() + "发送成功！");
						}else{
							this.addMailCount(statusMap, MailCount.SEND_FAIL);
							logger.info(searcher.getEmail() + "发送失败！");
						}
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					/**发送测试邮件**/
					this.addSendNum();
					if(this.getSendNum() % this.getSendTestMailPerNum() == 0){
						sender.send(new PosSubscribeMailVo(mailContent, this.getTestMailAddr(), Constants.MAIL_TYPE_SIMPLIFIED, paramMap));
					}
				}else{
					this.addMailCount(statusMap, MailCount.SEARCHER_IS_EMPTY);
				}
			}
		}
	}
	
	/**
	 * 组装邮件内容
	 * 
	 * @param perUser
	 * @return
	 * @throws IOException
	 */
	private String assembleMailContent(PerUser perUser, PerSearcher searcher, Map<String, Integer> statusMap) throws IOException {
		if (searcher != null) {
			List<NameValuePair> httpParamList = this.assemblePosSearchParam(searcher);
			if(CollectionUtils.isEmpty(httpParamList)){
				this.addMailCount(statusMap, MailCount.SEARCHER_IS_EMPTY);
				return StringUtils.EMPTY;
			}
			
			List<ComPosVo> comPosList = this.getPosListBySearcher(httpParamList);
			if(CollectionUtils.isEmpty(comPosList) || comPosList.size() == 0){
				this.addMailCount(statusMap, MailCount.POS_NUM_NOT_ENOUGH);
				return StringUtils.EMPTY;
			}
			
			if(comPosList.size() > 10){
				comPosList = comPosList.subList(0, 10);
			}
			String morePosLink = "/s/p/result?" + searcher.getUrl();
			String unsubscribeLink = this.assembleUnsubscribeLink(searcher);
			String editSearcherLink = "/login/per/?ref=" + URLEncoder.encode("/per/searcher#editId="+searcher.getId(), "UTF-8");
			
			Map<String, Object> map = Maps.newHashMap();
			map.put("perUser", perUser);
			map.put("comPosList", comPosList);
			map.put("morePosLink", morePosLink);
			map.put("unsubscribeLink", unsubscribeLink);
			map.put("editSearcherLink", editSearcherLink);
			map.put("email", searcher.getEmail());
			Configuration configure = FreemarkerConfigure.getFreemarkerConfig();
			Template template = configure.getTemplate("mail/third/position_subscribe.ftl");

			try {
				StringWriter result = new StringWriter();
				template.process(map, result);
				return result.toString();
			} catch (TemplateException e) {
				logger.error("===邮件模板解析异常：" + e.getMessage(), e);
			}
		}
		return StringUtils.EMPTY;
	}
	
	/**
	 * 根据求简历订阅查询匹配简历列表
	 * 
	 * @param perResume
	 * @return
	 */
	private List<ComPosVo> getPosListBySearcher(List<NameValuePair> httpParamList) {
		List<ComPosVo> posList = null;
		HttpClient httpClient = null;
		try {
			httpClient = new DefaultHttpClient();
			HttpPost httpost = new HttpPost(Constants.API_POS_SEARCH_URL);
			httpost.setEntity(new UrlEncodedFormEntity(httpParamList, Consts.UTF_8));
			HttpResponse response = httpClient.execute(httpost);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				String jsonStr = EntityUtils.toString(entity, "utf-8");
				EntityUtils.consume(entity);
				PosSearchResult result = gson.fromJson(jsonStr, PosSearchResult.class); 
				if (result.isSuccess()) {
					posList = result.getDataList();
				} else {
					logger.error("===调用职位搜索器接口查询职位列表失败：" + StringUtils.join(result.getErrorList(), ";"));
				}
			}
		} catch (Exception e) {
			logger.error("===调用职位搜索器接口查询职位列表异常：" + e.getMessage(), e);
		} finally {
			httpClient.getConnectionManager().shutdown();
		}
		return posList;
	}
	
	/**
	 * 封装搜索查询参数
	 * 
	 * @param perResume
	 * @return
	 */
	private List<NameValuePair> assemblePosSearchParam(PerSearcher searcher) {
		List<NameValuePair> paramList = Lists.newArrayList();
		SearchPosFormVo posVo = null;
		try{
			String searchContent = this.parsePerSearcherContent(searcher.getContent());
			posVo = gson.fromJson(searchContent, SearchPosFormVo.class);
		}catch(Exception e){
			e.printStackTrace();
			logger.error("===职位搜索器JSON内容转对象异常：" + e.getMessage(), e);
		}
		if(posVo != null){
			paramList.add(new BasicNameValuePair("keyword", StringUtils.defaultIfBlank(posVo.getKeyword(), "")));
			paramList.add(new BasicNameValuePair("keywordType", ObjectUtils.toString(posVo.getKeywordType(), "")));
			paramList.add(new BasicNameValuePair("keywordAnd", ObjectUtils.toString(posVo.getKeywordAnd(), "")));
			paramList.add(new BasicNameValuePair("workyearFrom", ObjectUtils.toString(posVo.getWorkyearFrom(), "")));
			paramList.add(new BasicNameValuePair("workyearTo", ObjectUtils.toString(posVo.getWorkyearTo(), "")));
			paramList.add(new BasicNameValuePair("workyearUnlimit", BooleanUtils.isTrue(posVo.getWorkyearUnlimit()) ? "1" : "0"));
			paramList.add(new BasicNameValuePair("degreeFrom", ObjectUtils.toString(posVo.getDegreeFrom(), "")));
			paramList.add(new BasicNameValuePair("degreeTo", ObjectUtils.toString(posVo.getDegreeTo(), "")));
			paramList.add(new BasicNameValuePair("degreeUnlimit", BooleanUtils.isTrue(posVo.getDegreeUnlimit()) ? "1" : "0"));
			paramList.add(new BasicNameValuePair("age", ObjectUtils.toString(posVo.getAge(), "")));
			paramList.add(new BasicNameValuePair("gender", ObjectUtils.toString(posVo.getGender(), "")));
			paramList.add(new BasicNameValuePair("salary", ObjectUtils.toString(posVo.getSalary(), "")));
			paramList.add(new BasicNameValuePair("updateIn", ObjectUtils.toString(posVo.getUpdateIn(), "")));
			
			if(CollectionUtils.isNotEmpty(posVo.getPosTypeList())){
				paramList.add(new BasicNameValuePair("posTypeList", StringUtils.join(posVo.getPosTypeList(), ",")));
			}
			if(CollectionUtils.isNotEmpty(posVo.getLocationList())){
				paramList.add(new BasicNameValuePair("locationList", StringUtils.join(posVo.getLocationList(), ",")));
			}
			if(CollectionUtils.isNotEmpty(posVo.getIndustryList())){
				paramList.add(new BasicNameValuePair("industryList", StringUtils.join(posVo.getIndustryList(), ",")));
			}
			if(CollectionUtils.isNotEmpty(posVo.getPropertyList())){
				paramList.add(new BasicNameValuePair("propertyList", StringUtils.join(posVo.getPropertyList(), ",")));
			}
			paramList.add(new BasicNameValuePair("manualSort", ObjectUtils.toString(posVo.getManualSort(), "1")));
			paramList.add(new BasicNameValuePair("authToken", MD5Builder.md5(Constants.API_COMMON_AUTH_KEY, Constants.API_COMMON_AUTH_PASS)));
		}
		return paramList;
	}
	
	/**
	 * 组装邮件退订链接，使用网站私钥对数据信息进行加密
	 * 
	 * @param perUser
	 * @return
	 */
	public String assembleUnsubscribeLink(PerSearcher searcher) {
		Integer perUserId = searcher.getPerUserId();
		if(perUserId==null){
			perUserId = -1;
		}
		StringBuffer buf = new StringBuffer();
		String token = MD5Builder.md5(String.valueOf(perUserId), String.valueOf(searcher.getId()),
				searcher.getEmail(), Constants.UNSUBSCRIBE_PRIVATE_KEY);
		buf.append("/mail/unsubscribe/position?uid=" + perUserId);
		buf.append("&sid=" + searcher.getId());
		buf.append("&email=" + searcher.getEmail());
		buf.append("&token=" + token);
		return buf.toString();
	}
	
	/**
	 * 为了兼容简历搜索器旧数据，这里对内容进行一次转化，以满足新的搜索功能
	 * <pre>
	 * List<Integer>locationList->List<Integer> workareaList
	 * Double location->List<Integer> locationList
	 * Integer hometown->List<Integer> hometownList
	 * </pre>
	 * @param content
	 * @return
	 */
	private String parsePerSearcherContent(String content){
		if(StringUtils.isNotBlank(content)){
			JSONObject jsonObject = new JSONObject(content);
			JSONArray locationArr = jsonObject.isNull("locationList") ? null : jsonObject.getJSONArray("locationList");
			
			if(locationArr != null && locationArr.length() > 0 && StringUtils.contains(locationArr.toString(), ".")){
				jsonObject.remove("locationList");
				
				List<Integer> locationList = Lists.newArrayList();
				if(locationArr != null && locationArr.length() > 0){
					for(int i=0; i<locationArr.length(); i++){
						if(NumberUtils.isNumber(ObjectUtils.toString(locationArr.get(i)))){
							locationList.add(Double.valueOf(ObjectUtils.toString(locationArr.get(i))).intValue());
						}
					}
				}
				jsonObject.put("locationList", new JSONArray(locationList));
				return jsonObject.toString();
			}
		}
		return content;
	}
}
