package com.zuoqiang.ThreadManagement.t7;

import com.zuqiang.cn.test.MyThread;

public class Main {
    public static void main(String[] args) {
        MyThreadFacotry facotry=new MyThreadFacotry("zuoqiang's factory");
        Task task=new Task();
        for (int i = 0; i < 10; i++) {
            Thread thread=facotry.newThread(task);  //十个线程执行同一个任务
            thread.start();
        }
        System.out.println("Factory sataus: \n");
        System.out.println(facotry.getStats()+"\n");
    }
}
