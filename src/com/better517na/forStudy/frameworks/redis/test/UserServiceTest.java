/*
 * 文件名：Test.java
 * 版权：Copyright 2007-2017 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： Test.java
 * 修改人：tianzhong
 * 修改时间：2017年8月15日
 * 修改内容：新增
 */
package com.better517na.forStudy.frameworks.redis.test;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import com.better517na.forStudy.advanced.reflect.jsonutil.JsonUtilsNew3;
import com.better517na.forStudy.frameworks.redis.client.cache.RedisCache;
import com.better517na.forStudy.frameworks.redis.entity.UserEntity;

import redis.clients.jedis.Jedis;

/**
 * TODO 添加类的一句话简单描述.
 * @author     tianzhong
 */
@ContextConfiguration("classpath:/com/better517na/forStudy/frameworks/redis/config/spring/app-context.xml")
public class UserServiceTest {
    
    /**
     * 添加字段注释.
     */
    private static final String REDIS_KEY = "UserServiceKey";
    
    /**
     * 添加字段注释.
     */
    private static ApplicationContext context = null;
    
    /**
     * 添加字段注释.
     */
    @Resource
    private RedisCache<String, String> caches;
    
    @SuppressWarnings("unchecked")
    @Before
    public void before(){
        System.out.println("before.........");
        
        context = new ClassPathXmlApplicationContext("classpath:/com/better517na/forStudy/frameworks/redis/config/spring/app-context.xml");
        caches = context.getBean(RedisCache.class);
    }

    @Test
    public void userServiceTest() {
        System.out.println("contetxt: " + context.getDisplayName());
        
        // Jedis jds = new Jedis("192.168.1.113", 6379);
        // jds.connect();
        
        UserEntity user = new UserEntity();
        user.setUaserName("kobe bryant");
        user.setUserNo("24");
        String key = REDIS_KEY + user.getUserNo();
        caches.set(key, JsonUtilsNew3.toJson(user));
        
        String redisValue = caches.get(key);
        System.out.println(redisValue);
    }

}
