package com.zuoqiang.ThreadExcuter.t4;

import java.util.concurrent.Callable;

public class TaskValidation implements Callable<String> {
    private UserValidator validator;
    private String user;
    private String password;

    public TaskValidation(UserValidator validator, String user, String password) {
        this.validator = validator;
        this.user = user;
        this.password = password;
    }

    public String call() throws Exception {
        if(!validator.validate(user,password)){
            System.out.println("没有找到用户"+validator.getName());
            throw new Exception("ERROR");
        }
        System.out.println("验证成功"+validator.getName());
        return validator.getName();
    }
}
