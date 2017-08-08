package com.zuoqiang.ThreadExcuter.t5;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Task implements Callable<Result> {
    private String name;

    public Task(String name) {
        this.name = name;
    }

    public Result call() throws Exception {
        try {
            long duration= (long) (Math.random()*10);
            System.out.printf("%s is Validating during %d s\n",this.name,duration);
            TimeUnit.SECONDS.sleep(duration);   //休眠，模拟验证时间
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int value=0;
        for (int i = 0; i < 5; i++) {
            value+=(int) (Math.random()*100);

        }
        Result result=new Result();
        result.setName(this.name);
        result.setValue(value);
        System.out.println(this.name+"结束");
        return result;
    }
}
