package com.job5156.run.fix;

import com.job5156.common.util.HibernateCountUtil;
import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>在RunCountPVData没有执行的时候执行本类进行修复</p>
 * Date: 2015/7/20 18:43
 *
 * @version 1.0
 * @author: zt
 */
public class FixRunCountPVData {
    private static final Logger logger = Logger.getLogger(FixRunCountPVData.class);

    /**
     * 入口方法
     * @param args
     * 支持的命令：
     * <p>
     * --fixOmissiveDays={开始日期},{结束日期} 例：--fixOmissiveDays=2015-03-23,2015-03-29
     * </p>
     */
    public static void main(String[] args){
        long startTime = System.currentTimeMillis();
        String command = null;
        if(args!= null && args.length > 0 ){
            command = args[0];
        } else return;
        logger.info("FixRunCountPVData[" + command + "]开始！");
        try {
           if (command.startsWith("--fixOmissiveDays=")) {//--fixOmissiveDays=2015-03-23,2015-03-29
                String[] dateStrArr = command.substring("--fixOmissiveDays=".length()).split(",");
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date startDay = dateFormat.parse(dateStrArr[0]);
                Date endDay = dateFormat.parse(dateStrArr[1]);
                new FixRunCountPVData().fixOmissiveDays(startDay, endDay);
            }
        } catch (Exception e){
            logger.error("执行\"" + command + "\"时出错", e);
        }finally {
            HibernateCountUtil.closeSession();
        }
        long endTime = System.currentTimeMillis();
        logger.info("FixRunCountPVData[" + command + "]结束！用时：" + ((endTime-startTime)/1000/60.0) + "分钟");
    }

    /**
     * 修复多天没有统计的数据
     * @param startDay
     * @param endDay
     */
    public void fixOmissiveDays(Date startDay, Date endDay) {
        try {
            FixBackPvAccessData backPvAccessDataFixer = new FixBackPvAccessData();
            backPvAccessDataFixer.fixOmissiveDays(startDay, endDay);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("====备份PV数据修复异常：" + e.getMessage(), e);
        }

        try {
            FixCountCitySiteFromBak countCitySiteFromBakFixer = new FixCountCitySiteFromBak();
            countCitySiteFromBakFixer.fixOmissiveDays(startDay, endDay);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("====城市PV统计修复异常：" + e.getMessage(), e);
        }

        try {
            FixCountPVCityAll countPVCityAllFixer = new FixCountPVCityAll();
            countPVCityAllFixer.fixOmissiveDays(startDay, endDay);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("====城市综合统计修复异常：" + e.getMessage(), e);
        }

        try {
            FixCountItem countItemFixer = new FixCountItem();
            countItemFixer.fixOmissiveDays(startDay, endDay);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("====栏目统计修复异常：" + e.getMessage(), e);
        }
    }
}
