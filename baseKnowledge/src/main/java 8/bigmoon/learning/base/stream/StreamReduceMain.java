/*
 * Copyright (C), 2002-2017, bigmoon,All Rights Reserved.
 * FileName: StreamReduceMain.java
 * Author:   bigmoon
 * Date:     19-6-13 上午11:18
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * bigmoon     19-5-23 下午6:17      版本号        描述
 */

package bigmoon.learning.base.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

/**
 * Steam 的reduce 使用
 */
public class StreamReduceMain {

    public static void main(String[] args) {
        sumItem2();
        sumItem();
        countByReduce();
//        intStreamRangeClosed();
    }

    /**
     * reduce 两个参数，则返回第一个参数类型结果
     */
    static void sumItem() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Integer sumResult = list.stream().reduce(0, (a, b) -> a + b);
        System.out.println("sum=" + sumResult);
    }

    /**
     *  reduce 一个参数：返回Optional 类型
     */
    static void sumItem2() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> sumResult = list.stream().reduce((a, b) -> a + b);
        sumResult.ifPresent(System.out::println);
    }

    static void countByReduce(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Integer sumResult = list.stream().reduce(0,(a, b) ->{
            System.out.println("a="+a+",b="+b);
            return a+1;
        });
        System.out.println("count=" + sumResult);
    }

    static void intStreamRange(){
        IntStream.range(1,10).forEach(System.out::println);
    }

//    static void intStreamRangeClosed()



}
