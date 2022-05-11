package com.yanftch.review;



public class T {
    public static String getTime(long sec) {
        long h = sec / 3600;
        long m = sec % 3600 / 60;
        long s = sec % 60; //不足60的就是秒，够60就是分
        return unitFormat(h)+ ":" + unitFormat(m)+":"+ unitFormat(s);
    }
    public static String secToTime(int time) {
        String timeStr = null;
        int hour = 0;
        int minute = 0;
        int second = 0;
        if (time <= 0)
            return "00:00:00";
        else {
            minute = time / 60;
            if (minute < 60) {
                second = time % 60;
                timeStr = unitFormat(minute) + ":" + unitFormat(second) + "";
            } else if (time <= 3660) {
                if (minute > 60) {
                    second = time - 3600;
                    minute = 60;
                } else {
                    second = time % 60;
                    timeStr = unitFormat(minute) + ":" + unitFormat(second) + "";
                }
                timeStr = unitFormat(minute) + ":" + unitFormat(second) + "";
            } else {
                hour = minute / 60;
                if (hour > 99)
                    return "99:59:59";
                minute = minute % 60;
                second = time - hour * 3600 - minute * 60;
                timeStr = unitFormat(hour) + ":" + unitFormat(minute) + ":" + unitFormat(second);
            }
        }
        return timeStr;
    }

    public static String unitFormat(long i) {
        String retStr = null;
        if (i >= 0 && i < 10)
            retStr = "0" + i;
        else
            retStr = "" + i;
        return retStr;
    }
//
//    public static String unitFormat(long i) {
//        String retStr = null;
//        if (i >= 0L && i < 10L) {
//            retStr = "0" + Long.toString(i);
//        } else {
//            retStr = "" + i;
//        }
//
//        return retStr;
//    }
//    public static String s2Time(long time) {
//        String timeStr = null;
//        long hour = 0L;
//        long minute = 0L;
//        long second = 0L;
//        if (time <= 0L) {
//            return "00:00";
//        } else {
//            second = time / 1000L;
//            minute = second / 60L;
//            if (second < 60L) {
//                timeStr = "00:" + unitFormat(second);
//            } else if (minute < 60L) {
//                second %= 60L;
//                timeStr = unitFormat(minute) + ":" + unitFormat(second);
//            } else {
//                hour = minute / 60L;
//                minute %= 60L;
//                second = second - hour * 3600L - minute * 60L;
//                timeStr = unitFormat(hour) + ":" + unitFormat(minute) + ":" + unitFormat(second);
//            }
//
//            return timeStr;
//        }
//    }
}
