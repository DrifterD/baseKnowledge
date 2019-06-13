/*
 * Copyright (C), 2002-2017, yhx,All Rights Reserved.
 * FileName: CollectorMain.java
 * Author:   yhx
 * Date:     19-6-13 上午11:19
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * yhx     19-6-13 上午11:18      版本号        描述
 */

package yhx.learning.base.stream;

import yhx.learning.base.entity.Dish;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.summingInt;

/**
 * 流中收集器
 */
public class CollectorMain {

    public static void main(String[] args){

        List<Dish> menu= Arrays.asList(
                new Dish("pork",false,800, Dish.Type.MEAT),
                new Dish("beef",false,700, Dish.Type.MEAT),
                new Dish("chicken",false,400, Dish.Type.MEAT),
                new Dish("french",true,530, Dish.Type.OTHER),
                new Dish("rice",true,350, Dish.Type.OTHER),
                new Dish("season fruit",true,120, Dish.Type.OTHER),
                new Dish("pizza",true,550, Dish.Type.MEAT),
                new Dish("parwns",true,300, Dish.Type.FISH),
                new Dish("salmon",true,1450, Dish.Type.FISH)
        );
        maxOrMin(menu);
        sum(menu);
        summaryStatistic(menu);
        joining(menu);
    }

    //对流归约
    public void count(List<Dish> dishLists){

        dishLists.stream().collect(counting());
        dishLists.stream().count();
    }

    public static void maxOrMin(List<Dish> dishList){
//        Optional<Dish> result= dishList.stream().collect(maxBy(Comparator.comparingInt(Dish::getCalories)));
        Optional<Dish> result=dishList.stream().collect(maxBy((item1,item2)->Integer.compare(item1.getCalories(),item2.getCalories())));
        result.ifPresent(System.out::println);
    }

    public static void sum(List<Dish> dishList){
        //第一种方法
//        Integer sum=dishList.stream().collect(summingInt(Dish::getCalories));

        //第二种方法
        Integer sum=dishList.stream().collect(summingInt(dish->dish.getCalories()));
        System.out.println("sum="+sum);
    }

    public static void summaryStatistic(List<Dish> dishList){

        IntSummaryStatistics result= dishList.stream().collect(Collectors.summarizingInt(Dish::getCalories));
        System.out.println("IntSummaryStatistics="+result);
    }

    public static void joining(List<Dish> dishList){

        String allName=dishList.stream().map(dish->dish.getName()).collect(Collectors.joining("-"));
        System.out.println(allName);

    }
}
