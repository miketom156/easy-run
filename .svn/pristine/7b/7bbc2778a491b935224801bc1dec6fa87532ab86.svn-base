package com.job5156.task.collect.company;

import java.sql.SQLException;
import java.util.Date;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import com.job5156.common.util.HttpClientUtils;
import com.job5156.model.temp.ComInfoCellect;

/**
 * 
* 数据采集基类
* @author xh 
* @date 2014-9-26 下午4:34:11 
*
 */
public abstract class CompanyDataCellectBase {
	//是否初始化数据
	private boolean init = false;
	//爬行器间歇时间（毫秒）
	private int waitTime = 500;
	//HTTP请求访问工具类
	private HttpClientUtils hcu;
	
	public CompanyDataCellectBase() {
		hcu = HttpClientUtils.getInstance();
	}
	
	public boolean isInit() {
		return init;
	}

	public void setInit(boolean init) {
		this.init = init;
	}

	public int getWaitTime() {
		return waitTime;
	}

	public void setWaitTime(int waitTime) {
		this.waitTime = waitTime;
	}

	public HttpClientUtils getHcu() {
		return hcu;
	}

	public void setHcu(HttpClientUtils hcu) {
		this.hcu = hcu;
	}

	/**
	 * 
	* 企业类型
	* @author xh 
	* @date 2014-9-26 下午2:28:02 
	*
	 */
	protected enum ComType {
		/**
		 * 卓博人才网
		 */
		JOBCN(0),
		/**
		 * 中山国际人才网(中华英才网)
		 */
		JOB001(1);
		
		private int value;
		
		public int getValue() {
			return value;
		}

		private ComType(int value) {
			this.value = value;
		}
	}
	
	/**
	 * 
	* 企业状态
	* @author xh 
	* @date 2014-8-28 下午3:04:58 
	*
	 */
	protected enum Status {
		/**
		 * 默认初始化数据
		 */
		DEFAULT(0),
		/**
		 * 新增的数据
		 */
		NEW(1),
		/**
		 * 过期的数据
		 */
		EXPIRE(-1);
		
		private int value;

		public int getValue() {
			return value;
		}

		private Status(int value) {
			this.value = value;
		}
	}
	
	/**
	 * 
	* 是否为智通会员
	* @author xh 
	* @date 2014-8-28 下午3:17:55 
	*
	 */
	protected enum MemberStatus {
		NO(0),
		YES(1);
		
		private int value;
		
		public int getValue() {
			return value;
		}

		private MemberStatus(int value) {
			this.value = value;
		}
	}
	
	private JdbcTemplate sourceTemplate = new JdbcTemplate(getJob5156DataSource());
	private JdbcTemplate sourceDownJobTemplate = new JdbcTemplate(getDownJobDataSource());
	
	private DataSource getJob5156DataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		basicDataSource.setUrl("jdbc:mysql://192.168.2.237/5156base?zeroDateTimeBehavior=convertToNull");
		basicDataSource.setUsername("M5156BSQL");
		basicDataSource.setPassword("&,R}sH_F{g5!$w](+V8')-8gJ");
		/*basicDataSource.setUrl("jdbc:mysql://192.168.8.47/5156base?zeroDateTimeBehavior=convertToNull");
		basicDataSource.setUsername("ztcwr");
		basicDataSource.setPassword("Chitone5156Zt%1");*/
		return basicDataSource;
	}

	private DataSource getDownJobDataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		basicDataSource.setUrl("jdbc:mysql://192.168.8.187/DownJob?zeroDateTimeBehavior=convertToNull");
		basicDataSource.setUsername("job2008");
		basicDataSource.setPassword("job2008");
		return basicDataSource;
	}
	
	/**
	 * 
	* 关闭数据库连接
	* @param     设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void closeDatabaseConnection() {
		try {
			sourceTemplate.getDataSource().getConnection().close();
			sourceDownJobTemplate.getDataSource().getConnection().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	* 解析html获取企业信息抽象方法
	* @param @param html
	* @param @return    设定文件 
	* @return JobcnComInfo    返回类型 
	* @throws
	 */
	public abstract ComInfoCellect getComInfo(String html);
	
	/**
	 * 
	* @Title: handleCompanyData 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param     设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void cellectCompanyData(ComInfoCellect comInfo, ComType comType) {
		if(comInfo != null) {
			boolean exist = isDownloaded(comInfo.getComId(), comType);
			
			if(init && !exist) {
				addCompanyData(comInfo, Status.DEFAULT, comType);
			} else {
				analysisCompanyData(comInfo, comType, exist);
			}
			System.out.println("=====>企业ID：" + comInfo.getComId() + "=====>企业名称：" + comInfo.getComName());
		}
		
		try {
			//设置采集间隔时间
			Thread.sleep(getWaitTime());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	* 添加企业数据
	* @return void    返回类型 
	* @throws
	 */
	public void addCompanyData(ComInfoCellect jobcnComInfo, Status status, ComType comType) {
		if(jobcnComInfo != null) {
			try {
				String sql = "insert into com_info_cellect(com_id,com_name,contact_person,contact_phone,email,status,my_member,create_date,update_date,com_type) values(?,?,?,?,?,?,?,?,?,?)";
				jobcnComInfo.setStatus(status.value);
				jobcnComInfo.setInMyDatabase(isMyMember(jobcnComInfo.getComName()).ordinal());
				jobcnComInfo.setCreateDate(new Date());
				jobcnComInfo.setUpdateDate(new Date());
				sourceDownJobTemplate.update(sql, jobcnComInfo.getComId(), jobcnComInfo.getComName(), jobcnComInfo.getContactPerson(), 
						jobcnComInfo.getContactPhone(), jobcnComInfo.getEmail(), jobcnComInfo.getStatus(), jobcnComInfo.getInMyDatabase(), 
						jobcnComInfo.getCreateDate(), jobcnComInfo.getUpdateDate(), comType.value);
			} catch(Exception e) {
				System.out.println("添加企业信息到数据库时发生错误：" + e.toString());
			}
			
		}
	}
	
	/**
	 * 
	* 判断指定的企业名称是否存在于智通企业数据表中(排除导入的企业会员member_type=6)
	* @param @param comName
	* @param @return    设定文件 
	* @return boolean    返回类型 
	* @throws
	 */
	private MemberStatus isMyMember(String comName) {
		String sql = "select count(r.id) from com_info c,com_right r where r.com_id=c.id and r.expire_date >= now() and c.com_name = ? and member_type !=6";
		Integer count = sourceTemplate.queryForObject(sql, Integer.class, comName);
		
		return count > 0 ? MemberStatus.YES : MemberStatus.NO;
	}
	
	/**
	 * 
	* 分析已采集的企业数据
	* @param @param jobcnComInfo
	* @param @param comId    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void analysisCompanyData(ComInfoCellect jobcnComInfo, ComType comType, boolean exist) {
		String comId = jobcnComInfo.getComId() == null ? "" : jobcnComInfo.getComId();
		
		if(exist) {
			if(StringUtils.isBlank(comId)) {
				updateCompanyStatus(comId, comType, Status.EXPIRE);
			} else {
				MemberStatus status = isMyMember(jobcnComInfo.getComName());
				//更新已存在于智通数据库中
				if(status.value == MemberStatus.YES.value) {
					setInMyDatabaseStatus(comId, comType, status);
				}
			}
		} else {
			addCompanyData(jobcnComInfo, Status.NEW, comType);
		}
	}
	
	/**
	 * 
	* 验证是否需要初始化数据
	* @param @return    设定文件 
	* @return boolean    返回类型 
	* @throws
	 */
	public boolean validateDateInit(ComType comType) {
		String sql = "select count(1) from com_info_cellect where com_type = ?";
		Integer count = sourceDownJobTemplate.queryForObject(sql, Integer.class, comType.value);
		
		return count == 0 ? true : false;
	}
	
	/**
	 * 
	* 判断指定的企业ID是否已经下载过
	* @param @param comName
	* @param @return    设定文件 
	* @return boolean    返回类型 
	* @throws
	 */
	private boolean isDownloaded(String comId, ComType comType) {
		String sql = "select count(1) from com_info_cellect where com_id = ? and com_type = ?";
		Integer count = sourceDownJobTemplate.queryForObject(sql, Integer.class, comId, comType.value);
		
		return count > 0 ? true : false;
	}
	
	/**
	 * 
	* 修改已下载企业状态
	* @param @param comId
	* @param @param status
	* @param @return    设定文件 
	* @return boolean    返回类型 
	* @throws
	 */
	private boolean updateCompanyStatus(String comId, ComType comType, Status status) {
		String sql = "update jobcn_com_info set status = ?, update_date = ? where com_id = ? and com_type = ?";
		return sourceDownJobTemplate.update(sql, status.value, new Date(), comId, comType.value) > 0 ? true : false;
	}
	
	/**
	 * 
	* 设置卓博企业数据已经存在在智通企业数据中（已经存在则不执行更新操作）
	* @param @param comId
	* @param @param status
	* @param @return    设定文件 
	* @return boolean    返回类型 
	* @throws
	 */
	private boolean setInMyDatabaseStatus(String comId, ComType comType, MemberStatus status) {
		String sql = "update com_info_cellect set my_member = ?, update_date = ? where com_id = ? and com_type = ? and my_member = 0";
		return sourceDownJobTemplate.update(sql, status.value, new Date(), comId, comType.value) > 0 ? true : false;
	}
	
	/**
	 * 
	* 解析工具类
	* @author xh 
	* @date 2014-8-27 下午5:14:31 
	*
	 */
	public static class ParseUtils {
		public static String parserValueByElement(String content, ParseElement element) {
			String parserContent = content;
			String value = "";
			
			int indexOf = parserContent.indexOf(element.getBegin());
			
			if(indexOf != -1) {
				parserContent = parserContent.substring(indexOf + element.getBegin().length(), parserContent.length());
				indexOf = parserContent.indexOf(element.getEnd());
				
				if(indexOf != -1) {
					value = parserContent.substring(0, indexOf);
				}
			}
			
			return value;
		}
	}
	
	/**
	 * 
	* 解析元素类
	* @author xh 
	* @date 2014-8-27 下午5:04:04 
	*
	 */
	public class ParseElement {
		private String begin;
		private String end;
		
		public ParseElement(String begin, String end) {
			this.begin = begin;
			this.end = end;
		}
		
		public String getBegin() {
			return begin;
		}
		public String getEnd() {
			return end;
		}
	}
}
