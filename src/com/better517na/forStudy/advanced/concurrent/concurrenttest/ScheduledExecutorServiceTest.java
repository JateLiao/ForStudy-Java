/*
 * 文件名：ScheduledExecutorServiceTest.java
 * 版权：Copyright 2007-2017 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： ScheduledExecutorServiceTest.java
 * 修改人：tianzhong
 * 修改时间：2017年8月4日
 * 修改内容：新增
 */
package com.better517na.forStudy.advanced.concurrent.concurrenttest;

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
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(new Runnable() {
            public void run() {
                System.out.println("丢雷楼某啊...");
                if (++count == 5) {
                    System.out.println("骂完收工，再见!");
                    System.exit(0);
                }
            }
        }, TimeUnit.SECONDS.toMillis(1), TimeUnit.SECONDS.toMillis(3), TimeUnit.MILLISECONDS);
    }

}
