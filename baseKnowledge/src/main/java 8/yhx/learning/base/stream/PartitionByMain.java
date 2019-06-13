/*
 * Copyright (C), 2002-2017, yhx,All Rights Reserved.
 * FileName: PartitionByMain.java
 * Author:   yhx
 * Date:     19-6-13 上午11:18
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * yhx     19-5-23 下午6:17      版本号        描述
 */

package yhx.learning.base.stream;

import yhx.learning.base.entity.Dish;

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
