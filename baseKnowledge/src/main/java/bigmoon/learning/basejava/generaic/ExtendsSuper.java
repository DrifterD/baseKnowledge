/*
 * Copyright (c) 2004- 2019 All Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 * FileName: ExtendsSuper.java
 * Author:   bigmoon
 * Date:     19-6-14 上午11:57
 * Description: baseKnowledge
 *
 */

package bigmoon.learning.basejava.generaic;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 测试泛型 extends 和super
 * extends 占位符上限，一个未知的类，父类是xxxx，通常叫子类通配符。但是无法得知具体子类是谁，所以无法使用set操作；  在集合中只能获取(get) 并且类型是 父级类型；
 * 不支持插入操作，集合没有确定具体类型，无法插入
 * super是 占位符下限，一个未知的父类派生类是xxxx。表示占位符是这个具体类型的父类，无法得知具体类型是什么，但是可以保障子类是对的。这样不能使用get操作，无法获取父类，
 * 但是可以使用set操作，因为隐式类型向上转型。
 * 遵循PECS(producer extends, consumer super)规则
 * 数组支持根据类型协变是因为数组本身就是跟语言而来，自然内部设计考虑到
 * @author bigmoon
 * @see [相关类/方法]（可选）
 * @since 0628
 */
public class ExtendsSuper {

    public static void main(String[] args) {

//        List<subInterB> list=new ArrayList<>();
//        list.add(new subInterB(10));
//        list.add(new subInterB(1));
//        testExtendList(list);
//        List<SubInteger> list2=new ArrayList<>();
//        list2.add(new subInterC(10));
//        list2.add(new subInterB(1));
//        testSuperList(list2);
        testArray();

    }


    public static void testExtendList(List<? extends SubInteger> list){

        //以下两行插入度不可以，编译异常。
//        list.add(new subInteger(2)); 父类本身也无法插入，占位符是不能插入数据根据PECS
//        list.add(new subInterB(10)); 具体一个子类也无法插入，占位符是不能插入数据根据PECS
        for(int i=0;i<list.size();i++){
            System.out.println("item class="+list.get(i).getClass()+",value="+list.get(i).printSub());
        }
    }

    public static void testSuperList(List<? super SubInterB> list){

        //插入对象本身是可以成功
        list.add(new SubInterB(10));
        list.add(new subInterC(10));
        //插入父级对象 编译失败  ？？
//        list.add(new subInteger(10));
        for(int i=0;i<list.size();i++){
            System.out.println("item class="+list.get(i).getClass());
        }
    }

    public static void testArray(){

        SubInteger[] subIntegers=new SubInterB[3];
        subIntegers[0]=new subInterC(10);
        subIntegers[1]=new SubInterB(1);
//        subIntegers[2]=new SubInteger(7); //运行时发生异常，java.lang.ArrayStoreException

        for(int i=0;i<subIntegers.length-1;i++){
            System.out.println(subIntegers[i].getClass()+",value:"+subIntegers[i].value);
        }




    }





    //region 类的继承关系
    /*
     supIntergerA、superIntgerB 是subInteger 父级接口、
     subInterB、subInterC是subInter子集
     */

    interface SupIntegerA {

        int printlnA();

    }


    interface SupIntegerB {

        int printlnB();

    }

    static class SubInteger implements SupIntegerA, SupIntegerB {

        int value;

        @Override
        public int printlnB() {
            return 0;
        }

        @Override
        public int printlnA() {
            return 0;
        }

        public SubInteger(int value) {
            this.value = value;
        }

        Integer printSub() {
            System.out.println("这事我传出来·；"+this.value);
            return 0;
        }
    }

    static class SubInterB extends SubInteger {
        @Override
        public int printlnB() {
            return super.printlnB();
        }

        @Override
        public int printlnA() {
            return super.printlnA();
        }

        public SubInterB(int value) {
            super(value);
        }

        @Override
        Integer printSub() {
            return super.printSub();
        }
    }

    static class subInterC extends SubInterB {
        @Override
        public int printlnB() {
            return super.printlnB();
        }

        @Override
        public int printlnA() {
            return super.printlnA();
        }

        public subInterC(int value) {
            super(value);
        }

        @Override
        Integer printSub() {
            return super.printSub();
        }
    }

    //endregion
}
