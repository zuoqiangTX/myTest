package com.zuqiang.cn.test;

public class MyThread extends Thread{
    public void run(){
        for (int i = 0; i <100 ; i++) {
            super.run();
            System.out.println("i="+(i+1));

        }
    }
}
