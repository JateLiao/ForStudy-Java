/*
 * 文件名：Tews.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： Tews.java
 * 修改人：tianzhong
 * 修改时间：2016年2月17日
 * 修改内容：新增
 */
package com.better517na.forStudy.quicktest.test;

import java.net.UnknownHostException;

/**
 * TODO 添加类的一句话简单描述.
 * <p>
 * TODO 详细描述
 * <p>
 * TODO 示例代码
 * 
 * <pre>
 * </pre>
 * 
 * @author tianzhong
 */
public class Test {
    public static void main(String[] args) throws UnknownHostException {
        B b = new B();
        // System.out.println(b instanceof A);
        System.out.println(b instanceof C);

        System.out.println(b.getClass().isAssignableFrom(C.class));
    }
}

class A {

}

class B implements C {

}

interface C {

}
