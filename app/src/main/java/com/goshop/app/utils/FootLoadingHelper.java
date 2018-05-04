package com.goshop.app.utils;

import com.goshop.app.widget.adapter.BaseFootLoadingAdapter;
import com.goshop.app.widget.listener.FootLoadingListener;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class FootLoadingHelper {

    public static void addLoadingListener(RecyclerView recyclerView,
        final LinearLayoutManager linearLayoutManager, final BaseFootLoadingAdapter adapter,
        final FootLoadingListener footLoadingListener) {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                int childCount = recyclerView.getChildCount();
                View lastChildView = recyclerView.getChildAt(childCount - 1);
                View firstChildView = recyclerView.getChildAt(0);
                int top = firstChildView.getTop();
                int bottom = lastChildView.getBottom();
                int bottomEdge = recyclerView.getHeight() - recyclerView.getPaddingBottom();
                int topEdge = recyclerView.getPaddingTop();
                if (bottom <= bottomEdge && top < topEdge) {
                    adapter.setShowFoot(true);
                } else {
                    adapter.setShowFoot(false);
                }
                int lastItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastItemPosition + 1 ==
                    adapter.getItemCount()) {
                    if (bottom <= bottomEdge) {
                        if (adapter.isShowFoot()) {
                            footLoadingListener.loadingMore();
                        }
                    }
                }
            }

        });
    }


}
