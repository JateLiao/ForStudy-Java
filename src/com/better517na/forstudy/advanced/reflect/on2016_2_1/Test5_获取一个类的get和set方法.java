/*
 * 文件名：Test5.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： Test5.java
 * 修改人：tianzhong
 * 修改时间：2016年2月2日
 * 修改内容：新增
 */
package com.better517na.forstudy.advanced.reflect.on2016_2_1;

/**
 * 获取一个类的get和set方法.
 * 
 * @author tianzhong
 */
public class Test5_获取一个类的get和set方法 {
    public static void main(String[] args) {
        Class<?> demo = null;
        try {
            demo = Class.forName("com.better517na.forStudy.advanced.reflect.on2016_2_1.Person");
            Object obj = demo.newInstance();
            demo.getMethod("setInfo", String.class, int.class, String.class).invoke(obj, "Kobe Bean Bryant", 38, "male");
            demo.getMethod("sayHello").invoke(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
