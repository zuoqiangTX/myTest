package com.zuoqiang.ThreadSychorized.t1;

/*使用sychronized实现同步方法
* 临界区：同一时间只能有一个线程访问它*/
public class Account {
    private double balance;

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {

        return balance;
    }

    public synchronized void addAmount(double amount) {
        double temp = amount;
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        temp += amount;
        balance = temp;
    }
    public synchronized void substractAmount(double amount){
        double temp = amount;
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        temp -= amount;
        balance = temp;
    }
}
