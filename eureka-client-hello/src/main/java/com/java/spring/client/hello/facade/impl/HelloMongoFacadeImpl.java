package com.java.spring.client.hello.facade.impl;

import com.java.spring.client.hello.common.ResultMessage;
import com.java.spring.client.hello.entity.Report;
import com.java.spring.client.hello.facade.HelloMongoFacade;
import com.java.spring.client.hello.facade.vo.HelloMongoCreateVO;
import com.java.spring.client.hello.facade.vo.HelloMongoListVO;
import com.java.spring.client.hello.service.ReportService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author renqingwang on 2017/9/5.
 * @version 1.0
 */
@RestController
public class HelloMongoFacadeImpl implements HelloMongoFacade {
    @Autowired
    private ReportService reportService;

    @Override
    public ResultMessage<Report> getReportByParams(@Validated @RequestBody HelloMongoCreateVO helloMongoCreateVO) {
        Report report = new Report();
        report.setContent(helloMongoCreateVO.getContent());
        report.setDate(helloMongoCreateVO.getDate());
        report.setTitle(helloMongoCreateVO.getTitle());
        report = reportService.createReport(report);
        return ResultMessage.getInstance().success(report);
    }

    @Override
    public ResultMessage<Report> getDetail(@ApiParam(value = "文档编号") @PathVariable String id) {
        return ResultMessage.getInstance().success(reportService.getDetail(id));
    }

    @Override
    public ResultMessage<List<Report>> getList(@ModelAttribute HelloMongoListVO helloMongoListVO) {
        List<Report> list = reportService.findByContentOrTitle(helloMongoListVO.getContent(), helloMongoListVO.getTitle());
        return ResultMessage.getInstance().success(list);
    }
}
