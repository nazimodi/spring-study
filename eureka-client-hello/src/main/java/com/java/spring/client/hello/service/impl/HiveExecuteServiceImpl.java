package com.java.spring.client.hello.service.impl;

import com.java.spring.client.hello.service.HiveExecuteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.hadoop.hive.HiveClient;
import org.springframework.data.hadoop.hive.HiveClientCallback;
import org.springframework.data.hadoop.hive.HiveTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author renqingwang on 2017/8/14.
 * @version 1.0
 */
@Service
public class HiveExecuteServiceImpl implements HiveExecuteService {
    @Autowired
    private HiveTemplate hiveTemplate;

    public List<String> executeHiveSql(final String hiveSql) {
        List<String> objectList = hiveTemplate.execute(new HiveClientCallback<List<String>>() {
            public List<String> doInHive(HiveClient hiveClient) throws Exception {
                return hiveClient.execute(hiveSql);
            }
        });
        System.out.print(objectList.toString());
        return objectList;
    }
}
