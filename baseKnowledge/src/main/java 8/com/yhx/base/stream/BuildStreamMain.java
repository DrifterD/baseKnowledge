package com.yhx.base.stream;

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
