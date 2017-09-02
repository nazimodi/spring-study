package com.java.spring.client.hello.facade;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author renqingwang on 2017/9/2.
 * @version 1.0
 */
@Api(description = "check spring")
@RequestMapping(value = "/v1/hello", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public interface HelloMyTest {
    @ApiOperation("check @Conditional")
    @RequestMapping(value = "/conditional", method = RequestMethod.GET)
    String checkConditional();
}
