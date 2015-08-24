package com.job5156.run.mail;

import com.job5156.common.Constants;
import com.job5156.common.util.HibernateActionUtil;
import com.job5156.common.util.HibernateSalveBaseUtil;
import com.job5156.task.mail.SysFindPosToResRecommend;
import com.job5156.task.mail.SystemResRecommend;
import org.apache.log4j.Logger;

/**
 * <p>筛选第二类符合规则的职位推送简历，三天一次</p>
 * Date:2015/7/18 8:36
 *
 * @author pzm
 * @version 1.0
 */
public class RunResRecommendThreeRun {
    private static final Logger logger = Logger.getLogger(RunResRecommendThreeRun.class);

    public static void main(String[] args) {
        logger.info("[RunResRecomendThreeRun] start!");
        try {
            String comId = null;
            for (String arg : args) {
                if (arg.startsWith("--comId=")) {
                    comId = arg.substring("--comId=".length());
                }
            }
            SysFindPosToResRecommend sysFindPosToResRecommend = new SysFindPosToResRecommend();
            sysFindPosToResRecommend.findPosToResRecommendThreeRun(comId);

            new SystemResRecommend(Constants.REDIS_KEY_RECOMMENDED_COMPOS_ID_THREE_RUN).send();
        } catch (Exception e) {
            logger.error("[RunResRecomendThreeRun] fail!", e);
        } finally {
            HibernateSalveBaseUtil.closeSession();
            HibernateActionUtil.closeSession();
        }
        logger.info("[RunResRecomendThreeRun] end!");
    }
}
