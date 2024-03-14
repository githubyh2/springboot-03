package com.example.springboot03.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author yanhao
 * @data 2024/3/12
 */
@Slf4j
@RestController
public class SessionController_session {

    @GetMapping("/s1")
    public Result session1(HttpSession session) {
        log.info("HttpSession-s1: {}", session.hashCode());

        session.setAttribute("loginUser", "tom"); //往session中存储数据
        session.setAttribute("password", "123456");
        return Result.success();
    }

    @GetMapping("/s2")
    public Result session2(HttpServletRequest request) {
        HttpSession session = request.getSession();
        log.info("HttpSession-s2: {}", session.hashCode());

        Object loginUser = session.getAttribute("loginUser"); //从session中获取数据
        log.info("loginUser: {}", loginUser);
        Object password = session.getAttribute("password");
        log.info("password: {}", password);

        return Result.success(password);
    }

}
