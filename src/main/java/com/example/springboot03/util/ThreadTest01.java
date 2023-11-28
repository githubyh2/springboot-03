package com.example.springboot03.util;

/**
 * @author yanhao
 * @data 2023/11/28
 * <p>
 * java中创建线程的第一种方法， 继承Thread 类，重写Run 方法
 */
public class ThreadTest01 {
    public static void main(String[] args) {
        // 3、创建Thread类的子类的对象
        SonThead sonThead = new SonThead();

        sonThead.setName("线程一");
        // 4、通过创建的对象调用start 方法
        sonThead.start();

        Thread.currentThread().setName("main主线程");
        // 如下操作仍然是在main()主线程中执行的
        System.out.println("Hello!");
        for (int i = 0; i < 10; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

// 1、创建一个继承Thread 类的子类
class SonThead extends Thread {
    // 2、重写Thread类的run 方法
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}