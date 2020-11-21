package org.starrier.imperator.content.config.hystrix;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.Controller;
import org.starrier.imperator.content.annotation.RequestLimitIntercept;

/**
 * @author Starrier
 * @date 2018/12/20.
 */
@Configuration
public class CollapsingConfiguration {

    @Bean
    @ConditionalOnClass(Controller.class)
    public HystrixContextInterceptor userContextInterceptor() {
        return new HystrixContextInterceptor();
    }
}

