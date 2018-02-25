/*
 * 文件名：MapTest.java
 * 版权：Copyright 2007-2017 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： MapTest.java
 * 修改人：tianzhong
 * 修改时间：2017年10月10日
 * 修改内容：新增
 */
package com.better517na.forstudy.basic.collection;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;
import org.springframework.beans.BeanUtils;

/**
 * TODO 添加类的一句话简单描述.
 * <p>
 * TODO 详细描述
 * <p>画虎画皮难虎骨你就是一个二皮脸，哈哈哈哈
 * TODO 示例代码
 * 
 * <pre>
 * </pre>
 * 
 * @author tianzhong
 */
public class MapTest {

    @SuppressWarnings("unchecked")
    @Test
    public void test1() throws InstantiationException, IllegalAccessException {
        HashMap<String, String> map1 = new HashMap<>(); // .class.newInstance();
        map1.put("1", "123");
        map1.put("2", "321");
        map1.put("3", "112233");
        map1.values();
        new ArrayList<String>(map1.values());
        HashMap<String, String> map = new HashMap<>(10);
        map.put("", "");
        
        BeanUtils.copyProperties(null, null);
        
        ArrayList<String> list = new ArrayList<>();
        list.add("");
        System.out.println(map1);
        System.out.println(list);
    }
}
