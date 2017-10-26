/*
 * 文件名：Test1.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： Test1.java
 * 修改人：tianzhong
 * 修改时间：2016年2月1日
 * 修改内容：新增
 */
package com.better517na.forstudy.advanced.reflect.on2016_2_1;

/**
 * 返回一个类实现的接口
 * 
 * @author tianzhong
 */
public class Test1_返回一个类实现的接口 {
    public static void main(String[] args) {
        Class<?> demo = null;
        try {
            demo = Class.forName("com.better517na.forStudy.advanced.reflect.on2016_2_1.Person");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Class<?>[] intefs = demo.getInterfaces();

        System.err.println(intefs.length);

        for (int i = 0; i < intefs.length; i++) {
            System.out.println("实现的接口   " + intefs[i].getName());
        }
    }
}
