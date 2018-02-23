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