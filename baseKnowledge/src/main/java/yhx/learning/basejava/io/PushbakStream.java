/*
 * Copyright (C), 2002-2017, yhx,All Rights Reserved.
 * FileName: PushbakStream.java
 * Author:   yhx
 * Date:     19-6-13 上午11:18
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * yhx     19-5-23 下午6:17      版本号        描述
 */
package yhx.learning.basejava.io;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PushbackInputStream;

/**
 * 〈一句话功能简述〉<br>
 * pushbakInputStream,pushbakOutputStream 示例
 * 
 * pushbakstream 为另一个输入流添加，即“推回 (push back)”或“取消读取 (unread)”一个字节的能力。
 * 在代码片段可以很方便地读取由特定字节值分隔的不定数量的数据字节时，这很有用；在读取终止字节后，代码片段可以“取消读取”该字节， 这样，输入流上的下一个读取操作将会重新读取被推回的字节。
 *
 * @author yhx
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class PushbakStream {

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
        pushbackInputStream();
    }

    public static void pushbackInputStream() {

        String demoStr = "12345678";

        try (PushbackInputStream pushbackInputStream = new PushbackInputStream(
                new ByteArrayInputStream(demoStr.getBytes(), 0, demoStr.getBytes().length))) {

            // byte[] cache=new byte[128];
            int length = -1;
            while ((length = pushbackInputStream.read()) != -1) {

                if ((char) length == '8' || (char) length == '2') {
                    // //unread操作，被读取的文件又放回缓存中，这个时候再skip(1),就是跳过当前读取这个字节
                    // pushbackInputStream.unread(length);
                    // pushbackInputStream.skip(1);
                    // continue;

                    // method 2
                    // 如果不unread，那么字节默认被读出，如果再skip(1);那就是跳了两个
                    continue;
                }

                System.out.println((char) length);
            }
        } catch (IOException e) {           
            e.printStackTrace();
        }
    }

    // pushback 没有outputStream ,只有inputStream
    public static void pushbackOutputStream() {

    }
}
