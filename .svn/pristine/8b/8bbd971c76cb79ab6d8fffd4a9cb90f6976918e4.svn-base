package com.job5156.task.mail;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.joda.time.DateTime;
import org.joda.time.Hours;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.job5156.beans.freemarker.FreemarkerConfigure;
import com.job5156.beans.mail.BaseMailSend;
import com.job5156.beans.mail.EmailSender;
import com.job5156.common.CommonEnum.MailCount;
import com.job5156.common.CommonEnum.MailServer;
import com.job5156.common.Constants;
import com.job5156.common.exception.EmailServerConfigException;
import com.job5156.common.util.HibernateActionUtil;
import com.job5156.common.util.HibernateCountUtil;
import com.job5156.common.util.HibernateSalveBaseUtil;
import com.job5156.common.util.HibernateUtil;
import com.job5156.model.com.ComPosition;
import com.job5156.model.logs.LogComReceiveResNum;
import com.job5156.model.sys.system.SysUser;
import com.job5156.vo.mail.ComReceiveResNumRemindMailVo;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * 企业未收到求职者投递简历给招聘顾问发送提醒邮件<br>
 * 业务说明:<br>
 * 1、职位未过期且还在招聘<br>
 * 2、职位已招聘一周 <br>
 * 3、职位收到简历数小于2份<br>
 * 
 * @author leo
 * 
 */
public class ComNotReceiveResume extends BaseMailSend {
	private static Logger logger = Logger.getLogger(ComNotReceiveResume.class);

	private EmailSender sender;

	public ComNotReceiveResume() throws EmailServerConfigException {
		sender = new EmailSender(MailServer.EXCHANGE);
	}

	public ComNotReceiveResume(MailServer mailServer) throws EmailServerConfigException {
		sender = new EmailSender(mailServer);
	}

	public static void main(String[] args) {
		try {
			ComNotReceiveResume notReceiveResume = new ComNotReceiveResume();
			notReceiveResume.send();
			HibernateUtil.closeSession();
			HibernateActionUtil.closeSession();
		} catch (EmailServerConfigException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void send() {
		logger.error("[系统发送企业收到投递简历过少提醒邮件]开始发送...");
		DateTime beginTime = DateTime.now();
		Date nowDate = DateTime.now().secondOfDay().withMinimumValue().toDate();

		int reachNum = 2;
		Date compareDate = new DateTime(DateUtils.addDays(new Date(), -7)).secondOfDay().withMinimumValue().toDate();
		Map<String, Integer> statusMap = Maps.newHashMap();

		String hql = "SELECT cp.* FROM com_position cp JOIN com_info ci ON ci.id = cp.com_id "
				+ " WHERE ci.location LIKE '1401%' AND cp.pos_status > 0 AND cp.update_date < ? AND cp.end_date > ?";
		String hqlCount = "SELECT COUNT(cp.id) FROM com_position cp JOIN com_info ci ON ci.id = cp.com_id "
				+ " WHERE ci.location LIKE '1401%' AND cp.pos_status > 0 AND cp.update_date < ? AND cp.end_date > ?";

		Session session = HibernateSalveBaseUtil.currentSession();
		Query query = session.createSQLQuery(hqlCount);
		query.setParameter(0, compareDate);
		query.setParameter(1, nowDate);

		Object obj = query.uniqueResult();
		int allRecord = Integer.valueOf(obj + "");
		int dataLoadNumber = 2000;
		if (allRecord > 0) {
			int allPage = allRecord / dataLoadNumber + ((allRecord % dataLoadNumber == 0) ? 0 : 1);
			Map<String, List<LogComReceiveResNum>> salerMailMap = Maps.newHashMap();

			for (int i = 0; i < allPage; i++) {
				query = session.createSQLQuery(hql).addEntity(ComPosition.class);
				query.setParameter(0, compareDate);
				query.setParameter(1, nowDate);
				query.setFirstResult(i * dataLoadNumber);
				query.setMaxResults(dataLoadNumber);

				List<ComPosition> posList = query.list();
				this.filterNotReachedPos(posList, compareDate, reachNum);
				this.logSalerMail(posList, statusMap, salerMailMap);
				session.clear();
			}

			this.sendSalerMail(salerMailMap, statusMap);
		}

		DateTime endTime = DateTime.now();
		String logMessage = "[系统发送企业收到投递简历过少提醒邮件]"
				+ "总计应发：" + NumberUtils.toInt(String.valueOf(statusMap.get(MailCount.TOTAL.getType())), 0) + "，"
				+ "邮件地址过滤：" + NumberUtils.toInt(String.valueOf(statusMap.get(MailCount.EMAIL_ADDR_FILTER.getType())), 0) + "，"
				+ "发送成功：" + NumberUtils.toInt(String.valueOf(statusMap.get(MailCount.SEND_SUCCESS.getType())), 0) + "，"
				+ "发送失败：" + NumberUtils.toInt(String.valueOf(statusMap.get(MailCount.SEND_FAIL.getType())), 0) + "，"
				+ "共耗时：" + Hours.hoursBetween(beginTime, endTime).getHours() + "小时";
		logger.error(logMessage);

		// 记录日志
		this.saveLog(statusMap, Constants.MAIL_TASK_SYSTEM_COM_RECEIVE_RES_NUM_REMIND, "系统发送企业收到投递简历过少提醒","");
		statusMap = null;
	}

	/**
	 * 给招聘顾问发邮件
	 * 
	 * @param salerMailMap
	 */
	private void sendSalerMail(Map<String, List<LogComReceiveResNum>> salerMailMap, Map<String, Integer> statusMap) {
		if(MapUtils.isNotEmpty(salerMailMap)){
			try{
				for(Map.Entry<String, List<LogComReceiveResNum>> entry : salerMailMap.entrySet()){
					String mailContent = this.assembleMailContent(entry.getValue());
					if(StringUtils.isNotBlank(mailContent)){
						String[] toAddr = StringUtils.split(entry.getKey(), Constants.MAIL_ADDRESS_SEPARATE_CHAR);
						boolean flag = sender.send(new ComReceiveResNumRemindMailVo(mailContent, toAddr, Constants.MAIL_TYPE_SIMPLIFIED));
						try {
							if(flag){
								this.addMailCount(statusMap, MailCount.SEND_SUCCESS);
								logger.error(entry.getKey() + "发送成功！");
							}else{
								this.addMailCount(statusMap, MailCount.SEND_FAIL);
								logger.error(entry.getKey() + "发送失败！");
							}
							Thread.sleep(500);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}else{
						this.addMailCount(statusMap, MailCount.SEARCHER_IS_EMPTY);
					}
				}
			}catch(IOException e){
				e.printStackTrace();
				logger.error("===系统发送企业收到投递简历过少提醒异常：" + e.getMessage(), e);
			}
		}
	}

	/**
	 * 判断职位列表中收到简历小于一定数量就发送
	 *
	 * @param posList
	 * @throws IOException
	 */
	private void logSalerMail(List<ComPosition> posList, Map<String, Integer> statusMap,
			Map<String, List<LogComReceiveResNum>> salerMailMap) {
		if (CollectionUtils.isNotEmpty(posList)) {
			List<Integer> comIdList = this.parseComIdList(posList);
			Map<Integer, String> comInfoMap = this.getComInfoFromComIdList(comIdList);
			Map<Integer, SysUser> mailMap = this.getUserMailFromComList(comIdList);

			int size = NumberUtils.toInt(String.valueOf(statusMap.get(MailCount.TOTAL.getType())), 0);
			statusMap.put(MailCount.TOTAL.getType(), (CollectionUtils.isNotEmpty(posList) ? posList.size() : 0) + size);
			
			for (ComPosition comPosition : posList) {

                //改为发邮件给销售员的上级
				SysUser sysUser = mailMap.get(comPosition.getComId());
                if(sysUser == null || sysUser.getDeptId() == null){
                    this.addMailCount(statusMap, MailCount.EMAIL_ADDR_FILTER);
                    continue;
                }
                String email =  getSalerManagerEmail(sysUser.getDeptId());
                LogComReceiveResNum logComReceiveResNum = this.assembleLogComReceive(comPosition, comInfoMap, sysUser);
                if(StringUtils.isBlank(email)){
                    logger.error("销售员的上级未填写EMAIL，或者是级别不是主管或经理，邮件发送给销售员自己，部门ID： "+ sysUser.getDeptId());
                    email = sysUser.getInternalEmail();
                    if(logComReceiveResNum!= null){
                        logComReceiveResNum.setNotfindManageEmail(true);
                    }
                }

				if (!this.checkInternalEmail(email)) {
					this.addMailCount(statusMap, MailCount.EMAIL_ADDR_FILTER);
					continue;
				}

				if (logComReceiveResNum != null) {
					List<LogComReceiveResNum> logComReceiveList = salerMailMap.get(email);
					if (logComReceiveList == null) {
						logComReceiveList = Lists.newArrayList();
						salerMailMap.put(email, logComReceiveList);
					}
					logComReceiveList.add(logComReceiveResNum);
				}
			}
		}
	}


    /**
     * 组装邮件内容
     * @param comReceiveLogList
     * @return
     * @throws IOException
     */
	private String assembleMailContent(List<LogComReceiveResNum> comReceiveLogList)	throws IOException {
		if (CollectionUtils.isNotEmpty(comReceiveLogList)) {
			Configuration configure = FreemarkerConfigure.getFreemarkerConfig();
			Template template = configure.getTemplate("mail/com_receive_resume_num_remind.ftl");
			String salerName = comReceiveLogList.get(0).getSalerName();

			Map<String, Object> map = Maps.newHashMap();
			map.put("salerName", salerName);
			map.put("receiveLogList", comReceiveLogList);
			try {
				StringWriter result = new StringWriter();
				template.process(map, result);
                String alertStr = "";
                if(comReceiveLogList.get(0).isNotfindManageEmail()) {
                    alertStr = "<br><h2>（此邮件本应发送给您的主管，但TA未填写内部邮箱或者是TA的级别不是主管或经理，请知会更正。）</h2>";
                }
                return result.toString() +alertStr;
			} catch (TemplateException e) {
				logger.error("===邮件模板解析异常：" + e.getMessage(), e);
			}
		}
		return StringUtils.EMPTY;
	}

	/**
	 * 获取企业收到简历数量小于一定量的职位ID列表
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private Map<Integer, Integer> getReceiveResumeNum(Date compareDate, List<Integer> posIdList) {
		Map<Integer, Integer> posReceiveMap = Maps.newHashMap();
		if (CollectionUtils.isNotEmpty(posIdList)) {
			Session session = HibernateActionUtil.currentSession();
			String sql = "SELECT r.pos_id, COUNT(r.pos_id) FROM com_receive r WHERE r.create_date > :createDate"
					+ " AND r.receive_type = 0 AND r.pos_id in(:posIdList) GROUP BY r.pos_id";
			List<Object[]> list = session.createSQLQuery(sql)
					.setParameter("createDate", compareDate)
					.setParameterList("posIdList", posIdList).list();

			if (CollectionUtils.isNotEmpty(list)) {
				for (Object[] data : list) {
					posReceiveMap.put(Integer.parseInt(data[0].toString()), Integer.parseInt(data[1].toString()));
				}
			}
		}
		return posReceiveMap;
	}

	/**
	 * 根据企业ID列表查询企业信息列表
	 * 
	 * @param comIdList
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private Map<Integer, String> getComInfoFromComIdList(List<Integer> comIdList) {
		Map<Integer, String> comInfoMap = Maps.newHashMap();
		if (CollectionUtils.isNotEmpty(comIdList)) {
			Session session = HibernateUtil.currentSession();
			String sql = "SELECT id, com_name FROM com_info WHERE id IN(:comIdList)";
			List<Object[]> list = session.createSQLQuery(sql).setParameterList("comIdList", comIdList).list();

			if (CollectionUtils.isNotEmpty(list)) {
				for (Object[] data : list) {
					String comName = String.valueOf(data[1]);
					if (StringUtils.isNotBlank(comName)) {
						comInfoMap.put(Integer.parseInt(data[0].toString()), comName);
					}
				}
			}
		}
		return comInfoMap;
	}

	/**
	 * 根据企业ID列表查询招聘顾问内部邮件地址
	 * 
	 * @param comIdList
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private Map<Integer, SysUser> getUserMailFromComList(List<Integer> comIdList) {
		Map<Integer, SysUser> salerMailMap = Maps.newHashMap();
		if (CollectionUtils.isNotEmpty(comIdList)) {
			Session session = HibernateUtil.currentSession();
			String sql = "SELECT cbi.id, su.internal_email, su.name, su.id as sid,su.dept_id as deptId FROM com_info cbi INNER JOIN sys_user su ON cbi.saler_id = su.id WHERE"
					+ " cbi.id in(:comIdList) AND su.internal_email != ''";
			List<Object[]> list = session.createSQLQuery(sql).setParameterList("comIdList", comIdList).list();

			if (CollectionUtils.isNotEmpty(list)) {
				for (Object[] data : list) {
					String email = StringUtils.defaultIfBlank(String.valueOf(data[1]), "");
					String name = StringUtils.defaultIfBlank(String.valueOf(data[2]), "");
					Integer id = (Integer) data[3];
					Integer deptId = (Integer) data[4];

					if (StringUtils.isNotBlank(email)) {
						SysUser user = new SysUser();
						user.setInternalEmail(email);
						user.setName(name);
						user.setId(id);
						user.setDeptId(deptId);;
						salerMailMap.put(Integer.parseInt(data[0].toString()), user);
					}
				}
			}
		}
		return salerMailMap;
	}

	/**
	 * 过滤满足条件的职位列表
	 * 
	 * @param posList
	 */
	private void filterNotReachedPos(List<ComPosition> posList, Date compareDate, Integer reachedNum) {
		if (CollectionUtils.isNotEmpty(posList)) {
			List<Integer> posIdList = this.parsePosIdList(posList);
			Map<Integer, Integer> posReceiveMap = this.getReceiveResumeNum(compareDate, posIdList);
			for (Iterator<ComPosition> iterator = posList.iterator(); iterator.hasNext();) {
				ComPosition position = iterator.next();
				if (posReceiveMap.containsKey(position.getId()) && posReceiveMap.get(position.getId()) >= reachedNum) {
					iterator.remove();
				}
			}
		}
	}

	/**
	 * 转换职位ID列表
	 * 
	 * @param posList
	 * @return
	 */
	private List<Integer> parsePosIdList(List<ComPosition> posList) {
		List<Integer> posIdList = Lists.newArrayList();
		if (CollectionUtils.isNotEmpty(posList)) {
			for (ComPosition comPosition : posList) {
				posIdList.add(comPosition.getId());
			}
		}
		return posIdList;
	}

	/**
	 * 转换企业ID列表
	 * 
	 * @param posList
	 * @return
	 */
	private List<Integer> parseComIdList(List<ComPosition> posList) {
		List<Integer> comIdList = Lists.newArrayList();
		if (CollectionUtils.isNotEmpty(posList)) {
			for (ComPosition comPosition : posList) {
				if (!comIdList.contains(comPosition.getId())) {
					comIdList.add(comPosition.getComId());
				}
			}
		}
		return comIdList;
	}

	/**
	 * 组装企业受到简历过少的实体
	 * 
	 * @param comPosition
	 * @param comInfoMap
	 * @param user
	 * @return
	 */
	private LogComReceiveResNum assembleLogComReceive(ComPosition comPosition, Map<Integer, String> comInfoMap,
			SysUser user) {
		if (comPosition != null && comInfoMap.containsKey(comPosition.getComId())) {
			LogComReceiveResNum logComReceiveResNum = new LogComReceiveResNum();
			logComReceiveResNum.setComId(comPosition.getComId());
			logComReceiveResNum.setComName(comInfoMap.get(comPosition.getComId()));
			logComReceiveResNum.setEmail(user.getInternalEmail());
			logComReceiveResNum.setPosId(comPosition.getId());
			logComReceiveResNum.setPosName(comPosition.getPosName());
			logComReceiveResNum.setSalerId(user.getId());
			logComReceiveResNum.setSalerName(user.getName());
			logComReceiveResNum.setCreateDate(new Date());
			return logComReceiveResNum;
		}
		return null;
	}

    /**
     * 记录企业收到简历数量
     * @param comPosition
     * @param comInfoMap
     * @param user
     */
	@SuppressWarnings("unused")
	private void logComReceiveNum(ComPosition comPosition, Map<Integer, String> comInfoMap, SysUser user) {
		LogComReceiveResNum logComReceiveResNum = new LogComReceiveResNum();
		logComReceiveResNum.setComId(comPosition.getComId());
		logComReceiveResNum.setComName(comInfoMap.get(comPosition.getComId()));
		logComReceiveResNum.setEmail(user.getInternalEmail());
		logComReceiveResNum.setPosId(comPosition.getId());
		logComReceiveResNum.setPosName(comPosition.getPosName());
		logComReceiveResNum.setSalerId(user.getId());
		logComReceiveResNum.setSalerName(user.getName());
		logComReceiveResNum.setCreateDate(new Date());

		Session session = HibernateCountUtil.currentSession();
		session.save(logComReceiveResNum);
		session.flush();
	}

    /**
     * 取得销售员上级的邮箱
     * @param deptId
     * @return
     */
    private String getSalerManagerEmail(Integer deptId){
        String email = "";
        Session session = HibernateUtil.currentSession();
        String hql = " FROM SysUser WHERE deptId = :deptId AND grade > 2 AND grade < 5";
        Query query = session.createQuery(hql);
        query.setParameter("deptId",deptId);
        List list = query.list();
        if(CollectionUtils.isNotEmpty(list)){
        	SysUser user = (SysUser) list.get(0);
        	if (user != null) {
        		email = ObjectUtils.toString(user.getInternalEmail());
        	}
        }
        return  email;
    }
}
