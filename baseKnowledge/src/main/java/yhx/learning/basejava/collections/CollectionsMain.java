/*
 * Copyright (C), 2002-2017, yhx,All Rights Reserved.
 * FileName: CollectionsMain.java
 * Author:   yhx
 * Date:     19-6-13 上午11:19
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * yhx     19-6-13 上午11:18      版本号        描述
 */

package yhx.learning.basejava.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * The type Collections main.
 */
public class CollectionsMain {

    public static void main(String[] args) {

        synchronizedCollection();
    }

   static class TestClass{
        private String finalStr;

        public String getFinalStr() {
            return finalStr;
        }

        public void setFinalStr(String finalStr) {
            this.finalStr = finalStr;
        }

        public TestClass(String finalStr) {
            this.finalStr = finalStr;
        }
    }


    /**
     * Synchronized collection.
     * 同步集合映射
     */
    static void synchronizedCollection() {

        final TestClass tc=new TestClass("yhx");
        final String finalStr = "yhx";
        final List<Integer> list = new ArrayList<Integer>() {{
            add(2);
            add(1);
        }};

        final List<Integer> list2 = new ArrayList<Integer>() ;
        list2.addAll(list);
        final List<Integer> synchronizedList = Collections.synchronizedList(list);
        tc.setFinalStr("yhx");
        System.out.println(tc.getFinalStr());

        for(int i=0;i<10;i++){

            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {

                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronizedList.add(10);
                    list2.add(10);
                }
            }, "thread"+i);

            t.start();
//            try {
//                t.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (Integer item : list2) {
            System.out.println("list2,"+item);
        }

        for (Integer item : list) {
            System.out.println("list,"+item);
        }
    }

}
