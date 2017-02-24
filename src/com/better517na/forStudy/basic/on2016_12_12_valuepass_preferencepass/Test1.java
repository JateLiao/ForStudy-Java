/*
 * 文件名：Test1.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： Test1.java
 * 修改人：tianzhong
 * 修改时间：2016年12月12日
 * 修改内容：新增
 */
package com.better517na.forStudy.basic.on2016_12_12_valuepass_preferencepass;

import org.junit.Test;

/**
 * @author     tianzhong
 */
public class Test1 {
    class Via{
        Integer ax;
        int pi;
        public Integer getAx() {
            return ax;
        }
        public void setAx(Integer ax) {
            this.ax = ax;
        }
        public int getPi() {
            return pi;
        }
        public void setPi(int pi) {
            this.pi = pi;
        }
    }
    
    public void increment(Integer ax) { 
        System.out.print("");
        ax = ax + 10;
        System.out.print("");
    }
    
    public void increment(Via via) {
        System.out.print("");
        via.ax = via.ax + 10;
        // via.setAx(15);
        via.pi = 1;
        // via.setPi(10);
        System.out.print("");
    }

    @Test
    public void test1() {
        Integer ai = new Integer(0);
        System.out.println(ai);
        increment(ai);
        System.out.println(ai);
    }
    
    @Test
    public void test2() {
        Via via = new Via();
        Integer ai = new Integer(0);
        via.ax = ai;
        System.out.println(via.ax);
        increment(via);
        System.out.println(via.ax);
    }
    @Test
    public void test3() {
        Via via = new Via();
        Integer ai = new Integer(0);
        via.ax = ai;
        // System.identityHashCode(ai);
        // System.identityHashCode(via.ax);
        System.out.println("ai = " + ai);
        System.out.println("via.ax = " + via.ax);
        System.out.println("via.pi = " + via.pi);
        increment(via);
        // increment(ai);
        System.out.println("ai = " + ai);
        System.out.println("via.ax = " + via.ax);
        System.out.println("via.pi = " + via.pi);
    }
    @Test
    public void test4() {
        Via via = new Via();
        Integer ai = new Integer(0);
        via.ax = ai;
        System.out.println("via.pi = " + via.pi);
        // increment(via.pi);
        increment(via);
        System.out.println("via.pi = " + via.pi);
    }
}
