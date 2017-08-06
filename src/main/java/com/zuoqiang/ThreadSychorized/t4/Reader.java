package com.zuoqiang.ThreadSychorized.t4;

public class Reader implements Runnable {
    private  PriceInfo priceInfo;

    public Reader(PriceInfo priceInfo) {
        this.priceInfo = priceInfo;
    }

    public void run() {
    //循环读取两个值10次
        for (int i = 0; i < 10; i++) {
            System.out.printf("%s :Price1 is %f\n",Thread.currentThread().getName(),priceInfo.getPrice1());
            System.out.printf("%s :Price2 is %f\n",Thread.currentThread().getName(),priceInfo.getPrice2());

        }
    }
}
