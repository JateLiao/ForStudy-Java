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

        System.out.println(list.offerFirst("0")); // offerFirst：增加元素到链表头，并且返回true
        System.out.println(list.offerLast("7")); // offerLast：增加元素到链表尾，并且返回true
        System.out.println(list);
        
        System.out.println(list.peek()); // peek：返回第一个元素，为空则返回null
        System.out.println(list);
        
        System.out.println(list.offer("xxx")); // offer：增加元素到链表尾，并且返回true
        System.out.println(list);

        System.out.println(list.peekFirst()); // peekFirst：返回第一个元素，为空则返回null
        System.out.println(list.peekLast()); // peekLast：返回最后一个元素，为空则返回null
        System.out.println(list);
        
        System.out.println("-----------------------------------------------");
        System.out.println(list.poll()); // poll：返回第一个元素，并从链表删除第一个元素
        System.out.println(list);
        
        System.out.println("-----------------------------------------------");
        System.out.println(list.pollFirst()); // pollFirst：返回第一个元素，并从链表删除第一个元素
        System.out.println(list);
        
        System.out.println("-----------------------------------------------");
        System.out.println(list.pollLast()); // pollLast：返回最后一个元素，并从链表删除最后一个元素
        System.out.println(list);
        
        System.out.println("-----------------------------------------------");
        System.out.println(list.pop()); // pop：等同于removeFirst，移除并返回第一个元素
        System.out.println(list);
        
        System.out.println("-----------------------------------------------");
        list.push("ehco"); // push：等同于addFirst
        System.out.println(list);
    }

}
