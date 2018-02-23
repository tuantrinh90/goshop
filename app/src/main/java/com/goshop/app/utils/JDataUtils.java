package com.goshop.app.utils;

import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JDataUtils {

    public static boolean isEmail(String email) {
        if (TextUtils.isEmpty(email)) {
            return false;
        }
        Pattern p = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
        Matcher m = p.matcher(email);
        return m.find();
    }
}
