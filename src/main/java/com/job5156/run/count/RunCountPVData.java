package com.job5156.run.count;

import com.job5156.task.count.CountItemTask;
import org.apache.log4j.Logger;

import com.job5156.task.count.BackPvAccessData;
import com.job5156.task.count.CountPVData;
import com.job5156.task.count.CountPvCityAllData;

/**
 * Created with IntelliJ IDEA.
 * User: DJH
 * Date: 14-11-24
 * Time: 上午9:04
 * pv统计入口类
 */
public class RunCountPVData {

    private static Logger logger = Logger.getLogger(RunCountPVData.class);

    public static void main(String args[]) {
        try{
            BackPvAccessData backPvAccessData = new BackPvAccessData();
            backPvAccessData.run();
            backPvAccessData = null;
        }catch(Exception e){
        	e.printStackTrace();
        	logger.error("====备份PV数据异常：" + e.getMessage(), e);
        }
        
        try {
            CountPVData countPVData = new CountPVData();
            countPVData.countCitySitePv();
            countPVData = null;
        } catch (Exception e) {
        	e.printStackTrace();
            logger.error("====城市PV统计异常：" + e.getMessage(), e);
        }

        try {
            CountPvCityAllData countPvCityAllData = new CountPvCityAllData();
            countPvCityAllData.run();
            countPvCityAllData = null;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("====城市综合统计异常：" + e.getMessage(), e);
        }

        try {
            CountItemTask countItemTask = new CountItemTask();
            countItemTask.run();
            countItemTask = null;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("====栏目统计异常：" + e.getMessage(), e);
        }

    }
}
