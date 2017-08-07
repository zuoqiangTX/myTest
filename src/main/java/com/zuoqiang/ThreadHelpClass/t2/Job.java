package com.zuoqiang.ThreadHelpClass.t2;

public class Job implements Runnable {
    private PrintQueue printQueue;

    public Job(PrintQueue printQueue) {
        this.printQueue = printQueue;
    }

    public void run() {
        // System.out.printf("%s is going\n",Thread.currentThread().getName());
        printQueue.printJob(new Object());
        System.out.printf("%s end\n",Thread.currentThread().getName());
    }
}
