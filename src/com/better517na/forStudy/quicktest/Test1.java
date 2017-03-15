/*
 * 文件名：Test1.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： Test1.java
 * 修改人：tianzhong
 * 修改时间：2016年12月20日
 * 修改内容：新增
 */
package com.better517na.forStudy.quicktest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

/**
 * @author     tianzhong
 */
public class Test1 {

    @Test
    public void test1(){
        String a = "asd";
        String b = a.replace("a", "A");
        System.out.println(a);
        System.out.println(b); 
    }

    @Test
    public void test2() throws ParseException{
        Date d1 = new Date();
        Date d2 = new SimpleDateFormat("yyyy-MM-dd").parse("2016-12-28");
        Integer day = (int) ((d2.getTime() - d1.getTime()) / TimeUnit.DAYS.toMillis(1));
        System.out.println(day);
        
    }

    @Test
    public void test3() throws ParseException{
        String s = "A a = new A();";
        String ss = "com.lsj.";
        String res = ss + s.substring(0, s.indexOf("new ") + "new ".length()) + ss + s.subSequence(s.indexOf("new ") + "new ".length(), s.length());
        System.out.println(res);
    }

    
    class DateA { 
        public DateA(){
        }
        public DateA(Date ddd) {
            this.d = ddd;
        }
        Date d;
    }
    @Test
    public void test4() throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<DateA> dl = new ArrayList<>();
        dl.add(new DateA(sdf.parse("2016-10-25")));
        dl.add(new DateA(sdf.parse("2017-01-11")));
        dl.add(new DateA(sdf.parse("2016-11-11")));
        dl.add(new DateA(sdf.parse("2016-01-01")));
        dl.add(new DateA(sdf.parse("2017-11-25")));
        dl.add(new DateA(sdf.parse("2016-06-11")));
//        Collections.sort(dl, dl.get(0));
//        
//        for (Date date : dl) {
//            System.out.println(sdf.format(date));
//        }
    }
    @Test
    public void test5() throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<Date> dl = new ArrayList<>();
        dl.add(sdf.parse("2016-10-25"));
        dl.add(sdf.parse("2017-01-11"));
        dl.add(sdf.parse("2016-11-11"));
        dl.add(sdf.parse("2016-01-01"));
        dl.add(sdf.parse("2017-11-25"));
        dl.add(sdf.parse("2016-06-11"));
        Collections.sort(dl);
        
        for (Date date : dl) {
            System.out.println(sdf.format(date));
        }
    }
    @Test
    public void test6() throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d = sdf.parse("2016-10-25");
        Date d2 = new Date(d.getTime());
        
        System.out.println(sdf.format(d2));
    }
    
    @Test
    public void test7() throws ParseException{
        for (int i = 0; i < 50; i++) {

            long s = TimeUnit.HOURS.toMillis(15) + TimeUnit.MINUTES.toMillis((int) (Math.random() * 193 + 19));
            System.out.println(s / TimeUnit.HOURS.toMillis(1));
        }
    }
}
