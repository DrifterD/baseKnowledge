/*
 * Copyright (C), 2002-2017, yhx,All Rights Reserved.
 * FileName: CountTask.java
 * Author:   yhx
 * Date:     19-6-13 上午11:18
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * yhx     19-5-24 下午3:32      版本号        描述
 */

package yhx.learning.basejava.thread.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author yhx
 * @see [相关类/方法]（可选）
 * @since 0528
 */
public class CountTask extends RecursiveTask<Integer> {

    static final int THRESHOLD = 2;

    int start;
    int end;

    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {

        System.out.println("thread:"+Thread.currentThread().getName());
        int sum = 0;

        boolean canCompute = (end - start) <= THRESHOLD;

        if (canCompute) {

            for (int i = start; i <= end; i++) {
                sum += i;
            }

        } else {
            int middle = (start + end) / 2;

            CountTask task1 = new CountTask(start, middle);
            CountTask task2 = new CountTask(middle + 1, end);
            task1.fork();
            task2.fork();
            int result1 = task1.join();
            int result2 = task2.join();
            sum = result1 + result2;
        }

        return sum;
    }

    public static void main(String[] args){

        ForkJoinPool forkJoinPool=new ForkJoinPool();
        CountTask countTask=new CountTask(1,4);
        Future<Integer> result=forkJoinPool.submit(countTask);

        try {
            System.out.println(result.get());

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
