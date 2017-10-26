/*
 * 文件名：MyThreadPrinter2.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： MyThreadPrinter2.java
 * 修改人：tianzhong
 * 修改时间：2016年6月20日
 * 修改内容：新增
 */
package com.better517na.forstudy.advanced.concurrent.concurrenttest.on20160705;

/**
 * TODO 建立三个线程，A线程打印10次A，B线程打印10次B,C线程打印10次C.
 * 
 * 要求线程同时运行，交替打印10次ABC。这个问题用Object的wait()，notify()就可以很方便的解决。
 * 
 * @author tianzhong
 */
public class MyThreadPrinter1 implements Runnable {
    private String name;

    private Object prev;

    private Object self;

    private MyThreadPrinter1(String name, Object prev, Object self) {
        this.name = name;
        this.prev = prev;
        this.self = self;
    }

    @Override
    public void run() {
        int count = 10;
        while (count > 0) {
            synchronized (prev) {
                synchronized (self) {
                    System.out.print(name);
                    count--;

                    self.notify();
                }

                try {
                    prev.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();

        MyThreadPrinter1 pa = new MyThreadPrinter1("A", c, a);
        MyThreadPrinter1 pb = new MyThreadPrinter1("B", a, b);
        MyThreadPrinter1 pc = new MyThreadPrinter1("C", b, c);

        Thread ta = new Thread(pa);
        ta.start();
        Thread tb = new Thread(pb);
        tb.start();
        Thread tc = new Thread(pc);
        tc.start();
    }
}
