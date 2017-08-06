package com.zuoqiang.ThreadManagement.t5;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class UnsafeTask implements Runnable {
    private Date startDate;
    public void run() {
     startDate=new Date();
        System.out.printf("starting thread is %s :%s\n",Thread.currentThread().getName(),startDate);
        try {
            TimeUnit.SECONDS.sleep((int) Math.rint(Math.random()*10));  //随机休眠
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Thread finished %s :%s\n",Thread.currentThread().getName(),startDate);
    }
}
