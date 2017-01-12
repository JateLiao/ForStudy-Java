/*
 * 文件名：ClassA.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： ClassA.java
 * 修改人：tianzhong
 * 修改时间：2016年11月7日
 * 修改内容：新增
 */
package com.better517na.forStudy.basic.generic.genericfield;

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
public class ClassA<T> {
    private T obj;

    public void setObject(T obj) {
        this.obj = obj;
    }

    public T getObject() {
        return obj;
    }
}