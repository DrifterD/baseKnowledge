package com.yhx.base.stream;

import com.yhx.base.entity.Dish;

import javax.xml.crypto.Data;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.partitioningBy;

public class PartitionByMain {

    public static void main(String[] args){

        firstPartitionBy();
    }

    static void firstPartitionBy(){

        Map<Boolean, Long> result=DataProvider.getDishList().stream().collect(partitioningBy(Dish::isVegetarian,counting()));

        System.out.println(result);
    }
}
