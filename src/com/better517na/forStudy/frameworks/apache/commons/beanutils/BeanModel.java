/*
 * 文件名：BeanModel.java
 * 版权：Copyright 2007-2017 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： BeanModel.java
 * 修改人：tianzhong
 * 修改时间：2017年8月4日
 * 修改内容：新增
 */
package com.better517na.forStudy.frameworks.apache.commons.beanutils;

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
public class BeanModel {

    private String id;

    private String name;

    private int age;

    private Integer height;

    private String desc;

    /**
     * 添加字段注释.
     */
    private TmpClass tmp;
    
    /** 
     * {@inheritDoc}.
     */
    @Override
    public String toString() {
        System.out.println(super.toString());
        return this.id + ", " + this.name + ", " + this.age + ", " + this.height + ", " 
                + this.desc + "  (TmpInfo: " + (null != this.getTmp() ? this.getTmp().toString() : "null") + ")";
    }
    
    /**
     * 构造函数.
     * 
     */
    public BeanModel() {
        // TODO Auto-generated constructor stub
    }

    /**
     * 构造函数.
     * 
     */
    public BeanModel(String id, String name, int age, Integer height, String desc, TmpClass tmp) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.height = height;
        this.desc = desc;
        this.tmp = tmp;
    }

    /**
     * 设置age.
     * 
     * @return 返回age
     */
    public int getAge() {
        return age;
    }

    /**
     * 获取age.
     * 
     * @param age
     *            要设置的age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 设置height.
     * 
     * @return 返回height
     */
    public Integer getHeight() {
        return height;
    }

    /**
     * 获取height.
     * 
     * @param height
     *            要设置的height
     */
    public void setHeight(Integer height) {
        this.height = height;
    }

    /**
     * 设置tmp.
     * 
     * @return 返回tmp
     */
    public TmpClass getTmp() {
        return tmp;
    }

    /**
     * 获取tmp.
     * 
     * @param tmp
     *            要设置的tmp
     */
    public void setTmp(TmpClass tmp) {
        this.tmp = tmp;
    }

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
