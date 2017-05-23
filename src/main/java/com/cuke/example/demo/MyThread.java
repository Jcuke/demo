package com.cuke.example.demo;

/**
 * Created by sunyz on 2017/5/18 0018.
 */
public class MyThread implements Runnable {

    public static volatile boolean isRun = true;

    @Override
    public void run() {
        try {
            while (true) {
                if(isRun){
                    Thread.sleep(3000);
//                    System.out.println("线程运行中!");
                }else{
//                    System.out.println("线程已经休眠!");
                    Thread.sleep(5000);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
