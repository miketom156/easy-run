package com.job5156.beans;

/**
 * <p>
 * 项目配置文件配置项
 * </p>
 * 
 * @author leo
 * 
 */
public class ServerConfig {

	//ICP对应bcp文件保存路径
	public static final String ICP_BCPFILE_SAVE_PATH = "icp.bcpFile.save.path";
	//ICP对应bcp备份文件保存路径
	public static final String ICP_BCPFILE_BAK_SAVE_PATH = "icp.bcpFile.bak.save.path";
	//ICP对应zip压缩文件保存路径
	public static final String ICP_ZIPFILE_SAVE_PATH = "icp.zipFile.save.path";
	//ICP上传主机地址
	public static final String ICP_FILE_UPLOAD_HOST = "icp.file.upload.host";
	//ICP上传主机端口
	public static final String ICP_FILE_UPLOAD_PORT = "icp.file.upload.port";
	//ICP上传账号
	public static final String ICP_FILE_UPLOAD_USERNAME = "icp.file.upload.username";
	//ICP上传密码
	public static final String ICP_FILE_UPLOAD_PASSWORD = "icp.file.upload.password";
	//ICP上传目录
	public static final String ICP_FILE_UPLOAD_REMOTEDIR = "icp.file.upload.remotedir";
	
	//REDIS服务器IP
	public static final String REDIS_HOST = "redis.host.";
	//REDIS服务器端口
	public static final String REDIS_PORT = "redis.port.";
	//REDIS服务器密码
	public static final String REDIS_PASS = "redis.pass.";

	//分词接口url
	public static final String API_SEGMENT_URL = "api.segment.url";
	
	//OPENCC简繁体转换接口URL
	public static final String API_OPENCC_URL = "api.opencc.url";
	//OPENCC简繁体转换认证KEY
	public static final String API_OPENCC_AUTH_KEY = "api.opencc.auth.key";
	//OPENCC简繁体转换认证PASS
	public static final String API_OPENCC_AUTH_PASS = "api.opencc.auth.pass";
	
	//职位与职级词库初始化文件
	public static final String INIT_POS_NAME_RANK_FILE = "init.posName.posRank.file";
	
	//推送系统推荐简历消息到企业微信端接口
	public static final String API_WEIXINHR_MSG_RESUME_RECOMMEND_URL = "api.weixinhr.msg.resume.recommend.url";

}
