package com.zuoqiang.ThreadManagement.t3;

import java.util.Date;
import java.util.concurrent.TimeUnit;
/*线程的休眠和恢复*/
public class FileClock implements Runnable {
    public void run() {
        for (int i = 0; i < 10 ; i++) {
            System.out.printf("%s\n", new Date());
            try {
                TimeUnit.SECONDS.sleep(1);//休眠一秒
            } catch (InterruptedException e) {
                System.out.println("The FileClock has been interrupted!");
            }

        }
    }
}
