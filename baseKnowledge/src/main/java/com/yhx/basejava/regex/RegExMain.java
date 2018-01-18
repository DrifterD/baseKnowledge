package com.yhx.basejava.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExMain {

    public static void main(String[] args) {

        groupTest();

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
        String regex = "(?<num>\\d+)ab(?<last>11f)+";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher("122ab11fadeba123ab11f");
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


}
