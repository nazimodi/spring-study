package com.java.spring.client.hello.facade.impl;

import com.java.spring.client.hello.base.BaseFacade;
import com.java.spring.client.hello.common.jedis.RedisClient;
import com.java.spring.client.hello.facade.HelloRedisFacade;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author renqingwang on 2017/8/31.
 * @version 1.0
 */
@RestController
public class HelloRedisFacadeImpl extends BaseFacade implements HelloRedisFacade {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
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

    @Override
    public String redisTemplateGet(@ApiParam(value = "key值") @PathVariable String key) {
        String string = stringRedisTemplate.opsForValue().get(key);
        return string;
    }

    @Override
    public String redisTemplateSet(@ApiParam(value = "key值") @PathVariable String key, @ApiParam(name = "value值") @PathVariable String value) {
        stringRedisTemplate.opsForValue().set(key, value);
        return "success";
    }

    @Override
    public String redisTemplateHGet(@ApiParam(value = "key值") @PathVariable String key, @ApiParam(value = "field值") @PathVariable String field) {
        return (String)stringRedisTemplate.opsForHash().get(key, field);
    }

    @Override
    public String redisTemplateHSet(@ApiParam(value = "key值") @PathVariable String key, @ApiParam(value = "field值") @PathVariable String field, @ApiParam(value = "value值") @PathVariable String value) {
        stringRedisTemplate.opsForHash().put(key, field, value);
        return "success";
    }
}
