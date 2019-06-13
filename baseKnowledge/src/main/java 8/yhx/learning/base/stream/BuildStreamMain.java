/*
 * Copyright (C), 2002-2017, yhx,All Rights Reserved.
 * FileName: BuildStreamMain.java
 * Author:   yhx
 * Date:     19-6-13 上午11:18
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * yhx     19-5-23 下午6:17      版本号        描述
 */

package yhx.learning.base.stream;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.stream.Stream;

/**
 * 构建流：可以创建无线流
 */
public class BuildStreamMain {

    public static void main(String[] args){
        iterator();
        generate();
    }

    /**
     * 无效流
     */
    static void iterator(){

        Stream.iterate(0,n->n+2).limit(10).forEach(System.out::println);
    }

    static void generate(){
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }
}
