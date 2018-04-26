package com.goshop.app.utils;

public class TextFormater {

    private static String BILLING_CODE = "(%s):";
    private static String COMMA = ", ";

    public static String formatBillingCode(String code) {
        return String.format(BILLING_CODE, code);
    }

    public static String formatCityStateCode(String city, String state, String postcode){
        StringBuilder result = new StringBuilder();
        result.append(city).append(COMMA).append(state).append(COMMA).append(postcode);
        return result.toString();
    }

}
