package com.zuoqiang.ThreadExcuter.t2;

import java.util.Date;

/*被web服务器执行的任务*/
public class Task implements Runnable{
    private Date initdate;
    private String name;

    public Task(String name) {
        initdate=new Date();
        this.name=name;
    }

    public void run() {
        System.out.printf("%s:Task %s create %s\n",Thread.currentThread().getName(),name,initdate);
        System.out.printf("%s:Task %s Start %s\n",Thread.currentThread().getName(),name,new Date());
        try {
            long duration= (long) (Math.random()*10);
            System.out.printf("%s:Task %s Working %s\n",Thread.currentThread().getName(),name,duration);
            Thread.sleep(duration);   //休眠，模拟工作时间
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s:Task %s end %s\n",Thread.currentThread().getName(),name,new Date());

    }
}
