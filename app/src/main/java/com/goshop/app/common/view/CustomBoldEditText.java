package com.goshop.app.common.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import com.goshop.app.common.Typefaces;


@SuppressWarnings("ALL")
public class CustomBoldEditText extends android.support.v7.widget.AppCompatEditText {

    public CustomBoldEditText(Context context) {
        super(context);
        setFont(context);
    }

    public CustomBoldEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFont(context);
    }

    public CustomBoldEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFont(context);
    }


    private void setFont(Context context) {
        Typeface face = Typefaces.get(context, Typefaces.PATH_FONT_CUSTOM_BOLD);
        setTypeface(face);
    }
}
