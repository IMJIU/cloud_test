package config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

/**
 * Created by Administrator on 2017/5/13.
 */
public class TestConfiguration {
    @Autowired
    private IClientConfig config;
    @Bean
    private IRule ribbonRule(IClientConfig config){
        return new RandomRule();
    }
}
