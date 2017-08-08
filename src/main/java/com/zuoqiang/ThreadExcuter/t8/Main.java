package com.zuoqiang.ThreadExcuter.t8;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 在线程池中取消操作
 * 使用Future接口的cancel来执行取消操作。
 */
public class Main {
    public static void main(String[] args) {
        ThreadPoolExecutor executor= (ThreadPoolExecutor) Executors.newCachedThreadPool();
        Task task=new Task();
        System.out.println("Main : 执行任务");
        Future<String> result=executor.submit(task);
        try {
            TimeUnit.SECONDS.sleep(2);  //主线程休眠两秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("取消任务！");
        result.cancel(true);
        System.out.println("Main cancelled:"+result.isCancelled());
        System.out.println("Main Done:"+result.isDone());
        executor.shutdown();
        System.out.println("Main : finshed!");


    }
}
