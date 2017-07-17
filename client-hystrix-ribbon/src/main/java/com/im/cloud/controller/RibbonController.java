package com.im.cloud.controller;

import com.im.cloud.entity.User;
import com.im.cloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/5/10.
 */
@RestController
public class RibbonController {

    @Autowired
    private UserService userService;


    @GetMapping("/async/{id}")
    public User getAsync(@PathVariable("id")Long id) {
        return userService.getAsync(id).get();
    }


    @GetMapping("/get/{id}")
    public User get(@PathVariable Long id) {
        return userService.get(id);
    }


    @GetMapping("/hi")
    public User hi() {
        return userService.hi();
    }

}
