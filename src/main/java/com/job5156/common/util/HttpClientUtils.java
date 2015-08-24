package com.job5156.common.util;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

public class HttpClientUtils {
	Logger logger = Logger.getLogger(HttpClientUtils.class);
	
	private static HttpClientUtils httpClientUtils;
	
	private HttpClient httpClient = null;
	
	public static HttpClientUtils getInstance() {
		if(httpClientUtils == null) {
			httpClientUtils = new HttpClientUtils();
		}
		
		return httpClientUtils;
	}
	
	private HttpClientUtils() {
		httpClient = new HttpClient();
	}
	
	/*public static void main(String[] args) {
		HttpClientUtils httpClientComponent = new HttpClientUtils();
		httpClientComponent.getCountryAndAreaByWeb("61.145.161.135");
	}
	
	public String getCountryAndAreaByWeb(String ip) {
		String url = "http://opendata.baidu.com/api.php";
		
		//定义请求参数
		Map<String, String> pars = Maps.newHashMap();
		pars.put("query", ip);
		pars.put("co", "");
		pars.put("resource_id", "6006");
		pars.put("t", "1411024869373");
		pars.put("ie", "utf8");
		pars.put("oe", "gbk");
		pars.put("format", "json");
		pars.put("tn", "baidu");
		pars.put("cb", "aa");
		
		String content = getResponseContent(url, pars);
		
		if(StringUtils.isNotBlank(content)) {
			String jsonStr = content.substring(content.indexOf("[") + 1, content.lastIndexOf("]"));
			Gson gson = new Gson();
			Map<String, String> dataMap = gson.<Map<String, String>>fromJson(jsonStr, new TypeToken<Map<String, Object>>() {}.getType());
			return dataMap.get("location");
		}
		
		return "";
	}*/
	
	public String getResponseContent(String url, Map<String, String> nameValuePairMap) {
		PostMethod postMethod = createHttpMethod(url);
		//将表单的值放入postMethod中
		postMethod.setRequestBody(mapToNameValuePairs(nameValuePairMap));
		return executeMethod(postMethod);
	}
	
	/**
	 * 
	* @Title: executeMethod 
	* @Description: 执行指定的http方法
	* @param @param method
	* @param @return    设定文件 
	* @return String    返回请求结果
	* @throws
	 */
	public String executeMethod(HttpMethod method) {
		String content = "";
		
		//使用系统提供的默认的恢复策略,在发生异常时候将自动重试3次
		method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler(3, false));
		  
		try {
			// 执行postMethod
			int statusCode = httpClient.executeMethod(method);
			if (statusCode == HttpStatus.SC_OK) {//请求正常返回结果
				content = method.getResponseBodyAsString();
			} else if (statusCode == HttpStatus.SC_MOVED_TEMPORARILY || statusCode == HttpStatus.SC_MOVED_PERMANENTLY || 
					statusCode == HttpStatus.SC_SEE_OTHER || statusCode == HttpStatus.SC_TEMPORARY_REDIRECT) {//请求被重定向
				//读取新的URL地址
	            Header header = method.getResponseHeader("location");
	            if (header != null) {
	            	String newuri = header.getValue();
	            	if (StringUtils.isNotBlank(newuri)) {
	            		PostMethod redirect = createHttpMethod(newuri);
		                httpClient.executeMethod(redirect);
		                content = redirect.getResponseBodyAsString();
	            	}
	            }
			}
		} catch (HttpException e) {
			// 发生致命的异常，可能是协议不对或者返回的内容有问题
			logger.error(e.toString());
		} catch (IOException e) {
			// 发生网络异常
			logger.error(e.toString());
		} catch (IllegalArgumentException e) {
			//host parameter is null
			logger.error(e.toString());
		}
		finally {
			// 释放连接
			method.releaseConnection();
		}
		
		return content;
	}
	
	/**
	 * 
	* @Title: mapToNameValuePairs 
	* @Description: 将map转换成http表单域值
	* @param @param nameValuePairMap
	* @param @return    设定文件 
	* @return NameValuePair[]    返回类型 
	* @throws
	 */
	private NameValuePair[] mapToNameValuePairs(Map<String, String> nameValuePairMap) {
		NameValuePair[] nameValuePairs = new NameValuePair[nameValuePairMap.keySet().size()];
		
		int i = 0;
		Iterator<String> keys = nameValuePairMap.keySet().iterator();
		while(keys.hasNext()) {
			String key = keys.next();
			nameValuePairs[i] = new NameValuePair(key, nameValuePairMap.get(key));
			i++;
		}
		
		return nameValuePairs;
	}
	
	/**
	 * 
	* @Title: createHttpMethod 
	* @Description: 通过url创建http方法
	* @param @param url
	* @param @return    设定文件 
	* @return HttpMethod    返回类型 
	* @throws
	 */
	public PostMethod createHttpMethod(String url) {
		PostMethod postMethod = new PostMethod(url);
		// 浏览器伪造
		postMethod.addRequestHeader("User-Agent", "Mozilla/5.0 (Windows NT 5.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/35.0.1916.114 Safari/537.36");
		postMethod.addRequestHeader("Protocol", "HTTP/1.1");
		postMethod.addRequestHeader("Scheme", "http");
		postMethod.addRequestHeader("Connection", "keep-alive");
		
		return postMethod; 
	}
}
