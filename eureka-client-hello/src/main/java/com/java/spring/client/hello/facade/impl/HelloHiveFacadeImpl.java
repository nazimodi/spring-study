package com.java.spring.client.hello.facade.impl;

import com.java.spring.client.hello.common.condition.ConditionServiceConfirm;
import com.java.spring.client.hello.facade.HelloHiveFacade;
import com.java.spring.client.hello.facade.vo.HelloHiveVO;
import com.java.spring.client.hello.service.HiveExecuteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author renqingwang on 2017/8/14.
 * @version 1.0
 */
@RestController
public class HelloHiveFacadeImpl implements HelloHiveFacade {
   @Autowired
   private HiveExecuteService hiveExecuteService;

   @Override
    public String hiveQuery(@Validated @RequestBody HelloHiveVO helloHiveVO) {
        return hiveExecuteService.executeHiveSql(helloHiveVO.getHiveSql()).toString();
    }

}
