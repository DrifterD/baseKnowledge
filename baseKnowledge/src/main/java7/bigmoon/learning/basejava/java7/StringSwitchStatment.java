/*
 * Copyright (c) 2004- 2019 bigmoon,All Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 * FileName: StringSwitchStatment.java
 * Author:   bigmoon
 * Date:     19-6-13 下午12:02
 * Description: baseKnowledge
 *
 */
package bigmoon.learning.basejava.java7;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * String 字符串可以在switch 语句中使用 再jdk7中
 * 注意： 字符串大小写敏感
 * 
 * jdk7中使用 string switch 比if else if 生成更高效的字节码(bytecode)
 *
 * @author bigmoon
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class StringSwitchStatment {

    /**
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param args
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static void main(String[] args) {
  
        List l=new ArrayList<String>();
        List<String> ls=l;
        
        
        
        switch("c"){
            case "a": System.out.println("a");break;
            case "b": System.out.println("b");break;
            case "c": System.out.println("c");break;
            case "d": System.out.println("d");break;
            case "C": System.out.println("C");break;
            default:System.out.println("null");
        }
        

    }

}
