/*
 * 文件名：RedisClient.java
 * 版权：Copyright 2007-2017 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： RedisClient.java
 * 修改人：tianzhong
 * 修改时间：2017年3月16日
 * 修改内容：新增
 */
package com.better517na.forStudy.frameworks.redis.client;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

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
public class RedisClient {
    
    private JedisPool pool;

    /**
     * 
     * TODO 获取连接.
     */
    public Jedis getRedisSource() {
        return pool.getResource();
    }
    
    /**
     * TODO 关闭连接.
     */
    public void disconnect(Jedis jedis) {
        jedis.disconnect();
    }
    
    /**
     * TODO 添加方法注释.
     */
    public void returnResource(Jedis jedis) {
        pool.returnBrokenResource(jedis);
    }
    
    /**
     * 设置pool.
     * 
     * @return 返回pool
     */
    public JedisPool getPool() {
        return pool;
    }

    /**
     * 获取pool.
     * 
     * @param pool 要设置的pool
     */
    public void setPool(JedisPool pool) {
        this.pool = pool;
    }

}
