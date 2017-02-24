/*
 * 文件名：Test5.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： Test5.java
 * 修改人：tianzhong
 * 修改时间：2016年12月14日
 * 修改内容：新增
 */
package com.better517na.forStudy.basic.on2016_12_12_valuepass_preferencepass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
public class Test5 {
    class AAA{
        Integer aaa;
    }

    @Test
    public void test1(){
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(6);
        l.add(5);
        l.add(3);
        l.add(2);
        l.add(5);
        l.add(3);

        System.out.println(Collections.max(l));
        System.out.println(Collections.min(l));
    }
    
    @Test
    public void test2(){
        AAA name = new AAA();
        System.out.println(3 == name.aaa);
    }
}
