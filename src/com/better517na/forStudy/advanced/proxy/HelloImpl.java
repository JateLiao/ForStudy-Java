package com.better517na.forStudy.advanced.proxy;

/**
 * @author tianzhong
 *
 */
public class HelloImpl implements IHello {

    @Override
    public void say(String name) {
        System.out.println("Hello, my name is " + name + ".");
    }

    /**
     * TODO 添加方法注释.
     * 
     * @param name
     *            .
     */
    public void shut(String name) {
        System.out.println(name + " shut up!");
    }
}
