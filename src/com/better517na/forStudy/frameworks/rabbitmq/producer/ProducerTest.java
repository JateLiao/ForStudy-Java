/*
 * 文件名：ProducerTest.java
 * 版权：Copyright 2007-2017 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： ProducerTest.java
 * 修改人：tianzhong
 * 修改时间：2017年8月18日
 * 修改内容：新增
 */
package com.better517na.forStudy.frameworks.rabbitmq.producer;

import org.junit.Test;

import com.better517na.forStudy.frameworks.rabbitmq.Statics;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

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
public class ProducerTest {
    
    // @Before
    // public void connection

    @Test
    public void producer() throws Exception{
        System.out.println("生产者线程启动......");
        
        try {
            // 创建连接工厂
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("192.168.1.34"); // host
            factory.setVirtualHost(Statics.VHOST); // virtual host
            factory.setUsername(Statics.USERNAME); // username
            factory.setPassword(Statics.PASSWORD); // pwd
            factory.setPort(Statics.PORT); // port
            System.out.println("连接工厂创建完成:\r\n工厂信息: " + factory.getHost() + ": " + factory.getPort() + "===> UserName: " + factory.getUsername() + ", PassWord: " + factory.getPassword());

            // 创建一个连接
            Connection conn = factory.newConnection();
            System.out.println("连接创建成功: " + conn.getServerProperties().toString());

            // 创建一个通道
            Channel channel = conn.createChannel();
            System.out.println("通道创建成功: " + channel.toString());

            // 声明一个队列
            channel.queueDeclare(Statics.QUEUE_NAME, true, false, false, null);
            /*
             * queueDeclare:
             * 第一个参数表示队列名称、
             * 第二个参数为是否持久化（true表示是，队列将在服务器重启时生存）、
             * 第三个参数为是否是独占队列（创建者可以使用的私有队列，断开后自动删除）、
             * 第四个参数为当所有消费者客户端连接断开时是否自动删除队列、
             * 第五个参数为队列的其他参数
             * */
            String message = "Hello RabbitMQ";

            // 发送消息到队列中
            channel.basicPublish(Statics.EXCHANGE, Statics.QUEUE_NAME, null, message.getBytes("UTF-8"));
            System.out.println("Producer Send: " + message);

            // 关闭通道和连接
            channel.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println("生产完毕，测试结束!");
    }
}
