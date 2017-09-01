/*
 * 文件名：StringTest3.java
 * 版权：Copyright 2007-2017 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： StringTest3.java
 * 修改人：tianzhong
 * 修改时间：2017年8月30日
 * 修改内容：新增
 */
package com.better517na.forStudy.basic.string;

import java.text.MessageFormat;

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
public class StringTest3 {
    
    @Test
    public void test1(){
        Double d = 35.55;
        System.out.println(String.format("%.1f", d));
    }
    
    @Test
    public void test2(){
        String s = "http://app.super8.com.cn/Hotel/Images{0}hotelID=?";
        System.out.println(MessageFormat.format(s, "517"));
    }
    
    @Test
    public void test3(){
        // 2.0*4.5
        String s = "20/40";
        // System.out.println(s.matches("[0-9](\\.[0-9]{1,2})?\\*[0-9](\\.[0-9]{1,2})?"));
        System.out.println(s.matches("[0-9](\\.?[0-9]{1,2})?(\\*|x|X|\\+|/)[0-9](\\.?[0-9]{1,2})?"));

        s = "1.2*2.2或者1.8*2";
        System.out.println(s.split("或"));
        System.out.println(s.split("或|或者"));
        System.out.println(s.split("或者|或"));
    }
    
}
