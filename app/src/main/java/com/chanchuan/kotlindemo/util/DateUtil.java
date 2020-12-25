package com.chanchuan.kotlindemo.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Administrator
 */
public class DateUtil {
    public static String transformTimestamp(long data) {
        String sd = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        sd = sdf.format(new Date(data));
        return sd;
    }

    public static String timestampToString(String timestamp) {
        if (timestamp == null || timestamp.equals("null") || timestamp.isEmpty()) {
            return "";
        }
        String format = "yyyy-MM-dd HH:mm:ss";

        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            return sdf.format(new Date(new Long(timestamp + "000")));
        } catch (Exception e) {
            return "";
        }
    }

    public static int compare_date(String DATE1, String DATE2) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dt1 = df.parse(DATE1);
            Date dt2 = df.parse(DATE2);
            int date = (int) ((dt1.getTime() - dt2.getTime()) / (24 * 3600 * 1000));

            return date;

        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }

    public static long transformDate(String data) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = simpleDateFormat.parse(data);
        } catch (ParseException pE) {
            pE.printStackTrace();
        }
        long ts = date.getTime();
        long time = ts / 1000;
        return time;
    }


    /**
     * 将毫秒转化为 分钟：秒 的格式
     *
     * @param millisecond 毫秒
     * @return
     */
    public static String formatTime(long millisecond) {
        int minute;//分钟
        int second;//秒数
        minute = (int) ((millisecond / 1000) / 60);
        second = (int) ((millisecond / 1000) % 60);
        if (minute < 10) {
            if (second < 10) {
                return "0" + minute + ":" + "0" + second;
            } else {
                return "0" + minute + ":" + second;
            }
        } else {
            if (second < 10) {
                return minute + ":" + "0" + second;
            } else {
                return minute + ":" + second;
            }
        }
    }
}
