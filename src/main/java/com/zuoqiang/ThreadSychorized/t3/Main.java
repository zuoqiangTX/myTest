package com.zuoqiang.ThreadSychorized.t3;

public class Main {
    public static void main(String[] args) {
       PrintQueue printQueue=new PrintQueue();
       Job job=new Job(printQueue);
        for (int i = 0; i < 10; i++) {
            Thread thread=new Thread(job,"线程"+i);
            thread.start();
        }
    }
}
