/*
 * 文件名：GreetingAroundAdvice.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： GreetingAroundAdvice.java
 * 修改人：tianzhong
 * 修改时间：2016年3月22日
 * 修改内容：新增
 */
package com.better517na.forstudy.advanced.aop.aroundadvice;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @author tianzhong
 */
public class GreetingAroundAdvice implements MethodInterceptor {

    /**
     * {@inheritDoc}.
     */
    @Override
    public Object intercept(Object paramObject, Method paramMethod, Object[] paramArrayOfObject, 
            MethodProxy paramMethodProxy) throws Throwable {
        return null;
    }

}
