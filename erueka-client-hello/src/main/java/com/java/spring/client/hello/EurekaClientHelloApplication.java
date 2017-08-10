package com.java.spring.client.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author renqingwang on 2017/8/10.
 * @version 1.0
 */
@EnableEurekaClient
@SpringBootApplication
public class EurekaClientHelloApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaClientHelloApplication.class, args);
    }
}
