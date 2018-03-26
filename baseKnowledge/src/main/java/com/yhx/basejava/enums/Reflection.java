package com.yhx.basejava.enums;

import com.yhx.basejava.base.BaseUtil;
import com.yhx.basejava.thread.semaphore.SemaphoreTest;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ThreadPoolExecutor;

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
