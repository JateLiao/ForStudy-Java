/*
 * 文件名：BigDecimalTest.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： BigDecimalTest.java
 * 修改人：tianzhong
 * 修改时间：2016年5月16日
 * 修改内容：新增
 */
package com.better517na.forstudy.basic.bigdecimal;

import java.math.BigDecimal;

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
public class BigDecimalTest {
    public static void main(String[] args) {
        BigDecimal b1 = new BigDecimal("0.00154879523");
        BigDecimal b2 = new BigDecimal("0.21548965233");

        BigDecimal result = b1.multiply(b2);

        System.out.println(result.toString());

    }
}
