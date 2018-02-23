package com.goshop.app.common.view;

import com.goshop.app.common.Typefaces;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

public class CustomBoldIconButton extends android.support.v7.widget.AppCompatButton {

    private Rect bounds;

    private DrawablePositions drawablePosition;

    private int drawableWidth;

    private int iconPadding;

    public CustomBoldIconButton(Context context) {
        super(context);
        setFont(context);
        bounds = new Rect();
    }

    private void setFont(Context context) {
        Typeface face = Typefaces.get(context, Typefaces.PATH_FONT_CUSTOM_BOLD);
        setTypeface(face);
    }

    public CustomBoldIconButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFont(context);
        bounds = new Rect();
        applyAttributes(attrs);
    }

    private void applyAttributes(AttributeSet attrs) {
        // Slight contortion to prevent allocating in onLayout
        if (null == bounds) {
            bounds = new Rect();
        }
    }

    public CustomBoldIconButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFont(context);
        bounds = new Rect();
        applyAttributes(attrs);
    }

    private void setIconPadding(int padding) {
        iconPadding = padding;
        requestLayout();
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

        Paint textPaint = getPaint();
        String text = getText().toString();
        textPaint.getTextBounds(text, 0, text.length(), bounds);

        int textWidth = bounds.width();
        int factor = (drawablePosition == DrawablePositions.LEFT_AND_RIGHT) ? 2 : 1;
        int contentWidth = drawableWidth + iconPadding * factor + textWidth;
        int horizontalPadding = (int) ((getWidth() / 2.0) - (contentWidth / 2.0));

        setCompoundDrawablePadding(-horizontalPadding + iconPadding);

        switch (drawablePosition) {
            case LEFT:
                setPadding(horizontalPadding, getPaddingTop(), 0, getPaddingBottom());
                break;

            case RIGHT:
                setPadding(0, getPaddingTop(), horizontalPadding, getPaddingBottom());
                break;

            case LEFT_AND_RIGHT:
                setPadding(horizontalPadding, getPaddingTop(), horizontalPadding,
                    getPaddingBottom());
                break;

            default:
                setPadding(0, getPaddingTop(), 0, getPaddingBottom());
        }
    }

    @Override
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable left, Drawable top, Drawable right,
        Drawable bottom) {
        super.setCompoundDrawablesWithIntrinsicBounds(left, top, right, bottom);

        if (left != null && right != null) {
            drawableWidth = left.getIntrinsicWidth() + right.getIntrinsicWidth();
            drawablePosition = DrawablePositions.LEFT_AND_RIGHT;
        } else if (left != null) {
            drawableWidth = left.getIntrinsicWidth();
            drawablePosition = DrawablePositions.LEFT;
        } else if (right != null) {
            drawableWidth = right.getIntrinsicWidth();
            drawablePosition = DrawablePositions.RIGHT;
        } else {
            drawablePosition = DrawablePositions.NONE;
        }

        requestLayout();
    }

    private enum DrawablePositions {
        NONE,
        LEFT_AND_RIGHT,
        LEFT,
        RIGHT
    }
}
