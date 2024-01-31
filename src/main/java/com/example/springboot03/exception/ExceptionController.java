package com.example.springboot03.exception;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yanhao
 * @data 2023/12/5
 */
@RestController
@RequestMapping("/api")
public class ExceptionController {

    @GetMapping("/illegalArgument")
    public void throwException() {
        System.out.println("2023/12/5---");
        throw new IllegalArgumentException();
    }

    @GetMapping("/resourceNotFound")
    public void throwException2() {
        throw new ResourceNotFoundException();
    }
}
