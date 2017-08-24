/*
 * 文件名：CntDwnLtchRunner.java
 * 版权：Copyright 2007-2017 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： CntDwnLtchRunner.java
 * 修改人：tianzhong
 * 修改时间：2017年8月18日
 * 修改内容：新增
 */
package com.better517na.forStudy.advanced.concurrent.concurrenttest.on20170818;

import java.util.concurrent.CountDownLatch;

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
public class CntDwnLtchRunner implements Runnable {

    /**
     * 添加字段注释.
     */
    private String name;

    /**
     * 构造函数.
     * 
     * @param string
     */
    public CntDwnLtchRunner(String name) {
        this.name = name;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void run() {
        System.out.println(this.name + "已启动!");
        CountDownLatchTest.cntDwnLatch.countDown();
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

}
