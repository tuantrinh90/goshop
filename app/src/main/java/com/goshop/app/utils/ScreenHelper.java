package com.goshop.app.utils;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Message;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class ScreenHelper {

    public static int getPxFromDp(Context context, int dp) {
        return (int) TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dp,
            context.getResources().getDisplayMetrics()
        );
    }

    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    public static String getDensity(Context paramContext) {
        int i = paramContext.getResources().getDisplayMetrics().densityDpi;
        if (i <= 160) {
            return "mdpi";
        }
        if (i >= 320) {
            return "xhdpi";
        }
        return "hdpi";
    }

    public static int getWidth(Context paramContext) {
        return getMeasures(paramContext).arg1;
    }

    public static Message getMeasures(Context paramContext) {
        Display display = ((WindowManager) paramContext.getSystemService(Context.WINDOW_SERVICE))
            .getDefaultDisplay();
        Point localPoint = new Point();
        int j;
        int i;
        if (Build.VERSION.SDK_INT >= 13) {
            display.getSize(localPoint);
            j = localPoint.x;
            i = localPoint.y;
        } else {
            j = display.getWidth();
            i = display.getHeight();
        }
        Message message = new Message();
        message.arg1 = j;
        message.arg2 = i;
        return message;
    }

    public static int getWidth(Activity paramContext) {
        return getMeasures(paramContext).arg1;
    }

    public static Message getMeasures(Activity paramContext) {
        Display display = ((WindowManager) paramContext.getSystemService(Context.WINDOW_SERVICE))
            .getDefaultDisplay();
        Point localPoint = new Point();
        int j;
        int i;
        if (Build.VERSION.SDK_INT >= 13) {
            display.getSize(localPoint);
            j = localPoint.x;
            i = localPoint.y;
        } else {
            DisplayMetrics dm = new DisplayMetrics();
            paramContext.getWindowManager().getDefaultDisplay().getMetrics(dm);
            j = dm.widthPixels;
            i = dm.heightPixels;
        }
        Message message = new Message();
        message.arg1 = j;
        message.arg2 = i;
        return message;
    }

    public static int getColor(int id) {
        return ContextCompat.getColor(GoShopApplication.getAppContext(), id);
    }

    public static String getString(int id) {
        return GoShopApplication.getAppContext().getResources().getString(id);
    }

    public static int getStatusBarHeight() {
        int result = 0;
        int resourceId = GoShopApplication.getAppContext().getResources()
            .getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = GoShopApplication.getAppContext().getResources()
                .getDimensionPixelSize(resourceId);
        }
        return result;
    }

    public static int getHeight(Activity paramContext) {
        return getMeasures(paramContext).arg2;
    }

    public static int getHeight(Context paramContext) {
        return getMeasures(paramContext).arg2;
    }

    public static Drawable getThemeIconSelector(int drawableId){
        Drawable drawable=ContextCompat.getDrawable(GoShopApplication.getAppContext(), drawableId);
        int pressColor= ContextCompat.getColor(GoShopApplication.getAppContext(), R.color.colorAccent);
        int defaultColor = ContextCompat.getColor(GoShopApplication.getAppContext(), R.color.blackTrans54);
        int[] colors = new int[] {pressColor, defaultColor,defaultColor};
        int[][] states = new int[3][];
        states[0] = new int[] { android.R.attr.state_enabled, android.R.attr.state_selected };
        states[1] = new int[] { android.R.attr.state_enabled };
        states[2] = new int[] {};
        ColorStateList colorList = new ColorStateList(states, colors);
        final Drawable wrappedDrawable = DrawableCompat.wrap(drawable);
        DrawableCompat.setTintList(wrappedDrawable, colorList);
        return wrappedDrawable;
    }


    /**
     * set common btn normal and press style
     */
    public static  void setSoildButtonColorStyle(View view,int defColor,int pressColor){
        StateListDrawable drawable=new StateListDrawable();
        GradientDrawable normal= new GradientDrawable();
        normal.setColor(ContextCompat.getColor(GoShopApplication.getAppContext(),defColor));
        normal.setCornerRadius(dip2px(GoShopApplication.getAppContext(),2));
        GradientDrawable  pressed= new GradientDrawable();
        pressed.setCornerRadius(dip2px(GoShopApplication.getAppContext(),2));
        pressed.setColor(ContextCompat.getColor(GoShopApplication.getAppContext(),pressColor));
        drawable.addState(new int[]{android.R.attr.state_pressed,android.R.attr.state_enabled},pressed);
        drawable.addState(new int[]{android.R.attr.state_enabled},normal);
        drawable.addState(new int[]{},normal);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
        if (view instanceof TextView ){
            ((TextView)view).setTextColor(ContextCompat.getColor(GoShopApplication.getAppContext(),R.color.white));
        }else if (view instanceof Button){
            ((Button)view).setTextColor(ContextCompat.getColor(GoShopApplication.getAppContext(),R.color.white));
        }
    }


}
