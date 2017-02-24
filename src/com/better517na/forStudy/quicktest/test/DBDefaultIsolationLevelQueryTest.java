/*
 * 文件名：DBIsolationLevelQueryTest.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： DBIsolationLevelQueryTest.java
 * 修改人：tianzhong
 * 修改时间：2016年7月1日
 * 修改内容：新增
 */
package com.better517na.forStudy.quicktest.test;

import java.sql.DatabaseMetaData;

import util.DBUtil;

/**
 * TODO 数据库默认隔离级别查询测试.
 * 
 * @author tianzhong
 */
public class DBDefaultIsolationLevelQueryTest {
    public static void main(String[] args) {
        int level = -1;

        try {
            DatabaseMetaData meta = DBUtil.getConnection().getMetaData();
            level = meta.getDefaultTransactionIsolation();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(level);
    }
}
