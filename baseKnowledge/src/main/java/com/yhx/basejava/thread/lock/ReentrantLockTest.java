package com.yhx.basejava.thread.lock;

import com.yhx.basejava.refection.Main;

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
