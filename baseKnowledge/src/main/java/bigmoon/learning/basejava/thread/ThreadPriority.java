/*
 * Copyright (C), 2002-2017, bigmoon,All Rights Reserved.
 * FileName: ThreadPriority.java
 * Author:   bigmoon
 * Date:     19-6-13 上午11:18
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * bigmoon     19-5-23 下午6:17      版本号        描述
 */

package bigmoon.learning.basejava.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 线程优先级
 */
public class ThreadPriority {

   static volatile boolean notStart=true;
   static  volatile boolean notEnd=true;

    public static void main(String[] args) throws Exception{

        List<Job> jobs=new ArrayList<>();

        for (int i=1;i<11;i++){

            int priority=i<5?Thread.MIN_PRIORITY:Thread.MAX_PRIORITY;
            Job job=new Job(priority);
            Thread thread=new Thread(job,"thread-"+i);
            thread.setPriority(priority);
            jobs.add(job);
            thread.start();
        }

        notStart=false;
        TimeUnit.SECONDS.sleep(10);
        notEnd=false;

        for(Job item:jobs){
            System.out.println("job priority:"+item.priority+", jobCount:"+item.jobCount);
        }
    }

    static class Job implements Runnable{

        private int priority;
        private int jobCount;

        public Job(int priority){
            this.priority=priority;
        }

        @Override
        public void run() {

            while (notStart){
                Thread.yield();
            }

            while(notEnd){
                Thread.yield();
                jobCount++;
            }
        }
    }
}
