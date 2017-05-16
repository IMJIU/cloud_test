package com.im.cloud.controller;

import com.im.cloud.dao.UserDao;
import com.im.cloud.entity.User;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2017/5/9.
 */
@RestController
public class UserController {

    @Autowired
    private UserDao userDao;
    @Autowired
    private org.springframework.cloud.client.discovery.DiscoveryClient discoveryClient;
    @Autowired
    private EurekaClient eurekaClient;
    @GetMapping("/user/{id}")
    public User get(@PathVariable Long id) {
        return userDao.findOne(id);
    }

    @PostMapping("/show")
    public User show(@RequestBody User user) {
        return user;
    }

    @GetMapping("/eurekaInstance")
    public String serviceUrl(){
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("PROVIDER",false);
        return instanceInfo.getHomePageUrl();
    }

    @GetMapping("/instanceInfo")
    public ServiceInstance showInfo(){
        ServiceInstance serviceInstance = discoveryClient.getLocalServiceInstance();
        return serviceInstance;
    }
}
