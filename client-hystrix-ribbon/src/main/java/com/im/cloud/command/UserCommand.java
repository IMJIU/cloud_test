package com.im.cloud.command;/**
 * Created by zhoulf on 2017/7/17.
 */


import com.im.cloud.entity.User;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixThreadPoolKey;
import org.springframework.web.client.RestTemplate;

/**
 * @author
 * @create 2017-07-17 17:44
 **/
public class UserCommand extends HystrixCommand<User> {
    private RestTemplate template;
    private Long id;

    public UserCommand(RestTemplate template, Long id) {
//        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"))
//                .andCommandKey(HystrixCommandKey.Factory.asKey("user.get"))
//                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("HelloWorldPool")));
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("UserCommand")));
        this.template = template;
        this.id = id;
    }

    @Override
    protected User run() throws Exception {
        return template.getForObject("http://PROVIDER/user/{1}", User.class, id);
    }
}
