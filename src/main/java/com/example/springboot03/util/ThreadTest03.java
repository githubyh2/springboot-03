package com.example.springboot03.util;

/**
 * @author yanhao
 * @data 2023/11/28
 * <p>
 * java中创建线程的第二种方法： 实现Runnable 接口，重写 Runnable接口中的run方法，将实现类传递到Thread类的构造方法中并调用start方法
 */
public class ThreadTest03 {
    public static void main(String[] args) {
        // 3、创建实现类对象
        DemoThread demoThread = new DemoThread();

        // 4、将此对象作为参数传递到Thread的构造器中，创建Thread类的对象
        Thread thread = new Thread(demoThread);

        // 5、通过Thread 类的对象 ， 调用start 方法
        thread.start();
    }
}


// 1、创建一个implements实现Runnable接口的类
class DemoThread implements Runnable {
    // 2、 实现类去实现Runnable 接口中的抽象方法： run()
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}