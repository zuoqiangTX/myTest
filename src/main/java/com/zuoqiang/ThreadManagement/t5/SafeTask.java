package com.zuoqiang.ThreadManagement.t5;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SafeTask implements Runnable {
    private ThreadLocal<Date> startDate=new ThreadLocal<Date>(){
        @Override
        protected Date initialValue() {
            return new Date();
        }
    };
    public void run() {
        System.out.printf("starting thread is %s :%s\n",Thread.currentThread().getName(),startDate.get());
        try {
            TimeUnit.SECONDS.sleep((int) Math.rint(Math.random()*10));  //随机休眠
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Thread finished %s :%s\n",Thread.currentThread().getName(),startDate.get());

    }
}
