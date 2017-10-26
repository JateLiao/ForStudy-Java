/*
 * 文件名：HelloProxy_Dynamic_Cglib.java
 * 版权：Copyright 2007-2017 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： HelloProxy_Dynamic_Cglib.java
 * 修改人：tianzhong
 * 修改时间：2017年10月25日
 * 修改内容：新增
 */
package com.better517na.forstudy.advanced.proxy.on2017_10_25;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

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
public class Dynamic_CGLIB implements MethodInterceptor{
    public static void main(String[] args) {
        IHello hello = Dynamic_CGLIB.newGenericProxyInstance(HelloImpl.class);
        hello.sayHello("你瞅啥？？\r\n-------\r\n瞅你咋地？？\r\n");
    }
    
    // 单例模式
    private static final Dynamic_CGLIB PROXY = new Dynamic_CGLIB();
    
    /**
     * 单例模式.
     * 
     */
    private Dynamic_CGLIB(){
    }

    @SuppressWarnings("unchecked")
    public static <T> T newGenericProxyInstance(Class<T> clss){
        return (T) Enhancer.create(clss, PROXY);
    }
    /** 
     * {@inheritDoc}.
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        return proxy.invokeSuper(obj, args);
    }

}
