package com.zuoqiang.ThreadExcuter.t11;

import java.util.concurrent.TimeUnit;

public class Task implements Runnable {
    String name;

    public Task(String name) {
        this.name = name;
    }

    public void run() {
        System.out.println("Task "+this.name+"Starting");
        try {
            long duration= (long) (Math.random()*10);
            System.out.printf("Task %s: Report report %d s\n",name,duration);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task "+this.name+"End!");
    }

    @Override
    public String toString() {
        return this.name;
    }
}
