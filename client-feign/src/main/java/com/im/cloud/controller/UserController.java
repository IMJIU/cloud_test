package com.im.cloud.controller;

import com.im.cloud.entity.User;
import com.im.cloud.interfase.IUserRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/5/10.
 */
@RestController
public class UserController {
    @Autowired
    private IUserRemote userRemote;


    @GetMapping("/get/{id}")
    public User get(@PathVariable Long id) {
        return userRemote.get(id);
    }

    @GetMapping("/show/{id}")
    public User showUser(@PathVariable Long id) {
        User user = userRemote.get(id);
        System.out.println("user:"+user.getName());
        return userRemote.show(user);
    }
}
