package com.java.spring.client.hello.facade;

import com.java.spring.client.hello.facade.vo.HelloHiveVO;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author renqingwang on 2017/8/14.
 * @version 1.0
 */
@RequestMapping(value = "/v1/hello", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public interface HelloWorldFacade {
    @RequestMapping(value = "/hive", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    String hiveQuery(@Validated @RequestBody HelloHiveVO helloHiveVO);

}
