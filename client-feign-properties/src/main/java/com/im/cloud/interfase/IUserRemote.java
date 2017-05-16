package com.im.cloud.interfase;

import com.im.cloud.entity.User;
import config.FeignConfiguration;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/5/14.
 */
@FeignClient(value = "provider", configuration = FeignConfiguration.class)
public interface IUserRemote {

    @RequestLine("GET /user/{id}")
    User get(@Param("id") Long id);
}
