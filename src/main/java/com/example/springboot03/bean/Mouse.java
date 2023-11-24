package com.example.springboot03.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author yanhao
 * @data 2023/10/30
 */
@Data
@Component
public class Mouse {
    private String name;
    private double weight;
}
