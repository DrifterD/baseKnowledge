/*
 * Copyright (C), 2002-2017, yhx,All Rights Reserved.
 * FileName: DateStreamMain.java
 * Author:   yhx
 * Date:     19-6-13 上午11:18
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * yhx     19-5-23 下午6:17      版本号        描述
 */
package yhx.learning.basejava.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br>
 * 描述dataStream 用例.
 *  存储指定java类型数据。
 *  注意读取数据时需要按照写入的顺序读取各自数据类型内容
 *
 * @author yhx
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
        
        //new school style. try with reources 
        // see #TryResourceMain
        try(DataOutputStream output2 = new DataOutputStream(new FileOutputStream("binary.data"))){           
            output2.writeUTF("测试data");
            output2.writeInt(4545);
            output2.writeDouble(109.123);
            output2.flush();
        }catch(Exception ex){
            ex.printStackTrace();
        }        
        
    }

    /// 读取data文件，必须按照存储顺序读取文件
    private static void readDataFile() {
        
        try(DataInputStream inputStream  = new DataInputStream(new FileInputStream("binary.data"))){
            System.out.println(String.format("arg[0]=%s,arg[1]=%d,arg[2]=%f", inputStream.readUTF(),
                    inputStream.readInt(), inputStream.readDouble()));
        }catch(IOException ex){
            ex.printStackTrace();
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
