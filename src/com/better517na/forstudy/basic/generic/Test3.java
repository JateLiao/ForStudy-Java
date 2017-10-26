/*
 * 文件名：Test3.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： Test3.java
 * 修改人：tianzhong
 * 修改时间：2016年5月20日
 * 修改内容：新增
 */
package com.better517na.forstudy.basic.generic;

import java.util.Date;

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
public class Test3 {
    public static void main(String[] args) throws Exception {
        Pair<String> p = new Pair<String>();

        System.out.println(p.getClass());

        p.setValue("test");
        System.out.println(p.getValue());

        p.getClass().getMethod("setValue", Object.class).invoke(p, new Date().toString());
        System.err.println(p.getValue());
    }
}