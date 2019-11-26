package com.wxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ConsulApplication {
    //启动类
    public static void main(String[] args) {
        SpringApplication.run(ConsulApplication.class,args);
    }
}
