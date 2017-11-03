/*
 * 文件名：LinkedListTest.java
 * 版权：Copyright 2007-2017 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： LinkedListTest.java
 * 修改人：tianzhong
 * 修改时间：2017年11月2日
 * 修改内容：新增
 */
package com.better517na.forstudy.basic.collection;

import java.util.LinkedList;

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
public class LinkedListTest {

    @Test
    public void test1() {
        LinkedList<String> list = new LinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        System.out.println(list);
        
        list.addFirst("0");
        System.out.println(list);
        
        list.removeFirst();
        System.out.println(list);
        
        list.addLast("6");
        System.out.println(list);

        System.out.println(list.offerFirst("0"));
        System.out.println(list.offerFirst("1"));
        System.out.println(list.offerFirst("1000"));
        System.out.println(list);
        
        System.out.println(list.peek());
        System.out.println(list);
    }

}
