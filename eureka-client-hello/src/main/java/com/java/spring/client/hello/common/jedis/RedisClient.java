package com.java.spring.client.hello.common.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author renqingwang on 2017/8/31.
 * @version 1.0
 */
public class RedisClient {
    private JedisPool jedisPool;

    public JedisPool getJedisPool() {
        return jedisPool;
    }

    public void setJedisPool(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    public String set(String key, String value) {
        Jedis jedis = null;
        jedis = jedisPool.getResource();
        String result = jedis.set(key, value);
        jedis.close();
        return result;
    }

    public String get(String key) {
        Jedis jedis = null;
        jedis = jedisPool.getResource();
        return jedis.get(key);
    }
}
