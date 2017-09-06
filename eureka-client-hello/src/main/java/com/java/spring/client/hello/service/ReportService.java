package com.java.spring.client.hello.service;

import com.java.spring.client.hello.entity.Report;

import java.util.List;

/**
 * @author renqingwang on 2017/9/5.
 * @version 1.0
 */
public interface ReportService {
    Report createReport(Report report);

    Report getDetail(String id);

    List<Report> findByContentOrTitle(String content, String title);
}
