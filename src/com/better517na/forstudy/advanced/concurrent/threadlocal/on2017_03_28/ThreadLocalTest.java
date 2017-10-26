/*
 * 文件名：Test1.java
 * 版权：Copyright 2007-2017 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： Test1.java
 * 修改人：tianzhong
 * 修改时间：2017年3月28日
 * 修改内容：新增
 */
package com.better517na.forstudy.advanced.concurrent.threadlocal.on2017_03_28;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;

import org.junit.Test;

/**
 * TODO 添加类的一句话简单描述.
 * 
 * @author     tianzhong
 */
public class ThreadLocalTest {
    static ThreadLocal<String> locals = new ThreadLocal<>();

    @Test
    public void threadTest() {
        int corePoolSize = 10;
        Executor es = new ScheduledThreadPoolExecutor(corePoolSize); // Executors.newScheduledThreadPool(10);
        List<Runnable> runs = new ArrayList<>();
        locals.set("ppp");
        for (int i = 0; i < 10; i++) {
            Runnable run = new Runnable() {
                @Override
                public void run() {
                    locals.set("sss");
                }
            };
            runs.add(run);
            locals.remove();
            es.execute(run);
        }

        locals.set("xxx");
        for (Runnable runnable : runs) {
            System.out.println(runnable.getClass());
            System.out.println(locals.get());
        }
    }
}
