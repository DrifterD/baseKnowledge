package bigmoon.learning.basejava.thread.future;

import java.util.concurrent.*;

/**
 * @author bigmoon
 * @date 2020/7/31
 * @return
 * @see [相关类/方法]（可选）
 * @since 200806
 */
public class main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService threadPoolExecutor=Executors.newCachedThreadPool();
        System.out.println("要开始："+System.currentTimeMillis());
        Future future=threadPoolExecutor.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(3000);
                return 100;
            }
        });

        threadPoolExecutor.shutdown();
        System.out.println(future.get()+","+System.currentTimeMillis());
        System.out.println(future.get()+","+System.currentTimeMillis());
        System.out.println(future.get()+","+System.currentTimeMillis());
        System.out.println(future.get()+","+System.currentTimeMillis());
        System.out.println(future.get()+","+System.currentTimeMillis());
        System.out.println(future.get()+","+System.currentTimeMillis());


    }
}
