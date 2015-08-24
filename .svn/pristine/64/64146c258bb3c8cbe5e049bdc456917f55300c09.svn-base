package com.job5156.task.collect.company;

import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;

import com.job5156.model.temp.ComInfoCellect;

/**
 * 
* 卓博企业数据采集器
* @author xh 
* @date 2014-9-28 上午9:53:23 
*
 */
public class JobcnCompanyDataCellect extends CompanyDataCellectBase {
	private static final Logger logger = Logger.getLogger(JobcnCompanyDataCellect.class);
	
	private static String dataCellectUrl = "http://www.jobcn.com/position/company.xhtml?redirect=0&comId={comId}&s=search/advanced";
	private static int beginId = 200406;//爬行器开始ID
	private static int endId = 600000;//爬行器结束ID
	private static String idPrefix = "";//企业ID前缀
	
	public static void main(String[] args) {
		JobcnCompanyDataCellect jobcnDataCellect = new JobcnCompanyDataCellect();
		//验证是否需要初始化数据
		jobcnDataCellect.setInit(jobcnDataCellect.validateDateInit(ComType.JOBCN));
		jobcnDataCellect.startCellectCompanyData(dataCellectUrl, beginId, endId, idPrefix);
	}
	
	public void startCellectCompanyData(String url, Integer beginId, Integer endId, String idPrefix) {
		logger.info("=====>开始启动卓博企业数据采集程序：" + DateTime.now().toString("yyyy-MM-dd HH:ss:mm"));
		
		for(; beginId <= endId; beginId++) {
			PostMethod postMethod = getHcu().createHttpMethod(url.replace("{comId}", String.valueOf(beginId)));
			String htmlContent =  getHcu().executeMethod(postMethod);
			ComInfoCellect comInfo = getComInfo(htmlContent);
			if(comInfo != null) {
				comInfo.setComId(String.valueOf(beginId));
				//采集企业数据
				cellectCompanyData(comInfo, ComType.JOBCN);
			}
		}
		
		logger.info("=====>卓博企业数据采集程序执行完毕：" + DateTime.now().toString("yyyy-MM-dd HH:ss:mm"));
	}

	@Override
	public ComInfoCellect getComInfo(String html) {
		ComInfoCellect comInfo = null;
		//用于判断企业时候存在职位信息
		String posIndex = "<span class=\"tab_btn_pos \" id=\"tab_btn_pos\">招聘职位";
		//获取职位html
		ParseElement posHtmlElement = new ParseElement("<div id=\"position_list\" class=\"pos_list\">", "</div><div class=\"tac\">");
		String posHtml = ParseUtils.parserValueByElement(html, posHtmlElement).trim();
		
		//判断是否存在职位信息并且职位数不为0，已过期企业将不采集
		if(html.indexOf(posIndex) != -1 && StringUtils.isNotBlank(posHtml)) {
			ParseElement comNameElement = new ParseElement("<DIV class=\"company_text fl\"><SPAN class=\"name\" title=\"", "\">");
			ParseElement contactPersonElement = new ParseElement("<DIV class=\"f444 company_us\"><SPAN class=\"b\">联系方式</SPAN><br/>联系人：", "<br/>");
			String comName = ParseUtils.parserValueByElement(html, comNameElement);
			String contactPerson = ParseUtils.parserValueByElement(html, contactPersonElement);
			
			if(StringUtils.isNotBlank(comName)) {
				comInfo = new ComInfoCellect();
				comInfo.setComName(comName);
				comInfo.setContactPerson(contactPerson);
			}
		}
		
		return comInfo;
	}
	
}
