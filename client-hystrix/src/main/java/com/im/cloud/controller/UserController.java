package com.im.cloud.controller;

import com.im.cloud.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.annotation.SessionScope;

/**
 * Created by Administrator on 2017/5/10.
 */
@RestController
@SessionScope
public class UserController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/get/{id}")
    @HystrixCommand(fallbackMethod = "getFailback")
    public User get(@PathVariable Long id) {
        return restTemplate.getForObject("http://PROVIDER/user/" + id, User.class);
    }

//    @GetMapping("/user2/{id}")
//    @HystrixCommand(fallbackMethod = "getFailback",commandProperties = @HystrixProperty(name="execution.isolation.strategy",value="thread"))
//    public User get2(@PathVariable Long id) {
//        return restTemplate.getForObject("http://PROVIDER/user/" + id, User.class);
//    }

    public User getFailback(@PathVariable Long id) {
        User user = new User();
        user.setId(id);
        return user;
    }
}
