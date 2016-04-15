package com.crowd.utils;


import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static String getFormattedDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd", DateFormatSymbols.getInstance());
        return dateFormat.format(date);
    }
}
