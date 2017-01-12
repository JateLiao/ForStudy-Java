/*
 * 文件名：Test3.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： Test3.java
 * 修改人：tianzhong
 * 修改时间：2016年12月12日
 * 修改内容：新增
 */
package com.better517na.forStudy.basic.on2016_12_12_valuepass_preferencepass;

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
public class Test3 {
    @Test
    public void test1(){
        int[] a = {1, 2};
        int[] b = a;
        // b[0] = 3;
        b[1] = 4;
        // System.out.println(a[0]);
        System.out.println(a[1]);
    }
    
    @Test
    public void test2(){
        int [] a={1,2};
        int b=3;
        a[0]=b;
        b=5;
        System.out.println(a[0]);
    }
}
