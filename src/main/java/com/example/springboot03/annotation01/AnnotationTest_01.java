package com.example.springboot03.annotation01;

/**
 * @author yanhao
 * @data 2023/12/4
 */

/**
 * 注解使用：
 */
public class AnnotationTest_01 {
}


@MyAnnotation(value = "person")  // 使用自定义的注解案例
class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void walk() {
        System.out.println("person 走路");
    }
}

interface Info {
    void show();
}

class Student extends Person implements Info {
    @Override
    public void walk() {
        System.out.println("student 中 walk");
    }

    @Override
    public void show() {

    }
}
