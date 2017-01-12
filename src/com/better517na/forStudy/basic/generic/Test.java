/*
 * 文件名：Tews.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： Tews.java
 * 修改人：tianzhong
 * 修改时间：2016年2月17日
 * 修改内容：新增
 */
package com.better517na.forStudy.basic.generic;

import java.util.ArrayList;
import java.util.List;

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
public class Test {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<String>();
        list1.add("ABC");
        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(1);

        System.out.println(list1.getClass());
        System.out.println(list2.getClass());
        System.out.println(list1.getClass() == list2.getClass());

        // Object o1 = new Object();
        // String o2 = new String();
        //
        // Integer i = (Integer) o1;
        // Integer i2 = (Integer) o2;
    }
}
