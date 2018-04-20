package com.goshop.app.utils;

public class NumberFormater {

    private static final String MONEY_SUFFIX = ".00";

    private static final String MONEY_SYMBOL = "RM ";

    private static final String ORDER_NO = "Order No. ";

    private static final String SYMBOL_MINUS = "- ";

    private static final String SYMBOL_PLUS = "+ ";

    private static final String LEFT_BRACKETS = "(\t";

    private static final String RIGHT_BRACKETS = "\t)";

    private static final String TEL_HEADER = "T: ";

    private static final String ANSWER_COUNTS_FORMAT = "All %s Answers";

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

    public static String formaterBrackets(String discount) {
        StringBuilder result = new StringBuilder(LEFT_BRACKETS);
        result.append(discount).append(RIGHT_BRACKETS);
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
