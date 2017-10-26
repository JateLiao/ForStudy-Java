package com.better517na.forstudy.advanced.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理.
 * 
 * @author tianzhong
 *
 */
public class DynamicProxy implements InvocationHandler {
    /**
     * 添加字段注释.
     */
    private Object target;

    /**
     * 构造函数.
     * 
     * @param t
     *            .
     */
    public DynamicProxy(Object t) {
        this.target = t;
    }

    /**
     * TODO 添加方法注释.
     * 
     */
    private void before() {
        System.out.println("Before");
    }

    /**
     * TODO 添加方法注释.
     * 
     */
    private void after() {
        System.out.println("After");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(target, args);
        after();
        return result;
    }

    /**
     * TODO 添加方法注释.
     * 
     * @return T .
     * @param <T>
     *            .
     */
    @SuppressWarnings("unchecked")
    public <T> T getProxy() {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    /**
     * TODO 添加方法注释.
     * 
     * @param args
     *            .
     */
    public static void main(String[] args) {
        DynamicProxy dynamicProxy = new DynamicProxy(new HelloImpl());
        IHello helloProxy = dynamicProxy.getProxy();

        helloProxy.say("Kobe");
        helloProxy.shut("Wade");
    }
}
