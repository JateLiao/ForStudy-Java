/*
 * 文件名：GenericTest.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： GenericTest.java
 * 修改人：tianzhong
 * 修改时间：2016年10月13日
 * 修改内容：新增
 */
package com.better517na.forStudy.advanced.reflect.on2016_10_13;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

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
public class GenericTest {
    class GenTest<T> {
        public int i;
        public T obj;
    }
    
    class SubGenTest {
        GenTest<String> genTest; 
    }
    
    @Test
    public void test2(){
        // ParameterizedType
        SubGenTest subGenTest = new SubGenTest();
        GenTest<String> genTest = new GenTest<String>();
        subGenTest.genTest = genTest;
        
        Field[] fds = subGenTest.getClass().getDeclaredFields();
        for (Field fd : fds) {
            fd.setAccessible(true);
            if ("genTest".equals(fd.getName())) {
                Type type = fd.getGenericType();
                if (type instanceof ParameterizedType) {
                    Type[] tps = ((ParameterizedType)type).getActualTypeArguments();
                    System.out.println(tps[0]);
                }
            }
        }
    }
}
