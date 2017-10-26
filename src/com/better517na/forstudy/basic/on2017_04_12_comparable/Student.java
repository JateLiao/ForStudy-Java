/*
 * 文件名：Student.java
 * 版权：Copyright 2007-2017 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： Student.java
 * 修改人：tianzhong
 * 修改时间：2017年4月12日
 * 修改内容：新增
 */
package com.better517na.forstudy.basic.on2017_04_12_comparable;

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
public class Student implements Comparable<Student> {

    private int age;

    /**
     * 构造函数.
     * 
     */
    public Student() {
        // TODO Auto-generated constructor stub
    }

    /**
     * 构造函数.
     * 
     */
    public Student(int age) {
        this.age = age;
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

    /**
     * {@inheritDoc}.
     */
    @Override
    public int compareTo(Student o) {
        if (o == null) {
            return 1;
        }
        if (this.age > o.age) {
            return 1;
        }
        if (this.age == o.age) {
            return 0;
        }
        return -1;
    }

}
