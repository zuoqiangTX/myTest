package com.zuoqiang.ThreadManagement.t4;

import java.util.Date;

/**等待线程的终止 join方法的使用*/
public class Main {
    public static void main(String[] args) {  //psvm
        Thread taskA=new Thread(new DataSourceLoader(),"DataSource");
        Thread taskB=new Thread(new NetWorkConnectionsLoader(),"Network");
        taskA.start();
        taskB.start();
        try {
            taskA.join();     //主线程等待A执行完
            taskB.join();     //主线程等待B执行完
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("congiure has been loaded:%s\n",new Date());

    }
}
