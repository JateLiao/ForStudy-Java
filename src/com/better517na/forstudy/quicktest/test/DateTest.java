/*
 * 文件名：DateTest.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： DateTest.java
 * 修改人：tianzhong
 * 修改时间：2016年9月21日
 * 修改内容：新增
 */
package com.better517na.forstudy.quicktest.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class DateTest {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = sf.parse("2016-9-21");
        Date d2 = sf.parse("2016-9-20");
        System.out.println(d1.compareTo(d2));
    }
}
