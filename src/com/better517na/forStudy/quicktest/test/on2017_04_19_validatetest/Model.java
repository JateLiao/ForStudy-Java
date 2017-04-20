/*
 * 文件名：Model.java
 * 版权：Copyright 2007-2017 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： Model.java
 * 修改人：tianzhong
 * 修改时间：2017年4月19日
 * 修改内容：新增
 */
package com.better517na.forStudy.quicktest.test.on2017_04_19_validatetest;

import com.better517na.annotation.NotNull;

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
public class Model {
    
    @NotNull(name="编码")
    private String id;
    
    @NotNull(name="名称")
    private String name;
    
    @NotNull(name="描述")
    private String desc;
    
    /**
     * 设置id.
     * 
     * @return 返回id
     */
    public String getId() {
        return id;
    }

    /**
     * 获取id.
     * 
     * @param id
     *            要设置的id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 设置name.
     * 
     * @return 返回name
     */
    public String getName() {
        return name;
    }

    /**
     * 获取name.
     * 
     * @param name
     *            要设置的name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 设置desc.
     * 
     * @return 返回desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * 获取desc.
     * 
     * @param desc
     *            要设置的desc
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

}
