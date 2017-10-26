/*
 * 文件名：SendMail.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： SendMail.java
 * 修改人：tianzhong
 * 修改时间：2016年2月25日
 * 修改内容：新增
 */
package com.better517na.forstudy.advanced.email;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

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
public class SendMail {
    // 方法一：使用transport对象发送邮件
    public static void main(String[] args) {
        String user = "374682617";
        String password = "htt374682617";

        String fromAddress = "374682617@qq.com";
        String toAddress = "lsj24legend@163.com";
        String subject = "邮件测试主题";
        String content = "这是一个测试邮件<b>哈哈</b>";
        // 配置参数
        Properties props = new Properties();
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.host", "smtp.qq.com");
        try {
            // 通过参数生成会话
            Session session = Session.getInstance(props);
            // 启用调试模式
            session.setDebug(true);
            // 创建一封邮件，并设置信息
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromAddress));
            message.setSubject(subject);
            message.setText(content);
            // 创建传输
            Transport transport = session.getTransport();
            // 连接smtp服务器
            transport.connect(user, password);
            // 发送
            transport.sendMessage(message, new InternetAddress[]{new InternetAddress(toAddress)});
            transport.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
