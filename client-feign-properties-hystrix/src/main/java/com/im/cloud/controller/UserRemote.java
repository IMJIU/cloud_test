package com.im.cloud.controller;

import com.im.cloud.entity.User;
import com.im.cloud.interfase.IUserRemote;
import feign.Param;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/5/14.
 */
@Component
public class UserRemote implements IUserRemote {

    @Override
    public User get(@Param("id") Long id) {
        User user = new User();
        user.setId(id);
        return user;
    }
}
