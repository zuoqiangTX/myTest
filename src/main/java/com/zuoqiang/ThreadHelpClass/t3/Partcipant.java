package com.zuoqiang.ThreadHelpClass.t3;

public class Partcipant implements  Runnable {
    private Videoconference videoconference;
    private String name;

    public Partcipant(Videoconference videoconference, String name) {
        this.videoconference = videoconference;
        this.name = name;
    }

    public void run() {
        long duration= (long) (Math.random()*10);
        try {
            Thread.sleep(duration);   //休眠，模拟路上花费的事件
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        videoconference.arrive(name);  //到达会议
    }
}
