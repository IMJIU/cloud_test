package com.im.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class ConfigClientEurekaApp {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientEurekaApp.class, args);
    }
}
