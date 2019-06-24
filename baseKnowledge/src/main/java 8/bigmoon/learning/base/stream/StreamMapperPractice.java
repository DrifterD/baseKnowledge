/*
 * Copyright (C), 2002-2017, bigmoon,All Rights Reserved.
 * FileName: StreamMapperPractice.java
 * Author:   bigmoon
 * Date:     19-6-13 上午11:18
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * bigmoon     19-5-23 下午6:17      版本号        描述
 */

package bigmoon.learning.base.stream;

import com.google.common.collect.Lists;

import java.util.*;

import static java.util.stream.Collectors.toList;


/**
 * Stream map和flatMap
 */
public class StreamMapperPractice {

    public static void main(String[] args) {
        mapSortStream();
        pro1();
        mapDiffFlatMap();
    }

    /**
     * 返回一个数据列表的平方结果
     * 例如：[1,2,3,4,5]
     */
    static void pro1() {

        Integer[] numbers = new Integer[]{1, 2, 3, 4, 5};
        Arrays.stream(numbers).map(n -> n * n).forEach(System.out::println);
    }

    /**
     * 给两个数字列表，如何计算所有数据对数
     * [1,2,3],[3,4]
     * 返回：
     * 1,3；1,4；2,3;2,4;3,3;3,4;
     */
    static void pro2() {

        Arrays.stream(new Integer[]{1, 2, 3}).flatMap(item -> Arrays.stream(new Integer[]{3, 4}).
                map(subItem -> new Integer[]{item, subItem})).forEach(System.out::println);
    }

    static void mapMaxStream() {
        Map<String, Integer> maps = new HashMap<>();
        maps.put("001", 4);
        maps.put("002", 42);
        maps.put("003", 10);

        Optional<Integer> result = maps.entrySet().stream().map(item ->
                item.getValue()
        ).max((t1, t2) ->
                t1.equals(t2) ? 0 : t1 > t2 ? 1 : -1
        );

        System.out.println(!result.isPresent() ? null : result.get());
    }

    static void mapSortStream() {
        Map<String, Integer> maps = new HashMap<>();
        maps.put("001", 4);
        maps.put("002", 42);
        maps.put("003", 10);

        List<Integer> result = maps.entrySet().stream().map(item ->
                item.getValue()
        ).sorted().collect(toList());

        result.forEach(item->System.out.println(item));
    }


    static void mapDiffFlatMap(){

        List<String> helloWorld= Lists.newArrayList("Hello","world");
        helloWorld.stream().map(item->item.split("")).
        flatMap(Arrays::stream).collect(toList()).
                forEach(System.out::println);


    }

}
