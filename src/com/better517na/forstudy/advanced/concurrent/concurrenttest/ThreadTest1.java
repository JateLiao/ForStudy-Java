/*
 * 文件名：ThreadTest1.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： ThreadTest1.java
 * 修改人：tianzhong
 * 修改时间：2016年6月28日
 * 修改内容：新增
 */
package com.better517na.forstudy.advanced.concurrent.concurrenttest;

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
public class ThreadTest1 {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(new ThreadA(i));
            t.start();
        }
    }
}

class TestA {
    static int i = 0;
}

class ThreadA implements Runnable {
    int index;

    /**
     * 构造函数.
     * 
     */
    public ThreadA(int i) {
        this.index = i;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void run() {
        TestA.i++;

        System.out.println("线程" + this.index + " 的i值: " + TestA.i);
    }
}
