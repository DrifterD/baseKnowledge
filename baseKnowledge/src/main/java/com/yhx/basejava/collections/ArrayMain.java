package com.yhx.basejava.collections;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class ArrayMain {
    static String timeConversion(String s) throws ParseException {

        String flag=s.substring(s.length()-2);
        Calendar calendar=Calendar.getInstance();
        DateFormat df=new SimpleDateFormat("HH:mm:ss");
        Date date=df.parse(s.substring(0,s.length()-2));
        calendar.setTime(date);

        if(flag.equalsIgnoreCase("pm")){
            calendar.add(Calendar.HOUR,12);

        }
        return df.format(calendar.getTime());
    }

    public static void main(String[] args)  throws Exception{
        Scanner scan = new Scanner(System.in);
        int fl=Integer.parseInt(scan.nextLine());
        double sl=Double.parseDouble(scan.nextLine());
        String tl=scan.nextLine();
//        System.out.println(i+fl);
//        System.out.println(d+sl);
//        System.out.println(s+tl);

    }


}
