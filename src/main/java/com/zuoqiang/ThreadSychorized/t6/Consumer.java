package com.zuoqiang.ThreadSychorized.t6;

import java.util.Random;

public class Consumer implements Runnable {
    private FileMock fileMock;
    private Buffer buffer;

    public Consumer(FileMock fileMock, Buffer buffer) {
        this.fileMock = fileMock;
        this.buffer = buffer;
    }

    public void run() {
        while(buffer.hasPendinglines()){
            String line=buffer.get();
            processLine(line);
        }
    }

    private void processLine(String line) {
        try {
            Random random=new Random();
            Thread.sleep(random.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
