/*
 * Copyright (C), 2002-2017, yhx,All Rights Reserved.
 * FileName: UpcaseEnum.java
 * Author:   yhx
 * Date:     19-6-13 上午11:18
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * yhx     19-5-23 下午6:17      版本号        描述
 */

package yhx.learning.basejava.enums;

enum Search{HITHRE,YOU  }

/**
 * enum实例向上转型后，就无法获取values方法咯，但是可以
 * 通过class.getEnumConstants方法同样获取枚举类型
 */
public class UpcaseEnum {

    public static void main(String[] args){

        Search[] vals=Search.values();
        //向上转型
        Enum e=Search.HITHRE;

        for(Enum en:e.getClass().getEnumConstants()){
            System.out.println(en);
        }
    }

}
