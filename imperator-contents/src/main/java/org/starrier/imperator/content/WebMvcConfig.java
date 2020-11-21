package org.starrier.imperator.content;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.Controller;
import org.starrier.imperator.content.annotation.RequestLimitIntercept;
import org.starrier.imperator.content.config.hystrix.HystrixContextInterceptor;

/**
 * @author starrier
 * @date 2020/11/21
 */
@Slf4j
@Component
public class WebMvcConfig implements WebMvcConfigurer {


    private final RequestLimitIntercept requestLimitIntercept;

    private final HystrixContextInterceptor userContextInterceptor;

    public WebMvcConfig(RequestLimitIntercept requestLimitIntercept, HystrixContextInterceptor userContextInterceptor) {
        this.requestLimitIntercept = requestLimitIntercept;
        this.userContextInterceptor = userContextInterceptor;
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        log.info("add custome intercept");
        registry.addInterceptor(requestLimitIntercept);
        registry.addInterceptor(userContextInterceptor);
    }


}