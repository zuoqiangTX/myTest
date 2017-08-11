package com.zuoqiang.ConcreencyCollections.t1;

import java.util.concurrent.ConcurrentLinkedDeque;

/**添加大量数据到列表中
 * 从一个列表中移除大量的数据
 * */
public class Main {
    public static void main(String[] args) {
        ConcurrentLinkedDeque<String> linkedDeque=new ConcurrentLinkedDeque<>();
        Thread[] thread=new Thread[100];
        for (int i = 0; i < 100; i++) {
            AddTask task=new AddTask(linkedDeque);
            thread[i]=new Thread(task);
            thread[i].start();
        }
        System.out.println("add task start");
        for (int i = 0; i < 100; i++) {
            try {
                thread[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("num is"+linkedDeque.size());
        for (int i = 0; i < 100; i++) {
            PoolTask task=new PoolTask(linkedDeque);
            thread[i]=new Thread(task);
            thread[i].start();
        }
        System.out.println("poll task start");
        for (int i = 0; i < 100; i++) {
            try {
                thread[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("num is"+linkedDeque.size());

    }
}
