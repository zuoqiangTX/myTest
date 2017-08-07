package com.zuoqiang.ThreadHelpClass.t4;

import java.util.Random;

public class MatrixMock {
    private int[][] data;

    public MatrixMock(int size,int length,int number) {
        int counter=0;
        data=new int[size][length];
        Random random=new Random();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j <length; j++) {
                data[i][j]=random.nextInt(10);
                if(data[i][j]==number){
                    counter++;
                }

            }

        }
        System.out.printf("数字%d has counter",number,counter);
    }
    public int[] getRow(int row){   //返回行数
        if(row>=0&&(row<data.length)){
          return data[row];
        }
        return null;
    }
}
