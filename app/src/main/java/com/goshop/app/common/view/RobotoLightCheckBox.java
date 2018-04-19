package com.goshop.app.common.view;

import com.goshop.app.common.Typefaces;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class RobotoLightCheckBox extends android.support.v7.widget.AppCompatCheckBox {

    public RobotoLightCheckBox(Context context) {
        super(context);
        setFont(context);
    }

    private void setFont(Context context) {
        Typeface face = Typefaces.get(context, Typefaces.PATH_FONT_ROBOTO_LIGHT);
        setTypeface(face);
    }

    public RobotoLightCheckBox(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFont(context);
    }

    public RobotoLightCheckBox(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFont(context);
    }
}
