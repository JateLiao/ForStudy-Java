/*
 * 文件名：Test1.java
 * 版权：Copyright 2007-2017 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： Test1.java
 * 修改人：tianzhong
 * 修改时间：2017年8月25日
 * 修改内容：新增
 */
package com.better517na.forStudy.advanced.concurrent.concurrenttest.on20170824.others;

import java.util.concurrent.CyclicBarrier;
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
public class Test1 {
    
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(5);
        for (int i = 0; i < 5; i++) {
            new Thread(new Test1().new Writer(barrier)).start();
        }
    }
    
    class Writer implements Runnable{
        private CyclicBarrier barrier;
        /**
         * 构造函数.
         * 
         */
        public Writer(CyclicBarrier barrier) {
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
