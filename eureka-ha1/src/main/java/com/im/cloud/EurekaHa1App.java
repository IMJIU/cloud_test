package com.im.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaHa1App {
    public static void main(String[] args) {
        SpringApplication.run(EurekaHa1App.class, args);
    }
}
