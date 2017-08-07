package com.zuoqiang.ThreadHelpClass.t1;
/**
 * 信号量的使用Semaphore,保护一个或者多个共享资源的访问。
 *应用程序任何时候都可以使用Semaphore来保护临界区，它是一个基础的同步机制。其他同步机制根据情况使用
 * 默认采用非公平模式
 * */
public class Main {
    public static void main(String[] args) {
        PrintQueue printQueue=new PrintQueue();
        Thread[] threads=new Thread[10];  //10个打印机共享一个队列
        for (int i = 0; i < 10; i++) {
            threads[i]=new Thread(new Job(printQueue),"打印机"+i);
        }
        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }
    }
}
