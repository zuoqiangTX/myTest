package com.zuoqiang.ThreadManagement.t3;

import java.util.concurrent.TimeUnit;

public class FileMain {
    public static void main(String[] args) {
        FileClock task=new FileClock();
        Thread t=new Thread(task);
        t.start();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            System.out.println("主线程休眠中");
        }
        t.interrupt();
    }
}
