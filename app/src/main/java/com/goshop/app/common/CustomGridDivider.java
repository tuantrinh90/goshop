package com.goshop.app.common;

import com.goshop.app.R;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class CustomGridDivider extends RecyclerView.ItemDecoration {

    private final Drawable mDivider;

    private Context context;

    public CustomGridDivider(Context context) {
        this.context = context;
        mDivider = context.getResources().getDrawable(R.drawable.drawable_dividing_grey);
    }

    @Override
    public void onDraw(Canvas canvas, RecyclerView parent, RecyclerView.State state) {
        int mChildCount = parent.getChildCount();
        for (int i = 0; i < mChildCount; i++) {
            View mChildView = parent.getChildAt(i);
            RecyclerView.LayoutParams mLayoutParams = (RecyclerView.LayoutParams) mChildView
                .getLayoutParams();
            int left = mChildView.getLeft() - mLayoutParams.leftMargin;
            int right = mChildView.getRight() + mDivider.getIntrinsicWidth() + mLayoutParams
                .rightMargin;
            int top = mChildView.getBottom() + mLayoutParams.bottomMargin;
            int bottom = top + mDivider.getIntrinsicHeight();
            if (mChildCount % 2 == 0 && (i == mChildCount - 1 || i == mChildCount - 2)) {
                bottom = 0;
            } else {
                if (i == mChildCount - 1) {
                    bottom = 0;
                }
            }
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(canvas);
        }

        for (int i = 0; i < mChildCount; i++) {
            View mChildView = parent.getChildAt(i);
            RecyclerView.LayoutParams mLayoutParams = (RecyclerView.LayoutParams) mChildView
                .getLayoutParams();
            int left = mChildView.getRight() + mLayoutParams.rightMargin;
            int right = left + mDivider.getIntrinsicWidth();
            int top = mChildView.getTop() - mLayoutParams.topMargin;
            int bottom = mChildView.getBottom() + mLayoutParams.bottomMargin;

            if (i % 2 == 0) {
                mDivider.setBounds(left, top, right, bottom);
            } else {
                mDivider.setBounds(left, top, 0, bottom);
            }

            mDivider.draw(canvas);
        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State
        state) {
        int bottom = mDivider.getIntrinsicHeight();
        int right = mDivider.getIntrinsicWidth();
        if (isLastCol(view, parent)) {
            right = 0;
        }
        if (isLastRow(view, parent)) {
            bottom = 0;
        }

        outRect.bottom = bottom;
        outRect.right = right;
    }

    private boolean isLastCol(View view, RecyclerView parent) {
        int currentPosition = ((RecyclerView.LayoutParams) view.getLayoutParams())
            .getViewLayoutPosition();
        int mSpanCount = getSpanCount(parent);
        return (currentPosition + 1) % mSpanCount == 0;
    }

    private boolean isLastRow(View view, RecyclerView parent) {
        int currentPosition = ((RecyclerView.LayoutParams) view.getLayoutParams())
            .getViewLayoutPosition();
        int mSpanCount = getSpanCount(parent);
        int rowNum = parent.getAdapter().getItemCount() / mSpanCount == 0 ? parent.getAdapter()
            .getItemCount() / mSpanCount : (parent.getAdapter().getItemCount() / mSpanCount +
            1);
        return (currentPosition + 1) > (rowNum - 1) * mSpanCount;
    }

    private int getSpanCount(RecyclerView parent) {
        RecyclerView.LayoutManager mLayoutManager = parent.getLayoutManager();
        if (mLayoutManager instanceof GridLayoutManager) {
            GridLayoutManager mGridLayoutManager = (GridLayoutManager) mLayoutManager;
            return mGridLayoutManager.getSpanCount();
        }
        return 1;
    }

}
