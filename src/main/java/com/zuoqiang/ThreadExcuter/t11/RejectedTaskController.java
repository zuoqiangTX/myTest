package com.zuoqiang.ThreadExcuter.t11;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class RejectedTaskController implements RejectedExecutionHandler {
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("RejectedExecutionHandler the task "+r.toString()+"has been rejected");
        System.out.println("RejectedExecutionHandler "+executor.toString());
        System.out.println("RejectedExecutionHandler Terminating "+executor.isTerminating());
        System.out.println("RejectedExecutionHandler Terminated "+executor.isTerminated());

    }
}
