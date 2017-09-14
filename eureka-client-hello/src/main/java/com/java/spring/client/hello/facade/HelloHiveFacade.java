package com.java.spring.client.hello.facade;

import com.java.spring.client.hello.common.ResultMessage;
import com.java.spring.client.hello.facade.vo.HelloHiveVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author renqingwang on 2017/8/14.
 * @version 1.0
 */
@Api(description = "hive库连接测试")
@RequestMapping(value = "/v1/hello", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public interface HelloHiveFacade {
    @RequestMapping(value = "/hive", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @ApiOperation(value = "根据hive sql查询hive库")
    ResultMessage<String> hiveQuery(@Validated @RequestBody HelloHiveVO helloHiveVO);

}
