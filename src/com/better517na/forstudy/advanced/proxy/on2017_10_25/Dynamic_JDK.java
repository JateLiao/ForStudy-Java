/*
 * 文件名：ProxyTEst1.java
 * 版权：Copyright 2007-2017 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： ProxyTEst1.java
 * 修改人：tianzhong
 * 修改时间：2017年10月25日
 * 修改内容：新增
 */
package com.better517na.forstudy.advanced.proxy.on2017_10_25;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

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
public class Dynamic_JDK implements InvocationHandler {

    public static void main(String[] args) {
        HelloImpl hello = new HelloImpl();
        Dynamic_JDK jdkDynamicProxy = new Dynamic_JDK(hello);
        IHello proxy = (IHello) Proxy.newProxyInstance(hello.getClass().getClassLoader(), hello.getClass().getInterfaces(), jdkDynamicProxy);
        proxy.sayHello("你瞅啥？？");
        
        
        IHello proxy2 = new Dynamic_JDK(hello).newProxyInstance();
        proxy2.sayHello("瞅你咋地？？");
    }

    /**
     * 被代理的目标对象.
     */
    private Object target;

    /**
     * 构造函数.
     * 
     */
    public Dynamic_JDK(Object obj) {
        this.target = obj;
    }

    @SuppressWarnings("unchecked")
    public <T> T newProxyInstance() {
        T t = (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
        return t;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(target, args);
    }

}
