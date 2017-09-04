package com.java.spring.client.hello.facade.impl;

import com.java.spring.client.hello.common.ResultMessage;
import com.java.spring.client.hello.entity.Report;
import com.java.spring.client.hello.facade.HelloMongoFacade;
import com.java.spring.client.hello.facade.vo.HelloMongoCreateVO;
import com.java.spring.client.hello.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author renqingwang on 2017/9/5.
 * @version 1.0
 */
@RestController
public class HelloMongoFacadeImpl implements HelloMongoFacade {
    @Autowired
    private ReportService reportService;

    @Override
    public ResultMessage<Report> getReportByParams(@Validated @ModelAttribute HelloMongoCreateVO helloMongoCreateVO) {
        Report report = new Report();
        report.setContent(helloMongoCreateVO.getContent());
        report.setDate(helloMongoCreateVO.getDate());
        report.setTitle(helloMongoCreateVO.getTitle());
        report = reportService.createReport(report);
        return ResultMessage.getInstance().success(report);
    }
}
