package bigmoon.learning.base.complatableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static java.util.Optional.ofNullable;

/**
 * 该类主要学习CompletableFuture 使用

 * @author bigmoon
 * @date 2021/4/17
 * @return
 * @see [相关类/方法]（可选）
 * @since
 */
public class Main {
    public static void main(String[] args) throws InterruptedException,ExecutionException {

        multiTaskCombine();
        Thread.sleep(10000);
    }

    static void taskCompletionStage() throws ExecutionException, InterruptedException {

        CompletableFuture completableFuture=CompletableFuture.runAsync(()->{
            System.out.println("current thread name:"+Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // accept  有入参无返回值
        completableFuture.thenAccept(result->{
            System.out.println("[thenAccept] current thread name:"+Thread.currentThread().getName());
            System.out.println("accept the reuslt "+result);
        });

        completableFuture.thenAcceptAsync(result->{
            System.out.println("[thenAcceptAsync] current thread name:"+Thread.currentThread().getName());
            System.out.println("accept the reuslt "+result);
        });

        //有入参有返回值
        completableFuture.thenApply(result->{
            System.out.println("[thenApply] current thread name:"+Thread.currentThread().getName());
            System.out.println("accept the reuslt "+result);
            return 100;
        }).whenComplete((result,ex)->{
            System.out.println("[thenApply] the new result="+result);
        });
    }

    static void multiTaskCombine(){
        CompletableFuture completableFuture=CompletableFuture.runAsync(()->{
            System.out.println("[task1]current thread name:"+Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        CompletableFuture completableFuture3=completableFuture.thenRunAsync(()->{
            System.out.println("[task3]current thread name:"+Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        CompletableFuture completableFuture2=CompletableFuture.supplyAsync(()->{
            System.out.println("[task2]current thread name:"+Thread.currentThread().getName());
            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 100;
        });

        CompletableFuture.allOf(completableFuture2,completableFuture).whenComplete((result,result2)->{
            System.out.println("all of the task has done");
            System.out.println("[allOf] the current thread name:"+Thread.currentThread().getName());
            System.out.println("the result ="+result);
            System.out.println("the result2 ="+result2);
        });

        completableFuture.thenCombine(completableFuture2,(result,result2)->{
            System.out.println("[thenCominbe] the current thread name:"+Thread.currentThread().getName());
            System.out.println("the result ="+result);
            System.out.println("the result2 ="+result2);
            return "over";
        }).whenComplete((result,ex)->{
            System.out.println("[whenComplete] the current thread name:"+Thread.currentThread().getName());
            System.out.println("the result ="+result);
        });
    }

    /**
     * 无参返回的任务中 get结果是null,isDone是true。
     * @author bigmoon
     * @params []
     * @return void
     * @see [相关类/方法]（可选）
     * @since
     */
    static void runAsync() throws ExecutionException, InterruptedException {
        CompletableFuture completableFuture=CompletableFuture.runAsync(()->{
            System.out.println("start the task");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("void result="+completableFuture.get()+", the task isDone="+completableFuture.isDone());
    }

    static CompletableFuture mulithandle(){

        CompletableFuture<Double> completableFuture= CompletableFuture.supplyAsync(()->{
            System.out.println("run this thread"+Thread.currentThread().getName());
            return Main.fetchPrice();
        });


        //异常处理
        completableFuture.exceptionally((exception)->{
            System.out.println("the exceptionally");
            ofNullable(exception).ifPresent(value->{
                System.out.println("the exception has en error："+exception.getMessage());
            });
            return Double.valueOf(100d);
        });

        //正常处理
        completableFuture.thenAccept(result->{
            System.out.println("then accept result="+result);
            ofNullable(result).ifPresent(value->{
                System.out.println("the result not null");
            });
        });

        return completableFuture;
    }

    /**
     * 自定义设定CompletableFuture结果内容
     *
     * @author bigmoon
     * @params []
     * @return void
     * @see [相关类/方法]（可选）
     * @since
     */
    static void setCompletableFutureResult(){
        //方法一
//        CompletableFuture<String> completableFuture=CompletableFuture.completedFuture("测试");
        //region 方法二
        CompletableFuture<String> completableFuture=new CompletableFuture<>();
        completableFuture.complete("测试");
        //endregion
        completableFuture.whenComplete((value,ex)->{
            System.out.println("the result value="+value);
            ofNullable(ex).ifPresent(subEx->{
                System.out.println("has exception,"+subEx.getMessage());
            });
        });
    }

    /**
     *  supplyAsync 贷后返回值的任务 方法使用
     * @author bigmoon
     * @params []
     * @return void
     * @see [相关类/方法]（可选）
     * @since
     */
    static void supplyAsync(){
        CompletableFuture completableFuture= CompletableFuture.supplyAsync(()->{
            System.out.println("run this thread"+Thread.currentThread().getName());
            return Main.fetchPrice();
        }).whenComplete((result,exception)->{

            ofNullable(result).ifPresent(newResult-> System.out.println("the result:"+result));

            if(null!=exception){
                System.out.println("the error msg："+exception.getMessage());
            }
            System.out.println("complete is done");

        });

        Object futureResult=completableFuture.join();
        System.out.println("the painter has only result:"+futureResult);
    }

    static Double fetchPrice() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        if (Math.random() < 0.3) {
            throw new RuntimeException("fetch price failed!");
        }
        return 5 + Math.random() * 20;
    }
}
