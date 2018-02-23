package com.goshop.app.utils;

import com.goshop.app.GoShopApplication;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;

public class ViewUtils {

    public static void setBg(View view, int drawableRes) {
        Drawable drawable = GoShopApplication.getAppContext().getResources()
            .getDrawable(drawableRes);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

}
