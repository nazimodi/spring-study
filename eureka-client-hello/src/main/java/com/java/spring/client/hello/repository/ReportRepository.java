package com.java.spring.client.hello.repository;

import com.java.spring.client.hello.entity.Report;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author renqingwang on 2017/9/5.
 * @version 1.0
 */
@Repository
public interface ReportRepository extends MongoRepository<Report, String> {
    Report findByTitle(String title);

    Report findById(String id);

    List<Report> findByDate(String date);
}
