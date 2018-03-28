package com.goshop.app.common.view;

import com.goshop.app.common.Typefaces;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class RobotoRegularRadioButton extends android.support.v7.widget.AppCompatRadioButton {

    public RobotoRegularRadioButton(Context context) {
        super(context);
        setFont(context);
    }

    private void setFont(Context context) {
        Typeface face = Typefaces.get(context, Typefaces.PATH_FONT_ROBOTO_REGULAR);
        setTypeface(face);
    }

    public RobotoRegularRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFont(context);
    }

    public RobotoRegularRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFont(context);
    }
}
