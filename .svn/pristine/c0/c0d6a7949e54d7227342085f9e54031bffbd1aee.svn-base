package com.job5156.task.count;

import java.io.IOException;
import java.io.StringWriter;
import java.net.SocketTimeoutException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.joda.time.DateTime;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.job5156.beans.freemarker.FreemarkerConfigure;
import com.job5156.beans.mail.BaseMailSend;
import com.job5156.beans.mail.EmailSender;
import com.job5156.common.CommonEnum.BuyFlag;
import com.job5156.common.CommonEnum.MailServer;
import com.job5156.common.Constants;
import com.job5156.common.exception.EmailServerConfigException;
import com.job5156.common.util.HibernateCountUtil;
import com.job5156.common.util.HibernateQuery2Util;
import com.job5156.common.util.HibernateSalveBaseUtil;
import com.job5156.common.util.KeyMaskUtil;
import com.job5156.model.com.ComInfo;
import com.job5156.model.com.ComPosition;
import com.job5156.model.com.ComRight;
import com.job5156.model.count.CountSiteIndexCheck;
import com.job5156.model.init.PosExportBrief;
import com.job5156.model.sys.SysWebSite;
import com.job5156.model.sys.logo.SysLogoFile;
import com.job5156.model.sys.logo.SysLogoPosition;
import com.job5156.model.sys.logo.SysLogoQueue;
import com.job5156.model.sys.logo.SysLogoResource;
import com.job5156.model.sys.logo.SysLogoTable;
import com.job5156.model.sys.setting.SysHotHunterPosition;
import com.job5156.model.sys.subsite.SysComPosSchool;
import com.job5156.model.sys.subsite.SysHomePosition;
import com.job5156.vo.mail.CountSiteAdminCheckAppVo;
import com.job5156.vo.mail.CountSiteIndexCheckAppVo;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * 针对站点首页中所有URL链接失效的过滤
 * 
 * @author Andy
 *
 */
public class CountSiteIndexCheckApp extends BaseMailSend {

    private static final Logger log = Logger.getLogger(CountSiteIndexCheckApp.class);

    private EmailSender sender;

    private static CloseableHttpClient httpClient = HttpClients.createDefault();
    
    private static List<Integer> siteIndexNetworkPosIds = null;//站点首页网络职位ID集合
    private static List<Integer> siteIndexRecruitment = null;//站点首页招聘会职位ID集合
    private static List<CountSiteIndexCheck> modelList = null;//站点首页存放职位集合
    
    //职位过期描述信息
    private static String posMesg = "企业名称：#comName#；职位名称：#posName#；职位ID：#posId#；过期日期：#expireDate#";
    //企业过期描述信息
    private static String comMesg = "企业名称：#comName#；企业ID：#comId#；过期日期：#expireDate#";
    
    //广告Logo过期描述信息
    private static String logoMesg = "广告位编号：#logoNo#；企业名称：#logoName#；Queue_ID：#logoId#；过期日期：#expireDate#";
    private static String advertisingMesg = "id：#id#；企业名称：#logoName#；过期日期：#expireDate#";
    private static String logoPosMesg = "广告位编号：#logoNo#；企业名称：#comName#；职位名称：#posName#；职位ID：#posId#；过期日期：#expireDate#";
    private static String logoComMesg = "广告位编号：#logoNo#；企业名称：#comName#；企业ID：#comId#；过期日期：#expireDate#";

    // 站点地址集合
    private static final String[][] SITEURL = {
        {"33","http://www.job5156.com"},{"362","http://nb.job5156.com"},
        {"290","http://nc.job5156.com"},{"272","http://cs.job5156.com"},
        {"218","http://cz.job5156.com"},{"296","http://wh.job5156.com"},
        {"612","http://jz.job5156.com"},//{"289","http://hf.job5156.com"},
        {"622","http://nj.job5156.com"},{"632","http://hy.job5156.com"},
        {"645","http://xt.job5156.com"},{"779","http://xn.job5156.com"},
        {"9","http://dg.job5156.com"},{"181","http://jm.job5156.com"},
        {"90","http://fs.job5156.com"},{"91","http://zs.job5156.com"},
        {"10","http://gz.job5156.com"},{"8","http://sz.job5156.com"},
        {"92","http://hz.job5156.com"},{"89","http://zh.job5156.com"},
        {"725","http://qy.job5156.com"},{"726","http://sd.job5156.com"},
        {"778","http://zq.job5156.com"},{"285","http://cq.job5156.com"}
      //  {"271","http://www.sjztjob.com"}
    };

    /*
     * 收件人的邮件配置，规则：第一维：收件人邮箱地址；第二维：站点Id
     * 如果没有配置接哪个站点的话，默认是全部接收
     */
    private static final String[][] SITEEMAIL = {
        {"dg3449@zhitong.com","362"},
        {"HY058@zhitong.com,HY075@zhitong.com","632"},
        {"Cz076@zhitong.com","218"},
        {"Wh201@zhitong.com","296"},
        {"ncxlx@zhitong.com","290"},
        {"Jz010@zhitong.com","612"},
        {"nj050@zhitong.com","622"},
        {"xt034@zhitong.com","645"},
        {"xn003@zhitong.com","779"},
        {"YHL@zhitong.com","33,9,92"},
        {"ca301@zhitong.com","8"},
        {"Jm281@zhitong.com","181"},
        {"Cs176@zhitong.com","272"},
        {"Makzs135@zhitong.com,Zs319@zhitong.com","89,91"},
        {"fs305@zhitong.com","285,726,90,10,725,778"},
        //{"XA092@zhitong.com","271"},
        {"JJZ@zhitong.com,YNXJ@zhitong.com,dg3996@zhitong.com,dg4231@zhitong.com,dg4290@zhitong.com",""}
    };
    
    /*
     * 网站后台各站点收件人的邮件配置，规则：第一维：收件人邮箱地址；第二维：站点Id
     * 如果没有配置接哪个站点的话，默认是全部接收
     */
    private static final String[][] SITEADMINEMAIL = {
        {"JJZ@zhitong.com,YNXJ@zhitong.com,dg3996@zhitong.com,dg4231@zhitong.com,dg4290@zhitong.com",""}
    };

    /**                 
     * 华南地区站点+宁波与南昌后台需要查检的模块
     */
    private static final String[][] SITENEWADMINSET = {
        {"33","http://www.job5156.com/,高薪职位,知名品牌,急聘职位"},{"9"," http://dg.job5156.com/,高薪职位,知名品牌,热聘职位"},
        {"181","http://jm.job5156.com/,高薪职位,知名品牌,热聘职位"},{"90","http://fs.job5156.com/,高薪职位,知名品牌,热聘职位"},
        {"91"," http://zs.job5156.com/,高薪职位,知名品牌,热聘职位"},{"10","http://gz.job5156.com/,高薪职位,知名品牌,热聘职位"},
        {"8","http://sz.job5156.com/,高薪职位,知名品牌,热聘职位"},{"92"," http://hz.job5156.com/,高薪职位,知名品牌,热聘职位"},
        {"89","http://zh.job5156.com/,高薪职位,知名品牌,热聘职位"},{"725","http://qy.job5156.com/,高薪职位,知名品牌,热聘职位"},
        {"726"," http://sd.job5156.com/,高薪职位,知名品牌,热聘职位"},{"778","http://zq.job5156.com/,高薪职位,知名品牌,热聘职位"},
        {"362","http://nb.job5156.com/,高薪职位,知名品牌,紧急招聘"}, {"290","http://nc.job5156.com/,高薪职位,知名品牌,紧急招聘"},
        {"622","http://nj.job5156.com/,高薪职位,知名品牌,热聘职位"}
    };
    
    /**
     * 其它地区站点后台需要查检的模块
     */
    private static final String[][] SITEOLDADMINSET = {
    	{"272"," http://cs.job5156.com/,首页Logo,最新招聘信息"},{"218","http://cz.job5156.com/,首页Logo,最新招聘信息"},
    	{"296","http://wh.job5156.com/,首页Logo,最新招聘信息,校园招聘"},{"612","http://jz.job5156.com/,首页Logo,最新招聘信息"},
    	{"289","http://hf.job5156.com/,首页Logo,最新招聘信息"},
    	{"632"," http://hy.job5156.com/,首页Logo,最新招聘信息"},{"645","http://xt.job5156.com/,首页Logo,最新招聘信息"},
    	{"779","http://xn.job5156.com/,首页Logo,最新招聘信息"},//{"271"," http://www.sjztjob.com/,首页Logo,最新招聘信息,校园招聘"},
    	{"285","http://cq.job5156.com/,首页Logo,最新招聘信息"}
    };

    public CountSiteIndexCheckApp() throws EmailServerConfigException {
        sender = new EmailSender(MailServer.EXCHANGE);
    }

    public CountSiteIndexCheckApp(MailServer mailServer) throws EmailServerConfigException {
        sender = new EmailSender(mailServer);
    }
    
    @Override
    public void send() {

    }
    
   /* public static void main(String[] args){
    	try {
			CountSiteIndexCheckApp csica = new CountSiteIndexCheckApp();
			//csica.siteIndexURLFailCheck();
			csica.siteIndexAdminExpiredCheck();
		} catch (EmailServerConfigException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
    }*/
    
    /**
     * 后台首页log、职位和企业过期检查
     * @throws ParseException 
     */
    public void siteIndexAdminExpiredCheck() throws ParseException{
    	long startTime = System.currentTimeMillis();
    	log.error("==>后台logo、职位与企业过期程序检查开始："+ DateTime.now().toString("yyyy-MM-dd HH:mm:ss"));
    	//华南地区站点+宁波与南昌后台查检数据
    	for(int i = 0 ; i < SITENEWADMINSET.length ; i++){
    		if(SITENEWADMINSET[i][1].split(",").length > 1){
    			//高薪职位
    			highSalaryList(NumberUtils.toInt(SITENEWADMINSET[i][0]),SITENEWADMINSET[i][1].split(",")[0],SITENEWADMINSET[i][1].split(",")[1]);
    			//知名品牌
				famousBrand(NumberUtils.toInt(SITENEWADMINSET[i][0]),SITENEWADMINSET[i][1].split(",")[0],SITENEWADMINSET[i][1].split(",")[2]);
				if(NumberUtils.toInt(SITENEWADMINSET[i][0]) != 33){
					//首页的急聘职位已经改到广告LOGO中
					//hotRecruit(NumberUtils.toInt(SITENEWADMINSET[i][0]),SITENEWADMINSET[i][1].split(",")[0],SITENEWADMINSET[i][1].split(",")[3]);
					//热聘职位
					hotRecruitPosition(NumberUtils.toInt(SITENEWADMINSET[i][0]),SITENEWADMINSET[i][1].split(",")[0],SITENEWADMINSET[i][1].split(",")[3]);
				}
    		}
    	}
    	
    	//其它地区站点后台需要查检的模块
    	for(int i = 0 ; i < SITEOLDADMINSET.length; i++){
    		//首页Logo
			famousBrand(NumberUtils.toInt(SITEOLDADMINSET[i][0]),SITEOLDADMINSET[i][1].split(",")[0],SITEOLDADMINSET[i][1].split(",")[1]);
			//最新招聘信息
    		hotRecruitPosition(NumberUtils.toInt(SITEOLDADMINSET[i][0]),SITEOLDADMINSET[i][1].split(",")[0],SITEOLDADMINSET[i][1].split(",")[2]);
    		if(NumberUtils.toInt(SITEOLDADMINSET[i][0]) == 296 || NumberUtils.toInt(SITEOLDADMINSET[i][0]) == 271){
				// 校园招聘
				getSchoolComByWebsite(NumberUtils.toInt(SITEOLDADMINSET[i][0]),SITEOLDADMINSET[i][1].split(",")[0],SITEOLDADMINSET[i][1].split(",")[3]);
    		}
    			
    	}
    	
    	//发送邮件
    	sendFrontMail(false,SITEEMAIL);
    	long endTime = System.currentTimeMillis();
        long date = (endTime - startTime) / 1000;
        log.error("=====>后台logo、职位与企业过期程序检查执行完毕："+ DateTime.now().toString("yyyy-MM-dd HH:mm:ss") + "\n 总共花费："+ date + "\t s");
    }
    
    /**
     * 前台首页URL链接失效检查
     */
    public void siteIndexURLFailCheck(){
        log.error("==>开始启动站点首页检测URL是否失效爬虫程序："+ DateTime.now().toString("yyyy-MM-dd HH:mm:ss"));
        long startTime = System.currentTimeMillis();
        Session countSession = HibernateCountUtil.currentSession();
        for (int i = 0 ; i < SITEURL.length; i++){
        	siteIndexNetworkPosIds = Lists.newArrayList();
        	modelList = Lists.newArrayList();
        	HttpGet httpGetSite = new HttpGet(SITEURL[i][1]);
        	getHttpParame(httpGetSite);
        	RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(30000).setConnectTimeout(2000).build();//设置请求和传输超时时间
        	httpGetSite.setConfig(requestConfig);
            executeMethod(httpGetSite, NumberUtils.toInt(SITEURL[i][0],0), SITEURL[i][1]);
            
            //企业名称
            Map<Integer,String> comNameMap = Maps.newHashMap();
            
            //网络职位
            if(CollectionUtils.isNotEmpty(siteIndexNetworkPosIds)){
            	getComInfoName(comNameMap);
            }
            
            //招聘会职位
            if(CollectionUtils.isNotEmpty(siteIndexRecruitment)){
            	getComInfoName(comNameMap);
            }
            
            if(MapUtils.isNotEmpty(comNameMap) && CollectionUtils.isNotEmpty(modelList)){
            	for(CountSiteIndexCheck model : modelList){
            		int[] posAndType = KeyMaskUtil.posNoToIdAndType(Integer.valueOf(StringUtils.substringBetween(model.getUrlOrType(), "/jobs/", ".shtml")));
            		StringBuilder infoName = new StringBuilder(model.getInfoName()+"(");
            		if(StringUtils.isNotBlank(comNameMap.get(posAndType[0]))){
            			infoName.append(comNameMap.get(posAndType[0]) );
            		}
            		infoName.append("）");
            		model.setInfoName(infoName.toString());
            		countSession.save(model);
            		countSession.flush();
            		countSession.clear();
            	}
            }
	    }
	    try {
	    	httpClient.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	        
	    //发送邮件
	    sendFrontMail(true,SITEEMAIL);
	    long endTime = System.currentTimeMillis();
	    long date = (endTime - startTime) / 1000;
	    log.error("=====>站点首页检测URL是否失效爬虫程序执行完毕："+ DateTime.now().toString("yyyy-MM-dd HH:mm:ss") + "\n 总共花费："+ date + "\t s");
    }
    
    /**
     * 邮件发送前数据组装
     */
    private void sendFrontMail(boolean isIndex,String[][] email){
    	 Session countSession = HibernateCountUtil.currentSession();
         Session baseSession = HibernateSalveBaseUtil.currentSession();
    	//发送邮件
        for(int i = 0 ; i < email.length; i++){
        	String siteIds = "";
        	if(null == email[i][1] || email[i][1].equals("")){
        		for(int j = 0 ; j < SITEURL.length; j++){
        			siteIds +=  SITEURL[j][0]+",";
        		}
        		siteIds = siteIds.substring(0, siteIds.lastIndexOf(","));
        	}else{
        		siteIds = email[i][1];
        	}
            StringBuilder sql = new StringBuilder("FROM CountSiteIndexCheck ");
            if(isIndex){
            	sql.append("WHERE sysStatus = 1 ");
            }else{
            	sql.append("WHERE sysStatus = 2 ");
            }
            sql.append(" AND siteId IN("+siteIds+") AND createDate > '"+DateTime.now().toString("yyyy-MM-dd")+"'");
            Query countQuery = countSession.createQuery(sql.toString());
            List<CountSiteIndexCheck> list = countQuery.list();
            Map<String,List<CountSiteIndexCheck>> paramMap = Maps.newLinkedHashMap();
            if(CollectionUtils.isNotEmpty(list)){
            	Integer siteId = 0;
            	List<CountSiteIndexCheck> dataList = Lists.newArrayList();
            	String siteName = "";
            	//遍历每个站点的数据
            	for(CountSiteIndexCheck model : list){
            		if(!siteId.equals(model.getSiteId())){
            			dataList = Lists.newArrayList();
            			SysWebSite site = (SysWebSite)baseSession.get(SysWebSite.class, model.getSiteId());
                		if(null != site){
                			if(isIndex){
                				if(site.getId().equals(33)){
                					siteName = "网站首页";
                				}else{
                					siteName = site.getName()+"站点";
                				}
                			}else{
                				siteName = "网站后台"+site.getName()+"站点";
                			}
                		}
            		}
            		if(StringUtils.isNotBlank(siteName)){
            			dataList.add(model);
                		paramMap.put(siteName, dataList);
            			siteId = model.getSiteId();
            		}
            	}
            	if(isIndex){
            		sendIndexMail(email[i][0],paramMap);
            	}else{
            		sendAdminMail(email[i][0],paramMap);
            	}
            }
        }
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
	private void executeMethod(HttpGet httpGetSite,Integer siteId, String siteUrl) {
		try {
			// 执行站点URL
			String content = EntityUtils.toString(httpClient.execute(httpGetSite).getEntity());
			// 通过正则表达式取首页中的所有URL地址
			content = StringUtils.substringAfter(content,"<div class=\"topNav\" id=\"topNav\">");
			// 分析img属性的标签
			//Pattern imgSrc = Pattern.compile("<img[^>]+src\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>");
			Pattern imgSrc = Pattern.compile("<img[^>]+src=\\s*['\"]((/static/img/blank/logo)(\\S*)+[.]{1}(jpg|jpeg|gif|png){1})['\"][^>]*>");
			Set<String> imgList = Sets.newHashSet();
			analysis(content, true,siteUrl, imgSrc, imgList, null);
			Pattern aUrl = Pattern.compile("<a[^>]+href=\"([^\"]+)\"[^>]*>([^<]+)</a>(?s)");
			if(CollectionUtils.isNotEmpty(imgList)){
				for(String imgUrl : imgList){
					save(siteId,siteUrl,imgUrl,"","虚位以待",1);
				}
			}
			
			// 分析a属性标签
			List<String[]> aUrllist = Lists.newArrayList();
			analysis(content, false,siteUrl, aUrl, null, aUrllist);
            //去重
            List<String[]> subUrlList = removeDuplicateWithOrder(aUrllist);
            //分析处理及保存
			mainSubUrl(subUrlList, siteId, siteUrl);
		} catch (HttpException e) {
			// 发生致命的异常，可能是协议不对或者返回的内容有问题
			log.error(e.toString());
		} catch (IOException e) {
			// 发生网络异常
			log.error(e.toString());
		} catch (IllegalArgumentException e) {
			// host parameter is null
			log.error(e.toString());
		} finally {
			// 释放连接
			httpGetSite.releaseConnection();
		}
	}

    /**
     * 站点首页中的其它所有URL进行遍历
     * 
     * @param listUrl
     */
    private void mainSubUrl(List<String[]> listUrl, Integer siteId,String siteUrl){
    	if(CollectionUtils.isNotEmpty(listUrl)){
    		log.error("站点URL【"+siteUrl+"】，总URL数量："+listUrl.size());
            for(String[] url : listUrl){
            	CountSiteIndexCheck model = new CountSiteIndexCheck();
            	model.setSiteId(siteId);
            	model.setMainUrl(siteUrl);
            	model.setUrlOrType(url[0]);
            	model.setInfoName(url[1]);
            	model.setSysStatus(1);
            	model.setCreateDate(new Date());
                // 执行首页中的URL
                HttpGet httpGeturl = new HttpGet(url[0]);
				try {
					RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(30000).setConnectTimeout(2000).build();//设置请求和传输超时时间
					httpGeturl.setConfig(requestConfig);
					CloseableHttpResponse response = httpClient.execute(httpGeturl);
					try {
						String subUrlContent = EntityUtils.toString(response.getEntity());
		                if(StringUtils.contains(subUrlContent,"<strong>该职位已停止招聘</strong>")){
		                	if(StringUtils.contains(url[0], "/jobs/")){
			                	model.setMesage("该职位已停止招聘。");
			                	positionPackage(model,Integer.valueOf(StringUtils.substringBetween(url[0], "/jobs/", ".shtml")));
			                }else{
			                	save(siteId,siteUrl,url[0],url[1],"该职位已停止招聘。" ,1);
			                }
		                }else if(StringUtils.contains(subUrlContent, "<div class=\"tips-layout tipsBg404\">")){
		                	if(StringUtils.contains(url[0], "/jobs/")){
			                	model.setMesage("对不起，没有找到您所请求的页面。");
			                	positionPackage(model,Integer.valueOf(StringUtils.substringBetween(url[0], "/jobs/", ".shtml")));
			                }else{
			                	save(siteId,siteUrl,url[0],url[1],"对不起，没有找到您所请求的页面。",1);
			                }
		                }else if(StringUtils.contains(subUrlContent, "<div class=\"tips-layout tipsBg500\">")){
		                	if(StringUtils.contains(url[0], "/jobs/")){
			                	model.setMesage("对不起，没有找到您所请求的页面。");
			                	positionPackage(model,Integer.valueOf(StringUtils.substringBetween(url[0], "/jobs/", ".shtml")));
			                }else{
			                	save(siteId,siteUrl,url[0],url[1],"对不起，没有找到您所请求的页面。",1);
			                }
		                }
		                
					} catch (Exception e) {
						if(e instanceof SocketTimeoutException)
							if(StringUtils.contains(url[0], "/jobs/")){
			                	model.setMesage("对不起,您请求的URL链接超时。");
			                	positionPackage(model,Integer.valueOf(StringUtils.substringBetween(url[0], "/jobs/", ".shtml")));
			                }else{
			                	save(siteId,siteUrl,url[0],url[1],"对不起,您请求的URL链接超时。",1);
			                }
						log.error("【"+url[0] + "】--->" +e.toString());
					}finally{
						try {
	                		if(null != response)
	                			response.close();
						} catch (IOException e1) {
							log.error(e1.toString());
						}
					}
				} catch (Exception e) {
					if(e instanceof SocketTimeoutException)
						if(StringUtils.contains(url[0], "/jobs/")){
		                	model.setMesage("对不起,您请求的URL链接超时。");
		                	positionPackage(model,Integer.valueOf(StringUtils.substringBetween(url[0], "/jobs/", ".shtml")));
		                }else{
		                	save(siteId,siteUrl,url[0],url[1],"对不起,您请求的URL链接超时。",1);
		                }
					log.error("【"+url[0] + "】--->" +e.toString());
				}finally{
					// 释放连接
                	httpGeturl.releaseConnection();
                	try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						log.error(e.toString());
					}
				}
            }
        }
    }
    
    /**
     * 参数组装
     * @param getMethod
     */
    private void getHttpParame(HttpGet getMethod){
        // 浏览器伪造
        getMethod.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 5.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/35.0.1916.114 Safari/537.36");
        getMethod.addHeader("Protocol", "HTTP/1.1");
        getMethod.addHeader("Scheme", "http");
        getMethod.addHeader("Connection", "keep-alive");
    }

    /**
     * 站点首页邮件发送
     *
     * @param email
     * @param paramMap
     */
    private void sendIndexMail(String email,Map<String,List<CountSiteIndexCheck>> paramMap){
        try{
            String mailContent = this.assembleMailContent(paramMap,"mail/count_site_index_check_app.ftl");
            if(StringUtils.isNotBlank(mailContent)){
                String[] toAddr = email.split(",");
                boolean flag = sender.send(new CountSiteIndexCheckAppVo(mailContent, toAddr, Constants.MAIL_TYPE_SIMPLIFIED));
                try {
                    if(flag){
                        log.error(email + "发送成功！");
                    }else{
                        log.error(email + "发送失败！");
                    }
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }catch(IOException e){
            log.error("==>站点首页检测URL是否失效提醒邮件异常：" + e.toString());
        }
    }
    
    /**
     * 后台邮件发送
     *
     * @param email
     * @param paramMap
     */
    private void sendAdminMail(String email,Map<String,List<CountSiteIndexCheck>> paramMap){
        try{
            String mailContent = this.assembleMailContent(paramMap,"mail/count_site_admin_data_check.ftl");
            if(StringUtils.isNotBlank(mailContent)){
                String[] toAddr = email.split(",");
                boolean flag = sender.send(new CountSiteAdminCheckAppVo(mailContent, toAddr, Constants.MAIL_TYPE_SIMPLIFIED));
                try {
                    if(flag){
                        log.error(email + "发送成功！");
                    }else{
                        log.error(email + "发送失败！");
                    }
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }catch(IOException e){
            log.error("==>后台logo、职位与企业过期程序检查提醒邮件异常：" + e.toString());
        }
    }

    /**
     * 组装邮件内容
     *
     * @param paramMap
     * @return
     * @throws IOException
     */
    private String assembleMailContent(Map<String,List<CountSiteIndexCheck>> paramMap,String mailTemplete)throws IOException {
        if (MapUtils.isNotEmpty(paramMap)) {
            Configuration configure = FreemarkerConfigure.getFreemarkerConfig();
            //"mail/count_site_index_check_app.ftl"
            Template template = configure.getTemplate(mailTemplete);

            Map<String, Object> map = Maps.newHashMap();
            map.put("map", paramMap);
            try {
                StringWriter result = new StringWriter();
                template.process(map, result);
                return result.toString();
            } catch (TemplateException e) {
                log.error("==>邮件模板解析异常：" + e.getMessage(), e);
            }
        }
        return StringUtils.EMPTY;
    }

    /**
     * 组装爬虫后的数据进行数据分析
     * 
     * @param content
     * @param siteUrl
     * @param pattern
     * @param imgList
     * @param aUrllist
     */
    private void analysis(String content,boolean isImg,String siteUrl,Pattern pattern,Set<String> imgList,List<String[]> aUrllist){
    	 Matcher matcher = pattern.matcher(content);
         while(matcher.find()) {
         	if (isImg && matcher.group(1).startsWith("/static/img/blank/logo")){
              	imgList.add(matcher.group(1));
            }
         	
         	if(!isImg && !matcher.group(1).contains("/s/p") && !matcher.group(1).contains("https://") && !matcher.group(1).contains("javascript")){
             	String[] url = new String[2];
             	if(!matcher.group(1).contains("http://")){
                    //组装职位与公司名称
                    if(matcher.group(1).contains("/jobs/") || matcher.group(1).contains("/corp/")){
                        url[1] = matcher.group(2);
                    }
             		url[0] = siteUrl + matcher.group(1);
             	}else{
             		url[0] = matcher.group(1);
             	}
                 aUrllist.add(url);
             }
        }
    }

    private List<String[]> removeDuplicateWithOrder(List<String[]> list) {
        Set<String[]> set = Sets.newHashSet();
        List<String[]> newList = Lists.newArrayList();
        for (Iterator<String[]> iter = list.iterator(); iter.hasNext();) {
            String[] element = iter.next();
            if (set.add(element))
                newList.add(element);
        }
        return newList;
    }
    
    /**
     * 高薪职位
     * 
     * @param siteId
     * @param siteUrl
     * @throws ParseException 
     */
    private void highSalaryList(Integer siteId,String siteUrl,String modelType) throws ParseException{
    	Session baseSession = HibernateSalveBaseUtil.currentSession();
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	Date date = sdf.parse(sdf.format(new Date()));
    	String hql = "FROM SysHotHunterPosition WHERE websiteId = :siteId AND delStatus <> 1 AND endDate > :endDate";
    	Query query = baseSession.createQuery(hql);
    	query.setParameter("siteId", siteId);
    	query.setParameter("endDate", date);
    	List<SysHotHunterPosition> list = query.list();
    	if(CollectionUtils.isNotEmpty(list)){
    		for(SysHotHunterPosition sysHot : list){
    			// 那么需要判断是否大于三天后的日期。
				if(sysHot.getEndDate().compareTo(DateUtils.addDays(date, 3)) <= 0 && sysHot.getEndDate().compareTo(date) >= 0){
					String mesg = posMesgDataPackage(sysHot.getComName(),sysHot.getPosName(),sysHot.getPosId(),sdf.format(sysHot.getEndDate()));
					save(siteId,siteUrl,modelType,"职位即将到期！",mesg,2);
				}
    		}
    	}
    }
    
    /**
     * 知名品牌
     * 
     * @param siteId
     * @param siteUrl
     * @throws ParseException 
     */
    private void famousBrand(Integer siteId,String siteUrl,String modelType) throws ParseException{
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	Date date = sdf.parse(sdf.format(new Date()));
    	Session baseSession = HibernateSalveBaseUtil.currentSession();
    	String hql = "FROM SysLogoFile where state = 1 and siteId = :siteId";
    	Query query = baseSession.createQuery(hql);
    	query.setParameter("siteId", siteId);
    	List<SysLogoFile> list = query.list();
    	if(CollectionUtils.isNotEmpty(list)){
    		for(SysLogoFile sysLogo : list){
    			List<Integer> logoPositionIdList = getLogoPositionIdListByFileId(sysLogo);
    			if(CollectionUtils.isNotEmpty(logoPositionIdList)){
    				List<SysLogoQueue> queryList = queryLogoQueueListByPosIdList(logoPositionIdList);
    				if(CollectionUtils.isNotEmpty(queryList)){
    					SysLogoQueue queue = getUsingLogoQueue(queryList);
    					if(null != queue){
    						SysLogoResource logoResource = queue.getLogoResource();
    						if(null == logoResource)
    							continue;
    						
    						//判断logo的截止日期是否大于3天，那么判断职位与企业的过期日期
    						if(queue.getEndDate().compareTo(DateUtils.addDays(date, 3)) > 0){
    							//广告位置
    							SysLogoPosition logoPos = queue.getLogoPosition();
    							if(logoResource.getComId() > 0){
    								ComInfo info = (ComInfo) baseSession.get(ComInfo.class, logoResource.getComId());
        							ComRight comRight = info.getComRight();
        							if(null != comRight && comRight.getExpireDate().compareTo(DateUtils.addDays(date, 3)) <= 0 && comRight.getExpireDate().compareTo(date) >= 0){
        								String mesg = logoComMesgDataPackage(logoPos.getCodeNo(),info.getComName(),comRight.getComId(),sdf.format(comRight.getExpireDate()));
        								save(siteId,siteUrl,modelType,"企业即将到期！",mesg,2);
        							}else{
        								//职位ids
            							List<Integer> positionList = queue.getPareJSONPositionInfo();
            							if(CollectionUtils.isNotEmpty(positionList)){
            								for(Integer posId : positionList){
            									ComPosition comPosition = (ComPosition) baseSession.get(ComPosition.class, posId);
            									ComInfo comInfo = (ComInfo) baseSession.get(ComInfo.class, comPosition.getComId());
            									if(null != comPosition && comPosition.getEndDate().compareTo(DateUtils.addDays(date, 3)) <= 0 && comPosition.getEndDate().compareTo(date) >= 0){
            	    								String mesg = logoPosMesgDataPackage(logoPos.getCodeNo(),comInfo.getComName(),comPosition.getPosName(),comPosition.getId(),sdf.format(comPosition.getEndDate()));
            	    								save(siteId,siteUrl,modelType,"职位即将到期！",mesg,2);
            	    							}
            								}
            							}
        							}
    							}
    						}else{
    							//广告位置
    							SysLogoPosition logoPos = queue.getLogoPosition();
    							//广告位置所对应的队列
    							List<SysLogoQueue> logoQueueList = baseSession.createQuery("FROM SysLogoQueue WHERE positionId =:posID ").setParameter("posID", logoPos.getId()).list();
    							//此位置是否还有LOGO在队列中等待
    							boolean isWaitQueue = false;
    							for(SysLogoQueue logoQueue : logoQueueList){
    								//广告LOGO的过期日期
        							Date logoQueueEndDate = sdf.parse(sdf.format(logoQueue.getEndDate()));
        							//查找队列中是否有排队等待的LOGO，并且需要剔除当前位置使用的资源ID
    								if(!logoResource.getId().equals(logoQueue.getResourceId()) && logoQueueEndDate.compareTo(DateUtils.addDays(date, 3)) > 0){
    									isWaitQueue = true;
    									break;
    								}
    							}
    							
    							if(!isWaitQueue && sdf.parse(sdf.format(queue.getEndDate())).compareTo(date) >= 0){
    								//如果截止日期小于或者等于当天的话，那么只保存logo过期的数据
    								String mesg = logoMesgDataPackage(logoPos.getCodeNo(),logoResource.getDescript(),logoResource.getLogoId(),sdf.format(queue.getEndDate()));
    								save(siteId,siteUrl,modelType,"广告LOGO即将到期！",mesg,2);
    							}
    						}
    					}
    				}
    			}
    		}
    	}
    }
    
    /**
     * 急聘职位
     * 
     * @param siteId
     * @param siteUrl
     * @throws ParseException 
     */
//    private void hotRecruit(Integer siteId,String siteUrl,String modelType) throws ParseException{
//    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//    	Date date = sdf.parse(sdf.format(new Date()));
//    	Session baseSession = HibernateSalveBaseUtil.currentSession();
//    	String hql = "FROM SysHotRecruitCom";
//    	Query query = baseSession.createQuery(hql);
//    	List<SysHotRecruitCom> list = query.list();
//    	if(CollectionUtils.isNotEmpty(list)){
//    		for(SysHotRecruitCom sHot : list){
//    			if(null != sHot.getComInfo() && null != sHot.getComInfo().getComRight()){
//    				Date expireDate = sdf.parse(sdf.format(sHot.getComInfo().getComRight().getExpireDate()));
//    				if(expireDate.compareTo(DateUtils.addDays(date, 3)) <= 0 && expireDate.compareTo(date) >= 0){
//    					String mesg = comMesgDataPackage(sHot.getComInfo().getComName(),sHot.getComId(),sdf.format(expireDate));
//    					save(siteId,siteUrl,modelType,"企业即将到期！",mesg,2);
//    				}
//    			}
//    		}
//    	}
//    	
//    }

    /**
     * 热聘职位
     * 
     * @param siteId
     * @param siteUrl
     * @throws ParseException
     */
    private void hotRecruitPosition(Integer siteId,String siteUrl,String modelType) throws ParseException{
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	Date date = sdf.parse(sdf.format(new Date()));
    	Session baseSession = HibernateSalveBaseUtil.currentSession();
    	String hql = "FROM SysHomePosition where websiteId = :siteId AND endDate >= :date";
    	Query query = baseSession.createQuery(hql);
    	query.setParameter("siteId", siteId);
    	query.setParameter("date", date);
    	List<SysHomePosition> list = query.list();
    	if(CollectionUtils.isNotEmpty(list)){
    		for(SysHomePosition sPos : list){
    			if(sPos.getEndDate().compareTo(DateUtils.addDays(date, 3)) > 0){
    				//查企业与职位
    				if(null != sPos.getComInfo()){
    					Date expireDate = sdf.parse(sdf.format(sPos.getComInfo().getComRight().getExpireDate()));
    					if(expireDate.compareTo(DateUtils.addDays(date, 3)) <= 0  && expireDate.compareTo(date) >= 0){
        					String mesg = comMesgDataPackage(sPos.getComInfo().getComName(),sPos.getComInfo().getId(),sdf.format(expireDate));
        					save(siteId,siteUrl,modelType,"企业即将到期！",mesg,2);
    					}else{
    						List<Integer> posistionList = sPos.getPositionList();
    						if(CollectionUtils.isNotEmpty(posistionList)){
    							for(Integer posId : posistionList){
    								ComPosition comPos = (ComPosition)baseSession.get(ComPosition.class, posId);
    								ComInfo comInfo = (ComInfo) baseSession.get(ComInfo.class, comPos.getComId());
    								if(null != comPos){
    									if(comPos.getEndDate().compareTo(DateUtils.addDays(date, 3)) <= 0  && comPos.getEndDate().compareTo(date) >= 0){
    										String mesg =posMesgDataPackage(comInfo.getComName(),comPos.getPosName(),comPos.getId(),sdf.format(comPos.getEndDate()));
    										save(siteId,siteUrl,modelType,"职位即将到期！",mesg,2);
    									}
    								}
    							}
    						}
    					}
    				}
    			}else{
    				if(sdf.parse(sdf.format(sPos.getEndDate())).compareTo(date) >= 0){
    					String mesg = advertisingMesgDataPackage(sPos.getId()+"",sPos.getComInfo().getComName(),sdf.format(sPos.getEndDate()));
    					save(siteId,siteUrl,modelType,"广告即将到期！",mesg,2);
        			}
    			}
    		}
    	}
    }
    
	/**
	 * 获取LOGO看板中所有位置的ID列表
	 * 
	 * @param logoFile
	 * @return
	 */
	private List<Integer> getLogoPositionIdListByFileId(SysLogoFile logoFile) {
		List<Integer> positionIdList = Lists.newArrayList();
		List<SysLogoTable> logoTableList = logoFile.getLogoTableList();
		if (CollectionUtils.isNotEmpty(logoTableList)) {
			for (SysLogoTable logoTable : logoTableList) {
				List<SysLogoPosition> logoPositionList = logoTable.getLogoPositionList();
				if (CollectionUtils.isNotEmpty(logoPositionList)) {
					for (SysLogoPosition logoPosition : logoPositionList) {
						positionIdList.add(logoPosition.getId());
					}
				}
			}
		}
		return positionIdList;
	}
	
	private List<SysLogoQueue> queryLogoQueueListByPosIdList(List<Integer> positionIdList){
		Session baseSession = HibernateSalveBaseUtil.currentSession();
		String hql = "FROM SysLogoQueue WHERE positionId IN(:positionIdList))";
		return baseSession.createQuery(hql).setParameterList("positionIdList", positionIdList).list();
	}
    
    /**
     * 有效的广告
     * 
     * @param logoQueueList
     * @return
     */
    private SysLogoQueue getUsingLogoQueue(List<SysLogoQueue> logoQueueList){
		if(CollectionUtils.isNotEmpty(logoQueueList)){
			DateTime currentDate = new DateTime(DateTime.now().toString("yyyy-MM-dd"));
			/** 优先判断付费LOGO **/
			for (SysLogoQueue logoQueue : logoQueueList) {
				if (logoQueue.getBuyFlag() == BuyFlag.FREE.getKey()) {
					continue;
				}
				if (currentDate.compareTo(new DateTime(logoQueue.getBeginDate())) >= 0
						&& currentDate.compareTo(new DateTime(logoQueue.getEndDate())) <= 0) {
					return logoQueue;
				}
			}
			
			/** 判断免费LOGO **/
			for (SysLogoQueue logoQueue : logoQueueList) {
				if (logoQueue.getBuyFlag() == BuyFlag.PAY.getKey()) {
					continue;
				}
				if (currentDate.compareTo(new DateTime(logoQueue.getBeginDate())) >= 0
						&& currentDate.compareTo(new DateTime(logoQueue.getEndDate())) <= 0) {
					return logoQueue;
				}
			}
			
			SysLogoQueue logoQueue = logoQueueList.get(0);
			int differ = dateDiff(logoQueue.getBeginDate(), currentDate.toDate());

			if (logoQueueList.size() > 1) {
				for (int i = 1; i < logoQueueList.size(); i++) {
					SysLogoQueue tempLogoQueue = logoQueueList.get(i);
					int tempDiffer = dateDiff(tempLogoQueue.getBeginDate(), currentDate.toDate());
					if (tempDiffer < differ) {
						differ = tempDiffer;
						logoQueue = tempLogoQueue;
					}
				}
			}
			return logoQueue;
		}
		return null;
	}
    
    /**
     * 保存
     * 
     * @param siteId
     * @param siteUrl
     * @param type
     * @param name
     * @param mesg
     */
    private void save(Integer siteId,String siteUrl,String type,String name,String mesg,int status){
    	Session countSession = HibernateCountUtil.currentSession();
    	CountSiteIndexCheck model = new CountSiteIndexCheck();
		model.setSiteId(siteId);
		model.setMainUrl(siteUrl);
		model.setCreateDate(new Date());
		model.setSysStatus(status);
		model.setUrlOrType(type);
		model.setInfoName(name);
		model.setMesage(mesg);
		
		countSession.save(model);
		countSession.flush();
		countSession.clear();
    }
    
    /**
     * @throws ParseException 
	 * 
	* @Description: 校园招聘企业
	* @param @param websiteId
	* @param @return    设定文件 
	* @return List<ComInfo>    返回类型 
	* @throws
	 */
	private void getSchoolComByWebsite(Integer siteId,String siteUrl,String modelType) throws ParseException {
		Session baseSession = HibernateSalveBaseUtil.currentSession();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	Date date = sdf.parse(sdf.format(new Date()));
		List<SysComPosSchool> sysComPosSchoolList = baseSession.createQuery("FROM SysComPosSchool WHERE websiteId = "+siteId).list();
		
		for(SysComPosSchool schoolCom : sysComPosSchoolList) {
			if(schoolCom.getComInfo() != null) {
				Date expireDate = sdf.parse(sdf.format(schoolCom.getComInfo().getComRight().getExpireDate()));
				if(expireDate.compareTo(DateUtils.addDays(date, 3)) <= 0 && expireDate.compareTo(date) >= 0){
					String mesg = comMesgDataPackage(schoolCom.getComInfo().getComName(),schoolCom.getComInfo().getId(),sdf.format(expireDate));
					save(siteId,siteUrl,modelType,"企业即将到期！",mesg,2);
				}else{
					List<ComPosition> comPositionList = getComPositionListByComId(schoolCom.getComId());
					if(CollectionUtils.isNotEmpty(comPositionList)) {
						for(ComPosition pos : comPositionList){
							if(pos.getEndDate().compareTo(DateUtils.addDays(date, 3)) <= 0 && pos.getEndDate().compareTo(date) >= 0){
								ComInfo comInfo = (ComInfo) baseSession.get(ComInfo.class, pos.getComId());
								String mesg = posMesgDataPackage(comInfo.getComName(),pos.getPosName(),pos.getId(),sdf.format(pos.getEndDate()));
								save(siteId,siteUrl,modelType,"职位即将到期！",mesg,2);
							}
						}
					}
				}
			}
		}
		
	}
	
	/**
	 * 
	* @Title: getComPositionList 
	* @Description: 通过企业id获取查询库的校园招聘职位信息
	* @param @param positionList
	* @param @return    设定文件 
	* @return List<Integer>    返回类型 
	* @throws
	 */
	private List<ComPosition> getComPositionListByComId(Integer comId) {
		List<ComPosition> comPositionList = Lists.newArrayList();
		Session session = HibernateSalveBaseUtil.currentSession();
		List<PosExportBrief> posBriefList = getSchoolPosBriefListByComId(comId);
		
		if(CollectionUtils.isNotEmpty(posBriefList)) {
			for(PosExportBrief posBrief : posBriefList) {
				ComPosition position = (ComPosition)session.get(ComPosition.class, posBrief.getPosId());
				comPositionList.add(position);
			}
		}
		
		return comPositionList;
	}
	
	/**
     * 根据企业ID在查询库中获取校园招聘职位具体信息
     * @param comId 企业ID
     * @return PosBreif List
     */
    private List<PosExportBrief> getSchoolPosBriefListByComId(Integer comId) {
    	Session querySession = HibernateQuery2Util.currentSession();
        if(comId != null && comId > 0) {
            String hql = "FROM PosExportBrief pb WHERE pb.workedYear =0 and pb.comId = "+ comId;
            return querySession.createQuery(hql).list();
        }
        return null;
    }
    
    /**
     * 组装职位的所有对应的公司名
     * 
     * @param model
     * @param posNo
     */
    private void positionPackage(CountSiteIndexCheck model,int posNo){
    	modelList.add(model);
    	int[] posAndType = KeyMaskUtil.posNoToIdAndType(posNo);
    	if(null == posAndType || posAndType.length == 0)
    		return ;
    	
    	if(posAndType[1] == 1){
    		// 网络职位
    		siteIndexNetworkPosIds.add(posAndType[0]);
    	}else{
    		// 招聘会职位
    		siteIndexRecruitment.add(posAndType[0]);
    	}
    }
    
    private void getComInfoName(Map<Integer,String> comMap){
    	Session baseSession = HibernateSalveBaseUtil.currentSession();
        //企业名称
    	String hql = "FROM ComPosition WHERE id IN (:ids)";
    	Query query = baseSession.createQuery(hql).setParameterList("ids", siteIndexNetworkPosIds);
    	List<ComPosition> list = query.list();
    	if(CollectionUtils.isNotEmpty(list)){
    		for(ComPosition compos : list){
    			ComInfo comInfo = (ComInfo)baseSession.get(ComInfo.class, compos.getComId());
    			comMap.put(compos.getId(), comInfo.getComName());
    		}
    	}
    }
    
    /**
     * 职位描述信息的数据组装
     * 
     * @param posName
     * @param posId
     * @param expireDate
     * @return
     */
    private String posMesgDataPackage(String comName,String posName,Integer posId,String expireDate){
    	return StringUtils.replace(StringUtils.replace(StringUtils.replace(StringUtils.replace(posMesg, "#comName#", comName),"#posName#",posName),"#posId#",posId+""),"#expireDate#",expireDate);
    }
    
    /**
     * 职位广告LOGO描述信息的数据组装
     * 
     * @param posName
     * @param posId
     * @param expireDate
     * @return
     */
    private String logoPosMesgDataPackage(String logoNo,String comName,String posName,Integer posId,String expireDate){
    	return StringUtils.replace(StringUtils.replace(StringUtils.replace(StringUtils.replace(StringUtils.replace(logoPosMesg,"#logoNo#",logoNo), "#comName#", comName),"#posName#",posName),"#posId#",posId+""),"#expireDate#",expireDate);
    }
    
    /**
     * 企业描述信息的数据组装
     * 
     * @param posName
     * @param posId
     * @param expireDate
     * @return
     */
    private String comMesgDataPackage(String comName,Integer comId,String expireDate){
    	return StringUtils.replace(StringUtils.replace(StringUtils.replace(comMesg, "#comName#", comName),"#comId#",comId+""),"#expireDate#",expireDate);
    }
    
    /**
     * 企业广告LOGO描述信息的数据组装
     * 
     * @param posName
     * @param posId
     * @param expireDate
     * @return
     */
    private String logoComMesgDataPackage(String logoNo,String comName,Integer comId,String expireDate){
    	return StringUtils.replace(StringUtils.replace(StringUtils.replace(StringUtils.replace(logoComMesg,"#logoNo#",logoNo), "#comName#", comName),"#comId#",comId+""),"#expireDate#",expireDate);
    }
    
    /**
     * 广告LOGO描述信息的数据组装
     * 
     * @param posName
     * @param posId
     * @param expireDate
     * @return
     */
    private String logoMesgDataPackage(String logoNo,String logoName,Integer logoId,String expireDate){
    	return StringUtils.replace(StringUtils.replace(StringUtils.replace(StringUtils.replace(logoMesg, "#logoNo#", logoNo), "#logoName#", logoName),"#logoId#",logoId+""),"#expireDate#",expireDate);
    }
    
    /**
     * 广告描述信息的数据组装
     * 
     * @param id
     * @param logoName
     * @param expireDate
     * @return
     */
    private String advertisingMesgDataPackage(String id,String logoName,String expireDate){
    	return StringUtils.replace(StringUtils.replace(StringUtils.replace(advertisingMesg, "#id#", id), "#logoName#", logoName),"#expireDate#",expireDate);
    }
    
    /**
	 * 计算两个时间差
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	private int dateDiff(java.util.Date a, java.util.Date b) {
		int tempDifference = 0;
		int difference = 0;
		Calendar earlier = Calendar.getInstance();
		Calendar later = Calendar.getInstance();

		if (a.compareTo(b) < 0) {
			earlier.setTime(a);
			later.setTime(b);
		} else {
			earlier.setTime(b);
			later.setTime(a);
		}

		while (earlier.get(Calendar.YEAR) != later.get(Calendar.YEAR)) {
			tempDifference = 365 * (later.get(Calendar.YEAR) - earlier.get(Calendar.YEAR));
			difference += tempDifference;

			earlier.add(Calendar.DAY_OF_YEAR, tempDifference);
		}

		if (earlier.get(Calendar.DAY_OF_YEAR) != later.get(Calendar.DAY_OF_YEAR)) {
			tempDifference = later.get(Calendar.DAY_OF_YEAR) - earlier.get(Calendar.DAY_OF_YEAR);
			difference += tempDifference;

			earlier.add(Calendar.DAY_OF_YEAR, tempDifference);
		}

		return difference;
	}
}