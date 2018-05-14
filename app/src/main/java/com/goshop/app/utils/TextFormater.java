package com.goshop.app.utils;

import android.text.TextUtils;

public class TextFormater {

    private static String BILLING_CODE = "(%s):";

    private static String COMMA = ", ";

    private static String UPDATED_AT = "Updated at ";

    private static String SPACE = " ";

    private static String COLON = ":";

    public static String formatBillingCode(String code) {
        if (TextUtils.isEmpty(code)) {
            return COLON;
        }
        return String.format(BILLING_CODE, code);
    }

    public static String formatCityStateCode(String city, String state, String postcode) {
        StringBuilder result = new StringBuilder();
        result.append(city).append(COMMA).append(state).append(COMMA).append(postcode);
        return result.toString();
    }

    public static String formatUpdateDate(String date) {
        StringBuilder result = new StringBuilder();
        result.append(UPDATED_AT).append(date);
        return result.toString();
    }

    public static String formatFirstLastName(String firstName, String lastName) {
        StringBuilder result = new StringBuilder();
        result.append(firstName).append(SPACE).append(lastName);
        return result.toString();
    }

}
