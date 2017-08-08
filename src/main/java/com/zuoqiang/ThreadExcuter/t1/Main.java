package com.zuoqiang.ThreadExcuter.t1;

/**
 * 线程执行器框架 Executor接口和它的子接口 ExecutorService 以及实现这两个接口的ThreadPoolExecutor
 * 执行器的优点
 * 1）线程池 ，只需把runnable对象丢进去
 * 2) callable接口，使用future控制callable对象的状态和结果。
 */

/*实现缓冲线程池newCachedThreadPool*/
public class Main {
    public static void main(String[] args) {
        Server server=new Server();
        for (int i = 0; i < 100; i++) {
            Task task=new Task("任务"+i);
            server.executorTask(task);
        }
        server.endServer();
    }
}
