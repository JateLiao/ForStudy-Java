/*
 * 文件名：HttpToolProxyInfo.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： HttpToolProxyInfo.java
 * 修改人：zhengmo
 * 修改时间：2016年3月31日
 * 修改内容：新增
 */
package util;

import java.io.Serializable;

/**
 * Http请求代理信息类.
 * @author zhengmo
 */
public class HttpToolProxyInfo implements Serializable {
    /**
     * 序列化.
     */
    private static final long serialVersionUID = 1L;
    /**
     * 代理主机.
     */
    private String host;
    /** 
     * 代理端口.
     */
    private int port;
    /**
     * 代理用户名.
     */
    private String username;
    /**
     * 代理密码.
     */
    private String password;
    /**
     * 构造函数.
     * @param host 主机
     * @param port 端口
     */
    public HttpToolProxyInfo(String host, int port) {
        this.host = host;
        this.port = port;
    }
    /**
     * 构造函数.
     * @param host 主机
     * @param port 端口
     * @param username 用户名
     * @param password 密码
     */
    public HttpToolProxyInfo(String host, int port, String username, String password) {
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
    }
    /**
     * 构造函数.
     */
    public HttpToolProxyInfo() {
    }
    /**
     * 设置host.
     * @return 返回host
     */
    public String getHost() {
        return host;
    }
    /**
     * 获取host.
     * @param host 要设置的host
     */
    public void setHost(String host) {
        this.host = host;
    }
    /**
     * 设置port.
     * @return 返回port
     */
    public int getPort() {
        return port;
    }
    /**
     * 获取port.
     * @param port 要设置的port
     */
    public void setPort(int port) {
        this.port = port;
    }
    /**
     * 设置username.
     * @return 返回username
     */
    public String getUsername() {
        return username;
    }
    /**
     * 获取username.
     * @param username 要设置的username
     */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
     * 设置password.
     * @return 返回password
     */
    public String getPassword() {
        return password;
    }
    /**
     * 获取password.
     * @param password 要设置的password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
