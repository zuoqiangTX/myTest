package com.zuoqiang.ThreadManagement.t1;

/*线程的创建和运行*/
public class Calclator implements  Runnable{
    private int number;

    public Calclator(int number) {
        this.number = number;
    }

    public void run() {
        for (int i = 0; i <=10 ; i++) {
            System.out.printf("%s : %d * %d =%d\n",Thread.currentThread().getName(),i,number,i * number);

        }
    }
}
