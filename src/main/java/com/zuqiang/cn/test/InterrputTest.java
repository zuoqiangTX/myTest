package com.zuqiang.cn.test;

public class InterrputTest {
    public static void main(String[] args) {
            Thread task=new Thread(new Worker());
            task.start();
            task.interrupt();

    }
    public static  class Worker implements Runnable{

        public void run() {
            System.out.println("Worker Start");
            try {
                Thread.sleep(500);

            }catch (InterruptedException e){
                System.out.println("Worker is :"+Thread.currentThread().isInterrupted());   //仅仅只能查看线程的中断状态
            }
            System.out.println("Worker End");

        }
    }
}
