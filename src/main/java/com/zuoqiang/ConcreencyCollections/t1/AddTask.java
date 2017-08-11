package com.zuoqiang.ConcreencyCollections.t1;

import java.util.concurrent.ConcurrentLinkedDeque;

public class AddTask implements Runnable {
    private ConcurrentLinkedDeque<String> list;

    public AddTask(ConcurrentLinkedDeque<String> list) {
        this.list = list;
    }

    public void run() {
        String name = Thread.currentThread().getName();
        for (int i = 0; i < 10000; i++) {
            list.add(name + ": Elment " + i);
        }

    }
}
