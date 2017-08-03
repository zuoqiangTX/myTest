package com.zuoqiang.ThreadManagement.t2;

public class Main {
    public static void main(String[] args) {
        PrimeGenerator task=new PrimeGenerator();
        task.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        task.interrupt();  //中断线程

    }
}
