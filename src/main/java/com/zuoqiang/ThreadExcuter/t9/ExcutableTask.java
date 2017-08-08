package com.zuoqiang.ThreadExcuter.t9;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class ExcutableTask implements Callable<String> {
    private String name;

    public ExcutableTask(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String call() throws Exception {

        try {
            long duration= (long) (Math.random()*10);
            System.out.printf("%s : waiting for %d s\n",this.name,duration);
            TimeUnit.SECONDS.sleep(duration);   //休眠，模拟工作时间
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello,world! I'm"+name;
    }
}
