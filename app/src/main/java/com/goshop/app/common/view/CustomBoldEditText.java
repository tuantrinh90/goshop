package com.goshop.app.common.view;

import com.goshop.app.common.Typefaces;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;

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
        //TODO if have font file open this method
        /*TextPaint paint = getPaint();
        paint.setFakeBoldText(true);
        Typeface face = Typefaces.get(context, Typefaces.PATH_FONT_CUSTOM_BOLD);
        setTypeface(face);*/
        setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
    }
}
