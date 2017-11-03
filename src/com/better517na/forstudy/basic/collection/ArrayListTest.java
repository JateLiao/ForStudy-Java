/*
 * 文件名：ArrayListTest.java
 * 版权：Copyright 2007-2017 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： ArrayListTest.java
 * 修改人：tianzhong
 * 修改时间：2017年11月3日
 * 修改内容：新增
 */
package com.better517na.forstudy.basic.collection;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * TODO 添加类的一句话简单描述.
 * 
 * @author tianzhong
 */
public class ArrayListTest {

    @Test
    public void addAddAllTest(){
        List<Tmp> list1= new ArrayList<>();
        list1.add(new Tmp(1, "no1"));
        list1.add(new Tmp(2, "no2"));
        List<Tmp> list2 = new ArrayList<>();
        list2.addAll(list1);
        System.out.println(list2);

        list1.get(0).i = 11;
        list1.get(0).name = "new no1";
        System.out.println(list2);
    }

    class Tmp {
        public int i = 0;
        public String name = "";

        /** * 构造函数. */
        public Tmp() { }

        /** * 构造函数. */
        public Tmp(int i, String name) {
            this.i = i;
            this.name = name;
        }

        @Override
        public String toString() {
            return "i = " + this.i + ", name = " + name;
        }
    }
}
