/*
 * Copyright (C), 2002-2017, bigmoon,All Rights Reserved.
 * FileName: ThreadState.java
 * Author:   bigmoon
 * Date:     19-6-13 上午11:19
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * bigmoon     19-6-13 上午11:19      版本号        描述
 */

package bigmoon.learning.basejava.thread;

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
