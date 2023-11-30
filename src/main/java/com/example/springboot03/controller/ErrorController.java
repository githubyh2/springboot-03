package com.example.springboot03.controller;

import com.example.springboot03.util.ExceptionMessage;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yanhao
 * @data 2023/11/30
 */
@RestController
public class ErrorController {

    @RequestMapping("/testError")
    public String testError() {
        System.out.println(5 / 0);
        return "500";
    }

    /**
     * @param e
     * @return
     * @ExceptionHandler的参数为发生异常的类型。 如果controller的方法中捕获到了这种异常，
     * 就会走@ExceptionHandler表示的方法arithmeticException(),在方法参数中，可以获取异常对象。
     */
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public ExceptionMessage arithmeticException(Exception e) {
        ExceptionMessage exceptionMessage = new ExceptionMessage();
        exceptionMessage.setCode("500");
        exceptionMessage.setMessage(e.getMessage());
        return exceptionMessage;
    }


    @RequestMapping("/testNull")
    public String testNull() {
        String s = null;
        System.out.println(s.length());
        return null;
    }

    @RequestMapping("/testOther")
    public String testOther() {
        int[] arr = new int[3];
        System.out.println(arr[5]);
        return null;
    }
}
