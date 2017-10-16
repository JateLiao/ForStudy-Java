/*
 * 文件名：MapTest.java
 * 版权：Copyright 2007-2017 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： MapTest.java
 * 修改人：tianzhong
 * 修改时间：2017年10月10日
 * 修改内容：新增
 */
package com.better517na.forStudy.basic.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
public class MapTest {

    @SuppressWarnings("unchecked")
    @Test
    public void test1() throws InstantiationException, IllegalAccessException {
        Map<String, String> map1 = HashMap.class.newInstance();
        map1.put("", "");
        
        HashMap<String, String> map = new HashMap<>(10);
        map.put("", "");
        
        ArrayList<String> list = new ArrayList<>();
        list.add("");
    }
}
