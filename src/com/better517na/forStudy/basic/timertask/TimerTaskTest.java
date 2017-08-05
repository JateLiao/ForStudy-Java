/*
 * 文件名：TimerTaskTest.java
 * 版权：Copyright 2007-2017 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： TimerTaskTest.java
 * 修改人：tianzhong
 * 修改时间：2017年8月4日
 * 修改内容：新增
 */
package com.better517na.forStudy.basic.timertask;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * TODO 添加类的一句话简单描述.
 * <p>
 * TODO 详细描述
 * <p>
 * TODO 示例代码
 * <pre>
 * </pre>
 * 
 * @author     tianzhong
 */
public class TimerTaskTest {
    public static int count = 0;
    
    public static void main(String[] args) {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("diu lei lou mou a...");
                count++;
                if (count == 10) {
                    System.exit(0);
                }
            }
        };
        Timer timer = new Timer(false);
        timer.scheduleAtFixedRate(task, TimeUnit.SECONDS.toMillis(1), TimeUnit.SECONDS.toMillis(3));
    }

}
