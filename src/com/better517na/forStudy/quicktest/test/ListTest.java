/*
 * 文件名：ListTest.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： ListTest.java
 * 修改人：tianzhong
 * 修改时间：2016年7月4日
 * 修改内容：新增
 */
package com.better517na.forStudy.quicktest.test;

import java.util.LinkedList;
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
public class ListTest {
    public static void main(String[] args) {
        // List<Integer> list = new ArrayList<>();
        // for (int i = 1; i <= 10; i++) {
        // list.add(i);
        // }
        //
        // list.remove(4);
        // list.add(5);

        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }

        list.remove(4);
        list.add(5);
    }
}
