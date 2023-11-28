package com.example.springboot03.util;

/**
 * @author yanhao
 * @data 2023/11/28
 */
public class ThreadTest02 {
    public static void main(String[] args) {

        // 获取可用的处理器核数
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println("-----" + availableProcessors);

        // 线程一
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    if (i % 2 == 0) {
                        // 获取线程
                        String threadName = Thread.currentThread().getName();
                        System.out.println(threadName + ":" + i);
                    }
                }
            }
        }.start();

        // 线程二
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    if (i % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    }
                }
            }
        }.start();
    }
}
