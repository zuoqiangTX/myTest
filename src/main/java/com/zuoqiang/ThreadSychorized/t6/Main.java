package com.zuoqiang.ThreadSychorized.t6;
/***
 * 1）必须在循环中使用await()方法
 * 2）带有条件的代码必须在 lock对象的Lock()方法和unLock()方法中间
 */
public class Main {
    public static void main(String[] args) {
        FileMock mock=new FileMock(100,10);
        Buffer buffer=new Buffer(20);
        Producer producer=new Producer(mock,buffer);
        Thread threadProducer=new Thread(producer,"生产者");
        threadProducer.start();
        Consumer[] consumers=new Consumer[3];
        Thread[] threadConsumer=new Thread[3];
        for (int i = 0; i < 3; i++) {
             consumers[i]=new Consumer(mock,buffer);
             threadConsumer[i]=new Thread(consumers[i],"消费者"+i);
        }
        for (int i = 0; i < 3; i++) {
            threadConsumer[i].start();
        }

    }
}
