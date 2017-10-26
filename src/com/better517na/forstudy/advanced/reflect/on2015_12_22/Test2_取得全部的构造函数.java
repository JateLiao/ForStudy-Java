package com.better517na.forstudy.advanced.reflect.on2015_12_22;

import java.lang.reflect.Constructor;

/**
 * @author tianzhong
 *
 */
public class Test2_取得全部的构造函数 {
    /**
     * TODO 添加方法注释.
     * 
     * @param args
     *            .
     */
    public static void main(String[] args) {
        Class<?> demo = null;
        try {
            demo = Class.forName("com.better517na.forStudy.advanced.reflect.Person");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Person per1 = null;
        Person per2 = null;
        Person per3 = null;
        Person per4 = null;
        Person per5 = null;
        // 取得全部的构造函数
        Constructor<?>[] cons = demo.getConstructors();
        try {
            per1 = (Person) cons[0].newInstance();
            per5 = (Person) cons[3].newInstance("Kobe");
            per2 = (Person) cons[1].newInstance("Wade", 33);
            per3 = (Person) cons[2].newInstance(38);
            // per5 = (Person) cons[2].newInstance(38);
            per4 = (Person) cons[3].newInstance("Kobe");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(per1);
        System.out.println(per2);
        System.out.println(per3);
        System.out.println(per4);
        System.out.println(per5);
    }

}
