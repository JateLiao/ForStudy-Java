/*
 * 文件名：ThreadPoolExcutorTest.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： ThreadPoolExcutorTest.java
 * 修改人：tianzhong
 * 修改时间：2016年5月16日
 * 修改内容：新增
 */
package com.better517na.forstudy.advanced.concurrent.concurrenttest.on20160705;

import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import util.DateUtil;

/**
 * TODO 添加类的一句话简单描述.
 * <p>
 * TODO 详细描述
 * <p>
 * TODO 示例代码
 * 
 * <pre>
 * </pre>
 * 
 * @author tianzhong
 */
public class ThreadPoolExcutorTest {
    public static void main(String[] args) {
         ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 100, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5));
        //
        // ExecutorService pool1 = Executors.newCachedThreadPool();
        // ExecutorService pool2 = Executors.newFixedThreadPool(5);
        // ExecutorService pool3 = Executors.newSingleThreadExecutor();
        // ExecutorService pool4 = Executors.newScheduledThreadPool(5);

        // StringBuffer sb = new StringBuffer("dfdsfads,");
        // sb.deleteCharAt(sb.length() - 1);
        // System.out.println(sb);

        System.out.println(DateUtil.dateToString(new Date(), "yyyy-MM-dd"));
    }
}
