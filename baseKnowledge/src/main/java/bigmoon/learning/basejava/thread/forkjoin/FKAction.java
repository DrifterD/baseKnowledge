package bigmoon.learning.basejava.thread.forkjoin;


import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

import static com.google.common.collect.Iterables.partition;

public class FKAction extends RecursiveAction {

    private List<String> data;
    private List<ForkJoinTask>  forkJoinTasks=new ArrayList<>();

    public  FKAction(List<String> data){
        this.data=data;
    }

    @Override
    protected void compute() {

        if(null==this.data||this.data.isEmpty()){
            System.out.println(Thread.currentThread().getName()+"没有数据");
            return;
        }

        if(this.data.size()>2){
            List<List<String>> listPart= Lists.partition(this.data,2);

            for(List<String> item:listPart){
                ForkJoinTask forkJoinTask=new FKAction(item).fork();
                forkJoinTask.fork();
                forkJoinTasks.add(forkJoinTask);

//                new FKAction(item).fork();
            }
        }else{
            //自行处理
            for(String item:this.data){
                System.out.println(Thread.currentThread().getName()+"内容:"+item);
            }
        }

        for(ForkJoinTask forkJoinTask:this.forkJoinTasks){
            forkJoinTask.join();
        }

    }

    public static void main(String[] args)throws Exception {

        ForkJoinPool forkJoinPool=new ForkJoinPool();

        List<String> data=new ArrayList();
        for(int i=0;i<20;i++){
            data.add("str"+i);
        }
        ForkJoinTask result=forkJoinPool.submit(new FKAction(data));
        System.out.println(result.get());
        System.out.println(Thread.currentThread().getName()+" 不知道有没有完成");
    }
}
