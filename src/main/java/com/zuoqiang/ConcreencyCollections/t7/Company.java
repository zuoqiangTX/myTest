package com.zuoqiang.ConcreencyCollections.t7;

public class Company implements Runnable {
    private Account account;

    public Company(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            account.addAmount(1000);    //转账10次,每次1000块
        }

    }
}
