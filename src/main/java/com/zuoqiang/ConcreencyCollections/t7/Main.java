package com.zuoqiang.ConcreencyCollections.t7;
//原子变量
public class Main {
    public static void main(String[] args) {
        Account account=new Account();
        account.setBalance(1000);

        Company company=new Company(account);
        Thread companyThread=new Thread(company);
        Bank bank=new Bank(account);
        Thread bankThread=new Thread(bank);
        System.out.println("company的初始余额为"+account.getBalance());
        companyThread.start();
        bankThread.start();

        try {
            companyThread.join();
            bankThread.join();
            System.out.println("FIANL BALANCE"+account.getBalance());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
