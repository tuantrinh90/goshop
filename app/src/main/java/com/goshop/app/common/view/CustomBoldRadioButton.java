package com.goshop.app.common.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

/**
 * Created by helen on 2018/2/12.
 */

public class CustomBoldRadioButton extends android.support.v7.widget.AppCompatRadioButton{

    public CustomBoldRadioButton(Context context) {
        super(context);
        setFont(context);
    }

    public CustomBoldRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFont(context);
    }

    public CustomBoldRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFont(context);
    }

    private void setFont(Context context) {
        setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
    }
}
