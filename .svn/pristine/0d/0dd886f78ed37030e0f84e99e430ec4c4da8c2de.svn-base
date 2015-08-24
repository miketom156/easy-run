package com.job5156.run;

import com.job5156.common.util.HibernateActionUtil;
import com.job5156.common.util.HibernateCountUtil;
import com.job5156.common.util.HibernateUtil;
import com.job5156.task.PosAverageLevelStatis;
import com.job5156.task.PosWordAnalyse;
import org.apache.log4j.Logger;

/**
 * Created by pzm on 2015/1/12.
 */
public class RunPosAvgStatis {
    private static Logger logger = Logger.getLogger(RunPosAvgStatis.class);

    public static void main(String[] args) {
        logger.info("[RunPosAvgStatis] start!");
        try {
            PosAverageLevelStatis posAverageLevelStatis = new PosAverageLevelStatis();
            posAverageLevelStatis.statisUsingTaoLabelPosCount();
            posAverageLevelStatis.statisPosCount();
            posAverageLevelStatis.statisTaoLabelUseFrequency();
            posAverageLevelStatis.statisAvgSalary();
            posAverageLevelStatis.statisPosTypeAvgLevel();
        } finally {
            HibernateActionUtil.closeSession();
            HibernateUtil.closeSession();
            HibernateCountUtil.closeSession();
        }
        logger.info("[RunPosAvgStatis] end!");
    }
}
