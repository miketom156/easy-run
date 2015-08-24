package com.job5156.run.cms;

import org.apache.log4j.Logger;
import com.job5156.task.cms.PosArticleConsultationData;


/**
 *
 * Date:2015-5-8 下午4:47:50
 * @author xiatao
 * @version 1.0
 */
public class RunPosArticleConsultationWeek {

	private static Logger logger = Logger.getLogger(RunPosArticleConsultationWeek.class);

    public static void main(String args[]) {
    	try{
    		PosArticleConsultationData posArticleConsultationData = new PosArticleConsultationData();
    		posArticleConsultationData.runPosData();
    		posArticleConsultationData = null;
    	}catch(Exception e){
    		e.printStackTrace();
    		logger.error("生成职位文章咨询出异常:" + e.getMessage(), e);
    	}
    }
}
