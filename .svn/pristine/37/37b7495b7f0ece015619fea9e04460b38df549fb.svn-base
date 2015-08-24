package com.job5156.task.count;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.job5156.common.CountJobCNConstants;
import com.job5156.common.util.HibernateCountUtil;
import com.job5156.model.count.CountPosResCateJobcn;
import com.job5156.model.temp.ComInfoCellect;
import com.job5156.task.collect.company.CompanyDataCellectBase;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.joda.time.DateTime;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 从卓博人才网采集东莞地区 所对应的最小岗位的数据统计
 * 
 * @author Andy
 * @version 1.0
 * 
 */
public class CountJobcnPostionCellect extends CompanyDataCellectBase {

	private static final Logger logger = Logger.getLogger(CountJobcnPostionCellect.class);
	// 搜索器url
	private static String DATACELLECTURL = "http://www.jobcn.com/search/result.xhtml?s=search/advanced";

	private static final int CONNECTION_TIMEOUT = 1000 * 5; // Http连接超时时间

	public static void main(String[] args) {
		logger.error("======卓博人才网职位数据统计程序开始======");
		long startMillSecond = System.currentTimeMillis();

		CountJobcnPostionCellect collect = new CountJobcnPostionCellect();
		collect.run();
		collect = null;

		long stopMillSecond = System.currentTimeMillis();
		logger.error("======卓博人才网职位数据统计程序结束，耗时"+ ((stopMillSecond - startMillSecond) / (60 * 1000))+ "分钟======");
	}

	public void run() {
		// 间隔时间
		setWaitTime(140);
		startCellectCompanyData();
		HibernateCountUtil.closeSession();
	}

	@Override
	public ComInfoCellect getComInfo(String html) {
		return null;
	}

	private void saveDownData(String html, CountJobcnPosVo vo) {
		try {
			Session session = HibernateCountUtil.currentSession();
			// 处理HTML中的回车及换行符
			html = html.replaceAll("(\r\n|\r\n\t|\r|\n|\t|\n\r)", "");
			ParseElement comInfoJsonElement = new ParseElement("_jsp.Group.init(", ")");
			String jobcnPosData = ParseUtils.parserValueByElement(html,comInfoJsonElement);
            if(StringUtils.isNotBlank(jobcnPosData)){
                Gson gson = new Gson();
                JsonObject object = gson.fromJson(jobcnPosData, JsonObject.class);

                if(null != object && object.has("choices")){
                    JsonElement choicesElement = object.get("choices");
                    if(choicesElement.getAsJsonObject().has("reqdegreeid")){
                        JsonElement reqdegreeidElement = choicesElement.getAsJsonObject().get("reqdegreeid");
                        if (null != reqdegreeidElement) {
                            JsonElement choicelistElement = reqdegreeidElement.getAsJsonObject().get("choicelist");
                            // 将json转换成List
                            List<Map<String, String>> listMap = gson.fromJson(choicelistElement,new TypeToken<List<Map<String, String>>>() {}.getType());
                            // 验证json MAP是否为空
                            if (CollectionUtils.isNotEmpty(listMap)) {
                                for (Map<String, String> map : listMap) {
                                    CountPosResCateJobcn jobcn = new CountPosResCateJobcn();
                                    jobcn.setWorkLocation(Integer.valueOf(vo.getWorkLaction()));
                                    if (StringUtils.isNotBlank(vo.getPosType()))
                                        jobcn.setPosType(Integer.valueOf(vo.getPosType()));
                                    jobcn.setJobcnPosType(Integer.valueOf(vo.getJobcnPostype()));
                                    jobcn.setPosName(vo.getPosName());
                                    if(Integer.valueOf(map.get("val")) % 10 > 0){
                                    	continue;
                                    }
                                    jobcn.setReqDegree(Integer.valueOf(map.get("val")));
                                    jobcn.setSavePosCount(Integer.valueOf(map.get("hits")));
                                    jobcn.setCreateDate(new Date());
                                    jobcn.setDataSource(ComType.JOBCN.getValue());
                                    session.save(jobcn);
                                }
                            } else {
                                logger.error("采集卓博职位【"+vo.getJobcnPostype()+"】数据为空，解析的JSON串为："+ jobcnPosData);
                            }
                        }
                    }
                }
            }
		} catch (Exception e) {
			logger.error("卓博职位数据采集时解析异常：", e);
		}
	}

	/**
	 * 
	 * 开始执行数据采集
	 * 
	 * @return void 返回类型
	 * @throws
	 */
	private void startCellectCompanyData() {
		long startTime = System.currentTimeMillis();
		logger.error("=====>开始启动卓博人才网东莞地区职位统计数据采集程序："+ DateTime.now().toString("yyyy-MM-dd HH:mm:ss"));
		Map<String, String> jobTypeMap = CountJobCNConstants.getJobTypeMap();
		for (String key : jobTypeMap.keySet()) {
			String[] jobTypes = jobTypeMap.get(key).split(",");// 岗位类别
			CountJobcnPosVo vo = new CountJobcnPosVo();
			vo.setJobLocationId("3002");
			vo.setWorkLaction("14010000");
			vo.setPosName(jobTypes[0]);
			vo.setJobcnPostype(key);
			if (jobTypes.length > 1 && null != jobTypes[1]) {
				vo.setPosType(jobTypes[1]);
			}

			cellectCompanyData(DATACELLECTURL, vo);
			//System.out.println("东莞地区数据下载---->岗位编号：" + key + "\t 岗位名称："+ jobTypes[0]);
		}
		long endTime = System.currentTimeMillis();
		long date = (endTime - startTime) % (60000l) == 0 ? (endTime - startTime) / (60000l): (endTime - startTime) / (60000l) + 1;
		logger.error("=====>卓博人才网东莞地区职位统计数据采集程序执行完毕："+ DateTime.now().toString("yyyy-MM-dd HH:mm:ss") + "\n 总共花费："+ date + "\t 分钟");
	}

	/**
	 * 
	 * 采集指定搜索URL中的所有企业信息
	 * 
	 * @param url
	 * @param vo
	 * @return List<ComInfoCellect> 返回类型
	 * 
	 */
	private void cellectCompanyData(String url, CountJobcnPosVo vo) {
		StringBuilder urlPackage = new StringBuilder(url);
		urlPackage.append("&p.jobLocationId=" + vo.getJobLocationId());
		urlPackage.append("&p.jobFunction=" + vo.getJobcnPostype());
		urlPackage.append("&p.degreeId1=10");
		urlPackage.append("&p.degreeId2=70");
		urlPackage.append("&p.posPostDate=30");
		PostMethod postMethod = getHcu().createHttpMethod(urlPackage.toString());
		postMethod.getParams().setIntParameter(HttpMethodParams.SO_TIMEOUT,new Integer(CONNECTION_TIMEOUT));
		String htmlContent = getHcu().executeMethod(postMethod);
		saveDownData(htmlContent, vo);
	}

	protected class CountJobcnPosVo {
		private String jobLocationId;// 卓博工作地区大类
		private String jobcnWorkLaction;// 卓博的工作地区（东莞地区城填）
		private String workLaction;// 对应网站的东莞地区
		private String jobcnPostype;// 卓博职位类别
		private String posType;// 网站的职位类别
		private String posName;
		private String degree;

		public String getJobLocationId() {
			return jobLocationId;
		}

		public void setJobLocationId(String jobLocationId) {
			this.jobLocationId = jobLocationId;
		}

		public String getJobcnWorkLaction() {
			return jobcnWorkLaction;
		}

		public void setJobcnWorkLaction(String jobcnWorkLaction) {
			this.jobcnWorkLaction = jobcnWorkLaction;
		}

		public String getWorkLaction() {
			return workLaction;
		}

		public void setWorkLaction(String workLaction) {
			this.workLaction = workLaction;
		}

		public String getJobcnPostype() {
			return jobcnPostype;
		}

		public void setJobcnPostype(String jobcnPostype) {
			this.jobcnPostype = jobcnPostype;
		}

		public String getPosType() {
			return posType;
		}

		public void setPosType(String posType) {
			this.posType = posType;
		}

		public String getPosName() {
			return posName;
		}

		public void setPosName(String posName) {
			this.posName = posName;
		}

		public String getDegree() {
			return degree;
		}

		public void setDegree(String degree) {
			this.degree = degree;
		}
	}
}