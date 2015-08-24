package com.job5156.task.mail;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.joda.time.DateTime;
import org.joda.time.Hours;

import com.google.common.collect.Maps;
import com.job5156.beans.mail.BaseMailSend;
import com.job5156.beans.mail.EmailSender;
import com.job5156.common.CommonEnum.MailCount;
import com.job5156.common.CommonEnum.MailServer;
import com.job5156.common.Constants;
import com.job5156.common.api.SendEmailByWebpowerApi;
import com.job5156.common.exception.EmailServerConfigException;
import com.job5156.common.util.HibernateSalveBaseUtil;
import com.job5156.common.util.HibernateUtil;
import com.job5156.model.per.PerSubscription;

/**
 * 智通才富专题订阅邮件提醒
 * 
 * @author Andy
 *
 */
public class VisitorSubscribe  extends BaseMailSend{

	private static Logger logger = Logger.getLogger(VisitorSubscribe.class);

	private EmailSender sender;
	
	public VisitorSubscribe() throws EmailServerConfigException {
		//sender = new EmailSender(MailServer.MAIN);
	}

	public VisitorSubscribe(MailServer mailServer) throws EmailServerConfigException {
		sender = new EmailSender(mailServer);
	}

	public static void main(String[] args) {
		try {
			VisitorSubscribe recommend = new VisitorSubscribe();
			recommend.send();
			HibernateUtil.closeSession();
		} catch (EmailServerConfigException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void send() {
		Date date = new Date();
        this.sendMailByIntervalDays(date,Constants.MAIL_TASK_VISITOR_SUBSCRIBE);
    }

	/**
	 * 根据发送策略查询用户列表
	 * 
	 * @param intervalDays
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public void sendMailByIntervalDays(Date date,Integer taskId) {
		
		logger.error("[智通才富专题订阅邮件]开始发送...");
		DateTime beginTime = DateTime.now();
		
		//Date beginDate = DateUtils.addDays(date, -1);
		Map<String, Integer> statusMap = Maps.newHashMap();
		int dataLoadNumber = 1000;
		
		//AND p.createDate >= :beginLoginDate AND p.createDate <= :endLoginDate 
		String hql = "FROM PerSubscription p WHERE p.userId = -1 AND p.subscribeStatus = 1 AND p.taskId= :taskId ";
		String countHql = "SELECT COUNT(p.id) " + hql;

		//Date beginLoginDate = new DateTime(beginDate).secondOfDay().withMinimumValue().toDate();
		//Date endLoginDate = new DateTime(beginDate).secondOfDay().withMaximumValue().toDate();

		//查询CRM平台数据
		
		Session session = HibernateSalveBaseUtil.currentSession();
		Query query = session.createQuery(countHql);
		query.setParameter("taskId", taskId);
		//query.setParameter("beginLoginDate", beginLoginDate);
		//query.setParameter("endLoginDate", endLoginDate);
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
					query.setParameter("taskId", taskId);
					//query.setParameter("beginLoginDate", beginLoginDate);
					//query.setParameter("endLoginDate", endLoginDate);
					query.setFirstResult(i * dataLoadNumber);
					query.setMaxResults(dataLoadNumber);

					List<PerSubscription> perSubList = query.list();
					this.sendComMail(perSubList, statusMap);
					session.clear();
				}
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("===系统发送职位推荐邮件异常：" + e.getMessage(), e);
			}
		}
		
		DateTime endTime = DateTime.now();
		String logMessage = Constants.sendMailTaskType.get(taskId)
						  + "总计应发：" + NumberUtils.toInt(String.valueOf(statusMap.get(MailCount.TOTAL.getType())), 0) + "，"
						  + "邮件地址过滤：" + NumberUtils.toInt(String.valueOf(statusMap.get(MailCount.EMAIL_ADDR_FILTER.getType())), 0) + "，"
						  + "职位列表不足：" + NumberUtils.toInt(String.valueOf(statusMap.get(MailCount.POS_NUM_NOT_ENOUGH.getType())), 0) + "，"
						  + "简历不存在：" + NumberUtils.toInt(String.valueOf(statusMap.get(MailCount.PER_RESUME_NOT_EXIST.getType())), 0) + "，"
						  + "未填求职意向：" + NumberUtils.toInt(String.valueOf(statusMap.get(MailCount.NOT_FILL_PER_INTENT.getType())), 0) + "，"
						  + "发送成功：" + NumberUtils.toInt(String.valueOf(statusMap.get(MailCount.SEND_SUCCESS.getType())), 0) + "，"
						  + "发送失败：" + NumberUtils.toInt(String.valueOf(statusMap.get(MailCount.SEND_FAIL.getType())), 0) + "，"
						  + "共耗时：" + Hours.hoursBetween(beginTime, endTime).getHours() + "小时";
		logger.error(logMessage);
		
		// 记录日志
		this.saveLog(statusMap, taskId, Constants.sendMailTaskType.get(taskId),"");
		statusMap = null;
	}
	
	/**
	 * 发送邮件信息
	 * 
	 * @param searcherList
	 * @param statusMap
	 * @throws IOException
	 */
	private void sendComMail(List<PerSubscription> searcherList, Map<String, Integer> statusMap) throws IOException {
		if (CollectionUtils.isNotEmpty(searcherList)) {
			/*StringBuilder sql = new StringBuilder("SELECT spec.aid,spec.redirecturl,arc.id,");
			sql.append("arc.typeid,arc.channel,arc.title,arc.litpic,");
			sql.append("arc.senddate,arc.arcrank,arc.description");
			sql.append(" FROM dede_addonspec AS spec");
			sql.append(" LEFT JOIN dede_archives AS arc ON spec.aid = arc.id");
			sql.append(" WHERE arc.channel = - 1 AND arc.arcrank = 0");
			sql.append(" ORDER BY arc.senddate DESC LIMIT 1");
			Session sessionCms = HibernateCmsUtil.currentSession();
			SQLQuery query = sessionCms.createSQLQuery(sql.toString());
			List list = query.list();
			String response = "";
			Map<String, Object> paramMap = Maps.newHashMap();
			if(CollectionUtils.isNotEmpty(list)){
				Object[] objs = (Object[] )list.get(0);
				HttpClient httpClient = new HttpClient();
				String host = "article.job5156.com";
				String url = "/plus/view.php";
				String param = "aid="+objs[0];
				httpClient.getHostConfiguration().setHost(host, 80, "http");   
				GetMethod get = new GetMethod(url+"?"+param);
				httpClient.executeMethod(get);
				response = get.getResponseBodyAsString();
				get.releaseConnection();
				paramMap.put("title", objs[5]);
			}*/
			
			for (PerSubscription perSub : searcherList) {
				String email = perSub.getEmail();
				if(!this.checkEmail(email)){
					this.addMailCount(statusMap, MailCount.EMAIL_ADDR_FILTER);
					continue;
				}
				//if(StringUtils.isNotBlank(response)){
				int campaignId = 13;   //活动ID
				int mailingId = 86;   //邮件ID
				int groupId = 81;     //组ID
				 boolean flag = SendEmailByWebpowerApi.getInstance().sendSingleMailing(email, "", campaignId, mailingId, groupId);
				try {
					if(flag){
						this.addMailCount(statusMap, MailCount.SEND_SUCCESS);
					}else{
						this.addMailCount(statusMap, MailCount.SEND_FAIL);
						logger.error(email + "发送失败！");
					}
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				/**发送测试邮件**/
				this.addSendNum();
					//if(this.getSendNum() == 1 || this.getSendNum() % this.getSendTestMailPerNum() == 0){
						//sender.send(new VisitorSubscribelVo(response, this.getTestMailAddr(), Constants.MAIL_TYPE_SIMPLIFIED, paramMap));
					//}
				//}else{
				//	this.addMailCount(statusMap, MailCount.SEARCHER_IS_EMPTY);
				//	throw new HttpClientError("由于网络原因，导致网络连接失败！");
				//}
			}
		}
	}
	
	/**
	 * 日期格式转换
	 * 
	 * @param datetime
	 * @return
	 */
	private String getDate(long datetime) {
		long date = datetime * 1000l;
		String dateStr = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date(date));
		String year = dateStr.substring(6, 10);
		String month = dateStr.substring(3, 5);
		String day = dateStr.substring(0, 2);
		return year + "-" + month + "-" + day;
	}
	
	 /**
     * 组装邮件内容
     * @param comReceiveLogList
     * @return
     * @throws IOException
     */
/*	private String assembleMailContent(String content)	throws IOException {
		if (StringUtils.isNotBlank(content)) {
			Configuration configure = FreemarkerConfigure.getFreemarkerConfig();
			Template template = configure.getTemplate("mail/visitor_subscribe.ftl");

			Map<String, Object> map = Maps.newHashMap();
			map.put("content", content);
			try {
				StringWriter result = new StringWriter();
				template.process(map, result);
                return result.toString();
			} catch (TemplateException e) {
				logger.error("===邮件模板解析异常：" + e.getMessage(), e);
			}
		}
		return StringUtils.EMPTY;
	}*/
}
