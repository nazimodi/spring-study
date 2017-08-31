package com.java.spring.client.hello.facade;

import com.java.spring.client.hello.domain.MsgBlackBatch;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author renqingwang on 2017/8/26.
 * @version 1.0
 */
@RequestMapping(value = "/v1/hello", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public interface HelloMybatisFacade {
    @ApiOperation("获取列表")
    @RequestMapping(value = "/mybatis", method = RequestMethod.GET)
    @ResponseBody
    List<MsgBlackBatch> list();
}
