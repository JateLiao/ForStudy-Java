/*
 * 文件名：Test3.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： Test3.java
 * 修改人：tianzhong
 * 修改时间：2016年12月23日
 * 修改内容：新增
 */
package com.better517na.forstudy.quicktest;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import util.JsonUtils;

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
public class Test3 {
    @Test
    public void test1() throws Exception {
        // Reader
        InputStream in = new BufferedInputStream(new FileInputStream(new File("D:\\Test\\sql.txt")));
//        int s = 0;
//        while (-1 != (s = in.read())) {
//            System.out.println(s);
//        }
        

        byte[] bytes = new byte[100];
        in.read(bytes);
        while (bytes.length > 0) {
            System.out.println(new String(bytes, "UTF-8"));
            in.read(bytes);
        }
        
        in.close();
    } 
    
    @Test
    public void test2() throws Exception {
        //Reader reader = new BufferedReader(new BufferedInputStream(new FileInputStream(new File("D:\\Test\\sql.txt"))));
        OutputStream out = new BufferedOutputStream(new FileOutputStream(new File("D:\\Test\\out.txt"), true));
        String str = "我说了你还不信\r\n";
        out.write(str.getBytes("UTF-8"));
        out.close();
    } 
    
    @Test
    public void test3() throws Exception {
        //Reader reader = new BufferedReader(new BufferedInputStream(new FileInputStream(new File("D:\\Test\\sql.txt"))));
        Reader reader = new BufferedReader(new FileReader(new File("D:\\Test\\out.txt")));
        char[] cs = new char[1024];
        while (-1 != reader.read(cs)) {
            System.out.println(new String(cs, 0, 100));
        }
        
        reader.close();
    } 
    
    @Test
    public void test4() throws Exception {
        String ss = "sasac$$grttr";
        System.out.println(ss.contains("$$"));
        String[] arr = ss.split("\\$\\$");
        for (String string : arr) {
            System.out.println(string);
        }
    } 
    
    @Test
    public void test5() throws Exception {
        String ss = "sasac/grttr";
        System.out.println(ss.contains("/"));
        String[] arr = ss.split("/");
        for (String string : arr) {
            System.out.println(string);
        }

        Map<String, Object> param = new HashMap<>();
        Map<String, Object> p = new HashMap<>();
        p.put("vendorHotelInfo", "QIANTAO/H137888");
        p.put("vendorCityInfo", "ELONG/0101");
        param.put("data", JsonUtils.toJson(p));
        param.put("method", "hotel.queryHotelDetail");
        
        System.out.println(JsonUtils.toJson(param));
    } 
    
    @Test
    public void test6() throws Exception { 

        Map<String, Object> param = new HashMap<>();
        Map<String, Object> p = new HashMap<>();
        p.put("vendorHotelInfo", "QIANTAO/H137888");
        p.put("vendorCityInfo", "ELONG/0101");
        param.put("data", JsonUtils.toJson(p));
        param.put("method", "hotel.queryHotelDetail");
        
        System.out.println(JsonUtils.toJson(param));
    } 
}
