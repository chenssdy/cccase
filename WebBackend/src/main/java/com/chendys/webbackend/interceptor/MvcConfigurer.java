package com.chendys.webbackend.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * MDC链路追踪注入
 */
@Component
public class MvcConfigurer implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(MvcConfigurer.class);

    private static final String KEY = "requestId";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        MDC.put(KEY, UUID.randomUUID().toString());
        logger.info("业务调用开始, 管理员Id --> {}", request.getHeader("adminId"));
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("业务调用结束， 管理员Id --> {}", request.getHeader("adminId"));
        MDC.remove(KEY);
    }


}
