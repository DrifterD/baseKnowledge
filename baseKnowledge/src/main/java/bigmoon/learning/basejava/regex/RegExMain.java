/*
 * Copyright (C), 2002-2017, bigmoon,All Rights Reserved.
 * FileName: RegExMain.java
 * Author:   bigmoon
 * Date:     19-6-13 上午11:18
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * bigmoon     19-5-23 下午6:17      版本号        描述
 */

package bigmoon.learning.basejava.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type Reg ex main.
 */
public class RegExMain {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        regeGroup();

    }

    private static void regeFind() {

        String regex = "[\u4e00-\u9fa5]";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher("122测(试3)4(王33) fd d都");

        //regin
        matcher.region(3, 14);
        System.out.println(matcher.regionStart());
        System.out.println(matcher.regionEnd());
        System.out.println(matcher.pattern());
        while (matcher.find()) {

            System.out.println("group=" + matcher.group());
            System.out.println("groupCount=" + matcher.groupCount());
            System.out.println(matcher.start());
        }
        System.out.println(matcher.group(1));

    }

    private static void regeGroup() {

        //group 是表达式中() 的组，group(0)全部，下标从1开始
        String regex = "(\\d+)ab(11f)+";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher("122ab11fadeba123af4f11f");
        matcher.find();
        System.out.println(matcher.group("num"));
        System.out.println(matcher.group("last"));
        //替换符合正则的内容
        System.out.println(matcher.replaceAll("110"));
    }

    static void groupTest(){
        String string = "good .very good";
        String regex="(good).*\1";

        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(string);
        System.out.println(matcher.matches());


    }


    //正则组的重复引用
    private static void regGroup2(String input){
        String regex="(good)(.ver).\\1\\2{3}";
        System.out.println(Pattern.compile(regex).matcher(input).matches());

    }


}
