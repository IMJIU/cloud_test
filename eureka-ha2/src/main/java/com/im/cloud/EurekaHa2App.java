package com.im.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaHa2App {
    public static void main(String[] args) {
        SpringApplication.run(EurekaHa2App.class, args);
    }
}
