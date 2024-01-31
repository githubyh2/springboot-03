package com.example.springboot03.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author yanhao
 * @data 2023/12/4
 */
@ControllerAdvice(assignableTypes = ExceptionController.class)
//@ResponseBody
public class GlobalExceptionHandler {
    ErrorResponse illegalArgumentResponse = new ErrorResponse(new IllegalArgumentException("参数错误！"));
    ErrorResponse resourceNotFoundResponse = new ErrorResponse(new ResourceNotFoundException("sorry,the source is not found"));

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(Exception e) {
        if (e instanceof IllegalArgumentException) {
            return ResponseEntity.status(400).body(illegalArgumentResponse);
        } else if (e instanceof ResourceNotFoundException) {
            return ResponseEntity.status(400).body(resourceNotFoundResponse);
        }
        return null;
    }

}
