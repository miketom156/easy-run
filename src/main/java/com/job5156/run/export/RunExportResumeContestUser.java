package com.job5156.run.export;

import com.job5156.common.util.HibernateSalveBaseUtil;
import com.job5156.task.export.ExportResumeContestUser;
import org.joda.time.DateTime;

import java.io.File;
import java.io.IOException;

/**
 * <p></p>
 * Date: 2015/4/27 10:33
 *
 * @version 1.0
 * @autor: Lu Weibiao
 */
public class RunExportResumeContestUser {
    public static void main(String[] args) throws IOException{
        ExportResumeContestUser exportResumeContestUser = new ExportResumeContestUser();
        String classPath = RunExportResumeContestUser.class.getResource("/").getPath();
        String simpleFileName = "exportJingZhou(" + DateTime.now().toString("yyyyMMdd") + ").xls";
        File file = new File(classPath + "/tempData/" + simpleFileName);
        exportResumeContestUser.exportJingZhouToExcel(file);
    }
}
