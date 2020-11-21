package org.starrier.imperator.content.handler;

import com.alibaba.ttl.TransmittableThreadLocal;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author starrier
 * @date 2020/11/20
 */
@Component
public class SeataHandler implements HandlerInterceptor {

    @Override
    public boolean preHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object object) throws Exception {

        TransmittableThreadLocal<String> parent = new TransmittableThreadLocal<>();


        return true;
    }
}
