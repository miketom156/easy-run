package com.job5156.run.count;

import com.job5156.task.count.BackPvAccessData;
import org.apache.log4j.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: DJH
 * Date: 14-12-8
 * Time: 上午8:53
 *
 */
public class RunCleanData {
    private static Logger logger = Logger.getLogger(RunCleanData.class);

    public static void main(String args[]) {
    	try{
            BackPvAccessData backPvAccessData = new BackPvAccessData();
            backPvAccessData.cleanData();
            backPvAccessData = null;
    	}catch(Exception e){
    		e.printStackTrace();
    		logger.error("清理每天访问数据异常：" + e.getMessage(), e);
    	}
    }
}
