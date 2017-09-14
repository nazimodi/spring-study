package com.java.spring.client.hello;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author renqingwang on 2017/8/10.
 * @version 1.0
 */
/*@EnableEurekaClient*/
@SpringBootApplication
@SpringBootConfiguration
@EnableAutoConfiguration
@Configuration
@ComponentScan(basePackages = {"com.java.spring.client.hello"})
@MapperScan(basePackages = {"com.java.spring.client.hello.mapper"})
@ImportResource(locations = {"classpath:hive-context.xml"})
public class EurekaClientHelloApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaClientHelloApplication.class, args);
    }
}
