package com.java.spring.client.hello.service.impl;

import com.java.spring.client.hello.entity.Report;
import com.java.spring.client.hello.repository.ReportRepository;
import com.java.spring.client.hello.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author renqingwang on 2017/9/5.
 * @version 1.0
 */
@Service
@EnableMongoRepositories(basePackages = {"com.java.spring.client.hello.repository"})
public class ReportServiceImpl implements ReportService {
    @Autowired
    private MongoOperations mongoOperations;
    @Autowired
    private ReportRepository reportRepository;

    @Override
    public Report createReport(Report report) {
        reportRepository.save(report);
        return report;
    }

    @Override
    public Report getDetail(String id) {
        return reportRepository.findById(id);
    }

    @Override
    @Cacheable(value = "report_list_cache")
    public List<Report> findByContentOrTitle(String content, String title) {
        return mongoOperations.find(Query.query(Criteria.where("content").is(content).and("title").is(title)), Report.class);
    }
}
