package com.better517na.forstudy.advanced.reflect.on2016_2_4;

/**
 * @author tianzhong
 *
 */
public class Person implements Social {
    /**
     * 添加字段注释.
     */
    private String name;

    /**
     * 添加字段注释.
     */
    private int age;

    /**
     * TODO 添加方法注释.
     * 
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * TODO 添加方法注释.
     * 
     * @param name
     *            .
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * TODO 添加方法注释.
     * 
     * @return int
     */
    public int getAge() {
        return age;
    }

    /**
     * TODO 添加方法注释.
     * 
     * @param age
     *            .
     */
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "[" + this.name + ":  " + this.age + "]";
    }

    /**
     * 无参构造函数.
     */
    public Person() {
    }

    /**
     * @param name
     *            .
     * @param age
     *            .
     */
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * 构造函数.
     * 
     * @param name
     *            .
     */
    public Person(String name) {
        this.name = name;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void sayHello() {
        System.out.println("Hello, I'm " + this.name + " and I'm " + this.age + " years old.");
    }
}
