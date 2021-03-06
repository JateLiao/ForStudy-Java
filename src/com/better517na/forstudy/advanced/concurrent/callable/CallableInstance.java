/*
 * 文件名：CallableInstance.java
 * 版权：Copyright 2007-2017 Liao Shijie Tech. Co. Ltd. All Rights Reserved. 
 * 描述： CallableInstance.java
 * 修改人：KOBE
 * 修改时间：2017年2月28日
 * 修改内容：新增
 */
package com.better517na.forstudy.advanced.concurrent.callable;

import java.util.concurrent.Callable;

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
 * @author KOBE
 */
public class CallableInstance /*extends Thread*/ implements Callable<String> {
    
    /**
     * 添加字段注释.
     */
    private String currentName;

    /**
     * 构造函数.
     * 
     */
    public CallableInstance(String name) {
        this.currentName = name;
        // super(name);
        // Thread.currentThread().setName(name);
        // Thread.currentThread().setPriority(1);
        // Thread.yield();
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public String call() throws Exception {
        // return Thread.currentThread().getName();
        System.out.println("当前线程名: " + Thread.currentThread().getName() + ", 当前线程优先级: " + Thread.currentThread().getPriority());
        return this.currentName;
    }

}
