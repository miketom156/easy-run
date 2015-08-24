package com.job5156.test;

import java.io.IOException;
import java.util.List;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.job5156.common.Constants;
import com.job5156.common.util.MD5Builder;
import com.job5156.vo.api.BaseResult;

/**
 * 测试分词接口调用
 * @author leo
 *
 */
public class TestAnalysisKeyword {

	private Gson gson = new Gson();
	private HttpClient httpClient = new DefaultHttpClient(); 
	
	public static void main(String[] args) throws ClientProtocolException, IOException{
		TestAnalysisKeyword test = new TestAnalysisKeyword();
		test.t2();
	}
	
	private void t2() throws ClientProtocolException, IOException {
		List<NameValuePair> paramList = Lists.newArrayList();
		paramList.add(new BasicNameValuePair("authToken", MD5Builder.md5(Constants.API_COMMON_AUTH_KEY, Constants.API_COMMON_AUTH_PASS)));
		paramList.add(new BasicNameValuePair("keyword", "JAVA软件工程师"));
		
		HttpPost httpost = new HttpPost("http://192.168.8.174/open/api/common/dic/segment.json");
		httpost.setEntity(new UrlEncodedFormEntity(paramList, Consts.UTF_8));
		HttpResponse response = httpClient.execute(httpost);
		HttpEntity resEntity = response.getEntity();
		String jsonStr = EntityUtils.toString(resEntity, "utf-8");
		BaseResult resultVo = gson.fromJson(jsonStr, BaseResult.class);
		System.out.println("success:" + resultVo.isSuccess() + ", message:" + resultVo.getMessage());
	}
	
}
