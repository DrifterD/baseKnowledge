package com.yhx.base.stream;

import com.yhx.base.entity.Dish;

import java.awt.event.ItemEvent;
import java.util.Arrays;
import java.util.List;

/**
 * Steam 的reduce 使用
 */
public class StreamReduceMain {

    public static void main(String[] args) {
        firstReduce();
    }

    public static void firstReduce() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
//        Integer result = list.stream().reduce(0, (a, b) -> a + b);
        //由于JDK1.8 之后在Integer中加入SUM方法，可以简化如下
        Integer result = list.stream().reduce(0, Integer::sum);
        System.out.println("reduce="+result);
    }
}
