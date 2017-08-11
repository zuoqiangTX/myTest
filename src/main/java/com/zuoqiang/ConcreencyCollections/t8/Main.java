package com.zuoqiang.ConcreencyCollections.t8;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class Main {
    public static void main(String[] args) {
        final int THREADS = 100;
        AtomicIntegerArray array = new AtomicIntegerArray(1000);
        Incrementer incrementer = new Incrementer(array);
        Decrementer decrementer = new Decrementer(array);
        Thread[] incrementerThread = new Thread[THREADS];
        Thread[] decrementerThread = new Thread[THREADS];
        for (int i = 0; i < THREADS; i++) {
            incrementerThread[i] = new Thread(incrementer);
            decrementerThread[i] = new Thread(decrementer);

            incrementerThread[i].start();
            decrementerThread[i].start();
        }
        for (int i = 0; i < THREADS; i++) {
            try {
                incrementerThread[i].join();
                decrementerThread[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < array.length(); i++) {
            if (array.get(i) != 0) {
                System.out.println("VECTOR[" + i + "]: " + array.get(i));   //输出不为0的值

            }
        }
        System.out.println("END!!");

    }
}
