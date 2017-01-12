/*
 * 文件名：MyParameterizedType.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： MyParameterizedType.java
 * 修改人：tianzhong
 * 修改时间：2016年11月7日
 * 修改内容：新增
 */
package com.better517na.forStudy.basic.generic.genericfield;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

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
@SuppressWarnings("rawtypes")
public class MyParameterizedType implements ParameterizedType {
    
    /**
     * 添加字段注释.
     */
    private Class clz;

    /**
     * 添加字段注释.
     */
    private Class[] actualTypes;

    /**
     * 构造函数.
     * 
     */
    public MyParameterizedType(Class clz, Class... actualTypes) {
        super();
        this.clz = clz;
        this.actualTypes = actualTypes;
    }

    /**
     * 设置clz.
     * 
     * @return 返回clz
     */
    public Class getClz() {
        return clz;
    }

    /**
     * 获取clz.
     * 
     * @param clz 要设置的clz
     */
    public void setClz(Class clz) {
        this.clz = clz;
    }

    /**
     * 设置actualTypes.
     * 
     * @return 返回actualTypes
     */
    public Class[] getActualTypes() {
        return actualTypes;
    }

    /**
     * 获取actualTypes.
     * 
     * @param actualTypes 要设置的actualTypes
     */
    public void setActualTypes(Class[] actualTypes) {
        this.actualTypes = actualTypes;
    }

    /** 
     * {@inheritDoc}.
     */
    @Override
    public Type[] getActualTypeArguments() {
        return actualTypes;
    }

    /** 
     * {@inheritDoc}.
     */
    @Override
    public Type getOwnerType() {
        return null;
    }

    /** 
     * {@inheritDoc}.
     */
    @Override
    public Type getRawType() {
        return clz;
    }
}
