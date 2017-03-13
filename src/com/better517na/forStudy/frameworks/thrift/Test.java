/*
 * 文件名：Test.java
 * 版权：Copyright 2007-2017 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： Test.java
 * 修改人：tianzhong
 * 修改时间：2017年3月13日
 * 修改内容：新增
 */
package com.better517na.forStudy.frameworks.thrift;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;

import com.better517na.forStudy.frameworks.thrift.service.IThriftTestServcie;

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
@ContextConfiguration("/com/better517na/config/spring/app-context*.xml")
public class Test {
    /**
     * 添加字段注释.
     */
    @Value("${thrift.port}")
    private static String serverPort;

    private static IThriftTestServcie.Client client = null;

    static {
        // thrift客户端
        TTransport transport = null;
        try {
            transport = new TSocket("localhost", Integer.valueOf(serverPort), 10000);
            // 协议要和服务端一致
            TProtocol protocol = new TBinaryProtocol(transport);
            // TProtocol protocol = new TCompactProtocol(transport);
            // TProtocol protocol = new TJSONProtocol(transport);
            // 
            client = new IThriftTestServcie.Client(protocol);
            transport.open();
        } catch (TTransportException e) {
            e.printStackTrace();
        } finally {
            if (null != transport) {
                transport.close();
            }
        }
    }

    /**
     * TODO 添加方法注释.
     * @throws TException 
     * 
     */
    @org.junit.Test
    public void thriftClient() throws TException {
        String result = client.invoke("thrift测试参数");
        System.out.println("Thrify client result =: " + result);
    }
}
