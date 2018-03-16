package com.goshop.app.common;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;

import java.util.Hashtable;

public class Typefaces {

    //TODO
    public static final String PATH_FONT_CUSTOM_BOLD = "";

    public static final String PATH_FONT_CUSTOM_TEXT = "";

    private static final String TAG = "Typefaces";

    public static final String PATH_FONT_ROBOTO_BOLD = "fonts/Roboto-Bold.ttf";

    public static final String PATH_FONT_ROBOTO_BOLD_ITALIC = "fonts/Roboto-BoldItalic.ttf";

    public static final String PATH_FONT_ROBOTO_ITALIC = "fonts/Roboto-Italic.ttf";

    public static final String PATH_FONT_ROBOTO_LIGHT = "fonts/Roboto-Light.ttf";

    public static final String PATH_FONT_ROBOTO_LIGHT_ITALIC = "fonts/Roboto-LightItalic.ttf";

    public static final String PATH_FONT_ROBOTO_MEDIUM = "fonts/Roboto-Medium.ttf";

    public static final String PATH_FONT_ROBOTO_MEDIUM_ITALIC = "fonts/Roboto-MediumItalic.ttf";

    public static final String PATH_FONT_ROBOTO_REGULAR = "fonts/Roboto-Regular.ttf";

    private static final Hashtable<String, Typeface> cache = new Hashtable<>();

    public static Typeface get(Context c, String assetPath) {
        synchronized (cache) {
            if (!cache.containsKey(assetPath)) {
                try {
                    Typeface t = Typeface.createFromAsset(c.getAssets(),
                        assetPath);
                    cache.put(assetPath, t);
                } catch (Exception e) {
                    Log.e(TAG, "Could not get typeface '" + assetPath
                        + "' because " + e.getMessage());
                    return null;
                }
            }
            return cache.get(assetPath);
        }
    }
}