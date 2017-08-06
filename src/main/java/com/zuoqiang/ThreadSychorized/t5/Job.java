package com.zuoqiang.ThreadSychorized.t5;

public class Job implements Runnable {
    private PrintQueue printQueue;

    public Job(PrintQueue printQueue) {
        this.printQueue = printQueue;
    }

    public void run() {
        //System.out.printf("%s start print\n",Thread.currentThread().getName());
        printQueue.printJob(new Object());
        System.out.printf("%s end   print\n",Thread.currentThread().getName());
    }
}
