package com.zuoqiang.ThreadHelpClass.t4;

import java.util.concurrent.CyclicBarrier;

/***
 * 集合点的同步CyclicBarrier
 * CyclicBarrier使用一个整数，代表需要在某个点进行同步的线程数。
 * 1）当一个线程到达点以后，将调用await()等待其他线程的到来，此时它将被休眠。
 * 2）当最后一个线程调用await方法的时候，将唤醒所有在等待的线程。
 * 与CountdownLatch不同的是，它可以传入一个runnable对象，让所有线程到达集合点以后将Runnable对象作为线程执行
 */
public class Main {
    public static void main(String[] args) {
        final  int ROWS=10000;
        final  int NUMBERS=1000;
        final  int SERCH=5;
        final  int PARTCIPANTS=5;
        final  int LINES_PARTICIPANT=2000;
        MatrixMock mock=new MatrixMock(ROWS,NUMBERS,SERCH);
        Result result=new Result(ROWS);
        Grouper grouper=new Grouper(result);
        CyclicBarrier cyclicBarrier=new CyclicBarrier(PARTCIPANTS,grouper); //等待五个线程执行完后执行grouper线程
        Searcher[] searcher=new Searcher[PARTCIPANTS];
        for (int i = 0; i < PARTCIPANTS ; i++) {
            searcher[i]=new Searcher(i*LINES_PARTICIPANT,(i*LINES_PARTICIPANT)+LINES_PARTICIPANT,mock,result,5,cyclicBarrier);
            Thread thread=new Thread(searcher[i],"搜索线程"+i);
            thread.start();
        }
        //System.out.println("任务完成！");

    }
}
