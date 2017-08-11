package com.zuoqiang.ConcreencyCollections.t2;

import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**添加大量数据到列表中
 * 从一个列表中移除大量的数据
 * */
public class Main {
    public static void main(String[] args) {
        LinkedBlockingDeque<String> list= new LinkedBlockingDeque<>(3);
        Client client=new Client(list);
        Thread thread=new Thread(client);
        thread.start();
        for (int i = 0; i < 5; i++) {   //每两秒取5个字符，重复三次
            for (int j = 0; j < 3; j++) {
                String request = null;
                try {
                    request = list.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.printf("MAIN %s at %s size %d\n", request, new Date(),list.size());

            }
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("MAIN END!");
    }
}
