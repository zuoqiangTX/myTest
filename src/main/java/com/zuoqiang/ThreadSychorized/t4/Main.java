package com.zuoqiang.ThreadSychorized.t4;

public class Main {
    public static void main(String[] args) {
        PriceInfo priceInfo=new PriceInfo();
        Reader[] readers=new Reader[5];
        Thread[] threadReaders=new Thread[5];
        for (int i = 0; i < 5; i++) {
            readers[i]=new Reader(priceInfo);
            threadReaders[i]=new Thread(readers[i],"读线程"+i);
        }
        Writer writer=new Writer(priceInfo);
        Thread threadWriter=new Thread(writer,"写线程");
        for (int i = 0; i <5 ; i++) {
            threadReaders[i].start();
        }
        threadWriter.start();
    }
}
