/*
 * Copyright (C), 2002-2017, 苏宁易购电子商务有限公司
 * FileName: DateStreamMain.java
 * Author:   17081794
 * Date:     2017年8月29日 下午3:49:39
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.yhx.basejava.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br>
 * 描述dataStream 用例.
 *  存储指定java类型数据。
 *  注意读取数据时需要按照写入的顺序读取各自数据类型内容
 *
 * @author 17081794
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class DateStreamMain {

    /**
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param args
     * @throws IOException
     * @throws ClassNotFoundException
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        creataeDataFile();
        readDataFile();
    }

    private static void creataeDataFile() {
        DataOutputStream output = null;
        try {
            output = new DataOutputStream(new FileOutputStream("binary.data"));
            output.writeUTF("测试data");
            output.writeInt(4545);
            output.writeDouble(109.123);
            output.flush();
        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {

            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    /// 读取data文件，必须按照存储顺序读取文件
    private static void readDataFile() {
        DataInputStream inputStream = null;

        try {
            inputStream = new DataInputStream(new FileInputStream("binary.data"));
            System.out.println(String.format("arg[0]=%s,arg[1]=%d,arg[2]=%f", inputStream.readUTF(),
                    inputStream.readInt(), inputStream.readDouble()));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (inputStream != null) {

                try {
                    inputStream.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
    


    public static class SimpleObj implements Serializable {

        /**
         */
        private static final long serialVersionUID = 292305906648610490L;
        private String name;
        private int age;

        /**
         * @return the name
         */
        public String getName() {
            return name;
        }

        /**
         * @param name the name to set
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * @return the age
         */
        public int getAge() {
            return age;
        }

        /**
         * @param age the age to set
         */
        public void setAge(int age) {
            this.age = age;
        }

        public SimpleObj() {
        }

        public SimpleObj(String name, int age) {
            this.name = name;
            this.age = age;
        }

        /*
         * (non-Javadoc)
         * @see java.lang.Object#toString()
         */
        @Override
        public String toString() {
            return "SimpleObj [name=" + name + ", age=" + age + "]";
        }
    }

}
