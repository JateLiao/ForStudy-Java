/*
 * 文件名：Main.java
 * 版权：Copyright 2007-2017 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： Main.java
 * 修改人：tianzhong
 * 修改时间：2017年3月16日
 * 修改内容：新增
 */
package com.better517na.forStudy.frameworks.quartz;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

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
@ContextConfiguration("classpath:/com/better517na/forStudy/frameworks/quartz/config/spring/app-context.xml")
public class Main {
    
    
    /**
     * 添加字段注释.
     */
    @Resource(name="propertyConfigurer")
    private PropertyPlaceholderConfigurer configurer;
    
    /**
     * 添加字段注释.
     */
    @Autowired
    private SimpleTriggerExample xxx;

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/com/better517na/forStudy/frameworks/quartz/config/spring/app-context.xml");
    
        PropertyPlaceholderConfigurer configurers =  (PropertyPlaceholderConfigurer) context.getBean("propertyConfigurer");
        
        System.out.println(configurers);
    }
    
    @Test
    public void main() {
        System.out.println(configurer);
        System.out.println(xxx);
    }
}