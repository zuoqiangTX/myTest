package com.zuoqiang.ThreadExcuter.t9;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ResultTask extends FutureTask<String> {
    private  String name;

    public ResultTask(Callable<String> callable) {
        super(callable);
        this.name =((ExcutableTask)callable).getName();
    }

    @Override
    protected void done() {
        if(isCancelled()){
            System.out.println(name+" : has been canceled");
        }else{
            System.out.println(name+" : has been finished");
        }
    }
}
