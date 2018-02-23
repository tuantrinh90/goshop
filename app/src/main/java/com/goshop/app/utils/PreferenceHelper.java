package com.goshop.app.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

@SuppressWarnings("ALL")
public class PreferenceHelper {

    public static final String FIRST_TIME_TRANSFER_LIST = "first_time_transfer_list";

    public static void putBoolean(Context context, String key, boolean value) {
        getEditor(context).putBoolean(key, value).commit();
    }

    public static SharedPreferences.Editor getEditor(Context context) {
        return getPreferences(context).edit();
    }

    public static SharedPreferences getPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static boolean getBoolean(Context context, String key, boolean defValue) {
        return getPreferences(context).getBoolean(key, defValue);
    }
}
