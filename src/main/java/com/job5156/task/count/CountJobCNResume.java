package com.job5156.task.count;

import com.job5156.common.CountJobCNConstants;
import com.job5156.common.util.HibernateCountUtil;
import com.job5156.model.count.CountPosResCateJobcn;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.lang.StringUtils;
import org.apache.http.protocol.HTTP;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.json.JSONObject;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: DJH
 * Date: 14-10-23
 * Time: 下午5:22
 * 用于统计卓博简历数
 */
public class CountJobCNResume {

    private HttpClient httpClient;
    private final static String userName = "jobcndemo";
    private final static String password = "jobcndemo";
    private static String loginURL = "http://hire.jobcn.com/company/login.xhtml";
    private static String loginPageURL = "http://hire.jobcn.com/login.jsp";
    private static Logger logger = Logger.getLogger(CountJobCNResume.class);
    private static String searchURL = "http://hire.jobcn.com/search/result_action.ujson";
    private static String checkCodeURL = "http://hire.jobcn.com/randomCode.xhtml";    //验证码
    private static String checkPerResURL = "http://hire.jobcn.com/online/person/check.ujson";   //代码上看，卓博的这个url访问时检测搜索结果中简历对应用户的登陆状态，但是不知道原因，查简历前若不访问该url，无法获得搜索结果
    private JdbcTemplate jdbcTemplateCount = HibernateCountUtil.getJdbcTemplate();
    private static long timeInterval = 1500l;//每次调用卓博搜索接口的时间间隔

    /**
     * 初始化httpclient
     * 请求头伪装为火狐
     *
     * @return
     */
    public HttpClient getHttpClient() {
        httpClient = new HttpClient();
        httpClient.getParams().setParameter("http.protocol.content-charset", "UTF-8");
        httpClient.getParams().setParameter(HTTP.CONTENT_ENCODING, HTTP.UTF_8);
        httpClient.getParams().setParameter(HTTP.CHARSET_PARAM, HTTP.UTF_8);
        httpClient.getParams().setParameter(HTTP.DEFAULT_PROTOCOL_CHARSET, HTTP.UTF_8);
        List<Header> headers = new ArrayList<Header>();
        headers.add(new Header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; rv:32.0) Gecko/20100101 Firefox/32.0"));
        headers.add(new Header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8"));
        headers.add(new Header("Accept-Language", "zh-cn,zh;q=0.8,en-us;q=0.5,en;q=0.3"));
        headers.add(new Header("Host", ".jobcn.com"));
        headers.add(new Header("Connection", "Keep-Alive"));
        headers.add(new Header("Cache-Control", "no-cache"));
//        headers.add(new Header("Accept-Encoding","gzip, deflate"));
        headers.add(new Header("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8"));
        headers.add(new Header("Referer", "http://hire.jobcn.com/login.jsp?s=login/p"));
        httpClient.getHostConfiguration().getParams().setParameter(
                "http.default-headers", headers);
        httpClient.getHostConfiguration().getParams().setParameter(      //据说这可以保证兼容某些只适应cookie在请求头的浏览器
                "http.protocol.single-cookie-header", true);
        return httpClient;
    }

    /**
     * 获得post方法实例
     *
     * @param url
     * @param paramsMap
     * @return
     */
    public PostMethod postRequest(String url, Map<String, String> paramsMap) {
        if (httpClient == null) {
            getHttpClient();
        }
        PostMethod postMethod = new PostMethod(url);
        postMethod.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);
        if (paramsMap != null) {
            Iterator<Map.Entry<String, String>> its = paramsMap.entrySet().iterator();
            NameValuePair[] params = new NameValuePair[paramsMap.size()];
            int i = 0;
            while (its.hasNext()) {
                Map.Entry<String, String> e = its.next();
                params[i++] = (new NameValuePair(e.getKey(), e.getValue()));
            }
            postMethod.setRequestBody(params);
        }
        return postMethod;
    }

    /**
     * 获得get方法实例
     *
     * @param url
     * @param paramsMap
     * @return
     */
    public GetMethod getRequest(String url, Map<String, String> paramsMap) {
        if (httpClient == null) {
            getHttpClient();
        }
        String params = "";
        if (paramsMap != null && paramsMap.size() > 0) {
            for (Map.Entry param : paramsMap.entrySet()) {
                params += "&" + param.getKey() + "=" + param.getValue();
            }
            params = params.substring(1);
            params = "?" + params;
        }
        GetMethod getMethod = new GetMethod(url + params);
        getMethod.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);
        return getMethod;
    }

    /**
     * 获取简历搜索结果json串
     *
     * @param params
     * @return
     */
    public String getResumeStatistics(Map<String, String> params) {
        getCheckPerRes();
        GetMethod getMethod = getRequest(searchURL, params);
        int statusCode = 0;
        try {
            getMethod.setRequestHeader(new Header("Referer", "http://hire.jobcn.com/search/result.xhtml"));
//            application/json, text/javascript, */*; q=0.01
            getMethod.setRequestHeader(new Header("Accept", "application/json, text/javascript, */*; q=0.01"));
            statusCode = httpClient.executeMethod(getMethod);
            if (statusCode >= HttpStatus.SC_OK && statusCode <= HttpStatus.SC_PARTIAL_CONTENT) {//成功状态的返回码
                return getMethod.getResponseBodyAsString();
            } else {
                throw new RuntimeException("未出理返回码：" + statusCode + "\n" + getMethod.getResponseBodyAsString());
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            getMethod.releaseConnection();
        }
        return null;
    }

    public int redirect(PostMethod postMethod, int time) {
        int statusCode = 0;
        if (time <= 5) {
            postMethod = postRequest(postMethod.getResponseHeader("location").getValue(), null);
            try {
                statusCode = httpClient.executeMethod(postMethod);
                if (statusCode >= HttpStatus.SC_MULTIPLE_CHOICES && statusCode <= HttpStatus.SC_TEMPORARY_REDIRECT) {//重定向
                    redirect(postMethod, time);
                }
                return statusCode;
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
            }
        }
        return -1;
    }

    /**
      * 获取一次搜索页后再搜索，不然结果会为空
     */
    public void getCheckPerRes() {
        GetMethod getMethod = getRequest(checkPerResURL, null);
        try {
            int statusCode = httpClient.executeMethod(getMethod);
            if (statusCode >= HttpStatus.SC_OK && statusCode <= HttpStatus.SC_PARTIAL_CONTENT) {//成功状态的返回码
            } else if (statusCode >= HttpStatus.SC_MULTIPLE_CHOICES && statusCode <= HttpStatus.SC_TEMPORARY_REDIRECT) {//重定向
                int i = 1;
                while (i <= 5 && (statusCode >= HttpStatus.SC_MULTIPLE_CHOICES && statusCode <= HttpStatus.SC_TEMPORARY_REDIRECT)) {   //最多重定向5次
                    getMethod = getRequest(getMethod.getResponseHeader("location").getValue(), null);
                    statusCode = httpClient.executeMethod(getMethod);
                    i++;
                }
            } else {
                throw new RuntimeException("未出理返回码：" + statusCode + "\n" + getMethod.getResponseBodyAsString());
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            getMethod.releaseConnection();
        }
    }

    /**
     * 获取一次登录页以获得加密密码用的随机数cookie
     */
    public void getLoginPage() {
        GetMethod getMethod = getRequest(loginPageURL, null);
        try {
            int statusCode = httpClient.executeMethod(getMethod);
            if (statusCode >= HttpStatus.SC_OK && statusCode <= HttpStatus.SC_PARTIAL_CONTENT) {//成功状态的返回码
            } else if (statusCode >= HttpStatus.SC_MULTIPLE_CHOICES && statusCode <= HttpStatus.SC_TEMPORARY_REDIRECT) {//重定向
                int i = 1;
                while (i <= 5 && (statusCode >= HttpStatus.SC_MULTIPLE_CHOICES && statusCode <= HttpStatus.SC_TEMPORARY_REDIRECT)) {   //最多重定向5次
                    getMethod = getRequest(getMethod.getResponseHeader("location").getValue(), null);
                    statusCode = httpClient.executeMethod(getMethod);
                    i++;
                }
            } else {
                throw new RuntimeException("未出理返回码：" + statusCode + "\n" + getMethod.getResponseBodyAsString());
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            getMethod.releaseConnection();
        }
    }

    /**
     * 将图片拉到本地
     * 先通过内容判断文件类型，失败后通过html的minetype判断
     *
     * @param fis
     * @return
     * @throws IOException
     */
    public static boolean getChkImage(InputStream fis, String mineType) throws IOException {
        BufferedInputStream buff = new BufferedInputStream(fis);
        String type = "";
        try {
            Iterator itr = ImageIO.getImageReaders(buff);
            if (!itr.hasNext() && StringUtils.isNotBlank(mineType)) {
                itr = ImageIO.getImageReadersByMIMEType(mineType);
            }
            if (!itr.hasNext()) {
                logger.error("不能识别图片类型");
                return false;
            }
            ImageReader reader = (ImageReader) itr.next();
            String imageName = reader.getClass().getSimpleName();
            if (imageName != null) {
                if ("GIFImageReader".equals(imageName)) {
                    type = "gif";
                } else if ("JPEGImageReader".equals(imageName)) {
                    type = "jpg";
                } else if ("PNGImageReader".equals(imageName)) {
                    type = "png";
                } else if ("BMPImageReader".equals(imageName)) {
                    type = "bmp";
                } else {
                    type = "noPic";
                    logger.error("不能识别图片类型");
                    return false;
                }
                BufferedImage image = ImageIO.read(buff);
                ImageIO.write(image, type, new File(CountJobCNResume.class.getResource("").getFile() + "chk." + type));
                return true;
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            if (buff != null) {
                try {
                    buff.close();
                } catch (IOException e) {
                    logger.error(e.getMessage(), e);
                }
            }
        }
        return false;
    }

    /**
     * 获取验证码图片，并放在当前类打包后的class文件目录下
     *
     * @return
     */
    public String getChkCode() {
        GetMethod getMethod = getRequest(checkCodeURL + "?" + (new Date().getTime()), null);
        try {
            int statusCode = httpClient.executeMethod(getMethod);
            if (statusCode >= HttpStatus.SC_OK && statusCode <= HttpStatus.SC_PARTIAL_CONTENT) {//成功状态的返回码
            } else if (statusCode >= HttpStatus.SC_MULTIPLE_CHOICES && statusCode <= HttpStatus.SC_TEMPORARY_REDIRECT) {//重定向
                int i = 1;
                while (i <= 5 && (statusCode >= HttpStatus.SC_MULTIPLE_CHOICES && statusCode <= HttpStatus.SC_TEMPORARY_REDIRECT)) {   //最多重定向5次
                    getMethod = getRequest(getMethod.getResponseHeader("location").getValue(), null);
                    statusCode = httpClient.executeMethod(getMethod);
                    i++;
                }
            } else {
                throw new RuntimeException("未出理返回码：" + statusCode + "\n" + getMethod.getResponseBodyAsString());
            }
            if (!getChkImage(getMethod.getResponseBodyAsStream(),
                    getMethod.getResponseHeader("Content-Type").getValue())) {
                logger.error("获取验证码失败");
                return "";
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            getMethod.releaseConnection();
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入验证码：");
        if (sc.hasNext()) {
            return sc.next();
        }
        return "";
    }


    /**
     * 用于登录，需要先访问卓博的登陆页获取jobcnid这一cookie，
     * 带有这一cookie去获取的验证码，并且使用该cookie再次加密密码才能通过验证
     */
    public boolean login() {
        Map<String, String> params = new HashMap();
        getLoginPage(); //访问登录页以获得cookie
        String jcnid = "";
        Cookie[] tempCookies = httpClient.getState().getCookies();
        for (int i = 0; i < tempCookies.length; i++) {
            if (tempCookies[i].getName().toString().equals("JCNID")) {
                jcnid = tempCookies[i].getValue();
            }
        }
        if (StringUtils.isBlank(jcnid)) {
            logger.error("卓博登录：获取随机码失败。");
            return false;
        }
        String chkCode = getChkCode();//验证码 （以访问登录页后获得的cookie去获取验证码，后面同样以该cookie加密密码）
        if (StringUtils.isBlank(chkCode)) {
            logger.error("卓博登录：获取验证码失败。");
            return false;
        }
        params.put("userName", userName);
        params.put("password", MD5(MD5(password) + jcnid)); //此处注意，卓博使用了webtoolkit.info网站提供的js工具在前台对密码进行了一次MD5加密
        params.put("chkCode", chkCode);
        params.put("remember", "1");
        params.put("page", "default");
        params.put("url", "");
        PostMethod postMethod = postRequest(loginURL, params);
        int statusCode = 0;
        boolean hasCookie = false;
        try {
            statusCode = httpClient.executeMethod(postMethod);
            if (statusCode >= HttpStatus.SC_OK && statusCode <= HttpStatus.SC_PARTIAL_CONTENT) {//成功状态的返回码
            } else if (statusCode >= HttpStatus.SC_MULTIPLE_CHOICES && statusCode <= HttpStatus.SC_TEMPORARY_REDIRECT) {//重定向
                int i = 1;
                while (i <= 5 && (statusCode >= HttpStatus.SC_MULTIPLE_CHOICES && statusCode <= HttpStatus.SC_TEMPORARY_REDIRECT)) {   //最多重定向5次
                    postMethod = postRequest(postMethod.getResponseHeader("location").getValue(), null);
                    statusCode = httpClient.executeMethod(postMethod);
                    i++;
                }
            } else {
                throw new RuntimeException("未出理返回码：" + statusCode + "\n" + postMethod.getResponseBodyAsString());
            }
            Cookie[] cookies = httpClient.getState().getCookies();
            if (cookies.length == 0) {
            } else {
                for (int i = 0; i < cookies.length; i++) {
                    if (cookies[i].getName().equals("comkey")) { //登录成功后会加入这一cookie
                        hasCookie = true;
                    }
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            postMethod.releaseConnection();
        }
        return hasCookie;
    }

    /**
     * jdk中自带的MD5算法
     * 得到加密后的字节码后转换成十六进制字符串
     *
     * @param s
     * @return
     */
    public final static String MD5(String s) {
        try {
            byte[] btInput = s.getBytes("UTF-8");
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < md.length; i++) {
                int val = ((int) md[i]) & 0xff;
                if (val < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(val));
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 用于更新相同条件的简历存量记录
     *
     * @param jobcn
     */
    public void updateReusmeSaveCount(CountPosResCateJobcn jobcn, String createDate) {
        String sql = "update count_pos_res_cate_jobcn set save_res_count = ? " +
                " where work_location = ? and jobcn_pos_type = ? " +
                " and req_degree = ? and create_date = ?";
        int effected = jdbcTemplateCount.update(sql, jobcn.getSaveResCount(), jobcn.getWorkLocation(),
                jobcn.getJobcnPosType(), jobcn.getReqDegree(), createDate);
        if (effected == 0) {
//                 logger.error("出现没有对应条件的简历存量查询数据，条件为工作地点【"+jobcn.getWorkLocation()+"】工作类型【"+ jobcn.getPosType()+"】卓博工作类型【"+
//                         jobcn.getJobcnPosType()+"】学历【"+jobcn.getReqDegree()+"】时间【"+DateTime.now().minusDays(2).toString("yyyy-MM-dd")+"】");
            String insertSql = "insert into count_pos_res_cate_jobcn(work_location,jobcn_pos_type,pos_name,req_degree,create_date,save_res_count,data_source) values(?,?,?,?,?,?,?)";
            jdbcTemplateCount.update(insertSql, jobcn.getWorkLocation(),
                    jobcn.getJobcnPosType(), jobcn.getPosName(), jobcn.getReqDegree(),
                    createDate, jobcn.getSaveResCount(), CountJobCNConstants.ComType.JOBCN.getValue());
        }
    }


    public static void main(String args[]) {
        logger.error("开始对卓博简历存量的统计。");
        CountJobCNResume countJobCNResume = new CountJobCNResume();
//        if (countJobCNResume.login()) {   //卓博的简历搜索接口不登录也可以访问
            String createDate = DateTime.now().toString("yyyy-MM-dd");
            try {
                String inputDate = "";
                if (args.length > 0) {
                    for (String arg : args) {
                        if (StringUtils.startsWith(arg, "--countdate=")) {
                            inputDate = arg.substring("--countdate=".length());
                        }
                    }
                }
                if (StringUtils.isNotBlank(inputDate)) {
                    DateTime temp = DateTimeFormat.forPattern("yyyy-MM-dd").parseDateTime(inputDate);
                    createDate = inputDate;
                }
            } catch (Exception e) {
                logger.error("输入日期格式有误。");
                return;
            }
            int total = CountJobCNConstants.getJobTypeMap().size() * CountJobCNConstants.getDegreeTypeMap().size();
            int curent = 0;
            for (Map.Entry<String, String> jobType : CountJobCNConstants.getJobTypeMap().entrySet()) {
                for (Map.Entry<String, String> degree : CountJobCNConstants.getDegreeTypeMap().entrySet()) {
                    Map<String, String> params = new HashMap();
                    String[] jobTypeCode = jobType.getValue().split(",");//获取城市编码
                    String[] degreeCode = degree.getValue().split(",");//获取城市编码
                    params.put("workplace", "3002");       //卓博的东莞地区编码
                    params.put("jobfunction", jobType.getKey());
                    params.put("abovedegree", degreeCode[0]);
                    params.put("degree", degreeCode[0]);
                    params.put("registerdate", "30");//查询一个月内的简历
                    //加入下面两个参数返回的json结果才会经过以上条件筛选，原因未知
                    params.put("pagename", "searcherfast");
                    params.put("submitFromResultPage", "true");
                    params.put("_t",Math.random()+"");
                    String json = countJobCNResume.getResumeStatistics(params);
                    if (json != null) {
                        JSONObject jsonObject = new JSONObject(json);
                        if(!jsonObject.has("parasMap")){
                             logger.error("返回结果参数不符，返回结果为【"+json+"】");
                            return;
                        }
                        int totalRow = jsonObject.getJSONObject("parasMap").getInt("rsCount");
                        curent++;
                        CountPosResCateJobcn jobcn = new CountPosResCateJobcn();
                        jobcn.setWorkLocation(14010000);
                        jobcn.setPosType(jobTypeCode != null && jobTypeCode.length > 1 ? Integer.parseInt(jobTypeCode[1]) : 0);
                        jobcn.setReqDegree(Integer.parseInt(degreeCode[0]));
                        jobcn.setJobcnPosType(Integer.parseInt(jobType.getKey()));
                        jobcn.setPosName(jobTypeCode[0]);
                        jobcn.setSaveResCount(totalRow);
                        countJobCNResume.updateReusmeSaveCount(jobcn, createDate);
                        //此处改成error是因为服务器中没有打印info数据
                        logger.error("卓博简历存量统计(" + curent + "/" + total + ")：条件为工作地点【" + jobcn.getWorkLocation() + "】工作类型【" + jobcn.getPosType() + "】卓博工作类型【" +
                                jobcn.getJobcnPosType() + "】学历【" + jobcn.getReqDegree() + "】时间【" + DateTime.now().toString("yyyy-MM-dd") + "】");
                    } else {
                        logger.error("卓博简历存量统计:出现返回json串为空的搜索结果!");
                    }
                    try {
                        Thread.sleep(timeInterval);
                    } catch (InterruptedException e) {
                        logger.error(e.getMessage(), e);
                    }
                }
            }
//        } else {
//            logger.error("登录失败！");
//        }
        logger.error("结束对卓博简历存量的统计。");
    }

}
