package com.zuoqiang.ConcreencyCollections.t3;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * 使用按优先级排列的阻塞式线程安全列表   PriorityBlockingQueue
 */
public class Main {
    public static void main(String[] args) {
        PriorityBlockingQueue<Event> queue = new PriorityBlockingQueue<>();
        Thread[] taskThread = new Thread[5];  //执行五个任务的线程
        for (int i = 0; i < 5; i++) {
            Task task = new Task(i, queue);
            taskThread[i] = new Thread(task);
        }
        for (int i = 0; i < 5; i++) {
            taskThread[i].start();
        }
        for (int i = 0; i < 5; i++) {
            try {
                taskThread[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println("SIZE " + queue.size());
        for (int i = 0; i < 5000; i++) {   //使用poll方法取数据
            Event e = queue.poll();
            System.out.println("Thread" + e.getThreadNum() + "priority" + e.getPriority());

        }
        System.out.println("main:END! size is"+queue.size());

    }
}
