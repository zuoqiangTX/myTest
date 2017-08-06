package com.zuoqiang.ThreadSychorized.t4;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**使用读写锁实现同步数据访问
 * 读写锁可以多个线程同时读，写时候只允许一个线程
 *
 * */
public class PriceInfo {
    private double price1;
    private double price2;
    private ReadWriteLock lock;   //读写锁

    public PriceInfo() {
        this.price1 = 0.0;
        this.price2 = 00;
        this.lock = new ReentrantReadWriteLock();
    }
    public double getPrice1(){
        //使用读锁
        lock.readLock().lock();
        double value=price1;
        lock.readLock().unlock();
        return value;

    }
    public double getPrice2(){
        //使用读锁
        lock.readLock().lock();
        double value=price2;
        lock.readLock().unlock();
        return value;

    }
    public void setPrices(double price1,double price2){
        //使用写锁
        lock.writeLock().lock();
        this.price1=price1;
        this.price2=price2;
        lock.writeLock().unlock();
    }
}
