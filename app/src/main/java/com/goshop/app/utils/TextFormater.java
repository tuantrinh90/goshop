package com.goshop.app.utils;

public class TextFormater {

    private static String BILLING_CODE = "(%s):";

    public static String formatBillingCode(String code) {
        return String.format(BILLING_CODE, code);
    }

}
