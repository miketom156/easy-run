package com.job5156.run;

import com.job5156.common.util.HibernateActionUtil;
import com.job5156.common.util.HibernateCountUtil;
import com.job5156.task.PosPublishAnalyse;
import com.job5156.task.PosWordAnalyse;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;

/**
 * Created by pzm on 2015/1/12.
 */
public class RunPosPublishAnalyse {
    private static Logger logger = Logger.getLogger(RunPosPublishAnalyse.class);

    public static void main(String[] args) {
        try {
            boolean forceRun = false;
            for (String arg : args) {
                if (arg.startsWith("--forcerun")) {
                    forceRun = true;
                }
            }
            DateTime now = new DateTime();
            if (now.dayOfMonth().get() == 1 || forceRun) {
                logger.info("[RunPosPublishAnalyse] start!");
                PosPublishAnalyse posPublishAnalyse = new PosPublishAnalyse();
                String count_date = now.minusMonths(1).toString("yyyy-MM");
                posPublishAnalyse.statisPosViewCount(count_date);
                posPublishAnalyse.statisPosDeliverCount(count_date);
                logger.info("[RunPosPublishAnalyse] end!");
            }
        } finally {
            HibernateActionUtil.closeSession();
            HibernateCountUtil.closeSession();
        }
    }
}
