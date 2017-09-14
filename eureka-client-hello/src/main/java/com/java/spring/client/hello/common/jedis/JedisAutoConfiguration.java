package com.java.spring.client.hello.common.jedis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author renqingwang on 2017/8/31.
 * @version 1.0
 */
@Configuration
@EnableConfigurationProperties(JedisProperties.class)//开启属性注入,通过@autowired注入
@ConditionalOnClass(JedisProperties.class)//判断这个类是否在classpath中存在
public class JedisAutoConfiguration {
    @Autowired
    private JedisProperties jedisProperties;

    @Bean(name = "jedisPool")
    public JedisPool jedisPool() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(jedisProperties.getMaxIdle());
        jedisPoolConfig.setMaxTotal(jedisProperties.getMaxTotal());
        jedisPoolConfig.setMaxWaitMillis(jedisProperties.getMaxWaitMillis());
        return new JedisPool(jedisPoolConfig, jedisProperties.getHost(), jedisProperties.getPort());
    }

    @Bean
    @ConditionalOnMissingBean(RedisClient.class)//容器中如果没有RedisClient这个类,那么自动配置这个RedisClient
    public RedisClient redisClient(@Qualifier("jedisPool") JedisPool jedisPool) {
        RedisClient redisClient = new RedisClient();
        redisClient.setJedisPool(jedisPool);
        return redisClient;
    }
}
