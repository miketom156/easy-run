package com.job5156.task.mail;

import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.joda.time.DateTime;
import org.joda.time.Hours;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.job5156.beans.freemarker.FreemarkerConfigure;
import com.job5156.beans.mail.BaseMailSend;
import com.job5156.beans.mail.EmailSender;
import com.job5156.common.CommonEnum.MailCount;
import com.job5156.common.CommonEnum.MailServer;
import com.job5156.common.Constants;
import com.job5156.common.exception.EmailServerConfigException;
import com.job5156.common.util.HibernateUtil;
import com.job5156.vo.com.ComPosExpireEmailData;
import com.job5156.vo.mail.ComPosExpireMailVo;
import com.job5156.vo.mail.ComSalesManMailVo;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 *企业职位到期是否可以提醒
 *
 * @author:Andy
 */
public class ComPosExpireEmailRemind extends BaseMailSend {
	private static Logger logger = Logger.getLogger(ComPosExpireEmailRemind.class);

	private EmailSender senderCom;//给企业发送邮件服务器地址
	private EmailSender senderSalesman;//给内部业务员发送邮件服务器地址

	public ComPosExpireEmailRemind() throws EmailServerConfigException{
		senderCom = new EmailSender(MailServer.MAIN);
		senderSalesman = new EmailSender(MailServer.EXCHANGE);
	}

	public ComPosExpireEmailRemind(MailServer comMailServer,MailServer salesmanMailServer) throws EmailServerConfigException{
		senderCom = new EmailSender(comMailServer);
		senderSalesman = new EmailSender(salesmanMailServer);
	}

	public static void main(String[] args) {
		try {
            ComPosExpireEmailRemind perLoginFailure = new ComPosExpireEmailRemind();
            perLoginFailure.send();
		} catch (EmailServerConfigException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void send(){
		try {
			this.sendMailByIntervalDays(Constants.MAIL_TASK_COM_POS_EXPIRE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		HibernateUtil.closeSession();
	}

	public void sendMailByIntervalDays(Integer taskId){
		logger.error("[企业职位到期邮件提醒开始发送...]");
		DateTime beginTime = DateTime.now();
		Date nowDate = DateTime.now().secondOfDay().withMinimumValue().toDate();
		Date compareDate = new DateTime(DateUtils.addDays(new Date(), 7)).secondOfDay().withMaximumValue().toDate();
		Map<String, Integer> statusMap = Maps.newHashMap();
		String sql = " SELECT ci.id AS comId,ci.com_name,cp.email,cp.pos_name,cp.end_date,sy.internal_email,sy.name FROM com_info ci "
				+ "JOIN com_position cp ON ci.id=cp.com_id JOIN sys_user sy ON sy.id=ci.saler_id "
				+ "WHERE ci.com_flag =1 AND cp.pos_status > 0 AND cp.end_date > ? AND cp.end_date <= ? ORDER BY ci.id";
		Session session = HibernateUtil.currentSession();
		SQLQuery query = session.createSQLQuery(sql);
		query.setParameter(0, nowDate);
		query.setParameter(1, compareDate);
		List list = query.list();
		Integer comId = 0 ;//
		List<ComPosExpireEmailData> paramList = Lists.newArrayList();//存放的集合，每发送完一批需要清理集合
		Gson gson = new Gson();
		statusMap.put(MailCount.TOTAL.getType(), list.size());
		if(CollectionUtils.isNotEmpty(list)){
			for(int i = 0 ; i < list.size();i++){
				Object[] objs = (Object[])list.get(i);
				if(null != objs){
					Type targetType = new TypeToken<List<String>>(){}.getType();  
					List<String> emails = gson.fromJson(objs[2]+"", targetType);
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					try{
						if(i == 0){
							comId = packageList(paramList,objs,emails,sdf);
						}else{
							if(comId.equals(Integer.valueOf(objs[0]+""))){
								comId = packageList(paramList,objs,emails,sdf);
								if(i < list.size()-1){
									continue;
								}
							}
							//如果发送成功，那么清空集合
							try{
								sendComMail(paramList,statusMap);
								//发送成功，清理集合并且将本次的值存放集合
								paramList.removeAll(paramList);
								if(i < list.size()-1){
									comId = packageList(paramList,objs,emails,sdf);
								}
							}catch(Exception e){
								paramList.removeAll(paramList);
								comId = packageList(paramList,objs,emails,sdf);
							}
							
						}
					}catch(ParseException e){
						 this.addMailCount(statusMap, MailCount.EMAIL_ADDR_FILTER);
						continue;
					}
				}
			}
		}
		
		DateTime endTime = DateTime.now();
		String logMessage = Constants.sendMailTaskType.get(taskId)
				  + "总计应发：" + NumberUtils.toInt(String.valueOf(statusMap.get(MailCount.TOTAL.getType())), 0) + "，"
				  + "邮件地址过滤：" + NumberUtils.toInt(String.valueOf(statusMap.get(MailCount.EMAIL_ADDR_FILTER.getType())), 0) + "，"
				  + "发送成功：" + NumberUtils.toInt(String.valueOf(statusMap.get(MailCount.SEND_SUCCESS.getType())), 0) + "，"
				  + "发送失败：" + NumberUtils.toInt(String.valueOf(statusMap.get(MailCount.SEND_FAIL.getType())), 0) + "，"
				  + "共耗时：" + Hours.hoursBetween(beginTime, endTime).getHours() + "小时";
		logger.error(logMessage);
		
		// 记录日志
		this.saveLog(statusMap, taskId, "企业职位到期提醒邮件","");
		statusMap = null;
	}

	/**
	 * 发送邮件给企业信息
	 * @param sendData
	 * @throws IOException 
	 */
	private boolean sendComMail(List<ComPosExpireEmailData> sendData, Map<String, Integer> statusMap) throws Exception{
		if (CollectionUtils.isNotEmpty(sendData)) {
			//企业邮件提醒
			String comMailContent = this.assembleMailContent(sendData,0);
			ComPosExpireEmailData comPos = sendData.get(0);
			if (StringUtils.isNotBlank(comMailContent)) {
				Map<String, Object> paramMap = Maps.newHashMap();
				paramMap.put("comName", comPos != null ? comPos.getComName() : "");
				List<String> emailList = getVaildEmailList(comPos.getEmail());
                if(CollectionUtils.isEmpty(emailList)){
                    this.addMailCount(statusMap, MailCount.EMAIL_ADDR_FILTER);
                    //throw new Exception(comPos.getComName()+"，企业的邮箱地址有误。");
                    return false;
                }
                String[] email = emailList.toArray(new String[0]);
                boolean flag = senderCom.send(new ComPosExpireMailVo(comMailContent, email, Constants.MAIL_TYPE_SIMPLIFIED, paramMap));
                try {
	                if(flag){
						this.addMailCount(statusMap, MailCount.SEND_SUCCESS);
						//logger.error(email + "企业邮件发送成功！");
					}else{
						this.addMailCount(statusMap, MailCount.SEND_FAIL);
						logger.error(StringUtils.join(email, ",") + "企业邮件发送失败！");
						return false;
					}
	                Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				/**发送测试邮件**/
				this.addSendNum();
				if(this.getSendNum() % this.getSendTestMailPerNum() == 0 || this.getSendNum() == 1){
					senderCom.send(new ComPosExpireMailVo(comMailContent, this.getTestMailAddr(), Constants.MAIL_TYPE_SIMPLIFIED, paramMap));
				}
			}else{
				this.addMailCount(statusMap, MailCount.SEARCHER_IS_EMPTY);
			}
			
			//业务员邮件提醒
			String salesmanMailContent = this.assembleMailContent(sendData,1);
			if (StringUtils.isNotBlank(salesmanMailContent)) {
				Map<String, Object> paramMap = Maps.newHashMap();
				paramMap.put("salemanName", comPos != null ? comPos.getSalesmanName() : "");
                String email = getOneVaildEmail(comPos.getInternalEmail());
                if(StringUtils.isBlank(email)){
                    this.addMailCount(statusMap, MailCount.EMAIL_ADDR_FILTER);
                    logger.error("邮件地址："+email+",业务员："+comPos.getSalesmanName()+"，的邮箱地址有误。");
                    //throw new RuntimeException(comPos.getSalesmanName()+"，业务员的邮箱地址有误。");
                    return false;
                }
                boolean flag = senderSalesman.send(new ComSalesManMailVo(salesmanMailContent,new String[]{email}, Constants.MAIL_TYPE_SIMPLIFIED, paramMap));
                try {
	                if(flag){
						this.addMailCount(statusMap, MailCount.SEND_SUCCESS);
						//logger.error(email + "业务员邮件发送成功！");
					}else{
						this.addMailCount(statusMap, MailCount.SEND_FAIL);
						logger.error(email + "业务员邮件发送失败！");
						return false;
					}
	                Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}else{
				this.addMailCount(statusMap, MailCount.SEARCHER_IS_EMPTY);
			}
		}
		return true;
	}

	/**
	 * 组装邮件内容
	 * @param sendData
	 * @param flag 0代表企业，1为业务员
	 * @return
	 * @throws IOException
	 */
	private String assembleMailContent(List<ComPosExpireEmailData> sendData,int flag) throws IOException {
		Map<String, Object> map = Maps.newHashMap();
		map.put("list", sendData);
		map.put("comPos", sendData.get(0));
		map.put("sendDate", new Date());
		Configuration configure = FreemarkerConfigure.getFreemarkerConfig();
		String freemarkUrl = "mail/third/comPosExpireRemind.ftl";
		if(flag > 0){
			freemarkUrl = "mail/third/comSalesManRemind.ftl";
		}
		Template template = configure.getTemplate(freemarkUrl);

		try {
			StringWriter result = new StringWriter();
			template.process(map, result);
			return result.toString();
		} catch (TemplateException e) {
			e.printStackTrace();
			logger.error("===邮件模板解析异常：" + e.getMessage(), e);
		}
		return StringUtils.EMPTY;
	}
	
	private int packageList(List<ComPosExpireEmailData> paramList,Object[] objs,List<String> emails,SimpleDateFormat sdf) throws ParseException{
		ComPosExpireEmailData comPos = new ComPosExpireEmailData();
		comPos.setComName(objs[1]+"");
		if(CollectionUtils.isNotEmpty(emails)){
			comPos.setEmail(StringUtils.join(emails, ";"));
		}
		comPos.setPosName(objs[3]+"");
		comPos.setEndDate(sdf.parse(objs[4] + ""));
		comPos.setInternalEmail(objs[5]+"");
		comPos.setSalesmanName(objs[6]+"");
		paramList.add(comPos);
		return Integer.valueOf(objs[0]+"");
	}
}
