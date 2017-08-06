package com.zuoqiang.ThreadManagement.t7;

import com.sun.org.glassfish.external.statistics.Stats;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadFactory;

/**
 * 使用工厂类ThreadFactory创建线程
 * 好处是 ：将对象的生成集中化
 * 1）更容易修改类
 * 2）更容易为有限资源限制对象数目
 * 3）更容易为创建的类统计数据
 */
public class MyThreadFacotry implements ThreadFactory {
    private int counter;  //线程的数量
    private String name;   //线程的名字
    private List<String> stats;  //线程的统计数据

    public MyThreadFacotry(String name) {
        counter = 0;
        this.name = name;
        this.stats =new ArrayList<String>();
    }

    public Thread newThread(Runnable r) {
        Thread t=new Thread(r,name+"-Thread-"+counter);
        counter++;
        stats.add(String.format("Create Thread %d with name %s on %s\n",t.getId(),t.getName(),new Date()));
        return t;

    }
    public String getStats(){
        StringBuffer str=new StringBuffer();
        Iterator<String> iterator=stats.iterator();
        while (iterator.hasNext()){
            str.append(iterator.next());
            str.append("\n");
        }
        return str.toString();
    }
}
