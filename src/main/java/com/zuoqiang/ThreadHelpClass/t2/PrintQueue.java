package com.zuoqiang.ThreadHelpClass.t2;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {
    private final Semaphore semaphore;
    private boolean freePrinters[];   //打印机的状态
    private Lock lockPrinters;   //保护对数组的访问

    public PrintQueue() {
        this.semaphore = new Semaphore(3);
        freePrinters=new boolean[3];
        for (int i = 0; i < 3; i++) {
            freePrinters[i]=true;
        }
        lockPrinters= new ReentrantLock();
    }
    public void printJob(Object document){
        try {
            semaphore.acquire();   //获得许可
            int ret=getPrintNum();
            long duration= (long) (Math.random()*10);
            System.out.printf("%s is Print %d s\n",Thread.currentThread().getName(),duration);
            Thread.sleep(duration);   //休眠，模拟工作时间
            freePrinters[ret]=true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();   //释放许可
        }

    }
    public int getPrintNum(){
        int ret=1;
        try {
            lockPrinters.lock();
            for (int i = 0; i <freePrinters.length; i++) {
                if(freePrinters[i]){
                    ret=i;
                    freePrinters[i]=false;
                    break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lockPrinters.unlock();
        }
        return  ret;
    }
}
