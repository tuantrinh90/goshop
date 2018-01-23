package com.goshop.app.common;

import com.goshop.app.utils.ScreenHelper;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by helen on 2018/1/16.
 */

public class CustomDynamicRelativeLayout extends RelativeLayout {

    private static final int margin = 16;

    private static final int size_height = 30;

    private static final int size_width = 80;

    private int child_height;

    private int child_width;

    private int number30 = 0;

    private int widthMargin;

    public CustomDynamicRelativeLayout(Context context) {
        super(context);
    }

    public CustomDynamicRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        widthMargin = ScreenHelper.getPxFromDp(context, margin);
        child_width = ScreenHelper.getPxFromDp(context, size_width);
        child_height = ScreenHelper.getPxFromDp(context, size_height);
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
                //TODO(helen)this need to decide
                int width = child_width;//child.getMeasuredWidth();
                int height = child_height;//child.getMeasuredHeight();
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
        int y = 0;
        int row = 0;
        for (int i = 0; i < childCount; i++) {
            final View child = this.getChildAt(i);
            if (child.getVisibility() != View.GONE) {
                //TODO(helen)this need to decide
                int width = child_width;//child.getMeasuredWidth();
                int height = child_height;//child.getMeasuredHeight();
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
