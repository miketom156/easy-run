package com.job5156.common.util;

import java.io.UnsupportedEncodingException;

import org.apache.commons.lang.ArrayUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.job5156.common.exception.SerializeException;

/**
 * 序列化工具类
 * @author leo
 *
 */
public class SerializeUtil {

	private static final String CHARSET = "UTF-8";
	private static final Gson gson = new GsonBuilder().serializeNulls().create();
	
	/**
	 * 序列化字符串
	 * @param data
	 * @return
	 * @throws SerializeException 
	 * @throws UnsupportedEncodingException
	 */
	public static byte[] serializeStr(String data) throws SerializeException {
		try {
			return data == null ? ArrayUtils.EMPTY_BYTE_ARRAY : data.getBytes(CHARSET);
		} catch (UnsupportedEncodingException e) {
			throw new SerializeException("Could not serialize string", e);
		}
	}
	
	/**
	 * 反序列化字符串
	 * @param bytes
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String deserializeStr(byte[] bytes) throws SerializeException {
		try {
			return ArrayUtils.isEmpty(bytes) ? null : new String(bytes, CHARSET);
		} catch (UnsupportedEncodingException e) {
			throw new SerializeException("Could not deserialize string", e);
		}
	}
	
	/**
	 * 序列化对象
	 * @param object
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static byte[] serializeObj(Object object) throws SerializeException{
		try {
			return object == null ? ArrayUtils.EMPTY_BYTE_ARRAY : gson.toJson(object).getBytes(CHARSET);
		} catch (UnsupportedEncodingException e) {
			throw new SerializeException("Could not serialize object", e);
		}
	}
	
	/**
	 * 反序列化对象
	 * @param bytes
	 * @param t
	 * @return
	 * @throws JsonSyntaxException
	 * @throws UnsupportedEncodingException
	 */
	public static <T> T deserializeObj(byte[] bytes, Class<T> t) throws SerializeException {
		try {
			return ArrayUtils.isEmpty(bytes) ? null : gson.fromJson(new String(bytes, CHARSET), t);
		} catch (JsonSyntaxException | UnsupportedEncodingException e) {
			throw new SerializeException("Could not deserialize object", e);
		}
	}
}
