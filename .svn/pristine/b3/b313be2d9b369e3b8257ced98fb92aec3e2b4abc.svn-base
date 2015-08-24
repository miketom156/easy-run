package com.job5156.beans;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.google.common.collect.Maps;

/**
 * 项目配置文件加载器
 * @author leo
 *
 */
public class ServerConfigLoader {
	private static final Logger logger = Logger.getLogger(ServerConfigLoader.class);
	
	private static Map<String, String> configMap = Maps.newHashMap();

	static {
		try {
			InputStream in = ClassLoader.getSystemResourceAsStream("config.properties");
			Properties property = new Properties();
			property.load(in);

			Set<String> propertyNameSet = property.stringPropertyNames();
			Iterator<String> iterator = propertyNameSet.iterator();
			while(iterator.hasNext()){
				String propertyName = iterator.next();
				String propertyValue = property.getProperty(propertyName);
				
				if(StringUtils.isNotBlank(propertyValue)){
					configMap.put(propertyName, propertyValue);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("项目配置文件加载失败====", e);
		}
	}
	
	public static String getConfigByName(String propertyName){
		return configMap.get(propertyName);
	}
}
