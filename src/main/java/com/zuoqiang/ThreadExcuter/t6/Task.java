package com.zuoqiang.ThreadExcuter.t6;

import java.util.Date;
import java.util.concurrent.Callable;

public class Task implements Callable<String> {
    private String name;

    public Task(String name) {
        this.name = name;
    }

    public String call() throws Exception {
        System.out.println(this.name+"开始于"+new Date());
        return "Hello World";
    }
}
