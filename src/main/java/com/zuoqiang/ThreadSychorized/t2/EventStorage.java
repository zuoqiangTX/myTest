package com.zuoqiang.ThreadSychorized.t2;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/*在同步代码中使用条件，使用sychronized |notify|notifyAll|wait 方法
* 1）调用wait时，线程休眠，释放同步代码块的对象，此时其他线程可以执行同步代码
* 2）使用notifyAll来唤醒
* */
public class EventStorage {
    private int maxSize;
    private List<Date> storage;

    public EventStorage() {
        this.maxSize = 10;
        this.storage = new LinkedList<Date>();
    }
    public synchronized  void set(){
        while(storage.size()==maxSize){  //列表如果为满，则wait挂起线程
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        storage.add(new Date());
        System.out.printf("Set:Size is %d\n",storage.size());
        notifyAll();
    }
    public synchronized  void get(){
        while(storage.size()==0) {       //列表如果为空，则wait挂起线程
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("Get:Size is %d:%s\n",storage.size(),((LinkedList<?>)storage).poll());
        notifyAll();
    }

}
