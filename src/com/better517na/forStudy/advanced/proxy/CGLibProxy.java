/*
 * 文件名：CGLibProxy.java
 * 版权：Copyright 2007-2015 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： CGLibProxy.java
 * 修改人：tianzhong
 * 修改时间：2015年12月28日
 * 修改内容：新增
 */
package com.better517na.forStudy.advanced.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * TODO 添加类的一句话简单描述.
 * 
 * @author tianzhong
 */
public class CGLibProxy implements MethodInterceptor {
    /**
     * 添加字段注释.
     */
    private static final CGLibProxy instance = new CGLibProxy();

    /**
     * 构造函数.
     * 
     */
    private CGLibProxy() {
    }

    /**
     * TODO 添加方法注释.
     * 
     * @return CGLibProxy
     */
    public static CGLibProxy getInstance() {
        return instance;
    }

    /**
     * TODO 添加方法注释.
     * 
     * @param cls
     *            .
     * @return T .
     * @param <T>
     *            .
     */
    @SuppressWarnings("unchecked")
    public <T> T getProxy(Class<T> cls) {
        return (T) Enhancer.create(cls, this);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        before();
        Object result = proxy.invokeSuper(obj, args);
        after();
        return result;
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

    /**
     * TODO 添加方法注释.
     * 
     * @param args
     *            .
     */
    public static void main(String[] args) {
        // CGLibProxy cgLibProxy = new CGLibProxy();
        // HelloImpl hello = cgLibProxy.getProxy(HelloImpl.class);
        HelloImpl hello = CGLibProxy.getInstance().getProxy(HelloImpl.class);
        hello.say("Wade");

        hello.shut("Jordan");
    }
}
