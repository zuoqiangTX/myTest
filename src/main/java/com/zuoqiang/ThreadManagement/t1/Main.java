package com.zuoqiang.ThreadManagement.t1;

public class Main {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            Calclator calclator=new Calclator(i);
            Thread thread=new Thread(calclator,"线程"+i);
            thread.start();
        }
    }
}
