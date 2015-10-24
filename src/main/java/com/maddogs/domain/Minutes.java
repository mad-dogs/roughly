package com.maddogs.domain;

public class Minutes {

    public static int HOUR = 60;
    public static int DAY = HOUR * 24;
    public static int WEEK = DAY * 7;

    public static int hours(int hours){
        return HOUR * hours;
    }

    public static int days(int days){
        return DAY * days;
    }

    public static int weeks(int weeks){
        return WEEK * weeks;
    }
}
