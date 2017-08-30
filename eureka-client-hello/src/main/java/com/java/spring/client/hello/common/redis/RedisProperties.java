package com.java.spring.client.hello.common.redis;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author renqingwang on 2017/8/30.
 * @version 1.0
 */
@Component
@ConfigurationProperties(prefix = "redis.cache")
public class RedisProperties {
    private int expireSeconds;

    private String clousterNodes;

    private int commandTimeout;

    public int getExpireSeconds() {
        return expireSeconds;
    }

    public void setExpireSeconds(int expireSeconds) {
        this.expireSeconds = expireSeconds;
    }

    public String getClousterNodes() {
        return clousterNodes;
    }

    public void setClousterNodes(String clousterNodes) {
        this.clousterNodes = clousterNodes;
    }

    public int getCommandTimeout() {
        return commandTimeout;
    }

    public void setCommandTimeout(int commandTimeout) {
        this.commandTimeout = commandTimeout;
    }
}
