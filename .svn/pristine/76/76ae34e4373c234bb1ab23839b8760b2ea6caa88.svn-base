package com.job5156.run.count;

import com.job5156.common.util.HibernateActionUtil;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;

import com.job5156.common.util.HibernateCountUtil;
import com.job5156.common.util.HibernateSalveBaseUtil;
import com.job5156.task.count.CountPosResCategory;

/**
 * Created with IntelliJ IDEA.
 * User: Andy
 * Date: 14-11-22
 * Time: 上午10:13
 * 职位/简历增量数据统计每周执行
 */
public class RunCountFromWeek {

    private static Logger logger = Logger.getLogger(RunCountFromWeek.class);

    public static void main(String args[]){
    	try{
			logger.info("【"+ DateTime.now().toString("yyyy-MM-dd")+"】职位/简历数据统计开始：");
			CountPosResCategory model = new CountPosResCategory();
			model.resPosStatistics();
			model = null;
            logger.info("【" + DateTime.now().toString("yyyy-MM-dd") + "】职位/简历数据统计结束。");
        }catch(Exception e){
            logger.error("职位/简历数据统计出错：\n" + e.getMessage(), e);
        }finally {
            HibernateActionUtil.closeSession();
            HibernateSalveBaseUtil.closeSession();
            HibernateCountUtil.closeSession();
        }



    }
}
