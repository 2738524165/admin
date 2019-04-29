package com.cssl.controller;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器
 */
public class Myinterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            Object onj= request.getSession().getAttribute("u");
            if(onj!=null){
                return  true;
            }
            response.sendRedirect("login.html");
        return false;
    }
}
