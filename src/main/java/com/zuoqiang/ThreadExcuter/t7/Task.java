package com.zuoqiang.ThreadExcuter.t7;

import java.util.Date;

public class Task implements Runnable {
    private String name;

    public Task(String name) {
        this.name = name;
    }

    public void run() {
        System.out.println(this.name + "处理完成" + new Date());
    }
}
