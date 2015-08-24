package com.job5156.run.test;


import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.http.protocol.HTTP;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.json.JSONObject;

import java.io.IOException;

/**
 * 这个类用来测试微信接口
 * 用于测试茜雅提供的获取accessToken接口的方法（该accesToken是否能获取二维码ticket）
 */
public class RunTestWeiXin {
    public static final String WEIXIN_APP_SECRET = "b3fec6d82b5a14bab4de0a8a71e85e3c";
    public static final String WEIXIN_API_GETACESSTOKEN = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential"; //获取accesstoken的grant_type是固定的这个参数
    public static final String WEIXIN_API_GETACESSTOKEN_EMBS = "http://192.168.2.240/embs/weuser/session/getAccessToken"; //从微信服务号外包方提供的接口获取accesstoken
    public static final String WEIXIN_API_SEND_TEXT_MSG_EMBS = "http://192.168.2.240/embs/weuser/session/pushWechatMessage"; //从微信服务号外包方提供接口发送message
    public static final String WEIXIN_API_GETQRCODE_TICKET_PREFIX = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token="; //其他参数以post方式提交
    public static final String WEIXIN_API_GETQRCODE_PREFIX = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket="; //获取加入后面的ticket参数
    public static final String WEIXIN_API_SEND_TEXT_MESSAGE_PREFIX = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token="; //其他参数以post方式提交
    public static final long WEIXIN_QRCODE_EXPIRE_TIME = (10 + 1) * 60;//过期时间为十分钟 ,加1分钟是否知网络传输等消耗的时间导致页面显示未过期的二维码无效
    private static Logger logger = Logger.getLogger(RunTestWeiXin.class);

    //
    public static HttpClient getHttpClient() {
        HttpClient httpClient = new HttpClient();
        httpClient.getParams().setParameter("http.protocol.content-charset", HTTP.UTF_8);
        httpClient.getParams().setParameter(HTTP.CONTENT_ENCODING, HTTP.UTF_8);
        httpClient.getParams().setParameter(HTTP.CHARSET_PARAM, HTTP.UTF_8);
        httpClient.getParams().setParameter(HTTP.DEFAULT_PROTOCOL_CHARSET, HTTP.UTF_8);
        return httpClient;
    }


    /**
     * 用于获取微信的accesstoken
     * 由于重新获取会导致上一次获取的失效
     * 所以应该使用同一的方法获取（微信服务号外包方的接口）
     * 只是测试用
     *
     * @return
     */
    public String getAccessTokenFromEMBS() {
        //------------------------------------------获取accesstoken
        HttpClient httpClient = getHttpClient();
        GetMethod getMethod = null;
        String accessToken = "";
        try {
            getMethod = new GetMethod(WEIXIN_API_GETACESSTOKEN_EMBS
            );
            int statusCode = httpClient.executeMethod(getMethod);
            if (statusCode != HttpStatus.SC_OK) {
                return "";
            }
            byte[] res = getMethod.getResponseBody();
            String resStr = new String(res);
            if (StringUtils.isBlank(resStr)) {
                return "";
            }
            JSONObject json = new JSONObject(resStr);
            if (json.getInt("ret") == 0) {
                logger.error("获取accessToken失败。");
                return "";
            }
            if (!json.has("accessToken") || StringUtils.isBlank(json.getString("accessToken"))) {
                return "";
            }
            accessToken = json.getString("accessToken");
            return accessToken;
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        } finally {
            if (getMethod != null) {
                getMethod.releaseConnection();
            }
        }
        return "";
    }

    /**
     * 获取绑定用的带参数二维码
     *
     * @param senceid     关于secceid的范围划分： （后续的调用可以再此处加上注释，防止重复了）
     *                    微信规定的范围：无符号32位整形(1~Integer.MAX_VALUE)
     *                    1.用于绑定网站当前登录用户的id与微信账号 100000000 ~ 199999999
     * @param accessToken
     * @return
     */
    public String getRQCodeTicketForConnect(String senceid, String accessToken, int retryTimeToken, int retryTimeUrl) {
        HttpClient httpClient = getHttpClient();
        String ticket = null;
        PostMethod postMethod = null;
        try {
            postMethod = new PostMethod(WEIXIN_API_GETQRCODE_TICKET_PREFIX
                    + accessToken);
            StringRequestEntity requestEntity = new StringRequestEntity(
                    "{\"expire_seconds\": " + WEIXIN_QRCODE_EXPIRE_TIME + ", \"action_name\": \"QR_SCENE\", \"action_info\": {\"scene\": {\"scene_id\": " + senceid + "}}}",
                    "application/json",
                    "UTF-8");
            postMethod.setRequestEntity(requestEntity);
            int statusCode = 0;
            try {
                statusCode = httpClient.executeMethod(postMethod);
            } catch (Exception e) {
                logger.error("调用获取二维码的url时出现异常", e.getCause());
                Thread.sleep(((int) Math.random() * 500)+500);   //等待一段时间后再发送
                if (retryTimeUrl < 3) {
                    return getRQCodeTicketForConnect(senceid, accessToken, retryTimeToken, retryTimeUrl + 1);
                } else {
                    logger.error("重复调用获取二维码的url三次后放弃。");
                    return "";
                }
            }
            if (statusCode != HttpStatus.SC_OK) {
                return "";
            }
            byte[] res = postMethod.getResponseBody();
            String resStr = new String(res);
            if (StringUtils.isBlank(resStr)) {
                return "";
            }
            JSONObject json = new JSONObject(resStr);
            if (json.has("errcode") && (json.getInt("errcode") == 42001 || json.getInt("errcode") == 40001) && retryTimeToken < 3) {
                logger.error("senceid【" + senceid + "】，第【" + (retryTimeToken + 1) + "】次调用微信api时accessToken【" + accessToken + "】过期,重新获取并调用");
                Thread.sleep(1000);
                return getRQCodeTicketForConnect(senceid, getAccessTokenFromEMBS(), retryTimeToken + 1, retryTimeUrl);
            }
            if (!json.has("ticket") || StringUtils.isBlank(json.getString("ticket"))) {
                return "";
            }
            ticket = json.getString("ticket");
            logger.error("成功获取tikect：" + ticket);
            return ticket;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            if (postMethod != null) {
                postMethod.releaseConnection();
            }
        }
        return "";
    }

    public static void main(String args[]) {
        RunTestWeiXin runTestWeiXin = new RunTestWeiXin();
        while (true) {
            runTestWeiXin.getRQCodeTicketForConnect("123", runTestWeiXin.getAccessTokenFromEMBS(), 0, 0);
            try {
                Thread.sleep(1000 * 60 * 10);//10分钟
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }
    }

}
