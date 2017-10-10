/*
 * 文件名：ReentrantLockTest.java
 * 版权：Copyright 2007-2017 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： ReentrantLockTest.java
 * 修改人：tianzhong
 * 修改时间：2017年10月9日
 * 修改内容：新增
 */
package com.better517na.forStudy.advanced.concurrent.concurrenttest.on20171009_ReentrantLockTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

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
public class ReentrantLockTest {

    /**
     * 添加字段注释.
     */
    private ReentrantLock lock = new ReentrantLock(); // 默认为非公平锁
    // private ReentrantLock lock = new ReentrantLock(true); // true: 公平锁，严格按照申请所的时间顺序获得锁

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executors = Executors.newFixedThreadPool(5);
        ReentrantLockTest test = new ReentrantLockTest();
        for (int i = 0; i < 5; i++) {
            executors.execute(test.new ReentrantLockThread());
        }
        
        executors.shutdown();
        while (!executors.isTerminated()) {
            Thread.sleep(TimeUnit.SECONDS.toMillis(1));
        }
        
        System.out.println("\r\n\r\nGame Over!!!");
    }

    class ReentrantLockThread implements Runnable {

        /**
         * {@inheritDoc}.
         */
        @Override
        public void run() {
            final ReentrantLock newLock = lock;
            try {
                System.out.println(Thread.currentThread().getName() + "等待获得锁...");
                newLock.lock();
                System.out.println(Thread.currentThread().getName() + "已获得锁，开始执行!");
                Thread.sleep(TimeUnit.SECONDS.toMillis(5));
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (null != newLock && newLock.isLocked()) {
                    newLock.unlock();
                }
            }
        }

    }
}
