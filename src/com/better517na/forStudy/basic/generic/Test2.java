/*
 * 文件名：Test2.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： Test2.java
 * 修改人：tianzhong
 * 修改时间：2016年5月20日
 * 修改内容：新增
 */
package com.better517na.forStudy.basic.generic;

import java.util.ArrayList;
import java.util.Date;
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
public class Test2 {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> arrayList3 = new ArrayList<Integer>();
        arrayList3.add(1);// 这样调用add方法只能存储整形，因为泛型类型的实例为Integer

        arrayList3.getClass().getMethod("add", Object.class).invoke(arrayList3, "asd");
        arrayList3.getClass().getMethod("add", Object.class).invoke(arrayList3, new Date());

        for (int i = 0; i < arrayList3.size(); i++) {
            System.out.println(arrayList3.get(i));
        }

        System.err.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");

        List<String> list2 = new ArrayList<String>();
        list2.add("ABC");
        list2.getClass().getMethod("add", Object.class).invoke(list2, 123);
        for (int i = 0; i < list2.size(); i++) {
            System.out.println(list2.get(i));
        }

        // String
    }
}