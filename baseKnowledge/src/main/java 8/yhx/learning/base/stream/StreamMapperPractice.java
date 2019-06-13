/*
 * Copyright (C), 2002-2017, yhx,All Rights Reserved.
 * FileName: StreamMapperPractice.java
 * Author:   yhx
 * Date:     19-6-13 上午11:18
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * yhx     19-5-23 下午6:17      版本号        描述
 */

package yhx.learning.base.stream;

import com.sun.org.apache.xerces.internal.xs.ItemPSVI;
import javafx.beans.property.IntegerProperty;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class StreamMapperPractice {

    public static void main(String[] args){
        pro2();
    }

    /**
     * 返回一个数据列表的平方结果
     * 例如：[1,2,3,4,5]
     */
    static void pro1(){

        Integer[] numbers=new Integer[]{1,2,3,4,5};
        Arrays.stream(numbers).map(n->n*n).forEach(System.out::println);
    }

    /**
     * 给两个数字列表，如何犯规所有数据对数
     * [1,2,3],[3,4]
     * 返回：
     * 1,3；1,4；2,3;2,4;3,3;3,4;
     */
    static void pro2(){

      Arrays.stream(new Integer[]{1,2,3}).flatMap(item->Arrays.stream(new Integer[]{3,4}).
                map(subItem->new Integer[]{item,subItem})).forEach(System.out::println);
    }
}