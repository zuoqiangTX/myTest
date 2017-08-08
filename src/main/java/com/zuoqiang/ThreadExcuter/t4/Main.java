package com.zuoqiang.ThreadExcuter.t4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *运行多个任务并处理第一个结果
 * 这个实例类有四种结果
 * 1）两个都返回true ，invokeAny结果为先完成的
 * 2）一个true 一个Exception ，InvokeAny返回第一个任务
 * 3)一个Exception,一个true ，InvokeAny返回第二个任务
 * 4)两个都异常，InvokeAny抛出ExcutionException
 *
*/
public class Main {
    public static void main(String[] args) {
        String name="test";
        String password="test";
        UserValidator ldapvalidator=new UserValidator("LDAP");
        UserValidator dbvalidator=new UserValidator("DB");
        TaskValidation ldapTask=new TaskValidation(ldapvalidator,name,password);
        TaskValidation dbTask=new TaskValidation(dbvalidator,name,password);
        List<TaskValidation> list=new ArrayList<TaskValidation>();
        list.add(ldapTask);
        list.add(dbTask);
        ExecutorService executor= Executors.newCachedThreadPool();
        String result;
        try {
            result=executor.invokeAny(list);
            System.out.println("结果为"+result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executor.shutdown();
        System.out.printf("end!!!!!");


    }
}
