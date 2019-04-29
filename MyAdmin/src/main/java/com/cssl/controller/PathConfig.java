package com.cssl.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


 @Configuration
 public class PathConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/**").addResourceLocations("file:///D:\\学习资料\\Y2结业项目\\后台项目\\MyAdmin\\src\\main\\resources\\static\\img\\");
    /* registry.addResourceHandler("/img/** ").addResourceLocations("file:///opt/MyAdmin/static/img/");
        super.addResourceHandlers(registry);*/
    }
}

