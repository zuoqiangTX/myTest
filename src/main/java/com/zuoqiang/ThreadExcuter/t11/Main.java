package com.zuoqiang.ThreadExcuter.t11;

import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 处理在线程池中被拒绝的任务
 */
public class Main {
    public static void main(String[] args) {
        RejectedExecutionHandler handler = new RejectedTaskController();
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        executor.setRejectedExecutionHandler(handler);
        System.out.println("Main : Starting");
        for (int i = 0; i < 3; i++) {
            Task task = new Task("Task" + i);
            executor.submit(task);
        }
        System.out.println("Main : Shutdown");
        executor.shutdown();

        System.out.println("Main : send another Task");
        Task task = new Task("RejectTask");
        executor.submit(task);
        System.out.println("Task End!");

    }
}
