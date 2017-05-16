package config;

import feign.Contract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2017/5/14.
 */
@Configuration
public class FeignConfiguration {
    @Bean
    public Contract feignContract(){
        return new feign.Contract.Default();
    }
}
