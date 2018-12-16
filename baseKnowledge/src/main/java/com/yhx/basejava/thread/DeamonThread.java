package com.yhx.basejava.thread;

import java.io.PrintStream;
import java.util.concurrent.TimeUnit;

public class DeamonThread  {

    public static void main(String[] args)throws Exception{

        System.out.println("start");
        Thread thread=new Thread(new Runnable() {

            @Override
            public void run()  {
                try {
                    System.out.println("thread start run");
                    TimeUnit.SECONDS.sleep(2);
                }catch (Exception ex){
                    ex.printStackTrace();
                }finally {
                    System.out.println("thread finally");
                }
            }
        });
//        thread.setDaemon(true);
        thread.start();
        TimeUnit.SECONDS.sleep(2);
        System.out.println("over");
    }
}
