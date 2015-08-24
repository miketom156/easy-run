package com.job5156.common.util;

import junit.framework.TestCase;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

public class PVAccessUtilTest extends TestCase {

    public void testGetPVAccessTableName(){
        String creDate = "2014-10-20";
        assertEquals("PV_Access_Bak_1",PVAccessUtil.getPVAccessTableName(DateTime.parse(creDate).toDate()));
        creDate = "2014-10-20 23:59:59";
        assertEquals("PV_Access_Bak_1",PVAccessUtil.getPVAccessTableName(DateTime.parse(creDate,DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")).toDate()));

        creDate = "2014-10-19";
        assertEquals("PV_Access_Bak_20",PVAccessUtil.getPVAccessTableName(DateTime.parse(creDate).toDate()));
        creDate = "2014-10-19 23:59:59";
        assertEquals("PV_Access_Bak_20",PVAccessUtil.getPVAccessTableName(DateTime.parse(creDate,DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")).toDate()));
    }
}