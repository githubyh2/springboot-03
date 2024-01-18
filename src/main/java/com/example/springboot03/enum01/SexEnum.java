package com.example.springboot03.enum01;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author yanhao
 * @data 2024/1/12
 */
@AllArgsConstructor
@Getter
public enum SexEnum {
    MALE(1, "男"),
    FEMALE(0, "女"),
    UNKNOW(2, "未知");

    /**
     * 在需要存储数据库的属性上添加@EnumValue注解，在需要前端展示的属性上添加@JsonValue注解；
     */
    private final Integer code;

    @EnumValue
    private final String desc;

}
