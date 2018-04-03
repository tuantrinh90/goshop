package com.goshop.app.utils;

public class NumberFormater {

    private static final String MONEY_SUFFIX = ".00";

    private static final String MONEY_SYMBOL = "RM ";

    private static final String ORDER_NO = "Order No. ";

    private static final String SYMBOL_MINUS = "- ";

    private static final String SYMBOL_PLUS = "+ ";

    private static final String TEL_HEADER = "T: ";

    public static String formaterPhoneNumber(String phoneNumber) {
        return phoneNumber.replaceFirst("(\\d{4})(\\d{2})(\\d{4})", "$1 - $2 - $3");
    }

    public static String formaterMoney(String money) {
        return MONEY_SYMBOL + money + MONEY_SUFFIX;
    }

    public static String formaterMoneyNoRM(String money) {
        return money + MONEY_SUFFIX;
    }

    public static String formaterTelNo(String tel) {
        return TEL_HEADER + tel;
    }

    public static String formaterPointOrderNo(int orderNo) {
        return ORDER_NO + orderNo;
    }

    public static String formaterPoints(int points, int type) {
        return type == 1 ? SYMBOL_PLUS + points : SYMBOL_MINUS + points;
    }

}
