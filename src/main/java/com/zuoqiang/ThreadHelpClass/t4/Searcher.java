package com.zuoqiang.ThreadHelpClass.t4;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/***
 * 实现线程，其他的都是辅助类
 */
public class Searcher implements Runnable {
    private int firstRow;
    private int lastRow;
    private  MatrixMock matrixMock;
    private Result result;
    private  int num;
    private final CyclicBarrier barrier;

    public Searcher(int firstRow, int lastRow, MatrixMock matrixMock, Result result, int num, CyclicBarrier barrier) {
        this.firstRow = firstRow;
        this.lastRow = lastRow;
        this.matrixMock = matrixMock;
        this.result = result;
        this.num = num;
        this.barrier = barrier;
    }

    public void run() {
        int counter;  //内部变量，每行查到的数据
        System.out.printf("%s 查找范围 %d - %d \n",Thread.currentThread().getName(),firstRow,lastRow);
        for (int i = firstRow; i <lastRow ; i++) {
            int row[]=matrixMock.getRow(i);
            counter=0;
            for (int j = 0; j < row.length; j++) {
                if(num==row[j]){
                    counter++;
                }
            }
            result.setData(i,counter);  //每行查到的数字保存到result中
        }
        System.out.printf("%s lines \n",Thread.currentThread().getName());
        try {
            barrier.await();   //然后在此等待，当最后一个await执行时候，被唤醒。
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }


    }
}
