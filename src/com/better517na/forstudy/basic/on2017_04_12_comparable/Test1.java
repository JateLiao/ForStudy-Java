/*
 * 文件名：Test1.java
 * 版权：Copyright 2007-2017 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： Test1.java
 * 修改人：tianzhong
 * 修改时间：2017年4月12日
 * 修改内容：新增
 */
package com.better517na.forstudy.basic.on2017_04_12_comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.junit.Test;

/**
 * @author tianzhong
 */
public class Test1 {
    
    @Test
    public void test1(){
        Random random = new Random();
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Student(random.nextInt(20) + 1));
        }
        
        Collections.sort(list);
        
        for (Student student : list) {
            System.out.println(student.getAge());
        }
    }
    
    @Test
    public void test2(){
        String sss = "1234";
        System.out.println(sss.substring(3, 4));
    }
}
