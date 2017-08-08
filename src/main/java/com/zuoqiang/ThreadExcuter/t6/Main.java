package com.zuoqiang.ThreadExcuter.t6;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 在任务延时器中执行任务
 */
public class Main {
    public static void main(String[] args) {
        ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(1);
        System.out.println("Main start" + new Date());
        for (int i = 0; i < 5; i++) {
            Task task = new Task("Task" + i);
            executor.schedule(task,i+1,TimeUnit.SECONDS);
        }
        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main:End"+new Date());
    }
}
