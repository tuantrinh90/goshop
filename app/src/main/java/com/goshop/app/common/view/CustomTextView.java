package com.goshop.app.common.view;

import com.goshop.app.common.Typefaces;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

/**
 * Created by winniseptiani on 3/16/17.
 */

@SuppressWarnings("ALL")
public class CustomTextView extends android.support.v7.widget.AppCompatTextView {

    public CustomTextView(Context context) {
        super(context);
//TODO if have font file open this method
//        setFont(context);
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
//TODO if have font file open this method
//        setFont(context);
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
//TODO if have font file open this method
//        setFont(context);
    }

    private void setFont(Context context) {
        Typeface face = Typefaces.get(context, Typefaces.PATH_FONT_CUSTOM_TEXT);
        setTypeface(face);
    }
}
