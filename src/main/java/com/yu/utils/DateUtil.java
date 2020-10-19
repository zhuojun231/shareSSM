package com.yu.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @ClassName DateUtil
 * @Description TODO
 * @Author yuzhuojun
 * Date 2020/9/21 13:00
 */
public class DateUtil {
    //日期转字符串
    public static String dateToString(Date date,String patt){
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        String format = sdf.format(date);
        return format;
    }

    public static Date StringToDate(String str,String patt) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        Date parse = sdf.parse(str);
        return parse;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        System.out.println(rand.nextInt(100));
    }
}
