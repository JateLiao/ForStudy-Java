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
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.springframework.test.context.ContextConfiguration;

import com.better517na.forStudy.frameworks.thrift.server.ThriftServer;
import com.better517na.forStudy.frameworks.thrift.service.IThriftTestServcie;
import com.better517na.forStudy.frameworks.thrift.service.IThriftTestServcie.Iface;
import com.better517na.forStudy.frameworks.thrift.service.impl.ThriftTestServcieImpl;

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
public class ClientTest {
    /**
     * 添加字段注释.
     */
    // @Resource(name = "thriftTestService")
    // private ThriftTestServcieImpl thriftTestService;

    /**
     * 添加字段注释.
     */
    // @Value("${thrift.port}")
    private static int serverPort = 9099;

    private static IThriftTestServcie.Client client = null;

    static {
        // thrift客户端
        TTransport transport = null;
        try {
            new Thread() { 
                public void run() {
                    new ThriftServer();
                };
            }.start();
            Thread.sleep(5000);
            transport = new TSocket("localhost", serverPort);
            // 协议要和服务端一致
            TProtocol protocol = new TBinaryProtocol(transport);
            client = new IThriftTestServcie.Client(protocol);
            transport.open();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != transport) {
                transport.close();
            }
        }
    }

    /**
     * TODO 添加方法注释.
     * 
     * @throws TException
     * 
     */
    @org.junit.Test
    public void thriftClient() throws TException {
        try {
            String result = client.invoke("thrift测试参数");
            System.out.println("Thrify client result =: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
