package com.zuoqiang.ConcreencyCollections.t6;

import java.util.concurrent.ThreadLocalRandom;

public class TaskLocalRandom implements Runnable {
    public TaskLocalRandom() {
        ThreadLocalRandom.current();  //当前线程初始化随机数生成器
    }

    @Override
    public void run() {
        String name=Thread.currentThread().getName();
        for (int i = 0; i < 10; i++) {
            System.out.printf("%s :%d \n", name,ThreadLocalRandom.current().nextInt(10));
        }

    }
}
