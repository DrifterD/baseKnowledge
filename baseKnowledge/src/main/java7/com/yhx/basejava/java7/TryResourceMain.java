/*
 * Copyright (C), 2002-2017, 苏宁易购电子商务有限公司
 * FileName: TryResourceMain.java
 * Author:   17081794
 * Date:     2017年8月30日 上午10:58:47
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.yhx.basejava.java7;

import java.io.Closeable;
import java.io.IOException;

/**
 * 该java7包下主要学习java7新特性
 * 〈一句话功能简述〉<br>
 * jdk7 中新增加 try with resource 功能。即可以自动管理资源关闭功能。但是必须继承autoCloseable
 *   这里主要证明： try(....) 中不限制定义变量。但是自动关闭时必须按照顺序，这个顺序是按照try()中定义顺序的倒叙实现关闭的。
 *  
 * @author 17081794
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class TryResourceMain {

    /**
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param args
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static void main(String[] args) {

        System.out.println("start");
        try (testResource1 t1 = new testResource1();
                testResource2 t2 = new testResource2();
                testResource3 t3 = new testResource3();) {

        } catch (Exception ex) {

            ex.printStackTrace();
        } finally {
            System.out.println("over");
        }

    }

    public static class testResource1 implements Closeable {

        public void close() throws IOException {

            System.out.println("resource1 has closed");

        }
    }

    public static class testResource2 implements Closeable {

        public void close() throws IOException {

            System.out.println("resource2 has closed");

        }
    }

    public static class testResource3 implements Closeable {

        public void close() throws IOException {

            System.out.println("resource3 has closed");

        }
    }
}
