package com.im.cloud.service;

import com.im.cloud.command.UserCommand;
import com.im.cloud.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
import rx.Observable;
import rx.Subscriber;

import java.util.concurrent.Future;

@Service
public class UserService {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFailback")
    public User get(@PathVariable Long id) {
        return restTemplate.getForObject("http://PROVIDER/user/" + id, User.class);
    }

    public User getFailback(@PathVariable Long id) {
        User user = new User();
        user.setId(id);
        return user;
    }

    @HystrixCommand(fallbackMethod = "getFailback")
    public User get2(@PathVariable Long id) {
        return new UserCommand(restTemplate, id).execute();
    }

    @HystrixCommand(fallbackMethod = "getFailback")
    public Future<User> get3(@PathVariable Long id) {
        return new UserCommand(restTemplate, id).queue();
    }

    @GetMapping("/hi")
    public User hi() {
        return restTemplate.getForObject("http://PROVIDER/user/" + 1, User.class);
    }

    @HystrixCommand(fallbackMethod = "getFallbackSubject")
    public AsyncResult<User> getAsync(Long id) {
        return new AsyncResult<User>() {
            @Override
            public User invoke() {
                return restTemplate.getForObject("http://PROVIDER/user/{1}", User.class,id);
            }
        };
    }

    @HystrixCommand(fallbackMethod = "getFallbackNoun")
    public Observable<String> getNoun() {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> observer) {
                try {
                    if (!observer.isUnsubscribed()) {
                        observer.onNext(restTemplate.getForObject("http://PROVIDER/print/noun", String.class));
                        observer.onCompleted();
                    }
                } catch (Exception e) {
                    observer.onError(e);
                }
            }
        });
    }

    public String getFallbackSubject() {
        return "某人";
    }

    public String getFallbackNoun() {
        return "某物";
    }
}