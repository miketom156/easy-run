package com.job5156.run.fix;

import com.job5156.common.util.HibernateCountUtil;
import com.job5156.task.count.BackPvAccessData;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>修复备份PV、IP有误的问题</p>
 * Date: 2015/7/20 18:46
 *
 * @version 1.0
 * @author: zt
 */
public class FixBackPvAccessData {
    private static final Logger logger = Logger.getLogger(FixBackPvAccessData.class);

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
        logger.info("FixBackPvAccessData[" + command + "]开始！");
        try {
            if (command.startsWith("--fixOmissiveDays=")) {//--fixOmissiveDays=2015-03-23,2015-03-29
                String[] dateStrArr = command.substring("--fixOmissiveDays=".length()).split(",");
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date startDay = dateFormat.parse(dateStrArr[0]);
                Date endDay = dateFormat.parse(dateStrArr[1]);
                new FixBackPvAccessData().fixOmissiveDays(startDay, endDay);
            }
        } catch (Exception e){
            logger.error("执行\"" + command + "\"时出错", e);
        }finally {
            HibernateCountUtil.closeSession();
        }
        long endTime = System.currentTimeMillis();
        logger.info("FixBackPvAccessData[" + command + "]结束！用时：" + ((endTime-startTime)/1000/60.0) + "分钟");
    }

    /**
     * 修复多天没有备份的情况
     * @param startDay
     * @param endDay
     */
    public void fixOmissiveDays(Date startDay, Date endDay){
        DateTime jodaStartDay = new DateTime(startDay).withTimeAtStartOfDay();
        DateTime jodaEndDay = new DateTime(endDay).withTimeAtStartOfDay();
        DateTime jodaFixDay = jodaStartDay;
        BackPvAccessData backPvAccessData = new BackPvAccessData();
        while(!jodaFixDay.isAfter(jodaEndDay)){
            Date startOfDay = jodaFixDay.toDate();
            Date endOfDay = jodaFixDay.plusDays(1).toDate();

            //对pvaccess表备份并生成相关 PV_Access_ClientDetail中的数据
            backPvAccessData.backPvAccess(startOfDay, endOfDay);
            //备份pvaccessip数据
            backPvAccessData.backPvAccessIp(startOfDay, endOfDay);

            jodaFixDay = jodaFixDay.plusDays(1);
        }
    }
}
