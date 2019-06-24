/*
 * Copyright (C), 2002-2017, bigmoon,All Rights Reserved.
 * FileName: DeamonThread.java
 * Author:   bigmoon
 * Date:     19-6-13 上午11:18
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * bigmoon     19-5-23 下午6:17      版本号        描述
 */

package bigmoon.learning.basejava.thread;

import java.io.PrintStream;
import java.util.concurrent.TimeUnit;

public class DeamonThread  {

    public static void main(String[] args)throws Exception{

        System.out.println("start");
        Thread thread=new Thread(new Runnable() {

            @Override
            public void run()  {
                try {
                    System.out.println("thread start run");
                    TimeUnit.SECONDS.sleep(2);
                }catch (Exception ex){
                    ex.printStackTrace();
                }finally {
                    System.out.println("thread finally");
                }
            }
        });
//        thread.setDaemon(true);
        thread.start();
        TimeUnit.SECONDS.sleep(2);
        System.out.println("over");
    }
}
