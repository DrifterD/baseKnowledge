/*
 * Copyright (C), 2002-2017, bigmoon,All Rights Reserved.
 * FileName: CreateStream.java
 * Author:   bigmoon
 * Date:     19-6-13 上午11:19
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * bigmoon     19-6-13 上午11:18      版本号        描述
 */

package bigmoon.learning.base.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * 创建stream 多个方法实现
 * 1.通过集合转换成流stream。通过Collection stream API实现集合自身流转换
 * 2.通过数组方式实现Arrays.Stream API实现;Stream.of API实际上调用Arrays.Stream
 * 3.
 *
 */
public class CreateStream {

    public static void main(String[] args) {
        CreateStream cs=new CreateStream();
        cs.collection2Stream();
        cs.Array2Stream();
    }

    //collection
    void collection2Stream(){

        Collection<String> collection=new ArrayList<String>(){
            {
                add("abc");
                add("abc2");
                add("abc3");
            }
        };

        //Mehtod 1
        Stream<String> stream1=collection.parallelStream();
        //method 2
        Stream<String> stream2=collection.stream();
        System.out.println("count:"+stream1.filter(i->i!=null&&!"abc".equals(i)).count());
        System.out.println("count:"+stream2.filter(i->i!=null&&!"abc".equals(i)).count());
        
        collection.forEach(i->System.out.println("original i="+i));
        
    }

    /**
     * Array 2 stream.
     */
    void Array2Stream(){
        Integer[] ints=new Integer[]{1,2,4,2424,42,42,4,343,4};
        Stream<Integer> stream=Arrays.stream(ints);
        Stream.of(ints);
        System.out.println(stream.filter(i->i>3).anyMatch(i->i%2==0));
    }
}
