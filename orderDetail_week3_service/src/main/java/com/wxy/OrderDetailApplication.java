package com.wxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OrderDetailApplication {
    public static void main(String[] args) {
        //启动类
        SpringApplication.run(OrderDetailApplication.class,args);
    }
}
