package com.zuoqiang.ThreadManagement.t4;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class NetWorkConnectionsLoader implements Runnable {
    public void run() {
        System.out.printf("Network is begining: %s\n", new Date());
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Network is ending: %s\n", new Date());
    }
}
