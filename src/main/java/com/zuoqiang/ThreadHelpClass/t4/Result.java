package com.zuoqiang.ThreadHelpClass.t4;

public class Result  {
    private int[] data;

    public Result(int size) {
        this.data = new int[size];
    }

    public int[] getData() {
        return data;
    }

    public void setData(int position,int value) {
         data[position]=value;
    }
}
