package com.zuoqiang.ThreadExcuter.t4;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class UserValidator {
    private String name;

    public UserValidator(String name) {
        this.name = name;
    }
    public boolean validate(String name,String password) {
        Random random=new Random();
        try {
            long duration= (long) (Math.random()*10);
            System.out.printf("%s is Validating during %d s\n",this.name,duration);
            TimeUnit.SECONDS.sleep(duration);   //休眠，模拟验证时间
        } catch (InterruptedException e) {
            //e.printStackTrace();
            return  false;
        }
        return  random.nextBoolean();
    }

    public String getName() {
        return name;
    }
}
