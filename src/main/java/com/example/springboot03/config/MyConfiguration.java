package com.example.springboot03.config;

import com.example.springboot03.bean.Cat;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yanhao
 * @data 2023/10/30
 */
@Slf4j
@Configuration
public class MyConfiguration {
    @Bean
    @ConditionalOnClass(name = "com.example.springboot03.bean.Mouse")
    public Cat getCat() {
        log.info(" YH----ConditionalOnClass .....");
        return new Cat();
    }

}
