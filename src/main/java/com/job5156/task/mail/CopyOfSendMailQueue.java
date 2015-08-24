package com.job5156.task.mail;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.job5156.beans.mail.BaseMailSend;
import com.job5156.beans.mail.EmailSender;
import com.job5156.common.CommonEnum.MailServer;
import com.job5156.common.Constants;
import com.job5156.common.exception.EmailServerConfigException;
import com.job5156.common.jedis.JedisFactory;
import com.job5156.common.jedis.JedisTemplate;
import com.job5156.common.util.HibernateCountUtil;
import com.job5156.model.mail.EmailQueue;

/**
 * 发送邮件队列邮件
 * 
 * @author leo
 * 
 */
public class CopyOfSendMailQueue extends BaseMailSend {
	private Logger logger = Logger.getLogger(CopyOfSendMailQueue.class);
	private Map<String, EmailSender> mailSenderMap = Maps.newHashMap();

	private static final Map<Integer, MailServer> mailServerMap = Maps.newHashMap();
	// 每次发送邮件数量
	private static final Integer MAIL_PER_SEND_NUM = 1000;
	//缓存客户端的工厂
	private JedisFactory jedisFactory = JedisFactory.getInstance();	
	
    public static enum NumberType {

        /**
         * 奇数
         */
        odd,

        /**
         * 偶数
         */
        even
    }

	static {
		/** 针对不同的邮件任务配置邮件服务器 **/
		mailServerMap.put(Constants.MAIL_TASK_SYS_POSITION_AUDIT, MailServer.EXCHANGE);
		mailServerMap.put(Constants.MAIL_TASK_SYS_COM_RETURN_POINTS_SALER,  MailServer.EXCHANGE);
		mailServerMap.put(Constants.MAIL_TASK_ACT_AWARDS_NOTIFY,  MailServer.EXCHANGE);
		mailServerMap.put(Constants.MAIL_TASK_ACT_FAIR_2015_NOTIFY,  MailServer.EXCHANGE);
		mailServerMap.put(Constants.MAIL_TASK_PROJ_OFFICIAL_FEEDBACK, MailServer.EXCHANGE);
		mailServerMap.put(Constants.MAIL_TASK_SYS_COM_RIGHT_AUDIT_SALER, MailServer.EXCHANGE);
	}
	
	public static void main(String[] args){
		try {
			CopyOfSendMailQueue sendMailQueue = new CopyOfSendMailQueue();
			sendMailQueue.send();
			
			HibernateCountUtil.closeSession();
		} catch (EmailServerConfigException e) {
			e.printStackTrace();
		}
	}

	public CopyOfSendMailQueue() throws EmailServerConfigException {
		EmailSender senderMain = new EmailSender(MailServer.MAIN);
		EmailSender senderExchange = new EmailSender(MailServer.EXCHANGE);
		EmailSender sendQQFox = new EmailSender(MailServer.QQ_FOX);
		EmailSender alColudEmail = null;
		mailSenderMap.put(MailServer.MAIN.getName(), senderMain);
		mailSenderMap.put(MailServer.EXCHANGE.getName(), senderExchange);
		mailSenderMap.put(MailServer.QQ_FOX.getName(), sendQQFox);
		for (int i = 1; i < 11; i++) {
			alColudEmail = new EmailSender(MailServer.BUSINESS.getName() + i);
			mailSenderMap.put(MailServer.BUSINESS.getName() + i, alColudEmail);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void send() {
        logger.info("[系统发送队列邮件]开始发送...");
       /* Session session = HibernateCountUtil.currentSession();
        String  hql = "FROM EmailQueue q WHERE q.sendFlag = 0 ORDER BY q.createDate ASC";
        for(int i=0; i<3; i++){
            Query query = session.createQuery(hql);
            query.setFirstResult(0);
            query.setMaxResults(MAIL_PER_SEND_NUM);
*/
           // List<EmailQueue> queueList = query.list();
        List<EmailQueue> queueList = Lists.newArrayList();
        EmailQueue emailQueue=new EmailQueue();
        emailQueue.setToAddr("790260645@qq.com");
        emailQueue.setContent("test");
        queueList.add(emailQueue);
          this.sendQueueList(queueList);
            //session.clear();
        //}
	}

    public void startSendByIdType(NumberType idType){

        logger.info("[系统发送队列邮件]开始发送...");
        Session session = HibernateCountUtil.currentSession();
        String hql ="";
        if(idType == NumberType.odd){
            hql = "FROM EmailQueue q WHERE q.sendFlag = 0 AND mod(id,2) = 1 ORDER BY q.createDate ASC";
        }
        if(idType == NumberType.even){
            hql = "FROM EmailQueue q WHERE q.sendFlag = 0 AND mod(id,2) = 0 ORDER BY q.createDate ASC";
        }
        for(int i=0; i<3; i++){
            Query query = session.createQuery(hql);
            query.setFirstResult(0);
            query.setMaxResults(MAIL_PER_SEND_NUM);

            List<EmailQueue> queueList = query.list();
            this.sendQueueList(queueList);
            session.clear();
        }
    }
	
	@SuppressWarnings("unchecked")
	public void sendByTaskId(Integer taskId){
		logger.info("[系统发送队列邮件]开始发送...");
		Session session = HibernateCountUtil.currentSession();
		String hql = "FROM EmailQueue q WHERE q.sendFlag = 0 AND q.taskId = ? ORDER BY q.createDate ASC";
		
		for(int i=0; i<3; i++){
			Query query = session.createQuery(hql);
			query.setParameter(0, taskId);
			query.setFirstResult(0);
			query.setMaxResults(MAIL_PER_SEND_NUM);
			
			List<EmailQueue> queueList = query.list();
			this.sendQueueList(queueList);
			session.clear();
		}
	}
	
	@SuppressWarnings("unchecked")
	public void sendByTaskGroup(List<Integer> taskIdList){
		logger.info("[系统发送队列邮件]开始发送...");
		Session session = HibernateCountUtil.currentSession();
		String hql = "FROM EmailQueue q WHERE q.sendFlag = 0 AND q.taskId in(:taskIdList) ORDER BY q.createDate ASC";
		
		for(int i=0; i<3; i++){
			Query query = session.createQuery(hql);
			query.setParameterList("taskIdList", taskIdList);
			query.setFirstResult(0);
			query.setMaxResults(MAIL_PER_SEND_NUM);
			
			List<EmailQueue> queueList = query.list();
			this.sendQueueList(queueList);
			session.clear();
		}
	}

	/**
	 * 发送邮件队列邮件
	 * 
	 * @param queueList
	 */
	private void sendQueueList(List<EmailQueue> queueList) {
		if (CollectionUtils.isNotEmpty(queueList)) {
			for (EmailQueue emailQueue : queueList) {
				boolean flag = this.sendQueue(emailQueue);
				//this.updateSendFlag(emailQueue, flag);
				logger.info(emailQueue.getFromName()+"--发出--"+emailQueue.getToAddr()+new Date());
				System.out.println(emailQueue.getToAddr() + "发送" + (flag ? "成功" : "失败")+emailQueue.getFromName() + new Date());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
			}
		}
	}

	/**
	 * 发送邮件
	 * 
	 * @param emailQueue
	 * @return
	 */
	private boolean sendQueue(EmailQueue emailQueue) {
		EmailSender mailSender = this.getMailSenderByTaskId(emailQueue );
		return mailSender.send(emailQueue);
	}

	/**
	 * 更新发送状态
	 * 
	 * @param emailQueue
	 * @param flag
	 */
	@SuppressWarnings("unused")
	private void updateSendFlag(EmailQueue emailQueue, boolean flag) {
		int sendFlag = flag ? Constants.MAIL_SEND_SUCCESS : Constants.MAIL_SEND_FAIL;
		emailQueue.setSendFlag(sendFlag);
		if(emailQueue.getSendDate() == null){
			emailQueue.setSendDate(new Date());
		}else{
			emailQueue.setResendDate(new Date());
		}
		Session session = HibernateCountUtil.currentSession();
		session.update(emailQueue);
		session.flush();
	}

	/**
	 * 根据发送任务ID,和收件人地址获取邮件发送服务器
	 * 
	 * @param  emailQueue 邮件队例
	 * @return
	 */
	private EmailSender getMailSenderByTaskId(EmailQueue emailQueue) {
	EmailSender sender = mailSenderMap.get(MailServer.MAIN.getName());
		String toAddress = emailQueue.getToAddr();
        JedisTemplate jedisTemplate = jedisFactory.getJedisTemplate(Constants.REDIS_KEY_FILTER_QQ_MAI); 
        List<String> filterEmails = jedisTemplate.readFromZset(Constants.REDIS_KEY_FILTER_QQ_MAI, 0);  //QQ，fox邮箱
        List<String> filterAlCloudEmails = jedisTemplate.readFromZset(Constants.REDIS_KEY_FILTER_ALI_CLOUD_MAI,0); //阿里邮箱
       
        if(CollectionUtils.isNotEmpty(filterEmails)){
        	System.out.println(filterEmails);
        	for(String email : filterEmails){
				if(StringUtils.containsIgnoreCase(toAddress, email)){
					 logger.info("qq.infoxsdosf");
					return mailSenderMap.get(MailServer.QQ_FOX.getName());
				}
        	}
        }
         if(CollectionUtils.isNotEmpty(filterAlCloudEmails)){
			for (String alEmail : filterAlCloudEmails) {
				System.out.println(alEmail);
				if (StringUtils.containsIgnoreCase(toAddress, alEmail)) {
					Random reRandom = new Random();
					int r = reRandom.nextInt(10);
					//boolean flag=mailSenderMap.get(MailServer.BUSINESS.getName() + r).;
					//System.out.println(flag);
			         
					return mailSenderMap.get(MailServer.BUSINESS.getName() + 1);
				}
			}
        }
		 if (mailServerMap.containsKey(emailQueue.getTaskId())) {
			MailServer mailServer = mailServerMap.get(emailQueue.getTaskId());
			sender = mailSenderMap.get(mailServer.getName());
		}
		return sender;
	}
	    // return mailSenderMap.get(MailServer.BUSINESS.getName() +10);
	//}
	
	

}
