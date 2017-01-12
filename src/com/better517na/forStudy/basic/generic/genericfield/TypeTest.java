/*
 * 文件名：TypeTest.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： TypeTest.java
 * 修改人：tianzhong
 * 修改时间：2016年11月7日
 * 修改内容：新增
 */
package com.better517na.forStudy.basic.generic.genericfield;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.TypeVariable;
import java.math.BigDecimal;

import org.junit.Test;

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
public class TypeTest {

    class Gen<K, V> {
        public String str;
        public K k;
        public V v;
    }
    
    class GT {
        public Integer i;
        Gen<String, BigDecimal> gen;
    }

    @Test
    public void genFieldTest(){
        GT gt = new GT(); 
        Field[] fields = gt.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.getGenericType() instanceof ParameterizedType) {
                //((ParameterizedType)field.getGenericType()).getActualTypeArguments()
                System.out.println(field.getName());
            }
        }
    }
    
    @Test
    public void test() throws NoSuchFieldException, SecurityException {
        System.out.println();
        
        for (Field fd : Response.class.getDeclaredFields()) {
            if (fd.getGenericType() instanceof TypeVariable) {
                 System.out.println(fd.getName() + ":" + fd.getGenericType().toString());
                TypeVariable[] tvs = ((TypeVariable)fd.getGenericType()).getGenericDeclaration().getTypeParameters();
                for (TypeVariable tv : tvs) {
                    if (tv == fd.getGenericType()) {
                        System.out.println(tv.getName());
                    }
                }
            }
        }
        
//        Field[] fds = r.getClass().getDeclaredFields();
//        for (Field fd : fds) {
//            fd.setAccessible(true);
//            System.out.println(fd.getName());
//            fd.getGenericType();
//            fd.getDeclaringClass().getName();
//            for (Field f : fd.getType().getClass().getDeclaredFields()){
//                f.setAccessible(true);
//                if ("genericInfo".equals(f.getName())) {
//                    System.out.println(f.getGenericType());
//                }
//                System.out.println(f.getName());
//            }
//        }
//        
//        System.out.println(r.getClass().getDeclaredField("obj").getGenericType());
//        
//        
//        System.out.println(123);
    }
}
