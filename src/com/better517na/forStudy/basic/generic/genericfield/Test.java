/*
 * 文件名：Test.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： Test.java
 * 修改人：tianzhong
 * 修改时间：2016年11月7日
 * 修改内容：新增
 */
package com.better517na.forStudy.basic.generic.genericfield;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author tianzhong
 */
public class Test<T> extends ClassA<T> {
    @SuppressWarnings("unused")
    private T list;

    public void testA() throws Exception {
        Type t = Test.class.getDeclaredField("list").getGenericType();
        if (ParameterizedType.class.isAssignableFrom(t.getClass())) {
            for (Type t1 : ((ParameterizedType) t).getActualTypeArguments()) {
                System.out.print(t1 + ",");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) throws Exception {
        new Test<String>().testA();
        System.out.println("======getSuperclass======:");
        System.out.println(Test.class.getSuperclass().getName());
        System.out.println("======getGenericSuperclass======:");
        Type t = Test.class.getGenericSuperclass();
        System.out.println(t);
        if (ParameterizedType.class.isAssignableFrom(t.getClass())) {
            System.out.print("----------->getActualTypeArguments:");
            for (Type t1 : ((ParameterizedType) t).getActualTypeArguments()) {
                System.out.print(t1 + ",");
            }
            System.out.println();
        }
    }

    
    
}