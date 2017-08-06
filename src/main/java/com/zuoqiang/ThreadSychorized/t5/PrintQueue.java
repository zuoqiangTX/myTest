package com.zuoqiang.ThreadSychorized.t5;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**实现锁的公平性
 * 公平锁将选择一个等待时间最长的来访问
 *
 * */
public class PrintQueue {
    private final Lock queueLock =new ReentrantLock(true);
    public  void printJob(Object document){
        queueLock.lock();
        try {
        Long duration=(long) (Math.random()*10000);
        System.out.println(Thread.currentThread().getName()+"Print a job during"+duration/1000+"s");
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            queueLock.unlock();
        }
        queueLock.lock();
        try {
            Long duration=(long) (Math.random()*10000);
            System.out.println(Thread.currentThread().getName()+"Print a job during"+duration/1000+"s");
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            queueLock.unlock();
        }

    }
}
