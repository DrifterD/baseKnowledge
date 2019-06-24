/*
 * Copyright (C), 2002-2017, bigmoon,All Rights Reserved.
 * FileName: DishMain.java
 * Author:   bigmoon
 * Date:     19-6-13 上午11:18
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * bigmoon     19-5-23 下午6:17      版本号        描述
 */

package bigmoon.learning.base.stream;

import bigmoon.learning.base.entity.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * 围绕菜谱为案例，展开stream相关使用
 */
public class DishMain {

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
                new Dish("salmon",true,450, Dish.Type.FISH)
        );

//        firstStream(menu);
//        distincStream();
//        firstSkp(menu);
        secondFlatMap();
//        reduce(menu);
    }

    /**
     *
     * @param menu
     */
    public static void firstStream(List<Dish> menu){
        List<String> newMenu=menu.stream().filter(d->{System.out.println("filter dish="+d);return d.getCalories()>300;}).map(d->{
            System.out.println("map dish="+d); return d.getName();}).limit(3).collect(toList());
        System.out.println(newMenu);
    }

    static void firstSkp(List<Dish> menu){
        menu.stream().filter(i->{System.out.println("filter i="+i);return i.getCalories()>300;}).
                skip(2).forEach(System.out::println);
    }

    /**
     * stream 尝试distinct
     */
    public static void distincStream(){
        List<Integer> numbers=Arrays.asList(1,2,34,55,3,5,2,4,6);
//        numbers.stream().filter(i ->i%2==0 ).distinct().forEach(item->System.out.println(item));
        //Lambda方法引用写法
        numbers.stream().filter(i->i%2==0).distinct().forEach(System.out::println);
    }

    static void firstMap(List<Dish> menu){
        menu.stream().map(Dish::getName).map(String::length).forEach(System.out::println);
    }
    static void secondMap(){
        List<String> words=Arrays.asList("hello","world");
       words.stream().map((item)->item.split("")).distinct().forEach(ite-> System.out.println(Arrays.toString(ite)));
    }

    static void firstFlatMap(){

        List<String> words=Arrays.asList("hello","world");
        words.stream().map(item->item.split("")).flatMap(item->Arrays.stream(item)).
                distinct().forEach(item->System.out.println(item));
    }

    static void secondFlatMap(){

        List<Integer[]> words= Arrays.asList(new Integer[]{1,2,3},new Integer[]{4,5,6});
        words.stream().flatMap(item->Arrays.stream(item)).
               forEach(item->System.out.println(item));
    }

    /**
     * @author 17081794
     * @param null
     * @return 
     * @see [相关类/方法]（可选）
     * @since 0628
     */
    static void firstAllMatch(List<Dish> dishes){
        System.out.println("allMatch="+dishes.stream().allMatch(item->item.getCalories()>1000));
    }
    static void firstNonMatch(List<Dish> dishes){
        System.out.println("nonMatch="+dishes.stream().noneMatch(item->item.getCalories()<1000));
    }


    static void reduce(List<Dish> dishes){

        System.out.println("size="+dishes.size());
        System.out.println("stream count="+dishes.stream().count());
        Optional<Integer> result=dishes.stream().map(item->1).reduce(Integer::sum);
        System.out.println("-----------------------old method--------------");

        if(result.isPresent()){
            System.out.println("result="+result.get());
        }

        System.out.println("-----------------------new method--------------");

        result.ifPresent(System.out::println);

        Long reuslt2=dishes.stream().collect(Collectors.counting());
        System.out.println(reuslt2);
    }
}
