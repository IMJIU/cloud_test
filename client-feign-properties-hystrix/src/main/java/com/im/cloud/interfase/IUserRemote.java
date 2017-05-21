package com.im.cloud.interfase;

import com.im.cloud.controller.UserRemote;
import com.im.cloud.entity.User;
import config.FeignConfiguration;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by Administrator on 2017/5/14.
 */
@FeignClient(name = "provider", configuration = FeignConfiguration.class, fallback = UserRemote.class)
public interface IUserRemote {

    @RequestLine("GET /user/{id}")
    User get(@Param("id") Long id);
}
