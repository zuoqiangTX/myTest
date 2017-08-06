package com.zuoqiang.ThreadManagement.t4;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/*等待线程的终止*/
public class DataSourceLoader implements  Runnable{
    public void run() {
        System.out.printf("DataSource is begining: %s\n",new Date());
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("DataSource is ending: %s\n",new Date());
    }
}
