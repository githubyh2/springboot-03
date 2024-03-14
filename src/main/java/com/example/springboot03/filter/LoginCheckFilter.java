package com.example.springboot03.filter;

import com.alibaba.fastjson.JSONObject;
import com.example.springboot03.controller.Result;
import com.example.springboot03.util.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yanhao
 * @data 2024/3/12
 * <p>
 * 登录的时候进行过滤器拦截校验jwt令牌
 * <p>
 * 使用过滤器的时候是：
 * 1、定义过滤器：定义一个类，实现Filter接口，并重写其所有方法
 * 2、配置过滤器类：Filter类上加 @WebFilter 注解，配置拦截资源路径，引导类上加 @ServletComponentScan 开启Servlet 组件支持
 */
@Slf4j
//@WebFilter(urlPatterns = "/*")
public class LoginCheckFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        //前置：强制转换为http协议的请求对象、响应对象 （转换原因：要使用子类中特有方法）
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;


        // 1、获取请求的url
        String url = request.getRequestURL().toString();
        log.info("请求的路径是：{}", url);

        // 2、判断请求url中是否包含login，如果包含，说明是登录操作，放行
        if (url.contains("/login")) {
            // 放行请求
            chain.doFilter(request, response);
            return;  //结束当前方法的执行
        }

        // 3.获取请求头中的令牌（token）
        String token = request.getHeader("token");
        log.info("从请求头中获取的令牌：{}", token);

        // 4.判断令牌是否存在，如果不存在，返回错误结果（未登录）
        // StringUtils.hasLength():如果字符序列不为 null 值,并且字符序列的长度大于 0 ,则返回 true
        if (!StringUtils.hasLength(token)) {
            log.info("Token不存在");

            Result responseResult = Result.error("NOT_LOGIN");

            //把Result对象转换为JSON格式字符串 (fastjson是阿里巴巴提供的用于实现对象和json的转换工具类)
            String json = JSONObject.toJSONString(responseResult);
            response.setContentType("application/json;charset=utf-8");
            //响应
            response.getWriter().write(json);

            return;
        }

        // 5、解析token,如果解析失败，返回错误结果（未登录）
        try {
            JwtUtils.parseJWT(token);
        } catch (Exception e) {
            log.info("令牌解析失败！！");

            Result responseResult = Result.error("NOT_LOGIN");
            //把Result对象转换为JSON格式字符串 (fastjson是阿里巴巴提供的用于实现对象和json的转换工具类)
            String json = JSONObject.toJSONString(responseResult);
            response.setContentType("application/json;charset=utf-8");
            //响应
            response.getWriter().write(json);

            return;
        }
        //6.放行
        chain.doFilter(request, response);

    }
}
