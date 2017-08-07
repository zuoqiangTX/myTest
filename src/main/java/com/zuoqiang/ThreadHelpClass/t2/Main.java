package com.zuoqiang.ThreadHelpClass.t2;

/**
 * 资源的多副本的并发控制
 * 3个线程可以同时对临界区进行访问，当一个完成释放工作量的时候，其他才可以。
 */
public class Main {
    public static void main(String[] args) {
        PrintQueue printQueue=new PrintQueue();
        Thread[] threads=new Thread[10];  //10个打印机共享一个队列
        for (int i = 0; i < 10; i++) {
            threads[i]=new Thread(new Job(printQueue),"打印机"+i);
        }
        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }    }
}
