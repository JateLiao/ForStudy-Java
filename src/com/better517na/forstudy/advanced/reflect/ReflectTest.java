/*
 * 文件名：ReflectTest.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： ReflectTest.java
 * 修改人：tianzhong
 * 修改时间：2016年11月24日
 * 修改内容：新增
 */
package com.better517na.forstudy.advanced.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.TypeVariable;
import java.util.List;

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
public class ReflectTest {
    class P{
        
    }
    class Ads<T>{
        T adv;
        List<Object> aaa;
        String ate;
        P p;
    }

    @Test
    public void test1(){
        Field[] fds = Ads.class.getDeclaredFields();
        for (Field fd : fds) {
            if (fd.getType() instanceof Object && fd.getGenericType() instanceof TypeVariable) {
                System.out.println(fd.getName());
            }
            
            // if (fd.getGenericType() instanceof ParameterizedType) {
            // System.out.println(fd.getName());
            // }
        }
    }
}
