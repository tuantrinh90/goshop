package com.goshop.app.common;

import com.goshop.app.utils.ScreenHelper;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RadioGroup;

public class CustomDynamicRadioGroup extends RadioGroup {

    private static final int margin = 16;

    private static final int size = 28;

    private int childSize;

    private int number30 = 0;

    private int widthMargin;

    public CustomDynamicRadioGroup(Context context) {
        super(context);
    }

    public CustomDynamicRadioGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        widthMargin = ScreenHelper.getPxFromDp(context, margin);
        childSize = ScreenHelper.getPxFromDp(context, size);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int maxWidth = MeasureSpec.getSize(widthMeasureSpec);
        int childCount = getChildCount();
        int x = 0;
        int y = number30;
        int row = 0;
        for (int index = 0; index < childCount; index++) {
            final View child = getChildAt(index);
            if (child.getVisibility() != View.GONE) {
                child.measure(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED);
                //TODO this need to decide
                int width = childSize;//child.getMeasuredWidth();
                int height = childSize;//child.getMeasuredHeight();
                x += (width + widthMargin);
                y = row * (height + widthMargin) + (height + widthMargin);
                if (x > maxWidth) {
                    if (index != 0)
                        row++;
                    if (width >= maxWidth) {
                        width = maxWidth - number30;
                    }
                    x = (width + widthMargin);
                    y = row * (height + widthMargin) + (height + widthMargin);
                }
            }
        }
        setMeasuredDimension(maxWidth, y);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        final int childCount = getChildCount();
        int maxWidth = r - l;
        int x = 0;
        int y;
        int row = 0;
        for (int i = 0; i < childCount; i++) {
            final View child = this.getChildAt(i);
            if (child.getVisibility() != View.GONE) {
                //TODO this need to decide
                int width = childSize;//child.getMeasuredWidth();
                int height = childSize;//child.getMeasuredHeight();
                x += (width + widthMargin);
                y = row * (height + widthMargin) + (height + widthMargin);
                if (x > maxWidth) {
                    if (i != 0)
                        row++;
                    if (width >= maxWidth) {
                        width = maxWidth - number30;
                    }
                    x = (width + widthMargin);
                    y = row * (height + widthMargin) + (height + widthMargin);
                }
                child.layout(x - width, y - height, x, y);
            }
        }
    }
}
