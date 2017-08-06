package com.zuoqiang.ThreadSychorized.t6;
/***
 * 在锁中使用多条件
 * Lock的condition的使用
 * 目的 ：允许线程获取锁并且查看等待的某一个条件是否满足，不满足就挂起直到某个线程唤醒他们。
 * conditon提供了挂起线程和唤醒线程的机制。
 */
public class FileMock {    //文本储存类
    private String[] content;
    private int index;

    public FileMock(int size,int length) {
        content=new String[size];
        for (int i = 0; i < size; i++) {
            StringBuilder builder=new StringBuilder(length);
            for (int j = 0; j < length; j++) {
                int indice= (int) (Math.random()*255);
                builder.append((char) indice);
            }
            content[i]=builder.toString();
        }
        index=0;
    }
    public boolean hasMoreLines(){
        return index<content.length;     //查看是否到结尾
    }
    public String getLine(){
        if(this.hasMoreLines()){
            System.out.printf("Mock:"+(content.length-index)+"\n");
            return content[index++];
        }
        return  null;
    }
}
