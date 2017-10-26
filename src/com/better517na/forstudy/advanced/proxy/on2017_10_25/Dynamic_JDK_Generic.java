/*
 * 文件名：Dynamic_JDK_Generic.java
 * 版权：Copyright 2007-2017 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： Dynamic_JDK_Generic.java
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
 * <pre>
 * </pre>
 * 
 * @author     tianzhong
 */
public class Dynamic_JDK_Generic <T> implements InvocationHandler{
    
    /**
     * 构造函数.
     * 
     * @param helloImpl
     */
    public Dynamic_JDK_Generic(T t) {
        this.target = t;
    }

    public static void main(String[] args) {
        IHello hello = new HelloImpl();
        Dynamic_JDK_Generic<IHello> dynamic = new Dynamic_JDK_Generic<IHello>(hello);
        IHello proxy = dynamic.newGenericProxyInstance();
        proxy.sayHello("你瞅啥？？\r\n-------\r\n瞅你咋地？？\r\n");
        
        // 一行流
        new Dynamic_JDK_Generic<IHello>(hello).newGenericProxyInstance().sayHello("你再瞅试试？？\r\n-------\r\n试试就试试！！");
    }
    
    
    /**
     * 泛型：被代理的目标类.
     */
    private T target;
    
    @SuppressWarnings("unchecked")
    public T newGenericProxyInstance(){
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    /** 
     * {@inheritDoc}.
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
       return method.invoke(target, args);
    }

}
