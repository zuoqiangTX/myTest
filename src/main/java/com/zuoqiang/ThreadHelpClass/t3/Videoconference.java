package com.zuoqiang.ThreadHelpClass.t3;

import java.util.concurrent.CountDownLatch;

public class Videoconference implements Runnable {
    private final CountDownLatch countDownLatch;

    public Videoconference(int num) {
        this.countDownLatch = new CountDownLatch(num);
    }
    public void arrive(String name){
        System.out.printf("%s : arrived\n",name);
        countDownLatch.countDown();  //计数器减一
        //System.out.printf("%d 个人在 waiting\n",countDownLatch.getCount());
    }
    public void run() {
        System.out.printf("人数:%d \n",countDownLatch.getCount());
        try {
            countDownLatch.await();  //所有使用await的线程等待与会者到达，在这里停下来
            //当计数器为0的时候，继续执行下面的语句
            System.out.println("所有人已到达");
            System.out.println("开始视频会议");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
