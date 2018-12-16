package com.yhx.basejava.thread.cyclicBarrier;

import com.yhx.basejava.refection.Main;

import java.util.concurrent.*;

public class CyclicBarrierMain {

    public static void main(String[] args) throws Exception{
        CyclicBarrier cyclicBarrier=new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("all thread has wait been go ");
            }
        });

        ExecutorService threadPool= Executors.newCachedThreadPool();

        for(int i=0;i<5;i++){
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("current thread:"+Thread.currentThread().getName()+"will use cyclicBarrier"+
                    ",NumberWaiting="+cyclicBarrier.getNumberWaiting());

                    try {
                        cyclicBarrier.await();
                        System.out.println("current thread:"+Thread.currentThread().getName()+"used cyclicBarrier");
                    }catch(InterruptedException|BrokenBarrierException ex){
                     ex.printStackTrace();
                    }
                }
            });
        }
        threadPool.awaitTermination(10000L,TimeUnit.SECONDS);
        System.out.println("over");
    }

}
