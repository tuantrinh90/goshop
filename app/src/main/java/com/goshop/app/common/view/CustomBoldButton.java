package com.goshop.app.common.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import com.goshop.app.common.Typefaces;


/**
 * Created by winniseptiani on 3/16/17.
 */

@SuppressWarnings("ALL")
public class CustomBoldButton extends android.support.v7.widget.AppCompatButton {

    public CustomBoldButton(Context context) {
        super(context);
        setFont(context);
    }

    public CustomBoldButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFont(context);
    }

    public CustomBoldButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFont(context);
    }

    private void setFont(Context context) {
        Typeface face = Typefaces.get(context, Typefaces.PATH_FONT_CUSTOM_BOLD);
        setTypeface(face);
    }
}
