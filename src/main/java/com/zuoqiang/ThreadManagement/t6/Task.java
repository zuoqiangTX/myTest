package com.zuoqiang.ThreadManagement.t6;

import java.lang.Thread;

import java.util.Random;

public class Task implements Runnable {
    public void run() {
          int result;
        Random random=new Random(Thread.currentThread().getId());
        while (true) {
            result= (1000/(int) (random.nextDouble()*1000));
            System.out.printf("Thread % s is %d\n", Thread.currentThread().getId(),result);
            if(Thread.currentThread().isInterrupted()){
                System.out.printf("%d is interrupted!"+Thread.currentThread().getId());
                return;
            }

        }
        }
}
