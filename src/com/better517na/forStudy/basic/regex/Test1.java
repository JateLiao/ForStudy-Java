/*
 * 文件名：Test1.java
 * 版权：Copyright 2007-2017 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： Test1.java
 * 修改人：tianzhong
 * 修改时间：2017年4月24日
 * 修改内容：新增
 */
package com.better517na.forStudy.basic.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

/**
 * @author     tianzhong
 */
public class Test1 {

    @Test
    public void test1(){
        String str = "    @hah";
        Pattern p = Pattern.compile("\\s+\\@");
        Matcher m = p.matcher(str);
        if (m.find()) {
            System.out.println(str);
        }
    }
    
    @Test
    public void test2(){
        String str = "    public ssss";
        if (str.startsWith("\\s*public")) {
            System.out.println(str);
        }
        
//        Pattern p = Pattern.compile("\\s*public");
//        Matcher m = p.matcher(str);
//        if (m.find()) {
//            System.out.println(str);
//        }
    }
    
}