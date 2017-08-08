package com.zuoqiang.ThreadExcuter.t3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * 在线程池中执行任务并返回结果
 * 实现callable接口，实现call方法，用Future获取call方法结果并管理他们的状态。
 */
public class Main {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        List<Future<Integer>> resultList = new ArrayList<Future<Integer>>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int num = random.nextInt(10);
            FactorialCalcutor factorialCalcutor = new FactorialCalcutor(num);
            Future<Integer> result = executor.submit(factorialCalcutor);
            resultList.add(result);
        }
        //循环打印任务的状态
        do {
            System.out.println("compelted Task " + executor.getCompletedTaskCount());
            for (int i = 0; i < resultList.size(); i++) {
                System.out.println("Task" + i + "is" + resultList.get(i).isDone());
            }
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (executor.getCompletedTaskCount() < resultList.size()); //如果完成数量小于10一直执行
        System.out.printf("Main :Result\n");// 打印结果
        for (int i = 0; i < resultList.size(); i++) {
            Future<Integer> result = resultList.get(i);
            Integer number = null;
            try {
                number = result.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            System.out.printf("Task %d :%d \n" ,i, number);

        }
        executor.shutdown();
    }

}
