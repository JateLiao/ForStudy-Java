/*
 * 文件名：Test7.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： Test7.java
 * 修改人：tianzhong
 * 修改时间：2016年6月3日
 * 修改内容：新增
 */
package com.better517na.forstudy.basic.generic;

import java.sql.Date;

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
public class Test7<E> {

    public static void main(String[] args) {
        DateInter dateInter = new DateInter();
        dateInter.setValue(new Date(0));
        // dateInter.setValue(new Object());// 编译错误

        int i = 0;
        try {
            i = 1;
            i = 2;
            i = (2 / 0);
            i = 3;
            i = 4;
            i = 5;
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(i);
    }
}
