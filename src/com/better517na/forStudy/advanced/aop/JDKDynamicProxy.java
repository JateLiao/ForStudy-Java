/*
 * 文件名：CreetingJDKDynamicProxy.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： CreetingJDKDynamicProxy.java
 * 修改人：tianzhong
 * 修改时间：2016年3月18日
 * 修改内容：新增
 */
package com.better517na.forStudy.advanced.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * TODO JDK动态代理.
 * 
 * @author tianzhong
 */
public class JDKDynamicProxy implements InvocationHandler {
    private Object target;

    public JDKDynamicProxy(Object obj) {
        this.target = obj;
    }

    @SuppressWarnings("unchecked")
    public <T> T getProxy() {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public Object invoke(Object arg0, Method arg1, Object[] arg2) throws Throwable {
        before();
        Object result = arg1.invoke(target, arg2);
        after();
        return result;
    }

    private void before() {
        System.out.println("Before");
    }

    private void after() {
        System.out.println("After");
    }

    public static void main(String[] args) {
        IGreeting greeting = new JDKDynamicProxy(new GreetingImpl()).getProxy();
        greeting.sayHello("Jack");
    }

}
