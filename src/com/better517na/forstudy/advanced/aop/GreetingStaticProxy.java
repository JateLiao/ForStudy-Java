/*
 * 文件名：GreetingStaticProxy.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： GreetingStaticProxy.java
 * 修改人：tianzhong
 * 修改时间：2016年3月18日
 * 修改内容：新增
 */
package com.better517na.forstudy.advanced.aop;

/**
 * TODO 静态代理.
 * 
 * @author tianzhong
 */
public class GreetingStaticProxy implements IGreeting {
    private IGreeting greeting;

    public GreetingStaticProxy(IGreeting greeting) {
        this.greeting = greeting;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void sayHello(String name) {
        before();
        greeting.sayHello(name);
        after();
    }

    private void before() {
        System.out.println("Before");
    }

    private void after() {
        System.out.println("After");
    }

    public static void main(String[] args) {
        GreetingStaticProxy greetingProxy = new GreetingStaticProxy(new GreetingImpl());
        greetingProxy.sayHello("Jack");
    }
}
