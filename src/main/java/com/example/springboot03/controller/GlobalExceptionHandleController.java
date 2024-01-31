package com.example.springboot03.controller;

import com.example.springboot03.util.ExceptionMessage;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yanhao
 * @data 2023/11/30
 * 全局异常处理器
 */
//@ControllerAdvice
public class GlobalExceptionHandleController {
    // 算术异常类处理：发生 除0 异常时，会执行该方法
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public ExceptionMessage arithmeticException(Exception e) {
        ExceptionMessage exceptionMessage = new ExceptionMessage();
        exceptionMessage.setCode("5001");
        exceptionMessage.setMessage(e.getMessage());
        return exceptionMessage;
    }

    // 空指针异常类处理：发生 空指针异常时， 会执行该方法
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public ExceptionMessage nullPointerException(NullPointerException e) {
        ExceptionMessage exceptionMessage = new ExceptionMessage();
        exceptionMessage.setCode("5002");
        exceptionMessage.setMessage(e.getMessage());
        return exceptionMessage;
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ExceptionMessage otherException() {
        ExceptionMessage exceptionMessage = new ExceptionMessage();
        exceptionMessage.setCode("5003");
        exceptionMessage.setMessage("发生了其他未知异常！");
        return exceptionMessage;
    }

}
