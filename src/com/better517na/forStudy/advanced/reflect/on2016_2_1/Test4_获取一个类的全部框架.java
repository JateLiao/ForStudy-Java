/*
 * 文件名：Test4.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： Test4.java
 * 修改人：tianzhong
 * 修改时间：2016年2月2日
 * 修改内容：新增
 */
package com.better517na.forStudy.advanced.reflect.on2016_2_1;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 通过Class获取一个类的全部框架
 * 
 * @author tianzhong
 */
public class Test4_获取一个类的全部框架 {
    public static void main(String[] args) {

        Class<?> demo = null;
        try {
            demo = Class.forName("com.better517na.forStudy.advanced.reflect.on2016_2_1.Person");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("===============Person类属性========================");
        Field[] field = demo.getDeclaredFields(); // 取得本类的全部属性
        for (int i = 0; i < field.length; i++) {
            // 权限修饰符
            int modifier = field[i].getModifiers();
            String modifierStr = Modifier.toString(modifier);

            // 属性类型
            Class<?> type = field[i].getType();
            System.out.println("权限修饰符:" + modifierStr + "  属性类型:" + type.getName() + "  属性名:" + field[i].getName() + ";");
        }

        System.out.println("\n===============Person类实现的接口或者父类的属性========================");
        Class<?> superClass = demo.getSuperclass(); // 继承的父类
        System.out.println("继承的父类:" + superClass.getName() + "\n父类和接口的属性:");
        Field[] field1 = demo.getFields();
        for (int j = 0; j < field1.length; j++) {
            // 权限修饰符
            int mo = field1[j].getModifiers();
            String priv = Modifier.toString(mo);
            // 属性类型
            Class<?> type = field1[j].getType();
            System.out.println("\t" + priv + " " + type.getName() + " " + field1[j].getName() + ";");
        }
        System.out.println("实现的接口:");
        Class<?>[] superInterfaces = demo.getInterfaces(); // 实现的接口
        for (int i = 0; i < superInterfaces.length; i++) {
            System.out.print("\t" + superInterfaces[i].getName() + "\n ");
        }

        System.out.println("\n===============Person类的方法========================");
        Method[] methods = demo.getMethods(); // 获取方法
        for (int i = 0; i < methods.length; i++) { // 方法拼接
            String modifierStr = Modifier.toString(methods[i].getModifiers()); // 方法权限
            Class<?>[] params = methods[i].getParameterTypes(); // 获取参数
            Class<?>[] exceptions = methods[i].getExceptionTypes(); // 获取异常
            System.out.print(modifierStr + " " + methods[i].getReturnType().getName() + " " + methods[i].getName() + "(");
            for (int j = 0; j < params.length; j++) {
                System.out.print(params[j].getSimpleName() + " " + "args" + j);
                if (j < params.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.print(")");

            for (int k = 0; k < exceptions.length; k++) { // 异常拼接
                if (k == 0) {
                    System.out.print(" throws ");
                }
                System.out.print(exceptions[k].getSimpleName());
                if (k < exceptions.length - 1) {
                    System.out.print(", ");
                }
            }

            System.out.println();
        }

    }
}
