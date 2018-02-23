package com.goshop.app.utils;

import android.support.v7.widget.RecyclerView;

public class RecyclerUtils {

    private boolean mShouldScroll;

    private int mToPosition;

    public static void smoothMoveToPosition(RecyclerView mRecyclerView, final int position) {
        int firstItem = mRecyclerView.getChildLayoutPosition(mRecyclerView.getChildAt(0));
        int lastItem = mRecyclerView
            .getChildLayoutPosition(mRecyclerView.getChildAt(mRecyclerView.getChildCount() - 1));

        if (position < firstItem) {
            mRecyclerView.smoothScrollToPosition(position);
        } else if (position <= lastItem) {
            int movePosition = position - firstItem;
            if (movePosition >= 0 && movePosition < mRecyclerView.getChildCount()) {
                int top = mRecyclerView.getChildAt(movePosition).getTop();
                mRecyclerView.smoothScrollBy(0, top);
            }
        } else {
            mRecyclerView.smoothScrollToPosition(position);
        }
    }
}
