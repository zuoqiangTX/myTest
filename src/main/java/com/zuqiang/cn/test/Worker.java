package com.zuqiang.cn.test;

public class Worker {
    public static void main(String[] args) {
        MyThread task=new MyThread();
        task.start();
        task.interrupt();
        System.out.println("task is :"+task.isInterrupted());
        System.out.println("task is :"+task.isInterrupted());//即使中断状态为true，依然在运行，说明线程中断只是改了标志位
    }
}
