/*
 * 文件名：Person.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： Person.java
 * 修改人：tianzhong
 * 修改时间：2016年2月1日
 * 修改内容：新增
 */
package com.better517na.forstudy.advanced.reflect.on2016_2_1;

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
public class Person extends Animal implements China, Growable {
    private String name;

    private String sex;

    private int age;

    /**
     * 设置name.
     * 
     * @return 返回name
     */
    public String getName() {
        return name;
    }

    /**
     * 获取name.
     * 
     * @param name
     *            要设置的name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 设置age.
     * 
     * @return 返回age
     */
    public int getAge() {
        return age;
    }

    /**
     * 获取age.
     * 
     * @param age
     *            要设置的age
     */
    public void setAge(int age) {
        this.age = age;
    }

    public Person() {

    }

    public Person(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void sayChina() throws Exception {
        System.out.println("Hello China");
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void sayHello() throws Exception {
        System.out.println("hello, I'm " + this.name + " , I'm " + this.age + " years old and I'm " + this.sex + ".");
        testMethod();
    }

    /**
     * testMethod.
     */
    private void testMethod() {
        System.out.println("This is a test method.");
    }

    public void setInfo(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
}
