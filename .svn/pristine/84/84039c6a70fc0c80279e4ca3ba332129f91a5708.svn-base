package com.job5156.run.mail;

import com.job5156.common.Constants;
import com.job5156.common.util.HibernateActionUtil;
import com.job5156.common.util.HibernateSalveBaseUtil;
import com.job5156.task.mail.SysFindPosToResRecommend;
import com.job5156.task.mail.SystemResRecommend;
import org.apache.log4j.Logger;

/**
 * <p>推送最近一周新发布职位，两天一次</p>
 * Date:2015/7/18 8:35
 *
 * @author pzm
 * @version 1.0
 */
public class RunResRecommendTwoRun {
    private static final Logger logger = Logger.getLogger(RunResRecommendThreeRun.class);

    public static void main(String[] args) {
        logger.info("[RunResRecommendTwoRun] start!");
        try {
            String comId = null;
            for (String arg : args) {
                if (arg.startsWith("--comId=")) {
                    comId = arg.substring("--comId=".length());
                }
            }
            SysFindPosToResRecommend sysFindPosToResRecommend = new SysFindPosToResRecommend();
            sysFindPosToResRecommend.findPosToResRecommendTwoRun(comId);

            new SystemResRecommend(Constants.REDIS_KEY_RECOMMENDED_COMPOS_ID_NEW_RELEASE).send();
        } catch (Exception e) {
            logger.error("[RunResRecommendTwoRun] fail!", e);
        } finally {
            HibernateSalveBaseUtil.closeSession();
            HibernateActionUtil.closeSession();
        }
        logger.info("[RunResRecommendTwoRun] end!");
    }
}
