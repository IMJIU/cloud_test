package com.im.cloud.interfase;

import com.im.cloud.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/5/14.
 */
@FeignClient("provider")
public interface IUserRemote {
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    User get(@PathVariable("id") Long id);

    @RequestMapping(value = "/show", method = RequestMethod.POST)
    User show(@RequestBody User user);
}
