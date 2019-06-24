/*
 * Copyright (C), 2002-2017, bigmoon,All Rights Reserved.
 * FileName: CyclicBarrierMain.java
 * Author:   bigmoon
 * Date:     19-6-13 上午11:18
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * bigmoon     19-5-23 下午6:17      版本号        描述
 */

package bigmoon.learning.basejava.thread.cyclicBarrier;

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
