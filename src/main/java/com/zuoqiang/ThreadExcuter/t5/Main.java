package com.zuoqiang.ThreadExcuter.t5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*运行多个任务并处理所有结果*/
public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        List<Task> list = new ArrayList<Task>();
        for (int i = 0; i < 3; i++) {
            Task task = new Task("任务" + i);
            list.add(task);
        }
        List<Future<Result>> resultList = null;
        try {
            resultList = executor.invokeAll(list);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.shutdown();
        for (int i = 0; i < resultList.size(); i++) {
            Future<Result> future = resultList.get(i);
            try {
                Result result = future.get();
                System.out.println(result.getName()+"结果为"+result.getValue());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

        }

    }
}
