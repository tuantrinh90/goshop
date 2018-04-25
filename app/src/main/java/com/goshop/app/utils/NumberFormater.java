package com.goshop.app.utils;

public class NumberFormater {

    private static final String MONEY_SUFFIX = ".00";

    private static final String MONEY_SYMBOL = "RM\t";

    private static final String ORDER_NO = "Order No.\t";

    private static final String SYMBOL_MINUS = "-\t";

    private static final String SYMBOL_PLUS = "+\t";

    private static final String LEFT_BRACKETS = "(\t";

    private static final String RIGHT_BRACKETS = "\t)";

    private static final String TEL_HEADER = "T:\t";

    private static final String ORDER_NUMBER = "#\t";

    private static final String ANSWER_COUNTS_FORMAT = "All %s Answers";

    private static final String SYMBOL_QTY = "x\t";

    public static String formaterPhoneNumber(String phoneNumber) {
        return phoneNumber.replaceFirst("(\\d{4})(\\d{2})(\\d{4})", "$1 - $2 - $3");
    }

    public static String formaterMoney(String money) {
        return MONEY_SYMBOL + money + MONEY_SUFFIX;
    }

    public static String formaterPrice(String money) {
        StringBuilder price = new StringBuilder(MONEY_SYMBOL);
        price.append(money);
        return price.toString();
    }

    public static String formaterDiscountPrice(String money) {
        StringBuilder price = new StringBuilder(SYMBOL_MINUS);
        price.append(MONEY_SYMBOL).append(money);
        return price.toString();
    }

    public static String formaterBrackets(String discount) {
        StringBuilder result = new StringBuilder(LEFT_BRACKETS);
        result.append(discount).append(RIGHT_BRACKETS);
        return result.toString();
    }

    public static String formaterOrderNumber(String orderNumber) {
        StringBuilder result = new StringBuilder(ORDER_NUMBER);
        result.append(orderNumber);
        return result.toString();
    }

    public static String formaterOrderQty(String qty) {
        StringBuilder result = new StringBuilder(SYMBOL_QTY);
        result.append(qty);
        return result.toString();
    }

    public static String formaterMoneyNoRM(String money) {
        return money + MONEY_SUFFIX;
    }

    public static String formaterTelNo(String tel) {
        return TEL_HEADER + tel;
    }

    public static String formaterPointOrderNo(String orderNo) {
        return ORDER_NO + orderNo;
    }

    public static String formaterPoints(int points, int type) {
        return type == 1 ? SYMBOL_PLUS + points : SYMBOL_MINUS + points;
    }

    public static String formaterAnswersCounts(String count) {
        return String.format(ANSWER_COUNTS_FORMAT, count);
    }

}
