/*
 * 文件名：JodaTimeTest.java
 * 版权：Copyright 2007-2017 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： JodaTimeTest.java
 * 修改人：tianzhong
 * 修改时间：2017年8月14日
 * 修改内容：新增
 */
package com.better517na.forStudy.frameworks.jodatime;

import java.util.Date;
import java.util.Locale;

import org.joda.time.DateTime;
import org.junit.Test;

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
public class JodaTimeTest {

    @Test
    public void test1(){
        DateTime anyDate = new DateTime().withDate(2017, 8, 15);
        System.out.println(anyDate.toString());
        System.out.println(anyDate.toString("yyyy-MM-dd HH:mm:ss"));
        
        anyDate = anyDate.plusDays(2);
        System.out.println(anyDate.toString());
        System.out.println(anyDate.toString("yyyy-MM-dd HH:mm:ss"));
        
        Date date  = anyDate.toDate();
        System.out.println(date.toString());
    }
    
    @Test
    public void test2(){
        DateTime anyDate = new DateTime();
        System.out.println(anyDate.toString());
        System.out.println(anyDate.toString("yyyy-MM-dd HH:mm:ss"));
        System.out.println(anyDate.toString("yyyy年MM月dd日HH点mm分ss秒", Locale.SIMPLIFIED_CHINESE));
        
    }
}
