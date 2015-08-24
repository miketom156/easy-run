package com.job5156.task.collect.company;

import java.util.Map;

import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.util.CollectionUtils;

import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.job5156.model.temp.ComInfoCellect;

/**
 * 
* 中山国际人才网（中华英才网）企业数据采集器
* @author xh 
* @date 2014-9-28 上午10:05:46 
*
 */
public class ChinaHrCompanyDataCellect extends CompanyDataCellectBase {
	private static final Logger logger = Logger.getLogger(ChinaHrCompanyDataCellect.class);
	//搜索器url
	private static String dataCellectUrl = "http://www.job001.cn/so/0/0-0-0-0-0-0-{jobType}-0-0-0-0-0-0-{city}/p{pageSize}";
	//企业url开始索引html
	private static String comIndexStr = "<td width=\"249\" align=\"left\" valign=\"middle\" class=\"joblist_a\"><div class=\"fontover_hide width_240\"><a href=\"";
	//企业url结束索引html
	private static String comEndStr = "\" target=\"_blank\">";
	
	public static void main(String[] args) {
		ChinaHrCompanyDataCellect chinaHrDataCellect = new ChinaHrCompanyDataCellect();
		//验证是否需要初始化数据
		chinaHrDataCellect.setInit(chinaHrDataCellect.validateDateInit(ComType.JOB001));
		//开始执行数据采集
		chinaHrDataCellect.startCellectCompanyData();
	}
	
	/**
	 * 
	* 开始执行数据采集
	* @param     设定文件 
	* @return void    返回类型 
	* @throws
	 */
	private void startCellectCompanyData() {
		logger.info("=====>开始启动中山国际人才网企业数据采集程序：" + DateTime.now().toString("yyyy-MM-dd HH:ss:mm"));
		
		Map<String, String> jobTypeMap = getJobTypeMap();
		Map<String, String> cityMap = getCityMap();
		
		for(String city : cityMap.values()) {
			String cityCode = city.replaceAll(",", "_");//获取城市编码
			for(String jobType : jobTypeMap.values()) {
				if(jobType.indexOf(",") == -1 || jobType.split(",").length != 3) continue;//跳过职位类别大类
				String jobTypeCode = jobType.replaceAll(",", "_");//获取职位类别编码
				String searchUrl = dataCellectUrl.replace("{jobType}", jobTypeCode).replace("{city}", cityCode);
				cellectCompanyData(searchUrl);
			}
		}
		
		logger.info("=====>中山国际人才网企业数据采集程序执行完毕：" + DateTime.now().toString("yyyy-MM-dd HH:ss:mm"));
	}
	
	/**
	 * 
	* 采集指定搜索URL中的所有企业信息
	* @param @param searchUrl
	* @param @return    设定文件 
	* @return List<ComInfoCellect>    返回类型 
	* @throws
	 */
	private void cellectCompanyData(String url) {
		String searchUrl = url.replace("{pageSize}", "0") ;
		//String searchUrl = "http://zs.job001.cn/so/0/0-0-0-0-0-0-1006_1031_1473-0-0-0-0-0-0-25_297/p0";
		PostMethod postMethod = getHcu().createHttpMethod(searchUrl);
		String htmlContent =  getHcu().executeMethod(postMethod);
		//获取页码
		int pageSize = getListPageSize(htmlContent);
		
		System.out.println("=====>采集URL：" + searchUrl + "====>页码：" + pageSize);
		
		for(int i=0; i < pageSize; i++) {
			cellectCompanyData(url, i);
		}
	}
	
	/**
	 * 
	* 采集指定页码的数据
	* @param @param url
	* @param @param currentPage    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	private void cellectCompanyData(String url, int currentPage) {
		String searchUrl = url.replace("{pageSize}", String.valueOf(currentPage * 20)) ;
		PostMethod postMethod = getHcu().createHttpMethod(searchUrl);
		String htmlContent =  getHcu().executeMethod(postMethod);
		
		int index = htmlContent.indexOf(comIndexStr);
		while(StringUtils.isNotBlank(htmlContent) && index != -1) {
			htmlContent = htmlContent.substring(index + comIndexStr.length(), htmlContent.length());
			int end = htmlContent.indexOf(comEndStr);
			if(end != -1) {
				String comInfoUrl = htmlContent.substring(0, end);
				postMethod = getHcu().createHttpMethod(comInfoUrl);
				String comInfoHtml =  getHcu().executeMethod(postMethod);
				ComInfoCellect comInfo = getComInfo(comInfoHtml);
				//采集企业数据
				cellectCompanyData(comInfo, ComType.JOB001);
				//丢弃已解析的内容
				htmlContent = htmlContent.substring(end, htmlContent.length());
			}
			index = htmlContent.indexOf(comIndexStr);
		}
	}

	@Override
	public ComInfoCellect getComInfo(String html) {
		//处理HTML中的回车及换行符
		html = html.replaceAll("(\r\n|\r\n\t|\r|\n|\t|\n\r)", "");
		ComInfoCellect comInfo = null;
		ParseElement comInfoJsonElement = new ParseElement("var zNodes = [", "];</script>");
		String comInfoJson = ParseUtils.parserValueByElement(html, comInfoJsonElement);
		
		if(StringUtils.isNotBlank(comInfoJson)) {
			//判断是否有多个联系人信息
			if(comInfoJson.indexOf("children") != -1) {
				//如果有多个联系人则只取第一个联系人信息
				ParseElement mainContactJsonElement = new ParseElement("\"children\":[", ",{");
				comInfoJson = ParseUtils.parserValueByElement(comInfoJson, mainContactJsonElement);
			}
			//将json转换成Map
			Map<String, String> comInfoMap = new Gson().fromJson(comInfoJson, new TypeToken<Map<String, String>>() {}.getType());
			//验证json MAP是否为空
			if(!CollectionUtils.isEmpty(comInfoMap)) {
				comInfo = new ComInfoCellect();
				String comId = comInfoMap.get("id");
				String comName = comInfoMap.get("name") == null ? "" : comInfoMap.get("name");
				String contactPerson = comInfoMap.get("contact") == null ? "" : comInfoMap.get("contact");
				String contactPhone = comInfoMap.get("phone") == null ? comInfoMap.get("mobile") : comInfoMap.get("phone");
				String email = comInfoMap.get("email");
				
				comInfo.setComId(comId);
				comInfo.setComName(comName);
				comInfo.setContactPerson(contactPerson);
				comInfo.setContactPhone(contactPhone);
				comInfo.setEmail(email);
			}
			
		} else {
			System.out.println("============>无法解析JSON格式！" + comInfoJson);
		}
		
		return comInfo;
	}
	
	/**
	 * 
	* 获取搜索结果列表中的页数
	* @param @param html
	* @param @return    设定文件 
	* @return int    返回类型 
	* @throws
	 */
	private int getListPageSize(String html) {
		int pageSize = 0;
		ParseElement pageInfoElement = new ParseElement("</a>  页数 ", " 跳转到 ");
		String pageStr = ParseUtils.parserValueByElement(html, pageInfoElement);
		
		if(StringUtils.isNotBlank(pageStr)) {
			String[] pageInfo = pageStr.split("/");
			if(pageInfo.length == 2) {
				pageSize = NumberUtils.toInt(pageInfo[1], 0);
			}
		}
		
		return pageSize;
	}
	
	/**
	 * 
	* 获取职位类别
	* @param @return    设定文件 
	* @return Map<String,String>    返回类型 
	* @throws
	 */
	private Map<String, String> getJobTypeMap() {
		Map<String, String> jobTypeMap = Maps.newHashMap();
		jobTypeMap.put("计算机/互联网/通信/电子", "1001");
		jobTypeMap.put("计算机硬件", "1001,1001");
		jobTypeMap.put("高级硬件工程师", "1001,1001,1001");
		jobTypeMap.put("硬件工程师", "1001,1001,1002");
		jobTypeMap.put("其他", "1001,1001,1003");
		jobTypeMap.put("计算机软件", "1001,1002");
		jobTypeMap.put("高级软件工程师", "1001,1002,1004");
		jobTypeMap.put("软件工程师", "1001,1002,1005");
		jobTypeMap.put("软件UI设计师/工程师", "1001,1002,1006");
		jobTypeMap.put("仿真应用工程师", "1001,1002,1007");
		jobTypeMap.put("ERP实施顾问", "1001,1002,1008");
		jobTypeMap.put("ERP技术开发", "1001,1002,1009");
		jobTypeMap.put("需求工程师", "1001,1002,1010");
		jobTypeMap.put("系统集成工程师", "1001,1002,1011");
		jobTypeMap.put("系统分析员", "1001,1002,1012");
		jobTypeMap.put("系统工程师", "1001,1002,1013");
		jobTypeMap.put("系统架构设计师", "1001,1002,1014");
		jobTypeMap.put("数据库工程师/管理员", "1001,1002,1015");
		jobTypeMap.put("计算机辅助设计工程师", "1001,1002,1016");
		jobTypeMap.put("其他师", "1001,1002,1017");
		jobTypeMap.put("互联网/电子商务/网游", "1001,1003");
		jobTypeMap.put("互联网软件开发工程师", "1001,1003,1018");
		jobTypeMap.put("多媒体/游戏开发工程师", "1001,1003,1019");
		jobTypeMap.put("网站营运经理/主管", "1001,1003,1020");
		jobTypeMap.put("网络工程师", "1001,1003,1021");
		jobTypeMap.put("系统管理员/网络管理员", "1001,1003,1022");
		jobTypeMap.put("网站策划", "1001,1003,1023");
		jobTypeMap.put("网站编辑", "1001,1003,1024");
		jobTypeMap.put("网页设计/制作/美工", "1001,1003,1025");
		jobTypeMap.put("网络信息安全工程师", "1001,1003,1026");
		jobTypeMap.put("网站架构设计师", "1001,1003,1027");
		jobTypeMap.put("网站维护工程师", "1001,1003,1028");
		jobTypeMap.put("语音/视频开发工程师", "1001,1003,1029");
		jobTypeMap.put("UI设计师/顾问", "1001,1003,1030");
		jobTypeMap.put("网站营运专员", "1001,1003,1031");
		jobTypeMap.put("脚本开发工程师", "1001,1003,1032");
		jobTypeMap.put("游戏策划师", "1001,1003,1033");
		jobTypeMap.put("游戏界面设计师", "1001,1003,1034");
		jobTypeMap.put("Flash设计/开发", "1001,1003,1035");
		jobTypeMap.put("特效设计师", "1001,1003,1036");
		jobTypeMap.put("视觉设计师", "1001,1003,1037");
		jobTypeMap.put("音效设计师", "1001,1003,1038");
		jobTypeMap.put("SEO搜索引擎优化", "1001,1003,1039");
		jobTypeMap.put("产品经理/主管", "1001,1003,1040");
		jobTypeMap.put("产品专员", "1001,1003,1041");
		jobTypeMap.put("电子商务经理/主管", "1001,1003,1042");
		jobTypeMap.put("电子商务专员", "1001,1003,1043");
		jobTypeMap.put("网店店长/客服", "1001,1003,1044");
		jobTypeMap.put("网站营运总监", "1001,1003,1045");
		jobTypeMap.put("产品总监", "1001,1003,1046");
		jobTypeMap.put("网络推广总监", "1001,1003,1047");
		jobTypeMap.put("网络推广经理/主管", "1001,1003,1048");
		jobTypeMap.put("网络推广专员", "1001,1003,1049");
		jobTypeMap.put("电子商务总监", "1001,1003,1050");
		jobTypeMap.put("交互设计师", "1001,1003,1051");
		jobTypeMap.put("其他", "1001,1003,1052");
		jobTypeMap.put("IT-管理", "1001,1004");
		jobTypeMap.put("首席技术执行官CTO/首席信息官CIO", "1001,1004,1053");
		jobTypeMap.put("技术总监/经理", "1001,1004,1054");
		jobTypeMap.put("信息技术经理/主管", "1001,1004,1055");
		jobTypeMap.put("信息技术专员", "1001,1004,1056");
		jobTypeMap.put("项目总监", "1001,1004,1057");
		jobTypeMap.put("项目经理", "1001,1004,1058");
		jobTypeMap.put("项目主管", "1001,1004,1059");
		jobTypeMap.put("项目执行/协调人员", "1001,1004,1060");
		jobTypeMap.put("其他", "1001,1004,1061");
		jobTypeMap.put("IT-品管、技术支持及其它", "1001,1005");
		jobTypeMap.put("技术支持/维护经理", "1001,1005,1062");
		jobTypeMap.put("技术支持/维护工程师", "1001,1005,1063");
		jobTypeMap.put("计量工程师", "1001,1005,1064");
		jobTypeMap.put("标准化工程师", "1001,1005,1065");
		jobTypeMap.put("品质经理", "1001,1005,1066");
		jobTypeMap.put("系统测试", "1001,1005,1067");
		jobTypeMap.put("软件测试", "1001,1005,1068");
		jobTypeMap.put("硬件测试", "1001,1005,1069");
		jobTypeMap.put("测试员", "1001,1005,1070");
		jobTypeMap.put("技术文员/助理", "1001,1005,1071");
		jobTypeMap.put("Helpdesk 技术支持", "1001,1005,1072");
		jobTypeMap.put("文档工程师", "1001,1005,1073");
		jobTypeMap.put("其他", "1001,1005,1074");
		jobTypeMap.put("通信技术开发及应用", "1001,1006");
		jobTypeMap.put("通信技术工程师", "1001,1006,1075");
		jobTypeMap.put("有线传输工程师", "1001,1006,1076");
		jobTypeMap.put("无线通信工程师", "1001,1006,1077");
		jobTypeMap.put("电信交换工程师", "1001,1006,1078");
		jobTypeMap.put("数据通信工程师", "1001,1006,1079");
		jobTypeMap.put("移动通信工程师", "1001,1006,1080");
		jobTypeMap.put("电信网络工程师", "1001,1006,1081");
		jobTypeMap.put("通信电源工程师", "1001,1006,1082");
		jobTypeMap.put("增值产品开发工程师", "1001,1006,1083");
		jobTypeMap.put("手机软件开发工程师", "1001,1006,1084");
		jobTypeMap.put("手机应用开发工程师师", "1001,1006,1085");
		jobTypeMap.put("其他", "1001,1006,1086");
		jobTypeMap.put("电子/电器/半导体/仪器仪表", "1001,1007");
		jobTypeMap.put("集成电路IC设计/应用工程师", "1001,1007,1087");
		jobTypeMap.put("IC验证工程师", "1001,1007,1088");
		jobTypeMap.put("电子工程师/技术员", "1001,1007,1089");
		jobTypeMap.put("电气工程师/技术员", "1001,1007,1090");
		jobTypeMap.put("电路工程师/技术员(模拟/数字)", "1001,1007,1091");
		jobTypeMap.put("电声/音响工程师/技术员", "1001,1007,1092");
		jobTypeMap.put("半导体技术", "1001,1007,1093");
		jobTypeMap.put("自动控制工程师/技术员", "1001,1007,1094");
		jobTypeMap.put("电子软件开发(ARM/MCU...)", "1001,1007,1095");
		jobTypeMap.put("嵌入式软件开发(Linux/单片机/DLC/DSP…)", "1001,1007,1096");
		jobTypeMap.put("电池/电源开发", "1001,1007,1097");
		jobTypeMap.put("FAE 现场应用工程师发", "1001,1007,1098");
		jobTypeMap.put("家用电器/数码产品研发", "1001,1007,1099");
		jobTypeMap.put("仪器/仪表/计量分析师", "1001,1007,1100");
		jobTypeMap.put("测试工程师", "1001,1007,1101");
		jobTypeMap.put("电子技术研发工程师", "1001,1007,1102");
		jobTypeMap.put("激光/光电子技术", "1001,1007,1103");
		jobTypeMap.put("嵌入式硬件开发(主板机…)", "1001,1007,1104");
		jobTypeMap.put("电子/电器维修工程师/技师", "1001,1007,1105");
		jobTypeMap.put("变压器与磁电工程师", "1001,1007,1106");
		jobTypeMap.put("版图设计工程师", "1001,1007,1107");
		jobTypeMap.put("工艺工程师", "1001,1007,1108");
		jobTypeMap.put("射频工程师", "1001,1007,1109");
		jobTypeMap.put("其他", "1001,1007,1110");
		jobTypeMap.put("销售/客服/技术支持", "1002");
		jobTypeMap.put("销售管理", "1002,1008");
		jobTypeMap.put("销售总监", "1002,1008,1111");
		jobTypeMap.put("销售经理", "1002,1008,1112");
		jobTypeMap.put("销售主管", "1002,1008,1113");
		jobTypeMap.put("业务拓展主管/经理", "1002,1008,1114");
		jobTypeMap.put("渠道/分销总监理", "1002,1008,1115");
		jobTypeMap.put("渠道/分销经理", "1002,1008,1116");
		jobTypeMap.put("渠道/分销主管", "1002,1008,1117");
		jobTypeMap.put("大客户销售管理", "1002,1008,1118");
		jobTypeMap.put("客户经理/主管", "1002,1008,1119");
		jobTypeMap.put("区域销售总监", "1002,1008,1120");
		jobTypeMap.put("区域销售经理", "1002,1008,1121");
		jobTypeMap.put("团购经理/主管", "1002,1008,1122");
		jobTypeMap.put("其他", "1002,1008,1123");
		jobTypeMap.put("销售人员", "1002,1009");
		jobTypeMap.put("销售代表", "1002,1009,1124");
		jobTypeMap.put("渠道/分销专员", "1002,1009,1125");
		jobTypeMap.put("客户代表", "1002,1009,1126");
		jobTypeMap.put("销售工程师", "1002,1009,1127");
		jobTypeMap.put("电话销售", "1002,1009,1128");
		jobTypeMap.put("经销商", "1002,1009,1129");
		jobTypeMap.put("团购业务员", "1002,1009,1130");
		jobTypeMap.put("大客户销售", "1002,1009,1131");
		jobTypeMap.put("其他", "1002,1009,1132");
		jobTypeMap.put("销售行政及商务", "1002,1010");
		jobTypeMap.put("销售行政经理/主管", "1002,1010,1133");
		jobTypeMap.put("销售行政专员/助理", "1002,1010,1134");
		jobTypeMap.put("商务经理", "1002,1010,1135");
		jobTypeMap.put("商务主管/专员", "1002,1010,1136");
		jobTypeMap.put("商务助理", "1002,1010,1137");
		jobTypeMap.put("销售助理", "1002,1010,1138");
		jobTypeMap.put("业务分析经理/主管", "1002,1010,1139");
		jobTypeMap.put("业务分析专员/助理", "1002,1010,1140");
		jobTypeMap.put("其他", "1002,1010,1141");
		jobTypeMap.put("客服及技术支持", "1002,1011");
		jobTypeMap.put("客服总监(非技术)", "1002,1011,1142");
		jobTypeMap.put("客服经理(非技术)", "1002,1011,1143");
		jobTypeMap.put("客服主管(非技术)", "1002,1011,1144");
		jobTypeMap.put("客服专员/助理(非技术)", "1002,1011,1145");
		jobTypeMap.put("售前/售后技术支持经理", "1002,1011,1146");
		jobTypeMap.put("售前/售后技术支持主管", "1002,1011,1147");
		jobTypeMap.put("售前/售后技术支持工程师", "1002,1011,1148");
		jobTypeMap.put("咨询热线/呼叫中心服务人员", "1002,1011,1149");
		jobTypeMap.put("客户关系经理/主管", "1002,1011,1150");
		jobTypeMap.put("投诉专员", "1002,1011,1151");
		jobTypeMap.put("VIP专员", "1002,1011,1152");
		jobTypeMap.put("其他", "1002,1011,1153");
		jobTypeMap.put("会计/金融/银行/保险", "1003");
		jobTypeMap.put("财务/审计/税务", "1003,1012");
		jobTypeMap.put("首席财务官 CFO", "1003,1012,1154");
		jobTypeMap.put("财务总监", "1003,1012,1155");
		jobTypeMap.put("财务经理", "1003,1012,1156");
		jobTypeMap.put("财务顾问", "1003,1012,1157");
		jobTypeMap.put("财务主管/总帐主管", "1003,1012,1158");
		jobTypeMap.put("会计经理/会计主管", "1003,1012,1159");
		jobTypeMap.put("会计", "1003,1012,1160");
		jobTypeMap.put("出纳员", "1003,1012,1161");
		jobTypeMap.put("财务/会计助理", "1003,1012,1162");
		jobTypeMap.put("会计文员", "1003,1012,1163");
		jobTypeMap.put("固定资产会计", "1003,1012,1164");
		jobTypeMap.put("财务分析经理/主管", "1003,1012,1165");
		jobTypeMap.put("财务分析员", "1003,1012,1166");
		jobTypeMap.put("成本经理/成本主管", "1003,1012,1167");
		jobTypeMap.put("成本管理员", "1003,1012,1168");
		jobTypeMap.put("资金经理/主管", "1003,1012,1169");
		jobTypeMap.put("资金专员", "1003,1012,1170");
		jobTypeMap.put("审计经理/主管", "1003,1012,1171");
		jobTypeMap.put("审计专员/助理", "1003,1012,1172");
		jobTypeMap.put("税务经理/税务主管", "1003,1012,1173");
		jobTypeMap.put("税务专员/助理", "1003,1012,1174");
		jobTypeMap.put("统计员", "1003,1012,1175");
		jobTypeMap.put("其他", "1003,1012,1176");
		jobTypeMap.put("金融/证券/期货/投资", "1003,1013");
		jobTypeMap.put("证券/期货/外汇经纪人", "1003,1013,1177");
		jobTypeMap.put("证券分析师", "1003,1013,1178");
		jobTypeMap.put("股票/期货操盘手", "1003,1013,1179");
		jobTypeMap.put("金融/经济研究员", "1003,1013,1180");
		jobTypeMap.put("投资/基金项目经理", "1003,1013,1181");
		jobTypeMap.put("投资/理财顾问", "1003,1013,1182");
		jobTypeMap.put("投资银行业务", "1003,1013,1183");
		jobTypeMap.put("融资经理/融资主管", "1003,1013,1184");
		jobTypeMap.put("融资专员", "1003,1013,1185");
		jobTypeMap.put("拍卖/担保/典当业务", "1003,1013,1186");
		jobTypeMap.put("金融产品经理", "1003,1013,1187");
		jobTypeMap.put("其他", "1003,1013,1188");
		jobTypeMap.put("银行", "1003,1014");
		jobTypeMap.put("行长/副行长", "1003,1014,1189");
		jobTypeMap.put("资产评估/分析", "1003,1014,1190");
		jobTypeMap.put("风险控制", "1003,1014,1191");
		jobTypeMap.put("进出口/信用证结算", "1003,1014,1192");
		jobTypeMap.put("清算人员", "1003,1014,1193");
		jobTypeMap.put("外汇交易", "1003,1014,1194");
		jobTypeMap.put("高级客户经理/客户经理", "1003,1014,1195");
		jobTypeMap.put("客户主管/专员", "1003,1014,1196");
		jobTypeMap.put("信贷管理", "1003,1014,1197");
		jobTypeMap.put("银行柜员", "1003,1014,1198");
		jobTypeMap.put("银行卡、电子银行业务推广", "1003,1014,1199");
		jobTypeMap.put("个人业务部门经理/主管", "1003,1014,1200");
		jobTypeMap.put("个人业务客户经理", "1003,1014,1201");
		jobTypeMap.put("公司业务部门经理/主管", "1003,1014,1202");
		jobTypeMap.put("公司业务客户经理", "1003,1014,1203");
		jobTypeMap.put("综合业务经理/主管", "1003,1014,1204");
		jobTypeMap.put("综合业务专员", "1003,1014,1205");
		jobTypeMap.put("信审核查", "1003,1014,1206");
		jobTypeMap.put("营业部大堂经理", "1003,1014,1207");
		jobTypeMap.put("其他", "1003,1014,1208");
		jobTypeMap.put("保险", "1003,1015");
		jobTypeMap.put("保险精算师", "1003,1015,1209");
		jobTypeMap.put("保险产品开发/项目策划", "1003,1015,1210");
		jobTypeMap.put("保险业务经理/主管", "1003,1015,1211");
		jobTypeMap.put("保险代理/经纪人/客户经理", "1003,1015,1212");
		jobTypeMap.put("理财顾问/财务规划师", "1003,1015,1213");
		jobTypeMap.put("储备经理人", "1003,1015,1214");
		jobTypeMap.put("保险核保", "1003,1015,1215");
		jobTypeMap.put("保险理赔", "1003,1015,1216");
		jobTypeMap.put("保险客户服务/续期管理", "1003,1015,1217");
		jobTypeMap.put("保险培训师", "1003,1015,1218");
		jobTypeMap.put("保险内勤", "1003,1015,1219");
		jobTypeMap.put("契约管理", "1003,1015,1220");
		jobTypeMap.put("其他", "1003,1015,1221");
		jobTypeMap.put("生产/营运/采购/物流", "1004");
		jobTypeMap.put("生产/营运", "1004,1016");
		jobTypeMap.put("工厂经理/厂长", "1004,1016,1222");
		jobTypeMap.put("总工程师/副总工程师", "1004,1016,1223");
		jobTypeMap.put("项目经理/主管", "1004,1016,1224");
		jobTypeMap.put("项目工程师", "1004,1016,1225");
		jobTypeMap.put("营运经理", "1004,1016,1226");
		jobTypeMap.put("营运主管", "1004,1016,1227");
		jobTypeMap.put("生产经理/车间主任", "1004,1016,1228");
		jobTypeMap.put("生产计划/物料管理(PMC)", "1004,1016,1229");
		jobTypeMap.put("生产主管/督导/领班/组长", "1004,1016,1230");
		jobTypeMap.put("化验员", "1004,1016,1231");
		jobTypeMap.put("生产文员", "1004,1016,1232");
		jobTypeMap.put("项目总监", "1004,1016,1233");
		jobTypeMap.put("生产总监", "1004,1016,1234");
		jobTypeMap.put("其他", "1004,1016,1235");
		jobTypeMap.put("质量管理/安全防护", "1004,1017");
		jobTypeMap.put("质量管理/测试经理(QA/QC经理)", "1004,1017,1236");
		jobTypeMap.put("质量管理/测试主管(QA/QC主管)", "1004,1017,1237");
		jobTypeMap.put("质量管理/测试工程师(QA/QC工程师)", "1004,1017,1238");
		jobTypeMap.put("质量检验员/测试员", "1004,1017,1239");
		jobTypeMap.put("可靠度工程师", "1004,1017,1240");
		jobTypeMap.put("故障分析工程师", "1004,1017,1241");
		jobTypeMap.put("认证工程师/审核员", "1004,1017,1242");
		jobTypeMap.put("体系工程师/审核员", "1004,1017,1243");
		jobTypeMap.put("环境/健康/安全经理/主管（EHS）", "1004,1017,1244");
		jobTypeMap.put("环境/健康/安全工程师（EHS）", "1004,1017,1245");
		jobTypeMap.put("供应商管理", "1004,1017,1246");
		jobTypeMap.put("采购材料、设备质量管理", "1004,1017,1247");
		jobTypeMap.put("安全防护", "1004,1017,1248");
		jobTypeMap.put("其他", "1004,1017,1249");
		jobTypeMap.put("工程/机械/能源", "1004,1018");
		jobTypeMap.put("技术研发经理/主管", "1004,1018,1250");
		jobTypeMap.put("技术研发工程师", "1004,1018,1251");
		jobTypeMap.put("产品工艺/制程工程师", "1004,1018,1252");
		jobTypeMap.put("产品规划工程师", "1004,1018,1253");
		jobTypeMap.put("项目管理", "1004,1018,1254");
		jobTypeMap.put("实验室负责人/工程师", "1004,1018,1255");
		jobTypeMap.put("工程/设备经理", "1004,1018,1256");
		jobTypeMap.put("工程/设备主管", "1004,1018,1257");
		jobTypeMap.put("工程/设备工程师", "1004,1018,1258");
		jobTypeMap.put("工程/机械绘图员", "1004,1018,1259");
		jobTypeMap.put("工业工程师", "1004,1018,1260");
		jobTypeMap.put("材料工程师", "1004,1018,1261");
		jobTypeMap.put("机械工程师", "1004,1018,1262");
		jobTypeMap.put("结构工程师", "1004,1018,1263");
		jobTypeMap.put("模具工程师", "1004,1018,1264");
		jobTypeMap.put("机电工程师", "1004,1018,1265");
		jobTypeMap.put("维修经理/主管", "1004,1018,1266");
		jobTypeMap.put("维修工程师", "1004,1018,1267");
		jobTypeMap.put("装配工程师/技师", "1004,1018,1268");
		jobTypeMap.put("铸造/锻造工程师/技师", "1004,1018,1269");
		jobTypeMap.put("注塑工程师/技师", "1004,1018,1270");
		jobTypeMap.put("焊接工程师/技师", "1004,1018,1271");
		jobTypeMap.put("夹具工程师/技师", "1004,1018,1272");
		jobTypeMap.put("CNC工程师", "1004,1018,1273");
		jobTypeMap.put("冲压工程师/技师", "1004,1018,1274");
		jobTypeMap.put("锅炉工程师/技师", "1004,1018,1275");
		jobTypeMap.put("电力工程师/技术员", "1004,1018,1276");
		jobTypeMap.put("光源与照明工程", "1004,1018,1277");
		jobTypeMap.put("光伏系统工程师", "1004,1018,1278");
		jobTypeMap.put("汽车/摩托车工程师", "1004,1018,1279");
		jobTypeMap.put("船舶工程师", "1004,1018,1280");
		jobTypeMap.put("轨道交通工程师/技术员", "1004,1018,1281");
		jobTypeMap.put("飞机维修机械师", "1004,1018,1282");
		jobTypeMap.put("飞行器设计与制造", "1004,1018,1283");
		jobTypeMap.put("水利/水电工程师", "1004,1018,1284");
		jobTypeMap.put("石油天然气技术人员", "1004,1018,1285");
		jobTypeMap.put("矿产勘探/地质勘测工程师", "1004,1018,1286");
		jobTypeMap.put("其他", "1004,1018,1287");
		jobTypeMap.put("汽车", "1004,1019");
		jobTypeMap.put("汽车机构工程师", "1004,1019,1288");
		jobTypeMap.put("汽车设计工程师", "1004,1019,1289");
		jobTypeMap.put("汽车电子工程师", "1004,1019,1290");
		jobTypeMap.put("汽车质量管理", "1004,1019,1291");
		jobTypeMap.put("汽车安全性能工程师", "1004,1019,1292");
		jobTypeMap.put("汽车装配工艺工程师", "1004,1019,1293");
		jobTypeMap.put("汽车修理人员", "1004,1019,1294");
		jobTypeMap.put("4S店经理/维修站经理", "1004,1019,1295");
		jobTypeMap.put("汽车销售/经纪人", "1004,1019,1296");
		jobTypeMap.put("二手车评估师", "1004,1019,1297");
		jobTypeMap.put("汽车项目管理", "1004,1019,1298");
		jobTypeMap.put("售后服务/客户服务", "1004,1019,1299");
		jobTypeMap.put("其他", "1004,1019,1300");
		jobTypeMap.put("技工", "1004,1020");
		jobTypeMap.put("技工", "1004,1020,1301");
		jobTypeMap.put("钳工/机修工/钣金工", "1004,1020,1302");
		jobTypeMap.put("电焊工/铆焊工", "1004,1020,1303");
		jobTypeMap.put("车工/磨工/铣工/冲压工/锣工", "1004,1020,1304");
		jobTypeMap.put("模具工", "1004,1020,1305");
		jobTypeMap.put("电工", "1004,1020,1306");
		jobTypeMap.put("叉车工", "1004,1020,1307");
		jobTypeMap.put("空调工/电梯工/锅炉工", "1004,1020,1308");
		jobTypeMap.put("水工/木工/漆工", "1004,1020,1309");
		jobTypeMap.put("普工/操作工", "1004,1020,1310");
		jobTypeMap.put("裁缝印纺熨烫", "1004,1020,1311");
		jobTypeMap.put("汽车修理工", "1004,1020,1312");
		jobTypeMap.put("切割技工", "1004,1020,1313");
		jobTypeMap.put("其他", "1004,1020,1314");
		jobTypeMap.put("服装/纺织/皮革", "1004,1021");
		jobTypeMap.put("服装/纺织设计", "1004,1021,1315");
		jobTypeMap.put("面料辅料开发", "1004,1021,1316");
		jobTypeMap.put("面料辅料采购", "1004,1021,1317");
		jobTypeMap.put("服装/纺织/皮革跟单", "1004,1021,1318");
		jobTypeMap.put("质量管理/验货员(QA/QC)", "1004,1021,1319");
		jobTypeMap.put("板房/楦头/底格出格师", "1004,1021,1320");
		jobTypeMap.put("打样/制版", "1004,1021,1321");
		jobTypeMap.put("纸样师/车板工", "1004,1021,1322");
		jobTypeMap.put("裁床", "1004,1021,1323");
		jobTypeMap.put("电脑放码员", "1004,1021,1324");
		jobTypeMap.put("服装/纺织设计总监", "1004,1021,1325");
		jobTypeMap.put("服装/纺织/皮革工艺师", "1004,1021,1326");
		jobTypeMap.put("其他", "1004,1021,1327");
		jobTypeMap.put("采购", "1004,1022");
		jobTypeMap.put("采购总监", "1004,1022,1328");
		jobTypeMap.put("采购经理", "1004,1022,1329");
		jobTypeMap.put("采购主管", "1004,1022,1330");
		jobTypeMap.put("采购员", "1004,1022,1331");
		jobTypeMap.put("采购助理", "1004,1022,1332");
		jobTypeMap.put("买手", "1004,1022,1333");
		jobTypeMap.put("供应商开发", "1004,1022,1334");
		jobTypeMap.put("其他", "1004,1022,1335");
		jobTypeMap.put("贸易", "1004,1023");
		jobTypeMap.put("贸易/外贸经理/主管", "1004,1023,1336");
		jobTypeMap.put("贸易/外贸专员/助理", "1004,1023,1337");
		jobTypeMap.put("国内贸易人员", "1004,1023,1338");
		jobTypeMap.put("业务跟单经理", "1004,1023,1339");
		jobTypeMap.put("高级业务跟单", "1004,1023,1340");
		jobTypeMap.put("业务跟单", "1004,1023,1341");
		jobTypeMap.put("助理业务跟单", "1004,1023,1342");
		jobTypeMap.put("其他", "1004,1023,1343");
		jobTypeMap.put("物流/仓储", "1004,1024");
		jobTypeMap.put("物流总监", "1004,1024,1344");
		jobTypeMap.put("物流经理", "1004,1024,1345");
		jobTypeMap.put("物流主管", "1004,1024,1346");
		jobTypeMap.put("物流专员/助理", "1004,1024,1347");
		jobTypeMap.put("供应链总监", "1004,1024,1348");
		jobTypeMap.put("供应链经理", "1004,1024,1349");
		jobTypeMap.put("供应链主管/专员", "1004,1024,1350");
		jobTypeMap.put("物料经理", "1004,1024,1351");
		jobTypeMap.put("物料主管/专员", "1004,1024,1352");
		jobTypeMap.put("仓库经理/主管", "1004,1024,1353");
		jobTypeMap.put("仓库管理员", "1004,1024,1354");
		jobTypeMap.put("运输经理/主管", "1004,1024,1355");
		jobTypeMap.put("项目经理/主管", "1004,1024,1356");
		jobTypeMap.put("货运代理", "1004,1024,1357");
		jobTypeMap.put("集装箱业务", "1004,1024,1358");
		jobTypeMap.put("海关事务管理", "1004,1024,1359");
		jobTypeMap.put("报关与报检", "1004,1024,1360");
		jobTypeMap.put("单证员", "1004,1024,1361");
		jobTypeMap.put("船务/空运陆运操作", "1004,1024,1362");
		jobTypeMap.put("快递员", "1004,1024,1363");
		jobTypeMap.put("调度员", "1004,1024,1364");
		jobTypeMap.put("理货员", "1004,1024,1365");
		jobTypeMap.put("其他", "1004,1024,1366");
		jobTypeMap.put("生物/制药/医疗/护理", "1005");
		jobTypeMap.put("生物/制药/医疗器械", "1005,1025");
		jobTypeMap.put("生物工程/生物制药", "1005,1025,1367");
		jobTypeMap.put("医药技术研发管理人员", "1005,1025,1368");
		jobTypeMap.put("医药技术研发人员", "1005,1025,1369");
		jobTypeMap.put("临床研究员", "1005,1025,1370");
		jobTypeMap.put("临床协调员", "1005,1025,1371");
		jobTypeMap.put("药品注册", "1005,1025,1372");
		jobTypeMap.put("药品生产/质量管理", "1005,1025,1373");
		jobTypeMap.put("药品市场推广经理", "1005,1025,1374");
		jobTypeMap.put("药品市场推广主管/专员", "1005,1025,1375");
		jobTypeMap.put("医药销售经理/主管", "1005,1025,1376");
		jobTypeMap.put("医药销售代表", "1005,1025,1377");
		jobTypeMap.put("医疗器械市场推广", "1005,1025,1378");
		jobTypeMap.put("医疗器械销售代表", "1005,1025,1379");
		jobTypeMap.put("化学分析测试员", "1005,1025,1380");
		jobTypeMap.put("医疗器械注册", "1005,1025,1381");
		jobTypeMap.put("医疗器械生产/质量管理", "1005,1025,1382");
		jobTypeMap.put("医疗器械维修人员", "1005,1025,1383");
		jobTypeMap.put("医药招商", "1005,1025,1384");
		jobTypeMap.put("政府事务管理", "1005,1025,1385");
		jobTypeMap.put("招投标管理", "1005,1025,1386");
		jobTypeMap.put("临床数据分析员", "1005,1025,1387");
		jobTypeMap.put("医疗器械研发", "1005,1025,1388");
		jobTypeMap.put("医疗器械销售经理/主管", "1005,1025,1389");
		jobTypeMap.put("其他", "1005,1025,1390");
		jobTypeMap.put("化工", "1005,1026");
		jobTypeMap.put("化工技术应用/化工工程师", "1005,1026,1391");
		jobTypeMap.put("化工实验室研究员/技术员", "1005,1026,1392");
		jobTypeMap.put("涂料研发工程师", "1005,1026,1393");
		jobTypeMap.put("配色技术员", "1005,1026,1394");
		jobTypeMap.put("塑料工程师", "1005,1026,1395");
		jobTypeMap.put("化妆品研发", "1005,1026,1396");
		jobTypeMap.put("食品/饮料研发", "1005,1026,1397");
		jobTypeMap.put("造纸研发", "1005,1026,1398");
		jobTypeMap.put("其他", "1005,1026,1399");
		jobTypeMap.put("医院/医疗/护理", "1005,1027");
		jobTypeMap.put("内科医生", "1005,1027,1400");
		jobTypeMap.put("医院管理人员", "1005,1027,1401");
		jobTypeMap.put("药库主任/药剂师", "1005,1027,1402");
		jobTypeMap.put("护士/护理人员", "1005,1027,1403");
		jobTypeMap.put("麻醉医生", "1005,1027,1404");
		jobTypeMap.put("心理医生", "1005,1027,1405");
		jobTypeMap.put("医药学检验", "1005,1027,1406");
		jobTypeMap.put("针灸、推拿", "1005,1027,1407");
		jobTypeMap.put("营养师", "1005,1027,1408");
		jobTypeMap.put("兽医", "1005,1027,1409");
		jobTypeMap.put("外科医生", "1005,1027,1410");
		jobTypeMap.put("专科医生", "1005,1027,1411");
		jobTypeMap.put("牙科医生", "1005,1027,1412");
		jobTypeMap.put("美容整形师", "1005,1027,1413");
		jobTypeMap.put("理疗师", "1005,1027,1414");
		jobTypeMap.put("中医科医生", "1005,1027,1415");
		jobTypeMap.put("公共卫生/疾病控制", "1005,1027,1416");
		jobTypeMap.put("护理主任/护士长", "1005,1027,1417");
		jobTypeMap.put("儿科医生", "1005,1027,1418");
		jobTypeMap.put("验光师", "1005,1027,1419");
		jobTypeMap.put("放射科医师", "1005,1027,1420");
		jobTypeMap.put("其他", "1005,1027,1421");
		jobTypeMap.put("广告/市场/媒体/艺术", "1006");
		jobTypeMap.put("广告", "1006,1028");
		jobTypeMap.put("广告客户总监/副总监", "1006,1028,1422");
		jobTypeMap.put("广告客户经理", "1006,1028,1423");
		jobTypeMap.put("广告客户主管/专员", "1006,1028,1424");
		jobTypeMap.put("广告创意/设计经理", "1006,1028,1425");
		jobTypeMap.put("广告创意总监", "1006,1028,1426");
		jobTypeMap.put("广告创意/设计主管/专员", "1006,1028,1427");
		jobTypeMap.put("文案/策划", "1006,1028,1428");
		jobTypeMap.put("企业/业务发展经理", "1006,1028,1429");
		jobTypeMap.put("企业策划人员", "1006,1028,1430");
		jobTypeMap.put("美术指导", "1006,1028,1431");
		jobTypeMap.put("其他", "1006,1028,1432");
		jobTypeMap.put("公关/媒介", "1006,1029");
		jobTypeMap.put("公关经理", "1006,1029,1433");
		jobTypeMap.put("公关主管", "1006,1029,1434");
		jobTypeMap.put("公关专员", "1006,1029,1435");
		jobTypeMap.put("会务/会展经理", "1006,1029,1436");
		jobTypeMap.put("会务/会展主管", "1006,1029,1437");
		jobTypeMap.put("会务/会展专员", "1006,1029,1438");
		jobTypeMap.put("媒介经理", "1006,1029,1439");
		jobTypeMap.put("媒介主管", "1006,1029,1440");
		jobTypeMap.put("媒介专员", "1006,1029,1441");
		jobTypeMap.put("公关/媒介助理", "1006,1029,1442");
		jobTypeMap.put("媒介销售", "1006,1029,1443");
		jobTypeMap.put("活动策划", "1006,1029,1444");
		jobTypeMap.put("活动执行", "1006,1029,1445");
		jobTypeMap.put("其他", "1006,1029,1446");
		jobTypeMap.put("市场/营销", "1006,1030");
		jobTypeMap.put("市场/营销/拓展总监", "1006,1030,1447");
		jobTypeMap.put("市场/营销/拓展经理", "1006,1030,1448");
		jobTypeMap.put("市场/营销/拓展主管", "1006,1030,1449");
		jobTypeMap.put("市场/营销/拓展专员", "1006,1030,1450");
		jobTypeMap.put("市场助理", "1006,1030,1451");
		jobTypeMap.put("市场分析/调研人员", "1006,1030,1452");
		jobTypeMap.put("产品/品牌经理", "1006,1030,1453");
		jobTypeMap.put("产品/品牌主管", "1006,1030,1454");
		jobTypeMap.put("产品/品牌专员", "1006,1030,1455");
		jobTypeMap.put("市场通路经理/主管", "1006,1030,1456");
		jobTypeMap.put("市场通路专员", "1006,1030,1457");
		jobTypeMap.put("市场企划经理/主管", "1006,1030,1458");
		jobTypeMap.put("市场企划专员", "1006,1030,1459");
		jobTypeMap.put("促销经理", "1006,1030,1460");
		jobTypeMap.put("促销主管/督导", "1006,1030,1461");
		jobTypeMap.put("促销员/导购", "1006,1030,1462");
		jobTypeMap.put("选址拓展/新店开发", "1006,1030,1463");
		jobTypeMap.put("其他", "1006,1030,1464");
		jobTypeMap.put("影视/媒体", "1006,1031");
		jobTypeMap.put("影视策划/制作人员", "1006,1031,1465");
		jobTypeMap.put("导演/编导", "1006,1031,1466");
		jobTypeMap.put("艺术/设计总监", "1006,1031,1467");
		jobTypeMap.put("经纪人/星探", "1006,1031,1468");
		jobTypeMap.put("演员/模特/主持人", "1006,1031,1469");
		jobTypeMap.put("摄影师/摄像师", "1006,1031,1470");
		jobTypeMap.put("音效师", "1006,1031,1471");
		jobTypeMap.put("配音员", "1006,1031,1472");
		jobTypeMap.put("化妆师/造型师", "1006,1031,1473");
		jobTypeMap.put("后期制作", "1006,1031,1474");
		jobTypeMap.put("放映经理/主管", "1006,1031,1475");
		jobTypeMap.put("放映员", "1006,1031,1476");
		jobTypeMap.put("其他", "1006,1031,1477");
		jobTypeMap.put("写作/出版/印刷", "1006,1032");
		jobTypeMap.put("总编/副总编", "1006,1032,1478");
		jobTypeMap.put("编辑", "1006,1032,1479");
		jobTypeMap.put("记者", "1006,1032,1480");
		jobTypeMap.put("美术编辑", "1006,1032,1481");
		jobTypeMap.put("排版设计", "1006,1032,1482");
		jobTypeMap.put("校对/录入", "1006,1032,1483");
		jobTypeMap.put("出版/发行", "1006,1032,1484");
		jobTypeMap.put("电分操作员", "1006,1032,1485");
		jobTypeMap.put("印刷排版/制版", "1006,1032,1486");
		jobTypeMap.put("数码直印/菲林输出", "1006,1032,1487");
		jobTypeMap.put("打稿机操作员", "1006,1032,1488");
		jobTypeMap.put("调墨技师", "1006,1032,1489");
		jobTypeMap.put("印刷机械机长", "1006,1032,1490");
		jobTypeMap.put("晒版/拼版/装订/烫金技工", "1006,1032,1491");
		jobTypeMap.put("电话采编", "1006,1032,1492");
		jobTypeMap.put("作家/撰稿人", "1006,1032,1493");
		jobTypeMap.put("其他", "1006,1032,1494");
		jobTypeMap.put("艺术/设计", "1006,1033");
		jobTypeMap.put("平面设计总监", "1006,1033,1495");
		jobTypeMap.put("平面设计经理/主管", "1006,1033,1496");
		jobTypeMap.put("平面设计师", "1006,1033,1497");
		jobTypeMap.put("绘画", "1006,1033,1498");
		jobTypeMap.put("动画/3D设计", "1006,1033,1499");
		jobTypeMap.put("原画师", "1006,1033,1500");
		jobTypeMap.put("展览/展示/店面设计", "1006,1033,1501");
		jobTypeMap.put("多媒体设计", "1006,1033,1502");
		jobTypeMap.put("包装设计", "1006,1033,1503");
		jobTypeMap.put("工业/产品设计", "1006,1033,1504");
		jobTypeMap.put("工艺品/珠宝设计鉴定", "1006,1033,1505");
		jobTypeMap.put("家具/家居用品设计", "1006,1033,1506");
		jobTypeMap.put("玩具设计", "1006,1033,1507");
		jobTypeMap.put("其他", "1006,1033,1508");
		jobTypeMap.put("建筑/房地产", "1007");
		jobTypeMap.put("建筑装潢/市政建设", "1007,1034");
		jobTypeMap.put("建筑工程师", "1007,1034,1509");
		jobTypeMap.put("结构/土木/土建工程师", "1007,1034,1510");
		jobTypeMap.put("建筑机电工程师", "1007,1034,1511");
		jobTypeMap.put("给排水/暖通工程", "1007,1034,1512");
		jobTypeMap.put("工程造价师/预结算经理", "1007,1034,1513");
		jobTypeMap.put("建筑工程管理/项目经理", "1007,1034,1514");
		jobTypeMap.put("工程监理", "1007,1034,1515");
		jobTypeMap.put("室内设计", "1007,1034,1516");
		jobTypeMap.put("规划与设计", "1007,1034,1517");
		jobTypeMap.put("建筑制图/模型/渲染", "1007,1034,1518");
		jobTypeMap.put("施工员", "1007,1034,1519");
		jobTypeMap.put("园艺/园林/景观设计", "1007,1034,1520");
		jobTypeMap.put("公路/桥梁/港口/隧道工程", "1007,1034,1521");
		jobTypeMap.put("岩土工程", "1007,1034,1522");
		jobTypeMap.put("测绘/测量", "1007,1034,1523");
		jobTypeMap.put("建筑工程验收", "1007,1034,1524");
		jobTypeMap.put("幕墙工程师", "1007,1034,1525");
		jobTypeMap.put("高级建筑工程师/总工", "1007,1034,1526");
		jobTypeMap.put("预结算员", "1007,1034,1527");
		jobTypeMap.put("楼宇自动化", "1007,1034,1528");
		jobTypeMap.put("智能大厦/综合布线/安防/弱电", "1007,1034,1529");
		jobTypeMap.put("开发报建", "1007,1034,1530");
		jobTypeMap.put("合同管理", "1007,1034,1531");
		jobTypeMap.put("安全员", "1007,1034,1532");
		jobTypeMap.put("资料员", "1007,1034,1533");
		jobTypeMap.put("建筑设计师", "1007,1034,1534");
		jobTypeMap.put("市政工程师", "1007,1034,1535");
		jobTypeMap.put("其他", "1007,1034,1536");
		jobTypeMap.put("房地产", "1007,1035");
		jobTypeMap.put("房地产项目/开发/策划经理", "1007,1035,1537");
		jobTypeMap.put("房地产项目/开发/策划主管/专员", "1007,1035,1538");
		jobTypeMap.put("房产项目配套工程师", "1007,1035,1539");
		jobTypeMap.put("房地产评估", "1007,1035,1540");
		jobTypeMap.put("房地产中介/交易", "1007,1035,1541");
		jobTypeMap.put("房地产销售人员", "1007,1035,1542");
		jobTypeMap.put("房地产项目招投标", "1007,1035,1543");
		jobTypeMap.put("房地产销售经理/主管", "1007,1035,1544");
		jobTypeMap.put("房地产投资分析", "1007,1035,1545");
		jobTypeMap.put("房地产资产管理", "1007,1035,1546");
		jobTypeMap.put("其他", "1007,1035,1547");
		jobTypeMap.put("物业管理", "1007,1036");
		jobTypeMap.put("高级物业顾问/物业顾问", "1007,1036,1548");
		jobTypeMap.put("物业管理经理/主管", "1007,1036,1549");
		jobTypeMap.put("物业管理专员/助理", "1007,1036,1550");
		jobTypeMap.put("物业招商/租赁/租售", "1007,1036,1551");
		jobTypeMap.put("物业设施管理人员", "1007,1036,1552");
		jobTypeMap.put("物业维修人员", "1007,1036,1553");
		jobTypeMap.put("物业机电工程师", "1007,1036,1554");
		jobTypeMap.put("其他", "1007,1036,1555");
		jobTypeMap.put("人事/行政/高级管理", "1008");
		jobTypeMap.put("人力资源", "1008,1037");
		jobTypeMap.put("人事总监", "1008,1037,1556");
		jobTypeMap.put("人事经理", "1008,1037,1557");
		jobTypeMap.put("人事主管", "1008,1037,1558");
		jobTypeMap.put("人事专员", "1008,1037,1559");
		jobTypeMap.put("人事助理", "1008,1037,1560");
		jobTypeMap.put("招聘经理/主管", "1008,1037,1561");
		jobTypeMap.put("招聘专员/助理", "1008,1037,1562");
		jobTypeMap.put("薪资福利经理/主管", "1008,1037,1563");
		jobTypeMap.put("薪资福利专员/助理", "1008,1037,1564");
		jobTypeMap.put("绩效考核经理/主管", "1008,1037,1565");
		jobTypeMap.put("绩效考核专员/助理", "1008,1037,1566");
		jobTypeMap.put("培训经理/主管", "1008,1037,1567");
		jobTypeMap.put("培训专员/助理/培训师", "1008,1037,1568");
		jobTypeMap.put("企业文化/员工关系/工会管理", "1008,1037,1569");
		jobTypeMap.put("人力资源信息系统专员", "1008,1037,1570");
		jobTypeMap.put("其他", "1008,1037,1571");
		jobTypeMap.put("高级管理", "1008,1038");
		jobTypeMap.put("首席执行官CEO/总裁/总经理", "1008,1038,1572");
		jobTypeMap.put("首席运营官COO", "1008,1038,1573");
		jobTypeMap.put("副总经理/副总裁", "1008,1038,1574");
		jobTypeMap.put("合伙人", "1008,1038,1575");
		jobTypeMap.put("总监/部门经理", "1008,1038,1576");
		jobTypeMap.put("策略发展总监", "1008,1038,1577");
		jobTypeMap.put("企业秘书/董事会秘书", "1008,1038,1578");
		jobTypeMap.put("投资者关系", "1008,1038,1579");
		jobTypeMap.put("办事处首席代表", "1008,1038,1580");
		jobTypeMap.put("办事处/分公司/分支机构经理", "1008,1038,1581");
		jobTypeMap.put("总裁助理/总经理助理", "1008,1038,1582");
		jobTypeMap.put("其他", "1008,1038,1583");
		jobTypeMap.put("行政/后勤", "1008,1039");
		jobTypeMap.put("行政总监", "1008,1039,1584");
		jobTypeMap.put("行政经理/主管/办公室主任", "1008,1039,1585");
		jobTypeMap.put("行政专员/助理", "1008,1039,1586");
		jobTypeMap.put("经理助理/秘书", "1008,1039,1587");
		jobTypeMap.put("前台接待/总机/接待生", "1008,1039,1588");
		jobTypeMap.put("后勤", "1008,1039,1589");
		jobTypeMap.put("图书管理员/资料管理员", "1008,1039,1590");
		jobTypeMap.put("电脑操作员/打字员/文员", "1008,1039,1591");
		jobTypeMap.put("其他", "1008,1039,1592");
		jobTypeMap.put("咨询/法律/教育/科研", "1009");
		jobTypeMap.put("咨询/顾问", "1009,1040");
		jobTypeMap.put("专业顾问", "1009,1040,1593");
		jobTypeMap.put("咨询总监", "1009,1040,1594");
		jobTypeMap.put("咨询经理", "1009,1040,1595");
		jobTypeMap.put("咨询员", "1009,1040,1596");
		jobTypeMap.put("专业培训师", "1009,1040,1597");
		jobTypeMap.put("情报信息分析人员", "1009,1040,1598");
		jobTypeMap.put("猎头/人才中介", "1009,1040,1599");
		jobTypeMap.put("调研员", "1009,1040,1600");
		jobTypeMap.put("其他", "1009,1040,1601");
		jobTypeMap.put("律师/法务/合规", "1009,1041");
		jobTypeMap.put("律师/法律顾问", "1009,1041,1602");
		jobTypeMap.put("法务主管/专员", "1009,1041,1603");
		jobTypeMap.put("律师助理", "1009,1041,1604");
		jobTypeMap.put("法务经理", "1009,1041,1605");
		jobTypeMap.put("法务助理", "1009,1041,1606");
		jobTypeMap.put("知识产权/专利/商标", "1009,1041,1607");
		jobTypeMap.put("合规经理", "1009,1041,1608");
		jobTypeMap.put("合规主管/专员", "1009,1041,1609");
		jobTypeMap.put("其他", "1009,1041,1610");
		jobTypeMap.put("教师", "1009,1042");
		jobTypeMap.put("中学教师", "1009,1042,1611");
		jobTypeMap.put("院校教务管理人员", "1009,1042,1612");
		jobTypeMap.put("讲师/助教", "1009,1042,1613");
		jobTypeMap.put("家教", "1009,1042,1614");
		jobTypeMap.put("幼教", "1009,1042,1615");
		jobTypeMap.put("大学教授", "1009,1042,1616");
		jobTypeMap.put("小学教师", "1009,1042,1617");
		jobTypeMap.put("兼职教师", "1009,1042,1618");
		jobTypeMap.put("职业技术教师", "1009,1042,1619");
		jobTypeMap.put("校长", "1009,1042,1620");
		jobTypeMap.put("音乐/美术教师", "1009,1042,1621");
		jobTypeMap.put("外语培训师", "1009,1042,1622");
		jobTypeMap.put("其他", "1009,1042,1623");
		jobTypeMap.put("培训", "1009,1043");
		jobTypeMap.put("培训督导", "1009,1043,1624");
		jobTypeMap.put("培训讲师", "1009,1043,1625");
		jobTypeMap.put("培训策划", "1009,1043,1626");
		jobTypeMap.put("培训助理", "1009,1043,1627");
		jobTypeMap.put("培训/课程顾问", "1009,1043,1628");
		jobTypeMap.put("培训产品开发", "1009,1043,1629");
		jobTypeMap.put("其他", "1009,1043,1630");
		jobTypeMap.put("科研人员", "1009,1044");
		jobTypeMap.put("科研人员", "1009,1044,1631");
		jobTypeMap.put("科研管理人员", "1009,1044,1632");
		jobTypeMap.put("服务业", "1010");
		jobTypeMap.put("餐饮/娱乐", "1010,1045");
		jobTypeMap.put("餐饮/娱乐管理", "1010,1045,1633");
		jobTypeMap.put("餐饮/娱乐领班/部长", "1010,1045,1634");
		jobTypeMap.put("餐饮/娱乐服务员", "1010,1045,1635");
		jobTypeMap.put("礼仪/迎宾", "1010,1045,1636");
		jobTypeMap.put("司仪", "1010,1045,1637");
		jobTypeMap.put("行政主厨/厨师长", "1010,1045,1638");
		jobTypeMap.put("厨师/面点师", "1010,1045,1639");
		jobTypeMap.put("调酒师/侍酒师/吧台员", "1010,1045,1640");
		jobTypeMap.put("茶艺师", "1010,1045,1641");
		jobTypeMap.put("传菜主管/传菜员", "1010,1045,1642");
		jobTypeMap.put("厨师助理/学徒", "1010,1045,1643");
		jobTypeMap.put("其他", "1010,1045,1644");
		jobTypeMap.put("酒店/旅游", "1010,1046");
		jobTypeMap.put("酒店/宾馆经理", "1010,1046,1645");
		jobTypeMap.put("酒店/宾馆营销", "1010,1046,1646");
		jobTypeMap.put("大堂经理", "1010,1046,1647");
		jobTypeMap.put("楼面经理", "1010,1046,1648");
		jobTypeMap.put("前厅接待", "1010,1046,1649");
		jobTypeMap.put("客房服务员/楼面服务员", "1010,1046,1650");
		jobTypeMap.put("行李员", "1010,1046,1651");
		jobTypeMap.put("清洁服务人员", "1010,1046,1652");
		jobTypeMap.put("导游/旅行顾问", "1010,1046,1653");
		jobTypeMap.put("票务/订房服务", "1010,1046,1654");
		jobTypeMap.put("宴会管理", "1010,1046,1655");
		jobTypeMap.put("机场代表", "1010,1046,1656");
		jobTypeMap.put("管家部经理/主管", "1010,1046,1657");
		jobTypeMap.put("宾客服务经理", "1010,1046,1658");
		jobTypeMap.put("预定部主管", "1010,1046,1659");
		jobTypeMap.put("预定员", "1010,1046,1660");
		jobTypeMap.put("健身房服务", "1010,1046,1661");
		jobTypeMap.put("旅游产品销售", "1010,1046,1662");
		jobTypeMap.put("行程管理/计调", "1010,1046,1663");
		jobTypeMap.put("签证专员", "1010,1046,1664");
		jobTypeMap.put("其他", "1010,1046,1665");
		jobTypeMap.put("美容/健身/体育", "1010,1047");
		jobTypeMap.put("美容顾问/化妆", "1010,1048");
		jobTypeMap.put("美容顾问/化妆", "1010,1047,1666");
		jobTypeMap.put("美容助理/见席美容师", "1010,1047,1667");
		jobTypeMap.put("瘦身顾问", "1010,1047,1668");
		jobTypeMap.put("发型师问", "1010,1047,1669");
		jobTypeMap.put("发型助理/学徒", "1010,1047,1670");
		jobTypeMap.put("美甲师", "1010,1047,1671");
		jobTypeMap.put("按摩/足疗", "1010,1047,1672");
		jobTypeMap.put("健身顾问/教练", "1010,1047,1673");
		jobTypeMap.put("瑜伽/舞蹈老师", "1010,1047,1674");
		jobTypeMap.put("宠物护理/美容", "1010,1047,1675");
		jobTypeMap.put("体育运动教练", "1010,1047,1676");
		jobTypeMap.put("彩妆培训师", "1010,1047,1677");
		jobTypeMap.put("专柜彩妆顾问(BA)", "1010,1047,1678");
		jobTypeMap.put("救生员", "1010,1047,1679");
		jobTypeMap.put("美容导师", "1010,1047,1680");
		jobTypeMap.put("其他", "1010,1047,1681");
		jobTypeMap.put("百货/连锁/零售服务", "1010,1048");
		jobTypeMap.put("店长/卖场经理/楼面管理", "1010,1048,1682");
		jobTypeMap.put("店员/营业员", "1010,1048,1683");
		jobTypeMap.put("收银主管/收银员", "1010,1048,1684");
		jobTypeMap.put("理货员/陈列员/收货员", "1010,1048,1685");
		jobTypeMap.put("导购员", "1010,1048,1686");
		jobTypeMap.put("兼职店员", "1010,1048,1687");
		jobTypeMap.put("防损员/内保", "1010,1048,1688");
		jobTypeMap.put("西点师/面包糕点加工", "1010,1048,1689");
		jobTypeMap.put("熟食加工", "1010,1048,1690");
		jobTypeMap.put("品类经理", "1010,1048,1691");
		jobTypeMap.put("安防主管", "1010,1048,1692");
		jobTypeMap.put("其他", "1010,1048,1693");
		jobTypeMap.put("交通运输服务", "1010,1049");
		jobTypeMap.put("乘务员", "1010,1049,1694");
		jobTypeMap.put("司机", "1010,1049,1695");
		jobTypeMap.put("飞机机长/副机长", "1010,1049,1696");
		jobTypeMap.put("空乘人员", "1010,1049,1697");
		jobTypeMap.put("地勤人员", "1010,1049,1698");
		jobTypeMap.put("列车/地铁车长", "1010,1049,1699");
		jobTypeMap.put("列车/地铁司机", "1010,1049,1700");
		jobTypeMap.put("船长/副船长", "1010,1049,1701");
		jobTypeMap.put("船员", "1010,1049,1702");
		jobTypeMap.put("其他", "1010,1049,1703");
		jobTypeMap.put("保安/家政/其他服务", "1010,1050");
		jobTypeMap.put("保安人员", "1010,1050,1704");
		jobTypeMap.put("保镖", "1010,1050,1705");
		jobTypeMap.put("寻呼员/话务员", "1010,1050,1706");
		jobTypeMap.put("搬运工", "1010,1050,1707");
		jobTypeMap.put("清洁工", "1010,1050,1708");
		jobTypeMap.put("家政服务/保姆", "1010,1050,1709");
		jobTypeMap.put("保安经理", "1010,1050,1710");
		jobTypeMap.put("其他", "1010,1050,1711");
		jobTypeMap.put("公务员/翻译/其他", "1011");
		jobTypeMap.put("公务员", "1011,1051");
		jobTypeMap.put("公务员", "1011,1051,1712");
		jobTypeMap.put("翻译", "1011,1052");
		jobTypeMap.put("英语翻译", "1011,1052,1713");
		jobTypeMap.put("日语翻译", "1011,1052,1714");
		jobTypeMap.put("德语翻译", "1011,1052,1715");
		jobTypeMap.put("法语翻译译", "1011,1052,1716");
		jobTypeMap.put("俄语翻译", "1011,1052,1717");
		jobTypeMap.put("西班牙语翻译", "1011,1052,1718");
		jobTypeMap.put("韩语/朝鲜语翻译", "1011,1052,1719");
		jobTypeMap.put("阿拉伯语翻译", "1011,1052,1720");
		jobTypeMap.put("意大利语翻译", "1011,1052,1721");
		jobTypeMap.put("葡萄牙语翻译", "1011,1052,1722");
		jobTypeMap.put("泰语翻译", "1011,1052,1723");
		jobTypeMap.put("中国方言翻译", "1011,1052,1724");
		jobTypeMap.put("其他语种翻译", "1011,1052,1725");
		jobTypeMap.put("在校学生", "1011,1053");
		jobTypeMap.put("中专/职校生", "1011,1053,1726");
		jobTypeMap.put("大学/大专应届毕业生", "1011,1053,1727");
		jobTypeMap.put("研究生", "1011,1053,1728");
		jobTypeMap.put("其他", "1011,1053,1729");
		jobTypeMap.put("储备干部/培训生/实习生", "1011,1054");
		jobTypeMap.put("培训生", "1011,1054,1730");
		jobTypeMap.put("储备干部", "1011,1054,1731");
		jobTypeMap.put("实习生", "1011,1054,1732");
		jobTypeMap.put("兼职", "1011,1055");
		jobTypeMap.put("兼职", "1011,1055,1733");
		jobTypeMap.put("环保", "1011,1056");
		jobTypeMap.put("环保工程师", "1011,1056,1737");
		jobTypeMap.put("水处理工程师", "1011,1056,1738");
		jobTypeMap.put("环境影响评价工程师", "1011,1056,1739");
		jobTypeMap.put("环保检测", "1011,1056,1740");
		jobTypeMap.put("水质检测员", "1011,1056,1741");
		jobTypeMap.put("固废工程师", "1011,1056,1742");
		jobTypeMap.put("废气处理工程师", "1011,1056,1743");
		jobTypeMap.put("其它", "1011,1056,1744");
		jobTypeMap.put("农/林/牧/渔", "1011,1057");
		jobTypeMap.put("养殖部主管", "1011,1057,1745");
		jobTypeMap.put("场长(农/林/牧/渔业)", "1011,1057,1746");
		jobTypeMap.put("农艺师", "1011,1057,1747");
		jobTypeMap.put("畜牧师", "1011,1057,1748");
		jobTypeMap.put("饲养员", "1011,1057,1749");
		jobTypeMap.put("动物营养/饲料研发", "1011,1057,1750");
		jobTypeMap.put("其他", "1011,1057,1751");
		jobTypeMap.put("其他", "1011,1058");
		jobTypeMap.put("驯兽师/助理驯兽师", "1011,1058,1734");
		jobTypeMap.put("志愿者/社会工作者", "1011,1058,1735");
		jobTypeMap.put("其他", "1011,1058,1736");
		
		return jobTypeMap;
	}
	
	/**
	 * 
	* 获取城市集合
	* @param @return    设定文件 
	* @return Map<String,String>    返回类型 
	* @throws
	 */
	private Map<String, String> getCityMap() {
		Map<String, String> cityMap = Maps.newHashMap();
		cityMap.put("中山", "25,308");
		//cityMap.put("佛山", "25,296");
		//cityMap.put("江门", "25,297");
		
		return cityMap;
	}
	
}
