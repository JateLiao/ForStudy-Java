/*
 * 文件名：CountDownLatchTest.java
 * 版权：Copyright 2007-2017 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： CountDownLatchTest.java
 * 修改人：tianzhong
 * 修改时间：2017年8月18日
 * 修改内容：新增
 */
package com.better517na.forStudy.advanced.concurrent.concurrenttest.on20170818_CountDownLatchTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

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
public class CountDownLatchTest {
    
    /**
     * 添加字段注释.
     */
    public static final CountDownLatch cntDwnLatch = new CountDownLatch(5);

    @Test
    public void countDownLatchTest() {
        // Executors.newScheduledThreadPool(5);
        ExecutorService pool = new ThreadPoolExecutor(4, 10, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
        
        new Thread(){
            public void run() {
                try {
                    //调用await()方法的线程会被挂起，它会等待直到count值为0才继续执行
                    CountDownLatchTest.cntDwnLatch.await();
                    System.out.println("妈的，终于轮到我了，大家有什么要问的吗？");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            };
        }.start();
        
        for (int i = 0; i < 5; i++) {
            pool.execute(new CntDwnLtchRunner("runner" + i));
        }
        
        pool.shutdown();
        
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(10));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void countDownLatchTest2() throws InterruptedException {
        // Executors.newScheduledThreadPool(5);
        ExecutorService pool = new ThreadPoolExecutor(4, 10, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
        
        new Thread(){
            public void run() {
                try {
                    // //和await()类似，只不过等待一定的时间后count值还没变为0的话就会继续执行
                    CountDownLatchTest.cntDwnLatch.await(3000, TimeUnit.MILLISECONDS);
                    System.out.println("妈的，终于轮到我了，大家有什么要问的吗？");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            };
        }.start();
        
        for (int i = 0; i < 5; i++) {
            pool.execute(new CntDwnLtchRunner("runner" + i));
        }
        Thread.sleep(TimeUnit.SECONDS.toMillis(10));
        pool.shutdown();
    }
}
