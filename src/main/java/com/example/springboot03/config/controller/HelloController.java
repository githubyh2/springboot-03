package com.example.springboot03.config.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yanhao
 * @data 2023/10/29
 */
@RestController
public class HelloController {

    @RequestMapping("/sayHello")
    public String sayHello() {
        return "hello,springboot!!!!";
    }
}
