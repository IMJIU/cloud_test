package com.im.cloud.controller;

import com.im.cloud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

/**
 * Created by Administrator on 2017/5/10.
 */
@RestController
public class RibbonController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient balancerClient;

    @GetMapping("/user/{id}")
    public User get(@PathVariable Long id) {
        return restTemplate.getForObject("http://PROVIDER/user/" + id, User.class);
    }

    @GetMapping("/choose/test")
    public String chooseTest() {
        ServiceInstance serviceInstance = balancerClient.choose("provider");
        System.out.println(serviceInstance.getHost()+":"+serviceInstance.getPort()+"/"+serviceInstance.getServiceId());
        return "" + new Random().nextInt();
    }
}
