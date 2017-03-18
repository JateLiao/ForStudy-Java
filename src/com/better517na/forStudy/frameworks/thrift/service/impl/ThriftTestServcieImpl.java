/*
 * 文件名：ThriftTestServcieImpl.java
 * 版权：Copyright 2007-2017 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： ThriftTestServcieImpl.java
 * 修改人：tianzhong
 * 修改时间：2017年3月13日
 * 修改内容：新增
 */
package com.better517na.forStudy.frameworks.thrift.service.impl;

import org.apache.thrift.TException;
import org.springframework.stereotype.Component;

import com.better517na.forStudy.frameworks.thrift.service.IThriftTestServcie.Iface;

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
@Component("thriftTestService")
public class ThriftTestServcieImpl implements Iface {

    /**
     * {@inheritDoc}.
     */
    @Override
    public String invoke(String para) throws TException {
        System.out.println("接收参数：" + para);
        return "thrift服务测试成功返回!!!";
    }
}
