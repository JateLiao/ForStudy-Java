/*
 * 文件名：Test2.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： Test2.java
 * 修改人：tianzhong
 * 修改时间：2016年2月1日
 * 修改内容：新增
 */
package com.better517na.forStudy.advanced.reflect.on2016_2_1;

/**
 * 返回一个类的父类
 * 
 * @author tianzhong
 */
public class Test2_返回一个类的父类 {
    public static void main(String[] args) {
        Class<?> demo = null;
        try {
            demo = Class.forName("com.better517na.forStudy.advanced.reflect.on2016_2_1.Person");
            Class<?> superClass = demo.getSuperclass();

            System.out.println("父类是：" + superClass.getSimpleName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
