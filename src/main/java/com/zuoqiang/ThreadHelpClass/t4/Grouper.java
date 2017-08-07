package com.zuoqiang.ThreadHelpClass.t4;

/*计算矩阵查找到的总次数*/
public class Grouper implements Runnable {
    private Result result;

    public Grouper(Result result) {
        this.result = result;
    }

    public void run() {
        int finalResult=0;
        System.out.printf("Grouper 处理中\n");
        int[] data=result.getData();
        for (int num : data) {
          finalResult+=num;
        }
        System.out.println("Grouper 总结果为"+finalResult);

    }
}
