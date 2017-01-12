/*
 * 文件名：GuavaTest1.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： GuavaTest1.java
 * 修改人：tianzhong
 * 修改时间：2016年11月17日
 * 修改内容：新增
 */
package com.better517na.forStudy.frameworks.guava.first;

import java.io.IOException;

import org.junit.Test;

import com.google.common.reflect.ClassPath;

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
public class GuavaTest1 {
    
    @Test
    public void test() throws IOException {
        ClassPath cp = ClassPath.from(new Student().getClass().getClassLoader());
        for (ClassPath.ClassInfo ci : cp.getTopLevelClasses("com.better517na.forStudy.AOP")) {
            System.out.println(ci.getName());
        }
    }
}
