/*
 * 文件名：FinalTest.java
 * 版权：Copyright 2007-2018 Liao Shijie Tech. Co. Ltd. All Rights Reserved. 
 * 描述： FinalTest.java
 * 修改人：liao
 * 修改时间：2018年2月25日
 * 修改内容：新增
 */
package com.better517na.forstudy.basic.finalJ;

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
 * @author liao
 */
public class FinalTest {

    private final String finalStr;
    private final Integer finalInt;

    /**
     * 构造函数.
     * 
     */
    public FinalTest() {
        // 对于final类型的变量，没有在声明时初始化的，就必须在构造函数内初始化
        this.finalStr = "default final String";
        this.finalInt = 0;
    }

    /**
     * 构造函数.
     * 
     */
    public FinalTest(int defaultInt) {
        // 对于final类型的变量，没有在声明时初始化的，就必须在构造函数内初始化
        // 同时，如果有多个final类型的域在声明时未被初始化，那么所有的构造函数都必须将这些没被初始化的域都初始化。
        this.finalStr = "default final String";
        this.finalInt = 0;
    }
}
