package com.zuoqiang.ThreadSychorized.t3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**使用锁实现同步 Lock的使用
 * 拥有更好的性能，tryLock的实现，控制代码更灵活。
 *
 * */
public class PrintQueue {
    private final Lock queueLock =new ReentrantLock();
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

    }
}
