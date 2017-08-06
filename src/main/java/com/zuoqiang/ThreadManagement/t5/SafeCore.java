package com.zuoqiang.ThreadManagement.t5;
/*ThreadLocal的使用，为每个线程存储自己独立的值，只供线程自己使用，可以用get取得。
* 如果线程第一次调用，没有初始的值，因此需要重写initialValue()方法*/
import java.util.concurrent.TimeUnit;

public class SafeCore {
    public static void main(String[] args) {
        SafeTask safeTask = new SafeTask();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(safeTask, "task" + i);
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(2);     //每两秒启动一个线程
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
