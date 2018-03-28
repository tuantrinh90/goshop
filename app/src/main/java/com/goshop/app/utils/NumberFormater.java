package com.goshop.app.utils;

public class NumberFormater {

    private static final String MONEY_SUFFIX = ".00";

    private static final String MONEY_SYMBOL = "RM ";

    public static String formaterPhoneNumber(String phoneNumber) {
        return phoneNumber.replaceFirst("(\\d{4})(\\d{2})(\\d{4})", "$1 - $2 - $3");
    }

    public static String formaterMoney(String money) {
        return MONEY_SYMBOL + money + MONEY_SUFFIX;
    }

    public static String formaterMoneyNoRM(String money) {
        return money + MONEY_SUFFIX;
    }

}
