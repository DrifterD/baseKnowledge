/*
 * Copyright (C), 2002-2017, bigmoon,All Rights Reserved.
 * FileName: PromoteLambda.java
 * Author:   bigmoon
 * Date:     19-6-13 上午11:18
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * bigmoon     19-5-23 下午6:17      版本号        描述
 */

package bigmoon.learning.base.lambda;

import java.util.function.Consumer;

/**
 * 主要提升使用Lambda代码质量以及注意事项
 */
public class PromoteLambda {

    private int code=12;
    private String name="lambda";

    public static void main(String[] args)throws Exception{

        PromoteLambda promoteLambda = new PromoteLambda();
        promoteLambda.anonymousClassThis();
        Thread.currentThread().join();
        System.out.println("over");
    }

    /**
     * 匿名类和lambda区别：
     * 1.this和super定义不同
     * 2.局部变量是否和包含类冲突
     */
    public static void lambdaAndAnonymousClassVariable(){

        int a=2;
        Runnable runnable=()->{
//          int a=100;  编译错误，和上面变量冲突
        };

        Runnable runnable1Annoymous=new Runnable() {
            @Override
            public void run() {
                int a=2;
                System.out.println("a="+a);
            }
        };
    }

    public void lambdaThis(){

        Consumer<String> consumer=(str)->{
            System.out.println(str+":"+this);
        };
        consumer.accept("测试Lambda中this含义");
    }

    public void anonymousClassThis(){

       Runnable runnable=new Runnable() {
           private int code;
           private String name;

//           @Override
//           public String toString(){
//               return this.code+","+this.name;
//           }

           @Override
           public void run() {

               try {
                   Thread.sleep(1000);
               }catch (Exception ex){
                   ex.printStackTrace();
               }

               this.name="abc";
               this.code=123;
               System.out.println(this);
           }
       };

       Thread thread=new Thread(runnable);
       thread.start();
    }
}
