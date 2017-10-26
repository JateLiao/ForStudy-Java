package com.better517na.forstudy.advanced.reflect.on2015_12_22;

/**
 * @author tianzhong
 *
 */

public class Test1_利用反射实例化一个对象 {
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

        Person per = null;
        try {
            per = (Person) demo.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        per.setName("Kobe");
        per.setAge(38);
        System.out.println(per);
    }
}
