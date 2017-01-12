/*
 * 文件名：Test2.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： Test2.java
 * 修改人：tianzhong
 * 修改时间：2016年12月12日
 * 修改内容：新增
 */
package com.better517na.forStudy.basic.on2016_12_12_valuepass_preferencepass;

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
public class Test2 {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    static void setName(Test2 student) {
        student.setName("@@@");
    }

    @Test
    public void test1() {
        Test2 student = new Test2();
        student.setName("!!!");
        System.err.println(student.getName());
        setName(student);
        System.err.println(student.getName());
    }
}
