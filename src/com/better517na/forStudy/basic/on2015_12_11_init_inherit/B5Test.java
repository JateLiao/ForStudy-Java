/*
 * 文件名：B5Test.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： B5Test.java
 * 修改人：tianzhong
 * 修改时间：2016年11月1日
 * 修改内容：新增
 */
package com.better517na.forStudy.basic.on2015_12_11_init_inherit;

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
public class B5Test {
    public static void main(String[] args) {
        System.out.println(add(10));
    }
    
    public static int add(int b) {
        try {
            b += 10;
            //b /= 0;
            return b;
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            b += 10;
        }
        b+= 10;
        return b;
    }
}

class B5_1{
    static B5_S n1 = new B5_S("父类1");
    public B5_S n2 = new B5_S("父类2");
    
    public B5_1() {
        System.out.println("B5_1");
    }
}

class B5_2 extends B5_1{
    static B5_S n1 = new B5_S("子类1");
    public B5_S n2 = new B5_S("子类2");
    
    /**
     * 构造函数.
     * 
     */
    public B5_2() {
        System.out.println("B5_2");
    }
}

class B5_S{
    /**
     * 构造函数.
     * 
     */
    public B5_S(String s) {
        System.out.println("B5_S: " + s);
    }
}
