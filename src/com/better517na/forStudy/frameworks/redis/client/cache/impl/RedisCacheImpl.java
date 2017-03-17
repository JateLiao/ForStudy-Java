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

import com.better517na.forStudy.frameworks.redis.client.cache.RedisCache;

/**
 * TODO 添加类的一句话简单描述.
 * 
 * @author     tianzhong
 */
public class RedisCacheImpl<V> implements RedisCache<String, V> {

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
