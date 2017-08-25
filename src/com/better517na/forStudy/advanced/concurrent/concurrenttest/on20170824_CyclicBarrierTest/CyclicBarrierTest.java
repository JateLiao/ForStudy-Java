/*
 * 文件名：CyclicBarrierTest.java
 * 版权：Copyright 2007-2017 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： CyclicBarrierTest.java
 * 修改人：tianzhong
 * 修改时间：2017年8月24日
 * 修改内容：新增
 */
package com.better517na.forStudy.advanced.concurrent.concurrenttest.on20170824_CyclicBarrierTest;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
public class CyclicBarrierTest {
    
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(5);
        ExecutorService executors = Executors.newScheduledThreadPool(5);
        for (int i = 1; i <= 5; i++) {
           executors.execute(new CyclicBarrierTest().new CyclicBarrierRunner(i, barrier));
        }
    } 
    
    class CyclicBarrierRunner implements Runnable {
        
        private int no;
        private CyclicBarrier barrier;
        
        /**
         * 构造函数.
         */
        public CyclicBarrierRunner(int no, CyclicBarrier barrier) {
            this.no = no;
            this.barrier = barrier;
        }
        
        /**
         * 构造函数.
         */
        public CyclicBarrierRunner() { }

        /** 
         * {@inheritDoc}.
         */
        @Override
        public void run() {
            System.out.println("当前线程：" + this.no + "正在运行...");
            try {
                barrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("线程：" + this.no + " 继续完成后续操作!");
        }
    }
}
