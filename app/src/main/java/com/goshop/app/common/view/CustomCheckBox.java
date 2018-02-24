package com.goshop.app.common.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

//todo this class may use later please keep it
public class CustomCheckBox extends android.support.v7.widget.AppCompatCheckBox {

    public CustomCheckBox(Context context) {
        super(context);
        setFont(context);
    }

    private void setFont(Context context) {
        setTypeface(Typeface.SANS_SERIF, Typeface.NORMAL);
    }

    public CustomCheckBox(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFont(context);
    }

    public CustomCheckBox(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFont(context);
    }
}
