package com.job5156.run.count;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;

import com.job5156.common.util.HibernateCountUtil;
import com.job5156.common.util.HibernateSalveBaseUtil;
import com.job5156.task.count.CountPosResCategory;

/**
 * 职位/简历存量数据统计
 * @author Andy
 * 
 */
public class RunCountFromDay {
	 private static Logger logger = Logger.getLogger(RunCountFromDay.class);

	public static void main(String[] args) {
//		try{
//			logger.info("【"+ DateTime.now().toString("yyyy-MM-dd")+"】职位/简历存量数据统计开始：");
//			//存量统计
//			CountPosResCategory model = new CountPosResCategory();
//			model.saveStatistics();
//			model = null;
//			HibernateSalveBaseUtil.closeSession();
//			HibernateCountUtil.closeSession();
//			logger.info("【"+ DateTime.now().toString("yyyy-MM-dd")+"】职位/简历存量数据统计结束。");
//		}catch(Exception e){
//			logger.error("职位/简历存量数据统计出错：\n"+e.getMessage(),e);
//		}
	}
}
