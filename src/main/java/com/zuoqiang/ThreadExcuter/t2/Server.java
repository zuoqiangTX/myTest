package com.zuoqiang.ThreadExcuter.t2;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Server {
    private ThreadPoolExecutor executor;

    public Server() {
        executor= (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
    }
    public void executorTask(Task task){
        executor.execute(task);
        //观察执行器的状态
        System.out.printf("Server : Pool size %d\n",executor.getPoolSize());
        System.out.printf("Server : Active Count %d\n",executor.getActiveCount());
        System.out.printf("Server : SEND Count %d\n",executor.getTaskCount());
        System.out.printf("Server : Complete task %d\n",executor.getCompletedTaskCount());

    }
    public void endServer(){
        executor.shutdown();
    }
}
