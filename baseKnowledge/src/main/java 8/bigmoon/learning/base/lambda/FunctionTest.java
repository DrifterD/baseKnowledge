/*
 * Copyright (C), 2002-2017, bigmoon,All Rights Reserved.
 * FileName: FunctionTest.java
 * Author:   bigmoon
 * Date:     19-6-13 上午11:18
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * bigmoon     19-5-23 下午6:17      版本号        描述
 */

package bigmoon.learning.base.lambda;

import java.util.function.Function;

/**实现 function 接口.
 *
 * 通过 compose, andThen 可以实现组合方法。方法主旨在于方法的层层嵌套对象。实现顺序的调用
  */
public class FunctionTest implements  Function {


    void run(){

        Function<Integer,Integer> funcAppl=(b)->{
            b++;
            System.out.println("apply invoke b="+b);
            return b;
        };

        Function<Integer,Integer> funcComp=(b)->{
            b+=2;
            System.out.println("compose invoke b="+b);
            return b;
        };

        Function<Integer,Integer> funcAndThen=(b)->{
            b+=2;
            System.out.println("andThen invoke b="+b);
            return b;
        };


        System.out.println("compose,andThen:"+funcAppl.compose(funcComp).compose(funcComp).andThen(funcAndThen).apply(1));
       // System.out.println("compose:"+funcAppl.compose(funcComp).apply(123));
    }


    /**
     * Applies this function to the given argument.
     *
     * @param o the function argument
     * @return the function result
     */
    @Override
    public Object apply(Object o) {
        return null;
    }

    /**
     * Returns a composed function that first applies the {@code before}
     * function to its input, and then applies this function to the result.
     * If evaluation of either function throws an exception, it is relayed to
     * the caller of the composed function.
     *
     * @param before the function to apply before this function is applied
     * @return a composed function that first applies the {@code before}
     * function and then applies this function
     * @throws NullPointerException if before is null
     * @see #andThen(Function)
     */
    @Override
    public Function compose(Function before) {
        System.out.println("compose");
        return null;
    }

    /**
     * Returns a composed function that first applies this function to
     * its input, and then applies the {@code after} function to the result.
     * If evaluation of either function throws an exception, it is relayed to
     * the caller of the composed function.
     *
     * @param after the function to apply after this function is applied
     * @return a composed function that first applies this function and then
     * applies the {@code after} function
     * @throws NullPointerException if after is null
     * @see #compose(Function)
     */
    @Override
    public Function andThen(Function after) {
        return null;
    }
}
