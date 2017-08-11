package com.zuoqiang.ConcreencyCollections.t1;

import java.util.concurrent.ConcurrentLinkedDeque;

public class PoolTask implements Runnable {
    private ConcurrentLinkedDeque<String> list;

    public PoolTask(ConcurrentLinkedDeque<String> list) {
        this.list = list;
    }

    public void run() {
        for (int i = 0; i < 5000; i++) {
            list.pollFirst();
            list.pollLast();
        }

    }
}
