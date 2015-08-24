package com.job5156.run.count;

import com.job5156.common.util.HibernateActionUtil;
import com.job5156.task.count.CountFromSource;
import com.job5156.task.count.CountIndexFromSource;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.format.ISODateTimeFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;


/**
 * 执行来源统计
 *
 * @author pzm
 */
public class RunCountFromSource {
    private static Logger LOG = Logger.getLogger(RunCountFromSource.class);

    public static void main(String[] args) {
        try {
            String countDate = "";
            for (String arg : args) {
                if (arg.startsWith("--countdate=")) {
                    countDate = arg.substring("--countdate=".length());
                }
            }
            LOG.info("Start RunCountFromSource");
            LOG.info(String.format("input param：countdate=%s", countDate));
            CountFromSource countFromSource = new CountFromSource();
            if (!"".equals(countDate)) {
                countFromSource.setCountDate(countDate);
            }
            LOG.info(String.format("countdate is "+new DateTime(countFromSource.getCountDate()).toString(ISODateTimeFormat.date())));
            countFromSource.countFromSourceBaseData();
            countFromSource.countFromSourceData();
            countFromSource.countFromSourceGeneralData();
            countFromSource.copySysCountItemSetting();
            LOG.info("End RunCountFromSource");

            LOG.info("Start RunCountIndexFromSource");
            LOG.info(String.format("input param：countdate=%s", countDate));
            CountIndexFromSource countIndexFromSource = new CountIndexFromSource();
            if (!"".equals(countDate)) {
                countIndexFromSource.setCountDate(countDate);
            }
            LOG.info(String.format("countdate is "+new DateTime(countIndexFromSource.getCountDate()).toString(ISODateTimeFormat.date())));
            countIndexFromSource.countIndexFromSourceBaseData();
            countIndexFromSource.countIndexFromSourceData();
            countIndexFromSource.countIndexFromSourceGeneralData();
            LOG.info("End RunCountIndexFromSource");
        } catch (ParseException e) {
            LOG.error("输入日期格式错误", e);
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error("RunCountFromSource 出错", e);
        } finally {
            HibernateActionUtil.closeSession();
        }
    }


}
