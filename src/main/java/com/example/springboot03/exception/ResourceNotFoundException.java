package com.example.springboot03.exception;

/**
 * @author yanhao
 * @data 2023/11/30
 */
public class ResourceNotFoundException extends RuntimeException{
    private String message;

    public ResourceNotFoundException() {
    }
}
