package com.zuoqiang.ThreadManagement.t2;
/*线程的中断*/
public class PrimeGenerator extends  Thread {
    public void run(){
        long number=1L;
        while (true){
            if(isPrime(number)){
                System.out.printf("Number is Prime:%d\n",number);
            }
             if(isInterrupted()){  //检测线程的中断状态
                 System.out.println("线程被中断！");
                 return;
             }
             number++;
        }

    }
    private  boolean isPrime(long number){
        if(number<=2){
           return true;
        }
        for (int i = 2; i <=number; i++) {
            if(number%i==0){
                return false;
            }
        }
        return true;
    }
}
