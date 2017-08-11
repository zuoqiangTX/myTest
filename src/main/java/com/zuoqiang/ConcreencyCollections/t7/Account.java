package com.zuoqiang.ConcreencyCollections.t7;

import java.util.concurrent.atomic.AtomicLong;

public class Account {
    private AtomicLong balance;

    public Account() {
        this.balance = new AtomicLong();
    }

    public Long getBalance() {
        return balance.get();
    }

    public void setBalance(long balance) {
        this.balance.set(balance);
    }
    public void addAmount(long amount){  //加
        this.balance.getAndAdd(amount);
    }
    public void substractAmount(long amount){  //减
        this.balance.getAndAdd(-amount);

    }

}
