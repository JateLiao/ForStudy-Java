/*
 * 文件名：Test3.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： Test3.java
 * 修改人：tianzhong
 * 修改时间：2016年5月20日
 * 修改内容：新增
 */
package com.better517na.forstudy.basic.generic;

import java.io.Serializable;

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
public class Test4 {
    public static void main(String[] args) throws Exception {
        Bear<Integer> p = new Bear<Integer>();

        System.out.println(p.getClass());

        p.setValue(456);
        System.out.println(p.getValue());

        p.getClass().getMethod("setValue", Object.class).invoke(p, "abc");
        System.err.println(p.getValue());
    }
}

@SuppressWarnings("rawtypes")
class Bear<T extends Comparable & Serializable> {
    /**
     * 添加字段注释.
     */
    private T value;

    /**
     * 设置value.
     * 
     * @return 返回value
     */
    public T getValue() {
        return value;
    }

    /**
     * 获取value.
     * 
     * @param value
     *            要设置的value
     */
    public void setValue(T value) {
        this.value = value;
    }
}