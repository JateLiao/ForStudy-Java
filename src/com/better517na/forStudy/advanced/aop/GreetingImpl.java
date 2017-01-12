/*
 * 文件名：GreetingImpl.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： GreetingImpl.java
 * 修改人：tianzhong
 * 修改时间：2016年3月18日
 * 修改内容：新增
 */
package com.better517na.forStudy.advanced.aop;

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
public class GreetingImpl implements IGreeting {
    @Override
    public void sayHello(String name) {
        before();
        System.out.println("Hello! " + name);
        after();
    }

    private void before() {
        System.out.println("Before");
    }

    private void after() {
        System.out.println("After");
    }

    public static void main(String[] args) {
        new GreetingImpl().sayHello("Kobe Bryant");
    }
}
