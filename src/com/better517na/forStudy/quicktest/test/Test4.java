/*
 * 文件名：Test4.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： Test4.java
 * 修改人：tianzhong
 * 修改时间：2016年12月29日
 * 修改内容：新增
 */
package com.better517na.forStudy.quicktest.test;

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
public class Test4 {

    @Test
    public void test1(){
        Integer i = 88;
        change1(i);
        System.out.println(i);
    }

    public static void change1(Integer i){
        i = null;
    }
}
