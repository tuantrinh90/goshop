package com.goshop.app.common.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

@SuppressWarnings("ALL")
public class CustomBoldItaticTextView extends android.support.v7.widget.AppCompatTextView {

    public CustomBoldItaticTextView(Context context) {
        super(context);
        setFont(context);
    }

    private void setFont(Context context) {
        //TODO if have font file open this method
        /*Typeface face = Typefaces.get(context, Typefaces.PATH_FONT_CUSTOM_TEXT);
        setTypeface(face);*/
        setTypeface(Typeface.SANS_SERIF, Typeface.BOLD_ITALIC);
    }

    public CustomBoldItaticTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFont(context);
    }

    public CustomBoldItaticTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFont(context);
    }
}
