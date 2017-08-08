package com.zuoqiang.ThreadExcuter.t9;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 在执行器中控制任务的完成
 * FutureTask 的done方法
 * */
public class Main {
    public static void main(String[] args) {
        ExecutorService executor= Executors.newCachedThreadPool();
        ResultTask[] resultTasks=new ResultTask[5];
        for (int i = 0; i < 5; i++) {
            ExcutableTask task=new ExcutableTask("Task"+i);
            resultTasks[i]=new ResultTask(task);
            executor.submit(resultTasks[i]);
        }
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.shutdown();   //任务执行完成以后就会调用done方法
    }
}
