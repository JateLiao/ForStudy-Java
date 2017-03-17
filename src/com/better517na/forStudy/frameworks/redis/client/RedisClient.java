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

    public static void main(String[] args) {

        JedisPool jedisPool = null;
        Jedis jedis = jedisPool.getResource();
        // jedis.
    }
}
