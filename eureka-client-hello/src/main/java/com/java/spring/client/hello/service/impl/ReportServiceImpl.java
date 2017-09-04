package com.java.spring.client.hello.service.impl;

import com.java.spring.client.hello.entity.Report;
import com.java.spring.client.hello.repository.ReportRepository;
import com.java.spring.client.hello.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

/**
 * @author renqingwang on 2017/9/5.
 * @version 1.0
 */
@Service
@EnableMongoRepositories(basePackages = {"com.java.spring.client.hello.repository"})
public class ReportServiceImpl implements ReportService {
    @Autowired
    private ReportRepository reportRepository;

    @Override
    public Report createReport(Report report) {
        reportRepository.save(report);
        return report;
    }

    @Override
    public Report getDetail(String title) {
        return reportRepository.findByTitle(title);
    }
}
