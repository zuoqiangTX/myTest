package com.zuqiang.cn.test;

public class InnerSingleton {
    //静态内部类，线程安全。
    private static class  Singleton{
        private static Singleton singleton=new Singleton();
    }
    public static Singleton getInstance(){
        return Singleton.singleton;
    }
}
