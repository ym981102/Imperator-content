package org.starrier.imperator.content.config.hystrix;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Starrier
 * @date 2018/12/19.
 */
@Configuration
public class HystrixThreadContextConfiguration {

    @Bean
    public SpringCloudHystrixConcurrencyStrategy springCloudHystrixCocurrencyStrategy() {
        return new SpringCloudHystrixConcurrencyStrategy();
    }

}
