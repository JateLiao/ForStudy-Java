/*
 * 文件名：EqualsTest.java
 * 版权：Copyright 2007-2017 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： EqualsTest.java
 * 修改人：tianzhong
 * 修改时间：2017年9月5日
 * 修改内容：新增
 */
package com.better517na.forStudy.basic.string;

import java.util.Objects;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

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
public class EqualsTest {
    public static void main(String[] args) {
        double deductFeesBefore = 0.0;
        System.out.println(Objects.equals(0.0, deductFeesBefore));
    }
    
    /**
     * TODO 添加方法注释.
     * 
     */
    @Test
    public void test1() {
        String s = "|fff|||4444||";
        s = "dads";
        String[] aa = s.split("\\|");
        System.out.println(aa.length);
        for (String string : aa) {
            System.out.print(string);
        }
    }
    
    /**
     * TODO 添加方法注释.
     * 
     */
    @Test
    public void test2() {
        StringBuffer names = new StringBuffer(""); // 名称
        System.out.println(names.toString());
        System.out.println(StringUtils.isNotBlank(names.toString()));
    }
}
