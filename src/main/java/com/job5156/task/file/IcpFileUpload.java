package com.job5156.task.file;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.google.common.collect.Lists;
import com.job5156.beans.FtpBean;
import com.job5156.beans.ServerConfig;
import com.job5156.beans.ServerConfigLoader;
import com.job5156.beans.mail.EmailSender;
import com.job5156.common.CommonEnum.MailServer;
import com.job5156.common.Constants;
import com.job5156.common.exception.EmailServerConfigException;
import com.job5156.common.exception.FtpConnectException;
import com.job5156.common.jedis.JedisFactory;
import com.job5156.common.jedis.JedisTemplate;
import com.job5156.model.mail.EmailQueue;

/**
 * ICP文件上传到FTP服务器
 * @author leo
 *
 */
public class IcpFileUpload {
	private static final Logger logger = Logger.getLogger(IcpFileUpload.class);
	
	private String hostName;		//主机名称
	private String port;			//主机端口
	private String userName;		//ftp账号
	private String password;		//ftp密码
	private String remoteDir;		//上传目录
	
	private FtpBean ftpBean;
	private JedisFactory jedisFactory;
	
	public IcpFileUpload(){
		this.hostName = ServerConfigLoader.getConfigByName(ServerConfig.ICP_FILE_UPLOAD_HOST);  
        this.port = ServerConfigLoader.getConfigByName(ServerConfig.ICP_FILE_UPLOAD_PORT);  
        this.userName = ServerConfigLoader.getConfigByName(ServerConfig.ICP_FILE_UPLOAD_USERNAME);  
        this.password = ServerConfigLoader.getConfigByName(ServerConfig.ICP_FILE_UPLOAD_PASSWORD);  
        this.remoteDir = ServerConfigLoader.getConfigByName(ServerConfig.ICP_FILE_UPLOAD_REMOTEDIR);
        
        ftpBean = new FtpBean(this.hostName, Integer.parseInt(this.port), this.userName, this.password, this.remoteDir);
        jedisFactory = JedisFactory.getInstance();
	}
	
	public static void main(String[] args){
		IcpFileUpload upload = new IcpFileUpload();
		upload.upload();
		upload = null;
	}
	
	/**
	 * 文件上传
	 */
	private void upload(){
		logger.info("=====开始上传ICP压缩文件=====");
		long startTime = System.currentTimeMillis();
		
		JedisTemplate jedisTemplate = jedisFactory.getDefaultJedisTemplate();
		if(jedisTemplate.isInSet(Constants.TASK_UPLOAD_START_FLAG, "uploadIcpFile")){
			String redisKey = Constants.REDIS_KEY_SAVE_FILE_ICP_PATH;
			List<String> uploadFileList = jedisTemplate.readFromZset(redisKey, 0);
			StringBuffer buffer = new StringBuffer();
			
			if(CollectionUtils.isNotEmpty(uploadFileList)){
				for(String uploadFilePath : uploadFileList){
					try{
						boolean uploadFlag = this.uploadFlie(uploadFilePath);
						if(uploadFlag){
							jedisTemplate.removeFromZset(redisKey, Lists.newArrayList(uploadFilePath));
							logger.error("icp file upload success: fileName[" + uploadFilePath +"]\r\n");
						}else{
							buffer.append("icp file upload fail: fileName[" + uploadFilePath + "]\r");
							logger.error("icp file upload fail: fileName[" + uploadFilePath + "]\r");
						}
					}catch(Exception e){
						e.printStackTrace();
						buffer.append("icp file upload exception: fileName[" + uploadFilePath + "]\r" + e.getMessage());
						logger.error("icp file upload exception: fileName[" + uploadFilePath + "]\r" + e.getMessage());
					}
				}
				ftpBean.closeServer();
			}
			
			if(buffer.length() > 0){
				this.sendFailMailRemind(buffer.toString());
			}
		}
		
		long endTime = System.currentTimeMillis();
		logger.info("=====上传ICP压缩文件结束，耗时 "+((endTime - startTime)/(1000))+"秒=====");
	}
	
	/**
	 * 上传单一文件到ftp服务器
	 * @param filePath
	 * @throws Exception 
	 */
	private boolean uploadFlie(String filePath) throws Exception{
		int connectTimes = 0;
		boolean connected = ftpBean.serverIsOpen();
		while(!connected && connectTimes <= 10){
			try {
				ftpBean.login();
				connected = ftpBean.serverIsOpen();
			} catch (Exception e) {
				e.printStackTrace();
				connected = false;
			}
			connectTimes ++;
		}
		
		if(!connected){
			throw new FtpConnectException("connect ftp server exception!");
		}
		
		String targetFilePath = StringUtils.substringAfterLast(filePath, "/");
		return ftpBean.upload(filePath, targetFilePath);
	}
	
	/**
	 * 文件生成失败发送提醒邮件
	 */
	private void sendFailMailRemind(String content){
		try {
			EmailSender sender = new EmailSender(MailServer.EXCHANGE);
			EmailQueue emailQueue = new EmailQueue();
			emailQueue.setToAddr("dg3996@zhitong.com");
			emailQueue.setFromName("智通人才网");
			emailQueue.setTitle("ICP文件上传失败");
			emailQueue.setContent(content);
			sender.send(emailQueue);
		} catch (EmailServerConfigException e) {
			e.printStackTrace();
		}
	}
	
}
