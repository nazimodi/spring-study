package com.java.spring.client.hello.service;

import java.util.List;

/**
 * @author renqingwang on 2017/8/14.
 * @version 1.0
 */
public interface HiveExecuteService {
    List<String> executeHiveSql(String hiveSql);
}
