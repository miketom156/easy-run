package com.job5156.run.fix;

import com.job5156.common.util.HibernateCountUtil;
import com.job5156.common.util.HibernateUtil;
import com.job5156.task.count.CountMobileApp;
import com.job5156.task.count.CountTouch;
import com.job5156.task.count.CountWeixin;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>修复访问方式统计</p>
 * Date: 2015/7/20 16:23
 *
 * @version 1.0
 * @author: zt
 */
public class FixCountAccessMode {
    private static final Logger logger = Logger.getLogger(FixCountAccessMode.class);

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
        logger.info("城市PV统计数据修复-FixCountAccessMode[" + command + "]开始！");
        try {
           if (command.startsWith("--fixOmissiveDays=")) {//--fixOmissiveDays=2015-03-23,2015-03-29
                String[] dateStrArr = command.substring("--fixOmissiveDays=".length()).split(",");
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date startDay = dateFormat.parse(dateStrArr[0]);
                Date endDay = dateFormat.parse(dateStrArr[1]);
                new FixCountAccessMode().fixOmissiveDays(startDay, endDay);
           }
        } catch (Exception e){
            logger.error("执行\"" + command + "\"时出错", e);
        }finally {
            HibernateUtil.closeSession();
            HibernateCountUtil.closeSession();
        }
        long endTime = System.currentTimeMillis();
        logger.info("执行城市PV统计数据数据修复-FixCountAccessMode[" + command + "]结束！用时：" + ((endTime-startTime)/1000/60.0) + "分钟");
    }

    /**
     * 新增统计指定的日期范围的数据（跨天）
     * @param startDay
     * @param endDay
     */
    public void fixOmissiveDays(Date startDay, Date endDay){
        CountMobileApp appFixer = new CountMobileApp();
        CountWeixin weiXinFixer = new CountWeixin();
        CountTouch touchFixer = new CountTouch();

        DateTime jodaStartDay = new DateTime(startDay).withTimeAtStartOfDay();
        DateTime jodaEndDay = new DateTime(endDay).withTimeAtStartOfDay();
        DateTime jodaFixDay = jodaStartDay;
        while(!jodaFixDay.isAfter(jodaEndDay)){
            Date fixDay = jodaFixDay.toDate();
            appFixer.countVistorsAndPV(fixDay);
            weiXinFixer.countVistorsAndPV(fixDay);
            touchFixer.countVistorsAndPV(fixDay);

            jodaFixDay = jodaFixDay.plusDays(1);
        }
    }
}
