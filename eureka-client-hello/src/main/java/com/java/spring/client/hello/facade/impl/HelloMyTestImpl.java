package com.java.spring.client.hello.facade.impl;

import com.java.spring.client.hello.base.BaseFacade;
import com.java.spring.client.hello.common.condition.ConditionServiceConfirm;
import com.java.spring.client.hello.facade.HelloMyTest;
import com.java.spring.client.hello.service.TestConditionService;
import com.java.spring.client.hello.service.impl.TestConditionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author renqingwang on 2017/9/2.
 * @version 1.0
 */
@RestController
@Configuration
public class HelloMyTestImpl extends BaseFacade implements HelloMyTest {
    @Autowired
    private TestConditionService testConditionService;

    @Override
    public String checkConditional() {
        try {
            if (testConditionService() == null) {
                System.out.println("conditional testConditionService not exist");
            } else {
                System.out.println("conditional testConditionService exist");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("conditional testConditionService not exist");
        }
        if (testConditionService == null) {
            System.out.println("autowired testConditionService not exist");
        } else {
            System.out.println("autowired testConditionService exist");
        }
        return null;
    }

    @Bean
    @Conditional(ConditionServiceConfirm.class)
    public TestConditionService testConditionService() {
        return new TestConditionServiceImpl();
    }
}
