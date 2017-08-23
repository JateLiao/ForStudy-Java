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
import org.joda.time.Days;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;

/**
 * Joda Time 是一个java时间工具集合框架。
 * 比之于JDK原生繁琐和性能底下线程不安全的Calendar和Date两个API，
 * Joda Time代码更简洁，性能更高效，支持西线程安全（DateFormat）。
 * 
 * @author     tianzhong
 */
public class JodaTimeTest {

    @Test
    public void test1(){
        DateTime anyDate = new DateTime().withDate(2017, 8, 15);
        System.out.println(anyDate.toString());
        System.out.println("yyyy-MM-dd'T'HH:mm:ss: " + anyDate.toString("yyyy-MM-dd'T'HH:mm:ss"));
        
        anyDate = anyDate.plusDays(2);
        System.out.println(anyDate.toString());
        System.out.println("yyyy-MM-dd HH:mm:ss: " + anyDate.toString("yyyy-MM-dd HH:mm:ss"));
        
        Date date  = anyDate.toDate();
        System.out.println(date.toString());
    }
    
    @Test
    public void test2(){
        DateTime anyDate = new DateTime();
        System.out.println(anyDate.toString());
        System.out.println(anyDate.toString("yyyy-MM-dd HH:mm:ss"));
        System.out.println(anyDate.toString("yyyy年MM月dd日HH点mm分ss秒", Locale.SIMPLIFIED_CHINESE));
        
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss");
        DateTime newDate = DateTime.parse("2017-08-15T16:42:46", formatter);
        System.out.println("parse1: " + newDate.toString());
        
        newDate = formatter.parseDateTime("2017-09-26T16:42:46");
        System.out.println("parse2: " + newDate.toString());
    }
    
    @Test
    public void test3(){
        /*计算两个日期之间的时间差*/
        DateTime anyDate1 = new DateTime(2017, 8, 15, 14, 25, 32); // 2017-08-14 14:25:32
        DateTime anyDate2 = new DateTime(2016, 11, 15, 9, 48, 18); // 2016-11-15 09:48:15
        Days days = Days.daysBetween(anyDate2, anyDate1);
        System.out.println("Days Between: " + days.getDays()); // 为正：表示在第一个时间之前，反之则在第一个时间之后
    }
}
