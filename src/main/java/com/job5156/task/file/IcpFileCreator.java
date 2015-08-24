package com.job5156.task.file;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.jboss.logging.Logger;
import org.joda.time.DateTime;
import org.springframework.jdbc.core.JdbcTemplate;

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.job5156.beans.ServerConfig;
import com.job5156.beans.ServerConfigLoader;
import com.job5156.beans.mail.EmailSender;
import com.job5156.common.CommonEnum.MailServer;
import com.job5156.common.Constants;
import com.job5156.common.exception.EmailServerConfigException;
import com.job5156.common.jedis.JedisFactory;
import com.job5156.common.jedis.JedisTemplate;
import com.job5156.common.util.FileUtil;
import com.job5156.common.util.HibernateSalveBaseUtil;
import com.job5156.model.mail.EmailQueue;
import com.job5156.vo.file.IcpBaseVo;
import com.job5156.vo.file.IcpPerLoginVo;
import com.job5156.vo.file.IcpPerRegisterVo;

/**
 * <p>
 * ICP文件生成器<br>
 * 1、按照ICP定义的文件生成规则，导出企业及个人信息<br>
 * 2、定义文件传输格式参见ICP数据传输标准1.2.6.doc<br>
 * </p>
 * 
 * @author leo
 * 
 */
public class IcpFileCreator {
	private static final Logger logger = Logger.getLogger(IcpFileCreator.class);
	
	private JedisFactory jedisFactory = JedisFactory.getInstance();
	
	//东莞地区行政编码
	private static final String CITY_ADMIN_CODE = "441900";
	//网站编码
	private static final String WEBSITE_CODE = "1002";
	//协议类型
	private static final String DATA_TYPE = "PASSPORT";
	//协议类型标识目录
	private static final String DATA_TYPE_PATH = "/passport";
	//服务器IP目录
	private static final String SERVER_IP_PATH = "/119.147.105.34";
	
	//生成bcp文件保存路径
	private String bcpSaveFilePath;
	//生成备份bcp文件保存路径
	private String bcpBakSaveFilePath;
	//生成zip压缩文件路径
	private String zipSaveFilePath;
	//以当前程序开始运行时间点目录
	private String runTimePath;
	
	public IcpFileCreator(){
		this.bcpSaveFilePath = ServerConfigLoader.getConfigByName(ServerConfig.ICP_BCPFILE_SAVE_PATH);
		this.zipSaveFilePath = ServerConfigLoader.getConfigByName(ServerConfig.ICP_ZIPFILE_SAVE_PATH);
		this.bcpBakSaveFilePath = ServerConfigLoader.getConfigByName(ServerConfig.ICP_BCPFILE_BAK_SAVE_PATH);
		this.runTimePath = "/" + (DateTime.now().getMillis() / 1000);
	}
	
	public static void main(String[] args){
		logger.info("=====生成ICP数据文件开始=====");
		long startTime = System.currentTimeMillis();
		
		Map<String, String> dateMap = Maps.newHashMap();
		if(ArrayUtils.isNotEmpty(args)){
			dateMap.put("beginDate", args[0]);
			if(args.length == 2){
				dateMap.put("endDate", args[1]);
			}
		}
		
		IcpFileCreator icpFileCreator = new IcpFileCreator();
		boolean initFlag = icpFileCreator.initDataFileDir();
		if(initFlag){
			try{
				icpFileCreator.createFile(dateMap);
			}catch(Exception e){
				e.printStackTrace();
				icpFileCreator.sendFailMailRemind(e.getMessage());
				logger.error("生成数据文件失败：" + e.getMessage());
			}
		}
		
		icpFileCreator = null;
		long endTime = System.currentTimeMillis();
		logger.info("=====生成ICP数据文件结束，耗时 "+((endTime - startTime)/1000)+"秒=====");
	}
	
	/**
	 * 文件生成失败发送提醒邮件
	 */
	private void sendFailMailRemind(String msg){
		try {
			EmailSender sender = new EmailSender(MailServer.EXCHANGE);
			EmailQueue emailQueue = new EmailQueue();
			emailQueue.setToAddr("dg3996@zhitong.com");
			emailQueue.setFromName("智通人才网");
			emailQueue.setTitle("ICP文件生成失败");
			emailQueue.setContent("ICP文件生成异常，错误信息：" + msg);
			sender.send(emailQueue);
		} catch (EmailServerConfigException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 在生成数据文件之前对数据目录进行备份
	 */
	public boolean initDataFileDir(){
		try{
			logger.info("====开始初始化文件目录====");
			//FileUtil.delFileDir(bcpBakSaveFilePath);
			//FileUtil.bakFileDir(bcpSaveFilePath, bcpBakSaveFilePath);
			File saveFileDir = new File(zipSaveFilePath);
			if(!saveFileDir.exists()){
				saveFileDir.mkdirs();
			}
			FileUtil.delFileDir(bcpSaveFilePath);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			logger.error("数据目录初始化失败：" + e.getMessage());
			return false;
		}
	}
	
	/**
	 * 导出ICP文件并生成压缩文件
	 * @param dateMap
	 * @throws Exception 
	 */
	public void createFile(Map<String, String> dateMap) throws Exception{
		Date beginDate = DateTime.now().minusDays(1).withTimeAtStartOfDay().toDate();
		Date endDate = DateTime.now().withTimeAtStartOfDay().toDate();
		
		String beginDateStr = dateMap.get("beginDate");
		String endDateStr = dateMap.get("endDate");
		
		if(StringUtils.isNotBlank(beginDateStr)){
			beginDate = new DateTime(beginDateStr).withTimeAtStartOfDay().toDate();
		}
		
		if(StringUtils.isNotBlank(endDateStr)){
			endDate = new DateTime(endDateStr).withTimeAtStartOfDay().toDate();
		}
		
		this.createPerRegisterFile(beginDate, endDate);
		this.createPerLoginFile(beginDate, endDate);
		this.createZIPFile();
	}
	
	/**
	 * 生成个人注册数据文件
	 * @param beginDate
	 * @param endDate
	 */
	private void createPerRegisterFile(Date beginDate, Date endDate){
		int lastRecordId = 0;
		int fileIndex = 1;
		
		List<IcpPerRegisterVo> dataList = Lists.newArrayList();
		JdbcTemplate jdbcTemplate = HibernateSalveBaseUtil.getJdbcTemplate();
		logger.info("====开始生成个人注册数据文件====");
		
		while(true){
			String sql = "SELECT u.*, r.pass FROM per_user u LEFT JOIN per_resume r ON u.res_id = r.id"
					   + " WHERE u.create_date > ? AND u.create_date < ? AND u.id > ? ORDER BY u.id ASC LIMIT 5000";
			List<Map<String, Object>> userList = jdbcTemplate.queryForList(sql, beginDate, endDate, lastRecordId);
			if(CollectionUtils.isEmpty(userList)){
				break;
			}
			for(Map<String, Object> dataMap : userList){
				IcpPerRegisterVo icpPerRegisterVo = this.assemblePerRegisterVo(dataMap);
				if(icpPerRegisterVo != null){
					dataList.add(icpPerRegisterVo);
					if(CollectionUtils.size(dataList) >= 5000){
						String fileContent = this.assembleFileData(dataList);
						this.writeToFile(fileContent, BusinessType.REGISTER, DATA_TYPE, fileIndex);
						dataList.clear();
						fileIndex ++;
					}
				}
				lastRecordId = NumberUtils.toInt(String.valueOf(dataMap.get("id")));
			}
		}
		
		if(CollectionUtils.isNotEmpty(dataList)){
			String fileContent = this.assembleFileData(dataList);
			this.writeToFile(fileContent, BusinessType.REGISTER, DATA_TYPE, fileIndex);
		}
	}
	
	/**
	 * 生成个人登陆数据文件
	 * @param beginDate
	 * @param endDate
	 */
	private void createPerLoginFile(Date beginDate, Date endDate){
		int lastRecordId = 0;
		int fileIndex = 1;
		
		List<IcpPerLoginVo> dataList = Lists.newArrayList();
		JdbcTemplate jdbcTemplate = HibernateSalveBaseUtil.getJdbcTemplate();
		logger.info("====开始生成个人登陆数据文件====");
		
		while(true){
			String sql = "SELECT ph.*, u.account as account, u.user_name as userName FROM per_login_history ph"
					   + " LEFT JOIN per_user u ON ph.per_user_id = u.id WHERE ph.cre_time > ? AND ph.cre_time < ?"
					   + " AND ph.id > ? ORDER BY ph.id ASC LIMIT 5000";
			List<Map<String, Object>> loginList = jdbcTemplate.queryForList(sql, beginDate, endDate, lastRecordId);
			if(CollectionUtils.isEmpty(loginList)){
				break;
			}
			for(Map<String, Object> dataMap : loginList){
				IcpPerLoginVo icpPerLoginVo = this.assemblePerLoginVo(dataMap);
				if(icpPerLoginVo != null){
					dataList.add(icpPerLoginVo);
					if(CollectionUtils.size(dataList) >= 5000){
						String fileContent = this.assembleFileData(dataList);
						this.writeToFile(fileContent, BusinessType.LOGIN, DATA_TYPE, fileIndex);
						dataList.clear();
						fileIndex ++;
					}
				}
				lastRecordId = NumberUtils.toInt(String.valueOf(dataMap.get("id")));
			}
		}
		
		if(CollectionUtils.isNotEmpty(dataList)){
			String fileContent = this.assembleFileData(dataList);
			this.writeToFile(fileContent, BusinessType.LOGIN, DATA_TYPE, fileIndex);
		}
	}
	
	/**
	 * 组装用户注册对象VO
	 * @param perUser
	 * @return
	 */
	private IcpPerRegisterVo assemblePerRegisterVo(Map<String, Object> dataMap){
		if(MapUtils.isNotEmpty(dataMap)){
			Integer pass = NumberUtils.toInt(ObjectUtils.toString(dataMap.get("pass")), 0);
			
			IcpPerRegisterVo registerVo = new IcpPerRegisterVo();
			registerVo.setIcpCode(this.generateIcpCode(AppCode.REGISTER.getCode()));
			registerVo.setDataType(DATA_TYPE);
			registerVo.setUserId(String.valueOf(dataMap.get("id")));
			registerVo.setStatus(getResumeStatus(pass));
			registerVo.setRegisterTime(new DateTime(dataMap.get("create_date")).toString("yyyyMMddHHmmss"));
			return registerVo;
		}
		return null;
	}
	
	/**
	 * 组装用户登陆对象VO
	 * @param perUser
	 * @return
	 */
	private IcpPerLoginVo assemblePerLoginVo(Map<String, Object> dataMap){
		if(MapUtils.isNotEmpty(dataMap)){
			String ipCode = this.generateIpCode(ObjectUtils.toString(dataMap.get("ip")));
			String userId = ObjectUtils.toString(dataMap.get("per_user_id"));
			
			if(StringUtils.isNotBlank(ipCode) && StringUtils.isNotBlank(userId)){
				IcpPerLoginVo loginVo = new IcpPerLoginVo();
				loginVo.setIcpCode(this.generateIcpCode(AppCode.LOGIN.getCode()));
				loginVo.setDataType(DATA_TYPE);
				loginVo.setSrcIp(ipCode);
				loginVo.setUserId(userId);
				loginVo.setAction(String.valueOf(1));
				loginVo.setActionTime(new DateTime(dataMap.get("cre_time")).toString("yyyyMMddHHmmss"));
				return loginVo;
			}
		}
		return null;
	}
	
	/**
	 * 组装文件内容
	 * @param userList
	 * @return
	 */
	private String assembleFileData(List<? extends IcpBaseVo> dataList){
		StringBuffer buf = new StringBuffer();
		buf.append("ICP\t2.1\t"+DATA_TYPE+"\r\n");
		if(CollectionUtils.isNotEmpty(dataList)){
			for(IcpBaseVo icpBaseVo : dataList){
				buf.append(icpBaseVo.getContent()+"\r\n");
			}
		}
		return buf.toString();
	}
	
	/**
	 * 写内容到文件
	 * @param content
	 * @param filePath
	 */
	private void writeToFile(String content, BusinessType businessType, String dataType, Integer fileIndex){
		String filePath = bcpSaveFilePath + SERVER_IP_PATH + businessType.getPath() + runTimePath + DATA_TYPE_PATH;
		String fileName = businessType.getName() 
				+ "_" 
				+ dataType 
				+ "_" 
				+ (DateTime.now().getMillis() / 1000) 
				+ "_" 
				+ fileIndex
				+ ".bcp";
		if(StringUtils.isNotBlank(content)){
			String file = filePath + "/" + fileName;
			try{
				File fileDir = new File(filePath);
	            //如果目录不存在则创建目录
	            if(!fileDir.exists()) fileDir.mkdirs();
				FileUtils.writeStringToFile(new File(file), content, Charsets.UTF_8);
			}catch(Exception e){
				e.printStackTrace();
				logger.error("ICP文件生成失败["+file+"]：" + e.getMessage());
			}
		}
	}
	
	/**
	 * 创建压缩文件
	 * @throws Exception 
	 */
	private void createZIPFile() throws Exception{
		logger.info("====开始压缩并加密数据文件====");
		String redisKey = Constants.REDIS_KEY_SAVE_FILE_ICP_PATH;
		String zipFileName = "data_" + (DateTime.now().getMillis() / 1000) + ".zip";
		String saveFilePath = zipSaveFilePath + "/" + zipFileName;
		
		Map<String, String> statusMap = execLinuxCmd("/home/compressIcp.sh "+zipFileName);
		Integer resultCode = NumberUtils.toInt(statusMap.get("resultCode"), 1);
		if(resultCode == 1){
			throw new Exception("ICP文件压缩加密linux执行异常：" + statusMap.get("errorInfo"));
		}
		
		//保存生成的ICP文件路径到redis
		JedisTemplate jedisTemplate = jedisFactory.getJedisTemplate(redisKey);
		jedisTemplate.writeToZset(redisKey, Lists.newArrayList(saveFilePath));
	}
	
	/**
	 * 根据应用编码获取ICP编码
	 * @return
	 */
	private String generateIcpCode(String appCode){
		return CITY_ADMIN_CODE + "13" + WEBSITE_CODE + appCode;
	}
	
	/**
	 * 获取IP编码
	 * @param ip
	 * @return
	 */
	private String generateIpCode(String ip){
		String[] ipArr = StringUtils.split(ip, ".");
		if(ArrayUtils.isNotEmpty(ipArr) && ipArr.length == 4){
			Long ipCode = Long.parseLong(ipArr[0]) * 256 * 256 * 256
						   + Long.parseLong(ipArr[1]) * 256 * 256
						   + Long.parseLong(ipArr[2]) * 256
						   + Long.parseLong(ipArr[3]);
			return String.valueOf(ipCode);
		}
		return null;
	}
	
	/**
	 * 调用linux命令执行
	 * @param command
	 * @return
	 */
	public static final Map<String, String> execLinuxCmd(String command) {  
        Process p = null;  
        Map<String, String> statusMap = Maps.newHashMap();  
        try {  
            String[] comands = new String[] { "/bin/sh", "-c", command };  
            p = Runtime.getRuntime().exec(comands);  
  
            String error = read(p.getErrorStream());  
            String outInfo = read(p.getInputStream());  
  
            String resultCode = "0";//脚本中输出0表示命令执行成功  
            if (error.length() != 0) { //如果错误流中有内容，表明脚本执行有问题  
                resultCode = "1";  
            }
  
            statusMap.put("resultCode", resultCode);
            statusMap.put("errorInfo", error);
            statusMap.put("outInfo", outInfo);
  
            p.waitFor();  
        } catch (Exception e) {
        	e.printStackTrace();
        	logger.error("ICP文件压缩加密失败：" + e.getMessage());
        } finally {  
            try {  
                p.getErrorStream().close();  
            } catch (Exception e) {  
            }  
            try {  
                p.getInputStream().close();  
            } catch (Exception e) {  
            }  
            try {  
                p.getOutputStream().close();  
            } catch (Exception e) {  
            }  
        }  
        return statusMap;  
    }  
  
    public static final String read(InputStream in) throws IOException {  
        StringBuilder sb = new StringBuilder();  
        int ch;  
        while (-1 != (ch = in.read())) {
        	sb.append((char) ch);  
        }
        return sb.toString();  
    } 
	
	/**
	 * 业务类型枚举定义
	 * @author leo
	 *
	 */
	public enum BusinessType {
		REGISTER("register", "/register"),
		CONNECT("connect", "/connect"),
		LOGIN("login", "/login"),
		ACCESS("access", "/access");
		
		private String name;
		private String path;
		
		private BusinessType(String name, String path){
			this.name = name;
			this.path = path;
		}
		
		public String getName(){
			return this.name;
		}
		
		public String getPath(){
			return this.path;
		}
	}

	/**
	 * 业务应用编码[90-99]
	 * @author leo
	 *
	 */
	public enum AppCode {
		REGISTER("00"),
		LOGIN("00");
		
		private String code;
		
		private AppCode(String code){
			this.code = code;
		}
		
		public String getCode(){
			return this.code;
		}
	}
	
	/**
	 * 转换简历状态
	 * @param pass
	 * @return
	 */
	public String getResumeStatus(Integer pass){
		if(pass != null){
			if(pass > 0){
				return "已完善";
			}else if(pass == 0){
				return "未完善";
			}else if(pass == -10 || pass == -11 || pass == -12){
				return "已删除";
			}else if(pass == -9){
				return "已停用";
			}else{
				return "未完善";
			}
		}else{
			return "未完善";
		}
	}
	
	public String getBcpSaveFilePath() {
		return bcpSaveFilePath;
	}

	public void setBcpSaveFilePath(String bcpSaveFilePath) {
		this.bcpSaveFilePath = bcpSaveFilePath;
	}

	public String getBcpBakSaveFilePath() {
		return bcpBakSaveFilePath;
	}

	public void setBcpBakSaveFilePath(String bcpBakSaveFilePath) {
		this.bcpBakSaveFilePath = bcpBakSaveFilePath;
	}

	public String getZipSaveFilePath() {
		return zipSaveFilePath;
	}

	public void setZipSaveFilePath(String zipSaveFilePath) {
		this.zipSaveFilePath = zipSaveFilePath;
	}

	public String getRunTimePath() {
		return runTimePath;
	}

	public void setRunTimePath(String runTimePath) {
		this.runTimePath = runTimePath;
	}

}
