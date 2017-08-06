package com.zuoqiang.ThreadSychorized.t6;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer {    //缓冲类，被生产者和消费者共享
    private LinkedList<String> buffer;
    private int maxSize;
    private ReentrantLock lock;
    private Condition lines;    //缓冲区有数据
    private Condition space;    //缓冲区为空

    public void setPendinglines(boolean pendinglines) {
        this.pendinglines = pendinglines;
    }

    private  boolean pendinglines;

    public Buffer(int maxSize) {
        this.maxSize = maxSize;
        buffer=new LinkedList<String>();
        lock=new ReentrantLock();
        lines=lock.newCondition();
        space=lock.newCondition();
        pendinglines=true;
    }

    public void insert(String line){
        lock.lock();
        try {
            if(buffer.size()==maxSize){
                //已经满了，调用space等待空位,当其他线程调用space条件的signal时候将被唤醒
                space.await();
            }
            buffer.add(line);    //有空位加入，lines唤醒所有等待缓冲区有数据的线程
            System.out.printf("%s :inserted line: %d\n",Thread.currentThread().getName(),buffer.size());
            lines.signalAll();

        }catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
    public String get(){
        String line=null;
        lock.lock();
        try {
            if(buffer.size()==0){
                //已经空了,调用lines等待缓冲区有数据的出现，
                lines.await();
            }
            //当被唤醒时候，继续执行下面的语句
            if(hasPendinglines()) {
                line=buffer.poll();
                System.out.printf("%s :Readed line: %d\n", Thread.currentThread().getName(), buffer.size());
                space.signalAll();
            }

        }catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return line;

    }
    public boolean hasPendinglines(){
        return pendinglines || buffer.size()>0;

    }

}
