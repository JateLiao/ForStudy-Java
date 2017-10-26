/*
 * 文件名：ConsumerTest.java
 * 版权：Copyright 2007-2017 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： ConsumerTest.java
 * 修改人：tianzhong
 * 修改时间：2017年8月18日
 * 修改内容：新增
 */
package com.better517na.forstudy.frameworks.rabbitmq.consumer;

import java.io.IOException;

import com.better517na.forstudy.frameworks.rabbitmq.Statics;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

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
public class ConsumerTest {
    
    public static void main(String[] args) {
        System.out.println("消费者开始消费消息队列......");
        try {
            // 创建连接工厂
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("192.168.1.116"); // host
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
            
            // 创建一个通道
            Channel channel = conn.createChannel();
            //声明要关注的队列
            channel.queueDeclare(Statics.QUEUE_NAME, true, false, false, null);
            
            //DefaultConsumer类实现了Consumer接口，通过传入一个频道，
            // 告诉服务器我们需要那个频道的消息，如果频道中有消息，就会执行回调函数handleDelivery
            Consumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    String message = new String(body, "UTF-8");
                    System.out.println("本次消费消息: " + message);
                }
            };
            
            //自动回复队列应答 -- RabbitMQ中的消息确认机制
            channel.basicConsume(Statics.QUEUE_NAME, true, consumer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("消费完毕!!!");
    }
}
