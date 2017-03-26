package com.cf.study.distributed.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServiceRegistry {

    public static void main(final String[] args) {
        SpringApplication.run(EurekaServiceRegistry.class, args);
    }

}
