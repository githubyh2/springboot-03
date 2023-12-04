package com.example.springboot03.annotation01;

/**
 * @author yanhao
 * @data 2023/12/4
 */

/**
 * 自定义注解：
 * 1、注解声明为：@interface
 * 2、内部定义成员，通常使用 value 表示
 * 3、可以指定成员默认值，使用defaule 定义
 * 4、如果自定义的注解没有成员，表名是一个标识作用
 * <p>
 * 如果注解有成员，在使用注解的时候，需要指明成员值
 * 自定义注解必须配上注解的信息处理流程（使用反射） 才有意义
 */
public @interface MyAnnotation {
    String value() default "hello";
}
