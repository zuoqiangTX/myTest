package com.zuoqiang.ConcreencyCollections.t5;

import java.util.Map;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class Main {
    public static void main(String[] args) {
        ConcurrentSkipListMap<String, Contact> map = new ConcurrentSkipListMap<>();
        Thread[] threads = new Thread[25];
        int counter = 0;
        for (char i = 'A'; i<'Z'; i++){  //每个task对象的标识符是一个大写字符，分别以这些task对象创建运行线程并启动
            Task task = new Task(map, String.valueOf(i));
            threads[counter]=new Thread(task);
            threads[counter].start();
            counter++;
        }
        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("SIZE IS"+map.size());
        //使用FirstEntry()取得 map的第一个元素
        Map.Entry<String,Contact> element;
        Contact contact;
        element=map.firstEntry();  //返回数据不会移除元素
        contact=element.getValue();
        System.out.printf("Main:First Entry:%s:%s\n",contact.getName(),contact.getPhone());

        element=map.lastEntry();
        contact=element.getValue();
        System.out.printf("Main:Last Entry:%s:%s\n",contact.getName(),contact.getPhone());

        System.out.println("Main: Submap from A1996 to B1002:");
        ConcurrentNavigableMap<String, Contact> submap=map.subMap("A1996","B1002");
        do {
            element=submap.pollFirstEntry();  //返回并移除
            if (element != null) {
                contact=element.getValue();
                System.out.printf("%s:%s \n",contact.getName(),contact.getPhone());
            }

        }while (element!=null);


    }
}
