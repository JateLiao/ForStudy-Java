/*
 * 文件名：Test1.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： Test1.java
 * 修改人：tianzhong
 * 修改时间：2016年5月16日
 * 修改内容：新增
 */
package com.better517na.forstudy.basic.bigdecimal;

import java.math.BigDecimal;

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
public class Test1 {
    public static void main(String[] args) {
        System.out.println(0.06 + 0.01);
        System.out.println(1.0 - 0.42);
        System.out.println(4.015 * 1000);
        System.out.println(3.301 / 1000);
    }
    
    @Test
    public void test1(){
        System.out.println(new BigDecimal("17").divide(new BigDecimal("3"), 2, BigDecimal.ROUND_HALF_UP));
    }
}
