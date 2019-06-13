/*
 * Copyright (C), 2002-2017, yhx,All Rights Reserved.
 * FileName: ReentrantLockTest.java
 * Author:   yhx
 * Date:     19-6-13 上午11:18
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * yhx     19-5-23 下午6:17      版本号        描述
 */

package yhx.learning.basejava.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

    static Integer count=0;

    public static void main(String[] args) throws Exception {
        Lock lock = new ReentrantLock();

        Thread t1 = new Thread(new CountJob(lock));
        Thread t2 = new Thread(new CountJob(lock));
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count);
    }

    static class CountJob implements Runnable {

        Lock lock;

        public CountJob(Lock lock) {
            this.lock = lock;
        }

        @Override
        public void run() {

            lock.lock();

            try {
                for (int j = 0; j < 1000000; j++) {
                    count++;
                }
                System.out.println("thread: " + Thread.currentThread().getName() + ",count=" + count);
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
