package com.example.springboot03.exception;

import lombok.Data;

/**
 * @author yanhao
 * @data 2023/11/30
 */
@Data
public class ErrorResponse {
    private String message;
    private String errorTypeName;

    public ErrorResponse(Exception e) {
        this(e.getClass().getName(), e.getMessage());
    }

    public ErrorResponse(String message, String errorTypeName) {
        this.message = message;
        this.errorTypeName = errorTypeName;
    }
}
