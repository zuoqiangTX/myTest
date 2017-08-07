package com.zuoqiang.ThreadHelpClass.t1;

import java.util.concurrent.Semaphore;

public class PrintQueue {
    private final Semaphore semaphore;

    public PrintQueue() {
        this.semaphore = new Semaphore(1);
    }
    public void printJob(Object document){
        try {
            semaphore.acquire();    //获得许可证
            long duration= (long) (Math.random()*10);
            System.out.printf("%s is Print %d s\n",Thread.currentThread().getName(),duration);
            Thread.sleep(duration);   //休眠，模拟工作时间
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();    //释放信号量
        }

    }
}
