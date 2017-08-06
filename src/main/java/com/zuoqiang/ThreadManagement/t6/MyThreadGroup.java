package com.zuoqiang.ThreadManagement.t6;
/*有的异常必须被捕获，或者必须使用throws再次抛出，这种叫做受检的异常
* 运行时异常不需要被捕获或者被声明*/
public class MyThreadGroup extends ThreadGroup{
    public MyThreadGroup(String name) {
        super(name);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.printf("This Thread %s has an Exception\n",t.getId()); //当一个线程抛出异常，其他线程对象都被中断。
        e.printStackTrace(System.out);
        System.out.printf("Terminating %s now\n",Thread.currentThread().getId());
        interrupt();
    }
}
