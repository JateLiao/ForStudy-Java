/*
 * 文件名：ProducerTest.java
 * 版权：Copyright 2007-2017 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： ProducerTest.java
 * 修改人：tianzhong
 * 修改时间：2017年8月18日
 * 修改内容：新增
 */
package com.better517na.forStudy.frameworks.rabbitmq.producer;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.joda.time.DateTime;
import org.junit.Test;

import com.better517na.forStudy.frameworks.rabbitmq.Statics;
import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.ReturnListener;
import com.rabbitmq.client.ShutdownListener;
import com.rabbitmq.client.ShutdownSignalException;

/**
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
            if (!conn.isOpen()) {
                System.out.println("连接不能被创建!!!");
                throw new Exception("连接不能被创建!!!");
            }
            System.out.println("连接创建成功: " + conn.getServerProperties().toString());

            // 创建一个通道
            Channel channel = conn.createChannel();
            System.out.println("通道创建成功: " + channel.toString());

            channel.addReturnListener(new ReturnListener() {
                
                @Override
                public void handleReturn(int arg0, String arg1, String arg2, String arg3, BasicProperties arg4, byte[] arg5) throws IOException {
                    System.out.println("请确保路由是否正确");
                }
            });
            channel.addShutdownListener(new ShutdownListener() {
                
                @Override
                public void shutdownCompleted(ShutdownSignalException shutdownsignalexception) {
                    System.out.println("通道被关闭!!!");
                }
            });
            if (!channel.isOpen()) {
                System.out.println("通道被关闭原因：" + channel.getCloseReason());
                throw new Exception("通道已被关闭!!!");
            }
            
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
            String message = "Hello RabbitMQ For TianZhong Test.";
            Map<String, Object> headers = new HashMap<>();
            headers.put("sent_time", new DateTime().toString("yyyy-MM-dd HH:mm:ss"));
            headers.put("producer_pid", String.valueOf(Thread.currentThread().getName()));
            headers.put("traker_id", "traker_id");
            headers.put("producer_addr", InetAddress.getLocalHost().getHostAddress());
            BasicProperties properties = new BasicProperties("text/plain", "utf-8", headers, 2, 1, "correlationId", "replyTo", "expiration", "messageId", new Date(), 
                    "type", "userId", "appId","clusterId");
            // 发送消息到队列中
            channel.basicPublish(Statics.EXCHANGE, Statics.ROUTE_KEY, properties, message.getBytes("UTF-8"));
            /*basicPublish:
             * 第一个参数为交换机名称、
             * 第二个参数为队列映射的路由key、
             * 第三个参数为消息的其他属性、
             * 第四个参数为发送信息的主体
             */
            System.out.println("Producer Send: " + message);

            // 关闭通道和连接
            if (null != channel && channel.isOpen()) {
                channel.close();
            }
            if (null != conn && conn.isOpen()) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println("生产完毕，测试结束!");
    }
}
