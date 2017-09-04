package com.java.spring.client.hello.service;

import com.java.spring.client.hello.entity.Report;

/**
 * @author renqingwang on 2017/9/5.
 * @version 1.0
 */
public interface ReportService {
    Report createReport(Report report);

    Report getDetail(String title);
}
