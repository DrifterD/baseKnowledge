package com.yhx.basejava.String;

public class StringMain {

    public static void main(String[] args){

        //存在 string pool中
        String a="a";
        // 堆上创建一个对象string,值a

        String a1=new String("a");
        //不同对象
        System.out.println("a==a1:"+(a==a1));
        // intern（）方法调用的时候pool中存在相同的a(即a)所以相同
        System.out.println("a1==a1.intern():"+(a==a1.intern()));
    }
}
