/*
 * Copyright (C), 2002-2017, bigmoon,All Rights Reserved.
 * FileName: Reflection.java
 * Author:   bigmoon
 * Date:     19-6-13 上午11:18
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * bigmoon     19-5-23 下午6:17      版本号        描述
 */

package bigmoon.learning.basejava.enums;

import bigmoon.learning.basejava.base.BaseUtil;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;

enum Explore{HEAR,THERE}

/**
 *  通过实际反射对比，values和valueOf(String) 方法是通过编译器添加的
 *  static 方法
 *
 */
public class Reflection extends BaseUtil {

    public static Set<String> analyze(Class<?> enumClass){
        System.out.println("-----Anaylzing"+enumClass+"--------");

        System.out.println("getGenericInterfaces:");
        for(Type type:enumClass.getGenericInterfaces())
            print(type);

        System.out.println("interfaces");

        for(Class cla:enumClass.getInterfaces())
            print(cla);

        System.out.println("base:"+enumClass.getSuperclass());
        Set<String> methods=new TreeSet<>();

        for(Method method:enumClass.getMethods())
            methods.add(method.getName());

        println("methods; "+methods);
        return methods;
    }

    public static void main(String[] args){
       Set<String> methods= analyze(Explore.class);
       Set<String> enumMethod=analyze(Enum.class);
       println("Explore.containsAll(enum)?"+methods.containsAll(enumMethod));
       System.out.println("Explore.removeAll(Enum)");
       methods.removeAll(enumMethod);
       print("after removeAll:"+methods);
      // OSExecute.command("javap Explore");
    }

}
