package com.im.cloud.controller;/**
 * Created by zhoulf on 2017/6/20.
 */

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author
 * @create 2017-06-20 15:39
 **/
@RestController
public class OrderController {

    private static final Logger LOG = Logger.getLogger(OrderController.class.getName());

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/order")
    public String order() {
        LOG.log(Level.INFO, "order() is being called");
        return "get order()";
    }

    @RequestMapping("/user")
    public String user() {
        LOG.log(Level.INFO, "user() is being called");
        return restTemplate.getForObject("http://localhost:7961/user", String.class);
    }


}
