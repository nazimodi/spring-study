package com.java.spring.client.hello.facade.impl;

import com.java.spring.client.hello.common.jedis.RedisClient;
import com.java.spring.client.hello.facade.HelloJedisFacade;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author renqingwang on 2017/8/31.
 * @version 1.0
 */
@RestController
public class HelloJedisFacadeImpl implements HelloJedisFacade {
    @Autowired
    private RedisClient redisClient;
    @Override
    public String jedisGet(@ApiParam(value = "key值") @PathVariable String key) {
        return redisClient.get(key);
    }

    @Override
    public String jedisSet(@ApiParam(value = "key值") @PathVariable String key, @ApiParam(value = "value值") @PathVariable String value) {
        return redisClient.set(key, value);
    }
}
