package com.zuoqiang.ThreadSychorized.t4;

public class Writer implements  Runnable {
    private PriceInfo priceInfo;

    public Writer(PriceInfo priceInfo) {
        this.priceInfo = priceInfo;
    }

    public void run() {
        //循环修改价格3次
        for (int i = 0; i < 3; i++) {
            System.out.printf("Price is modify\n");
            priceInfo.setPrices(Math.random()*10,Math.random()*8);
            System.out.printf("Price has been modify\n");
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
