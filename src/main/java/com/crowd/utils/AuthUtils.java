package com.crowd.utils;

public class AuthUtils {
    public static boolean isPasswordCorrect(String password) {
        return !StringUtils.isBlank(password);
    }

    public static boolean checkPasswordEquals(String password, String hashed) {
        return Cipher.encrypt(password).equals(hashed);
    }
}
