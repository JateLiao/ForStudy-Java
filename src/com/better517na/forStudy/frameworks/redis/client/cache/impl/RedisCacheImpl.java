/*
 * 文件名：RedisCacheImpl.java
 * 版权：Copyright 2007-2017 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： RedisCacheImpl.java
 * 修改人：tianzhong
 * 修改时间：2017年3月17日
 * 修改内容：新增
 */
package com.better517na.forStudy.frameworks.redis.client.cache.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.better517na.forStudy.frameworks.redis.client.RedisClient;
import com.better517na.forStudy.frameworks.redis.client.cache.RedisCache;

import redis.clients.jedis.Jedis;
import util.JsonUtils;

/**
 * TODO 添加类的一句话简单描述.
 * 
 * @author tianzhong
 */
@Component
public class RedisCacheImpl<V> implements RedisCache<String, V> {
    
    /**
     * 添加字段注释.
     */
    @Autowired
    private RedisClient client;
    
    /** 
     * 默认过时时间 
     */  
    private static final int EXPRIE_TIME =3600*24;   
    /** 
     * 在redis数据库中插入 key  和value 
     * @param key 
     * @param value 
     * @return 
     */  
    @Override  
    public boolean set(String key, V value) {  
        //设置默认过时时间  
        return set(key, value, EXPRIE_TIME);  
    }  
    /**
     * TODO 添加方法注释.
     * 
     * @param key
     * @param value
     * @param exprieTime
     * @return
     */ 
    @Override  
    public boolean set(String key, V value, int exprieTime) {
        try {
            Jedis jedis = client.getRedisSource();
            jedis.setnx(key, JsonUtils.toJson(value));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     * {@inheritDoc}.
     */
    @Override
    public V get(String key) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public boolean remove(String key) {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public boolean hset(String cacheKey, String key, V value) {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public V hget(String cacheKey, String key) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public Map<String, V> hget(String cacheKey) {
        // TODO Auto-generated method stub
        return null;
    }

}
