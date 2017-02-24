/*
 * 文件名：Test1_获得类加载器.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： Test1_获得类加载器.java
 * 修改人：tianzhong
 * 修改时间：2016年2月4日
 * 修改内容：新增
 */
package com.better517na.forStudy.advanced.reflect.on2016_2_4;

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
public class Test1_获得类加载器 {

    public static void main(String[] args) {
        Person person = new Person();
        System.out.println("类加载器：" + person.getClass().getClassLoader().getClass().getSimpleName());
    }
}
