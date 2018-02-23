package com.goshop.app.common.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class CustomRadioButton extends android.support.v7.widget.AppCompatRadioButton {

    public CustomRadioButton(Context context) {
        super(context);
        setFont(context);
    }

    private void setFont(Context context) {
        setTypeface(Typeface.SANS_SERIF, Typeface.NORMAL);
    }

    public CustomRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFont(context);
    }

    public CustomRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFont(context);
    }
}
