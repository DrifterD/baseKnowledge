package com.yhx.basejava.thread;

import org.apache.commons.lang3.ThreadUtils;

public class ThreadState {

    public static void main(String[] arg){

        new Thread(new TimeWaiting(),"timeWating").start();
        new Thread(new Waiting(),"waitng").start();
        new Thread(new Blocked(),"blocked").start();
        new Thread(new Blocked(),"blocked-2").start();


    }

    static class TimeWaiting implements  Runnable{
        @Override
        public void run() {
            while(true){
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Waiting implements  Runnable{
        @Override
        public void run() {

            synchronized(Waiting.class){
                try {
                    Waiting.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    static class Blocked implements  Runnable{
        @Override
        public void run() {

            synchronized (Blocked.class) {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
