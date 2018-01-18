package com.goshop.app.common.view;

import com.goshop.app.common.Typefaces;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;

/**
 * Created by Ray on 2018/1/15.
 */

public class CustomButton extends android.support.v7.widget.AppCompatButton {

    public CustomButton(Context context) {
        super(context);
//TODO if have font file open this method
//        setFont(context);
    }

    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
//TODO if have font file open this method
//        setFont(context);
    }

    public CustomButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
//TODO if have font file open this method
//        setFont(context);
    }

    private void setFont(Context context) {
        TextPaint paint = getPaint();
        paint.setFakeBoldText(true);
        Typeface face = Typefaces.get(context, Typefaces.PATH_FONT_CUSTOM_TEXT);
        setTypeface(face);
    }
}
