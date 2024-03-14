package com.example.springboot03.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author yanhao
 * @data 2024/3/12
 * <p>
 * 注意：Cookie是无法跨域的
 */

@Slf4j
@RestController
public class SessionController_cookie {
    //设置Cookie
    @GetMapping("/c1")
    public Result cookie1(HttpServletResponse response) {   // response:响应  服务端 返回响应->浏览器
        response.addCookie(new Cookie("login_username", "itheima")); //设置Cookie/响应Cookie
        return Result.success();
    }

    //获取Cookie
    @GetMapping("/c2")
    public Result cookie2(HttpServletRequest request) {  // request:请求 浏览器 发送请求->服务端
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            System.out.println("====" + cookie.getName());
            if (cookie.getName().equals("login_username")) {
                System.out.println("login_username: " + cookie.getValue()); //输出name为login_username的cookie
            }
        }
        return Result.success();
    }
}
