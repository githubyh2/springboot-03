package com.example.springboot03.config;

import com.example.springboot03.interceptor.LoginCheckInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author yanhao
 * @data 2024/3/13
 */
//@Configuration
public class WebConfig implements WebMvcConfigurer {
    // 配置自定义的拦截器对象
    @Autowired
    private LoginCheckInterceptor loginCheckInterceptor;


    // 增加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // 注册自定义拦截器对象
        registry.addInterceptor(loginCheckInterceptor)
                .addPathPatterns("/**") //设置拦截器拦截的请求路径（ /** 表示拦截所有请求
                .excludePathPatterns("/login"); //设置不拦截的请求路径
    }
}
