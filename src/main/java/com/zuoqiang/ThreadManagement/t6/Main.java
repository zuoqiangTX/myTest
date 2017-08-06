package com.zuoqiang.ThreadManagement.t6;

public class Main {
    public static void main(String[] args) {
        Task task = new Task();
        MyThreadGroup threadGroup = new MyThreadGroup("zuoqiang");
        for (int i = 0; i < 2; i++) {
            Thread thread = new Thread(threadGroup, task);
            thread.start();
        }

    }
}
