package com.job5156.beans.mail;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.google.common.collect.Maps;

/**
 * 邮件服务器配置加载类
 * 
 * @author leo
 * 
 */
public class EmailServerLoader {
	private static final Logger logger = Logger.getLogger(EmailServerLoader.class);

	private static final String MAIL_SERVER_LIST = "mail.server.list";
	private static final String MAIL_SERVER_SPLIT = ",";
	private static final String MAIL_SERVER_PREFIX = "mail.server.";

	private static Map<String, EmailServerConfig> serverConfigMap = Maps.newHashMap();

	static {
		try {
			InputStream in = ClassLoader.getSystemResourceAsStream("mail.properties");
			Properties property = new Properties();
			property.load(in);

			String mailServer = property.getProperty(MAIL_SERVER_LIST);
			String[] mailServerArr = StringUtils.split(mailServer, MAIL_SERVER_SPLIT);
			if (ArrayUtils.isNotEmpty(mailServerArr)) {
				for (String server : mailServerArr) {
					String mailHost = property.getProperty(MAIL_SERVER_PREFIX + server + ".host");
					String hostName = property.getProperty(MAIL_SERVER_PREFIX + server + ".hostName");
					String authKey = property.getProperty(MAIL_SERVER_PREFIX + server + ".authKey");
					String authVal = property.getProperty(MAIL_SERVER_PREFIX + server + ".authVal");
					String isAuth = property.getProperty(MAIL_SERVER_PREFIX + server + ".isAuth", "true");
					String port = property.getProperty(MAIL_SERVER_PREFIX + server + ".port");

					if(StringUtils.isNotBlank(mailHost)){
						EmailServerConfig config = new EmailServerConfig();
						config.setMailHost(mailHost);
						config.setHostName(hostName);
						config.setAuthKey(authKey);
						config.setAuthVal(authVal);
						config.setAuth(Boolean.parseBoolean(isAuth));
						config.setPort(port);

						serverConfigMap.put(server, config);
						config = null;
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("邮件服务器配置加载异常====", e);
		}
	}
	
	public static EmailServerConfig getServerConfigByName(String serverName){
		return serverConfigMap.get(serverName);
	}
}
