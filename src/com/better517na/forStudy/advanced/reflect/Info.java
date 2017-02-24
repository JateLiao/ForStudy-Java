package com.better517na.forStudy.advanced.reflect;

import org.junit.Test;

/**
 * @author tianzhong
 *
 */
public class Info { 
    @Test
    public void testwe(){
        Boolean ad = new Boolean(false);
        System.out.println(ad);
        change(ad);
        System.out.println(ad);
    }
    
    public void change(Boolean ax) {
        Boolean cv = new Boolean(true);
        ax = cv;
    }
    
    
    class Via{
        Integer ax;
        int pi; 
    }
    class Func{
        public void increament(Integer i){
            System.out.println();
            i += 10;
            System.out.println();
        }
        
        public void increament(Via v){
            System.out.println();
            v.ax += 10;
            v.pi += 10;
            System.out.println();
        }
    }
    @Test
    public void test2(){
        Via via = new Via();
        Integer ai = 20;
        via.ax = ai;
        via.pi = 10;
        System.out.println(via.ax);
        
        new Func().increament(via.ax);
        System.out.println(via.ax);
        
        new Func().increament(via);
        System.out.println(via.ax);
        
        System.out.println("pi = " + via.pi);
    }
    
    
    
    
    
    @Test
    public void testFunc(){
//        System.out.println("123".substring(0, "123".length() - 1));
        
        System.out.println(Integer.valueOf("00"));
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
