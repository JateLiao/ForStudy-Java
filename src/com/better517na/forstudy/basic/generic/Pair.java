/*
 * 文件名：Pair.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： Pair.java
 * 修改人：tianzhong
 * 修改时间：2016年6月3日
 * 修改内容：新增
 */
package com.better517na.forstudy.basic.generic;

import java.util.Date;

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
public class Pair<T> {
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

class DateInter extends Pair<Date> {
    @Override
    public void setValue(Date value) {
        super.setValue(value);
    }

    @Override
    public Date getValue() {
        return super.getValue();
    }
}
