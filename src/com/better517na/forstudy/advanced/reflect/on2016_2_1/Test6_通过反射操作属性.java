/*
 * 文件名：Test6.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： Test6.java
 * 修改人：tianzhong
 * 修改时间：2016年2月2日
 * 修改内容：新增
 */
package com.better517na.forstudy.advanced.reflect.on2016_2_1;

import java.lang.reflect.Field;

/**
 * 通过反射操作属性
 * 
 * @author tianzhong
 */
public class Test6_通过反射操作属性 {
    public static void main(String[] args) {
        try {
            Class<?> demo = Class.forName("com.better517na.forStudy.advanced.reflect.on2016_2_1.Person");
            Object obj = demo.newInstance();
            Field[] fileds = demo.getDeclaredFields();
            for (int i = 0; i < fileds.length; i++) {
                fileds[i].setAccessible(true);
                switch (i + 1) {
                    case 1:
                        fileds[i].set(obj, "Kobe Bean Bryant");
                        break;
                    case 2:
                        fileds[i].set(obj, "male");
                        break;
                    case 3:
                        fileds[i].set(obj, 38);
                        break;
                    default:
                        break;
                }
            }

            for (int i = 0; i < fileds.length; i++) {
                System.out.println(fileds[i].get(obj));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
