/*
 * 文件名：RedisCache.java
 * 版权：Copyright 2007-2017 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： RedisCache.java
 * 修改人：tianzhong
 * 修改时间：2017年3月17日
 * 修改内容：新增
 */
package com.better517na.forStudy.frameworks.redis.client.cache;

import java.util.Map;

/**
 * TODO 添加类的一句话简单描述.
 * 
 * @author     tianzhong
 */
public interface RedisCache<K, V> {
    /**
     * 根据key 去redis 中获取value
     * 
     * @param key
     * @return
     */
    V get(K key);

    /**
     * 删除redis库中的数据
     * 
     * @param key
     * @return
     */
    boolean remove(K key);

    /**
     * 设置哈希类型数据到redis 数据库
     * 
     * @param cacheKey
     *            可以看做一张表
     * @param key
     *            表字段
     * @param value
     * @return
     */
    boolean hset(String cacheKey, K key, V value);

    /**
     * 获取哈希表数据类型的值
     * 
     * @param cacheKey
     * @param key
     * @return
     */
    V hget(String cacheKey, K key);

    /**
     * 获取哈希类型的数据
     * 
     * @param cacheKey
     * @return
     */
    Map<K, V> hget(String cacheKey);
}
