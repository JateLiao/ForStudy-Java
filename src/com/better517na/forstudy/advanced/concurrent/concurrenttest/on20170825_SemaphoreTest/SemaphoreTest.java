/*
 * 文件名：SemaphoreTest.java
 * 版权：Copyright 2007-2017 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： SemaphoreTest.java
 * 修改人：tianzhong
 * 修改时间：2017年8月25日
 * 修改内容：新增
 */
package com.better517na.forstudy.advanced.concurrent.concurrenttest.on20170825_SemaphoreTest;

import java.util.concurrent.Semaphore;
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
public class SemaphoreTest {

    public static void main(String[] args) throws Exception {
        Semaphore semaphore = new Semaphore(5); // 初始化5个信号量
        // semaphore = new Semaphore(5, false); // 这个多了一个参数fair表示是否是公平的，即等待时间越久的越先获取许可
        semaphore.release();
        semaphore.acquire();
        semaphore.acquire(2);
        semaphore.tryAcquire();
        
        semaphore.release();
        semaphore.release(2);
        
        System.out.println(semaphore.availablePermits());
        
        int workerNum = 8; // 工人数
        semaphore = new Semaphore(5); // 机器数目
        for (int i = 0; i < workerNum; i++) {
            new Thread(new SemaphoreTest().new Runner(i, semaphore)).start();
        }
        
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(20));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println("最后剩余可用机器数：" + semaphore.availablePermits());
    }
    
    class Runner implements Runnable {
        private int num;
        private Semaphore semaphore;
        
        /**
         * 构造函数.
         */
        public Runner(int num, Semaphore semaphore) {
            this.num = num;
            this.semaphore = semaphore;
        }
        
        /** 
         * {@inheritDoc}.
         */
        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("工人" + this.num + "占用一个机器在生产...");
                Thread.sleep(2000);
                System.out.println("工人" + this.num + "释放出机器");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
