package com.zuoqiang.ThreadExcuter.t8;

import java.util.concurrent.Callable;

public class Task implements Callable<String> {
    public String call() throws Exception {
        while (true){
            System.out.printf("Task :Test\n");
            Thread.sleep(100);
        }
    }
}
