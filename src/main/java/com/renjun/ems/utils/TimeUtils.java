package com.renjun.ems.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {
    //获取当前日期
    public static String getCurrentTime(){
        Date date = new Date();
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return sdf.format(date);
    }
}
