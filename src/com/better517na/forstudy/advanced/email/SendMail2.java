/*
 * 文件名：SendMail2.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： SendMail2.java
 * 修改人：tianzhong
 * 修改时间：2016年2月25日
 * 修改内容：新增
 */
package com.better517na.forstudy.advanced.email;

import javax.mail.internet.MimeUtility;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

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
public class SendMail2 {// smtp服务器
    private String hostName = "smtp.163.com";

    // 帐号与密码
    private String userName = "lsj24legend@163.com";

    private String password = "lsj118114";

    // 发件人
    private String fromAddress = "lsj24legend@163.com";

    // 发件人姓名
    private String fromName = "现象级吃货";

    public static void main(String[] args) throws Exception {
        // 收件人与收件人名字
        String toAddress = "374682617@qq.com"; //
        String toName = "Kobe";
        SendMail2 test = new SendMail2();
        // 所有的异常都为处理，方便浏览
        test.sendSimpleEmail(toAddress, toName);
        // test.sendHtmlEmail(toAddress, toName);
        // test.sendMultiPartEmail(toAddress, toName);
        System.out.println("发送完成");
    }

    // 发送简单邮件，类似一条信息
    public void sendSimpleEmail(String toAddress, String toName) throws Exception {
        try {
            SimpleEmail email = new SimpleEmail();
            // email.setSSL(Boolean.TRUE); // 设定是否使用SSL
            // email.setSslSmtpPort("465");
            // email.setSmtpPort(25);
            email.setHostName(hostName);// 设置smtp服务器
            email.setAuthentication(userName, password);// 设置授权信息
            email.setCharset("utf-8");
            email.setFrom(fromAddress, fromName, "utf-8");// 设置发件人信息
            email.addTo(toAddress, toName, "utf-8");// 设置收件人信息
            email.setSubject("测试主题");// 设置主题
            email.setMsg("这是一个简单的测试！");// 设置邮件内容
            email.send();// 发送邮件
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 发送Html内容的邮件
    public void sendHtmlEmail(String toAddress, String toName) throws Exception {
        HtmlEmail email = new HtmlEmail();
        email.setHostName(hostName);
        email.setAuthentication(userName, password);
        email.setCharset("utf-8");
        email.addTo(toAddress, toName, "utf-8");
        email.setFrom(fromAddress, fromName, "utf-8");
        email.setSubject("这是一个html邮件");
        // 设置html内容，实际使用时可以从文本读入写好的html代码
        email.setHtmlMsg("<div style='width:100px;height:200px;'>这是一个html邮件</div>");
        email.send();
    }

    // 发送复杂的邮件，包含附件等
    public void sendMultiPartEmail(String toAddress, String toName) throws Exception {
        MultiPartEmail email = null;
        email = new MultiPartEmail();
        email.setHostName(hostName);
        email.setAuthentication(userName, password);
        email.setCharset("utf-8");
        email.addTo(toAddress, toName, "utf-8");
        email.setFrom(fromAddress, fromName, "utf-8");
        email.setSubject("这是有附件的邮件");
        email.setMsg("<a href='#'>测试内容</a>");
        // 为邮件添加附加内容
        EmailAttachment attachment = new EmailAttachment();
        attachment.setPath("D:\\邮件.txt");// 本地文件
        // attachment.setURL(new URL("http://xxx/a.gif"));//远程文件
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setDescription("描述信息");
        // 设置附件显示名字，必须要编码，不然中文会乱码
        attachment.setName(MimeUtility.encodeText("邮件.txt"));
        // 将附件添加到邮件中
        email.attach(attachment);
        email.send();
    }
}
