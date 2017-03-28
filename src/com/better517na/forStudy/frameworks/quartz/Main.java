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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * TODO quartz测试.
 * 
 * @author     tianzhong
 */
//@ContextConfiguration("classpath:/com/better517na/forStudy/frameworks/quartz/config/spring/app-context.xml")
@Component
public class Main {
    
    
    /**
     * 添加字段注释.
     */
    @Resource(name="propertyConfigurer")
    private PropertyPlaceholderConfigurer configurer;
    
    /**
     * 添加字段注释.
     */
    private static String tmpVal;

    @Value("${quartz.jobStore.class}")
    public void setTmpVal(String tmpVal) {
        Main.tmpVal = tmpVal;
    }

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/com/better517na/forStudy/frameworks/quartz/config/spring/app-context.xml");
        System.err.println("Work Begin!!!");
        PropertyPlaceholderConfigurer configurers =  (PropertyPlaceholderConfigurer) context.getBean("propertyConfigurer");
        System.out.println(configurers);
        System.out.println("撒旦：" + tmpVal);
        System.err.println("Work Complete!!!");
    }
    
    @Test
    public void main() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/com/better517na/forStudy/frameworks/quartz/config/spring/app-context.xml");
        PropertyPlaceholderConfigurer configurers =  (PropertyPlaceholderConfigurer) context.getBean("propertyConfigurer");
        System.out.println(configurers);
        
        System.out.println("轱辘：" + tmpVal);
    }
}
