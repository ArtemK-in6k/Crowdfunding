package com.crowd.utils;


import java.util.Objects;

public class StringUtils {

    public static boolean isBlank(String string){
        return Objects.isNull(string) || (string.trim().length() == 0);
    }
}
