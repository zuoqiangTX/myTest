package com.zuoqiang.ThreadManagement.t7;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Task implements Runnable {
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
