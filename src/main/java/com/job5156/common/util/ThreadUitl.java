package com.job5156.common.util;

import java.util.*;


/**
 *  线程管理工具
 *  @author leeton
 */
public class ThreadUitl {

    public static LinkedList<Object> list = new LinkedList<Object>();   // 定义全局数据存放位置
    public static Map<Thread, Long> runThreadMap = new LinkedHashMap<>();  // 正在运行的线程
    public final static int THREAD_COUNT = 10;// 定义最大启动线程个数

    /**
     * 进程运行超时(秒）则强制中止运行
     * @param sencond 秒
     */
    public static void killThreadWhenOvertime(int sencond){

        Iterator iter = ThreadUitl.runThreadMap.keySet().iterator();
        while (iter.hasNext()) {
            try {
                synchronized (ThreadUitl.runThreadMap) {
                    Thread thread = (Thread) iter.next();
                    if ((new Date().getTime() - ThreadUitl.runThreadMap.get(thread)) / 1000 > sencond) {
                        // System.out.printf("thread to stop and remove : " + thread.getId() + "\r\n");
                        thread.stop(); //超过时间强制中止线程
                        iter.remove();
                        ThreadUitl.runThreadMap.remove(thread);
                    }
                }
                Thread.sleep(300);  //让轮循暂停0.3秒，以免CPU占用资源过高
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void addObject(Object obj) {
        ThreadUitl.list.add(obj);
    }


    public static void removeObject() {
        ThreadUitl.list.remove(0);
    }
}