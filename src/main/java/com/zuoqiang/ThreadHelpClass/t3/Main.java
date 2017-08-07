package com.zuoqiang.ThreadHelpClass.t3;
/**
 * 等待多个并发事件的完成
 * CountDownLatch类
 * 完成一组正在其他线程中执行的操作之前，它允线程一直等待。构造参数的整数就是要等待的操作的数目。
 *  当一个类需要等待操作时候，调用await，然后它将进入休眠等待。
 *  当其他操作完成并调用countDown（）时候，计数器将减1，直到成0的时候
 *  所有调用await()的线程将被唤醒（可能不止一个哦）
 * */
public class Main {
    public static void main(String[] args) {
        Videoconference videoconference=new Videoconference(10); //等待10个会议人员
        Thread thread=new Thread(videoconference,"视频会议");
        thread.start();
        for (int i = 0; i < 10; i++) {
            Partcipant partcipant=new Partcipant(videoconference,"会员"+i);
            Thread tempThread=new Thread(partcipant);
            tempThread.start();

        }

    }
}
