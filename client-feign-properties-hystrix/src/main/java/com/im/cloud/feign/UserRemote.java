package com.im.cloud.feign;

import com.im.cloud.entity.User;
import com.im.cloud.interfase.IUserRemote;
import org.springframework.stereotype.Component;

@Component
public class UserRemote implements IUserRemote {

    @Override
    public User get(Long id) {
        User user = new User();
        user.setId(id);
        return user;
    }
}