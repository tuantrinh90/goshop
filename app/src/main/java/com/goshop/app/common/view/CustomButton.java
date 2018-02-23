package com.goshop.app.common.view;

import com.goshop.app.common.Typefaces;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;



public class CustomButton extends android.support.v7.widget.AppCompatButton {

    public CustomButton(Context context) {
        super(context);
        setFont(context);
    }

    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFont(context);
    }

    public CustomButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFont(context);
    }

    private void setFont(Context context) {
        //TODO if have font file open this method
        /*TextPaint paint = getPaint();
        paint.setFakeBoldText(true);
        Typeface face = Typefaces.get(context, Typefaces.PATH_FONT_CUSTOM_TEXT);
        setTypeface(face);*/
        setTypeface(Typeface.SANS_SERIF, Typeface.NORMAL);
    }
}
