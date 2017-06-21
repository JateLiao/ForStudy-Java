/*
 * 文件名：CloneTest.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： CloneTest.java
 * 修改人：tianzhong
 * 修改时间：2016年11月14日
 * 修改内容：新增
 */
package com.better517na.forStudy.basic.on2016_11_14_deepcopy_shadowcopy;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

/**
 * TODO 添加类的一句话简单描述.
 * 
 * 浅复制：只拷贝基本类型，引用类型只是创建了一个指向原的引用。
 * 
 * 深复制：都拷贝。
 * 
 * @author     tianzhong
 */
public class CloneTest { 
    @Test
    public void testFunc(){
        System.out.println(TimeUnit.DAYS.toMillis(1));
        System.out.println(24 * 60 * 60 * 1000);
    }
    
    @Test
    public void testFunc2(){
        String json = "123\",\"dfsf\",\"dfsdfds\"";
        System.out.println(json.substring(0, json.length()));
        
        for (int i=0; i<json.length(); i++) {
            char c = json.charAt(i);
            if (',' == c && i >= 2 && !"\"".equals(json.substring(i-2, i-1))) {
                System.out.println("xxxxxxxxxxx");
            }
        }
    }
    
    
    class Inner {
        /**
         * 添加字段注释.
         */
        private String inner;

        /**
         * 设置inner.
         * 
         * @return 返回inner
         */
        public String getInner() {
            return inner;
        }

        /**
         * 获取inner.
         * 
         * @param inner 要设置的inner
         */
        public void setInner(String inner) {
            this.inner = inner;
        }
    }
    
    class Acc implements Cloneable{
        /**
         * 添加字段注释.
         */
        private int i;
        
        /**
         * 添加字段注释.
         */
        private String name;
        
        /**
         * 添加字段注释.
         */
        private Inner in;
        
        /**
         * 设置in.
         * 
         * @return 返回in
         */
        public Inner getIn() {
            return in;
        }

        /**
         * 获取in.
         * 
         * @param in 要设置的in
         */
        public void setIn(Inner in) {
            this.in = in;
        }

        @Override
        public Object clone() {
            try {
                return super.clone();
            } catch (Exception e) {
                return null;
            }
        }
        
        /**
         * 设置i.
         * 
         * @return 返回i
         */
        public int getI() {
            return i;
        }
        /**
         * 获取i.
         * 
         * @param i 要设置的i
         */
        public void setI(int i) {
            this.i = i;
        }
        /**
         * 设置name.
         * 
         * @return 返回name
         */
        public String getName() {
            return name;
        }
        /**
         * 获取name.
         * 
         * @param name 要设置的name
         */
        public void setName(String name) {
            this.name = name;
        }
    }

    @org.junit.Test
    public void ShallowCopyTest(){
        Acc a1 = new Acc();
        a1.setI(10);
        a1.setName("Source Name");
        Inner in = new Inner();
        in.setInner("Inner Name");
        a1.setIn(in);
        Acc a2 = (Acc) a1.clone();
        
        a1.setName("First Name");
        
        a2.setName("Cloned Name");
        
        System.out.println(a2.getI());
        System.out.println(a2.getName());
        
        System.out.println(a1 == a2);
    }


}
