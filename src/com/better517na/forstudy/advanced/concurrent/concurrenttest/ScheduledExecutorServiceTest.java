/*
 * 文件名：ScheduledExecutorServiceTest.java
 * 版权：Copyright 2007-2017 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： ScheduledExecutorServiceTest.java
 * 修改人：tianzhong
 * 修改时间：2017年8月4日
 * 修改内容：新增
 */
package com.better517na.forstudy.advanced.concurrent.concurrenttest;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * TODO 1.5后出现的定时任务api，是目前比较理想的定时任务工具.
 * 
 * @author     tianzhong
 */
public class ScheduledExecutorServiceTest {
    public static int count = 0;
    
    public static void main(String[] args) {
        ScheduledExecutorService executorService =  Executors.newSingleThreadScheduledExecutor();
        // new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS, new BlockingQueue<Runnable>());
        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("丢雷楼某啊...");
                if (++count == 5) {
                    System.out.println("骂完收工，再见!");
                    System.exit(0);
                }
            }
        }, TimeUnit.SECONDS.toMillis(1), TimeUnit.SECONDS.toMillis(3), TimeUnit.MILLISECONDS);
        // 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间 
    }

}
