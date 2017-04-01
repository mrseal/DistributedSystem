package com.cf.study.distribute.system.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

import com.cf.study.distribute.system.controller.Calculate24Controller;

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackageClasses = Calculate24Controller.class)
public class Application {

    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
