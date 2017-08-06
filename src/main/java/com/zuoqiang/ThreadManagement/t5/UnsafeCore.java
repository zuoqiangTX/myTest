package com.zuoqiang.ThreadManagement.t5;
/*线程的局部变量所有线程都会共享*/
import java.util.concurrent.TimeUnit;

public class UnsafeCore {
    public static void main(String[] args) {
        UnsafeTask unsafeTask=new UnsafeTask();
        for (int i = 0; i <10 ; i++) {
            Thread thread=new Thread(unsafeTask,"task"+i);
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(2);     //每两秒启动一个线程
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
