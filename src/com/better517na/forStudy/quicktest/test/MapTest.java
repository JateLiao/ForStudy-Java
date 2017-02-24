/*
 * 文件名：MapTest.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： MapTest.java
 * 修改人：tianzhong
 * 修改时间：2016年10月19日
 * 修改内容：新增
 */
package com.better517na.forStudy.quicktest.test;

import java.util.HashMap;
import java.util.Map;

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
public class MapTest {
    @Test
    public void mapTest1(){
        Map<String, String> map = new HashMap<>();
        map.put("nba", "USA");
        map.put("fifa", "UA");
        String s = map.get("fifa");
        System.out.println(s);
        for (int i = 0; i < 10; i++) {
            Object object = new Object();
            System.out.println("obj:" + object.hashCode());
            System.out.println("int:" + Integer.valueOf(i).hashCode());
        }
    }
}
