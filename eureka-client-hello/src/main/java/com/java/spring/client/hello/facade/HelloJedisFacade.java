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
@RequestMapping(value = "/v1/jedis/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public interface HelloJedisFacade {
    @ApiOperation("get方法")
    @RequestMapping(value = "/get/{key}", method = RequestMethod.GET)
    @ResponseBody
    String jedisGet(@ApiParam(value = "key值") @PathVariable String key);

    @ApiOperation("set方法")
    @RequestMapping(value = "/set/{key}/{value}", method = RequestMethod.GET)
    @ResponseBody
    String jedisSet(@ApiParam(value = "key值") @PathVariable String key, @ApiParam(name = "value值") @PathVariable String value);
}