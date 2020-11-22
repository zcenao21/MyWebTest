package com.will.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {
    public static String timeStamp2Date(Long timeStamp, String format){
        Date date=new Date(timeStamp);
        DateFormat df=new SimpleDateFormat(format);
        return df.format(date);
    }

    public static void main(String[] args) {
        System.out.println(TimeUtils.timeStamp2Date(System.currentTimeMillis(),"yyyy-MM-dd HH:mm:ss"));
    }
}
