package com.goshop.app.utils;

/**
 * Created by helen on 2018/1/30.
 */

public class NumberFormater {

    public static String formaterPhoneNumber(String phoneNumber) {
        return phoneNumber.replaceFirst("(\\d{4})(\\d{2})(\\d{4})", "$1 - $2 - $3");
    }

}
