package com.java.spring.client.hello.facade.impl;

import com.java.spring.client.hello.facade.HelloWorldFacade;
import com.java.spring.client.hello.facade.vo.HelloHiveVO;
import com.java.spring.client.hello.service.HiveExecuteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.hadoop.hive.HiveClient;
import org.springframework.data.hadoop.hive.HiveClientCallback;
import org.springframework.data.hadoop.hive.HiveTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author renqingwang on 2017/8/14.
 * @version 1.0
 */
@RestController
public class HelloWorldFacadeImpl implements HelloWorldFacade{
   /* @Autowired
    private HiveTemplate hiveTemplate;*/
   @Autowired
   private HiveExecuteService hiveExecuteService;

    public String hiveQuery(@Validated HelloHiveVO helloHiveVO) {
       return hiveExecuteService.executeHiveSql(helloHiveVO.getHiveSql()).toString();
    }
}
