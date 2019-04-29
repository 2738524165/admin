package com.cssl.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 添加拦截器
 */
@Configuration
public class SessionConfiguraction implements WebMvcConfigurer {


    //拦截登录直接访问index页面
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new Myinterceptor()).addPathPatterns("/**").excludePathPatterns("/login","/login.html","/AuthImage","/css/**","/js/**","/lib/**","/static/**","/temp/**","/assets/**","/logins");
    }



}
