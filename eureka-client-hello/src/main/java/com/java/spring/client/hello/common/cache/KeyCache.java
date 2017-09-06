package com.java.spring.client.hello.common.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.lang.reflect.Method;

/**
 * @author renqingwang on 2017/9/7.
 * @version 1.0
 */
@Configuration
@EnableCaching
public class KeyCache extends CachingConfigurerSupport {
    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        JedisConnectionFactory redisConnectionFactory = new JedisConnectionFactory();

        // Defaults
        /*redisConnectionFactory.setHostName("127.0.0.1");
        redisConnectionFactory.setPort(6379);*/
        redisConnectionFactory.afterPropertiesSet();
        return redisConnectionFactory;
    }
    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(factory);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }
    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate) {
        return new RedisCacheManager(redisTemplate);
    }

    @Bean
    public KeyGenerator customKeyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object o, Method method, Object... objects) {
                StringBuilder sb = new StringBuilder();
                sb.append(o.getClass().getName());
                sb.append(method.getName());
                for (Object obj : objects) {
                    sb.append(obj.toString());
                }
                return sb.toString();
            }
        };
    }
}
