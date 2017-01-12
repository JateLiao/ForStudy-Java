/*
 * 文件名：DBUtil.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： DBUtil.java
 * 修改人：tianzhong
 * 修改时间：2016年7月1日
 * 修改内容：新增
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
public class DBUtil {
    public static Connection getConnection() {
        Connection conn = null;

        try {
            String driver = "com.mysql.jdbc.Driver"; // 数据库驱动
            String url = "jdbc:mysql://192.168.1.61:3306/TZDBTest";// 数据库
            String user = "betterdevread"; // 用户名
            String password = "root"; // 密码
            Class.forName(driver); // 加载数据库驱动
            if (null == conn) {
                conn = DriverManager.getConnection(url, user, password);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Sorry,can't find the Driver!");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }
}
