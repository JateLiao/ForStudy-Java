/*
 * 文件名：HelloImpl.java
 * 版权：Copyright 2007-2017 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： HelloImpl.java
 * 修改人：tianzhong
 * 修改时间：2017年10月25日
 * 修改内容：新增
 */
package com.better517na.forStudy.advanced.proxy.on2017_10_25;

/**
 * @author tianzhong
 */
public class HelloImpl implements IHello {

    /**
     * {@inheritDoc}.
     */
    @Override
    public void sayHello(String conent) {
        System.out.println("Somebody say: " + conent);
    }

}
