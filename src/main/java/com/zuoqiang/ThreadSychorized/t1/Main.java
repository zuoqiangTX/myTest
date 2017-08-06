package com.zuoqiang.ThreadSychorized.t1;
/*实际应用中应该尽量缩小sychronized的使用范围，只加在需要保护的代码上面，因为sychronized会降低程序的性能
*使用sychonized关键字的时候，必须把对象引用传入参数
*
* sychronized(对象/this) {      //this指当前对象
*
* }
*
* */
public class Main {
    public static void main(String[] args) {
        Account account=new Account();
        account.setBalance(1000);
        Bank bank=new Bank(account);
        Thread bankthread=new Thread(bank);
        Company company=new Company(account);
        Thread companythread=new Thread(company);
        System.out.println("初始的值为："+account.getBalance());
        companythread.start();
        bankthread.start();
        try {
            companythread.join();
            bankthread.join();
            System.out.println("当前余额"+account.getBalance());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
