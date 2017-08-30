/*
 * Copyright (C), 2002-2017, 苏宁易购电子商务有限公司
 * FileName: StringSwitchStatment.java
 * Author:   17081794
 * Date:     2017年8月30日 上午11:55:44
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.yhx.basejava.java7;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * String 字符串可以在switch 语句中使用 再jdk7中
 * 注意： 字符串大小写敏感
 * 
 * jdk7中使用 string switch 比if else if 生成更高效的字节码(bytecode)
 *
 * @author 17081794
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
