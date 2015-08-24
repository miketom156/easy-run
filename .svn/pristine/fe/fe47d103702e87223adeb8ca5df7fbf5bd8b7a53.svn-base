package com.job5156.vo.file;

import java.lang.reflect.Field;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;

public abstract class IcpBaseVo {
	
	/**
	 * 组装每个字段内容
	 */
	public String getContent(){
		StringBuffer buf = new StringBuffer();
		try{
			Field[] fieldArr = this.getClass().getDeclaredFields();
	        for(Field field : fieldArr) {
	        	String fieldValue = ObjectUtils.toString(PropertyUtils.getSimpleProperty(this, field.getName()), "");
	        	fieldValue = this.replaceSpecialChar(fieldValue);
	        	buf.append(fieldValue + "\t");
	        }
	        return StringUtils.substringBeforeLast(buf.toString(), "\t");
		}catch(Exception e){
			e.printStackTrace();
			return "";
		}
	}
	
	/**
	 * 替换字段中出现的特殊字符
	 * @param fieldValue
	 * @return
	 */
	public String replaceSpecialChar(String fieldValue){
		return StringUtils.replace(fieldValue, "\t", "").replace("\r", "").replace("\n", "");
	}
}
