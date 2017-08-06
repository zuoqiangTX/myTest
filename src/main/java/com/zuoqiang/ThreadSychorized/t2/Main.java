package com.zuoqiang.ThreadSychorized.t2;
/*必须在while循环中调用wait，并且不断查询wait的条件，直到条件为真的时候才能继续*/
public class Main {
    public static void main(String[] args) {
        EventStorage storage=new EventStorage();
        Producer producer=new Producer(storage);
        Thread thread1=new Thread(producer,"生产者");
        Consumer consumer=new Consumer(storage);
        Thread thread2=new Thread(consumer,"消费者");
        thread1.start();
        thread2.start();
    }
}
