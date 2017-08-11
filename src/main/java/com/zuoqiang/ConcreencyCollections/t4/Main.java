package com.zuoqiang.ConcreencyCollections.t4;

import java.util.Date;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

//带有延迟元素的线程安全列表 DelayQueue
public class Main {
    public static void main(String[] args) {
        DelayQueue<Event> queue = new DelayQueue<>();
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            Task task = new Task(i, queue);
            threads[i] = new Thread(task);
        }
        for (int i = 0; i < 5; i++) {
            threads[i].start();
        }
        for (int i = 0; i < 5; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        do {
            int counter = 0;
            Event event;
            do {
                event = queue.poll();
                if (event != null) {
                    counter++;
                }
            } while (event != null);
            System.out.printf("%s has read % d events \n",new Date(),counter);
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } while (queue.size() > 0);

    }
}
