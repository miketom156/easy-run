package com.job5156.task.count;

import com.job5156.model.sys.SysFromSource;
import junit.framework.TestCase;

/**
 * Created by pzm on 2014/11/1.
 */

public class TestCountFromSource extends TestCase {
    public void testSysFromSource() {
        String fromSource = "http://www.baidu.com/s?tn=baidubig5&ie=big5&bs=%25E5%25B7%25A5%25E4%25BD%259C%25E9%2580%25A0%25E5%25B0%25B1%25E4%25BA%25BA%25E6%25A0%25BC%25E7%259A%2584%25E5%258F%258D%25E7%259C%2581&z=&cl=3&f=8&wd=%A4u%A7@%B3y%B4N%A4H%AE%E6%AA%BA%A4%CF%AC%D9&ct=1";
        SysFromSource sysFromSource = new SysFromSource();
        sysFromSource.parseFromSourceUrl(fromSource);
        assertEquals(SysFromSource.SOURCE_TYPE_SEARCHENGINE, sysFromSource.getSourceType());
        assertEquals("www.baidu.com", sysFromSource.getSourceDomain());
        assertEquals(SysFromSource.SEARCHENGINE_BAIDU, sysFromSource.getSearchEngine());
        assertEquals(fromSource.substring("http://www.baidu.com".length()), sysFromSource.getSourceAddr());
        assertEquals("衡阳北京现代4S店招聘", sysFromSource.getSearchKeyword());
    }

    public void testParse360SearchEngine() {
        String fromSource = "http://www.so.com/s?psid=c9ba5aea1787ec54639a78e688b29e39&q=%E5%85%B3%E9%94%AE%E5%AD%97&pq=test&src=srp&fr=tab_music";
        SysFromSource sysFromSource = new SysFromSource();
        sysFromSource.parseFromSourceUrl(fromSource);
        assertEquals(SysFromSource.SEARCHENGINE_360, sysFromSource.getSearchEngine());
        assertEquals("关键字", sysFromSource.getSearchKeyword());

        fromSource = "http://s.music.so.com/s?frsug=0&q=test";
        sysFromSource.parseFromSourceUrl(fromSource);
        assertEquals(SysFromSource.SEARCHENGINE_360, sysFromSource.getSearchEngine());
        assertEquals("test", sysFromSource.getSearchKeyword());
    }
}
