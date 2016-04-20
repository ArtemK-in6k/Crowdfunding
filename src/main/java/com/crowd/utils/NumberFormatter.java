package com.crowd.utils;


import java.text.DecimalFormat;

public class NumberFormatter {
    public static double format(double value){
        DecimalFormat df = new DecimalFormat("#,##");
        return Double.valueOf(df.format(value));
    }
}
