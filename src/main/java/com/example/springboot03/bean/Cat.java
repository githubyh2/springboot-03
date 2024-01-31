package com.example.springboot03.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author yanhao
 * @data 2023/10/30
 */
@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class Cat {
    // 名字
    private String name;
    private Integer age;
}
