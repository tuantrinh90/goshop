package com.goshop.app.common.view;

import com.goshop.app.common.Typefaces;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

@SuppressWarnings("ALL")
public class RobotoLightItalicTextView extends android.support.v7.widget.AppCompatTextView {

    public RobotoLightItalicTextView(Context context) {
        super(context);
        setFont(context);
    }

    private void setFont(Context context) {
        Typeface face = Typefaces.get(context, Typefaces.PATH_FONT_ROBOTO_LIGHT_ITALIC);
        setTypeface(face);
    }

    public RobotoLightItalicTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFont(context);
    }

    public RobotoLightItalicTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFont(context);
    }
}
