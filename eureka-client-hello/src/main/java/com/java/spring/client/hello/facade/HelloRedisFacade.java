package com.java.spring.client.hello.facade;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author renqingwang on 2017/8/31.
 * @version 1.0
 */
@Api(description = "操作jedis")
@RequestMapping(value = "/v1/redis/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public interface HelloRedisFacade {
    @ApiOperation("jedis-get方法")
    @RequestMapping(value = "/jedis/get/{key}", method = RequestMethod.GET)
    @ResponseBody
    String jedisGet(@ApiParam(value = "key值") @PathVariable String key);

    @ApiOperation("jedis-set方法")
    @RequestMapping(value = "/jedis/set/{key}/{value}", method = RequestMethod.GET)
    @ResponseBody
    String jedisSet(@ApiParam(value = "key值") @PathVariable String key,
                    @ApiParam(value = "value值") @PathVariable String value);

    @ApiOperation("redistemplate-get方法")
    @RequestMapping(value = "/redistemplate/get/{key}", method = RequestMethod.GET)
    @ResponseBody
    String redisTemplateGet(@ApiParam(value = "key值") @PathVariable String key);

    @ApiOperation("redistemplate-set方法")
    @RequestMapping(value = "/redistemplate/set/{key}/{value}", method = RequestMethod.GET)
    @ResponseBody
    String redisTemplateSet(@ApiParam(value = "key值") @PathVariable String key,
                            @ApiParam(value = "value值") @PathVariable String value);

    @ApiOperation("redistemplate-hget方法")
    @RequestMapping(value = "/redistemplate/hget/{key}/{field}", method = RequestMethod.GET)
    @ResponseBody
    String redisTemplateHGet(@ApiParam(value = "key值") @PathVariable String key,
                             @ApiParam(value = "field值") @PathVariable String field);

    @ApiOperation("redistemplate-hset方法")
    @RequestMapping(value = "/redistemplate/hset/{key}/{field}/{value}", method = RequestMethod.GET)
    @ResponseBody
    String redisTemplateHSet(@ApiParam(value = "key值") @PathVariable String key,
                             @ApiParam(value = "field值") @PathVariable String field,
                             @ApiParam(value = "value值") @PathVariable String value);

}