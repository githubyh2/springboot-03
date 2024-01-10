package com.example.springboot03.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yanhao
 * @data 2023/10/29
 */
@Slf4j
@RestController
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/sayHello")
    public String sayHello() {
        log.info("the method is called。。。。。");
        return "hello,springboot!!!!";
    }
}
