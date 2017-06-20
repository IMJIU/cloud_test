package com.im.cloud.controller;/**
 * Created by zhoulf on 2017/6/20.
 */

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author
 * @create 2017-06-20 15:38
 **/
@RestController
public class UserController {
    private static final Logger LOG = Logger.getLogger(UserController.class.getName());
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/order")
    public String order() {
        LOG.log(Level.INFO, "calling trace user()  ");
        return restTemplate.getForObject("http://localhost:7962/order", String.class);
    }

    @RequestMapping("/user")
    public String user() {
        LOG.log(Level.INFO, "calling trace service-hi user() ");
        return "get User()";
    }

    @Bean
    public AlwaysSampler defaultSampler() {
        return new AlwaysSampler();
    }


}
