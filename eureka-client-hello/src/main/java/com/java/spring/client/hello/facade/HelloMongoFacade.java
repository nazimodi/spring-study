package com.java.spring.client.hello.facade;

import com.java.spring.client.hello.common.ResultMessage;
import com.java.spring.client.hello.entity.Report;
import com.java.spring.client.hello.facade.vo.HelloMongoCreateVO;
import com.java.spring.client.hello.facade.vo.HelloMongoListVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author renqingwang on 2017/9/5.
 * @version 1.0
 */
@Api(description = "mongo操作")
@RequestMapping(value = "/v1/hello", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public interface HelloMongoFacade {
    @ApiOperation("创建report数据")
    @RequestMapping(value = "/mongo/report", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    ResultMessage<Report> getReportByParams(@Validated @RequestBody HelloMongoCreateVO helloMongoCreateVO);

    @ApiOperation("获取详情")
    @RequestMapping(value = "/mongo/report/{id}", method = RequestMethod.GET)
    ResultMessage<Report> getDetail(@ApiParam(value = "文档编号") @PathVariable String id);

    @ApiOperation("获取列表")
    @RequestMapping(value = "/mongo/report", method = RequestMethod.GET)
    ResultMessage<List<Report>> getList(@ModelAttribute HelloMongoListVO helloMongoListVO);

}
