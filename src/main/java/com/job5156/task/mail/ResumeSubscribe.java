package com.job5156.task.mail;

import java.io.IOException;
import java.io.StringWriter;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
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
import com.job5156.common.util.HibernateCountUtil;
import com.job5156.common.util.HibernateUtil;
import com.job5156.common.util.MD5Builder;
import com.job5156.model.com.ComSearcher;
import com.job5156.model.com.ComUser;
import com.job5156.vo.api.ResumeSearchResult;
import com.job5156.vo.api.ResumeSearchResult.PerResVo;
import com.job5156.vo.mail.ResumeSubscribeMailVo;
import com.job5156.vo.per.PerResumeVo;
import com.job5156.vo.per.PerUserInfoVo;
import com.job5156.vo.search.SearchResumeFormVo;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * <p>
 * 简历订阅邮件
 * </p>
 * 
 * @author leo
 * 
 */
@SuppressWarnings("deprecation")
public class ResumeSubscribe extends BaseMailSend {
	private static Logger logger = Logger.getLogger(ResumeSubscribe.class);

	private Gson gson;
	private EmailSender sender;
    private String comUserId;

    public String getComUserId() {
        return comUserId;
    }

    public void setComUserId(String comUserId) {
        this.comUserId = comUserId;
    }

    public ResumeSubscribe() throws EmailServerConfigException {
		sender = new EmailSender(MailServer.MAIN);
		gson = new Gson();
	}

	public ResumeSubscribe(MailServer mailServer) throws EmailServerConfigException {
		sender = new EmailSender(mailServer);
		gson = new Gson();
	}
	
	public static void main(String[] args){
		try {
			ResumeSubscribe subscribe = new ResumeSubscribe();
			subscribe.send();
			HibernateUtil.closeSession();
			HibernateCountUtil.closeSession();
		} catch (EmailServerConfigException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void send() {
		logger.error("[系统发送简历订阅器邮件]开始发送...");
		Map<String, Integer> statusMap = Maps.newHashMap();
		int dataLoadNumber = 2000;
		DateTime beginTime = DateTime.now();
        String whereSql="";
        if (StringUtils.isNotBlank(comUserId)) {
            whereSql += " and s.comUserId = '" + comUserId + "'";
        }
        String hql = "FROM ComSearcher s WHERE s.subscribe = 1" + whereSql;
		String countHql = "SELECT COUNT(s.id) FROM ComSearcher s WHERE s.subscribe = 1" + whereSql;
		Session session = HibernateUtil.currentSession();
		Query query = session.createQuery(countHql);
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
					query.setFirstResult(i * dataLoadNumber);
					query.setMaxResults(dataLoadNumber);

					List<ComSearcher> userList = query.list();
					this.sendComMail(userList, statusMap);
					session.clear();
				}
			} catch (IOException e) {
				e.printStackTrace();
				logger.error("===系统发送简历订阅器邮件异常：" + e.getMessage(), e);
			}
		}
		
		DateTime endTime = DateTime.now();
		String logMessage = "[系统发送简历订阅器邮件]"
				  + "总计应发：" + NumberUtils.toInt(String.valueOf(statusMap.get(MailCount.TOTAL.getType())), 0) + "，"
				  + "邮件地址过滤：" + NumberUtils.toInt(String.valueOf(statusMap.get(MailCount.EMAIL_ADDR_FILTER.getType())), 0) + "，"
				  + "搜索器内容为空：" + NumberUtils.toInt(String.valueOf(statusMap.get(MailCount.SEARCHER_IS_EMPTY.getType())), 0) + "，"
				  + "简历列表不足：" + NumberUtils.toInt(String.valueOf(statusMap.get(MailCount.RESUME_NUM_NOT_ENOUGH.getType())), 0) + "，"
				  + "发送成功：" + NumberUtils.toInt(String.valueOf(statusMap.get(MailCount.SEND_SUCCESS.getType())), 0) + "，"
				  + "发送失败：" + NumberUtils.toInt(String.valueOf(statusMap.get(MailCount.SEND_FAIL.getType())), 0) + "，"
				  + "共耗时：" + Hours.hoursBetween(beginTime, endTime).getHours() + "小时";
		logger.error(logMessage);
		
		// 记录日志
		this.saveLog(statusMap, Constants.MAIL_TASK_SYSTEM_RES_SUBSCRIBE, "系统发送简历订阅器邮件","");
		statusMap = null;
	}
	
	/**
	 * 发送邮件信息
	 * 
	 * @param userList
	 * @param statusMap
	 * @throws IOException
	 */
	private void sendComMail(List<ComSearcher> searcherList, Map<String, Integer> statusMap) throws IOException {
		if (CollectionUtils.isNotEmpty(searcherList)) {
			for (ComSearcher searcher : searcherList) {
				if(!this.checkEmail(searcher.getEmail())){
					this.addMailCount(statusMap, MailCount.EMAIL_ADDR_FILTER);
					continue;
				}
				ComUser comUser = searcher.getComUser();
				String mailContent = this.assembleMailContent(comUser, searcher, statusMap);
				if (StringUtils.isNotBlank(mailContent)) {
					String[] toAddr = StringUtils.split(searcher.getEmail(), Constants.MAIL_ADDRESS_SEPARATE_CHAR);
					boolean flag = sender.send(new ResumeSubscribeMailVo(mailContent, toAddr, Constants.MAIL_TYPE_SIMPLIFIED));
					try {
						if(flag){
							this.addMailCount(statusMap, MailCount.SEND_SUCCESS);
							//logger.info(searcher.getEmail() + "发送成功！");
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
						sender.send(new ResumeSubscribeMailVo(mailContent, this.getTestMailAddr(), Constants.MAIL_TYPE_SIMPLIFIED));
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
	private String assembleMailContent(ComUser comUser, ComSearcher searcher, Map<String, Integer> statusMap) throws IOException {
		if (comUser != null && searcher != null) {
			List<NameValuePair> httpParamList = this.assembleResumeSearchParam(searcher);
			if(CollectionUtils.isEmpty(httpParamList)){
				this.addMailCount(statusMap, MailCount.SEARCHER_IS_EMPTY);
				return StringUtils.EMPTY;
			}
			
			List<PerResVo> perResList = this.getResumeListBySearcher(httpParamList);
			List<PerResumeVo> perResumeVoList = this.parsePerResVo(perResList);
			
			if(CollectionUtils.isEmpty(perResumeVoList) || perResumeVoList.size() < 7){
				this.addMailCount(statusMap, MailCount.RESUME_NUM_NOT_ENOUGH);
				return StringUtils.EMPTY;
			}
			
			if(perResumeVoList.size() > 10){
				perResumeVoList = perResumeVoList.subList(0, 10);
			}
			String moreResumeLink = "/s/r/result?"+searcher.getUrl();
			String unsubscribeLink = this.assembleUnsubscribeLink(searcher);
			String editSearcherLink = "/login/com/?ref=" + URLEncoder.encode("/com/searcher#editId=" + searcher.getId(), "UTF-8");
			
			Map<String, Object> map = Maps.newHashMap();
			map.put("comUser", comUser);
			map.put("perResumeVoList", perResumeVoList);
			map.put("moreResumeLink", moreResumeLink);
			map.put("unsubscribeLink", unsubscribeLink);
			map.put("editSearcherLink", editSearcherLink);

			Configuration configure = FreemarkerConfigure.getFreemarkerConfig();
			Template template = configure.getTemplate("mail/third/resume_subscribe.ftl");

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
	private List<PerResVo> getResumeListBySearcher(List<NameValuePair> httpParamList) {
		List<PerResVo> resumeList = null;
		HttpClient httpClient = null;
		try {
			httpClient = new DefaultHttpClient();
			HttpPost httpost = new HttpPost(Constants.API_RESUME_SEARCH_URL);
			httpost.setEntity(new UrlEncodedFormEntity(httpParamList, Consts.UTF_8));
			HttpResponse response = httpClient.execute(httpost);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				String jsonStr = EntityUtils.toString(entity, "utf-8");
				EntityUtils.consume(entity);
				ResumeSearchResult result = gson.fromJson(jsonStr, ResumeSearchResult.class);
				if (result.isSuccess()) {
					resumeList = result.getDataList();
				} else {
					logger.error("===调用接口查询简历搜索器简历列表失败：" + StringUtils.join(result.getErrorList(), ";"));
				}
			}
		} catch (Exception e) {
			logger.error("===调用接口查询简历搜索器简历列表异常：" + e.getMessage(), e);
		} finally {
			httpClient.getConnectionManager().shutdown();
		}
		return resumeList;
	}
	
	/**
	 * 封装搜索查询参数
	 * 
	 * @param perResume
	 * @return
	 */
	private List<NameValuePair> assembleResumeSearchParam(ComSearcher comSearcher) {
		List<NameValuePair> paramList = Lists.newArrayList();
		SearchResumeFormVo resumeVo = null;
		try{
			String searchContent = this.parseComSearcherContent(comSearcher.getContent());
			resumeVo = gson.fromJson(searchContent, SearchResumeFormVo.class);
		}catch(Exception e){
			e.printStackTrace();
			logger.error("===简历搜索器JSON内容转对象异常：" + e.getMessage(), e);
		}
		if(resumeVo != null){
			paramList.add(new BasicNameValuePair("keyword", StringUtils.defaultIfBlank(resumeVo.getKeyword(), "")));
			paramList.add(new BasicNameValuePair("keywordAnd", ObjectUtils.toString(resumeVo.getKeywordAnd(), "")));
			paramList.add(new BasicNameValuePair("workyearFrom", ObjectUtils.toString(resumeVo.getWorkyearFrom(), "")));
			paramList.add(new BasicNameValuePair("workyearTo", ObjectUtils.toString(resumeVo.getWorkyearTo(), "")));
			paramList.add(new BasicNameValuePair("degreeFrom", ObjectUtils.toString(resumeVo.getDegreeFrom(), "")));
			paramList.add(new BasicNameValuePair("degreeTo", ObjectUtils.toString(resumeVo.getDegreeTo(), "")));
			paramList.add(new BasicNameValuePair("ageFrom", ObjectUtils.toString(resumeVo.getAgeFrom(), "")));
			paramList.add(new BasicNameValuePair("ageTo", ObjectUtils.toString(resumeVo.getAgeTo(), "")));
			paramList.add(new BasicNameValuePair("gender", ObjectUtils.toString(resumeVo.getGender(), "")));
			paramList.add(new BasicNameValuePair("updateIn", ObjectUtils.toString(resumeVo.getUpdateIn(), "90")));
			
			if(CollectionUtils.isNotEmpty(resumeVo.getPosTypeList())){
				paramList.add(new BasicNameValuePair("posTypeList", StringUtils.join(resumeVo.getPosTypeList(), ",")));
			}
			if(CollectionUtils.isNotEmpty(resumeVo.getLocationList())){
				paramList.add(new BasicNameValuePair("locationList", StringUtils.join(resumeVo.getLocationList(), ",")));
			}
			if(CollectionUtils.isNotEmpty(resumeVo.getWorkareaList())){
				paramList.add(new BasicNameValuePair("workareaList", StringUtils.join(resumeVo.getWorkareaList(), ",")));
			}
			if(CollectionUtils.isNotEmpty(resumeVo.getHometownList())){
				paramList.add(new BasicNameValuePair("hometownList", StringUtils.join(resumeVo.getHometownList(), ",")));
			}
			paramList.add(new BasicNameValuePair("authToken", MD5Builder.md5(Constants.API_COMMON_AUTH_KEY, Constants.API_COMMON_AUTH_PASS)));
		}
		return paramList;
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
	private String parseComSearcherContent(String content){
		if(StringUtils.contains(content, "\"location\":")){
			JSONObject jsonObject = new JSONObject(content);
			JSONArray locationArr = jsonObject.isNull("locationList") ? null : jsonObject.getJSONArray("locationList");

			Object location = jsonObject.isNull("location") ? null : jsonObject.get("location");
			Object hometown = jsonObject.isNull("hometown") ? null : jsonObject.get("hometown");
			
			jsonObject.remove("locationList");
			jsonObject.remove("location");
			jsonObject.remove("hometown");
			
			List<Integer> locationList = Lists.newArrayList();
			if(NumberUtils.isNumber(ObjectUtils.toString(location))){
				locationList.add(Double.valueOf(ObjectUtils.toString(location)).intValue());
			}
			
			List<Integer> hometownList = Lists.newArrayList();
			if(NumberUtils.isNumber(ObjectUtils.toString(hometown))){
				hometownList.add(Double.valueOf(ObjectUtils.toString(hometown)).intValue());
			}
			
			List<Integer> workareaList = Lists.newArrayList();
			if(locationArr != null && locationArr.length() > 0 && StringUtils.contains(locationArr.toString(), ".")){
				for(int i=0; i<locationArr.length(); i++){
					if(NumberUtils.isNumber(ObjectUtils.toString(locationArr.get(i)))){
						workareaList.add(Double.valueOf(ObjectUtils.toString(locationArr.get(i))).intValue());
					}
				}
			}
			
			jsonObject.put("locationList", new JSONArray(locationList));
			jsonObject.put("hometownList", new JSONArray(hometownList));
			jsonObject.put("workareaList", new JSONArray(workareaList));
			
			return jsonObject.toString();
		}
		return content;
	}
	
	/**
	 * 组装邮件退订链接，使用网站私钥对数据信息进行加密
	 * 
	 * @param perUser
	 * @return
	 */
	public String assembleUnsubscribeLink(ComSearcher comSearcher) {
		StringBuffer buf = new StringBuffer();
		String token = MD5Builder.md5(String.valueOf(comSearcher.getComUserId()), String.valueOf(comSearcher.getId()),
				comSearcher.getEmail(), Constants.UNSUBSCRIBE_PRIVATE_KEY);
		buf.append("/mail/unsubscribe/resume?cuid=" + comSearcher.getComUserId());
		buf.append("&sid=" + comSearcher.getId());
		buf.append("&email=" + comSearcher.getEmail());
		buf.append("&token=" + token);
		return buf.toString();
	}
	
	/**
	 * 转换简历信息
	 * @param resList
	 * @return
	 */
	public List<PerResumeVo> parsePerResVo(List<PerResVo> resList){
		List<PerResumeVo> dataList = null;
		if(CollectionUtils.isNotEmpty(resList)){
			dataList = Lists.newArrayList();
			for(PerResVo perResVo : resList){
				try {
					PerResumeVo resumeVo = new PerResumeVo(perResVo.getResume());
					PerUserInfoVo userInfoVo = new PerUserInfoVo(perResVo.getUser());
					resumeVo.setBasicInfoVo(userInfoVo);
					dataList.add(resumeVo);
					resumeVo = null;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return dataList;
	}
}
