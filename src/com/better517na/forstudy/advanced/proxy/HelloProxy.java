package com.better517na.forstudy.advanced.proxy;

/**
 * 静态代理.
 * 
 * @author tianzhong
 *
 */
public class HelloProxy implements IHello {

    /**
     * 添加字段注释.
     */
    private HelloImpl hello = new HelloImpl();

    /**
     * TODO 添加方法注释.
     * 
     */
    private void before() {
        System.out.println("Before");
    }

    /**
     * TODO 添加方法注释.
     * 
     */
    private void after() {
        System.out.println("After");
    }

    @Override
    public void say(String name) {
        before();
        hello.say(name);
        after();
    }

    /**
     * TODO 添加方法注释.
     * 
     * @param args
     *            .
     */
    public static void main(String[] args) {
        HelloProxy helloProxy = new HelloProxy();
        helloProxy.say("Kobe");
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void shut(String name) {
        // TODO Auto-generated method stub

    }
}
