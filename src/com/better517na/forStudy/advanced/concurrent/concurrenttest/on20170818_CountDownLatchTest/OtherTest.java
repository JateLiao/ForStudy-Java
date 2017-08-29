/*
 * 文件名：OtherTest.java
 * 版权：Copyright 2007-2017 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： OtherTest.java
 * 修改人：tianzhong
 * 修改时间：2017年8月25日
 * 修改内容：新增
 */
package com.better517na.forStudy.advanced.concurrent.concurrenttest.on20170818_CountDownLatchTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * TODO 测试CountDownLatch是否是只能让一个线程等待，还是能让一组线程等待。
 * 
 * @author     tianzhong
 */
public class OtherTest {
    
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            new Thread(new OtherTest().new TestWaiter(countDownLatch)).start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(new OtherTest().new TestCountDowner(countDownLatch)).start();
        }
        
        
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(20));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("\r\n\r\nMission OVER!!!");
    }

    /** 等待线程 */
    class TestWaiter implements Runnable {
        private CountDownLatch cLatch;
        public TestWaiter(CountDownLatch cLatch) {
            this.cLatch = cLatch;
        }
        
        @Override
        public void run() {
            System.out.println("等待线程" + Thread.currentThread().getName() + "已启动...");
            try {
                cLatch.await();
                System.out.println("等待线程" + Thread.currentThread().getName() + "守得云开见月明，开始执行!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    /** 递减线程 */
    class TestCountDowner implements Runnable {
        private CountDownLatch cLatch;
        public TestCountDowner(CountDownLatch cLatch) {
            this.cLatch = cLatch;
        }
        
        @Override
        public void run() {
            System.out.println("CountDown递减线程" + Thread.currentThread().getName() + "已启动~");
            try {
                Thread.sleep(2000);
                cLatch.countDown();
                System.out.println("线程" + Thread.currentThread().getName() + "递减后Count值：" + cLatch.getCount());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
