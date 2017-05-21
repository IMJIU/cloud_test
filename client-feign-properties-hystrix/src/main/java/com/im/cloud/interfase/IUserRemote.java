package com.im.cloud.interfase;

import com.im.cloud.entity.User;
import com.im.cloud.feign.UserRemote;
import feign.hystrix.FallbackFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2017/5/14.
 */
@FeignClient(name = "provider",fallback = UserRemote.class)
public interface IUserRemote {
    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
     User get(@PathVariable("id") Long id);

//    static class HystrixClientFallbackFactory implements FallbackFactory<HystrixClient> {
//        @Override
//        public HystrixClient create(Throwable cause) {
//            return new HystrixClientWithFallBackFactory() {
//                @Override
//                public Hello iFailSometimes() {
//                    return new Hello("fallback; reason was: " + cause.getMessage());
//                }
//            };
//        }
//    }
}
