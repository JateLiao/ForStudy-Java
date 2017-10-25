/*
 * 文件名：HelloProxy.java
 * 版权：Copyright 2007-2017 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： HelloProxy.java
 * 修改人：tianzhong
 * 修改时间：2017年10月25日
 * 修改内容：新增
 */
package com.better517na.forStudy.advanced.proxy.on2017_10_25;

/**
 * TODO 添加类的一句话简单描述.
 * <p>
 * TODO 详细描述
 * <p>
 * TODO 示例代码
 * <pre>
 * </pre>
 * 
 * @author     tianzhong
 */
public class HelloProxy_Static implements IHello {
    /**
     * 代理的实现类(静态代理).
     */
    private IHello target;
    
    public HelloProxy_Static(IHello obj) {
        this.target = obj;
    }
    
    public static void main(String[] args) {
        HelloImpl hello = new HelloImpl();
        HelloProxy_Static helloProxy = new HelloProxy_Static(hello);
        helloProxy.sayHello("你瞅啥？？");
    }

    /** 
     * {@inheritDoc}.
     */
    @Override
    public void sayHello(String conent) {
        target.sayHello(conent);
    }

}
