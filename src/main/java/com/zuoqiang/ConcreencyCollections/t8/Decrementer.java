package com.zuoqiang.ConcreencyCollections.t8;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class Decrementer implements Runnable {
    private AtomicIntegerArray array;

    public Decrementer(AtomicIntegerArray array) {
        this.array = array;
    }

    @Override
    public void run() {
        for (int i = 0; i < array.length(); i++) {
            array.getAndDecrement(i);
        }

    }
}
