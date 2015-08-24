package com.job5156.beans.freemarker;

import java.io.File;
import java.util.Date;

import org.apache.log4j.Logger;

import com.job5156.common.Constants;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;

/**
 * Freemarker模板配置
 * @author leo
 *
 */
public class FreemarkerConfigure {
	private static final Logger logger = Logger.getLogger(FreemarkerConfigure.class);

	private static Configuration configure = new Configuration();
	
	static {
		try{
			// 指定加载模板的数据源
			configure.setDirectoryForTemplateLoading(new File(ClassLoader.getSystemResource("template").getFile()));
			// 指定模版如何查看数据模型
			configure.setObjectWrapper(new DefaultObjectWrapper());
			// 设置编码
			configure.setDefaultEncoding("UTF-8");
			// 设置全局共享变量
			configure.setSharedVariable(Constants.VISIT_DOMAIN, "http://www.job5156.com");
			configure.setSharedVariable(Constants.IMAGE_DOMAIN,	"http://www.job5156.com");
			configure.setSharedVariable(Constants.SEARCH_DOMAIN, "http://s.job5156.com");
			configure.setSharedVariable(Constants.PERSON_DOMAIN, "http://my.job5156.com");
			configure.setSharedVariable(Constants.COMPANY_DOMAIN, "http://hr.job5156.com");
            configure.setSharedVariable("now", new Date());
		}catch(Exception e){
			e.printStackTrace();
			logger.error("Freemarker模板初始化异常：" + e.getMessage(), e);
		}
	}
	
	public static Configuration getFreemarkerConfig(){
		return configure;
	}
}
