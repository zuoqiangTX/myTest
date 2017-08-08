package com.zuoqiang.ThreadExcuter.t2;

/**
 * 创建固定大小的线程池
 * */
/*实现缓冲线程池newFixedThreadPool(数量)*/
public class Main {
    public static void main(String[] args) {
        Server server=new Server();
        for (int i = 0; i < 100; i++) {
            Task task=new Task("任务"+i);
            server.executorTask(task);
        }
        server.endServer();
    }
}
