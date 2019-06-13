/*
 * Copyright (c) 2004- 2019 yhx,All Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 * FileName: MutilThrowException.java
 * Author:   yhx
 * Date:     19-6-13 下午12:02
 * Description: baseKnowledge
 *
 */
package yhx.learning.basejava.java7;

/**
 * 〈一句话功能简述〉<br>
 * 主要描述jdk7中1.catch 捕获 多个不同的异常；2.支持重新抛出异常处理再throws中
 * 
 *
 * @author yhx
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class MutilThrowException {

    
    static class BaseException extends Exception {
    }
    
    
    static class FirstException extends BaseException {
    }

    static class SecondException extends BaseException {
    }

    /**
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param args
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    private static void catchMultiException(int flag) {

        // prior jdk version
        try {
            // dosomething

            if (flag == 1) {
                throw new FirstException();
            } else {
                throw new SecondException();
            }

            // 多个异常只能有多个catch块来处理
        } catch (FirstException ex) {

        } catch (SecondException ex2) {

        }
    }

    // jdk7 中catch 支持捕获多个异常 使用 | 符号分割异常类型，异常变量使用final定义。编译成字节码比 prior 更见少，性能更佳
    private static void catchMultiException2(int flag) {

        try {
            // dosomething

            if (flag == 1) {
                throw new FirstException();
            } else {
                throw new SecondException();
            }

            // jdk 7 中可以通过一下方式捕获多个异常
        } catch (FirstException | SecondException ex) {

        }
    }

    //jdk7 之前版本只能在throws 子句中添加超类(父类)，无法指定firstException,secondException
    private static void retrhowException(int flag) throws Exception{

        if (flag == 1) {
            throw new FirstException();
        } else{
            throw new SecondException();
        }
    }
    
    //jdk7中可以支持throws 子句中定义多个异常
    private static void retrhowException2(int flag) throws FirstException,SecondException {

        if (flag == 1) {
            throw new FirstException();
        } else {
            throw new SecondException();
        }
    }

}
