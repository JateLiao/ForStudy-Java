/*
 * 文件名：Anima.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： Anima.java
 * 修改人：tianzhong
 * 修改时间：2016年2月2日
 * 修改内容：新增
 */
package com.better517na.forstudy.advanced.reflect.on2016_2_1;

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
public class Animal {
    public String type;

    public float height;

    /**
     * 设置type.
     * 
     * @return 返回type
     */
    public String getType() {
        return type;
    }

    /**
     * 获取type.
     * 
     * @param type
     *            要设置的type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 设置height.
     * 
     * @return 返回height
     */
    public float getHeight() {
        return height;
    }

    /**
     * 获取height.
     * 
     * @param height
     *            要设置的height
     */
    public void setHeight(float height) {
        this.height = height;
    }
}
