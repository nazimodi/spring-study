package com.java.spring.client.hello.common.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * @author renqingwang on 2017/8/30.
 * @version 1.0
 */
/*@Configuration*/
@EnableConfigurationProperties(RedisProperties.class)
public class JedisClusterConfig {
    @Autowired
    private RedisProperties redisProperties;

    @Bean
    public JedisCluster getJedisCluster() {
        String[] serverArray = redisProperties.getClousterNodes().split(",");
        Set<HostAndPort> hostAndPorts = new HashSet<>();

        for (String server : serverArray) {
            String[] ipPortPair = server.split(":");
            hostAndPorts.add(new HostAndPort(ipPortPair[0].trim(), Integer.valueOf(ipPortPair[1])));
        }

        return new JedisCluster(hostAndPorts, redisProperties.getCommandTimeout());
    }
}
