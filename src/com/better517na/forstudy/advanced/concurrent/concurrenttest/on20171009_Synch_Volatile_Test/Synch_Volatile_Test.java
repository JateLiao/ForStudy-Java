/*
 * 文件名：Synch_Volatile_Test.java
 * 版权：Copyright 2007-2017 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： Synch_Volatile_Test.java
 * 修改人：tianzhong
 * 修改时间：2017年10月9日
 * 修改内容：新增
 */
package com.better517na.forstudy.advanced.concurrent.concurrenttest.on20171009_Synch_Volatile_Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

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
public class Synch_Volatile_Test {
    /**
     * 测试Synchronized和Volatile的特性.
     */
    
    public static void main(String[] args) throws InterruptedException {
        final Synch_Volatile_Test test = new Synch_Volatile_Test();
        int nThreads = 5;
        ExecutorService executors = new ThreadPoolExecutor(nThreads , nThreads, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
        for (int i = 0; i < 5; i++) {
            executors.execute(new Runnable() {
                /**
                 * volatile并不能保证每次最后numVolatile的值为5000，因为volatile保证了可见性，但是没有保证原子性，
                 * 而自增（++运算符）并不是一个原子操作，synchronized作用于自增方法，使得increase()方法具有了原子性，因此每次的值都为5000。
                 */
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        test.increaseVolatile();
                    }
                }
            });
        }

        ExecutorService executors1 = new ThreadPoolExecutor(nThreads, nThreads,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
        for (int i = 0; i < 5; i++) {
            executors1.execute(new Runnable() {
                
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        test.increase();
                    }
                }
            });
        }
        
        executors.shutdown();
        executors1.shutdown();
        while (!executors.isTerminated() || !executors1.isTerminated()) {
            Thread.sleep(1000);
        }

        test.showNumVolatileValue();
        test.showNumValue();
    }
    

    private volatile int numVola = 0;

    private volatile int num = 0;

    public void increaseVolatile() {
        this.numVola++;
    }

    public synchronized void increase() {
        this.num++;
    }
    
    public void showNumVolatileValue(){
        System.out.println("Value of NumVolatile: " + this.numVola);
    }
    
    public void showNumValue(){
        System.out.println("Value of Num: " + this.num);
    }
    
}
