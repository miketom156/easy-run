package com.job5156.run.count;

import com.job5156.task.count.CountMobileApp;
import com.job5156.task.count.CountTouch;
import com.job5156.task.count.CountWeixin;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;

/**
 * Created with IntelliJ IDEA.
 * User: DJH
 * Date: 14-10-24
 * Time: 上午10:44
 * 访问方式相关的统计
 */
public class RunCountAccessMode {

    private static Logger logger = Logger.getLogger(RunCountAccessMode.class);

    public static void main(String args[]){
        logger.info("【"+ DateTime.now().minusDays(1).toString("yyyy-MM-dd")+"】渠道访问统计开始：");
        try{
            //统计触屏版访问量
            CountTouch countTouch = new CountTouch();
            countTouch.countVistorsAndPV();
            countTouch = null;
        }catch(Exception e){
            logger.error("触屏版渠道访问出错：\n"+e.getMessage(),e);
        }
        try{
            //统计微信访问量
            CountWeixin countWeixin = new CountWeixin();
            countWeixin.countVistorsAndPV();
            countWeixin = null;
        }catch(Exception e){
            logger.error("微信渠道访问出错：\n"+e.getMessage(),e);
        }

        try{
            //统计手机app访问量
            CountMobileApp countMobileApp = new CountMobileApp();
            countMobileApp.countVistorsAndPV();
            countMobileApp = null;
        }catch(Exception e){
            logger.error("手机app渠道访问出错：\n"+e.getMessage(),e);
        }

        logger.info("【"+ DateTime.now().minusDays(1).toString("yyyy-MM-dd")+"】渠道访问统计结束");
    }
}
