/*
 * 文件名：Test2_Reuse.java
 * 版权：Copyright 2007-2017 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： Test2_Reuse.java
 * 修改人：tianzhong
 * 修改时间：2017年8月25日
 * 修改内容：新增
 */
package com.better517na.forstudy.advanced.concurrent.concurrenttest.on20170824_CyclicBarrierTest.others;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * 这个小demo体现CyclicBarrier的可重复使用的特性. 
 * @author     tianzhong
 */
public class Test2_Reuse {
    
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(5);
        for (int i = 0; i < 5; i++) {
            new Thread(new Test2_Reuse().new Writer_Reuse(barrier)).start();
        }
    
        System.out.println("CyclicBarrier重用");

        for (int i = 0; i < 5; i++) {
            new Thread(new Test2_Reuse().new Writer_Reuse(barrier)).start();
        }
    }
    
    class Writer_Reuse implements Runnable {
        private CyclicBarrier barrier;
        /**
         * 构造函数.
         * 
         */
        public Writer_Reuse(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        /** 
         * {@inheritDoc}.
         */
        @Override
        public void run() {
            System.out.println("线程" + Thread.currentThread().getName() + "正在写入数据...");
            
            try {
                Thread.sleep(TimeUnit.SECONDS.toMillis(2));
                System.out.println("线程" + Thread.currentThread().getName() + "数据写入完毕，等待其他线程写入完毕...");
                barrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("所有线程写入完毕，继续处理其他任务!!!");
        }
    
    }

}
