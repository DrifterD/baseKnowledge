/*
 * Copyright (C), 2002-2017, yhx,All Rights Reserved.
 * FileName: GroupingByMain.java
 * Author:   yhx
 * Date:     19-6-13 上午11:19
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * yhx     19-6-13 上午11:18      版本号        描述
 */

package yhx.learning.base.stream;

import yhx.learning.base.entity.Dish;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;

import static java.util.stream.Collectors.*;

/**
 * 主要讲解 collector中分组功能
 */
public class GroupingByMain {

    public static void main(String[] args) {
//        firstGroupingBy();
        secondGrouingBy();
//        thridGroupingBy();
//        forthGroupingBy();
//        fifthGroupingBy();
    }

    static void firstGroupingBy() {
        Map<Dish.Type, List<Dish>> result = DataProvider.getDishList().stream().collect(groupingBy(Dish::getType));
        System.out.println(result);
    }

    static void secondGrouingBy() {
        Map<Dish.CaloricLevel, List<Dish>> result = DataProvider.getDishList().stream().collect(groupingBy(
                dish -> {
                    if (dish.getCalories() <= 400) return Dish.CaloricLevel.DIET;
                    else if (dish.getCalories() <= 700) return Dish.CaloricLevel.NORMAL;
                    else return Dish.CaloricLevel.FAT;
                }
        ));
        System.out.println(result);
    }

    /**
     * 嵌套分组
     */
    static void thridGroupingBy() {

        //groupingBy 第二个参数是Collector类型，不一定必须是groupingBy,可以是任何实现collector的内容
        Collector<Dish, ?, Map<Dish.CaloricLevel, List<Dish>>> classifier = groupingBy(dish -> {
            if (dish.getCalories() <= 400) return Dish.CaloricLevel.DIET;
            else if (dish.getCalories() <= 700) return Dish.CaloricLevel.NORMAL;
            else return Dish.CaloricLevel.FAT;
        });

        Map<Dish.Type, Map<Dish.CaloricLevel, List<Dish>>> result = DataProvider.getDishList().stream().collect(
                groupingBy(Dish::getType, classifier));

        Map<Dish.Type, Long> result2 = DataProvider.getDishList().stream().collect(
                groupingBy(Dish::getType, counting()));
        System.out.println(result);
        System.out.println(result2);
    }

    /**
     * 按子组收集数据
     */
    static void forthGroupingBy() {

        Map<Dish.Type, Optional<Dish>> result = DataProvider.getDishList().stream().collect(groupingBy(Dish::getType,
                maxBy(Comparator.comparingInt(Dish::getCalories))));

        System.out.println(result);

        //将收集器结果类型转换成另一个类型

        Map<Dish.Type, String> result2 = DataProvider.getDishList().stream().collect(groupingBy(Dish::getType,
                collectingAndThen(maxBy(Comparator.comparingInt(Dish::getCalories)), optiong -> {
                    return optiong.get().getName();
                })
        ));

        System.out.println("类型转换后的内容：" + result2);

    }

    static void fifthGroupingBy() {
        Map<Dish.Type, List<Dish.CaloricLevel>> result = DataProvider.getDishList().stream().collect(groupingBy(Dish::getType,
                mapping(dish -> {
            if (dish.getCalories() <= 400) return Dish.CaloricLevel.DIET;
            else if (dish.getCalories() <= 700) return Dish.CaloricLevel.NORMAL;
            else return Dish.CaloricLevel.FAT;
        }, toList())));

        System.out.println(result);
    }

}
